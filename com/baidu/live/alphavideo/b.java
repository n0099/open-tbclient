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
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.searchbox.afx.proxy.VideoPlayerProxy;
/* loaded from: classes10.dex */
public class b implements c {
    private AlphaVideo aCU;
    private c.a aCV;
    private PlayerProxy aCW;

    public b(Context context) {
        init(context);
    }

    @Override // com.baidu.live.alphavideo.c
    public View getView() {
        return this.aCU;
    }

    @Override // com.baidu.live.alphavideo.c
    public void a(c.a aVar) {
        this.aCV = aVar;
    }

    @Override // com.baidu.live.alphavideo.c
    public long getDuration() {
        if (this.aCU != null) {
            return this.aCU.getDuration();
        }
        return -1L;
    }

    @Override // com.baidu.live.alphavideo.c
    public void setLooping(boolean z) {
        if (z && !(this.aCW instanceof VideoPlayerProxy)) {
            AlphaVideo alphaVideo = this.aCU;
            VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
            this.aCW = videoPlayerProxy;
            alphaVideo.setPlayer(videoPlayerProxy);
        }
        this.aCU.setLooping(z);
    }

    @Override // com.baidu.live.alphavideo.c
    public void play(String str) {
        if (this.aCU != null && !TextUtils.isEmpty(str)) {
            this.aCU.setSourcePath(str);
            this.aCU.play();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void stop() {
        if (this.aCU != null) {
            this.aCU.stop();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void reset() {
        if (this.aCW != null) {
            this.aCW.reset();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public void release() {
        this.aCV = null;
        if (this.aCU != null) {
            this.aCU.destroy();
        }
    }

    @Override // com.baidu.live.alphavideo.c
    public boolean isDestroyed() {
        return this.aCU == null || this.aCU.isDestroyed();
    }

    private void init(Context context) {
        this.aCU = new AlphaVideo(context);
        AlphaVideo alphaVideo = this.aCU;
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
        this.aCW = mediaPlayerProxy;
        alphaVideo.setPlayer(mediaPlayerProxy);
        this.aCU.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.live.alphavideo.b.1
            @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
            public void onVideoStarted() {
                if (b.this.aCV != null) {
                    b.this.aCV.onStart();
                }
            }
        });
        this.aCU.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.live.alphavideo.b.2
            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                if (b.this.aCV != null) {
                    b.this.aCV.onEnd();
                }
            }
        });
        this.aCU.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.live.alphavideo.b.3
            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                if (b.this.aCV != null) {
                    if (errorInfo != null) {
                        b.this.aCV.onError(errorInfo.mErrorCode, errorInfo.mErrorMsg);
                    } else {
                        b.this.aCV.onError(-1, "unknown");
                    }
                }
                return false;
            }
        });
    }
}
