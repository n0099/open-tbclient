package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.publisher.event.StartPublishEvent;
import com.baidu.searchbox.publisher.event.UpdateVideoCoverEvent;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.dialog.UGCBoxActivityDialog;
import com.baidu.searchbox.ugc.dialog.UploadPhotosDialog;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter;
import com.baidu.searchbox.ugc.provider.listener.OnVideoShareListener;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.ugc.utils.DialogUtils;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.UgcDialogUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.baidu.searchbox.ugc.view.RoundProgressBar;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import rx.functions.b;
/* loaded from: classes13.dex */
public class VideoPublishActivity extends PublishBaseActivity<VideoBasePublishPresenter> implements View.OnClickListener {
    private static final int INCREASE_PROGRESS_INTERVAL = 10;
    private static final int MAX_PROGRESS = 100;
    private static final int THREAD_RUN_INTERVAL = 100;
    public static OnVideoShareListener sVideoShareListener;
    private ImageView mAddVideoImg;
    private ImageView mDeleteVideoImg;
    private UploadPhotosDialog mDialog;
    private boolean mEditedTag;
    private RoundProgressBar mProgressBar;
    private int mVideoHeight;
    private SimpleDraweeView mVideoImg;
    private ImageView mVideoPlay;
    private ImageView mVideoShadow;
    private View mVideoUploadProgress;
    private View mVideoUploadView;
    private int mVideoWidth;

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        baseSetContentView(R.layout.ugc_video_publish_layout);
        this.mInput.setListener((EmojiconEditText.TextNumbersChangedListener) this.mPublishPresenter);
        ((VideoBasePublishPresenter) this.mPublishPresenter).initDraftData(this.mInput);
        initView();
        updateUi();
        ((VideoBasePublishPresenter) this.mPublishPresenter).initTargetRuleAndUbc(this.mInput);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    public VideoBasePublishPresenter getPresenter() {
        return new VideoBasePublishPresenter(this);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        registerEvent();
    }

