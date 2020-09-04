package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class a<T extends AbsThreadDataSupport> extends al<T> implements com.baidu.tieba.play.e {
    private as aeS;

    public a(aj<T> ajVar) {
        super(ajVar);
        this.aeS = null;
        if (ajVar.tK() instanceof as) {
            this.aeS = (as) ajVar.tK();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.aeS != null) {
            this.aeS.setVideoStatData(oVar);
        }
    }

    public as tu() {
        return this.aeS;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.aeS == null) {
            return false;
        }
        return this.aeS.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.aeS == null) {
            return false;
        }
        return this.aeS.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.aeS == null) {
            return false;
        }
        return this.aeS.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.aeS != null) {
            this.aeS.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.aeS != null) {
            this.aeS.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.aeS == null) {
            return null;
        }
        return this.aeS.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.aeS == null) {
            return null;
        }
        return this.aeS.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.aeS == null) {
            return 0;
        }
        return this.aeS.getCurrentPosition();
    }
}
