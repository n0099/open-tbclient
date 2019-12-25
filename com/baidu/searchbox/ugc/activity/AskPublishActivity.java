package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.skin.NightModeHelper;
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
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcDialogUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.view.PhotoChooseView;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.spswitch.b.e;
import com.google.gson.Gson;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AskPublishActivity extends PublishBaseActivity<BasePublishPresenter> implements EmojiconEditText.TextNumbersChangedListener, PhotoChooseView.StartAlbumListener {
    private static final int ASK_SOURCE_TYPE = 3;
    private static final int MAX_PIC_COUNT = 3;
    private static final int MAX_TEXT_SIZE = 500;
    private static final int MIN_TEXT_SIZE = 4;
    private static final int TITLE_MAX_TEXT_SIZE = 26;
    private static final int TITLE_SIZE_WITH_MARK = 27;
    private boolean isClickQuestionMark;
    private boolean isFocusForTitle;
    private ImageView mClearTitle;
    private UploadPhotosDialog mDialog;
    private DraftData mDraftData;
    private String mDraftKey;
    private boolean mEditedTag;
    private JSONObject mExtObject;
    private ArrayList<ImageStruct> mImageList;
    private boolean mIsPhotoUploading;
    private boolean mIsShowDes;
    private PhotoChooseView mPhotoChooseView;
    private EditText mQuestionTitle;
    private String mQuestionTitleHint;
    private String mThirdId;
    private int mIndex = 0;
    private boolean isDestroyed = false;

    static /* synthetic */ int access$1408(AskPublishActivity askPublishActivity) {
        int i = askPublishActivity.mIndex;
        askPublishActivity.mIndex = i + 1;
        return i;
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        baseSetContentView(R.layout.ugc_question_ask_layout);
        initData();
        intView();
        initDraftData();
        updateUiForNight();
        setInputCount(this.mInput.getText().toString().length());
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected BasePublishPresenter getPresenter() {
        return new BasePublishPresenter(this);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        if (this.isFocusForTitle) {
            this.mQuestionTitle.setSelection(this.mQuestionTitle.getText().length());
            e.a(this.mQuestionTitle, 300L);
        }
        super.onResume();
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
            UploadManager.getInstance().release();
            if (this.mInput != null) {
                this.mInput.removeListener();
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onPublish(String str) {
        UgcUBCUtils.askStatistics(UgcUBCUtils.UGC_TYPE_ASK_PUBLISH_CLICK);
        if (this.mQuestionTitle.getText().toString().trim().length() < 4) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_ask_question_title_size_tips).showToast();
        } else if (this.mPublishPresenter.mEnableClick) {
            if (!UgcLoginUtils.isLogin()) {
                UgcLoginUtils.login(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.1
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            AskPublishActivity.this.goPublish();
                        }
                    }
                }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            } else if (!UgcLoginUtils.isGuestLogin()) {
                goPublish();
            } else {
                UgcLoginUtils.bindPhone(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.2
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            AskPublishActivity.this.goPublish();
                        }
                    }
                }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            }
            UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPublishPicBtnPage);
            UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_PUBLISH_CLICK, null, "publish");
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onCancel(String str) {
        backDispose(this.mQuestionTitle.getText().toString(), str);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onEnterAlbum() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mPhotoChooseView.updateUi();
        if (intent == null) {
            this.mEditedTag = true;
        }
    }

    private void initData() {
        UgcSchemeModel ugcSchemeModel = this.mPublishPresenter.mInfo;
        if (ugcSchemeModel != null) {
            try {
                JSONObject jSONObject = new JSONObject(ugcSchemeModel.questionAsk);
                this.mThirdId = jSONObject.optString("third_id");
                this.mQuestionTitleHint = jSONObject.optString("title_placeholder");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(ugcSchemeModel.ext)) {
                try {
                    this.mExtObject = new JSONObject(ugcSchemeModel.ext);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(this.mThirdId)) {
                UgcUBCUtils.setExtInfo("interest_id", this.mThirdId);
            }
            UgcUBCUtils.askStatistics(UgcUBCUtils.UGC_TYPE_ASK_SHOW);
        }
    }

    private void initDraftData() {
        this.mDraftKey = DraftUtils.getDraftKey(this.mPublishPresenter.mInfo);
        this.mDraftData = DraftUtils.getDraft(this.mDraftKey);
        if (this.mDraftData != null) {
            if (!TextUtils.isEmpty(this.mDraftData.title)) {
                this.mQuestionTitle.setText(this.mDraftData.title);
                this.mQuestionTitle.setSelection(this.mQuestionTitle.getText().length());
            }
            if (!TextUtils.isEmpty(this.mDraftData.content)) {
                hideQuestionDescriptionView();
                showEditContentView();
                this.mInput.setText(this.mDraftData.content);
                this.mInput.handleDraftEmojiDisplay();
                this.mInput.setSelection(this.mInput.getText().length());
            }
            if (this.mDraftData.images != null && this.mDraftData.images.size() > 0) {
                SelectUtil.clear();
                for (String str : this.mDraftData.images) {
                    SelectUtil.saveSelectedImages(new ImageStruct(new File(str).toString()));
                }
                showEditContentView();
                hideQuestionDescriptionView();
                this.mPhotoChooseView.updateUi();
            }
            if (this.mDraftData.target != null) {
                this.mPublishPresenter.mTarget = (UGCTarget) new Gson().fromJson(this.mDraftData.target, (Class<Object>) UGCTarget.class);
            }
            if (this.mInput.length() <= 500 && this.mQuestionTitle.getText().toString().length() >= 4) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
            } else {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
            }
        }
    }

    private void intView() {
        this.mContentTopLine.setVisibility(0);
        this.mBottomLine.setVisibility(8);
        this.mInput.setMaxSize(500);
        initAskTitleView();
        initQuestionTitleView();
        initImageView();
        initBottomView();
    }

    private void initBottomView() {
        if (this.mAddDescription != null) {
            if (this.mEmoijImg != null) {
                this.mEmoijImg.setVisibility(8);
            }
            if (this.mVideoEntrance != null) {
                this.mVideoEntrance.setVisibility(8);
            }
            if (this.mAlbumEntrance != null) {
                this.mAlbumEntrance.setVisibility(8);
            }
            if (this.mTopicSelectIv != null) {
                this.mTopicSelectIv.setVisibility(8);
            }
            if (this.mAtIv != null) {
                this.mAtIv.setVisibility(8);
            }
            if (this.mPublishView != null) {
                this.mPublishView.setVisibility(8);
            }
            if (this.mEmojiTipsTv != null) {
                this.mEmojiTipsTv.setVisibility(8);
            }
            this.mAddDescription.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ugc_ask_add_question_description), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mAddDescription.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UgcUBCUtils.askStatistics(UgcUBCUtils.UGC_TYPE_ASK_DESCRP_CLICK);
                    AskPublishActivity.this.isClickQuestionMark = true;
                    AskPublishActivity.this.mIsShowDes = true;
                    AskPublishActivity.this.showEditContentView();
                    AskPublishActivity.this.mInput.setFocusable(true);
                    AskPublishActivity.this.mInput.setFocusableInTouchMode(true);
                    AskPublishActivity.this.mInput.requestFocus();
                    AskPublishActivity.this.hideQuestionDescriptionView();
                    AskPublishActivity.this.mQuestionTitle.setText(AskPublishActivity.this.addQuestionMark(AskPublishActivity.this.mQuestionTitle.getText().toString()));
                    AskPublishActivity.this.mClearTitle.setVisibility(8);
                }
            });
            this.mAddDescription.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    UgcUiUtils.setTouchAlpha(view, motionEvent);
                    return false;
                }
            });
            this.mInput.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditContentView() {
        if (!this.mInput.isShown()) {
            this.mInput.setVisibility(0);
            this.mPhotoChooseView.setVisibility(0);
            this.mInput.setListener(this);
            this.mInput.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.5
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        AskPublishActivity.this.isFocusForTitle = false;
                        AskPublishActivity.this.mClearTitle.setVisibility(8);
                    }
                }
            });
        }
    }

    private void initAskTitleView() {
        this.mTitle.setText(R.string.ugc_ask_publish_title);
    }

    private void initQuestionTitleView() {
        if (this.mAskQuestionTitleLayout != null) {
            this.mAskQuestionTitleLayout.inflate();
            this.mQuestionTitle = (EditText) findViewById(R.id.ugc_ask_question_title);
            this.mClearTitle = (ImageView) findViewById(R.id.ugc_ask_clear_question_title);
            if (!TextUtils.isEmpty(this.mQuestionTitleHint)) {
                this.mQuestionTitle.setHint(this.mQuestionTitleHint);
            } else {
                this.mQuestionTitle.setHint(R.string.ugc_ask_question_title_hint);
            }
            this.mQuestionTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.6
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return true;
                }
            });
            this.mQuestionTitle.addTextChangedListener(new TextWatcher() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.7
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    AskPublishActivity.this.mClearTitle.setVisibility(0);
                    if (charSequence.length() > 26) {
                        if ((!AskPublishActivity.this.isClickQuestionMark || !AskPublishActivity.this.mAddDescription.isShown()) && AskPublishActivity.this.isFocusForTitle) {
                            AskPublishActivity.this.showTitleToast();
                        }
                        AskPublishActivity.this.mPublishPresenter.setClickState(AskPublishActivity.this.mPublishTv, true);
                    } else if (charSequence.length() < 4) {
                        AskPublishActivity.this.mPublishPresenter.setClickState(AskPublishActivity.this.mPublishTv, false);
                    } else {
                        AskPublishActivity.this.mPublishPresenter.setClickState(AskPublishActivity.this.mPublishTv, true);
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().length() <= 26) {
                        AskPublishActivity.this.mQuestionTitle.setSelection(editable.length());
                    } else if (!editable.toString().endsWith("?") || editable.toString().length() != 27) {
                        AskPublishActivity.this.mQuestionTitle.setText(editable.toString().substring(0, 26));
                        AskPublishActivity.this.mQuestionTitle.setSelection(26);
                    } else {
                        AskPublishActivity.this.mQuestionTitle.setSelection(27);
                    }
                    if (editable.toString().length() >= 1 && !AskPublishActivity.this.mIsShowDes && !AskPublishActivity.this.mInput.isShown()) {
                        AskPublishActivity.this.showQuestionDescriptionView();
                    }
                    if (editable.toString().length() < 1 && !AskPublishActivity.this.mNumberTv.isShown()) {
                        AskPublishActivity.this.hideQuestionDescriptionView();
                        AskPublishActivity.this.mClearTitle.setVisibility(8);
                    }
                }
            });
            this.mQuestionTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AskPublishActivity.this.mQuestionTitle.setFocusable(true);
                    AskPublishActivity.this.mQuestionTitle.setFocusableInTouchMode(true);
                    AskPublishActivity.this.mQuestionTitle.requestFocus();
                }
            });
            this.mQuestionTitle.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.9
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        AskPublishActivity.this.isFocusForTitle = true;
                        if (AskPublishActivity.this.mQuestionTitle.getText().length() >= 1) {
                            AskPublishActivity.this.mClearTitle.setVisibility(0);
                        }
                        e.a(AskPublishActivity.this.mQuestionTitle, 300L);
                        return;
                    }
                    AskPublishActivity.this.isFocusForTitle = false;
                    AskPublishActivity.this.mClearTitle.setVisibility(8);
                    AskPublishActivity.this.mQuestionTitle.setText(AskPublishActivity.this.addQuestionMark(AskPublishActivity.this.mQuestionTitle.getText().toString()));
                }
            });
            this.mClearTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AskPublishActivity.this.mQuestionTitle.setText("");
                    if (!AskPublishActivity.this.mNumberTv.isShown()) {
                        AskPublishActivity.this.hideQuestionDescriptionView();
                    }
                    AskPublishActivity.this.mClearTitle.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTitleToast() {
        UniversalToast.makeText(this, R.string.ugc_ask_question_title_max_size_tips).showToast();
    }

    private void initImageView() {
        this.mPhotoChooseView = (PhotoChooseView) findViewById(R.id.ugc_pic_choose);
        this.mPhotoChooseView.setVisibility(8);
        this.mInput.setHint(R.string.ugc_ask_question_description_content);
        this.mInput.setVisibility(8);
        this.mPhotoChooseView.init(this);
        this.mPhotoChooseView.setListener(this);
        this.mPhotoChooseView.getAdapter2().setMaxCount(3);
    }

    private void updateUiForNight() {
        UgcUiUtils.setImageResource(this.mClearTitle, R.drawable.ugc_ask_clear_title);
        UgcUiUtils.setViewColor(findViewById(R.id.ugc_line), R.color.ugc_album_titleline_color);
        UgcUiUtils.setEditHintResource(this.mQuestionTitle, R.color.ugc_color_999999);
        UgcUiUtils.setTextResource(this.mAddDescription, R.color.ugc_color_3388ff);
        UgcUiUtils.setTextResource(this.mNumberTv, R.color.ugc_color_999999);
        UgcUiUtils.setViewColor(this.mContentTopLine, R.color.ugc_vote_line_color);
        UgcUiUtils.setTextResource(this.mInput, R.color.ugc_black);
        if (NightModeHelper.getNightModeSwitcherState()) {
            this.mQuestionTitle.setTextColor(getResources().getColor(R.color.ugc_color_666666));
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.ugc_publish_color_cursor);
            gradientDrawable.setColor(getResources().getColor(R.color.ugc_color_19437F));
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.mQuestionTitle, gradientDrawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQuestionDescriptionView() {
        UgcUBCUtils.askStatistics(UgcUBCUtils.UGC_TYPE_ASK_DESCRP_SHOW);
        this.mPublishView.setVisibility(0);
        this.mAddDescription.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideQuestionDescriptionView() {
        this.mEmojiTipsTv.setVisibility(8);
        this.mPublishView.setVisibility(8);
        this.mAddDescription.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goPublish() {
        if (SelectUtil.getSelectedCount() > 0) {
            publishImages(SelectUtil.getSeletedImages());
        } else {
            publish(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish(ArrayList<PublishModels.ImageData> arrayList) {
        this.mPublishPresenter.setClickState(this.mPublishTv, false);
        JSONObject jSONObject = new JSONObject();
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        publishRequestModel.title = addQuestionMark(this.mQuestionTitle.getText().toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("third_id", this.mThirdId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishRequestModel.questionAsk = jSONObject2;
        publishRequestModel.data = jSONObject;
        publishRequestModel.inputStr = this.mInput.getText().toString();
        publishRequestModel.postUrl = this.mPublishPresenter.mPostUrl;
        publishRequestModel.sourceFrom = this.mPublishPresenter.mSourceFrom;
        publishRequestModel.sourceType = 3;
        publishRequestModel.extObject = this.mExtObject;
        publishRequestModel.imageUrlList = arrayList;
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.11
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                AskPublishActivity.this.mIsPhotoUploading = false;
                AskPublishActivity.this.publishSuccess(publishResultInfo);
                AskPublishActivity.this.dismissProgressDialog();
                DraftUtils.deleteDraft(AskPublishActivity.this.mDraftKey);
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str) {
                AskPublishActivity.this.mPublishPresenter.setClickState(AskPublishActivity.this.mPublishTv, true);
                AskPublishActivity.this.mIsPhotoUploading = false;
                AskPublishActivity.this.mPublishPresenter.publishFail(str);
                AskPublishActivity.this.setBottomEntrAbleClick();
                AskPublishActivity.this.dismissProgressDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String addQuestionMark(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.endsWith("？")) {
            str = str.substring(0, str.length() - 1) + "?";
        }
        if (!str.endsWith("?")) {
            return str + "?";
        }
        return str;
    }

    public void publishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        this.mPublishPresenter.publishSuccess(publishResultInfo);
        finish();
    }

    private void publishImages(List<ImageStruct> list) {
        if (!NetWorkUtils.isHighNetworkConnected()) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
        } else {
            startUploadImages(list);
        }
    }

    private void startUploadImages(List<ImageStruct> list) {
        this.mIsPhotoUploading = true;
        final int size = list.size();
        this.mIndex = 0;
        final ArrayList arrayList = new ArrayList();
        this.mDialog = new UploadPhotosDialog(this);
        this.mDialog.show();
        this.mDialog.notifyProgress(this.mIndex, size);
        this.mDialog.setListener(new UploadPhotosDialog.CancalProgressListener() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.12
            @Override // com.baidu.searchbox.ugc.dialog.UploadPhotosDialog.CancalProgressListener
            public void cancel() {
                AskPublishActivity.this.dismissProgressDialog();
                UploadManager.getInstance().stopAll();
                AskPublishActivity.this.mIsPhotoUploading = false;
            }
        });
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.activity.AskPublishActivity.13
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                AskPublishActivity.this.dismissProgressDialog();
                AskPublishActivity.this.mIsPhotoUploading = false;
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                PublishModels.ImageData imageData = new PublishModels.ImageData();
                imageData.url = uploadFileTask.getUrl();
                imageData.width = uploadFileTask.width;
                imageData.height = uploadFileTask.height;
                imageData.size = uploadFileTask.size;
                arrayList.add(imageData);
                AskPublishActivity.access$1408(AskPublishActivity.this);
                AskPublishActivity.this.mDialog.notifyProgress(AskPublishActivity.this.mIndex, size);
                if (AskPublishActivity.this.mIndex == size) {
                    AskPublishActivity.this.publish(arrayList);
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                AskPublishActivity.this.dismissProgressDialog();
                AskPublishActivity.this.mIsPhotoUploading = false;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList2.add(new UploadImageTask(list.get(i).uriStr));
        }
        UploadManager.getInstance().startAll(arrayList2, 0, "wenda");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    private boolean isInputEdited(String str, String str2) {
        if (SelectUtil.getSeletedImages().size() == 0) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return (this.mDraftData.images.size() <= 0 && str.equals(this.mDraftData.title) && str2.equals(this.mDraftData.content)) ? false : true;
            } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return (this.mDraftData.images.size() <= 0 && TextUtils.isEmpty(this.mDraftData.title) && TextUtils.isEmpty(this.mDraftData.content)) ? false : true;
            } else if (!TextUtils.isEmpty(str)) {
                return (this.mDraftData.images.size() <= 0 && str.equals(this.mDraftData.title) && TextUtils.isEmpty(this.mDraftData.content)) ? false : true;
            } else if (TextUtils.isEmpty(str2)) {
                return false;
            } else {
                return (this.mDraftData.images.size() <= 0 && str2.equals(this.mDraftData.content) && TextUtils.isEmpty(this.mDraftData.title)) ? false : true;
            }
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return (SelectUtil.getSelectedCount() == this.mDraftData.images.size() && str.equals(this.mDraftData.title) && str2.equals(this.mDraftData.content) && !this.mEditedTag) ? false : true;
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return (SelectUtil.getSelectedCount() == this.mDraftData.images.size() && TextUtils.isEmpty(this.mDraftData.title) && TextUtils.isEmpty(this.mDraftData.content)) ? false : true;
        } else if (!TextUtils.isEmpty(str)) {
            return (SelectUtil.getSelectedCount() == this.mDraftData.images.size() && str.equals(this.mDraftData.title) && !this.mEditedTag && TextUtils.isEmpty(this.mDraftData.content)) ? false : true;
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        } else {
            return (SelectUtil.getSelectedCount() == this.mDraftData.images.size() && str2.equals(this.mDraftData.content) && !this.mEditedTag && TextUtils.isEmpty(this.mDraftData.title)) ? false : true;
        }
    }

    private void showSaveDraftDialog() {
        UgcDialogUtils.showSaveDraftDialog(new DraftOnPositiveClickListener(new WeakReference(this), new SaveDraftTask(this.mQuestionTitle.getText().toString(), this.mInput.getText().toString()), this.mPublishPresenter.mInfo), new DraftOnNegativeClickListener(new WeakReference(this), this.mPublishPresenter.mInfo, this.mDraftKey));
    }

    private void setInputCount(int i) {
        if (i == 0) {
            this.mNumberTv.setVisibility(8);
        } else if (i < 480) {
            this.mNumberTv.setVisibility(8);
        } else if (i >= 480 && i <= 500) {
            this.mPublishView.setVisibility(0);
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(500 - i)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_normal_color));
        } else if (i > 500 && i < 1500) {
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - 500)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
            this.mPublishView.setVisibility(0);
            this.mNumberTv.setVisibility(0);
        } else {
            this.mPublishView.setVisibility(0);
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(R.string.ugc_reply_input_over_999_hint);
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !this.mIsPhotoUploading) {
            backDispose(this.mQuestionTitle.getText().toString(), this.mInput.getText().toString());
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void backDispose(String str, String str2) {
        if (!this.mIsPhotoUploading) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && SelectUtil.getSelectedCount() <= 0) {
                if (this.mDraftData != null) {
                    DraftUtils.deleteDraft(this.mDraftKey);
                }
                finish();
            } else if (this.mDraftData != null && !isInputEdited(this.mQuestionTitle.getText().toString(), this.mInput.getText().toString())) {
                finish();
            } else if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str) || SelectUtil.getSeletedImages().size() != 0) {
                showSaveDraftDialog();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void addChanged(int i) {
        if (i > 500) {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        } else if (this.mQuestionTitle.getText().toString().trim().length() > 4) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        }
        if (i > 500 && i < 1500) {
            this.mPublishView.setVisibility(0);
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - 500)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
            return;
        }
        this.mPublishView.setVisibility(0);
        this.mNumberTv.setVisibility(0);
        this.mNumberTv.setText(R.string.ugc_reply_input_over_999_hint);
        this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void reduceChanged(int i) {
        this.mNumberTv.setText(String.format(getString(R.string.ugc_input_number_count), Integer.valueOf(i), 500));
        if (i > 500) {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        } else if (this.mQuestionTitle.getText().toString().trim().length() > 4) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        }
        if (i == 0) {
            this.mPublishView.setVisibility(8);
            this.mNumberTv.setVisibility(8);
        } else if (i < 480) {
            this.mPublishView.setVisibility(8);
            this.mNumberTv.setVisibility(8);
        } else {
            this.mPublishView.setVisibility(0);
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(500 - i)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_color_999999));
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void back() {
    }

    @Override // com.baidu.searchbox.ugc.view.PhotoChooseView.StartAlbumListener
    public void goAlbumBefore() {
    }

    @Override // com.baidu.searchbox.ugc.view.PhotoChooseView.StartAlbumListener
    public void setPublishBtnStatus() {
        if (TextUtils.isEmpty(this.mQuestionTitle.getText())) {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            AskPublishActivity.this.mImageList = new ArrayList(SelectUtil.getSeletedImages());
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
    /* loaded from: classes11.dex */
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
            DraftUtils.deleteDraft(this.mDraftKey);
            SelectUtil.clear();
            Activity activity = this.mWeakReference.get();
            if (activity != null) {
                activity.finish();
            }
            UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
            UgcUBCUtils.saveDraftPublishUbcStatistics(this.mUgcSchemeModel.sourceFrom, false, true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class SaveDraftTask implements Runnable {
        String content;
        String title;

        SaveDraftTask(String str, String str2) {
            this.title = str;
            this.content = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String saveImageDraft;
            DraftData draftData = new DraftData();
            if (!TextUtils.isEmpty(this.title)) {
                draftData.title = this.title;
            }
            if (!TextUtils.isEmpty(this.content)) {
                draftData.content = this.content;
            }
            if (AskPublishActivity.this.mImageList != null && AskPublishActivity.this.mImageList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = AskPublishActivity.this.mImageList.iterator();
                while (it.hasNext()) {
                    ImageStruct imageStruct = (ImageStruct) it.next();
                    if (!TextUtils.isEmpty(imageStruct.uriStr)) {
                        if (SelectUtil.isGif(imageStruct.uriStr)) {
                            saveImageDraft = FileUtils.saveGifDraft(AskPublishActivity.this, imageStruct.uriStr);
                        } else {
                            saveImageDraft = FileUtils.saveImageDraft(AskPublishActivity.this, imageStruct.uriStr);
                        }
                        if (!TextUtils.isEmpty(saveImageDraft)) {
                            arrayList.add(saveImageDraft);
                        }
                    }
                }
                draftData.images.addAll(arrayList);
            }
            draftData.timestamp = System.currentTimeMillis();
            DraftUtils.saveDraft(AskPublishActivity.this.mDraftKey, draftData);
        }
    }
}
