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
    private AlphaVideo asC;
    private c.a asD;
    private MediaPlayerProxy asE;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.asC;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.asD = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.asC != null) {
            return this.asC.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void ef(String str) {
        if (this.asC != null && !TextUtils.isEmpty(str)) {
            this.asC.setSourcePath(str);
            this.asC.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.asC != null) {
            this.asC.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.asE != null) {
            this.asE.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.asD = null;
        if (this.asC != null) {
            this.asC.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.asC == null || this.asC.isDestroyed();
    }

    private void init(Context context) {
        this.asC = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.asC;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.asE = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.asC.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.asD != null) {
                    b.this.asD.onStart();
                }
            }
        });
        this.asC.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.asD != null) {
                    b.this.asD.onEnd();
                }
            }
        });
        this.asC.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.asD.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.asD.onError(-1, "unknown");
                return false;
            }
        });
    }
}
