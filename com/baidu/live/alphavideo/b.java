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
/* loaded from: classes3.dex */
public class b implements c {
    private AlphaVideo anC;
    private c.a anD;
    private MediaPlayerProxy anE;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.anC;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.anD = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.anC != null) {
            return this.anC.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void dB(String str) {
        if (this.anC != null && !TextUtils.isEmpty(str)) {
            this.anC.setSourcePath(str);
            this.anC.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.anC != null) {
            this.anC.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.anE != null) {
            this.anE.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.anD = null;
        if (this.anC != null) {
            this.anC.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.anC == null || this.anC.isDestroyed();
    }

    private void init(Context context) {
        this.anC = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.anC;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.anE = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.anC.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.anD != null) {
                    b.this.anD.onStart();
                }
            }
        });
        this.anC.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.anD != null) {
                    b.this.anD.onEnd();
                }
            }
        });
        this.anC.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.anD.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.anD.onError(-1, "unknown");
                return false;
            }
        });
    }
}
