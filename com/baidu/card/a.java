package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes20.dex */
public class a<T extends AbsThreadDataSupport> extends am<T> implements com.baidu.tieba.play.e {
    private at afk;

    public a(ak<T> akVar) {
        super(akVar);
        this.afk = null;
        if (akVar.tP() instanceof at) {
            this.afk = (at) akVar.tP();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.afk != null) {
            this.afk.setVideoStatData(oVar);
        }
    }

    public at tz() {
        return this.afk;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.afk == null) {
            return false;
        }
        return this.afk.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.afk == null) {
            return false;
        }
        return this.afk.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.afk == null) {
            return false;
        }
        return this.afk.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.afk != null) {
            this.afk.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.afk != null) {
            this.afk.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.afk == null) {
            return null;
        }
        return this.afk.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afk == null) {
            return null;
        }
        return this.afk.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.afk == null) {
            return 0;
        }
        return this.afk.getCurrentPosition();
    }
}
