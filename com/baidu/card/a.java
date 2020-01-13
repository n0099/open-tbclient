package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes6.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends af<T> implements com.baidu.tieba.play.f {
    private al JB;

    public a(ad<T> adVar) {
        super(adVar);
        this.JB = null;
        if (adVar.mN() instanceof al) {
            this.JB = (al) adVar.mN();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.JB != null) {
            this.JB.a(yVar);
        }
    }

    public al mC() {
        return this.JB;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.JB == null) {
            return false;
        }
        return this.JB.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.JB == null) {
            return false;
        }
        return this.JB.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.JB == null) {
            return false;
        }
        return this.JB.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.JB != null) {
            this.JB.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.JB != null) {
            this.JB.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.JB == null) {
            return null;
        }
        return this.JB.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.JB == null) {
            return null;
        }
        return this.JB.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.JB == null) {
            return 0;
        }
        return this.JB.getCurrentPosition();
    }
}
