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
    private AlphaVideo VO;
    private c.a VP;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.VO;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.VP = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.VO != null) {
            return this.VO.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void cQ(String str) {
        if (this.VO != null && !TextUtils.isEmpty(str)) {
            this.VO.setSourcePath(str);
            this.VO.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.VO != null) {
            this.VO.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.VP = null;
        if (this.VO != null) {
            this.VO.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.VO == null || this.VO.isDestroyed();
    }

    private void init(Context context) {
        this.VO = new AlphaVideo(context);
        this.VO.setPlayer(new MediaPlayerProxy());
        this.VO.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.VP != null) {
                    b.this.VP.onStart();
                }
            }
        });
        this.VO.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.VP != null) {
                    b.this.VP.onEnd();
                }
            }
        });
        this.VO.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (errorInfo != null) {
                    b.this.VP.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    return false;
                }
                b.this.VP.onError(-1, "unknown");
                return false;
            }
        });
    }
}
