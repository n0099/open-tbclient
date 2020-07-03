package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class a<T extends AbsThreadDataSupport> extends ak<T> implements com.baidu.tieba.play.f {
    private ar adU;

    public a(ai<T> aiVar) {
        super(aiVar);
        this.adU = null;
        if (aiVar.rX() instanceof ar) {
            this.adU = (ar) aiVar.rX();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.adU != null) {
            this.adU.a(yVar);
        }
    }

    public ar rH() {
        return this.adU;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.adU == null) {
            return false;
        }
        return this.adU.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.adU == null) {
            return false;
        }
        return this.adU.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.adU == null) {
            return false;
        }
        return this.adU.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.adU != null) {
            this.adU.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.adU != null) {
            this.adU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.adU == null) {
            return null;
        }
        return this.adU.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.adU == null) {
            return null;
        }
        return this.adU.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.adU == null) {
            return 0;
        }
        return this.adU.getCurrentPosition();
    }
}
