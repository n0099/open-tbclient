package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes21.dex */
public class a<T extends AbsThreadDataSupport> extends am<T> implements com.baidu.tieba.play.e {
    private at afC;

    public a(ak<T> akVar) {
        super(akVar);
        this.afC = null;
        if (akVar.tP() instanceof at) {
            this.afC = (at) akVar.tP();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.afC != null) {
            this.afC.setVideoStatData(oVar);
        }
    }

    public at tz() {
        return this.afC;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.afC == null) {
            return false;
        }
        return this.afC.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.afC == null) {
            return false;
        }
        return this.afC.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.afC == null) {
            return false;
        }
        return this.afC.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.afC != null) {
            this.afC.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.afC != null) {
            this.afC.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.afC == null) {
            return null;
        }
        return this.afC.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afC == null) {
            return null;
        }
        return this.afC.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.afC == null) {
            return 0;
        }
        return this.afC.getCurrentPosition();
    }
}
