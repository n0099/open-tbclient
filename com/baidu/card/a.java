package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Vh;

    public a(x<T> xVar) {
        super(xVar);
        this.Vh = null;
        if (xVar.ql() instanceof ac) {
            this.Vh = (ac) xVar.ql();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Vh != null) {
            this.Vh.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Vh == null) {
            return false;
        }
        return this.Vh.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Vh == null) {
            return false;
        }
        return this.Vh.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Vh == null) {
            return false;
        }
        return this.Vh.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Vh != null) {
            this.Vh.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Vh != null) {
            this.Vh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Vh == null) {
            return null;
        }
        return this.Vh.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Vh == null) {
            return null;
        }
        return this.Vh.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Vh == null) {
            return 0;
        }
        return this.Vh.getCurrentPosition();
    }
}
