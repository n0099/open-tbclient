package com.baidu.searchbox.ugc.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.publisher.event.StartPublishEvent;
import com.baidu.searchbox.publisher.event.UpdateVideoCoverEvent;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.dialog.UploadPhotosDialog;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.presenter.BasePublishPresenter;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.baidu.searchbox.ugc.view.PhotoChooseView;
import com.baidu.searchbox.ugc.view.RoundProgressBar;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.b;
/* loaded from: classes12.dex */
public class ReplyPublishActivity extends PublishBaseActivity implements EmojiconEditText.TextNumbersChangedListener, PhotoChooseView.StartAlbumListener {
    private static final int INCREASE_PROGRESS_INTERVAL = 10;
    private static final int MAX_COUNT = 9;
    private static final int MAX_PROGRESS = 100;
    private static final int THOUSAND_WORDS = 1000;
    private static final int THREAD_RUN_INTERVAL = 100;
    private ImageView mAddVideoImg;
    private ImageView mDeleteVideoImg;
    private UploadPhotosDialog mDialog;
    private DraftData mDraftData;
    private String mDraftKey;
    private List<ImageStruct> mISList;
    private boolean mIsSuccess;
    private String mMediaId;
    private PhotoChooseView mPhotoChooseView;
    private LinearLayout mPhotoView;
    private RoundProgressBar mProgressBar;
    private int mSourceId;
    private String mSourceKey;
    private int mSourceType;
    private boolean mTuneupPlugin;
    private String mVideoCover;
    private int mVideoHeight;
    private SimpleDraweeView mVideoImg;
    private String mVideoPath;
    private ImageView mVideoPlay;
    private String mVideoProductionType;
    private ImageView mVideoShadow;
    private View mVideoUploadProgress;
    private View mVideoUploadView;
    private boolean mVideoUploading;
    private RelativeLayout mVideoView;
    private int mVideoWidth;
    private boolean mPhotoUploading = false;
    private int mUploadImageIndex = 0;
    private int mUploadVideoIndex = 0;
    private boolean isDestroyed = false;