    private void initView() {
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
        ((VideoBasePublishPresenter) this.mPublishPresenter).setClickState(this.mPublishTv, false);
        ((VideoBasePublishPresenter) this.mPublishPresenter).setInputState(this.mInput, this.mNumberTv, this.mPublishTv, ((VideoBasePublishPresenter) this.mPublishPresenter).getDynamicWordLimit(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath));
        if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.placeTitle)) {
            this.mTitle.setText(((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.placeTitle);
        } else {
            this.mTitle.setText(R.string.ugc_publish_title);
        }
        if (!TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath)) {
            notifyVideoUi();
            updateVideoCover();
            if (TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId) || HttpRequestPublishModule.videoInfo == null) {
                this.mEditedTag = true;
                ((VideoBasePublishPresenter) this.mPublishPresenter).startUploadVideo(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath);
            } else {
                this.mVideoPlay.setVisibility(0);
                ((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding = false;
                ((VideoBasePublishPresenter) this.mPublishPresenter).mIsSuccess = true;
                setPublishBtnStatus();
            }
        } else {
            this.mVideoUploadView.setVisibility(8);
            this.mAddVideoImg.setVisibility(0);
        }
        ((VideoBasePublishPresenter) this.mPublishPresenter).videoTopic(this.mInput);
        if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && !TextUtils.equals("9", ((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.publishType)) {
            this.mDeleteVideoImg.setVisibility(0);
        } else {
            this.mDeleteVideoImg.setVisibility(8);
        }
    }

    private void updateUi() {
        UgcUiUtils.setImageResource(this.mAddVideoImg, R.drawable.ugc_add_localalbum_selector);
        UgcUiUtils.setViewColor(findViewById(R.id.ugc_video_upload_view), R.color.ugc_white);
        UgcUiUtils.setViewDrawable(this.mVideoShadow, R.drawable.ugc_video_uploading_shadow_bg);
        UgcUiUtils.setImageResource(this.mDeleteVideoImg, R.drawable.ugc_delete_selected_img);
        UgcUiUtils.setImageResource(this.mVideoPlay, R.drawable.ugc_video_box_play);
        UgcUiUtils.setEditTextSelectedColor(this.mInput, R.color.ugc_highlight_text_color_topic_background);
        UgcUiUtils.setTopicHighLightColor(((VideoBasePublishPresenter) this.mPublishPresenter).mTopicRule, R.color.ugc_highlight_text_color_topic);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onPublish(String str) {
        ((VideoBasePublishPresenter) this.mPublishPresenter).onPublish(str);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onCancel(String str) {
        UgcUBCUtils.clickLayerStatistics(0, UgcUBCUtils.mPublcshVideoBtnPage);
        backDispose(str);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity
    protected void onEnterAlbum() {
    }

    private void showProgressDialog() {
        this.mDialog = new UploadPhotosDialog(this);
        this.mDialog.show();
        ExecutorUtilsExt.postOnElastic(new AnonymousClass1(), VideoPublishActivity.class.getSimpleName(), 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.searchbox.ugc.activity.VideoPublishActivity$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements Runnable {
        int progress = 0;

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (this.progress < 100) {
                this.progress += 10;
                VideoPublishActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass1.this.progress <= 100) {
                            VideoPublishActivity.this.mDialog.notifyProgress(AnonymousClass1.this.progress, 100);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVideoUi() {
        this.mAddVideoImg.setVisibility(8);
        this.mVideoUploadView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoUploadView.getLayoutParams();
        layoutParams.width = this.mVideoWidth;
        layoutParams.height = this.mVideoHeight;
        this.mVideoUploadView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoCover() {
        String str = TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoCover) ? ((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath : ((VideoBasePublishPresenter) this.mPublishPresenter).mVideoCover;
        if (!TextUtils.isEmpty(str)) {
            ImageRequestBuilder Y = ImageRequestBuilder.Y(UgcUriUtils.getUri(str));
            Y.c(new d((int) (this.mVideoWidth / 2.0f), (int) (this.mVideoHeight / 2.0f)));
            Y.vw(true);
            this.mVideoImg.setController(c.dly().vh(true).bg(Y.dsC()).c(this.mVideoImg.getController()).dmp());
        }
    }

    private void dismissProgressDialog() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    private void updateProgress(long j) {
        if (j <= 100) {
            this.mProgressBar.setProgress(j);
        }
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadStart() {
        this.mVideoUploadProgress.setVisibility(0);
        this.mVideoShadow.setVisibility(0);
        this.mVideoPlay.setVisibility(8);
        ((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding = true;
        ((VideoBasePublishPresenter) this.mPublishPresenter).setClickState(this.mPublishTv, false);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void setVideoUploadEnd() {
        this.mVideoUploadProgress.setVisibility(8);
        this.mProgressBar.setProgress(0L);
        this.mVideoShadow.setVisibility(8);
        this.mVideoPlay.setVisibility(0);
        ((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding = false;
        setPublishBtnStatus();
        ((VideoBasePublishPresenter) this.mPublishPresenter).setInputState(this.mInput, this.mNumberTv, this.mPublishTv, ((VideoBasePublishPresenter) this.mPublishPresenter).inputVideoLimit);
    }

    private void setPublishBtnStatus() {
        if (isAllowPublish()) {
            ((VideoBasePublishPresenter) this.mPublishPresenter).setClickState(this.mPublishTv, true);
        } else {
            ((VideoBasePublishPresenter) this.mPublishPresenter).setClickState(this.mPublishTv, false);
        }
    }

    private boolean isAllowPublish() {
        if (this.mInput == null || this.mInput.getText() == null) {
            return !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId);
        } else if (this.mInput.getText().length() <= ((VideoBasePublishPresenter) this.mPublishPresenter).getDynamicWordLimit(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath)) {
            return this.mInput.getText().length() > 0 || !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId);
        } else {
            return false;
        }
    }

    private void deleteVideo() {
        if (((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding) {
            UGCBoxActivityDialog.newBuilder().setTitle(R.string.ugc_publish_prompt).setMessage(R.string.ugc_publish_uploadding_text).setPositiveButton(R.string.ugc_publish_delete, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    VideoPublishActivity.this.mVideoUploadView.setVisibility(8);
                    VideoPublishActivity.this.mProgressBar.setProgress(0L);
                    VideoPublishActivity.this.mAddVideoImg.setVisibility(0);
                    UploadManager.getInstance().stopAll();
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mUploadding = false;
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoPath = "";
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).setInputState(VideoPublishActivity.this.mInput, VideoPublishActivity.this.mNumberTv, VideoPublishActivity.this.mPublishTv, ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).inputImgTextLimit);
                    if (TextUtils.isEmpty(VideoPublishActivity.this.mInput.getText())) {
                        ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).setClickState(VideoPublishActivity.this.mPublishTv, false);
                    }
                }
            }).setNegativeButton(R.string.ugc_publish_cancel, (DialogInterface.OnClickListener) null).show();
        } else if (!((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding && ((VideoBasePublishPresenter) this.mPublishPresenter).mIsSuccess) {
            UGCBoxActivityDialog.newBuilder().setTitle(R.string.ugc_delete_video_tips).setMessage(R.string.ugc_publish_uploaded_text).setPositiveButton(R.string.ugc_publish_delete, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!TextUtils.isEmpty(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mMediaId)) {
                        ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mMediaId = "";
                        ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoPath = "";
                    }
                    VideoPublishActivity.this.mVideoUploadView.setVisibility(8);
                    VideoPublishActivity.this.mProgressBar.setProgress(0L);
                    VideoPublishActivity.this.mAddVideoImg.setVisibility(0);
                    VideoPublishActivity.this.mEditedTag = true;
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).setInputState(VideoPublishActivity.this.mInput, VideoPublishActivity.this.mNumberTv, VideoPublishActivity.this.mPublishTv, ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).inputImgTextLimit);
                    if (TextUtils.isEmpty(VideoPublishActivity.this.mInput.getText())) {
                        ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).setClickState(VideoPublishActivity.this.mPublishTv, false);
                    }
                }
            }).setNegativeButton(R.string.ugc_publish_cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    private void registerEvent() {
        EventBusWrapper.registerOnMainThread(this, StartPublishEvent.class, new b<StartPublishEvent>() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(StartPublishEvent startPublishEvent) {
                if (startPublishEvent != null) {
                    VideoPublishActivity.this.mEditedTag = true;
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoPath = startPublishEvent.videoPath;
                    VideoPublishActivity.this.notifyVideoUi();
                    VideoPublishActivity.this.updateVideoCover();
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).startUploadVideo(startPublishEvent.videoPath);
                }
            }
        });
        EventBusWrapper.registerOnMainThread(this, UpdateVideoCoverEvent.class, new b<UpdateVideoCoverEvent>() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(UpdateVideoCoverEvent updateVideoCoverEvent) {
                if (updateVideoCoverEvent != null) {
                    ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoCover = updateVideoCoverEvent.videoCover;
                    VideoPublishActivity.this.updateVideoCover();
                }
            }
        });
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.ugc_video_img) {
            if (!((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding) {
                if (((VideoBasePublishPresenter) this.mPublishPresenter).mTuneupPlugin) {
                    IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
                    if (iPublisherSboxVideoInterface != null) {
                        iPublisherSboxVideoInterface.invokePluginForAlbumResult(this, ((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath, true);
                        return;
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("path", ((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath);
                intent.putExtra("from", "publish");
                IPublisherSboxVideoInterface iPublisherSboxVideoInterface2 = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
                if (iPublisherSboxVideoInterface2 != null) {
                    iPublisherSboxVideoInterface2.openVideoPreviewActivity(this, intent);
                }
            }
        } else if (id == R.id.ugc_add_video_img) {
            ((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.launchFrom = "publish";
            IPublisherSboxVideoInterface iPublisherSboxVideoInterface3 = (IPublisherSboxVideoInterface) com.baidu.pyramid.runtime.service.c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
            if (iPublisherSboxVideoInterface3 != null) {
                iPublisherSboxVideoInterface3.invokeVideoCapture(((VideoBasePublishPresenter) this.mPublishPresenter).mInfo, this);
            }
        } else if (id == R.id.ugc_video_close) {
            deleteVideo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32769 && i2 == -1 && intent != null) {
            ((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath = intent.getStringExtra("path");
            if (!TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath)) {
                notifyVideoUi();
                ((VideoBasePublishPresenter) this.mPublishPresenter).startUploadVideo(((VideoBasePublishPresenter) this.mPublishPresenter).mVideoPath);
            }
        }
    }

    private void backDispose(String str) {
        if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && TextUtils.equals("9", ((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.publishType)) {
            OnVideoShareListener onVideoShareListener = PublisherManagerFactory.get().getOnVideoShareListener();
            if (onVideoShareListener != null) {
                onVideoShareListener.onShareCancel();
            }
            finish();
        } else if (((VideoBasePublishPresenter) this.mPublishPresenter).mUploadding) {
            if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && !((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.isFollowVideo) {
                showSaveDraftDialog(str);
            } else {
                DialogUtils.showDialog(R.string.ugc_exit_upload_tips, R.string.ugc_publish_video_uploading_cancel, R.string.ugc_publish_confirm_exit, R.string.ugc_publish_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        VideoPublishActivity.this.finish();
                        UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
        } else if ((TextUtils.isEmpty(str) || (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mTopicName) && str.equals(((VideoBasePublishPresenter) this.mPublishPresenter).mTopicName))) && TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId)) {
            if (((VideoBasePublishPresenter) this.mPublishPresenter).mDraftData != null) {
                DraftUtils.deleteDraft(((VideoBasePublishPresenter) this.mPublishPresenter).mDraftKey);
            }
            finish();
            UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
            if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && !((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.isFollowVideo) {
                UgcUBCUtils.saveDraftPublishUbcStatistics(((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.sourceFrom, false, false, false, false);
            }
        } else if (((VideoBasePublishPresenter) this.mPublishPresenter).mDraftData != null && !isInputEdited(str)) {
            finish();
            if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && !((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.isFollowVideo) {
                UgcUBCUtils.saveDraftPublishUbcStatistics(((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.sourceFrom, false, false, false, false);
            }
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId)) {
            if (((VideoBasePublishPresenter) this.mPublishPresenter).mInfo != null && !((VideoBasePublishPresenter) this.mPublishPresenter).mInfo.isFollowVideo) {
                showSaveDraftDialog(str);
            } else {
                showDefaultDialog();
            }
        }
    }

    private void showSaveDraftDialog(String str) {
        UgcDialogUtils.showSaveDraftDialog(new DraftOnPositiveClickListener(new WeakReference(this), new SaveDraftTask(str), ((VideoBasePublishPresenter) this.mPublishPresenter).mInfo), new DraftOnNegativeClickListener(new WeakReference(this), ((VideoBasePublishPresenter) this.mPublishPresenter).mInfo, ((VideoBasePublishPresenter) this.mPublishPresenter).mDraftKey));
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
            ExecutorUtilsExt.postOnElastic(this.mSaveDraftTask, "saveToDraft", 1);
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
            DraftUtils.deleteDraft(this.mDraftKey);
            UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
            UgcUBCUtils.saveDraftPublishUbcStatistics(this.mUgcSchemeModel.sourceFrom, false, true, false, false);
            Activity activity = this.mWeakReference.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private void showDefaultDialog() {
        DialogUtils.showDialog(R.string.ugc_exit_publish_tips, R.string.ugc_publish_video_cancle, R.string.ugc_publish_confirm_exit, R.string.ugc_publish_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.activity.VideoPublishActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                VideoPublishActivity.this.finish();
                UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_CANCEL);
            }
        }, (DialogInterface.OnClickListener) null);
    }

    private boolean isInputEdited(String str) {
        boolean z = true;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId)) {
            return this.mEditedTag || !str.equals(((VideoBasePublishPresenter) this.mPublishPresenter).mDraftData.content);
        } else if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId)) {
            if (this.mEditedTag || !TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mDraftData.content)) {
                z2 = true;
            }
            return z2;
        } else {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(((VideoBasePublishPresenter) this.mPublishPresenter).mMediaId) || (str.equals(((VideoBasePublishPresenter) this.mPublishPresenter).mDraftData.content) && !this.mEditedTag)) {
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
            DraftData draftData = new DraftData();
            if (!TextUtils.isEmpty(this.inputStr)) {
                draftData.content = this.inputStr;
            }
            if (!TextUtils.isEmpty(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoPath)) {
                if (!TextUtils.isEmpty(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mMediaId)) {
                    draftData.mediaId = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mMediaId;
                }
                if (!TextUtils.isEmpty(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoProductionType)) {
                    draftData.videoProductionType = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoProductionType;
                }
                draftData.video = FileUtils.saveVideoDraft(VideoPublishActivity.this, ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoPath);
                if (!TextUtils.isEmpty(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoCover)) {
                    if (!TextUtils.isEmpty(FileUtils.saveImageDraft(VideoPublishActivity.this, ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoCover))) {
                        draftData.videoCover = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoCover;
                    }
                    draftData.videoCover = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mVideoCover;
                }
                if (!TextUtils.isEmpty(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mInfo.followVideoDataStr)) {
                    draftData.videoInfo = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mInfo.followVideoDataStr;
                }
            }
            draftData.timestamp = System.currentTimeMillis();
            draftData.target = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).getTargetJson();
            draftData.sourceKey = ((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mSourceKey;
            DraftUtils.saveDraft(((VideoBasePublishPresenter) VideoPublishActivity.this.mPublishPresenter).mDraftKey, draftData);
        }
    }

    @Override // com.baidu.searchbox.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            backDispose(this.mInput.getText().toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishStart() {
        super.showPublishStart();
        showProgressDialog();
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void showUploadFailed() {
        super.showUploadFailed();
        dismissProgressDialog();
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishFailed(String str) {
        super.showPublishFailed(str);
        dismissProgressDialog();
        setPublishBtnStatus();
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void showPublishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        if (this.mDialog != null) {
            this.mDialog.notifyProgress(100, 100);
        }
        dismissProgressDialog();
        finish();
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void onUploadVideoErrorCancle() {
        this.mVideoUploadView.setVisibility(8);
        this.mProgressBar.setProgress(0L);
        this.mAddVideoImg.setVisibility(0);
        DraftUtils.deleteDraft(((VideoBasePublishPresenter) this.mPublishPresenter).mDraftKey);
    }

    @Override // com.baidu.searchbox.ugc.activity.PublishBaseActivity, com.baidu.searchbox.ugc.activity.IPublishView
    public void updateUploadVideoProgress(long j, long j2) {
        if (j <= 100 && j2 <= 100) {
            updateProgress((((float) j) / ((float) j2)) * 100.0f);
        }
    }
}
