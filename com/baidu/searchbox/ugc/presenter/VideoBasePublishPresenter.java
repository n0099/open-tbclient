package com.baidu.searchbox.ugc.presenter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.net.http.Headers;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.Sender;
import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.IPublishView;
import com.baidu.searchbox.ugc.dialog.UGCBoxActivityDialog;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.emoji.EmojiconHandler;
import com.baidu.searchbox.ugc.emoji.edittextrule.TopicRule;
import com.baidu.searchbox.ugc.model.FollowVideoData;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.provider.listener.OnVideoShareListener;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.google.gson.Gson;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class VideoBasePublishPresenter extends BasePublishPresenter implements EmojiconEditText.TextNumbersChangedListener {
    protected static final int MINI_VIDEO = 1;
    protected static final int UGC_VIDEO = 0;
    public FollowVideoData followVideoData;
    public String mChannel;
    private ClipboardManager mClip;
    public DraftData mDraftData;
    public String mDraftKey;
    private int mIndex;
    public boolean mIsSuccess;
    public String mMediaId;
    protected int mNumberTvColor;
    private SoftReference<OnVideoShareListener> mOnVideoShareListener;
    public String mSourceKey;
    public int mSourceType;
    public int mSourceid;
    private TopicRule.TopicMapSizeChangeListener mTopicMapSizeChangeListener;
    public boolean mTuneupPlugin;
    public boolean mUploadding;
    public String mVideoCover;
    public String mVideoPath;
    public String mVideoProductionType;
    public static final String TAG = VideoBasePublishPresenter.class.getSimpleName();
    public static final boolean DEBUG = AppConfig.isDebug();

    static /* synthetic */ int access$208(VideoBasePublishPresenter videoBasePublishPresenter) {
        int i = videoBasePublishPresenter.mIndex;
        videoBasePublishPresenter.mIndex = i + 1;
        return i;
    }

    public VideoBasePublishPresenter(IPublishView iPublishView) {
        super(iPublishView);
        this.followVideoData = new FollowVideoData();
        this.mIndex = 0;
        this.mNumberTvColor = R.color.ugc_publish_no_able_color;
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void onCreate(UgcSchemeModel ugcSchemeModel) {
        super.onCreate(ugcSchemeModel);
        OnVideoShareListener onVideoShareListener = PublisherManagerFactory.get().getOnVideoShareListener();
        if (onVideoShareListener != null) {
            this.mOnVideoShareListener = new SoftReference<>(onVideoShareListener);
        }
    }

    public void initTargetRuleAndUbc(EmojiconEditText emojiconEditText) {
        addTargetRule(emojiconEditText);
        if (this.mSourceType == 0) {
            UgcUBCUtils.ugcPvStatistics(1, "publish");
        } else {
            UgcUBCUtils.miniVideoStatistics(UgcUBCUtils.MINI_VIDEO_FROM, UgcUBCUtils.MINI_VIDEO_PUBLISH, netStatus(NetWorkUtils.getNetworkClass()));
        }
    }

    private static String netStatus(String str) {
        if (TextUtils.equals("wifi", str)) {
            return "1";
        }
        if (TextUtils.equals("2g", str)) {
            return "2";
        }
        if (TextUtils.equals("3g", str)) {
            return "3";
        }
        if (TextUtils.equals("4g", str)) {
            return "4";
        }
        return "0";
    }

    public void videoTopic(EmojiconEditText emojiconEditText) {
        this.mClip = (ClipboardManager) this.mPublishView.getContext().getSystemService("clipboard");
        this.mTopicMapSizeChangeListener = new TopicRule.TopicMapSizeChangeListener() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.1
            @Override // com.baidu.searchbox.ugc.emoji.edittextrule.TopicRule.TopicMapSizeChangeListener
            public void onSizeChange(int i) {
                if (i == 0) {
                    VideoBasePublishPresenter.this.mPublishView.getTopicSelectIv().setClickable(true);
                    VideoBasePublishPresenter.this.mPublishView.getTopicSelectIv().setAlpha(1.0f);
                    VideoBasePublishPresenter.this.mTopicRule.setIsCallPatternTagInput(true);
                } else if (i == 1) {
                    VideoBasePublishPresenter.this.mPublishView.getTopicSelectIv().setClickable(false);
                    VideoBasePublishPresenter.this.mPublishView.getTopicSelectIv().setAlpha(0.2f);
                    VideoBasePublishPresenter.this.mTopicRule.setIsCallPatternTagInput(false);
                } else {
                    VideoBasePublishPresenter.this.mPublishView.getTopicSelectIv().setClickable(false);
                    VideoBasePublishPresenter.this.mPublishView.getTopicSelectIv().setAlpha(0.2f);
                    VideoBasePublishPresenter.this.mTopicRule.setIsCallPatternTagInput(false);
                }
            }
        };
        this.mTopicRule.setTopicMapSizeChangeListener(this.mTopicMapSizeChangeListener);
        emojiconEditText.setPasteKeyEventListener(new EmojiconEditText.OnPasteKeyEventListener() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.2
            @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.OnPasteKeyEventListener
            public void onPasteClick() {
                ClipData primaryClip = VideoBasePublishPresenter.this.mClip.getPrimaryClip();
                if (primaryClip != null) {
                    for (int i = 0; i < primaryClip.getItemCount(); i++) {
                        VideoBasePublishPresenter.this.mClip.setPrimaryClip(ClipData.newPlainText("simple text", HanziToPinyin.Token.SEPARATOR + primaryClip.getItemAt(i).coerceToStyledText(VideoBasePublishPresenter.this.mPublishView.getContext().getBaseContext()).toString()));
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void addChanged(int i) {
        TextView numberTV = this.mPublishView.getNumberTV();
        if (numberTV == null) {
            Log.e(TAG, "mNumberTv is null");
            return;
        }
        numberTV.setText(String.format(this.mPublishView.getContext().getString(R.string.ugc_input_number_count), Integer.valueOf(i), Integer.valueOf(getDynamicWordLimit(this.mVideoPath))));
        UgcUiUtils.setTextResource(numberTV, R.color.ugc_red);
        setClickState(this.mPublishView.getPublishTv(), false);
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void reduceChanged(final int i) {
        final TextView numberTV = this.mPublishView.getNumberTV();
        if (numberTV == null) {
            Log.e(TAG, "mNumberTv is null");
            return;
        }
        numberTV.post(new Runnable() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                numberTV.setText(String.format(VideoBasePublishPresenter.this.mPublishView.getContext().getString(R.string.ugc_input_number_count), Integer.valueOf(i), Integer.valueOf(VideoBasePublishPresenter.this.getDynamicWordLimit(VideoBasePublishPresenter.this.mVideoPath))));
            }
        });
        UgcUiUtils.setTextResource(numberTV, this.mNumberTvColor);
        TextView publishTv = this.mPublishView.getPublishTv();
        if (publishTv == null) {
            Log.e(TAG, "reduceChanged mPublishTv = null");
        }
        setClickState(publishTv, canPublish(i, this.mMediaId));
    }

    protected boolean canPublish(int i, String str) {
        if (i == 0) {
            return !TextUtils.isEmpty(str);
        } else if (this.mUploadding) {
            return false;
        } else {
            return i <= getDynamicWordLimit(this.mVideoPath) && i > 0;
        }
    }

    @Override // com.baidu.searchbox.ugc.emoji.EmojiconEditText.TextNumbersChangedListener
    public void back() {
    }

    public void initDraftData(EmojiconEditText emojiconEditText) {
        if (this.mInfo != null) {
            if (!TextUtils.equals("9", this.mInfo.publishType)) {
                this.mDraftKey = DraftUtils.getDraftKey(this.mInfo);
                this.mDraftData = DraftUtils.getDraft(this.mDraftKey);
            }
            if (this.mDraftData != null && !this.mInfo.isFollowVideo) {
                if (!TextUtils.isEmpty(this.mDraftData.content)) {
                    emojiconEditText.setText(this.mDraftData.content);
                    emojiconEditText.handleDraftEmojiDisplay();
                    emojiconEditText.setSelection(emojiconEditText.length());
                }
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
                if (!TextUtils.isEmpty(this.mDraftData.videoInfo)) {
                    this.followVideoData.parseFromString(TextUtils.isEmpty(this.mDraftData.videoInfo) ? "" : this.mDraftData.videoInfo);
                }
                if (this.mDraftData.target != null) {
                    this.mTarget = (UGCTarget) new Gson().fromJson(this.mDraftData.target, (Class<Object>) UGCTarget.class);
                }
                if (!TextUtils.isEmpty(this.mDraftData.sourceKey)) {
                    this.mSourceKey = this.mDraftData.sourceKey;
                }
            } else {
                this.mVideoPath = this.mInfo.path;
                this.mVideoCover = this.mInfo.videoCover;
                this.followVideoData.parseFromString(TextUtils.isEmpty(this.mInfo.followVideoDataStr) ? "" : this.mInfo.followVideoDataStr);
                this.mVideoProductionType = this.mInfo.videoProductionType;
                if (!TextUtils.isEmpty(this.mInfo.target)) {
                    this.mTarget = (UGCTarget) new Gson().fromJson(this.mInfo.target, (Class<Object>) UGCTarget.class);
                }
            }
            this.mSourceid = this.mInfo.sourceid;
            this.mSourceType = this.mInfo.sourceType;
            this.mChannel = this.mInfo.channel;
            this.mTuneupPlugin = this.mInfo.tuneupPlugin;
        }
    }

    public void onPublish(final String str) {
        if (this.mEnableClick) {
            ILoginResultListener iLoginResultListener = new ILoginResultListener() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.4
                @Override // com.baidu.searchbox.account.ILoginResultListener
                public void onResult(int i) {
                    if (i == 0) {
                        VideoBasePublishPresenter.this.publish(str);
                    }
                }
            };
            if (!UgcLoginUtils.isLogin()) {
                UgcLoginUtils.login(iLoginResultListener, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            } else if (!UgcLoginUtils.isGuestLogin()) {
                publish(str);
            } else {
                UgcLoginUtils.bindPhone(iLoginResultListener, UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, UgcLoginUtils.UGC_LOGIN_SRC);
            }
            UgcUBCUtils.ugcUbcStatistics("593", UgcUBCUtils.UGC_TYPE_PUBLISH_CLICK, null, "publish");
        }
    }

    protected void publish(String str, HttpRequestPublishModule.VideoUploadModel videoUploadModel) {
        setClickState(this.mPublishView.getPublishTv(), false);
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.mTarget == null) {
                this.mTarget = new UGCTarget();
            }
            if (this.mTopicRule != null) {
                this.mTopicRule.obtainTopicList(this.mTarget.mTopicList);
            }
            if (this.mAtRule != null) {
                this.mAtRule.obtainUserInfoList(this.mTarget.mUserInfoList);
            }
            if (this.mTarget.tagList != null && this.mPublishView.getTag() != null) {
                this.mTarget.tagList.add(this.mPublishView.getTag());
            }
            if (this.mTarget != null) {
                jSONObject.putOpt("target", new JSONObject(new Gson().toJson(this.mTarget)));
            }
            publishRequestModel.data = jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishRequestModel.inputStr = str;
        publishRequestModel.postUrl = this.mPostUrl;
        publishRequestModel.sourceFrom = this.mSourceFrom;
        publishRequestModel.topic = this.mTopicObject;
        publishRequestModel.extObject = this.mExtObject;
        publishRequestModel.sourceid = this.mSourceid;
        publishRequestModel.sourceKey = this.mSourceKey;
        publishRequestModel.sourceType = this.mSourceType;
        publishRequestModel.videoInfo = videoUploadModel;
        publishRequestModel.swanObject = this.mSwanObject;
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.5
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                VideoBasePublishPresenter.this.publishSuccess(publishResultInfo);
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str2) {
                VideoBasePublishPresenter.this.publishFail(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publish(final String str) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.mMediaId)) {
            if (TextUtils.isEmpty(this.mMediaId)) {
                if (this.mSourceType == 1) {
                    UniversalToast.makeText(this.mPublishView.getContext(), this.mPublishView.getContext().getString(R.string.ugc_add_video_tips)).showToast();
                } else {
                    UGCBoxActivityDialog.newBuilder().setTitle(R.string.ugc_publish_prompt).setMessage(R.string.ugc_publish_no_video_prompt).setPositiveButton(R.string.ugc_publish_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            VideoBasePublishPresenter.this.publish(str, null);
                        }
                    }).setNegativeButton(R.string.ugc_publish_cancel, (DialogInterface.OnClickListener) null).show();
                }
            } else {
                showPublishStart();
                publishVideo(str);
            }
            UgcUBCUtils.clickLayerStatistics(1, UgcUBCUtils.mPublcshVideoBtnPage);
        }
    }

    protected void showPublishStart() {
        this.mPublishView.showPublishStart();
    }

    protected void publishVideo(String str) {
        ArrayList<ImageStruct> arrayList = new ArrayList<>();
        String saveBitmap = FileUtils.saveBitmap(FileUtils.getLocalVideoBitmap(this.mVideoPath));
        if (TextUtils.isEmpty(this.mVideoCover)) {
            if (!TextUtils.isEmpty(this.mVideoPath)) {
                arrayList.add(new ImageStruct(saveBitmap));
            }
        } else {
            arrayList.add(new ImageStruct(this.mVideoCover));
            arrayList.add(new ImageStruct(saveBitmap));
        }
        startUploadImages(str, arrayList);
    }

    private void startUploadImages(final String str, final ArrayList<ImageStruct> arrayList) {
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.7
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
                VideoBasePublishPresenter.this.mPublishView.showUploadFailed();
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
                    UniversalToast.makeText(VideoBasePublishPresenter.this.mPublishView.getContext().getApplicationContext(), R.string.ugc_release_fail).showToast();
                    return;
                }
                HttpRequestPublishModule.VideoUploadModel videoUploadInfo = HttpRequestPublishModule.getVideoUploadInfo();
                if (VideoBasePublishPresenter.this.mIndex == 0) {
                    videoUploadInfo.coverUrl = uploadFileTask.getUrl();
                    if (arrayList.size() == 1) {
                        videoUploadInfo.videoFirstFrame = uploadFileTask.getUrl();
                    }
                } else {
                    videoUploadInfo.videoFirstFrame = uploadFileTask.getUrl();
                }
                VideoBasePublishPresenter.access$208(VideoBasePublishPresenter.this);
                if (VideoBasePublishPresenter.this.mIndex == arrayList.size()) {
                    videoUploadInfo.mediaId = VideoBasePublishPresenter.this.mMediaId;
                    if (VideoBasePublishPresenter.this.followVideoData != null) {
                        videoUploadInfo.authorUK = VideoBasePublishPresenter.this.followVideoData.mAuthorUK;
                        videoUploadInfo.musicName = VideoBasePublishPresenter.this.followVideoData.mMusicName;
                        videoUploadInfo.soundSrc = VideoBasePublishPresenter.this.followVideoData.mSoundSrc;
                        videoUploadInfo.bgSound = VideoBasePublishPresenter.this.followVideoData.mBgSound;
                        videoUploadInfo.bgSoundRec = VideoBasePublishPresenter.this.followVideoData.mBgSoundRec;
                    }
                    if (!TextUtils.isEmpty(VideoBasePublishPresenter.this.mVideoProductionType)) {
                        videoUploadInfo.videoProductionType = VideoBasePublishPresenter.this.mVideoProductionType;
                    }
                    VideoBasePublishPresenter.this.publish(str, videoUploadInfo);
                    FileUtils.deleteCoverFile(new File(Environment.getExternalStorageDirectory().getPath() + FileUtils.VIDEOCOVER));
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                VideoBasePublishPresenter.this.mPublishView.showUploadFailed();
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.ugc_release_fail).showToast();
            }
        });
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
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

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void publishSuccess(PublishModels.PublishResultInfo publishResultInfo) {
        OnVideoShareListener onVideoShareListener;
        super.publishSuccess(publishResultInfo);
        if (this.mInfo != null && this.mInfo.isFollowVideo) {
            try {
                if (publishResultInfo.data != null && publishResultInfo.data.subData != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("video_id", publishResultInfo.data.subData.vid);
                    Sender.sendBroadcast(this.mPublishView.getContext(), "com.baidu.channel.ugc.publish_finish", jSONObject.toString());
                    this.mPublishView.showPublishSuccess(publishResultInfo);
                    UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_PUB);
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.mSourceType == 1 && TextUtils.isEmpty(this.mUgcCallback) && TextUtils.equals("tiny", this.mSourceFrom) && this.mInfo != null && !TextUtils.equals("9", this.mInfo.publishType) && publishResultInfo.data != null && publishResultInfo.data.subData != null) {
            BaseRouter.invoke(this.mPublishView.getContext(), getSchemeUrl(publishResultInfo.data.subData.vid));
        }
        if (this.mOnVideoShareListener != null && publishResultInfo.data != null && publishResultInfo.data.subData != null && (onVideoShareListener = this.mOnVideoShareListener.get()) != null) {
            onVideoShareListener.onShareSuccess(publishResultInfo.data.subData.metaId);
        }
        DraftUtils.deleteDraft(this.mDraftKey);
        UgcUBCUtils.exitUnForwardPage(UgcUBCUtils.UGC_TIME_PUB);
        this.mPublishView.showPublishSuccess(publishResultInfo);
    }

    private String getSchemeUrl(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", this.mSourceFrom);
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put(Headers.REFRESH, "1");
            jSONObject.put("channel", this.mChannel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "baiduboxapp://v11/appTab/select?item=miniVideo&upgrade=0&params=" + jSONObject.toString();
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void publishFail(String str) {
        OnVideoShareListener onVideoShareListener;
        super.publishFail(str);
        if (this.mOnVideoShareListener != null && (onVideoShareListener = this.mOnVideoShareListener.get()) != null) {
            onVideoShareListener.onShareFailed(str);
        }
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void onDestroy(EmojiconEditText emojiconEditText) {
        super.onDestroy(emojiconEditText);
        UploadManager.getInstance().release();
        EventBusWrapper.unregister(this);
        this.mClip = null;
        this.mTopicMapSizeChangeListener = null;
        EmojiconHandler.removeAddTopicItemListener();
        if (emojiconEditText != null) {
            emojiconEditText.removeListener();
        }
    }

    public void startUploadVideo(final String str) {
        Runnable uploadVideoTask;
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.8
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                VideoBasePublishPresenter.this.mIsSuccess = false;
                VideoBasePublishPresenter.this.mUploadding = false;
                BoxAlertDialog.Builder message = new BoxAlertDialog.Builder(VideoBasePublishPresenter.this.mPublishView.getContext()).setTitle(R.string.ugc_publish_prompt).setMessage(R.string.ugc_publish_upload_fail);
                message.setPositiveButton(R.string.ugc_publish_upload_video, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.8.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        VideoBasePublishPresenter.this.startUploadVideo(str);
                    }
                }).setNegativeButton(R.string.ugc_publish_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter.8.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        VideoBasePublishPresenter.this.mPublishView.onUploadVideoErrorCancle();
                    }
                });
                message.create().show();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
                if (j > 0 && j2 > j) {
                    float f = ((float) j) / ((float) j2);
                    VideoBasePublishPresenter.this.mPublishView.updateUploadVideoProgress(j, j2);
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
                VideoBasePublishPresenter.this.mPublishView.setVideoUploadStart();
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                VideoBasePublishPresenter.this.mMediaId = uploadFileTask.getUrl();
                VideoBasePublishPresenter.this.mSourceKey = uploadFileTask.getBosKey();
                VideoBasePublishPresenter.this.mPublishView.setVideoUploadEnd();
                VideoBasePublishPresenter.this.mIsSuccess = true;
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                VideoBasePublishPresenter.this.mPublishView.setVideoUploadEnd();
            }
        });
        ArrayList arrayList = new ArrayList();
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null && (uploadVideoTask = iPublisherSboxVideoInterface.getUploadVideoTask(str)) != null && (uploadVideoTask instanceof UploadFileTask)) {
            arrayList.add((UploadFileTask) uploadVideoTask);
        }
        UploadManager.getInstance().startAll(arrayList, this.mSourceType, "ugc");
    }
}
