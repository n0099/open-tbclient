package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends com.baidu.tbadk.core.data.a> extends ThreadCardViewHolder<T> implements com.baidu.tieba.play.e {
    private as agc;

    public AutoVideoCardViewHolder(ak<T> akVar) {
        super(akVar);
        this.agc = null;
        if (akVar.tc() instanceof as) {
            this.agc = (as) akVar.tc();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.agc != null) {
            this.agc.setVideoStatData(oVar);
        }
    }

    public as sM() {
        return this.agc;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.agc == null) {
            return false;
        }
        return this.agc.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.agc == null) {
            return false;
        }
        return this.agc.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.agc == null) {
            return false;
        }
        return this.agc.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.agc != null) {
            this.agc.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.agc != null) {
            this.agc.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.agc == null) {
            return null;
        }
        return this.agc.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.agc == null) {
            return null;
        }
        return this.agc.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.agc == null) {
            return 0;
        }
        return this.agc.getCurrentPosition();
    }
}
