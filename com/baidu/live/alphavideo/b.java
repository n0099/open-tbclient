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
    private AlphaVideo anI;
    private c.a anJ;
    private MediaPlayerProxy anK;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.anI;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.anJ = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.anI != null) {
            return this.anI.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void dB(String str) {
        if (this.anI != null && !TextUtils.isEmpty(str)) {
            this.anI.setSourcePath(str);
            this.anI.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.anI != null) {
            this.anI.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.anK != null) {
            this.anK.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.anJ = null;
        if (this.anI != null) {
            this.anI.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.anI == null || this.anI.isDestroyed();
    }

    private void init(Context context) {
        this.anI = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.anI;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.anK = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.anI.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.anJ != null) {
                    b.this.anJ.onStart();
                }
            }
        });
        this.anI.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.anJ != null) {
                    b.this.anJ.onEnd();
                }
            }
        });
        this.anI.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.anJ.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.anJ.onError(-1, "unknown");
                return false;
            }
        });
    }
}
