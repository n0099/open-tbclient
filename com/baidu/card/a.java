package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes8.dex */
public class a<T extends AbsThreadDataSupport> extends ag<T> implements com.baidu.tieba.play.f {
    private am adq;

    public a(ae<T> aeVar) {
        super(aeVar);
        this.adq = null;
        if (aeVar.rF() instanceof am) {
            this.adq = (am) aeVar.rF();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.adq != null) {
            this.adq.a(yVar);
        }
    }

    public am rq() {
        return this.adq;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.adq == null) {
            return false;
        }
        return this.adq.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.adq == null) {
            return false;
        }
        return this.adq.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.adq == null) {
            return false;
        }
        return this.adq.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.adq != null) {
            this.adq.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.adq != null) {
            this.adq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.adq == null) {
            return null;
        }
        return this.adq.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.adq == null) {
            return null;
        }
        return this.adq.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.adq == null) {
            return 0;
        }
        return this.adq.getCurrentPosition();
    }
}
