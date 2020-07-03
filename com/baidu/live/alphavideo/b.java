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
    private AlphaVideo atU;
    private c.a atV;
    private MediaPlayerProxy atW;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.atU;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.atV = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.atU != null) {
            return this.atU.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void eh(String str) {
        if (this.atU != null && !TextUtils.isEmpty(str)) {
            this.atU.setSourcePath(str);
            this.atU.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.atU != null) {
            this.atU.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.atW != null) {
            this.atW.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.atV = null;
        if (this.atU != null) {
            this.atU.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.atU == null || this.atU.isDestroyed();
    }

    private void init(Context context) {
        this.atU = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.atU;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.atW = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.atU.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.atV != null) {
                    b.this.atV.onStart();
                }
            }
        });
        this.atU.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.atV != null) {
                    b.this.atV.onEnd();
                }
            }
        });
        this.atU.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.atV.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.atV.onError(-1, "unknown");
                return false;
            }
        });
    }
}
