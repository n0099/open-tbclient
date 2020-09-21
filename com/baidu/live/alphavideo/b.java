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
/* loaded from: classes4.dex */
public class b implements c {
    private AlphaVideo azA;
    private c.a azB;
    private MediaPlayerProxy azC;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.azA;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.azB = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.azA != null) {
            return this.azA.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.azA != null && !TextUtils.isEmpty(str)) {
            this.azA.setSourcePath(str);
            this.azA.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.azA != null) {
            this.azA.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.azC != null) {
            this.azC.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.azB = null;
        if (this.azA != null) {
            this.azA.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.azA == null || this.azA.isDestroyed();
    }

    private void init(Context context) {
        this.azA = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.azA;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.azC = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.azA.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.azB != null) {
                    b.this.azB.onStart();
                }
            }
        });
        this.azA.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.azB != null) {
                    b.this.azB.onEnd();
                }
            }
        });
        this.azA.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.azB.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.azB.onError(-1, "unknown");
                return false;
            }
        });
    }
}
