package com.baidu.searchbox.ugc.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.IPublishView;
import com.baidu.searchbox.ugc.adapter.EmotionPagerAdapter;
import com.baidu.searchbox.ugc.dialog.UploadProgressDialog;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.model.FollowVideoData;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.UgcTagDisplayModel;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.baidu.searchbox.ugc.model.UgcVoteInfo;
import com.baidu.searchbox.ugc.presenter.PluginVideoPublishPresenter;
import com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.view.IUgcPublishPanel;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.spswitch.b.e;
import com.baidu.spswitch.c;
import com.baidu.spswitch.emotion.b;
import com.baidu.spswitch.emotion.view.BDEmotionBagLayout;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.spswitch.view.SPSwitchRootLinearLayout;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class UgcPublishPanel implements View.OnClickListener, View.OnTouchListener, NoProGuard, IPublishView, IUgcPublishPanel {
    public ImageView mAtIv;
    private Activity mContext;
    private String mDefalutInput;
    public ImageView mEmoijImg;
    public EmojiconEditText mInput;
    public TextView mNumberTv;
    private SPSwitchPanelLinearLayout mPanelRoot;
    private String mParamJson;
    private IUgcPublishPanel.IPluginProvider mPluginProvider;
    private UploadProgressDialog mProgressDialog;
    public Button mPublishBtn;
    public SPSwitchRootLinearLayout mRootView;
    public ImageView mTopicSelectIv;
    private boolean isCancle = false;
    private VideoBasePublishPresenter mPublishPanelPresenter = new PluginVideoPublishPresenter(this);

    public UgcPublishPanel(Activity activity, String str) {
        this.mContext = activity;
        this.mParamJson = str;
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public View getView() {
        View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.ugc_publish_panel_layout, (ViewGroup) null);
        initView(inflate);
        return inflate;
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void onCreate() {
        if (!TextUtils.isEmpty(this.mParamJson)) {
            try {
                this.mPublishPanelPresenter.onCreate(UgcSchemeModel.parserSchemeModel(new JSONObject(this.mParamJson)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.mInput.setListener(this.mPublishPanelPresenter);
        this.mInput.setMaxSize(this.mPublishPanelPresenter.inputVideoLimit);
        this.mPublishPanelPresenter.initView(this.mNumberTv, this.mInput, this.mTopicSelectIv, this.mAtIv);
        this.mPublishPanelPresenter.videoTopic(this.mInput);
        this.mPublishPanelPresenter.initEmotionPanel((ViewGroup) getContext().findViewById(16908290), this.mPanelRoot, this.mInput, this.mEmoijImg, getContext().getWindow(), null);
        initListeners();
        this.mPublishPanelPresenter.initTargetRuleAndUbc(this.mInput);
        this.mDefalutInput = this.mInput.getText().toString();
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void onResume() {
        this.mPublishPanelPresenter.onResume(this.mInput);
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void onStop() {
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void onDestroy() {
        this.mPublishPanelPresenter.onDestroy(this.mInput);
        this.mContext = null;
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void setPluginProvider(IUgcPublishPanel.IPluginProvider iPluginProvider) {
        this.mPluginProvider = iPluginProvider;
    }

    private void initView(View view) {
        this.mRootView = (SPSwitchRootLinearLayout) view.findViewById(ResourceUtils.getResIdByName("ugc_publish_root"));
        this.mInput = (EmojiconEditText) view.findViewById(ResourceUtils.getResIdByName("ugc_edittext"));
        this.mEmoijImg = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_emoij"));
        this.mTopicSelectIv = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_topic"));
        this.mAtIv = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_at"));
        this.mNumberTv = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_text_number"));
        this.mPublishBtn = (Button) view.findViewById(ResourceUtils.getResIdByName("ugc_publish_btn"));
        UiBaseUtils.setOnClickListener(this.mTopicSelectIv, this);
        UiBaseUtils.setOnClickListener(this.mAtIv, this);
        UiBaseUtils.setOnClickListener(this.mPublishBtn, this);
        this.mPanelRoot = (SPSwitchPanelLinearLayout) view.findViewById(ResourceUtils.getResIdByName("ugc_panel_root"));
        initPluginEmotionPanel(this.mRootView);
    }

    private void initPluginEmotionPanel(View view) {
        List<String> Gj = b.bc(AppRuntime.getAppContext()).Gj();
        BDEmotionBagLayout bDEmotionBagLayout = new BDEmotionBagLayout(AppRuntime.getAppContext());
        bDEmotionBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, DeviceUtil.ScreenInfo.dp2px(getContext(), 260.0f)));
        bDEmotionBagLayout.setEmotionList(Gj);
        ((ViewPager) this.mPanelRoot.findViewById(c.C0195c.vp_emotion_type)).setAdapter(new EmotionPagerAdapter(bDEmotionBagLayout));
    }

    private void initListeners() {
        this.mEmoijImg.setOnTouchListener(this);
        this.mTopicSelectIv.setOnTouchListener(this);
        this.mAtIv.setOnTouchListener(this);
        this.mPublishBtn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.view.UgcPublishPanel.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UgcPublishPanel.this.mPublishPanelPresenter.mEnableClick) {
                    UgcUiUtils.setTouchAlpha(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
        this.mInput.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.searchbox.ugc.view.UgcPublishPanel.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UgcPublishPanel.this.mInput.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    UgcPublishPanel.this.mInput.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(UgcPublishPanel.this.mContext, R.drawable.ugc_game_write_unpressed), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        UgcUiUtils.setTouchAlpha(view, motionEvent);
        return false;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void initPKView() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showVoteView(UgcVoteInfo ugcVoteInfo) {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void hidePKContainer() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void initUgcTagView(UgcTagDisplayModel ugcTagDisplayModel) {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public Activity getContext() {
        return this.mContext;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public List<UgcVoteInfo.VoteOption> getVoteOption() {
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
        return this.mPublishBtn;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public ImageView getTopicSelectIv() {
        return this.mTopicSelectIv;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishStart() {
        showProgressDialog();
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showUploadFailed() {
        dismissProgressDialog();
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.notifyProgress(100L);
        }
        dismissProgressDialog();
        if (this.mContext != null) {
            this.mContext.finish();
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishFailed(String str) {
        dismissProgressDialog();
        PublisherManagerFactory.get().setOnVideoShareListener(null);
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public UgcTagItem getTag() {
        return null;
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void onUploadVideoErrorCancle() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void updateUploadVideoProgress(long j, long j2) {
        if (this.mProgressDialog != null) {
            long j3 = ((((float) j) / ((float) j2)) * 100.0f) / 2.0f;
            if (j3 > this.mProgressDialog.getProgress()) {
                this.mProgressDialog.notifyProgress(j3);
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadStart() {
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadEnd() {
        if (this.isCancle) {
            this.isCancle = false;
            return;
        }
        this.mPublishPanelPresenter.onPublish(this.mInput.getText().toString());
        if (this.mProgressDialog != null) {
            this.mProgressDialog.setCancleEnable(false);
            this.mProgressDialog.updateProgressAuto(100);
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.IPublishView
    public boolean isEmojiShown() {
        return this.mPanelRoot != null && this.mPanelRoot.getVisibility() == 0;
    }

    private void showProgressDialog() {
        if (this.mPluginProvider != null) {
            this.mProgressDialog = new UploadProgressDialog(this.mContext, this.mPluginProvider.getDialogStyle());
            this.mProgressDialog.setListener(new UploadProgressDialog.CancalProgressListener() { // from class: com.baidu.searchbox.ugc.view.UgcPublishPanel.3
                @Override // com.baidu.searchbox.ugc.dialog.UploadProgressDialog.CancalProgressListener
                public void cancel() {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_cancle_publish).showToast();
                    UgcPublishPanel.this.isCancle = true;
                }
            });
            this.mProgressDialog.show();
        }
    }

    private void dismissProgressDialog() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.setCancleEnable(true);
            this.mProgressDialog.dismiss();
        }
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void publish(String str) {
        if (this.mContext != null) {
            this.mContext.sendBroadcast(new Intent("clip_complete_action"));
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("output_video_path");
                String optString2 = jSONObject.optString(FileUtils.VIDEO_COVER_DIR);
                String optString3 = jSONObject.optString("follow_video");
                this.mPublishPanelPresenter.mInfo.path = optString;
                this.mPublishPanelPresenter.mVideoPath = optString;
                this.mPublishPanelPresenter.mInfo.videoCover = optString2;
                this.mPublishPanelPresenter.mVideoCover = optString2;
                this.mPublishPanelPresenter.mInfo.followVideoDataStr = optString3;
                FollowVideoData followVideoData = this.mPublishPanelPresenter.followVideoData;
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = "";
                }
                followVideoData.parseFromString(optString3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        uploadVideo();
    }

    private void uploadVideo() {
        this.mPublishPanelPresenter.setClickState(this.mPublishBtn, true);
        this.mPublishPanelPresenter.startUploadVideo(this.mPublishPanelPresenter.mInfo.path);
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public boolean isInputEdited() {
        e.aa(this.mInput);
        return !TextUtils.equals(this.mDefalutInput, this.mInput.getText().toString());
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void hideInputPanel() {
        if (this.mInput != null) {
            e.aa(this.mInput);
        }
    }

    @Override // com.baidu.searchbox.ugc.view.IUgcPublishPanel
    public void setEmojiVisibility(boolean z) {
        if (this.mPanelRoot != null) {
            this.mPanelRoot.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ResourceUtils.getResIdByName("ugc_publish_btn")) {
            if (this.mPublishPanelPresenter.mEnableClick) {
                if (!NetWorkUtils.isNetworkConnected()) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
                } else if (this.mInput != null) {
                    showPublishStart();
                    if (!TextUtils.isEmpty(this.mPublishPanelPresenter.mVideoPath)) {
                        uploadVideo();
                    } else if (this.mPluginProvider != null) {
                        this.mPluginProvider.onPublish();
                    }
                }
            }
        } else if (id == ResourceUtils.getResIdByName("ugc_topic")) {
            this.mPublishPanelPresenter.onTopicSelect(this.mInput);
        } else if (id == ResourceUtils.getResIdByName("ugc_at")) {
            this.mPublishPanelPresenter.onATSelect(this.mInput);
        }
    }
}
