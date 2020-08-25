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
    private AlphaVideo ayS;
    private c.a ayT;
    private MediaPlayerProxy ayU;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.ayS;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.ayT = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.ayS != null) {
            return this.ayS.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.ayS != null && !TextUtils.isEmpty(str)) {
            this.ayS.setSourcePath(str);
            this.ayS.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.ayS != null) {
            this.ayS.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.ayU != null) {
            this.ayU.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.ayT = null;
        if (this.ayS != null) {
            this.ayS.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.ayS == null || this.ayS.isDestroyed();
    }

    private void init(Context context) {
        this.ayS = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.ayS;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.ayU = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.ayS.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.ayT != null) {
                    b.this.ayT.onStart();
                }
            }
        });
        this.ayS.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.ayT != null) {
                    b.this.ayT.onEnd();
                }
            }
        });
        this.ayS.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.ayT.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.ayT.onError(-1, "unknown");
                return false;
            }
        });
    }
}
