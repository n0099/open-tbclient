package com.baidu.searchbox.ugc.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.LocalAlbumActivity;
import com.baidu.searchbox.ugc.activity.ReplyPublishActivity;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.emoji.EmojiconHandler;
import com.baidu.searchbox.ugc.emoji.edittextrule.AtRule;
import com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule;
import com.baidu.searchbox.ugc.listener.PublishLimitUpdateListener;
import com.baidu.searchbox.ugc.model.AtSelectEvent;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.UgcDataUtil;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcSpWrapper;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.spswitch.b.a;
import com.baidu.spswitch.b.c;
import com.baidu.spswitch.b.e;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.google.gson.Gson;
import com.google.gson.b.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.b;
/* loaded from: classes13.dex */
public class ReplyPublishDialog extends DialogFragment implements View.OnClickListener, EmojiconEditText.TextNumbersChangedListener {
    private static final int DURATION = 100;
    private int MAX_INPUT_COUNT = getInputWordLimit(PublishLimitUpdateListener.KEY_IMG_TXT_LEN);
    private Activity mActivity;
    private ImageView mAlbumEnterView;
    private AtRule mAtRule;
    private String mAtSelectPageScheme;
    private ImageView mAtSelectView;
    private DraftData mDraftData;
    private String mDraftKey;
    private ImageView mEmojiSwitchView;
    private JSONObject mExtObject;
    private TextView mInputCountView;
    private EmojiconEditText mInputView;
    private String mInterestId;
    private boolean mIsShowEmojiPanel;
    private boolean mIsShowSoftInput;
    private String mNid;
    private SPSwitchPanelLinearLayout mPanelRootView;
    private String mPostUrl;
    private ProgressBar mProgressBar;
    private LinearLayout mRootView;
    private FrameLayout mSendContainer;
    private TextView mSendView;
    private String mSourceFrom;
    private String mUgcCallback;
    private UgcSchemeModel mUgcInfo;
    private UGCTarget mUgcTarget;
    private ImageView mVideoEnterView;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.ugc_publish_dialog_style);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        this.mRootView = (LinearLayout) layoutInflater.inflate(R.layout.ugc_publish_reply_dailog, viewGroup, false);
        initView();
        initData();
        initEmotionPanel();
        updateUI();
        addTargetRule();
        UgcUBCUtils.replyPublishUbcStatistics("show", null, this.mNid, this.mInterestId);
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().setGravity(80);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private void initData() {
        if (this.mActivity.getIntent() != null) {
            this.mUgcInfo = (UgcSchemeModel) getArguments().getSerializable("data");
            if (this.mUgcInfo != null) {
                this.mAtSelectPageScheme = this.mUgcInfo.atSchema;
                this.mPostUrl = this.mUgcInfo.url;
                String str = this.mUgcInfo.ext;
                this.mSourceFrom = this.mUgcInfo.sourceFrom;
                this.mUgcCallback = this.mUgcInfo.ugcCallback;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.mExtObject = new JSONObject(str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mDraftKey = DraftUtils.getDraftKey(this.mUgcInfo);
                this.mDraftData = DraftUtils.getDraft(this.mDraftKey);
                if (this.mDraftData != null) {
                    getDraftData();
                }
                if (!TextUtils.isEmpty(this.mUgcInfo.target)) {
                    try {
                        String optString = new JSONObject(this.mUgcInfo.target).optString("tag");
                        if (this.mUgcTarget == null) {
                            this.mUgcTarget = new UGCTarget();
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            this.mUgcTarget.tagList = (List) new Gson().fromJson(optString, new a<List<UgcTagItem>>() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.1
                            }.getType());
                            if (this.mUgcTarget.tagList.size() > 0) {
                                this.mNid = this.mUgcTarget.tagList.get(0).postId;
                                this.mInterestId = this.mUgcTarget.tagList.get(0).tagID;
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(this.mUgcInfo.placeholder)) {
                        this.mInputView.setHint(this.mUgcInfo.placeholder);
                    } else {
                        this.mInputView.setHint(R.string.ugc_publish_hint_text);
                    }
                    if (!TextUtils.isEmpty(this.mAtSelectPageScheme)) {
                        this.mAtSelectView.setVisibility(0);
                    } else {
                        this.mAtSelectView.setVisibility(8);
                    }
                }
            }
        }
    }

    private void getDraftData() {
        if (!TextUtils.isEmpty(this.mDraftData.content)) {
            this.mInputView.setText(this.mDraftData.content);
            this.mInputView.handleDraftEmojiDisplay();
            this.mInputView.setSelection(this.mInputView.length());
        }
        if (this.mDraftData.target != null) {
            this.mUgcTarget = (UGCTarget) new Gson().fromJson(this.mDraftData.target, (Class<Object>) UGCTarget.class);
        }
    }

    private void initView() {
        this.mInputView = (EmojiconEditText) this.mRootView.findViewById(R.id.ugc_input_box);
        this.mInputCountView = (TextView) this.mRootView.findViewById(R.id.ugc_input_count);
        this.mEmojiSwitchView = (ImageView) this.mRootView.findViewById(R.id.ugc_emoji_view);
        this.mAtSelectView = (ImageView) this.mRootView.findViewById(R.id.ugc_at_view);
        this.mAlbumEnterView = (ImageView) this.mRootView.findViewById(R.id.ugc_pic_view);
        this.mVideoEnterView = (ImageView) this.mRootView.findViewById(R.id.ugc_video_view);
        this.mPanelRootView = (SPSwitchPanelLinearLayout) this.mRootView.findViewById(R.id.ugc_panel_root);
        this.mSendContainer = (FrameLayout) this.mRootView.findViewById(R.id.ugc_send_container);
        this.mSendView = (TextView) this.mRootView.findViewById(R.id.ugc_send_view);
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.ugc_send_progressbar);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.ugc_reply_publish_progress));
        this.mAtSelectView.setOnClickListener(this);
        this.mAlbumEnterView.setOnClickListener(this);
        this.mVideoEnterView.setOnClickListener(this);
        this.mSendView.setOnClickListener(this);
        this.mInputView.setListener(this);
        this.mInputView.setMaxSize(this.MAX_INPUT_COUNT);
        UgcUiUtils.setEditResource(this.mInputView, R.color.ugc_dialog_input_text_color);
        this.mAtRule = new AtRule(this.mInputView);
        this.mInputView.addRule("@", this.mAtRule);
        this.mAtRule.setPatternTag('@');
        this.mAtRule.setPatternTagInputListener(new BasePatternRule.PatternTagInputListener() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.2
            @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule.PatternTagInputListener
            public void onPatternTagInput() {
                if (!TextUtils.isEmpty(ReplyPublishDialog.this.mAtSelectPageScheme)) {
                    UgcUiUtils.callAtPage(ReplyPublishDialog.this.getDialog().getContext(), ReplyPublishDialog.this.mAtSelectPageScheme, new b<AtSelectEvent>() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // rx.functions.b
                        public void call(AtSelectEvent atSelectEvent) {
                            if (atSelectEvent != null && atSelectEvent.mAtUserInfoItem != null) {
                                int selectionStart = ReplyPublishDialog.this.mInputView.getSelectionStart();
                                ReplyPublishDialog.this.mInputView.getEditableText().delete(selectionStart - 1, selectionStart);
                                EmojiconHandler.addAt(ReplyPublishDialog.this.mInputView, new AtUserInfoItem(atSelectEvent.mAtUserInfoItem.nickname, atSelectEvent.mAtUserInfoItem.uk), ReplyPublishDialog.this.mAtRule);
                                EventBusWrapper.unregister(ReplyPublishDialog.this.getDialog().getContext());
                            }
                        }
                    });
                }
            }
        });
        this.mRootView.findViewById(R.id.ugc_publish_place_holder).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        ReplyPublishDialog.this.dismissWithDraft();
                        return true;
                    case 1:
                        view.performClick();
                        return true;
                    default:
                        return true;
                }
            }
        });
        if (!PublisherConfig.isMainApp()) {
            this.mVideoEnterView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWithDraft() {
        String obj = this.mInputView.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            if (this.mDraftData == null || (!TextUtils.isEmpty(this.mDraftData.content) && !this.mDraftData.content.equals(obj))) {
                Sender.sendBroadcast(AppRuntime.getAppContext(), UgcConstant.UGC_REPLY_PUBLISH_INPUT_ACTION, obj);
            }
            DraftData draftData = new DraftData();
            if (!TextUtils.isEmpty(obj)) {
                draftData.content = obj;
            }
            if (this.mUgcTarget == null) {
                this.mUgcTarget = new UGCTarget();
            }
            if (this.mAtRule != null) {
                this.mAtRule.obtainUserInfoList(this.mUgcTarget.mUserInfoList);
            }
            draftData.target = new Gson().toJson(this.mUgcTarget);
            DraftUtils.saveDraft(this.mDraftKey, draftData);
        } else if (this.mDraftData != null) {
            DraftUtils.deleteDraft(this.mDraftKey);
            Sender.sendBroadcast(AppRuntime.getAppContext(), UgcConstant.UGC_REPLY_PUBLISH_INPUT_ACTION, null);
        }
        UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
        dismiss();
    }

    private void updateUI() {
        UgcUiUtils.setEditHintResource(this.mInputView, R.color.ugc_dialog_input_hint_color);
        UgcUiUtils.setViewDrawable(this.mInputView, R.drawable.ugc_dialog_input_bg);
        UgcUiUtils.setViewDrawable(this.mSendContainer, R.drawable.ugc_publish_dialog_btn_selector);
        UgcUiUtils.setViewDrawable(this.mSendView, R.drawable.ugc_publish_dialog_btn_selector);
        UgcUiUtils.setTextResource(this.mSendView, R.drawable.ugc_publish_dialog_btn_txt_selector);
        UgcUiUtils.setImageResource(this.mEmojiSwitchView, R.drawable.ugc_switch_soft_emoji_small_selector);
        UgcUiUtils.setImageResource(this.mAlbumEnterView, R.drawable.ugc_choose_photo_enter_small_selector);
        UgcUiUtils.setImageResource(this.mVideoEnterView, R.drawable.ugc_choose_video_enter_small_selector);
        UgcUiUtils.setImageResource(this.mAtSelectView, R.drawable.ugc_topic_at_small_selector);
        UgcUiUtils.setViewColor(this.mRootView.findViewById(R.id.ugc_publish_input_layout), R.color.ugc_reply_input_bg_color);
        UgcUiUtils.setViewColor(this.mRootView.findViewById(R.id.ugc_publish_view), R.color.ugc_reply_input_bg_color);
        UgcUiUtils.setViewColor(this.mRootView.findViewById(R.id.ugc_division_line), R.color.ugc_reply_publish_division_line_color);
    }

    private void initEmotionPanel() {
        e.a(this.mActivity, (ViewGroup) getDialog().getWindow().getDecorView().findViewById(16908290), this.mPanelRootView, new e.a() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.4
            @Override // com.baidu.spswitch.b.e.a
            public void onSoftInputShowing(boolean z) {
                if (z) {
                    ReplyPublishDialog.this.mIsShowSoftInput = true;
                    UgcUiUtils.setImageResource(ReplyPublishDialog.this.mEmojiSwitchView, R.drawable.ugc_switch_soft_emoji_small_selector);
                }
            }
        });
        c.a(getDialog().getWindow(), this.mPanelRootView, this.mEmojiSwitchView, this.mInputView, new c.a() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.5
            @Override // com.baidu.spswitch.b.c.a
            public void onClickSwitch(View view, boolean z) {
                ReplyPublishDialog.this.mIsShowEmojiPanel = z;
                if (z) {
                    UgcUiUtils.setImageResource(ReplyPublishDialog.this.mEmojiSwitchView, R.drawable.ugc_keyboard_small_selector);
                    UgcSpWrapper.getInstance().putString("ugc_publish_emoji_tips", "emoji");
                    UgcUBCUtils.replyPublishUbcStatistics("click", UgcUBCUtils.UGC_TYPE_EMOJI_CLICK, ReplyPublishDialog.this.mNid, ReplyPublishDialog.this.mInterestId);
                    return;
                }
                UgcUiUtils.setImageResource(ReplyPublishDialog.this.mEmojiSwitchView, R.drawable.ugc_switch_soft_emoji_selector);
            }
        });
        com.baidu.spswitch.b.b.init(AppConfig.isDebug());
        com.baidu.spswitch.b.a.Gq().a(this.mActivity, this.mPanelRootView, this.mInputView, NightModeHelper.getNightModeSwitcherState());
        com.baidu.spswitch.b.a.Gq().a(new a.InterfaceC0194a() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.6
            @Override // com.baidu.spswitch.b.a.InterfaceC0194a
            public void onEmotionClick(EmotionType emotionType, int i, String str, String str2) {
                if (!TextUtils.isEmpty(str)) {
                    UgcUBCUtils.emotionUbcStatistics(ReplyPublishDialog.this.mSourceFrom, false, str);
                }
            }
        });
        e.a(this.mInputView, 100L);
    }

    private void addTargetRule() {
        this.mRootView.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.7
            @Override // java.lang.Runnable
            public void run() {
                if (ReplyPublishDialog.this.mUgcTarget != null && ReplyPublishDialog.this.mAtRule != null && ReplyPublishDialog.this.mUgcTarget.mUserInfoList != null && ReplyPublishDialog.this.mUgcTarget.mUserInfoList.size() > 0) {
                    ReplyPublishDialog.this.mAtRule.setRuleFromUserInfoList(ReplyPublishDialog.this.mUgcTarget.mUserInfoList);
                    ReplyPublishDialog.this.mAtRule.highLightMatchString();
                }
            }
        }, 150L);
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void addChanged(int i) {
        if (i > this.MAX_INPUT_COUNT && i < this.MAX_INPUT_COUNT + 1000) {
            this.mSendView.setEnabled(false);
            this.mInputCountView.setVisibility(0);
            this.mInputCountView.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - this.MAX_INPUT_COUNT)));
            this.mInputCountView.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
            return;
        }
        this.mSendView.setEnabled(false);
        this.mInputCountView.setVisibility(0);
        this.mInputCountView.setText(R.string.ugc_reply_input_over_999_hint);
        this.mInputCountView.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void reduceChanged(int i) {
        if (i == 0) {
            this.mSendView.setEnabled(false);
            this.mInputCountView.setVisibility(8);
        } else if (i < this.MAX_INPUT_COUNT - 20) {
            this.mSendView.setEnabled(true);
            this.mInputCountView.setVisibility(8);
        } else {
            this.mSendView.setEnabled(true);
            this.mInputCountView.setVisibility(0);
            this.mInputCountView.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(this.MAX_INPUT_COUNT - i)));
            this.mInputCountView.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_normal_color));
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void back() {
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsShowSoftInput && !this.mIsShowEmojiPanel) {
            e.a(this.mInputView, 100L);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        EventBusWrapper.unregister(getDialog().getContext());
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mInputView != null) {
            this.mInputView.removeListener();
        }
        com.baidu.spswitch.b.a.Gq().dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ugc_pic_view) {
            onEnterAlbum();
        } else if (id == R.id.ugc_video_view) {
            onEnterVideo();
        } else if (id == R.id.ugc_at_view) {
            onEnterFollowPage();
        } else if (id == R.id.ugc_send_view) {
            if (!NetWorkUtils.isNetworkConnected()) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
            } else {
                onPublish(this.mInputView.getText().toString());
            }
        }
    }

    private void showProgressBar() {
        this.mProgressBar.setVisibility(0);
        this.mSendView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
        this.mSendView.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            Intent intent2 = new Intent(this.mActivity, ReplyPublishActivity.class);
            this.mUgcInfo.from = 0;
            this.mUgcInfo.launchFrom = "menu";
            if (!TextUtils.isEmpty(this.mInputView.getText())) {
                this.mUgcInfo.placeContent = this.mInputView.getText().toString();
            }
            if (this.mUgcTarget == null) {
                this.mUgcTarget = new UGCTarget();
            }
            if (this.mAtRule != null) {
                this.mAtRule.obtainUserInfoList(this.mUgcTarget.mUserInfoList);
            }
            if (this.mUgcTarget != null) {
                this.mUgcInfo.target = new Gson().toJson(this.mUgcTarget);
            }
            intent2.putExtra("data", this.mUgcInfo);
            startActivity(intent2);
            dismiss();
        }
    }

    private void onEnterAlbum() {
        if (this.mDraftData != null) {
            DraftUtils.deleteDraft(this.mDraftKey);
        }
        UgcUBCUtils.replyPublishUbcStatistics("click", UgcUBCUtils.UGC_TYPE_PHOTO_CLICK, this.mNid, this.mInterestId);
        startActivityForResult(new Intent(this.mActivity, LocalAlbumActivity.class), 32769);
        this.mActivity.overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
    }

    private void onEnterVideo() {
        if (this.mDraftData != null) {
            DraftUtils.deleteDraft(this.mDraftKey);
        }
        this.mUgcInfo.launchFrom = "menu";
        if (!TextUtils.isEmpty(this.mInputView.getText())) {
            this.mUgcInfo.placeContent = this.mInputView.getText().toString();
        }
        if (this.mUgcTarget == null) {
            this.mUgcTarget = new UGCTarget();
        }
        if (this.mAtRule != null) {
            this.mAtRule.obtainUserInfoList(this.mUgcTarget.mUserInfoList);
        }
        if (this.mUgcTarget != null) {
            this.mUgcInfo.target = new Gson().toJson(this.mUgcTarget);
        }
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null) {
            iPublisherSboxVideoInterface.invokeVideoCapture(this.mUgcInfo, this.mActivity);
        }
        UgcUBCUtils.replyPublishUbcStatistics("click", "video_click", this.mNid, this.mInterestId);
        dismiss();
    }

    private void onEnterFollowPage() {
        if (!TextUtils.isEmpty(this.mAtSelectPageScheme)) {
            UgcUiUtils.callAtPage(getDialog().getContext(), this.mAtSelectPageScheme, new b<AtSelectEvent>() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(AtSelectEvent atSelectEvent) {
                    if (atSelectEvent != null && atSelectEvent.mAtUserInfoItem != null) {
                        EmojiconHandler.addAt(ReplyPublishDialog.this.mInputView, new AtUserInfoItem(atSelectEvent.mAtUserInfoItem.nickname, atSelectEvent.mAtUserInfoItem.uk), ReplyPublishDialog.this.mAtRule);
                        EventBusWrapper.unregister(ReplyPublishDialog.this.getDialog().getContext());
                    }
                }
            });
            UgcUBCUtils.replyPublishUbcStatistics("click", UgcUBCUtils.UGC_TYPE_AT_CLICK, this.mNid, this.mInterestId);
        }
    }

    private void onPublish(final String str) {
        if (!UgcLoginUtils.isLogin()) {
            UgcLoginUtils.login(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.9
                @Override // com.baidu.searchbox.account.ILoginResultListener
                public void onResult(int i) {
                    if (i == 0) {
                        ReplyPublishDialog.this.goPublish(str);
                    }
                }
            }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
        } else if (!UgcLoginUtils.isGuestLogin()) {
            goPublish(str);
        } else {
            UgcLoginUtils.bindPhone(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.10
                @Override // com.baidu.searchbox.account.ILoginResultListener
                public void onResult(int i) {
                    if (i == 0) {
                        ReplyPublishDialog.this.goPublish(str);
                    }
                }
            }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
        }
        UgcUBCUtils.replyPublishUbcStatistics("click", UgcUBCUtils.UGC_TYPE_PUBLISH_CLICK, this.mNid, this.mInterestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goPublish(String str) {
        if (!TextUtils.isEmpty(str)) {
            showProgressBar();
            JSONObject jSONObject = new JSONObject();
            PublishRequestModel publishRequestModel = new PublishRequestModel();
            try {
                if (this.mUgcTarget == null) {
                    this.mUgcTarget = new UGCTarget();
                }
                if (this.mAtRule != null) {
                    this.mAtRule.obtainUserInfoList(this.mUgcTarget.mUserInfoList);
                }
                if (this.mUgcTarget != null) {
                    jSONObject.putOpt("target", new JSONObject(new Gson().toJson(this.mUgcTarget)));
                }
                publishRequestModel.data = jSONObject;
                publishRequestModel.inputStr = str;
                publishRequestModel.postUrl = this.mPostUrl;
                publishRequestModel.sourceFrom = this.mSourceFrom;
                publishRequestModel.extObject = this.mExtObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.view.ReplyPublishDialog.11
                @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
                public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                    ReplyPublishDialog.this.publishSuccess(publishResultInfo);
                    DraftUtils.deleteDraft(ReplyPublishDialog.this.mDraftKey);
                    Sender.sendBroadcast(AppRuntime.getAppContext(), UgcConstant.UGC_REPLY_PUBLISH_INPUT_ACTION, null);
                }

                @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
                public void onFailed(String str2) {
                    ReplyPublishDialog.this.hideProgressBar();
                    ReplyPublishDialog.this.publishFailure(str2);
                }
            });
        }
    }

    public void publishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        String str = null;
        if (publishResultInfo != null) {
            str = publishResultInfo.data.errmsg;
        }
        if (TextUtils.isEmpty(str) && isAdded()) {
            str = getResources().getString(R.string.ugc_release_success);
        }
        if ((this.mUgcInfo.showToast == 0 || this.mUgcInfo.showToast == 2) && !TextUtils.isEmpty(str)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
        }
        if (!TextUtils.isEmpty(this.mUgcCallback)) {
            if (publishResultInfo != null) {
                handleCallback(this.mUgcCallback, publishResultInfo.requestId);
            }
        } else {
            CallbackHandler callbackHandler = UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.get("publish");
            UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.remove("publish");
            if (callbackHandler != null && (callbackHandler instanceof NullableCallbackHandler) && publishResultInfo != null) {
                Sender.sendBroadcast(AppRuntime.getAppContext(), "com.baidu.channel.talos.schemesecondcallback", publishResultInfo.requestId);
            }
        }
        UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
        dismiss();
    }

    private void handleCallback(String str, String str2) {
        CallbackHandler callbackHandler = UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.get("publish");
        UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.remove("publish");
        if (callbackHandler != null && str != null) {
            callbackHandler.handleSchemeDispatchCallback(str, str2);
        }
    }

    public void publishFailure(String str) {
        if (TextUtils.isEmpty(str) && isAdded()) {
            str = getResources().getString(R.string.ugc_release_fail);
        }
        if (this.mUgcInfo.showToast == 0 || this.mUgcInfo.showToast == 1) {
            UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
        }
    }

    private int getInputWordLimit(String str) {
        String str2 = null;
        if (this.mUgcInfo != null && !TextUtils.isEmpty(this.mUgcInfo.publishLimit)) {
            try {
                JSONObject optJSONObject = new JSONObject(this.mUgcInfo.publishLimit).optJSONObject(this.mUgcInfo.publishType);
                if (optJSONObject != null) {
                    str2 = optJSONObject.optString("wordLimit");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return UgcDataUtil.getWordLimit(str2, str);
    }
}
