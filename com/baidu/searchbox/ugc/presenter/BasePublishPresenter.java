package com.baidu.searchbox.ugc.presenter;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.publisher.controller.IPublisherManagerInterface;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.publisher.controller.listener.SelectAtListener;
import com.baidu.searchbox.publisher.controller.listener.SelectTopicListener;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.ForwardPublishActivity;
import com.baidu.searchbox.ugc.activity.IPublishView;
import com.baidu.searchbox.ugc.activity.VideoPublishActivity;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.emoji.EmojiconHandler;
import com.baidu.searchbox.ugc.emoji.edittextrule.AtRule;
import com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule;
import com.baidu.searchbox.ugc.emoji.edittextrule.LinkRule;
import com.baidu.searchbox.ugc.emoji.edittextrule.TopicRule;
import com.baidu.searchbox.ugc.listener.PublishLimitUpdateListener;
import com.baidu.searchbox.ugc.model.AtSelectEvent;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.TopicItem;
import com.baidu.searchbox.ugc.model.TopicSelectEvent;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.model.UgcPKInfo;
import com.baidu.searchbox.ugc.model.UgcTagDisplayModel;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.baidu.searchbox.ugc.model.UgcVoteInfo;
import com.baidu.searchbox.ugc.utils.FastPublishUtils;
import com.baidu.searchbox.ugc.utils.UgcDataUtil;
import com.baidu.searchbox.ugc.utils.UgcSpWrapper;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.spswitch.b.a;
import com.baidu.spswitch.b.c;
import com.baidu.spswitch.b.e;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.b.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.b;
/* loaded from: classes13.dex */
public class BasePublishPresenter {
    private static final int THOUSAND_WORDS = 1000;
    private static final String VOTE_OPTION_IS_CHECKED = "1";
    public int inputImgTextLimit;
    public int inputVideoLimit;
    private boolean isShowUgcTag;
    public String mAtPageScheme;
    public AtRule mAtRule;
    public int mCallType;
    protected int mEmojiDrawable;
    public boolean mEnableClick = false;
    public String mExtInfo;
    public JSONObject mExtObject;
    public UgcSchemeModel mInfo;
    protected boolean mIsShowSoftInput;
    protected int mKeyboardDrawable;
    public LinkRule mLinkRule;
    public String mLocation;
    public JSONObject mLocationObject;
    public String mPlaceholder;
    public String mPoiId;
    public String mPostUrl;
    protected IPublishView mPublishView;
    private IPublisherManagerInterface mPublisherInterfaceManager;
    public int mServerTopicsRule;
    public String mSourceFrom;
    public JSONObject mSwanObject;
    public UGCTarget mTarget;
    public String mTopic;
    public String mTopicId;
    public String mTopicName;
    public JSONObject mTopicObject;
    public TopicRule mTopicRule;
    public String mTopicSelectPageScheme;
    public String mUgcCallback;
    private String mUgcTagScheme;
    public UgcVoteInfo ugcVoteInfo;
    public static final String TAG = BasePublishPresenter.class.getSimpleName();
    public static final boolean DEBUG = AppConfig.isDebug();
    public static String HOME_FOLLOW_TAB_SCHEMA = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params={\"channel\":\"58\"}";

    public BasePublishPresenter(IPublishView iPublishView) {
        this.mPublishView = iPublishView;
    }

    public void onCreate(UgcSchemeModel ugcSchemeModel) {
        this.mPublisherInterfaceManager = PublisherManagerFactory.get();
        initData(ugcSchemeModel);
        if (TextUtils.equals(this.mInfo.publishType, "5")) {
            UgcUBCUtils.ugcUbcStatistics("593", "show", null, UgcUBCUtils.PUBLISH_FORWARD_PAGE);
        } else {
            UgcUBCUtils.ugcUbcStatistics("593", "show", null, "publish");
        }
        this.mKeyboardDrawable = R.drawable.ugc_keyboard_selector;
        this.mEmojiDrawable = R.drawable.ugc_switch_soft_emoji_selector;
    }

    public void onResume(EmojiconEditText emojiconEditText) {
        EventBusWrapper.unregister(this.mPublishView.getContext());
        if (this.mIsShowSoftInput && !this.mPublishView.isEmojiShown()) {
            e.a(emojiconEditText, 300L);
        }
    }

    private void initData(UgcSchemeModel ugcSchemeModel) {
        this.mInfo = ugcSchemeModel;
        this.inputImgTextLimit = getInputWordLimit(PublishLimitUpdateListener.KEY_IMG_TXT_LEN);
        this.inputVideoLimit = getInputWordLimit(PublishLimitUpdateListener.KEY_VIDEO_LEN);
        if (this.mInfo != null) {
            this.mPlaceholder = this.mInfo.placeholder;
            this.mServerTopicsRule = this.mInfo.serverTopicsRule;
            this.mTopic = this.mInfo.topic;
            this.mTopicSelectPageScheme = this.mInfo.topicSelectSchema;
            this.mAtPageScheme = this.mInfo.atSchema;
            this.mPostUrl = this.mInfo.url;
            this.mLocation = this.mInfo.location;
            this.mExtInfo = this.mInfo.ext;
            this.mSourceFrom = this.mInfo.sourceFrom;
            this.mUgcCallback = this.mInfo.ugcCallback;
            this.mCallType = this.mInfo.callType;
            if (!TextUtils.isEmpty(this.mTopic)) {
                try {
                    this.mTopicObject = new JSONObject(this.mTopic);
                    this.mTopicId = this.mTopicObject.optString("id");
                    this.mTopicName = this.mTopicObject.optString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(this.mLocation)) {
                try {
                    this.mLocationObject = new JSONObject(this.mLocation);
                    this.mPoiId = this.mLocationObject.optString(UgcConstant.POI_ID);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(this.mExtInfo)) {
                try {
                    this.mExtObject = new JSONObject(this.mExtInfo);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(this.mInfo.swan)) {
                try {
                    this.mSwanObject = new JSONObject(this.mInfo.swan);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            try {
                if (TextUtils.isEmpty(this.mInfo.target)) {
                    this.isShowUgcTag = true;
                    return;
                }
                JSONObject jSONObject = new JSONObject(this.mInfo.target);
                String optString = jSONObject.optString("ugcpk");
                String optString2 = jSONObject.optString("at");
                String optString3 = jSONObject.optString("tag");
                String optString4 = jSONObject.optString("vote");
                String optString5 = jSONObject.optString("ext");
                if (this.mTarget == null) {
                    this.mTarget = new UGCTarget();
                }
                if (TextUtils.isEmpty(optString)) {
                    this.mPublishView.hidePKContainer();
                } else {
                    this.mTarget.mUgcPKInfo = (UgcPKInfo) new Gson().fromJson(optString, (Class<Object>) UgcPKInfo.class);
                    if (!TextUtils.isEmpty(this.mTarget.mUgcPKInfo.pkID)) {
                        this.mPublishView.initPKView();
                    }
                }
                if (!TextUtils.isEmpty(optString3)) {
                    this.isShowUgcTag = false;
                    this.mTarget.tagList = (List) new Gson().fromJson(optString3, new a<List<UgcTagItem>>() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.1
                    }.getType());
                } else {
                    this.isShowUgcTag = true;
                }
                if (!TextUtils.isEmpty(optString2)) {
                    this.mTarget.mUserInfoList = (List) new Gson().fromJson(optString2, new a<List<AtUserInfoItem>>() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.2
                    }.getType());
                }
                if (!TextUtils.isEmpty(optString4)) {
                    UGCTarget uGCTarget = this.mTarget;
                    UgcVoteInfo ugcVoteInfo = (UgcVoteInfo) new Gson().fromJson(optString4, (Class<Object>) UgcVoteInfo.class);
                    uGCTarget.mUgcVoteInfo = ugcVoteInfo;
                    this.ugcVoteInfo = ugcVoteInfo;
                    if (this.ugcVoteInfo.voteOptions != null && this.ugcVoteInfo.voteOptions.size() > 0) {
                        this.mPublishView.showVoteView(this.ugcVoteInfo);
                    }
                }
                if (!TextUtils.isEmpty(optString5)) {
                    this.mTarget.extInfo = (JsonObject) new Gson().fromJson(optString5, (Class<Object>) JsonObject.class);
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    public void initView(TextView textView, final EmojiconEditText emojiconEditText, ImageView imageView, ImageView imageView2) {
        if (!TextUtils.isEmpty(this.mTopicSelectPageScheme)) {
            UiBaseUtils.setVisibility(imageView, 0);
        }
        if (!TextUtils.isEmpty(this.mAtPageScheme)) {
            UiBaseUtils.setVisibility(imageView2, 0);
        }
        if (emojiconEditText != null) {
            emojiconEditText.setSelectListener(new EmojiconEditText.TextSelectChangedListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.3
                @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextSelectChangedListener
                public void selectChanged(int i, int i2) {
                    if (!TextUtils.isEmpty(BasePublishPresenter.this.mTopicName)) {
                        if (i < BasePublishPresenter.this.mTopicName.length() || i2 < BasePublishPresenter.this.mTopicName.length()) {
                            if (emojiconEditText.getText().toString().length() < BasePublishPresenter.this.mTopicName.length()) {
                                BasePublishPresenter.this.mTopicName = null;
                                if (BasePublishPresenter.this.mTopicRule != null) {
                                    BasePublishPresenter.this.mTopicRule.setPageTopicName(BasePublishPresenter.this.mTopicName);
                                    return;
                                }
                                return;
                            }
                            emojiconEditText.setSelection(Math.max(BasePublishPresenter.this.mTopicName.length(), i), Math.max(BasePublishPresenter.this.mTopicName.length(), i2));
                        }
                    }
                }
            });
        }
        if (emojiconEditText != null) {
            emojiconEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    int length;
                    return i == 67 && keyEvent.getAction() == 0 && !TextUtils.isEmpty(BasePublishPresenter.this.mTopicName) && emojiconEditText.getSelectionStart() <= (length = BasePublishPresenter.this.mTopicName.length()) && emojiconEditText.getSelectionEnd() <= length;
                }
            });
        }
        if (emojiconEditText != null) {
            this.mAtRule = new AtRule(emojiconEditText);
            emojiconEditText.addRule("@", this.mAtRule);
            this.mAtRule.setPatternTag('@');
            this.mAtRule.setPatternTagInputListener(new BasePatternRule.PatternTagInputListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.5
                @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule.PatternTagInputListener
                public void onPatternTagInput() {
                    if (!TextUtils.isEmpty(BasePublishPresenter.this.mAtPageScheme)) {
                        if (PublisherConfig.getPublisherVersion() == 1) {
                            UgcUiUtils.callAtPage(BasePublishPresenter.this.mPublishView.getContext(), BasePublishPresenter.this.mAtPageScheme, new b<AtSelectEvent>() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.5.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // rx.functions.b
                                public void call(AtSelectEvent atSelectEvent) {
                                    if (atSelectEvent != null && atSelectEvent.mAtUserInfoItem != null) {
                                        int selectionStart = emojiconEditText.getSelectionStart();
                                        emojiconEditText.getEditableText().delete(selectionStart - 1, selectionStart);
                                        EmojiconHandler.addAt(emojiconEditText, new AtUserInfoItem(atSelectEvent.mAtUserInfoItem.nickname, atSelectEvent.mAtUserInfoItem.uk), BasePublishPresenter.this.mAtRule);
                                        EventBusWrapper.unregister(BasePublishPresenter.this.mPublishView.getContext());
                                    }
                                }
                            });
                            return;
                        }
                        String str = BasePublishPresenter.this.mAtPageScheme;
                        if (BasePublishPresenter.this.mCallType == 2) {
                            str = BasePublishPresenter.this.getUrlFromSchemeUri(BasePublishPresenter.this.mAtPageScheme);
                        }
                        BasePublishPresenter.this.mPublisherInterfaceManager.selectAt(BasePublishPresenter.this.mPublishView.getContext(), str, new SelectAtListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.5.2
                            @Override // com.baidu.searchbox.publisher.controller.listener.SelectAtListener
                            public void callbackAt(AtUserInfoItem atUserInfoItem) {
                                if (emojiconEditText != null) {
                                    int selectionStart = emojiconEditText.getSelectionStart();
                                    emojiconEditText.getEditableText().delete(selectionStart - 1, selectionStart);
                                    if (emojiconEditText != null) {
                                        EmojiconHandler.addAt(emojiconEditText, atUserInfoItem, BasePublishPresenter.this.mAtRule);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
        if (emojiconEditText != null) {
            this.mTopicRule = new TopicRule(emojiconEditText);
            this.mTopicRule.setPatternTag('#');
            this.mTopicRule.setPatternTagInputListener(new BasePatternRule.PatternTagInputListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.6
                @Override // com.baidu.searchbox.ugc.emoji.edittextrule.BasePatternRule.PatternTagInputListener
                public void onPatternTagInput() {
                    if (!TextUtils.isEmpty(BasePublishPresenter.this.mTopicSelectPageScheme)) {
                        if (PublisherConfig.getPublisherVersion() == 1) {
                            UgcUiUtils.callTopicSelectPage(BasePublishPresenter.this.mPublishView.getContext(), BasePublishPresenter.this.mTopicSelectPageScheme, new b<TopicSelectEvent>() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // rx.functions.b
                                public void call(TopicSelectEvent topicSelectEvent) {
                                    if (topicSelectEvent != null && topicSelectEvent.mTopicItem != null) {
                                        if (BasePublishPresenter.DEBUG) {
                                            Log.e(BasePublishPresenter.TAG, "TopicItem:id" + topicSelectEvent.mTopicItem.id + "，name:" + topicSelectEvent.mTopicItem.name);
                                        }
                                        int selectionStart = emojiconEditText.getSelectionStart();
                                        emojiconEditText.getEditableText().delete(selectionStart - 1, selectionStart);
                                        EmojiconHandler.addTopic(emojiconEditText, new TopicItem(topicSelectEvent.mTopicItem.name, topicSelectEvent.mTopicItem.id), BasePublishPresenter.this.mTopicRule);
                                        EventBusWrapper.unregister(BasePublishPresenter.this.mPublishView.getContext());
                                    }
                                }
                            });
                            return;
                        }
                        String str = BasePublishPresenter.this.mTopicSelectPageScheme;
                        if (BasePublishPresenter.this.mCallType == 2) {
                            str = BasePublishPresenter.this.getUrlFromSchemeUri(BasePublishPresenter.this.mTopicSelectPageScheme);
                        }
                        BasePublishPresenter.this.mPublisherInterfaceManager.selectTopic(BasePublishPresenter.this.mPublishView.getContext(), str, new SelectTopicListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.6.2
                            @Override // com.baidu.searchbox.publisher.controller.listener.SelectTopicListener
                            public void callbackTopic(TopicItem topicItem) {
                                if (emojiconEditText != null) {
                                    int selectionStart = emojiconEditText.getSelectionStart();
                                    emojiconEditText.getEditableText().delete(selectionStart - 1, selectionStart);
                                }
                                if (emojiconEditText != null) {
                                    EmojiconHandler.addTopic(emojiconEditText, topicItem, BasePublishPresenter.this.mTopicRule);
                                }
                            }
                        });
                    }
                }
            });
            emojiconEditText.addRule("#", this.mTopicRule);
        }
        if (!TextUtils.isEmpty(this.mTopicName)) {
            if (this.mPublishView.getContext() instanceof VideoPublishActivity) {
                EmojiconHandler.setAddTopicItemListener(this.mTopicRule.mAddTopicItemListener);
                EmojiconHandler.addTopic(emojiconEditText, new TopicItem(this.mTopicName, this.mTopicId), this.mTopicRule);
            } else {
                if (this.mTopicRule != null) {
                    this.mTopicRule.setPageTopicName(this.mTopicName);
                }
                UiBaseUtils.setTextString(emojiconEditText, this.mTopicName);
            }
            if (this.mInfo != null && !TextUtils.isEmpty(this.mInfo.placeContent)) {
                if (emojiconEditText != null) {
                    emojiconEditText.append(this.mInfo.placeContent);
                }
                if (this.mTarget != null && this.mTarget.mUserInfoList != null && this.mTarget.mUserInfoList.size() > 0) {
                    this.mAtRule.setRuleFromUserInfoList(this.mTarget.mUserInfoList);
                    this.mAtRule.highLightMatchString();
                }
            }
            if (emojiconEditText != null) {
                emojiconEditText.setSelection(emojiconEditText.getEditableText().toString().length());
            }
        } else if (emojiconEditText != null) {
            if (!TextUtils.isEmpty(this.mInfo.placeContent)) {
                UiBaseUtils.setTextString(emojiconEditText, this.mInfo.placeContent);
                emojiconEditText.setSelection(emojiconEditText.length());
            } else if (!TextUtils.isEmpty(this.mPlaceholder)) {
                emojiconEditText.setHint(this.mPlaceholder);
            } else {
                emojiconEditText.setHint(R.string.ugc_publish_hint_text);
            }
        }
    }

    public void initEmotionPanel(ViewGroup viewGroup, final SPSwitchPanelLinearLayout sPSwitchPanelLinearLayout, EmojiconEditText emojiconEditText, final ImageView imageView, Window window, final TextView textView) {
        if (sPSwitchPanelLinearLayout != null || emojiconEditText != null) {
            e.a(this.mPublishView.getContext(), viewGroup, sPSwitchPanelLinearLayout, new e.a() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.7
                @Override // com.baidu.spswitch.b.e.a
                public void onSoftInputShowing(boolean z) {
                    if (z) {
                        BasePublishPresenter.this.mIsShowSoftInput = z;
                        UgcUiUtils.setImageResource(imageView, BasePublishPresenter.this.mEmojiDrawable);
                    }
                }
            });
            c.a(window, sPSwitchPanelLinearLayout, imageView, emojiconEditText, new c.a() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.8
                @Override // com.baidu.spswitch.b.c.a
                public void onClickSwitch(View view, boolean z) {
                    BasePublishPresenter.this.switchToPanel(sPSwitchPanelLinearLayout, z);
                    if (z) {
                        UgcUiUtils.setImageResource(imageView, BasePublishPresenter.this.mKeyboardDrawable);
                        UiBaseUtils.setVisibility(textView, 8);
                        UgcSpWrapper.getInstance().putString("ugc_publish_emoji_tips", "emoji");
                        if (TextUtils.equals(BasePublishPresenter.this.mInfo.publishType, "5")) {
                            UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_EMOJI_CLICK, null, UgcUBCUtils.PUBLISH_FORWARD_PAGE);
                            return;
                        } else {
                            UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_EMOJI_CLICK, null, "publish");
                            return;
                        }
                    }
                    UgcUiUtils.setImageResource(imageView, BasePublishPresenter.this.mEmojiDrawable);
                }
            });
            com.baidu.spswitch.b.b.init(AppConfig.isDebug());
            loadInnerEmotionPanel(sPSwitchPanelLinearLayout, emojiconEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void switchToPanel(View view, boolean z) {
    }

    protected void loadInnerEmotionPanel(SPSwitchPanelLinearLayout sPSwitchPanelLinearLayout, EmojiconEditText emojiconEditText) {
        com.baidu.spswitch.b.a.Go().a(this.mPublishView.getContext(), sPSwitchPanelLinearLayout, emojiconEditText, UgcRuntime.getUgcInterface().getNightModeSwitcherState());
        com.baidu.spswitch.b.a.Go().a(new a.InterfaceC0194a() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.9
            @Override // com.baidu.spswitch.b.a.InterfaceC0194a
            public void onEmotionClick(EmotionType emotionType, int i, String str, String str2) {
                if (!TextUtils.isEmpty(str)) {
                    UgcUBCUtils.emotionUbcStatistics(BasePublishPresenter.this.mSourceFrom, BasePublishPresenter.this.mPublishView.getContext() instanceof ForwardPublishActivity, str);
                }
            }
        });
        e.a(emojiconEditText, 300L);
    }

    protected int getInputWordLimit(String str) {
        String str2 = null;
        if (this.mInfo != null && !TextUtils.isEmpty(this.mInfo.publishLimit)) {
            try {
                JSONObject optJSONObject = new JSONObject(this.mInfo.publishLimit).optJSONObject(this.mInfo.publishType);
                if (optJSONObject != null) {
                    str2 = optJSONObject.optString("wordLimit");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return UgcDataUtil.getWordLimit(str2, str);
    }

    public int getDynamicWordLimit(String str) {
        return !TextUtils.isEmpty(str) ? this.inputVideoLimit : this.inputImgTextLimit;
    }

    public void setClickState(TextView textView, boolean z) {
        this.mEnableClick = z;
        if (this.mEnableClick) {
            UgcUiUtils.setTextResource(textView, R.color.ugc_publish_action_color);
        } else {
            UgcUiUtils.setTextResource(textView, R.color.ugc_publish_no_able_color);
        }
    }

    public void initInputState(EmojiconEditText emojiconEditText, TextView textView, int i) {
        if (emojiconEditText != null) {
            if (textView != null) {
                UiBaseUtils.setTextString(textView, String.format(this.mPublishView.getContext().getString(R.string.ugc_input_number_count), Integer.valueOf(emojiconEditText.length()), Integer.valueOf(i)));
            }
            emojiconEditText.setMaxSize(i);
        }
    }

    public void setInputState(EmojiconEditText emojiconEditText, TextView textView, TextView textView2, int i) {
        emojiconEditText.setMaxSize(i);
        if (emojiconEditText.length() < i - 20) {
            textView.setVisibility(8);
        } else if (emojiconEditText.length() < i) {
            textView.setVisibility(0);
            textView.setText(this.mPublishView.getContext().getString(R.string.ugc_reply_input_left_count_hint, new Object[]{Integer.valueOf(i - emojiconEditText.length())}));
            UgcUiUtils.setTextResource(textView, R.color.ugc_reply_input_count_normal_color);
        } else if (emojiconEditText.length() > i && emojiconEditText.length() < i + 1000) {
            textView.setVisibility(0);
            textView.setText(this.mPublishView.getContext().getString(R.string.ugc_reply_input_over_count_hint, new Object[]{Integer.valueOf(i - emojiconEditText.length())}));
            UgcUiUtils.setTextResource(textView, R.color.ugc_reply_input_count_over_color);
            setClickState(textView2, false);
        } else {
            textView.setVisibility(0);
            textView.setText(R.string.ugc_reply_input_over_999_hint);
            UgcUiUtils.setTextResource(textView, R.color.ugc_reply_input_count_over_color);
            setClickState(textView2, false);
        }
    }

    public UGCTarget getTarget() {
        return this.mTarget;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUrlFromSchemeUri(String str) {
        return new UnitedSchemeEntity(Uri.parse(str)).getParam("url");
    }

    public void setUgcTagScheme(String str) {
        this.mUgcTagScheme = str;
    }

    public void onDestroy(EmojiconEditText emojiconEditText) {
        this.mPublisherInterfaceManager = null;
        emojiconEditText.clearData();
        com.baidu.spswitch.b.a.Go().dismiss();
    }

    public void onBackPressed(EmojiconEditText emojiconEditText) {
        if (emojiconEditText != null) {
            e.aa(emojiconEditText);
        }
    }

    public void getUgcTagData() {
        if (NetWorkUtils.isNetworkConnected() && this.isShowUgcTag && this.mInfo.sourceType != 1) {
            new UgcTagDisplayModel().displayUgcTag(new UgcTagDisplayModel.UgcTagRequestCallback() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.10
                @Override // com.baidu.searchbox.ugc.model.UgcTagDisplayModel.UgcTagRequestCallback
                public void onSuccess(UgcTagDisplayModel ugcTagDisplayModel) {
                    if (ugcTagDisplayModel != null) {
                        BasePublishPresenter.this.mPublishView.initUgcTagView(ugcTagDisplayModel);
                        UgcUBCUtils.recordUgcTagStatistics("interest_show", BasePublishPresenter.this.mInfo.sourceFrom);
                    }
                }

                @Override // com.baidu.searchbox.ugc.model.UgcTagDisplayModel.UgcTagRequestCallback
                public void onFailed(String str) {
                }
            });
        }
    }

    public String getPublishType() {
        return this.mInfo.publishType;
    }

    public String getSourceFrom() {
        return this.mSourceFrom;
    }

    public void onTopicSelect(final EmojiconEditText emojiconEditText) {
        if (!TextUtils.isEmpty(this.mTopicSelectPageScheme)) {
            if (PublisherConfig.getPublisherVersion() == 1) {
                UgcUiUtils.callTopicSelectPage(this.mPublishView.getContext(), this.mTopicSelectPageScheme, new b<TopicSelectEvent>() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.11
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(TopicSelectEvent topicSelectEvent) {
                        if (topicSelectEvent != null && topicSelectEvent.mTopicItem != null) {
                            if (BasePublishPresenter.DEBUG) {
                                Log.e(BasePublishPresenter.TAG, "TopicItem:id" + topicSelectEvent.mTopicItem.id + "，name:" + topicSelectEvent.mTopicItem.name);
                            }
                            TopicItem topicItem = new TopicItem(topicSelectEvent.mTopicItem.name, topicSelectEvent.mTopicItem.id);
                            if (emojiconEditText != null) {
                                EmojiconHandler.addTopic(emojiconEditText, topicItem, BasePublishPresenter.this.mTopicRule);
                            }
                            EventBusWrapper.unregister(BasePublishPresenter.this.mPublishView.getContext());
                            BasePublishPresenter.this.onSelectAtOrTopic();
                        }
                    }
                });
            } else {
                String str = this.mTopicSelectPageScheme;
                if (this.mCallType == 2) {
                    str = getUrlFromSchemeUri(this.mTopicSelectPageScheme);
                }
                this.mPublisherInterfaceManager.selectTopic(this.mPublishView.getContext(), str, new SelectTopicListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.12
                    @Override // com.baidu.searchbox.publisher.controller.listener.SelectTopicListener
                    public void callbackTopic(TopicItem topicItem) {
                        if (emojiconEditText != null) {
                            EmojiconHandler.addTopic(emojiconEditText, topicItem, BasePublishPresenter.this.mTopicRule);
                        }
                    }
                });
            }
            if (TextUtils.equals(this.mInfo.publishType, "5")) {
                UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_TOPIC_CLICK, null, UgcUBCUtils.PUBLISH_FORWARD_PAGE);
            } else {
                UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_TOPIC_CLICK, null, "publish");
            }
        }
    }

    public void onATSelect(final EmojiconEditText emojiconEditText) {
        if (!TextUtils.isEmpty(this.mAtPageScheme)) {
            if (PublisherConfig.getPublisherVersion() == 1) {
                UgcUiUtils.callAtPage(this.mPublishView.getContext(), this.mAtPageScheme, new b<AtSelectEvent>() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.13
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(AtSelectEvent atSelectEvent) {
                        if (atSelectEvent != null && atSelectEvent.mAtUserInfoItem != null) {
                            EmojiconHandler.addAt(emojiconEditText, new AtUserInfoItem(atSelectEvent.mAtUserInfoItem.nickname, atSelectEvent.mAtUserInfoItem.uk), BasePublishPresenter.this.mAtRule);
                            EventBusWrapper.unregister(BasePublishPresenter.this.mPublishView.getContext());
                            BasePublishPresenter.this.onSelectAtOrTopic();
                        }
                    }
                });
            } else {
                String str = this.mAtPageScheme;
                if (this.mCallType == 2) {
                    str = getUrlFromSchemeUri(this.mAtPageScheme);
                }
                this.mPublisherInterfaceManager.selectAt(this.mPublishView.getContext(), str, new SelectAtListener() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.14
                    @Override // com.baidu.searchbox.publisher.controller.listener.SelectAtListener
                    public void callbackAt(AtUserInfoItem atUserInfoItem) {
                        if (emojiconEditText != null) {
                            EmojiconHandler.addAt(emojiconEditText, atUserInfoItem, BasePublishPresenter.this.mAtRule);
                        }
                    }
                });
            }
            if (TextUtils.equals(this.mInfo.publishType, "5")) {
                UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_AT_CLICK, null, UgcUBCUtils.PUBLISH_FORWARD_PAGE);
            } else {
                UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_AT_CLICK, null, "publish");
            }
        }
    }

    protected void onSelectAtOrTopic() {
    }

    public String getUgcTagScheme() {
        return this.mUgcTagScheme;
    }

    public void publishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        String str = null;
        if (publishResultInfo != null && publishResultInfo.data != null) {
            str = publishResultInfo.data.errmsg;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPublishView.getContext().getString(R.string.ugc_release_success);
        }
        if (TextUtils.equals(this.mSourceFrom, "shouye")) {
            BaseRouter.invoke(this.mPublishView.getContext(), HOME_FOLLOW_TAB_SCHEMA);
            if (publishResultInfo != null && UgcRuntime.getUgcInterface() != null) {
                UgcRuntime.getUgcInterface().setUgcRNInitData(this.mPublishView.getContext(), publishResultInfo.requestId);
            }
            if (this.mInfo.showToast == 0 || this.mInfo.showToast == 2) {
                UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
                return;
            }
            return;
        }
        if (!TextUtils.equals(this.mInfo.publishType, "5") && (this.mInfo.showToast == 0 || this.mInfo.showToast == 2)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
        }
        if (!TextUtils.isEmpty(this.mUgcCallback)) {
            if (publishResultInfo != null) {
                UnitedSchemeUGCDispatcher.handleCallback(this.mUgcCallback, publishResultInfo.requestId);
            }
        } else {
            CallbackHandler callbackHandler = UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.get("publish");
            UnitedSchemeUGCDispatcher.sSchemeCallbackHandlerMap.remove("publish");
            if (callbackHandler != null && (callbackHandler instanceof NullableCallbackHandler) && publishResultInfo != null) {
                Sender.sendBroadcast(this.mPublishView.getContext(), "com.baidu.channel.talos.schemesecondcallback", publishResultInfo.requestId);
            }
        }
        UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
    }

