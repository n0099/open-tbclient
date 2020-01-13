package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.model.UgcTagDisplayModel;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.baidu.searchbox.ugc.model.UgcTagSelectEvent;
import com.baidu.searchbox.ugc.model.UgcVoteInfo;
import com.baidu.searchbox.ugc.presenter.BasePublishPresenter;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcSpWrapper;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.view.VoteOptionsView;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.b.c;
import com.baidu.spswitch.b.e;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.spswitch.view.SPSwitchRootLinearLayout;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import rx.functions.b;
/* loaded from: classes12.dex */
public abstract class PublishBaseActivity<T extends BasePublishPresenter> extends BaseActivity implements View.OnClickListener, IPublishView {
    public static final int DURATION = 300;
    public TextView mAddDescription;
    public ImageView mAlbumEntrance;
    public ViewStub mAskQuestionTitleLayout;
    public ImageView mAtIv;
    protected View mBottomLine;
    private int mBottomNavigationKeyHeight;
    public TextView mCancel;
    public View mContentTopLine;
    private Context mContext;
    public ImageView mEmoijImg;
    public boolean mEmojiIsShowing;
    public TextView mEmojiTipsTv;
    public EmojiconEditText mInput;
    private int mInputMethodHeight;
    private boolean mIsFirstGlobalLayout;
    public TextView mNumberTv;
    public LinearLayout mPKContainer;
    public ViewStub mPKContainerViewStub;
    public TextView mPKPointViewTv;
    public TextView mPKTitleTv;
    private SPSwitchPanelLinearLayout mPanelRoot;
    public TextView mPublishTv;
    public RelativeLayout mPublishView;
    public SPSwitchRootLinearLayout mRootView;
    public ScrollView mScrollow;
    public TextView mTitle;
    public ImageView mTopicSelectIv;
    public ImageView mVideoEntrance;
    private HorizontalScrollView mVoteScrollView;
    private TextView mVoteTitle;
    private VoteOptionsView mVoteView;
    private ViewStub mVoteViewStub;
    public LinearLayout tagContainer;
    public ImageView tagDeleteView;
    public View tagDividedView;
    public TextView tagNameView;
    public ViewStub tagViewStub;
    public UgcTagItem ugcTag;
    public static final String TAG = PublishBaseActivity.class.getSimpleName();
    public static final boolean DEBUG = AppConfig.isDebug();
    public boolean mKeyboardShowing = true;
    private int mLastVisibleHeight = -1;
    protected T mPublishPresenter = getPresenter();

    protected abstract T getPresenter();

    protected abstract void onCancel(String str);

    protected abstract void onEnterAlbum();

    protected abstract void onPublish(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setContentView(R.layout.ugc_publish_base_layout);
        UgcSchemeModel ugcSchemeModel = null;
        Intent intent = getIntent();
        if (intent != null) {
            ugcSchemeModel = (UgcSchemeModel) intent.getSerializableExtra("data");
        }
        this.mPublishPresenter.onCreate(ugcSchemeModel);
        initView();
        this.mPublishPresenter.initView(this.mNumberTv, this.mInput, this.mTopicSelectIv, this.mAtIv);
        if (PublisherConfig.getPublisherVersion() == 1) {
            this.mPublishPresenter.getUgcTagData();
        }
        if (PublisherConfig.getIsShowEmojiTips()) {
            initPublishEmojiTips();
        }
        updateUi();
        setEnableImmersion(false);
        SelectUtil.isWenda(false);
        this.mPublishPresenter.initEmotionPanel((ViewGroup) findViewById(16908290), this.mPanelRoot, this.mInput, this.mEmoijImg, getWindow(), this.mEmojiTipsTv);
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.mInput != null) {
            e.aa(this.mInput);
        }
        overridePendingTransition(0, R.anim.ugc_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mPublishPresenter.onResume(this.mInput);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mPublishPresenter.onDestroy(this.mInput);
        UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.mPublishPresenter.onBackPressed(this.mInput);
        UnitedSchemeUGCDispatcher.cleanSchemeHandlerMap();
    }

