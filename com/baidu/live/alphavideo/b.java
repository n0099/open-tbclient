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
    private AlphaVideo aDq;
    private c.a aDr;
    private MediaPlayerProxy aDs;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aDq;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aDr = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aDq != null) {
            return this.aDq.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aDq != null && !TextUtils.isEmpty(str)) {
            this.aDq.setSourcePath(str);
            this.aDq.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aDq != null) {
            this.aDq.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aDs != null) {
            this.aDs.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aDr = null;
        if (this.aDq != null) {
            this.aDq.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aDq == null || this.aDq.isDestroyed();
    }

    private void init(Context context) {
        this.aDq = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aDq;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aDs = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aDq.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aDr != null) {
                    b.this.aDr.onStart();
                }
            }
        });
        this.aDq.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aDr != null) {
                    b.this.aDr.onEnd();
                }
            }
        });
        this.aDq.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.aDr.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.aDr.onError(-1, "unknown");
                return false;
            }
        });
    }
}
