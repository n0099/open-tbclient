package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class a<T extends AbsThreadDataSupport> extends al<T> implements com.baidu.tieba.play.e {
    private as aeQ;

    public a(aj<T> ajVar) {
        super(ajVar);
        this.aeQ = null;
        if (ajVar.tK() instanceof as) {
            this.aeQ = (as) ajVar.tK();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.aeQ != null) {
            this.aeQ.setVideoStatData(oVar);
        }
    }

    public as tu() {
        return this.aeQ;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.aeQ == null) {
            return false;
        }
        return this.aeQ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.aeQ == null) {
            return false;
        }
        return this.aeQ.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.aeQ == null) {
            return false;
        }
        return this.aeQ.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.aeQ != null) {
            this.aeQ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.aeQ != null) {
            this.aeQ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.aeQ == null) {
            return null;
        }
        return this.aeQ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.aeQ == null) {
            return null;
        }
        return this.aeQ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.aeQ == null) {
            return 0;
        }
        return this.aeQ.getCurrentPosition();
    }
}
