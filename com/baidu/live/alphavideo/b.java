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
    private AlphaVideo aBF;
    private c.a aBG;
    private MediaPlayerProxy aBH;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aBF;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aBG = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aBF != null) {
            return this.aBF.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aBF != null && !TextUtils.isEmpty(str)) {
            this.aBF.setSourcePath(str);
            this.aBF.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aBF != null) {
            this.aBF.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aBH != null) {
            this.aBH.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aBG = null;
        if (this.aBF != null) {
            this.aBF.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aBF == null || this.aBF.isDestroyed();
    }

    private void init(Context context) {
        this.aBF = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aBF;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aBH = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aBF.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aBG != null) {
                    b.this.aBG.onStart();
                }
            }
        });
        this.aBF.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aBG != null) {
                    b.this.aBG.onEnd();
                }
            }
        });
        this.aBF.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.aBG.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.aBG.onError(-1, "unknown");
                return false;
            }
        });
    }
}