    static /* synthetic */ int access$2108(ReplyPublishActivity replyPublishActivity) {
        int i = replyPublishActivity.mUploadImageIndex;
        replyPublishActivity.mUploadImageIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$2208(ReplyPublishActivity replyPublishActivity) {
        int i = replyPublishActivity.mUploadVideoIndex;
        replyPublishActivity.mUploadVideoIndex = i + 1;
        return i;
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        baseSetContentView(R.layout.ugc_reply_publish_layout);
        initView();
        initImageView();
        initVideoView();
        initDraftData();
        initData();
        updateUi();
        this.mPublishPresenter.addTargetRule(this.mInput);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected BasePublishPresenter getPresenter() {
        return new BasePublishPresenter(this);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        registerEvent();
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
            EventBusWrapper.unregister(this);
            if (this.mInput != null) {
                this.mInput.removeListener();
            }
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !this.mPhotoUploading) {
            backDispose(this.mInput.getText().toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ugc.view.PhotoChooseView.StartAlbumListener
    public void goAlbumBefore() {
    }

    @Override // com.baidu.searchbox.ugc.view.PhotoChooseView.StartAlbumListener
    public void setPublishBtnStatus() {
        if (TextUtils.isEmpty(this.mInput.getText())) {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
        this.mPhotoView.setVisibility(8);
        this.mVideoView.setVisibility(8);
        this.mAlbumEntrance.setAlpha(1.0f);
        this.mVideoEntrance.setAlpha(1.0f);
        this.mVideoEntrance.setClickable(true);
        this.mAlbumEntrance.setClickable(true);
    }

    private void initView() {
        this.mPhotoView = (LinearLayout) findViewById(R.id.ugc_text_image_view);
        this.mVideoView = (RelativeLayout) findViewById(R.id.ugc_video_view);
        this.mInput.setListener(this);
        this.mInput.setMaxSize(this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath));
        this.mAlbumEntrance.setVisibility(0);
        if (PublisherConfig.isMainApp()) {
            this.mVideoEntrance.setVisibility(0);
        }
        this.mNumberTv.setVisibility(8);
    }

    private void initImageView() {
        this.mPhotoChooseView = (PhotoChooseView) findViewById(R.id.ugc_pic_choose);
        this.mPhotoChooseView.init(this);
        this.mPhotoChooseView.setListener(this);
        this.mPhotoChooseView.getAdapter2().setMaxCount(9);
        if (SelectUtil.getSelectedCount() > 0) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        }
    }

    private void initVideoView() {
        this.mVideoUploadView = findViewById(R.id.ugc_video_upload_view);
        this.mVideoImg = (SimpleDraweeView) findViewById(R.id.ugc_video_img);
        this.mProgressBar = (RoundProgressBar) findViewById(R.id.ugc_progress);
        this.mVideoShadow = (ImageView) findViewById(R.id.ugc_publish_shadow);
        this.mDeleteVideoImg = (ImageView) findViewById(R.id.ugc_video_close);
        this.mVideoPlay = (ImageView) findViewById(R.id.ugc_publish_upload_end);
        this.mAddVideoImg = (ImageView) findViewById(R.id.ugc_add_video_img);
        this.mVideoUploadProgress = findViewById(R.id.ugc_video_uploading_view);
        this.mVideoImg.setOnClickListener(this);
        this.mVideoUploadView.setOnClickListener(this);
        this.mAddVideoImg.setOnClickListener(this);
        this.mDeleteVideoImg.setOnClickListener(this);
        this.mProgressBar.setMax(100);
        this.mVideoWidth = DeviceUtil.ScreenInfo.dp2px(this, 80.0f);
        this.mVideoHeight = DeviceUtil.ScreenInfo.dp2px(this, 80.0f);
    }

    private void initDraftData() {
        this.mDraftKey = DraftUtils.getDraftKey(this.mPublishPresenter.mInfo);
        this.mDraftData = DraftUtils.getDraft(this.mDraftKey);
        if (this.mDraftData != null) {
            if (!TextUtils.isEmpty(this.mDraftData.content)) {
                this.mInput.setText(this.mDraftData.content);
                this.mInput.setSelection(this.mInput.length());
            }
            if (this.mDraftData.images != null && this.mDraftData.images.size() > 0) {
                SelectUtil.clear();
                for (String str : this.mDraftData.images) {
                    SelectUtil.saveSelectedImages(new ImageStruct(new File(str).toString()));
                }
                this.mPhotoChooseView.updateUi();
            } else if (this.mDraftData.video != null && !TextUtils.isEmpty(this.mDraftData.video)) {
                if (!TextUtils.isEmpty(this.mDraftData.mediaId)) {
                    this.mMediaId = this.mDraftData.mediaId;
                }
                if (!TextUtils.isEmpty(this.mDraftData.video)) {
                    this.mVideoPath = this.mDraftData.video;
                }
                if (!TextUtils.isEmpty(this.mDraftData.videoCover)) {
                    this.mVideoCover = this.mDraftData.videoCover;
                }
                if (!TextUtils.isEmpty(this.mDraftData.videoProductionType)) {
                    this.mVideoProductionType = this.mDraftData.videoProductionType;
                }
                if (!TextUtils.isEmpty(this.mDraftData.sourceKey)) {
                    this.mSourceKey = this.mDraftData.sourceKey;
                }
            }
            if (this.mDraftData.target != null) {
                this.mPublishPresenter.mTarget = (UGCTarget) new Gson().fromJson(this.mDraftData.target, (Class<Object>) UGCTarget.class);
            }
            if (this.mInput.length() <= this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath)) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
                return;
            } else {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
                return;
            }
        }
        this.mVideoPath = this.mPublishPresenter.mInfo.path;
        this.mVideoCover = this.mPublishPresenter.mInfo.videoCover;
        this.mVideoProductionType = this.mPublishPresenter.mInfo.videoProductionType;
        if (!TextUtils.isEmpty(this.mPublishPresenter.mInfo.target)) {
            this.mPublishPresenter.mTarget = (UGCTarget) new Gson().fromJson(this.mPublishPresenter.mInfo.target, (Class<Object>) UGCTarget.class);
        }
        this.mSourceId = this.mPublishPresenter.mInfo.sourceid;
        this.mSourceType = this.mPublishPresenter.mInfo.sourceType;
        this.mTuneupPlugin = this.mPublishPresenter.mInfo.tuneupPlugin;
    }

    private void initData() {
        if (this.mPublishPresenter.mInfo != null && !TextUtils.isEmpty(this.mPublishPresenter.mInfo.placeTitle)) {
            this.mTitle.setText(this.mPublishPresenter.mInfo.placeTitle);
        } else {
            this.mTitle.setText(R.string.ugc_reply_publish_title);
        }
        this.mPublishTv.setText(R.string.ugc_reply_publish);
        this.mInput.handleDraftEmojiDisplay();
        setInputCount(this.mInput.length(), this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath));
        if (SelectUtil.getSelectedCount() > 0) {
            this.mPhotoView.setVisibility(0);
            this.mVideoView.setVisibility(8);
            this.mAlbumEntrance.setClickable(true);
            this.mVideoEntrance.setClickable(false);
            this.mAlbumEntrance.setAlpha(1.0f);
            this.mVideoEntrance.setAlpha(0.4f);
        } else {
            this.mVideoView.setVisibility(0);
            this.mPhotoView.setVisibility(8);
            this.mVideoEntrance.setClickable(false);
            this.mAlbumEntrance.setClickable(false);
            this.mAlbumEntrance.setAlpha(0.4f);
            this.mVideoEntrance.setAlpha(0.4f);
        }
        if (!TextUtils.isEmpty(this.mVideoPath)) {
            notifyVideoUi();
            updateVideoCover();
            if (TextUtils.isEmpty(this.mMediaId)) {
                startUploadVideo(this.mVideoPath);
                return;
            }
            this.mVideoPlay.setVisibility(0);
            this.mVideoUploading = false;
            this.mIsSuccess = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputCount(int i, int i2) {
        this.mInput.setMaxSize(i2);
        if (i == 0) {
            this.mNumberTv.setVisibility(8);
        } else if (i < i2 - 20) {
            this.mNumberTv.setVisibility(8);
        } else if (i >= i2 - 20 && i <= i2) {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(i2 - i)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_normal_color));
        } else if (i > i2 && i < i2 + 1000) {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - i2)));
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
        } else {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(R.string.ugc_reply_input_over_999_hint);
            this.mNumberTv.setTextColor(getResources().getColor(R.color.ugc_reply_input_count_over_color));
        }
        if (this.mInput.getText().length() == 0) {
            if (!TextUtils.isEmpty(this.mMediaId)) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
            } else {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
            }
        } else if (this.mInput.getText().length() > 0 && this.mInput.getText().length() <= i2) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        } else {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
    }

    private void updateUi() {
        UgcUiUtils.setImageResource(this.mAddVideoImg, R.drawable.ugc_add_localalbum_selector);
        UgcUiUtils.setViewColor(findViewById(R.id.ugc_video_upload_view), R.color.ugc_white);
        UgcUiUtils.setViewColor(this.mVideoShadow, R.color.ugc_video_upload_shadow_color);
        UgcUiUtils.setImageResource(this.mDeleteVideoImg, R.drawable.ugc_delete_selected_img);
        UgcUiUtils.setImageResource(this.mVideoPlay, R.drawable.ugc_video_box_play);
        UgcUiUtils.setEditTextSelectedColor(this.mInput, R.color.ugc_highlight_text_color_topic_background);
        UgcUiUtils.setTopicHighLightColor(this.mPublishPresenter.mTopicRule, R.color.ugc_highlight_text_color_topic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVideoUi() {
        this.mPhotoView.setVisibility(8);
        this.mVideoView.setVisibility(0);
        this.mAddVideoImg.setVisibility(8);
        this.mVideoUploadView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoUploadView.getLayoutParams();
        layoutParams.width = this.mVideoWidth;
        layoutParams.height = this.mVideoHeight;
        this.mVideoUploadView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoCover() {
        String str = TextUtils.isEmpty(this.mVideoCover) ? this.mVideoPath : this.mVideoCover;
        if (!TextUtils.isEmpty(str)) {
            ImageRequestBuilder X = ImageRequestBuilder.X(UgcUriUtils.getUri(str));
            X.c(new d((int) (this.mVideoWidth / 2.0f), (int) (this.mVideoHeight / 2.0f)));
            X.vs(true);
            this.mVideoImg.setController(c.dkj().vd(true).be(X.dro()).c(this.mVideoImg.getController()).dla());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadVideo(final String str) {
        Runnable uploadVideoTask;
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.1
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                ReplyPublishActivity.this.mIsSuccess = false;
                ReplyPublishActivity.this.mVideoUploading = false;
                BoxAlertDialog.Builder builder = new BoxAlertDialog.Builder(ReplyPublishActivity.this);
                builder.setTitle(R.string.ugc_publish_prompt);
                builder.setMessage(R.string.ugc_publish_upload_fail);
                builder.setPositiveButton(R.string.ugc_publish_upload_video, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ReplyPublishActivity.this.startUploadVideo(str);
                    }
                });
                builder.setNegativeButton(R.string.ugc_publish_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ReplyPublishActivity.this.mPhotoView.setVisibility(8);
                        ReplyPublishActivity.this.mVideoView.setVisibility(8);
                        ReplyPublishActivity.this.mAlbumEntrance.setAlpha(1.0f);
                        ReplyPublishActivity.this.mVideoEntrance.setAlpha(1.0f);
                        ReplyPublishActivity.this.mAlbumEntrance.setClickable(true);
                        ReplyPublishActivity.this.mVideoEntrance.setClickable(true);
                        DraftUtils.deleteDraft(ReplyPublishActivity.this.mDraftKey);
                    }
                });
                builder.show();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
                ReplyPublishActivity.this.updateProgress(j);
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
                ReplyPublishActivity.this.setVideoUploadStart();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                ReplyPublishActivity.this.mMediaId = uploadFileTask.getUrl();
                ReplyPublishActivity.this.mSourceKey = uploadFileTask.getBosKey();
                ReplyPublishActivity.this.setVideoUploadEnd();
                ReplyPublishActivity.this.mIsSuccess = true;
                ReplyPublishActivity.this.setInputCount(ReplyPublishActivity.this.mInput.length(), ReplyPublishActivity.this.mPublishPresenter.inputVideoLimit);
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
            }
        });
        ArrayList arrayList = new ArrayList();
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null && (uploadVideoTask = iPublisherSboxVideoInterface.getUploadVideoTask(str)) != null && (uploadVideoTask instanceof UploadFileTask)) {
            arrayList.add((UploadFileTask) uploadVideoTask);
        }
        UploadManager.getInstance().startAll(arrayList, this.mSourceType, "ugc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        if (j <= 100) {
            this.mProgressBar.setProgress(j);
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadStart() {
        this.mVideoUploadProgress.setVisibility(0);
        this.mVideoShadow.setVisibility(0);
        this.mVideoPlay.setVisibility(8);
        this.mVideoUploading = true;
        this.mPublishPresenter.setClickState(this.mPublishTv, false);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadEnd() {
        this.mVideoUploadProgress.setVisibility(8);
        this.mVideoShadow.setVisibility(8);
        this.mVideoPlay.setVisibility(0);
        this.mVideoUploading = false;
        if ((this.mInput.getText().length() > 0 && this.mInput.getText().length() <= this.mPublishPresenter.inputVideoLimit) || !TextUtils.isEmpty(this.mMediaId)) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        }
    }

    private void deleteVideo() {
        if (this.mVideoUploading) {
            BoxAlertDialog.Builder builder = new BoxAlertDialog.Builder(this);
            builder.setTitle(R.string.ugc_publish_prompt);
            builder.setMessage(R.string.ugc_publish_uploadding_text);
            builder.setPositiveButton(R.string.ugc_publish_delete, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ReplyPublishActivity.this.mPhotoView.setVisibility(8);
                    ReplyPublishActivity.this.mVideoView.setVisibility(8);
                    ReplyPublishActivity.this.mAlbumEntrance.setAlpha(1.0f);
                    ReplyPublishActivity.this.mVideoEntrance.setAlpha(1.0f);
                    ReplyPublishActivity.this.mAlbumEntrance.setClickable(true);
                    ReplyPublishActivity.this.mVideoEntrance.setClickable(true);
                    UploadManager.getInstance().stopAll();
                    ReplyPublishActivity.this.mVideoUploading = false;
                    ReplyPublishActivity.this.mVideoPath = "";
                    ReplyPublishActivity.this.setInputCount(ReplyPublishActivity.this.mInput.length(), ReplyPublishActivity.this.mPublishPresenter.inputImgTextLimit);
                    if (TextUtils.isEmpty(ReplyPublishActivity.this.mInput.getText())) {
                        ReplyPublishActivity.this.mPublishPresenter.setClickState(ReplyPublishActivity.this.mPublishTv, false);
                    }
                }
            });
            builder.setNegativeButton(R.string.ugc_publish_cancel, (DialogInterface.OnClickListener) null);
            builder.show();
        } else if (this.mIsSuccess) {
            BoxAlertDialog.Builder builder2 = new BoxAlertDialog.Builder(this);
            builder2.setTitle(R.string.ugc_delete_video_tips);
            builder2.setMessage(R.string.ugc_publish_uploaded_text);
            builder2.setPositiveButton(R.string.ugc_publish_delete, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!TextUtils.isEmpty(ReplyPublishActivity.this.mMediaId)) {
                        ReplyPublishActivity.this.mMediaId = "";
                        ReplyPublishActivity.this.mVideoPath = "";
                    }
                    ReplyPublishActivity.this.mPhotoView.setVisibility(8);
                    ReplyPublishActivity.this.mVideoView.setVisibility(8);
                    ReplyPublishActivity.this.mAlbumEntrance.setAlpha(1.0f);
                    ReplyPublishActivity.this.mVideoEntrance.setAlpha(1.0f);
                    ReplyPublishActivity.this.mAlbumEntrance.setClickable(true);
                    ReplyPublishActivity.this.mVideoEntrance.setClickable(true);
                    ReplyPublishActivity.this.setInputCount(ReplyPublishActivity.this.mInput.length(), ReplyPublishActivity.this.mPublishPresenter.inputImgTextLimit);
                    if (TextUtils.isEmpty(ReplyPublishActivity.this.mInput.getText())) {
                        ReplyPublishActivity.this.mPublishPresenter.setClickState(ReplyPublishActivity.this.mPublishTv, false);
                    }
                }
            });
            builder2.setNegativeButton(R.string.ugc_publish_cancel, (DialogInterface.OnClickListener) null);
            builder2.show();
        }
    }

    private void registerEvent() {
        EventBusWrapper.registerOnMainThread(this, StartPublishEvent.class, new b<StartPublishEvent>() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(StartPublishEvent startPublishEvent) {
                if (startPublishEvent != null) {
                    ReplyPublishActivity.this.mPhotoView.setVisibility(8);
                    ReplyPublishActivity.this.mVideoView.setVisibility(0);
                    ReplyPublishActivity.this.mAlbumEntrance.setAlpha(0.4f);
                    ReplyPublishActivity.this.mVideoEntrance.setAlpha(0.4f);
                    ReplyPublishActivity.this.mAlbumEntrance.setClickable(false);
                    ReplyPublishActivity.this.mVideoEntrance.setClickable(false);
                    ReplyPublishActivity.this.mVideoPath = startPublishEvent.videoPath;
                    ReplyPublishActivity.this.notifyVideoUi();
                    ReplyPublishActivity.this.updateVideoCover();
                    ReplyPublishActivity.this.startUploadVideo(startPublishEvent.videoPath);
                }
            }
        });
        EventBusWrapper.registerOnMainThread(this, UpdateVideoCoverEvent.class, new b<UpdateVideoCoverEvent>() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(UpdateVideoCoverEvent updateVideoCoverEvent) {
                if (updateVideoCoverEvent != null) {
                    ReplyPublishActivity.this.mVideoCover = updateVideoCoverEvent.videoCover;
                    ReplyPublishActivity.this.updateVideoCover();
                }
            }
        });
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void addChanged(int i) {
        if (i > this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath) && i < this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath) + 1000) {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_over_count_hint, Integer.valueOf(i - this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath))));
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
            } else if (!TextUtils.isEmpty(this.mMediaId)) {
                this.mPublishPresenter.setClickState(this.mPublishTv, true);
            } else {
                this.mPublishPresenter.setClickState(this.mPublishTv, false);
            }
        } else if (this.mVideoUploading) {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        } else if (i <= this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath) && i > 0) {
            this.mPublishPresenter.setClickState(this.mPublishTv, true);
        } else {
            this.mPublishPresenter.setClickState(this.mPublishTv, false);
        }
        if (i == 0) {
            this.mNumberTv.setVisibility(8);
        } else if (i < this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath) - 20) {
            this.mNumberTv.setVisibility(8);
        } else {
            this.mNumberTv.setVisibility(0);
            this.mNumberTv.setText(getResources().getString(R.string.ugc_reply_input_left_count_hint, Integer.valueOf(this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath) - i)));
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
                UgcLoginUtils.login(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.6
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            ReplyPublishActivity.this.goPublish(str);
                        }
                    }
                }, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            } else if (!UgcLoginUtils.isGuestLogin()) {
                goPublish(str);
            } else {
                UgcLoginUtils.bindPhone(new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.7
                    @Override // com.baidu.searchbox.account.ILoginResultListener
                    public void onResult(int i) {
                        if (i == 0) {
                            ReplyPublishActivity.this.goPublish(str);
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
        if (SelectUtil.getSelectedCount() > 0) {
            publishImages(str, SelectUtil.getSeletedImages());
        } else if (!TextUtils.isEmpty(this.mMediaId)) {
            showProgressDialog();
            publishVideo(str);
        } else {
            publish(str, null, null);
        }
    }

    private void publishVideo(final String str) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.mMediaId)) {
            if (TextUtils.isEmpty(this.mMediaId)) {
                BoxAlertDialog.Builder builder = new BoxAlertDialog.Builder(this);
                builder.setTitle(R.string.ugc_publish_prompt);
                builder.setMessage(R.string.ugc_publish_no_video_prompt);
                builder.setPositiveButton(R.string.ugc_publish_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ReplyPublishActivity.this.publish(str, null, null);
                    }
                });
                builder.setNegativeButton(R.string.ugc_publish_cancel, (DialogInterface.OnClickListener) null);
                builder.show();
            } else {
                showProgressDialog();
                goVideoPublish(str);
            }
            UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPublcshVideoBtnPage);
        }
    }

    private void goVideoPublish(String str) {
        ArrayList<ImageStruct> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(this.mVideoCover)) {
            arrayList.add(new ImageStruct(this.mVideoCover));
        }
        if (!TextUtils.isEmpty(this.mVideoPath)) {
            arrayList.add(new ImageStruct(FileUtils.saveBitmap(FileUtils.getLocalVideoBitmap(this.mVideoPath))));
        }
        if (arrayList.size() > 0) {
            startUploadVideoCover(str, arrayList);
        }
    }

    private void showProgressDialog() {
        this.mDialog = new UploadPhotosDialog(this);
        this.mDialog.show();
        ExecutorUtilsExt.postOnElastic(new AnonymousClass9(), VideoPublishActivity.class.getSimpleName(), 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.searchbox.ugc.activity.ReplyPublishActivity$9  reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass9 implements Runnable {
        int progress = 0;

        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (this.progress < 100) {
                this.progress += 10;
                ReplyPublishActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass9.this.progress <= 100) {
                            ReplyPublishActivity.this.mDialog.notifyProgress(AnonymousClass9.this.progress, 100);
                        }
                    }
                });
                try {
                    Thread.sleep(100L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
        if (i2 == -1) {
            if (i == 32769) {
                if (intent == null) {
                    this.mPhotoView.setVisibility(0);
                    this.mVideoView.setVisibility(8);
                    this.mAlbumEntrance.setAlpha(1.0f);
                    this.mVideoEntrance.setAlpha(0.4f);
                    this.mAlbumEntrance.setClickable(true);
                    this.mVideoEntrance.setClickable(false);
                    this.mPhotoChooseView.updateUi();
                    if (SelectUtil.getSelectedCount() > 0 && this.mInput.length() <= this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath)) {
                        this.mPublishPresenter.setClickState(this.mPublishTv, true);
                        return;
                    } else if (TextUtils.isEmpty(this.mInput.getText())) {
                        this.mPublishPresenter.setClickState(this.mPublishTv, false);
                        return;
                    } else {
                        return;
                    }
                }
                this.mVideoView.setVisibility(0);
                this.mPhotoView.setVisibility(8);
                this.mVideoEntrance.setAlpha(0.4f);
                this.mAlbumEntrance.setAlpha(0.4f);
                this.mVideoEntrance.setClickable(false);
                this.mAlbumEntrance.setClickable(false);
                this.mVideoPath = intent.getStringExtra("path");
                if (!TextUtils.isEmpty(this.mVideoPath)) {
                    notifyVideoUi();
                    startUploadVideo(this.mVideoPath);
                }
            } else if (i == 32770) {
                this.mPhotoChooseView.updateUi();
                if (SelectUtil.getSelectedCount() > 0 && this.mInput.length() <= this.mPublishPresenter.getDynamicWordLimit(this.mVideoPath)) {
                    this.mPublishPresenter.setClickState(this.mPublishTv, true);
                    return;
                }
                if (TextUtils.isEmpty(this.mInput.getText())) {
                    this.mPublishPresenter.setClickState(this.mPublishTv, false);
                }
                this.mPhotoView.setVisibility(8);
                this.mVideoView.setVisibility(8);
                this.mAlbumEntrance.setAlpha(1.0f);
                this.mVideoEntrance.setAlpha(1.0f);
                this.mAlbumEntrance.setClickable(true);
                this.mVideoEntrance.setClickable(true);
            }
        }
    }

    private void backDispose(String str) {
        if (!this.mPhotoUploading) {
            if (this.mVideoUploading && this.mPublishPresenter.mInfo != null) {
                saveDraft(str);
            } else if (TextUtils.isEmpty(str) && SelectUtil.getSeletedImages().size() == 0 && TextUtils.isEmpty(this.mMediaId)) {
                if (this.mDraftData != null) {
                    DraftUtils.deleteDraft(this.mDraftKey);
                }
                Sender.sendBroadcast(this, UgcConstant.UGC_REPLY_PUBLISH_INPUT_ACTION, null);
                finish();
                UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
                if (this.mPublishPresenter.mInfo != null) {
                    UgcUBCUtils.saveDraftPublishUbcStatistics(this.mPublishPresenter.mInfo.sourceFrom, false, false, false, false);
                }
            } else {
                saveDraft(str);
            }
        }
    }

    private void saveDraft(String str) {
        this.mISList = new ArrayList(SelectUtil.getSeletedImages());
        ExecutorUtilsExt.postOnElastic(new SaveDraftTask(str), "saveToDraft", 1);
        SelectUtil.clear();
        UgcUBCUtils.saveDraftPublishUbcStatistics(this.mPublishPresenter.mInfo.sourceFrom, false, true, true, false);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class SaveDraftTask implements Runnable {
        String inputStr;

        SaveDraftTask(String str) {
            this.inputStr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String saveImageDraft;
            DraftData draftData = new DraftData();
            if (!TextUtils.isEmpty(this.inputStr)) {
                draftData.content = this.inputStr;
            }
            if (ReplyPublishActivity.this.mISList != null && ReplyPublishActivity.this.mISList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ImageStruct imageStruct : ReplyPublishActivity.this.mISList) {
                    if (!TextUtils.isEmpty(imageStruct.uriStr)) {
                        if (SelectUtil.isGif(imageStruct.uriStr)) {
                            saveImageDraft = FileUtils.saveGifDraft(ReplyPublishActivity.this, imageStruct.uriStr);
                        } else {
                            saveImageDraft = FileUtils.saveImageDraft(ReplyPublishActivity.this, imageStruct.uriStr);
                        }
                        if (!TextUtils.isEmpty(saveImageDraft)) {
                            arrayList.add(saveImageDraft);
                        }
                    }
                }
                draftData.images.addAll(arrayList);
            }
            if (!TextUtils.isEmpty(ReplyPublishActivity.this.mVideoPath)) {
                if (!TextUtils.isEmpty(ReplyPublishActivity.this.mMediaId)) {
                    draftData.mediaId = ReplyPublishActivity.this.mMediaId;
                }
                if (!TextUtils.isEmpty(ReplyPublishActivity.this.mVideoProductionType)) {
                    draftData.videoProductionType = ReplyPublishActivity.this.mVideoProductionType;
                }
                draftData.video = FileUtils.saveVideoDraft(ReplyPublishActivity.this, ReplyPublishActivity.this.mVideoPath);
                if (!TextUtils.isEmpty(ReplyPublishActivity.this.mVideoCover)) {
                    if (!TextUtils.isEmpty(FileUtils.saveImageDraft(ReplyPublishActivity.this, ReplyPublishActivity.this.mVideoCover))) {
                        draftData.videoCover = ReplyPublishActivity.this.mVideoCover;
                    }
                    draftData.videoCover = ReplyPublishActivity.this.mVideoCover;
                }
                if (!TextUtils.isEmpty(ReplyPublishActivity.this.mPublishPresenter.mInfo.followVideoDataStr)) {
                    draftData.videoInfo = ReplyPublishActivity.this.mPublishPresenter.mInfo.followVideoDataStr;
                }
            }
            if (ReplyPublishActivity.this.mPublishPresenter.mTarget == null) {
                ReplyPublishActivity.this.mPublishPresenter.mTarget = new UGCTarget();
            }
            if (ReplyPublishActivity.this.mPublishPresenter.mAtRule != null) {
                ReplyPublishActivity.this.mPublishPresenter.mAtRule.obtainUserInfoList(ReplyPublishActivity.this.mPublishPresenter.mTarget.mUserInfoList);
            }
            draftData.target = new Gson().toJson(ReplyPublishActivity.this.mPublishPresenter.mTarget);
            draftData.timestamp = System.currentTimeMillis();
            if (!TextUtils.isEmpty(ReplyPublishActivity.this.mSourceKey)) {
                draftData.sourceKey = ReplyPublishActivity.this.mSourceKey;
            }
            DraftUtils.saveDraft(ReplyPublishActivity.this.mDraftKey, draftData);
            if (draftData.images != null && draftData.images.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < draftData.images.size(); i++) {
                    sb.append("[图片]");
                }
                str = this.inputStr + sb.toString();
            } else if (!TextUtils.isEmpty(draftData.video)) {
                str = this.inputStr + "[视频]";
            } else {
                str = this.inputStr;
            }
            Sender.sendBroadcast(ReplyPublishActivity.this, UgcConstant.UGC_REPLY_PUBLISH_INPUT_ACTION, str);
        }
    }

    private void publishImages(String str, List<ImageStruct> list) {
        if (!NetWorkUtils.isNetworkConnected(this)) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_preview_toast_no_network).showToast();
        } else if (list.size() > 0) {
            startUploadImages(str, list);
        }
    }

    private void startUploadImages(final String str, List<ImageStruct> list) {
        this.mPhotoUploading = true;
        final int size = list.size();
        this.mUploadImageIndex = 0;
        final ArrayList arrayList = new ArrayList();
        this.mDialog = new UploadPhotosDialog(this);
        this.mDialog.show();
        this.mDialog.notifyProgress(this.mUploadImageIndex, size);
        this.mDialog.setListener(new UploadPhotosDialog.CancalProgressListener() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.10
            @Override // com.baidu.searchbox.ugc.dialog.UploadPhotosDialog.CancalProgressListener
            public void cancel() {
                ReplyPublishActivity.this.dismissProgressDialog();
                UploadManager.getInstance().stopAll();
                ReplyPublishActivity.this.mPhotoUploading = false;
            }
        });
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.11
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                ReplyPublishActivity.this.dismissProgressDialog();
                ReplyPublishActivity.this.mPhotoUploading = false;
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
                ReplyPublishActivity.access$2108(ReplyPublishActivity.this);
                ReplyPublishActivity.this.mDialog.notifyProgress(ReplyPublishActivity.this.mUploadImageIndex, size);
                if (ReplyPublishActivity.this.mUploadImageIndex == size) {
                    ReplyPublishActivity.this.publish(str, arrayList, null);
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                ReplyPublishActivity.this.dismissProgressDialog();
                ReplyPublishActivity.this.mPhotoUploading = false;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList2.add(new UploadImageTask(list.get(i).uriStr));
        }
        UploadManager.getInstance().startAll(arrayList2, 0, "ugc");
    }

    private void startUploadVideoCover(final String str, final ArrayList<ImageStruct> arrayList) {
        int i = 0;
        this.mUploadVideoIndex = 0;
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.12
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                if (HttpRequestPublishModule.getVideoUploadInfo() == null) {
                    UniversalToast.makeText(ReplyPublishActivity.this.getApplicationContext(), R.string.ugc_release_fail).showToast();
                    return;
                }
                HttpRequestPublishModule.VideoUploadModel videoUploadInfo = HttpRequestPublishModule.getVideoUploadInfo();
                if (ReplyPublishActivity.this.mUploadVideoIndex == 0) {
                    videoUploadInfo.coverUrl = uploadFileTask.getUrl();
                    if (arrayList.size() == 1) {
                        videoUploadInfo.videoFirstFrame = uploadFileTask.getUrl();
                    }
                } else {
                    videoUploadInfo.videoFirstFrame = uploadFileTask.getUrl();
                }
                ReplyPublishActivity.access$2208(ReplyPublishActivity.this);
                if (ReplyPublishActivity.this.mUploadVideoIndex == arrayList.size()) {
                    videoUploadInfo.mediaId = ReplyPublishActivity.this.mMediaId;
                    if (!TextUtils.isEmpty(ReplyPublishActivity.this.mVideoProductionType)) {
                        videoUploadInfo.videoProductionType = ReplyPublishActivity.this.mVideoProductionType;
                    }
                    ReplyPublishActivity.this.publish(str, null, videoUploadInfo);
                    FileUtils.deleteCoverFile(new File(Environment.getExternalStorageDirectory().getPath() + FileUtils.VIDEOCOVER));
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                ReplyPublishActivity.this.dismissProgressDialog();
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
            }
        });
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(new UploadImageTask(arrayList.get(i2).uriStr));
                i = i2 + 1;
            } else {
                UploadManager.getInstance().startAll(arrayList2, this.mSourceType, "ugc");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish(String str, final ArrayList<PublishModels.ImageData> arrayList, final HttpRequestPublishModule.VideoUploadModel videoUploadModel) {
        this.mPublishPresenter.setClickState(this.mPublishTv, false);
        setBottomEntrUnableClick();
        JSONObject jSONObject = new JSONObject();
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        try {
            if (this.mPublishPresenter.mTarget == null) {
                this.mPublishPresenter.mTarget = new UGCTarget();
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
            publishRequestModel.inputStr = str;
            publishRequestModel.postUrl = this.mPublishPresenter.mPostUrl;
            publishRequestModel.sourceFrom = this.mPublishPresenter.mSourceFrom;
            publishRequestModel.extObject = this.mPublishPresenter.mExtObject;
            if (arrayList != null) {
                publishRequestModel.imageUrlList = arrayList;
            }
            if (videoUploadModel != null) {
                publishRequestModel.sourceid = this.mSourceId;
                publishRequestModel.sourceKey = this.mSourceKey;
                publishRequestModel.sourceType = this.mSourceType;
                publishRequestModel.videoInfo = videoUploadModel;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.activity.ReplyPublishActivity.13
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                if (arrayList != null) {
                    ReplyPublishActivity.this.mPhotoUploading = false;
                }
                if (videoUploadModel != null) {
                    ReplyPublishActivity.this.mDialog.notifyProgress(100, 100);
                }
                ReplyPublishActivity.this.publishSuccess(publishResultInfo);
                ReplyPublishActivity.this.setBottomEntrAbleClick();
                ReplyPublishActivity.this.dismissProgressDialog();
                DraftUtils.deleteDraft(ReplyPublishActivity.this.mDraftKey);
                Sender.sendBroadcast(ReplyPublishActivity.this, UgcConstant.UGC_REPLY_PUBLISH_INPUT_ACTION, null);
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str2) {
                ReplyPublishActivity.this.mPublishPresenter.setClickState(ReplyPublishActivity.this.mPublishTv, true);
                ReplyPublishActivity.this.mPhotoUploading = false;
                ReplyPublishActivity.this.mPublishPresenter.publishFail(str2);
                ReplyPublishActivity.this.setBottomEntrAbleClick();
                ReplyPublishActivity.this.dismissProgressDialog();
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

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.ugc_video_img) {
            if (!this.mVideoUploading) {
                if (this.mTuneupPlugin) {
                    IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
                    if (iPublisherSboxVideoInterface != null) {
                        iPublisherSboxVideoInterface.invokePluginForAlbumResult(this, this.mVideoPath, true);
                        return;
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("path", this.mVideoPath);
                intent.putExtra("from", "publish");
                IPublisherSboxVideoInterface iPublisherSboxVideoInterface2 = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
                if (iPublisherSboxVideoInterface2 != null) {
                    iPublisherSboxVideoInterface2.openVideoPreviewActivityForResult(this, intent, 32769);
                }
            }
        } else if (id == R.id.ugc_video_entrance) {
            this.mPublishPresenter.mInfo.launchFrom = "publish";
            IPublisherSboxVideoInterface iPublisherSboxVideoInterface3 = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
            if (iPublisherSboxVideoInterface3 != null) {
                iPublisherSboxVideoInterface3.invokeVideoCapture(this.mPublishPresenter.mInfo, this);
            }
        } else if (id == R.id.ugc_video_close) {
            deleteVideo();
        }
    }
}
