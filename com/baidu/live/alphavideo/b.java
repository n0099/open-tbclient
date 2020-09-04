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
/* loaded from: classes7.dex */
public class b implements c {
    private AlphaVideo ayU;
    private c.a ayV;
    private MediaPlayerProxy ayW;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.ayU;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.ayV = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.ayU != null) {
            return this.ayU.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.ayU != null && !TextUtils.isEmpty(str)) {
            this.ayU.setSourcePath(str);
            this.ayU.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.ayU != null) {
            this.ayU.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.ayW != null) {
            this.ayW.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.ayV = null;
        if (this.ayU != null) {
            this.ayU.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.ayU == null || this.ayU.isDestroyed();
    }

    private void init(Context context) {
        this.ayU = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.ayU;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.ayW = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.ayU.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.ayV != null) {
                    b.this.ayV.onStart();
                }
            }
        });
        this.ayU.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.ayV != null) {
                    b.this.ayV.onEnd();
                }
            }
        });
        this.ayU.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.ayV.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.ayV.onError(-1, "unknown");
                return false;
            }
        });
    }
}
