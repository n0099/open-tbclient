package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends af<T> implements com.baidu.tieba.play.f {
    private al JW;

    public a(ad<T> adVar) {
        super(adVar);
        this.JW = null;
        if (adVar.nd() instanceof al) {
            this.JW = (al) adVar.nd();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.JW != null) {
            this.JW.a(yVar);
        }
    }

    public al mR() {
        return this.JW;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.JW == null) {
            return false;
        }
        return this.JW.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.JW == null) {
            return false;
        }
        return this.JW.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.JW == null) {
            return false;
        }
        return this.JW.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.JW != null) {
            this.JW.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.JW != null) {
            this.JW.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.JW == null) {
            return null;
        }
        return this.JW.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.JW == null) {
            return null;
        }
        return this.JW.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.JW == null) {
            return 0;
        }
        return this.JW.getCurrentPosition();
    }
}
