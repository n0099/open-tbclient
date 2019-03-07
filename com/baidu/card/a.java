package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Xo;

    public a(x<T> xVar) {
        super(xVar);
        this.Xo = null;
        if (xVar.rq() instanceof ac) {
            this.Xo = (ac) xVar.rq();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Xo != null) {
            this.Xo.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Xo == null) {
            return false;
        }
        return this.Xo.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Xo == null) {
            return false;
        }
        return this.Xo.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Xo == null) {
            return false;
        }
        return this.Xo.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Xo != null) {
            this.Xo.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Xo != null) {
            this.Xo.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Xo == null) {
            return null;
        }
        return this.Xo.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Xo == null) {
            return null;
        }
        return this.Xo.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Xo == null) {
            return 0;
        }
        return this.Xo.getCurrentPosition();
    }
}
