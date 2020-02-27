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
    private AlphaVideo VE;
    private c.a VF;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.VE;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.VF = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.VE != null) {
            return this.VE.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void cR(String str) {
        if (this.VE != null && !TextUtils.isEmpty(str)) {
            this.VE.setSourcePath(str);
            this.VE.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.VE != null) {
            this.VE.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.VF = null;
        if (this.VE != null) {
            this.VE.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.VE == null || this.VE.isDestroyed();
    }

    private void init(Context context) {
        this.VE = new AlphaVideo(context);
        this.VE.setPlayer(new MediaPlayerProxy());
        this.VE.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.VF != null) {
                    b.this.VF.onStart();
                }
            }
        });
        this.VE.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.VF != null) {
                    b.this.VF.onEnd();
                }
            }
        });
        this.VE.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.VF.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.VF.onError(-1, "unknown");
                return false;
            }
        });
    }
}
