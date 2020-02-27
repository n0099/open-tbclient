package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.event.UgcForwardEvent;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.model.LinkInfoItem;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.ReferenceDt;
import com.baidu.searchbox.ugc.model.TopicItem;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.presenter.BasePublishPresenter;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FastPublishUtils;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcDialogUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcRichTextProcessor;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.view.ForwardPreview;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.google.gson.Gson;
import com.google.gson.b.a;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class ForwardPublishActivity extends PublishBaseActivity implements EmojiconEditText.TextNumbersChangedListener {
    private static final int THOUSAND_WORDS = 1000;
    private String mDraftContent;
    private String mDraftKey;
    private CheckBox mForwardCommentCheckBox;
    private String mForwardContent;
    private UgcSchemeModel mForwardInfo;
    private String mForwardIsComment;
    private ForwardPreview mForwardPreview;
    private ViewStub mForwardPreviewViewStub;
    private String mForwardSource;
    private ReferenceDt mReferenceDt;

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        baseSetContentView(R.layout.ugc_forward_layout);
        initForwardData();
        initForWardComment();
        initForwardView();
        initDraftData();
        this.mPublishPresenter.addTargetRule(this.mInput);
        if (this.mInput != null) {
            this.mInput.handleDraftEmojiDisplay();
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected BasePublishPresenter getPresenter() {
        return new BasePublishPresenter(this);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBusWrapper.unregister(this);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onPublish(final String str) {
        ILoginResultListener iLoginResultListener = new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.ForwardPublishActivity.1
            @Override // com.baidu.searchbox.account.ILoginResultListener
            public void onResult(int i) {
                if (i == 0) {
                    ForwardPublishActivity.this.publish(str);
                }
            }
        };
        if (this.mPublishPresenter.mEnableClick) {
            if (!NetWorkUtils.isNetworkConnected(this)) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
                return;
            }
            if (!UgcLoginUtils.isLogin()) {
                UgcLoginUtils.login(iLoginResultListener, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            } else if (!UgcLoginUtils.isGuestLogin()) {
                publish(str);
            } else {
                UgcLoginUtils.bindPhone(iLoginResultListener, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            }
            UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_PUBLISH_CLICK, null, UgcUBCUtils.PUBLISH_FORWARD_PAGE);
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onCancel(String str) {
        backDispose(str);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onEnterAlbum() {
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void addChanged(int i) {
        if (i > getForwardWordLimit() && i < getForwardWordLimit() + 1000) {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - getForwardWordLimit())));
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
        if (i <= getForwardWordLimit() && i >= 0) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        } else {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
        if (i == 0) {
            this.mNumberTv.setVisibility(8);
        } else if (i < getForwardWordLimit() - 20) {
            this.mNumberTv.setVisibility(8);
        } else {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(getForwardWordLimit() - i)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_normal_color));
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void back() {
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mInput != null) {
            backDispose(this.mInput.getText().toString());
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void backDispose(String str) {
        PositiveListener positiveListener = new PositiveListener(this, str);
        NegativeListener negativeListener = new NegativeListener(this);
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.mDraftContent)) {
                UgcUBCUtils.saveDraftPublishUbcStatistics(this.mForwardInfo.sourceFrom, true, false, false, false);
                finish();
                return;
            }
            UgcDialogUtils.showSaveDraftDialog(positiveListener, negativeListener);
            return;
        }
        UgcUBCUtils.saveDraftPublishUbcStatistics(this.mForwardInfo.sourceFrom, true, false, false, false);
        PublisherManagerFactory.get().deleteDraft(this.mDraftKey);
        postForwardEvent(false);
        finish();
        UgcUBCUtils.exitForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class PositiveListener implements DialogInterface.OnClickListener {
        private String mInputStr;
        private WeakReference<Activity> mWeakReference;

        public PositiveListener(Activity activity, String str) {
            this.mWeakReference = new WeakReference<>(activity);
            this.mInputStr = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.mWeakReference != null && this.mWeakReference.get() != null) {
                Activity activity = this.mWeakReference.get();
                if (activity instanceof ForwardPublishActivity) {
                    ((ForwardPublishActivity) activity).saveDraft(this.mInputStr);
                    UgcUBCUtils.saveDraftPublishUbcStatistics(((ForwardPublishActivity) activity).mForwardInfo.sourceFrom, true, true, true, false);
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class NegativeListener implements DialogInterface.OnClickListener {
        private WeakReference<Activity> mWeakReference;

        public NegativeListener(Activity activity) {
            this.mWeakReference = new WeakReference<>(activity);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.mWeakReference != null && this.mWeakReference.get() != null) {
                Activity activity = this.mWeakReference.get();
                if (activity instanceof ForwardPublishActivity) {
                    PublisherManagerFactory.get().deleteDraft(((ForwardPublishActivity) activity).mDraftKey);
                    UgcUBCUtils.saveDraftPublishUbcStatistics(((ForwardPublishActivity) activity).mForwardInfo.sourceFrom, true, true, false, false);
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDraft(String str) {
        DraftData draftData = new DraftData();
        if (!TextUtils.isEmpty(str)) {
            draftData.content = str;
        }
        draftData.target = this.mPublishPresenter.getTargetJson();
        draftData.timestamp = System.currentTimeMillis();
        PublisherManagerFactory.get().saveDraft(this.mDraftKey, draftData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish(String str) {
        this.mPublishPresenter.setClickState(this.mPublishTv, false);
        setBottomEntrUnableClick();
        JSONObject requestJson = FastPublishUtils.getRequestJson(this.mReferenceDt);
        String initExtraData = initExtraData(str, requestJson);
        PublishRequestModel requestModel = FastPublishUtils.getRequestModel(requestJson, this.mForwardInfo, this.mPublishPresenter.mExtObject);
        if (requestModel != null) {
            requestModel.topic = this.mPublishPresenter.mTopicObject;
            requestModel.inputStr = initExtraData;
            sendRequest(requestModel);
            return;
        }
        Toast.makeText(this, "转发失败", 0).show();
    }

    private void sendRequest(PublishRequestModel publishRequestModel) {
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.activity.ForwardPublishActivity.2
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                ForwardPublishActivity.this.publishSuccess(publishResultInfo);
                ForwardPublishActivity.this.setBottomEntrAbleClick();
                PublisherManagerFactory.get().deleteDraft(ForwardPublishActivity.this.mDraftKey);
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str) {
                ForwardPublishActivity.this.publishFail(str);
                ForwardPublishActivity.this.setBottomEntrAbleClick();
            }
        });
    }

    private String initExtraData(String str, JSONObject jSONObject) {
        if (this.mPublishPresenter.mTarget == null) {
            this.mPublishPresenter.mTarget = new UGCTarget();
        }
        if (this.mPublishPresenter.mLinkRule != null) {
            str = this.mPublishPresenter.mLinkRule.formatInputStr(str);
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
            try {
                jSONObject.putOpt("target", new JSONObject(new Gson().toJson(this.mPublishPresenter.mTarget)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public void publishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        this.mPublishPresenter.publishSuccess(publishResultInfo);
        FastPublishUtils.notifyFeedForwardNum(this.mReferenceDt, this.mPublishPresenter.mExtObject);
        postForwardEvent(true);
        if (this.mPublishPresenter.mInfo.showToast == 0 || this.mPublishPresenter.mInfo.showToast == 2) {
            UniversalToast.makeText(AppRuntime.getAppContext(), getString(R.string.ugc_forward_success)).showToast();
        }
        finish();
        UgcUBCUtils.exitForwardPage(UgcUBCUtils.UGC_TIME_PUB);
    }

    public void publishFail(String str) {
        this.mPublishPresenter.publishFail(str);
        this.mPublishPresenter.setClickState(this.mPublishTv, true);
    }

    private void postForwardEvent(boolean z) {
        if (!TextUtils.isEmpty(this.mForwardSource)) {
            UgcForwardEvent ugcForwardEvent = new UgcForwardEvent();
            ugcForwardEvent.forwardSource = this.mForwardSource;
            ugcForwardEvent.forwardSuccess = z;
            EventBusWrapper.post(ugcForwardEvent);
        }
    }

    private void initForwardData() {
        if (getIntent() != null) {
            this.mForwardInfo = (UgcSchemeModel) getIntent().getSerializableExtra("data");
            if (this.mForwardInfo != null) {
                this.mForwardContent = this.mForwardInfo.forwardContent;
                this.mForwardSource = this.mForwardInfo.forwardSource;
                String str = this.mForwardInfo.target;
                if (!TextUtils.isEmpty(str)) {
                    Gson gson = new Gson();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString("topics");
                        String optString2 = jSONObject.optString("at");
                        String optString3 = jSONObject.optString("link");
                        if (this.mPublishPresenter.mTarget == null) {
                            this.mPublishPresenter.mTarget = new UGCTarget();
                        }
                        this.mPublishPresenter.mTarget.mTopicList = (List) gson.fromJson(optString, new a<List<TopicItem>>() { // from class: com.baidu.searchbox.ugc.activity.ForwardPublishActivity.3
                        }.getType());
                        this.mPublishPresenter.mTarget.mUserInfoList = (List) gson.fromJson(optString2, new a<List<AtUserInfoItem>>() { // from class: com.baidu.searchbox.ugc.activity.ForwardPublishActivity.4
                        }.getType());
                        this.mPublishPresenter.mTarget.mLinkInfoList = (List) gson.fromJson(optString3, new a<List<LinkInfoItem>>() { // from class: com.baidu.searchbox.ugc.activity.ForwardPublishActivity.5
                        }.getType());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String str2 = this.mForwardInfo.referenceDt;
                if (!TextUtils.isEmpty(str2)) {
                    this.mReferenceDt = (ReferenceDt) new Gson().fromJson(str2, (Class<Object>) ReferenceDt.class);
                }
                if (this.mPublishPresenter.mExtObject != null) {
                    if (this.mPublishPresenter.mExtObject.has("forward_is_comment")) {
                        this.mForwardIsComment = this.mPublishPresenter.mExtObject.optString("forward_is_comment");
                    } else {
                        this.mForwardIsComment = "1";
                    }
                }
            }
        }
        if (this.mInput != null) {
            this.mInput.setListener(this);
        }
    }

    private void initForwardView() {
        this.mForwardPreviewViewStub = (ViewStub) findViewById(ResourceUtils.getResIdByName("ugc_forward_preview_viewstub"));
        if (this.mForwardInfo != null && !TextUtils.isEmpty(this.mForwardInfo.placeTitle)) {
            UiBaseUtils.setTextString(this.mTitle, this.mForwardInfo.placeTitle);
        } else {
            UiBaseUtils.setTextStringResource(this.mTitle, R.string.ugc_forward_title);
        }
        this.mPublishPresenter.setClickState(this.mPublishTv, true);
        if (this.mForwardPreviewViewStub != null) {
            this.mForwardPreview = (ForwardPreview) this.mForwardPreviewViewStub.inflate();
        }
        if (this.mForwardPreview == null || this.mForwardPreview.getId() != ResourceUtils.getResIdByName("ugc_forward_preview")) {
            if (DEBUG) {
                Log.e(TAG, "转发界面ViewStub inflate设置界面失败");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.mForwardContent) && this.mInput != null) {
            this.mInput.setText("//" + this.mForwardContent);
        }
        if (this.mReferenceDt != null && this.mForwardPreview != null) {
            this.mForwardPreview.setText(this.mReferenceDt.title);
            handleForwardPreviewTvEmotion();
            this.mForwardPreview.loadImage(this.mReferenceDt.refType, this.mReferenceDt.thumbpic, this.mReferenceDt.avatar);
            this.mForwardPreview.setAttachmentInfo(this.mReferenceDt.attachmentInfo);
        }
    }

    private void handleForwardPreviewTvEmotion() {
        if (this.mForwardPreview != null) {
            UgcRichTextProcessor.handleEmotionDispaly(this.mForwardPreview.getForwardPreViewText());
        }
    }

    private void initForWardComment() {
        ViewStub viewStub;
        if (this.mRootView != null && (viewStub = (ViewStub) this.mRootView.findViewById(ResourceUtils.getResIdByName("viewstub_forward_comment_container"))) != null) {
            final LinearLayout linearLayout = (LinearLayout) viewStub.inflate();
            this.mForwardCommentCheckBox = (CheckBox) linearLayout.findViewById(ResourceUtils.getResIdByName("ugc_forward_comment_cb"));
            this.mInput.setMaxSize(getForwardWordLimit());
            if (TextUtils.isEmpty(this.mForwardIsComment)) {
                UiBaseUtils.setVisibility(linearLayout, 8);
                return;
            }
            if ("0".equals(this.mForwardIsComment)) {
                setForwardIsCommentValue("0");
                UiBaseUtils.setVisibility(linearLayout, 8);
            } else if ("1".equals(this.mForwardIsComment) || "2".equals(this.mForwardIsComment)) {
                UiBaseUtils.setVisibility(linearLayout, 0);
                if ("1".equals(this.mForwardIsComment)) {
                    UiBaseUtils.setChecked(this.mForwardCommentCheckBox, true);
                    setForwardIsCommentValue("1");
                }
                if ("2".equals(this.mForwardIsComment)) {
                    UiBaseUtils.setChecked(this.mForwardCommentCheckBox, false);
                    setForwardIsCommentValue("2");
                    UgcUiUtils.setTextResource((TextView) linearLayout.findViewById(ResourceUtils.getResIdByName("ugc_forward_comment_tv")), R.color.ugc_album_layer_text_color);
                }
                UiBaseUtils.setOnCheckedChangeListener(this.mForwardCommentCheckBox, new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.searchbox.ugc.activity.ForwardPublishActivity.6
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        ForwardPublishActivity.this.setForwardIsCommentValue(z ? "1" : "2");
                        UgcUiUtils.setTextResource((TextView) linearLayout.findViewById(ResourceUtils.getResIdByName("ugc_forward_comment_tv")), z ? R.color.ugc_forward_preview_text_color : R.color.ugc_album_layer_text_color);
                        ForwardPublishActivity.this.mPublishPresenter.setInputState(ForwardPublishActivity.this.mInput, ForwardPublishActivity.this.mNumberTv, ForwardPublishActivity.this.mPublishTv, ForwardPublishActivity.this.getForwardWordLimit());
                    }
                });
            }
            UgcUiUtils.setCheckBoxBtn(this.mForwardCommentCheckBox, R.drawable.ugc_forward_comment_checkbox_btn);
            UgcUiUtils.setTextResource((TextView) findViewById(ResourceUtils.getResIdByName("ugc_forward_comment_tv")), R.color.ugc_forward_preview_text_color);
        }
    }

    private void initDraftData() {
        this.mDraftKey = DraftUtils.getDraftKey(this.mPublishPresenter.mInfo);
        DraftData draft = PublisherManagerFactory.get().getDraft(this.mDraftKey);
        if (draft != null) {
            if (!TextUtils.isEmpty(draft.content) && this.mInput != null) {
                String str = this.mPublishPresenter.mInfo.forwardContent;
                this.mDraftContent = draft.content;
                String str2 = this.mDraftContent;
                if (this.mDraftContent.contains("/")) {
                    str2 = substring(this.mDraftContent, 0, this.mDraftContent.indexOf("/"));
                }
                String substring = substring(this.mDraftContent, this.mDraftContent.indexOf("@"), this.mDraftContent.indexOf(":"));
                String str3 = null;
                if (!TextUtils.isEmpty(str)) {
                    str3 = substring(str, str.indexOf(substring), str.length());
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    this.mInput.setText(str2 + "//" + str3);
                } else if (TextUtils.isEmpty(str2)) {
                    this.mInput.setText("//" + str3);
                } else {
                    this.mInput.setText(str2);
                }
            }
            if (draft.target != null) {
                this.mPublishPresenter.mTarget = (UGCTarget) new Gson().fromJson(draft.target, (Class<Object>) UGCTarget.class);
            }
        }
    }

    private String substring(String str, int i, int i2) {
        if (str == null) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        int length = str.length();
        if (i >= length || i > i2 || i2 > length) {
            return "";
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForwardIsCommentValue(String str) {
        try {
            if (this.mPublishPresenter.mExtObject != null) {
                this.mPublishPresenter.mExtObject.put("forward_is_comment", str);
                UgcUBCUtils.setExtInfo("is_comment", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getForwardWordLimit() {
        if (this.mForwardCommentCheckBox == null || !this.mForwardCommentCheckBox.isChecked() || this.mPublishPresenter.inputImgTextLimit <= 200) {
            return this.mPublishPresenter.inputImgTextLimit;
        }
        return 200;
    }
}
