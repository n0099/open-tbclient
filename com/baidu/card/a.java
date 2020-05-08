package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends af<T> implements com.baidu.tieba.play.f {
    private al acX;

    public a(ad<T> adVar) {
        super(adVar);
        this.acX = null;
        if (adVar.rw() instanceof al) {
            this.acX = (al) adVar.rw();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.acX != null) {
            this.acX.a(yVar);
        }
    }

    public al rj() {
        return this.acX;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.acX == null) {
            return false;
        }
        return this.acX.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.acX == null) {
            return false;
        }
        return this.acX.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.acX == null) {
            return false;
        }
        return this.acX.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.acX != null) {
            this.acX.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.acX != null) {
            this.acX.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.acX == null) {
            return null;
        }
        return this.acX.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.acX == null) {
            return null;
        }
        return this.acX.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.acX == null) {
            return 0;
        }
        return this.acX.getCurrentPosition();
    }
}
