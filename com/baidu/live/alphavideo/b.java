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
    private AlphaVideo aBu;
    private c.a aBv;
    private PlayerProxy aBw;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aBu;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aBv = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aBu != null) {
            return this.aBu.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void setLooping(boolean z) {
        if (z && !(this.aBw instanceof VideoPlayerProxy)) {
            AlphaVideo alphaVideo = this.aBu;
            VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
            this.aBw = videoPlayerProxy;
            alphaVideo.setPlayer(videoPlayerProxy);
        }
        this.aBu.setLooping(z);
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aBu != null && !TextUtils.isEmpty(str)) {
            this.aBu.setSourcePath(str);
            this.aBu.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aBu != null) {
            this.aBu.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aBw != null) {
            this.aBw.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aBv = null;
        if (this.aBu != null) {
            this.aBu.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aBu == null || this.aBu.isDestroyed();
    }

    private void init(Context context) {
        this.aBu = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aBu;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aBw = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aBu.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aBv != null) {
                    b.this.aBv.onStart();
                }
            }
        });
        this.aBu.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aBv != null) {
                    b.this.aBv.onEnd();
                }
            }
        });
        this.aBu.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (b.this.aBv != null) {
                    if (errorInfo != null) {
                        b.this.aBv.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    } else {
                        b.this.aBv.onError(-1, "unknown");
                    }
                }
                return false;
            }
        });
    }
}
