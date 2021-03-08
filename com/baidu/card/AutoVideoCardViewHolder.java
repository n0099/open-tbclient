package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends com.baidu.tbadk.core.data.a> extends ThreadCardViewHolder<T> implements com.baidu.tieba.play.e {
    private as ahv;

    public AutoVideoCardViewHolder(ak<T> akVar) {
        super(akVar);
        this.ahv = null;
        if (akVar.tc() instanceof as) {
            this.ahv = (as) akVar.tc();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.ahv != null) {
            this.ahv.setVideoStatData(oVar);
        }
    }

    public as sM() {
        return this.ahv;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.ahv == null) {
            return false;
        }
        return this.ahv.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.ahv == null) {
            return false;
        }
        return this.ahv.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ahv == null) {
            return false;
        }
        return this.ahv.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.ahv != null) {
            this.ahv.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.ahv != null) {
            this.ahv.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.ahv == null) {
            return null;
        }
        return this.ahv.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ahv == null) {
            return null;
        }
        return this.ahv.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.ahv == null) {
            return 0;
        }
        return this.ahv.getCurrentPosition();
    }
}
