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
    private AlphaVideo aCF;
    private c.a aCG;
    private MediaPlayerProxy aCH;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aCF;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aCG = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aCF != null) {
            return this.aCF.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aCF != null && !TextUtils.isEmpty(str)) {
            this.aCF.setSourcePath(str);
            this.aCF.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aCF != null) {
            this.aCF.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aCH != null) {
            this.aCH.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aCG = null;
        if (this.aCF != null) {
            this.aCF.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aCF == null || this.aCF.isDestroyed();
    }

    private void init(Context context) {
        this.aCF = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aCF;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aCH = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aCF.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aCG != null) {
                    b.this.aCG.onStart();
                }
            }
        });
        this.aCF.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aCG != null) {
                    b.this.aCG.onEnd();
                }
            }
        });
        this.aCF.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.aCG.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.aCG.onError(-1, "unknown");
                return false;
            }
        });
    }
}
