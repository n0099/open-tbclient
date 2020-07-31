package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public class a<T extends AbsThreadDataSupport> extends ak<T> implements com.baidu.tieba.play.e {
    private ar adK;

    public a(ai<T> aiVar) {
        super(aiVar);
        this.adK = null;
        if (aiVar.rZ() instanceof ar) {
            this.adK = (ar) aiVar.rZ();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.adK != null) {
            this.adK.setVideoStatData(oVar);
        }
    }

    public ar rJ() {
        return this.adK;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.adK == null) {
            return false;
        }
        return this.adK.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.adK == null) {
            return false;
        }
        return this.adK.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.adK == null) {
            return false;
        }
        return this.adK.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.adK != null) {
            this.adK.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.adK != null) {
            this.adK.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.adK == null) {
            return null;
        }
        return this.adK.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.adK == null) {
            return null;
        }
        return this.adK.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.adK == null) {
            return 0;
        }
        return this.adK.getCurrentPosition();
    }
}