    public void baseSetContentView(int i) {
        LinearLayout linearLayout = (LinearLayout) findViewById(ResourceUtils.getResIdByName("ugc_content"));
        if (linearLayout != null) {
            View.inflate(this, i, linearLayout);
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showVoteView(UgcVoteInfo ugcVoteInfo) {
        if (ugcVoteInfo != null) {
            if (this.mVoteViewStub == null) {
                this.mVoteViewStub = (ViewStub) findViewById(ResourceUtils.getResIdByName("ugc_vote_view_stub"));
            }
            if (this.mVoteViewStub != null) {
                this.mVoteViewStub.inflate();
            }
            this.mVoteTitle = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_vote_title"));
            this.mContentTopLine = findViewById(ResourceUtils.getResIdByName("ugc_content_top_line"));
            if (this.mContentTopLine != null) {
                this.mContentTopLine.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.ugc_vote_line_color));
                UiBaseUtils.setVisibility(this.mContentTopLine, 0);
            }
            if (!TextUtils.isEmpty(ugcVoteInfo.voteTitle) && ugcVoteInfo.voteTitle.length() > 6) {
                ugcVoteInfo.voteTitle = ugcVoteInfo.voteTitle.substring(0, 5);
            }
            UiBaseUtils.setTextString(this.mVoteTitle, TextUtils.isEmpty(ugcVoteInfo.voteTitle) ? getString(R.string.ugc_vote_title) : ugcVoteInfo.voteTitle);
            this.mVoteView = (VoteOptionsView) findViewById(ResourceUtils.getResIdByName("ugc_vote_layout"));
            if (this.mVoteView != null) {
                this.mVoteView.initLayout(ugcVoteInfo);
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void initUgcTagView(UgcTagDisplayModel ugcTagDisplayModel) {
        if (this.mRootView != null) {
            this.tagViewStub = (ViewStub) this.mRootView.findViewById(ResourceUtils.getResIdByName("ugc_tag_view_stub"));
            if (this.tagViewStub != null) {
                if (this.tagContainer == null) {
                    this.tagContainer = (LinearLayout) this.tagViewStub.inflate();
                }
                if (this.tagContainer != null) {
                    this.tagNameView = (TextView) this.tagContainer.findViewById(ResourceUtils.getResIdByName("ugc_tag_name_tv"));
                    this.tagDeleteView = (ImageView) this.tagContainer.findViewById(ResourceUtils.getResIdByName("ugc_tag_delete_iv"));
                    this.tagDividedView = this.tagContainer.findViewById(ResourceUtils.getResIdByName("ugc_tag_divided_view"));
                    UiBaseUtils.setOnClickListener(this.tagNameView, this);
                    UiBaseUtils.setOnClickListener(this.tagDeleteView, this);
                    try {
                        if (!TextUtils.isEmpty(ugcTagDisplayModel.tagName) && !TextUtils.isEmpty(ugcTagDisplayModel.tagScheme) && Integer.valueOf(ugcTagDisplayModel.tagNum).intValue() > 0) {
                            DefaultSharedPrefsWrapper.getInstance().putString("ugc_tag_default_name", ugcTagDisplayModel.tagName);
                            this.mPublishPresenter.setUgcTagScheme(ugcTagDisplayModel.tagScheme);
                            UiBaseUtils.setVisibility(this.tagContainer, 0);
                            UiBaseUtils.setVisibility(this.tagDividedView, 8);
                            UiBaseUtils.setVisibility(this.tagDeleteView, 8);
                            Drawable drawable = getResources().getDrawable(R.drawable.ugc_tag_select);
                            UiBaseUtils.setTextString(this.tagNameView, ugcTagDisplayModel.tagName);
                            if (this.tagNameView != null) {
                                this.tagNameView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                            }
                            UgcUiUtils.setViewDrawable(this.tagNameView, R.drawable.ugc_tag_rounded_corner_selector);
                            UgcUiUtils.setViewDrawable(this.tagDeleteView, R.drawable.ugc_tag_right_rounded_corner_selector);
                            UgcUiUtils.setViewColor(this.tagDividedView, R.color.ugc_tag_divided_bg_color);
                            return;
                        }
                        UiBaseUtils.setVisibility(this.tagContainer, 8);
                    } catch (NumberFormatException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void hidePKContainer() {
        if (this.mPKContainer != null) {
            UiBaseUtils.setVisibility(this.mPKContainer, 8);
        }
    }

    private void initView() {
        this.mRootView = (SPSwitchRootLinearLayout) findViewById(ResourceUtils.getResIdByName("ugc_publish_root"));
        this.mScrollow = (ScrollView) findViewById(ResourceUtils.getResIdByName("ugc_scrollow"));
        this.mInput = (EmojiconEditText) findViewById(ResourceUtils.getResIdByName("ugc_edittext"));
        this.mEmoijImg = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_emoij"));
        this.mTopicSelectIv = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_topic"));
        this.mAtIv = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_at"));
        this.mAlbumEntrance = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_pic_entrance"));
        this.mVideoEntrance = (ImageView) findViewById(ResourceUtils.getResIdByName("ugc_video_entrance"));
        this.mNumberTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_text_number"));
        this.mTitle = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_publish_title"));
        this.mPublishTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_publish"));
        this.mCancel = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_publish_cancel"));
        UiBaseUtils.setOnClickListener(this.mTopicSelectIv, this);
        UiBaseUtils.setOnClickListener(this.mAtIv, this);
        UiBaseUtils.setOnClickListener(this.mPublishTv, this);
        UiBaseUtils.setOnClickListener(this.mCancel, this);
        this.mPanelRoot = (SPSwitchPanelLinearLayout) findViewById(ResourceUtils.getResIdByName("ugc_panel_root"));
        this.mBottomLine = findViewById(ResourceUtils.getResIdByName("ugc_panel_root"));
        this.mAskQuestionTitleLayout = (ViewStub) findViewById(ResourceUtils.getResIdByName("ugc_ask_question_title_layout"));
        this.mAddDescription = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_ask_add_description"));
        this.mContentTopLine = findViewById(ResourceUtils.getResIdByName("ugc_content_top_line"));
        this.mPublishView = (RelativeLayout) findViewById(ResourceUtils.getResIdByName("ugc_publish_view"));
        UiBaseUtils.setOnClickListener(this.mAlbumEntrance, this);
        UiBaseUtils.setOnClickListener(this.mVideoEntrance, this);
        UiBaseUtils.setOnTouchListener(this.mScrollow, new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.activity.PublishBaseActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PublishBaseActivity.this.changeSoftState();
                    return false;
                }
                return false;
            }
        });
        UgcUiUtils.setEditResource(this.mInput, R.color.ugc_black);
        this.mPublishTv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.activity.PublishBaseActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                UgcUiUtils.setTouchAlpha(view, motionEvent);
                return false;
            }
        });
        this.mCancel.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.activity.PublishBaseActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                UgcUiUtils.setTouchAlpha(view, motionEvent);
                return false;
            }
        });
    }

    private void initPublishEmojiTips() {
        this.mEmojiTipsTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_publish_emoji_tip"));
        if (!TextUtils.equals(UgcSpWrapper.getInstance().getString("ugc_publish_emoji_tips", ""), "emoji")) {
            UiBaseUtils.setVisibility(this.mEmojiTipsTv, 0);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.PublishBaseActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    UiBaseUtils.setVisibility(PublishBaseActivity.this.mEmojiTipsTv, 8);
                    UgcSpWrapper.getInstance().putString("ugc_publish_emoji_tips", "emoji");
                }
            }, 7000L);
        }
        UiBaseUtils.setOnClickListener(this.mEmojiTipsTv, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.PublishBaseActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UiBaseUtils.setVisibility(PublishBaseActivity.this.mEmojiTipsTv, 8);
                UgcSpWrapper.getInstance().putString("ugc_publish_emoji_tips", "emoji");
            }
        });
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void initPKView() {
        UGCTarget target = this.mPublishPresenter.getTarget();
        if (target == null || target.mUgcPKInfo == null) {
            UiBaseUtils.setVisibility(this.mPKContainer, 8);
            return;
        }
        this.mPKContainerViewStub = (ViewStub) findViewById(ResourceUtils.getResIdByName("viewstub_ugc_pk_container"));
        if (this.mPKContainer == null && this.mPKContainerViewStub != null) {
            this.mPKContainer = (LinearLayout) this.mPKContainerViewStub.inflate();
        }
        if (this.mPKContainer != null) {
            this.mPKContainer.setVisibility(0);
            if (this.mPKTitleTv == null) {
                this.mPKTitleTv = (TextView) this.mPKContainer.findViewById(ResourceUtils.getResIdByName("ugc_pk_title_tv"));
            }
            if (this.mPKPointViewTv == null) {
                this.mPKPointViewTv = (TextView) this.mPKContainer.findViewById(ResourceUtils.getResIdByName("ugc_pk_point_view_tv"));
            }
        }
        UiBaseUtils.setTextString(this.mPKTitleTv, target.mUgcPKInfo.pkTitle);
        if (target.mUgcPKInfo.pkOption == null) {
            UiBaseUtils.setVisibility(this.mPKPointViewTv, 8);
            return;
        }
        UiBaseUtils.setVisibility(this.mPKPointViewTv, 0);
        UgcUiUtils.setViewDrawable(this.mPKPointViewTv, R.drawable.ugc_pk_point_view_bg);
        if (this.mPKContainer != null) {
            UgcUiUtils.setViewColor(this.mPKContainer.findViewById(ResourceUtils.getResIdByName("pk_line")), R.color.ugc_bd_im);
        }
        UiBaseUtils.setTextString(this.mPKPointViewTv, target.mUgcPKInfo.pkOption.pkOptionName);
        if (this.mPKPointViewTv != null) {
            if (UgcRuntime.getUgcInterface().getNightModeSwitcherState()) {
                if (!TextUtils.isEmpty(target.mUgcPKInfo.pkOption.nightOptionTextColor)) {
                    this.mPKPointViewTv.setTextColor(Color.parseColor(target.mUgcPKInfo.pkOption.nightOptionTextColor));
                }
            } else if (!TextUtils.isEmpty(target.mUgcPKInfo.pkOption.optionTextColor)) {
                this.mPKPointViewTv.setTextColor(Color.parseColor(target.mUgcPKInfo.pkOption.optionTextColor));
            }
        }
    }

    private void updateUi() {
        UgcUiUtils.setViewColor(this.mRootView, R.color.ugc_white);
        UgcUiUtils.setViewColor(findViewById(ResourceUtils.getResIdByName("ugc_publish_header")), R.color.ugc_white);
        UgcUiUtils.setTextResource(this.mCancel, R.color.ugc_album_empty_tv_color);
        UgcUiUtils.setTextResource(this.mTitle, R.color.ugc_black);
        UgcUiUtils.setTextResource(this.mPublishTv, R.color.ugc_publish_no_able_color);
        UgcUiUtils.setViewColor(findViewById(ResourceUtils.getResIdByName("ugc_line")), R.color.ugc_album_titleline_color);
        UgcUiUtils.setEditHintResource(this.mInput, R.color.ugc_publish_hint_color);
        UgcUiUtils.setViewColor(findViewById(ResourceUtils.getResIdByName("ugc_publish_line")), R.color.ugc_publish_emoji_line);
        UgcUiUtils.setViewColor(findViewById(ResourceUtils.getResIdByName("ugc_publish_view")), R.color.ugc_white);
        UgcUiUtils.setImageResource(this.mEmoijImg, R.drawable.ugc_switch_soft_emoji_selector);
        UgcUiUtils.setImageResource(this.mAlbumEntrance, R.drawable.ugc_choose_photo_enter_selector);
        UgcUiUtils.setImageResource(this.mVideoEntrance, R.drawable.ugc_choose_video_enter_selector);
        UgcUiUtils.setTextResource(this.mNumberTv, R.color.ugc_album_layer_text_color);
        UgcUiUtils.setImageResource(this.mTopicSelectIv, R.drawable.ugc_topic_select_selector);
        UgcUiUtils.setImageResource(this.mAtIv, R.drawable.ugc_topic_at_selector);
        UgcUiUtils.setViewColor(this.mBottomLine, R.color.ugc_question_reply_line_bg_color);
        UgcUiUtils.setTextResource(this.mEmojiTipsTv, R.color.ugc_emoji_tips_color);
        if (NightModeHelper.getNightModeSwitcherState()) {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.ugc_publish_color_cursor);
            gradientDrawable.setColor(getResources().getColor(R.color.ugc_color_19437F));
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.mInput, gradientDrawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void changeSoftState() {
        if (this.mPanelRoot != null && this.mInput != null) {
            c.f(this.mPanelRoot, this.mInput);
        }
        UgcUiUtils.setImageResource(this.mEmoijImg, R.drawable.ugc_switch_soft_emoji_selector);
    }

    public void setBottomEntrUnableClick() {
        UiBaseUtils.setClickable(this.mEmoijImg, false);
        UiBaseUtils.setClickable(this.mTopicSelectIv, false);
        UiBaseUtils.setClickable(this.mAtIv, false);
        UiBaseUtils.setClickable(this.mAlbumEntrance, false);
        UiBaseUtils.setClickable(this.mVideoEntrance, false);
    }

    public void setBottomEntrAbleClick() {
        UiBaseUtils.setClickable(this.mEmoijImg, true);
        UiBaseUtils.setClickable(this.mTopicSelectIv, true);
        UiBaseUtils.setClickable(this.mAtIv, true);
        UiBaseUtils.setClickable(this.mAlbumEntrance, true);
        UiBaseUtils.setClickable(this.mVideoEntrance, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ResourceUtils.getResIdByName("ugc_publish")) {
            if (this.mInput != null) {
                onPublish(this.mInput.getText().toString());
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_publish_cancel")) {
            e.aa(this.mInput);
            if (this.mInput != null) {
                onCancel(this.mInput.getText().toString());
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_pic_entrance")) {
            if (!TextUtils.equals(this.mPublishPresenter.getPublishType(), "5")) {
                UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_PHOTO_CLICK, null, "publish");
            }
            onEnterAlbum();
        } else if (id == ResourceUtils.getResIdByName("ugc_topic")) {
            this.mPublishPresenter.onTopicSelect(this.mInput);
        } else if (id == ResourceUtils.getResIdByName("ugc_at")) {
            this.mPublishPresenter.onATSelect(this.mInput);
        } else if (id == ResourceUtils.getResIdByName("ugc_tag_name_tv")) {
            if (!TextUtils.isEmpty(this.mPublishPresenter.getUgcTagScheme())) {
                UgcUBCUtils.recordUgcTagStatistics("interest_click", this.mPublishPresenter.getSourceFrom());
                UgcUiUtils.callUgcTagListPage(this, getUgcTagTargetScheme(), new b<UgcTagSelectEvent>() { // from class: com.baidu.searchbox.ugc.activity.PublishBaseActivity.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(UgcTagSelectEvent ugcTagSelectEvent) {
                        if (ugcTagSelectEvent != null && ugcTagSelectEvent.tagItem != null) {
                            PublishBaseActivity.this.ugcTag = new UgcTagItem(ugcTagSelectEvent.tagItem.tagID, ugcTagSelectEvent.tagItem.tagName, ugcTagSelectEvent.tagItem.tagType, ugcTagSelectEvent.tagItem.tagOption);
                            if (TextUtils.isEmpty(PublishBaseActivity.this.ugcTag.tagName) || !"add".equals(PublishBaseActivity.this.ugcTag.tagOption)) {
                                PublishBaseActivity.this.showDefaultTagView();
                            } else {
                                if (PublishBaseActivity.this.tagNameView != null) {
                                    UiBaseUtils.setTextString(PublishBaseActivity.this.tagNameView, PublishBaseActivity.this.ugcTag.tagName);
                                    PublishBaseActivity.this.tagNameView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                    UgcUiUtils.setViewDrawable(PublishBaseActivity.this.tagNameView, R.drawable.ugc_tag_left_rounded_corner_selector);
                                }
                                UiBaseUtils.setVisibility(PublishBaseActivity.this.tagDividedView, 0);
                                UiBaseUtils.setVisibility(PublishBaseActivity.this.tagDeleteView, 0);
                            }
                            EventBusWrapper.unregister(PublishBaseActivity.this);
                        }
                    }
                });
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_tag_delete_iv")) {
            this.ugcTag = null;
            showDefaultTagView();
            UgcUBCUtils.recordUgcTagStatistics("interest_cancel", this.mPublishPresenter.getSourceFrom());
        }
    }

    private String getUgcTagTargetScheme() {
        String ugcTagScheme = this.mPublishPresenter.getUgcTagScheme();
        try {
            Uri.Builder buildUpon = Uri.parse(URLDecoder.decode(UnitedSchemeUtility.getParams(ugcTagScheme).get("url"), "UTF-8")).buildUpon();
            if (this.ugcTag != null && !TextUtils.isEmpty(this.ugcTag.tagID) && !TextUtils.isEmpty(this.ugcTag.tagType)) {
                buildUpon.appendQueryParameter(TiebaInitialize.Params.TAG_ID, this.ugcTag.tagID);
                buildUpon.appendQueryParameter("tag_type", this.ugcTag.tagType);
                return (ugcTagScheme.substring(0, ugcTagScheme.indexOf("?") + 1) + "url=") + URLEncoder.encode(buildUpon.toString(), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ugcTagScheme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDefaultTagView() {
        String string = DefaultSharedPrefsWrapper.getInstance().getString("ugc_tag_default_name", "");
        if (!TextUtils.isEmpty(string)) {
            UiBaseUtils.setVisibility(this.tagContainer, 0);
            Drawable drawable = getResources().getDrawable(R.drawable.ugc_tag_select);
            if (this.tagNameView != null) {
                UiBaseUtils.setTextString(this.tagNameView, string);
                this.tagNameView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                UgcUiUtils.setViewDrawable(this.tagNameView, R.drawable.ugc_tag_rounded_corner_selector);
            }
            UiBaseUtils.setVisibility(this.tagDeleteView, 8);
            UiBaseUtils.setVisibility(this.tagDividedView, 8);
            return;
        }
        UiBaseUtils.setVisibility(this.tagContainer, 8);
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public Activity getContext() {
        return this;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public List<UgcVoteInfo.VoteOption> getVoteOption() {
        if (this.mVoteView != null) {
            return this.mVoteView.getOptions();
        }
        return null;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public EmojiconEditText getInput() {
        return this.mInput;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public TextView getNumberTV() {
        return this.mNumberTv;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public TextView getPublishTv() {
        return this.mPublishTv;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public ImageView getTopicSelectIv() {
        return this.mTopicSelectIv;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishStart() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showUploadFailed() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishFailed(String str) {
        PublisherManagerFactory.get().setOnVideoShareListener(null);
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public UgcTagItem getTag() {
        return this.ugcTag;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void onUploadVideoErrorCancle() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void updateUploadVideoProgress(long j, long j2) {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadStart() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadEnd() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public boolean isEmojiShown() {
        return false;
    }
}
