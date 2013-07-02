package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.cyberplayer.sdk.internal.CommonUtils;
import com.baidu.cyberplayer.sdk.internal.CyberPlayerEngineVersion;
import com.baidu.cyberplayer.sdk.internal.GlobalConstants;
import com.baidu.cyberplayer.sdk.internal.IVideoViewBridge;
import com.baidu.cyberplayer.sdk.internal.LogUtils;
/* loaded from: classes.dex */
public class BVideoView extends RelativeLayout {
    public static final int DECODE_HW = 0;
    public static final int DECODE_SW = 1;
    public static final int MEDIA_ERROR_DISPLAY = 304;
    public static final int MEDIA_ERROR_EIO = 305;
    public static final int MEDIA_ERROR_INVALID_INPUTFILE = 302;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_NO_INPUTFILE = 301;
    public static final int MEDIA_ERROR_NO_SUPPORTED_CODEC = 303;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UAS_ERRORPARAM = 513;
    public static final int MEDIA_ERROR_UAS_ERR_USER_SIGN = 546;
    public static final int MEDIA_ERROR_UAS_USER_NOT_EXIT = 543;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_PLAYING_AVDIFFERENCE = 851;
    public static final int MEDIA_INFO_PLAYING_QUALITY = 850;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    private IVideoViewBridge a;

    /* loaded from: classes.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    /* loaded from: classes.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnPlayingBufferCacheListener {
        void onPlayingBufferCache(int i);
    }

    /* loaded from: classes.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    public BVideoView(Context context) {
        super(context);
        this.a = null;
        this.a = BCyberPlayerFactory.a(context, this);
        a();
    }

    public BVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.a = BCyberPlayerFactory.a(context, attributeSet, this);
        a();
    }

    public BVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.a = BCyberPlayerFactory.a(context, attributeSet, i, this);
        a();
    }

    private void a() {
        addView(this.a.getVideoView());
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.a.setOnPreparedListener(onPreparedListener);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.a.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.a.setOnErrorListener(onErrorListener);
    }

    public void setOnPlayingBufferCacheListener(OnPlayingBufferCacheListener onPlayingBufferCacheListener) {
        String version = CyberPlayerEngineVersion.getVersion(null);
        if (CommonUtils.versionStrToNum(version) < CommonUtils.versionStrToNum(GlobalConstants.INNER_VERSION)) {
            LogUtils.w("BVideoView", "setOnPlayingBufferCacheListener api added in mediacloud-1.1, but current engine is " + version + ", ignore", new Object[0]);
        } else {
            this.a.setOnPlayingBufferCacheListener(onPlayingBufferCacheListener);
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.a.setOnInfoListener(onInfoListener);
    }

    public IVideoViewBridge getWebViewWrapper() {
        return this.a;
    }

    public RelativeLayout getVideoView() {
        if (this.a != null) {
            return this.a.getVideoView();
        }
        return null;
    }

    public void setDecodeMode(int i) {
        this.a.setDecodeMode(i);
    }

    public void showCacheInfo(boolean z) {
        String version = CyberPlayerEngineVersion.getVersion(null);
        if (CommonUtils.versionStrToNum(version) < CommonUtils.versionStrToNum(GlobalConstants.INNER_VERSION)) {
            LogUtils.w("BVideoView", "showCacheInfo api added in mediacloud-1.1, but current engine is " + version + ", ignore", new Object[0]);
        } else {
            this.a.showCacheInfo(z);
        }
    }

    public void setVideoPath(String str) {
        this.a.setVideoPath(str);
    }

    public void start() {
        this.a.start();
    }

    public int getCurrentPosition() {
        return this.a.getCurrentPosition();
    }

    public int getDuration() {
        return this.a.getDuration();
    }

    public boolean isPlaying() {
        return this.a.isPlaying();
    }

    public void pause() {
        this.a.pause();
    }

    public void resume() {
        this.a.resume();
    }

    public void seekTo(int i) {
        this.a.seekTo(i);
    }

    public void stopPlayback() {
        this.a.stopPlayback();
    }

    public void setMediaController(BMediaController bMediaController) {
        this.a.setMediaControllerBridge(bMediaController.getVideoViewControllerBridge());
    }

    public int getVideoWidth() {
        return this.a.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.a.getVideoHeight();
    }
}
