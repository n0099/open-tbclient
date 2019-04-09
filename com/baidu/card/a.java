package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Xq;

    public a(x<T> xVar) {
        super(xVar);
        this.Xq = null;
        if (xVar.rq() instanceof ac) {
            this.Xq = (ac) xVar.rq();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Xq != null) {
            this.Xq.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Xq == null) {
            return false;
        }
        return this.Xq.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Xq == null) {
            return false;
        }
        return this.Xq.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Xq == null) {
            return false;
        }
        return this.Xq.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Xq != null) {
            this.Xq.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Xq != null) {
            this.Xq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Xq == null) {
            return null;
        }
        return this.Xq.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Xq == null) {
            return null;
        }
        return this.Xq.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Xq == null) {
            return 0;
        }
        return this.Xq.getCurrentPosition();
    }
}
