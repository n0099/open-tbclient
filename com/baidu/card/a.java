package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes21.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends am<T> implements com.baidu.tieba.play.e {
    private at agD;

    public a(ak<T> akVar) {
        super(akVar);
        this.agD = null;
        if (akVar.tS() instanceof at) {
            this.agD = (at) akVar.tS();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.agD != null) {
            this.agD.setVideoStatData(oVar);
        }
    }

    public at tC() {
        return this.agD;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.agD == null) {
            return false;
        }
        return this.agD.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.agD == null) {
            return false;
        }
        return this.agD.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.agD == null) {
            return false;
        }
        return this.agD.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.agD != null) {
            this.agD.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.agD != null) {
            this.agD.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.agD == null) {
            return null;
        }
        return this.agD.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.agD == null) {
            return null;
        }
        return this.agD.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.agD == null) {
            return 0;
        }
        return this.agD.getCurrentPosition();
    }
}