    public void publishFail(String str) {
        FastPublishUtils.publishFail(str, this.mInfo);
    }

    public void addTargetRule(final EmojiconEditText emojiconEditText) {
        new Handler(this.mPublishView.getContext().getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.searchbox.ugc.presenter.BasePublishPresenter.15
            @Override // java.lang.Runnable
            public void run() {
                if (BasePublishPresenter.this.mTarget != null) {
                    if (BasePublishPresenter.this.mTarget.mLinkInfoList != null && BasePublishPresenter.this.mTarget.mLinkInfoList.size() > 0 && emojiconEditText != null) {
                        BasePublishPresenter.this.mLinkRule = new LinkRule(emojiconEditText);
                        emojiconEditText.addRule("[网页链接]", BasePublishPresenter.this.mLinkRule);
                        BasePublishPresenter.this.mLinkRule.setLinkInfoItemList(BasePublishPresenter.this.mTarget.mLinkInfoList);
                        BasePublishPresenter.this.mLinkRule.formatLinkStrRange();
                    }
                    if (BasePublishPresenter.this.mAtRule != null && BasePublishPresenter.this.mTarget.mUserInfoList != null && BasePublishPresenter.this.mTarget.mUserInfoList.size() > 0) {
                        BasePublishPresenter.this.mAtRule.setRuleFromUserInfoList(BasePublishPresenter.this.mTarget.mUserInfoList);
                        BasePublishPresenter.this.mAtRule.highLightMatchString();
                    }
                    if (BasePublishPresenter.this.mTopicRule != null && BasePublishPresenter.this.mTarget.mTopicList != null && BasePublishPresenter.this.mTarget.mTopicList.size() > 0) {
                        BasePublishPresenter.this.mTopicRule.setRuleFromTopicList(BasePublishPresenter.this.mTarget.mTopicList);
                        BasePublishPresenter.this.mTopicRule.highLightMatchString();
                    }
                }
            }
        }, 150L);
    }

    public String getTargetJson() {
        if (this.mTarget == null) {
            this.mTarget = new UGCTarget();
        }
        if (this.mTopicRule != null) {
            this.mTopicRule.obtainTopicList(this.mTarget.mTopicList);
        }
        if (this.mAtRule != null) {
            this.mAtRule.obtainUserInfoList(this.mTarget.mUserInfoList);
        }
        return new Gson().toJson(this.mTarget);
    }

    public void basePublish() {
        UgcVoteInfo.VoteOption voteOption = null;
        if (this.ugcVoteInfo != null && this.ugcVoteInfo.voteOptions != null && this.ugcVoteInfo.voteOptions.size() > 0) {
            this.ugcVoteInfo.voteTitle = null;
            this.ugcVoteInfo.voteOptions = this.mPublishView.getVoteOption();
            int i = 0;
            while (i < this.ugcVoteInfo.voteOptions.size()) {
                UgcVoteInfo.VoteOption voteOption2 = "1".equals(this.ugcVoteInfo.voteOptions.get(i).voteTagState) ? this.ugcVoteInfo.voteOptions.get(i) : voteOption;
                i++;
                voteOption = voteOption2;
            }
            this.ugcVoteInfo.voteOptions.clear();
            if (voteOption != null) {
                this.ugcVoteInfo.voteOptions.add(voteOption);
            }
            if (this.ugcVoteInfo.voteOptions.size() == 1 && this.mTarget.mUgcVoteInfo.voteOptions.get(0) != null) {
                clearInvalidField(this.mTarget.mUgcVoteInfo.voteOptions.get(0));
            }
            this.mTarget.mUgcVoteInfo = this.ugcVoteInfo;
        }
    }

    private void clearInvalidField(UgcVoteInfo.VoteOption voteOption) {
        voteOption.voteTagState = null;
        voteOption.voteValue = null;
    }
}
