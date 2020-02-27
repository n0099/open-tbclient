package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.dialog.UploadPhotosDialog;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.presenter.BasePublishPresenter;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.PublisherCommonUtils;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcDialogUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.view.PhotoChooseView;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.upload.provider.UploadProviderManager;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class TextImagePublishActivity extends PublishBaseActivity implements EmojiconEditText.TextNumbersChangedListener, PhotoChooseView.StartAlbumListener {
    public static final boolean DEBUG = false;
    private static final int MAX_COUNT = 9;
    private static final String TAG = TextImagePublishActivity.class.getSimpleName();
    private static final int THOUSAND_WORDS = 1000;
    private UploadPhotosDialog mDialog;
    private DraftData mDraftData;
    private String mDraftKey;
    private boolean mEditedTag;
    private List<ImageStruct> mISList;
    private PhotoChooseView mPhotoChooseView;
    private int mIndex = 0;
    private boolean mIsPhotoUploading = false;
    private boolean isDestroyed = false;

    static /* synthetic */ int access$508(TextImagePublishActivity textImagePublishActivity) {
        int i = textImagePublishActivity.mIndex;
        textImagePublishActivity.mIndex = i + 1;
        return i;
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent != null ? intent.getIntExtra("customLayoutResourceId", -1) : -1;
        if (intExtra != -1) {
            try {
                baseSetContentView(intExtra);
            } catch (Exception e) {
                if (PublisherCommonUtils.DEBUG.booleanValue()) {
                    Toast.makeText(this, "传入定制布局失败，Exception：" + e, 1).show();
                    Log.i(TAG, "传入定制布局失败，Exception：" + e);
                }
                baseSetContentView(R.layout.ugc_text_image_layout);
            }
        } else {
            baseSetContentView(R.layout.ugc_text_image_layout);
        }
        initView();
        initDraftData();
        UgcUBCUtils.ugcPvStatistics(0, "publish");
        this.mPublishPresenter.addTargetRule(this.mInput);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected BasePublishPresenter getPresenter() {
        return new BasePublishPresenter(this);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SelectUtil.tryRemoveNoExistsImags() && this.mPhotoChooseView != null) {
            this.mPhotoChooseView.updateUi();
        }
        if (SelectUtil.getSelectedCount() == 0) {
            setPublishBtnStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            destroy();
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        destroy();
    }

    private void destroy() {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
            SelectUtil.clear();
            UploadProviderManager.getUploadProvider().releaseUploadManager();
            if (this.mInput != null) {
                this.mInput.removeListener();
            }
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.mIsPhotoUploading || this.mInput == null) {
            return super.onKeyDown(i, keyEvent);
        }
        backDispose(this.mInput.getText().toString());
        return true;
    }

    @Override // com.baidu.searchbox.ugc.view.PhotoChooseView.StartAlbumListener
    public void goAlbumBefore() {
    }

    @Override // com.baidu.searchbox.ugc.view.PhotoChooseView.StartAlbumListener
    public void setPublishBtnStatus() {
        if (this.mInput != null && TextUtils.isEmpty(this.mInput.getText())) {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
    }

    private void initView() {
        this.mPhotoChooseView = (PhotoChooseView) findViewById(ResourceUtils.getResIdByName("ugc_pic_choose"));
        if (this.mPhotoChooseView != null) {
            this.mPhotoChooseView.init(this);
            this.mPhotoChooseView.setListener(this);
            this.mPhotoChooseView.getAdapter2().setMaxCount(9);
        }
        UiBaseUtils.setVisibility(this.mAlbumEntrance, 0);
        if (this.mPublishPresenter.mInfo != null && !TextUtils.isEmpty(this.mPublishPresenter.mInfo.placeTitle)) {
            UiBaseUtils.setTextString(this.mTitle, this.mPublishPresenter.mInfo.placeTitle);
        } else {
            UiBaseUtils.setTextStringResource(this.mTitle, R.string.ugc_publish_title);
        }
        if (this.mInput != null) {
            this.mInput.setListener(this);
        }
        if (SelectUtil.getSelectedCount() > 0) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        }
        if (!TextUtils.isEmpty(this.mPublishPresenter.mTopicName)) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        }
    }

    private void initDraftData() {
        this.mDraftKey = DraftUtils.getDraftKey(this.mPublishPresenter.mInfo);
        this.mDraftData = PublisherManagerFactory.get().getDraft(this.mDraftKey);
        if (this.mDraftData != null) {
            if (!TextUtils.isEmpty(this.mDraftData.content) && this.mInput != null) {
                this.mInput.setText(this.mDraftData.content);
                this.mInput.handleDraftEmojiDisplay();
                this.mInput.setSelection(this.mInput.length());
            }
            if (this.mDraftData.images != null && this.mDraftData.images.size() > 0) {
                SelectUtil.clear();
                for (String str : this.mDraftData.images) {
                    SelectUtil.saveSelectedImages(new ImageStruct(str));
                }
                if (this.mPhotoChooseView != null) {
                    this.mPhotoChooseView.updateUi();
                }
            }
            if (this.mDraftData.target != null) {
                this.mPublishPresenter.mTarget = (UGCTarget) new Gson().fromJson(this.mDraftData.target, (Class<Object>) UGCTarget.class);
            }
            if (this.mInput != null && this.mInput.length() <= this.mPublishPresenter.inputImgTextLimit) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
            } else {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void addChanged(int i) {
        if (i > this.mPublishPresenter.inputImgTextLimit && i < this.mPublishPresenter.inputImgTextLimit + 1000) {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - this.mPublishPresenter.inputImgTextLimit)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
        } else {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(R.string.ugc_reply_input_over_999_hint);
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
        }
        this.mPublishPresenter.setClickState(this.mPublishTv, false);
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void reduceChanged(int i) {
        if (i == 0) {
            if (SelectUtil.getSelectedCount() > 0) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
            } else {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
            }
        } else if (i <= this.mPublishPresenter.inputImgTextLimit && i > 0) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        } else {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
        if (i == 0) {
            this.mNumberTv.setVisibility(8);
        } else if (i < this.mPublishPresenter.inputImgTextLimit - 20) {
            this.mNumberTv.setVisibility(8);
        } else {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(this.mPublishPresenter.inputImgTextLimit - i)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_normal_color));
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void back() {
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onPublish(final String str) {
        if (this.mPublishPresenter.mEnableClick) {
            if (!UgcLoginUtils.isLogin()) {
                UgcLoginUtils.login(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.TextImagePublishActivity.1
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            TextImagePublishActivity.this.goPublish(str);
                        }
                    }
                }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            } else if (!UgcLoginUtils.isGuestLogin()) {
                goPublish(str);
            } else {
                UgcLoginUtils.bindPhone(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.TextImagePublishActivity.2
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            TextImagePublishActivity.this.goPublish(str);
                        }
                    }
                }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            }
            UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPublishPicBtnPage);
            UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_PUBLISH_CLICK, null, "publish");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goPublish(String str) {
        if (!TextUtils.isEmpty(str) || SelectUtil.getSelectedCount() > 0) {
            publishImages(str, SelectUtil.getSeletedImages());
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onCancel(String str) {
        UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mPublishPicBtnPage);
        backDispose(str);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onEnterAlbum() {
        Intent intent = new Intent(this, LocalAlbumActivity.class);
        this.mPublishPresenter.mInfo.from = 0;
        this.mPublishPresenter.mInfo.launchFrom = "publish";
        intent.putExtra("data", this.mPublishPresenter.mInfo);
        startActivityForResult(intent, 32769);
        overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mPhotoChooseView != null) {
            this.mPhotoChooseView.updateUi();
        }
        if (intent == null) {
            this.mEditedTag = true;
        }
        if (SelectUtil.getSelectedCount() > 0 && this.mInput != null && this.mInput.length() <= this.mPublishPresenter.inputImgTextLimit) {
            if (SelectUtil.getSelectedCount() > 0 && this.mInput.length() <= this.mPublishPresenter.inputImgTextLimit) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
            } else if (this.mInput != null && TextUtils.isEmpty(this.mInput.getText())) {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
            }
        }
    }

    private void backDispose(String str) {
        if (!this.mIsPhotoUploading) {
            if (this.mPublishPresenter.ugcVoteInfo != null) {
                finish();
            } else if ((TextUtils.isEmpty(str) || (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mPublishPresenter.mTopicName) && (str.equals(this.mPublishPresenter.mTopicName) || str.equals(this.mPublishPresenter.mTopicName + HanziToPinyin.Token.SEPARATOR + this.mPublishPresenter.mInfo.placeContent)))) && SelectUtil.getSeletedImages().size() == 0) {
                if (this.mDraftData != null) {
                    PublisherManagerFactory.get().deleteDraft(this.mDraftKey);
                }
                finish();
                UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
                UgcUBCUtils.saveDraftPublishUbcStatistics(this.mPublishPresenter.mInfo.sourceFrom, false, false, false, false);
            } else if (this.mDraftData != null && !isInputEdited(str)) {
                finish();
                UgcUBCUtils.saveDraftPublishUbcStatistics(this.mPublishPresenter.mInfo.sourceFrom, false, false, false, false);
            } else if (!TextUtils.isEmpty(str) || SelectUtil.getSeletedImages().size() != 0) {
                showSaveDraftDialog(str);
            }
        }
    }

    private void showSaveDraftDialog(String str) {
        UgcDialogUtils.showSaveDraftDialog(new DraftOnPositiveClickListener(new WeakReference(this), new SaveDraftTask(str), this.mPublishPresenter.mInfo), new DraftOnNegativeClickListener(new WeakReference(this), this.mPublishPresenter.mInfo, this.mDraftKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class DraftOnPositiveClickListener implements DialogInterface.OnClickListener {
        private SaveDraftTask mSaveDraftTask;
        private UgcSchemeModel mUgcSchemeModel;
        private WeakReference<Activity> mWeakReference;

        DraftOnPositiveClickListener(WeakReference<Activity> weakReference, SaveDraftTask saveDraftTask, UgcSchemeModel ugcSchemeModel) {
            this.mWeakReference = weakReference;
            this.mSaveDraftTask = saveDraftTask;
            this.mUgcSchemeModel = ugcSchemeModel;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            TextImagePublishActivity.this.mISList = new ArrayList(SelectUtil.getSeletedImages());
            ExecutorUtilsExt.postOnElastic(this.mSaveDraftTask, "saveToDraft", 1);
            SelectUtil.clear();
            UgcUBCUtils.saveDraftPublishUbcStatistics(this.mUgcSchemeModel.sourceFrom, false, true, true, false);
            Activity activity = this.mWeakReference.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class DraftOnNegativeClickListener implements DialogInterface.OnClickListener {
        private String mDraftKey;
        private UgcSchemeModel mUgcSchemeModel;
        private WeakReference<Activity> mWeakReference;

        DraftOnNegativeClickListener(WeakReference<Activity> weakReference, UgcSchemeModel ugcSchemeModel, String str) {
            this.mWeakReference = weakReference;
            this.mUgcSchemeModel = ugcSchemeModel;
            this.mDraftKey = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            PublisherManagerFactory.get().deleteDraft(this.mDraftKey);
            SelectUtil.clear();
            Activity activity = this.mWeakReference.get();
            if (activity != null) {
                activity.finish();
            }
            UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
            UgcUBCUtils.saveDraftPublishUbcStatistics(this.mUgcSchemeModel.sourceFrom, false, true, false, false);
        }
    }

    private boolean isInputEdited(String str) {
        boolean z = true;
        if (!TextUtils.isEmpty(str) && SelectUtil.getSeletedImages().size() == 0) {
            return this.mDraftData.images.size() > 0 || !str.equals(this.mDraftData.content);
        } else if (TextUtils.isEmpty(str) && SelectUtil.getSeletedImages().size() > 0) {
            return (TextUtils.isEmpty(this.mDraftData.content) && SelectUtil.getSeletedImages().size() == this.mDraftData.images.size() && !this.mEditedTag) ? false : true;
        } else {
            if (TextUtils.isEmpty(str) || SelectUtil.getSeletedImages().size() <= 0 || (str.equals(this.mDraftData.content) && SelectUtil.getSeletedImages().size() == this.mDraftData.images.size() && !this.mEditedTag)) {
                z = false;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class SaveDraftTask implements Runnable {
        String inputStr;

        SaveDraftTask(String str) {
            this.inputStr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String saveImageDraft;
            DraftData draftData = new DraftData();
            if (!TextUtils.isEmpty(this.inputStr)) {
                draftData.content = this.inputStr;
            }
            if (TextImagePublishActivity.this.mISList != null && TextImagePublishActivity.this.mISList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ImageStruct imageStruct : TextImagePublishActivity.this.mISList) {
                    if (!TextUtils.isEmpty(imageStruct.uriStr)) {
                        if (SelectUtil.isGif(imageStruct.uriStr)) {
                            saveImageDraft = FileUtils.saveGifDraft(TextImagePublishActivity.this, imageStruct.uriStr);
                        } else {
                            saveImageDraft = FileUtils.saveImageDraft(TextImagePublishActivity.this, imageStruct.uriStr);
                        }
                        if (!TextUtils.isEmpty(saveImageDraft)) {
                            arrayList.add(saveImageDraft);
                        }
                    }
                }
                draftData.images.addAll(arrayList);
            }
            draftData.timestamp = System.currentTimeMillis();
            draftData.target = TextImagePublishActivity.this.mPublishPresenter.getTargetJson();
            PublisherManagerFactory.get().saveDraft(TextImagePublishActivity.this.mDraftKey, draftData);
        }
    }

    private void publishImages(String str, List<ImageStruct> list) {
        if (!NetWorkUtils.isNetworkConnected(this)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
        } else if (list.size() > 0) {
            startUploadImages(str, list);
        } else {
            publish(str, null);
        }
    }

    private void startUploadImages(final String str, List<ImageStruct> list) {
        int i = 0;
        this.mIsPhotoUploading = true;
        final int size = list.size();
        this.mIndex = 0;
        final ArrayList arrayList = new ArrayList();
        this.mDialog = new UploadPhotosDialog(this);
        this.mDialog.show();
        this.mDialog.notifyProgress(this.mIndex, size);
        this.mDialog.setListener(new UploadPhotosDialog.CancalProgressListener() { // from class: com.baidu.searchbox.ugc.activity.TextImagePublishActivity.3
            @Override // com.baidu.searchbox.ugc.dialog.UploadPhotosDialog.CancalProgressListener
            public void cancel() {
                TextImagePublishActivity.this.dismissProgressDialog();
                UploadProviderManager.getUploadProvider().stopUpload();
                TextImagePublishActivity.this.mIsPhotoUploading = false;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList2.add(list.get(i2).uriStr);
                i = i2 + 1;
            } else {
                UploadProviderManager.getUploadProvider().setSTSFrom("ugc");
                UploadProviderManager.getUploadProvider().upLoadImage(arrayList2, new UploadImageListener() { // from class: com.baidu.searchbox.ugc.activity.TextImagePublishActivity.4
                    @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                    public void uploadSuccess(String str2, int i3, int i4, long j) {
                        PublishModels.ImageData imageData = new PublishModels.ImageData();
                        imageData.url = str2;
                        imageData.width = i3;
                        imageData.height = i4;
                        imageData.size = j;
                        arrayList.add(imageData);
                        TextImagePublishActivity.access$508(TextImagePublishActivity.this);
                        TextImagePublishActivity.this.mDialog.notifyProgress(TextImagePublishActivity.this.mIndex, size);
                        if (TextImagePublishActivity.this.mIndex == size) {
                            TextImagePublishActivity.this.publish(str, arrayList);
                        }
                    }

                    @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                    public void uploadFail() {
                        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                        TextImagePublishActivity.this.dismissProgressDialog();
                        TextImagePublishActivity.this.mIsPhotoUploading = false;
                    }

                    @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                    public void uploadProgress(float f) {
                        Log.i("Upload-Progress", f + "");
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish(String str, ArrayList<PublishModels.ImageData> arrayList) {
        this.mPublishPresenter.basePublish();
        this.mPublishPresenter.setClickState(this.mPublishTv, false);
        setBottomEntrUnableClick();
        JSONObject jSONObject = new JSONObject();
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        try {
            if (this.mPublishPresenter.mTarget == null) {
                this.mPublishPresenter.mTarget = new UGCTarget();
            }
            if (this.mPublishPresenter.mTopicRule != null) {
                this.mPublishPresenter.mTopicRule.obtainTopicList(this.mPublishPresenter.mTarget.mTopicList);
            }
            if (this.mPublishPresenter.mAtRule != null) {
                this.mPublishPresenter.mAtRule.obtainUserInfoList(this.mPublishPresenter.mTarget.mUserInfoList);
            }
            if (this.mPublishPresenter.mTarget.tagList != null && this.ugcTag != null) {
                this.mPublishPresenter.mTarget.tagList.add(this.ugcTag);
            }
            if (this.mPublishPresenter.mTarget != null) {
                jSONObject.putOpt("target", new JSONObject(new Gson().toJson(this.mPublishPresenter.mTarget)));
            }
            publishRequestModel.data = jSONObject;
            publishRequestModel.serverTopicsRule = this.mPublishPresenter.mServerTopicsRule;
            publishRequestModel.inputStr = str;
            publishRequestModel.postUrl = this.mPublishPresenter.mPostUrl;
            publishRequestModel.sourceFrom = this.mPublishPresenter.mSourceFrom;
            publishRequestModel.topic = this.mPublishPresenter.mTopicObject;
            publishRequestModel.locationObject = this.mPublishPresenter.mLocationObject;
            publishRequestModel.extObject = this.mPublishPresenter.mExtObject;
            publishRequestModel.imageUrlList = arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.activity.TextImagePublishActivity.5
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                TextImagePublishActivity.this.mIsPhotoUploading = false;
                TextImagePublishActivity.this.publishSuccess(publishResultInfo);
                TextImagePublishActivity.this.setBottomEntrAbleClick();
                TextImagePublishActivity.this.dismissProgressDialog();
                PublisherManagerFactory.get().deleteDraft(TextImagePublishActivity.this.mDraftKey);
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str2) {
                TextImagePublishActivity.this.mPublishPresenter.setClickState(TextImagePublishActivity.this.mPublishTv, true);
                TextImagePublishActivity.this.mIsPhotoUploading = false;
                TextImagePublishActivity.this.mPublishPresenter.publishFail(str2);
                TextImagePublishActivity.this.setBottomEntrAbleClick();
                TextImagePublishActivity.this.dismissProgressDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void publishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        this.mPublishPresenter.publishSuccess(publishResultInfo);
        finish();
        UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_PUB);
    }
}
