package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes20.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends am<T> implements com.baidu.tieba.play.e {
    private at afH;

    public a(ak<T> akVar) {
        super(akVar);
        this.afH = null;
        if (akVar.tP() instanceof at) {
            this.afH = (at) akVar.tP();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.afH != null) {
            this.afH.setVideoStatData(oVar);
        }
    }

    public at tz() {
        return this.afH;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.afH == null) {
            return false;
        }
        return this.afH.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.afH == null) {
            return false;
        }
        return this.afH.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.afH == null) {
            return false;
        }
        return this.afH.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.afH != null) {
            this.afH.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.afH != null) {
            this.afH.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.afH == null) {
            return null;
        }
        return this.afH.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afH == null) {
            return null;
        }
        return this.afH.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.afH == null) {
            return 0;
        }
        return this.afH.getCurrentPosition();
    }
}
