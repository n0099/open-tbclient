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
/* loaded from: classes11.dex */
public class b implements c {
    private AlphaVideo aEC;
    private c.a aED;
    private PlayerProxy aEE;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aEC;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aED = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aEC != null) {
            return this.aEC.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void setLooping(boolean z) {
        if (z && !(this.aEE instanceof VideoPlayerProxy)) {
            AlphaVideo alphaVideo = this.aEC;
            VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
            this.aEE = videoPlayerProxy;
            alphaVideo.setPlayer(videoPlayerProxy);
        }
        this.aEC.setLooping(z);
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aEC != null && !TextUtils.isEmpty(str)) {
            this.aEC.setSourcePath(str);
            this.aEC.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aEC != null) {
            this.aEC.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aEE != null) {
            this.aEE.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aED = null;
        if (this.aEC != null) {
            this.aEC.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aEC == null || this.aEC.isDestroyed();
    }

    private void init(Context context) {
        this.aEC = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aEC;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aEE = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aEC.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aED != null) {
                    b.this.aED.onStart();
                }
            }
        });
        this.aEC.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aED != null) {
                    b.this.aED.onEnd();
                }
            }
        });
        this.aEC.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.aED.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.aED.onError(-1, "unknown");
                return false;
            }
        });
    }
}
