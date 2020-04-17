package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes8.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends af<T> implements com.baidu.tieba.play.f {
    private al acU;

    public a(ad<T> adVar) {
        super(adVar);
        this.acU = null;
        if (adVar.rw() instanceof al) {
            this.acU = (al) adVar.rw();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.acU != null) {
            this.acU.a(yVar);
        }
    }

    public al rj() {
        return this.acU;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.acU == null) {
            return false;
        }
        return this.acU.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.acU == null) {
            return false;
        }
        return this.acU.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.acU == null) {
            return false;
        }
        return this.acU.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.acU != null) {
            this.acU.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.acU != null) {
            this.acU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.acU == null) {
            return null;
        }
        return this.acU.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.acU == null) {
            return null;
        }
        return this.acU.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.acU == null) {
            return 0;
        }
        return this.acU.getCurrentPosition();
    }
}
