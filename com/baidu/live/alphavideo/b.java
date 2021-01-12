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
/* loaded from: classes10.dex */
public class b implements c {
    private AlphaVideo azP;
    private c.a azQ;
    private PlayerProxy azR;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.azP;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.azQ = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.azP != null) {
            return this.azP.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void setLooping(boolean z) {
        if (z && !(this.azR instanceof VideoPlayerProxy)) {
            AlphaVideo alphaVideo = this.azP;
            VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
            this.azR = videoPlayerProxy;
            alphaVideo.setPlayer(videoPlayerProxy);
        }
        this.azP.setLooping(z);
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.azP != null && !TextUtils.isEmpty(str)) {
            this.azP.setSourcePath(str);
            this.azP.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.azP != null) {
            this.azP.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.azR != null) {
            this.azR.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.azQ = null;
        if (this.azP != null) {
            this.azP.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.azP == null || this.azP.isDestroyed();
    }

    private void init(Context context) {
        this.azP = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.azP;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.azR = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.azP.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.azQ != null) {
                    b.this.azQ.onStart();
                }
            }
        });
        this.azP.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.azQ != null) {
                    b.this.azQ.onEnd();
                }
            }
        });
        this.azP.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.azQ.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.azQ.onError(-1, "unknown");
                return false;
            }
        });
    }
}
