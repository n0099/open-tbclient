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
    private AlphaVideo aCJ;
    private c.a aCK;
    private MediaPlayerProxy aCL;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aCJ;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aCK = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aCJ != null) {
            return this.aCJ.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aCJ != null && !TextUtils.isEmpty(str)) {
            this.aCJ.setSourcePath(str);
            this.aCJ.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aCJ != null) {
            this.aCJ.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aCL != null) {
            this.aCL.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aCK = null;
        if (this.aCJ != null) {
            this.aCJ.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aCJ == null || this.aCJ.isDestroyed();
    }

    private void init(Context context) {
        this.aCJ = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aCJ;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aCL = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aCJ.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aCK != null) {
                    b.this.aCK.onStart();
                }
            }
        });
        this.aCJ.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aCK != null) {
                    b.this.aCK.onEnd();
                }
            }
        });
        this.aCJ.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.aCK.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.aCK.onError(-1, "unknown");
                return false;
            }
        });
    }
}
