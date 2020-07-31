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
    private AlphaVideo atQ;
    private c.a atR;
    private MediaPlayerProxy atS;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.atQ;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.atR = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.atQ != null) {
            return this.atQ.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void eg(String str) {
        if (this.atQ != null && !TextUtils.isEmpty(str)) {
            this.atQ.setSourcePath(str);
            this.atQ.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.atQ != null) {
            this.atQ.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.atS != null) {
            this.atS.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.atR = null;
        if (this.atQ != null) {
            this.atQ.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.atQ == null || this.atQ.isDestroyed();
    }

    private void init(Context context) {
        this.atQ = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.atQ;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.atS = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.atQ.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.atR != null) {
                    b.this.atR.onStart();
                }
            }
        });
        this.atQ.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.atR != null) {
                    b.this.atR.onEnd();
                }
            }
        });
        this.atQ.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.atR.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.atR.onError(-1, "unknown");
                return false;
            }
        });
    }
}
