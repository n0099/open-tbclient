package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Vz;

    public a(x<T> xVar) {
        super(xVar);
        this.Vz = null;
        if (xVar.qJ() instanceof ac) {
            this.Vz = (ac) xVar.qJ();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Vz != null) {
            this.Vz.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Vz == null) {
            return false;
        }
        return this.Vz.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Vz == null) {
            return false;
        }
        return this.Vz.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Vz == null) {
            return false;
        }
        return this.Vz.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Vz != null) {
            this.Vz.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Vz != null) {
            this.Vz.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Vz == null) {
            return null;
        }
        return this.Vz.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Vz == null) {
            return null;
        }
        return this.Vz.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Vz == null) {
            return 0;
        }
        return this.Vz.getCurrentPosition();
    }
}
