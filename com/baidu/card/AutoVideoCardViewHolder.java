package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends com.baidu.tbadk.core.data.a> extends ThreadCardViewHolder<T> implements com.baidu.tieba.play.e {
    private as ahc;

    public AutoVideoCardViewHolder(ak<T> akVar) {
        super(akVar);
        this.ahc = null;
        if (akVar.tr() instanceof as) {
            this.ahc = (as) akVar.tr();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.ahc != null) {
            this.ahc.setVideoStatData(oVar);
        }
    }

    public as ta() {
        return this.ahc;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.ahc == null) {
            return false;
        }
        return this.ahc.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.ahc == null) {
            return false;
        }
        return this.ahc.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ahc == null) {
            return false;
        }
        return this.ahc.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.ahc != null) {
            this.ahc.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.ahc != null) {
            this.ahc.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.ahc == null) {
            return null;
        }
        return this.ahc.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ahc == null) {
            return null;
        }
        return this.ahc.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.ahc == null) {
            return 0;
        }
        return this.ahc.getCurrentPosition();
    }
}
