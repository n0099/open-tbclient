package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public class a<T extends AbsThreadDataSupport> extends am<T> implements com.baidu.tieba.play.e {
    private at afB;

    public a(ak<T> akVar) {
        super(akVar);
        this.afB = null;
        if (akVar.tP() instanceof at) {
            this.afB = (at) akVar.tP();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.afB != null) {
            this.afB.setVideoStatData(oVar);
        }
    }

    public at tz() {
        return this.afB;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.afB == null) {
            return false;
        }
        return this.afB.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.afB == null) {
            return false;
        }
        return this.afB.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.afB == null) {
            return false;
        }
        return this.afB.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.afB != null) {
            this.afB.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.afB != null) {
            this.afB.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.afB == null) {
            return null;
        }
        return this.afB.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afB == null) {
            return null;
        }
        return this.afB.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.afB == null) {
            return 0;
        }
        return this.afB.getCurrentPosition();
    }
}
