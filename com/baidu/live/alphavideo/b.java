package com.baidu.live.alphavideo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.alphavideo.c;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.proxy.MediaPlayerProxy;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.searchbox.afx.proxy.VideoPlayerProxy;
/* loaded from: classes4.dex */
public class b implements c {
    private AlphaVideo aEl;
    private c.a aEm;
    private PlayerProxy aEn;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aEl;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aEm = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aEl != null) {
            return this.aEl.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void setLooping(boolean z) {
        if (z && !(this.aEn instanceof VideoPlayerProxy)) {
            AlphaVideo alphaVideo = this.aEl;
            VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
            this.aEn = videoPlayerProxy;
            alphaVideo.setPlayer(videoPlayerProxy);
        }
        this.aEl.setLooping(z);
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aEl != null && !TextUtils.isEmpty(str)) {
            this.aEl.setSourcePath(str);
            this.aEl.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aEl != null) {
            this.aEl.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aEn != null) {
            this.aEn.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aEm = null;
        if (this.aEl != null) {
            this.aEl.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aEl == null || this.aEl.isDestroyed();
    }

    private void init(Context context) {
        this.aEl = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aEl;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aEn = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aEl.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aEm != null) {
                    b.this.aEm.onStart();
                }
            }
        });
        this.aEl.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aEm != null) {
                    b.this.aEm.onEnd();
                }
            }
        });
        this.aEl.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.aEm.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.aEm.onError(-1, "unknown");
                return false;
            }
        });
    }
}
