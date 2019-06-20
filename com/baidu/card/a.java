package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Vg;

    public a(x<T> xVar) {
        super(xVar);
        this.Vg = null;
        if (xVar.ql() instanceof ac) {
            this.Vg = (ac) xVar.ql();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Vg != null) {
            this.Vg.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Vg == null) {
            return false;
        }
        return this.Vg.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Vg == null) {
            return false;
        }
        return this.Vg.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Vg == null) {
            return false;
        }
        return this.Vg.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Vg != null) {
            this.Vg.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Vg != null) {
            this.Vg.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Vg == null) {
            return null;
        }
        return this.Vg.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Vg == null) {
            return null;
        }
        return this.Vg.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Vg == null) {
            return 0;
        }
        return this.Vg.getCurrentPosition();
    }
}
