package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes.dex */
public class AutoVideoCardViewHolder<T extends com.baidu.tbadk.core.data.a> extends ThreadCardViewHolder<T> implements com.baidu.tieba.play.e {
    private as agl;

    public AutoVideoCardViewHolder(ak<T> akVar) {
        super(akVar);
        this.agl = null;
        if (akVar.tf() instanceof as) {
            this.agl = (as) akVar.tf();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.o oVar) {
        if (this.agl != null) {
            this.agl.setVideoStatData(oVar);
        }
    }

    public as sP() {
        return this.agl;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.agl == null) {
            return false;
        }
        return this.agl.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.agl == null) {
            return false;
        }
        return this.agl.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.agl == null) {
            return false;
        }
        return this.agl.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.agl != null) {
            this.agl.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.agl != null) {
            this.agl.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.agl == null) {
            return null;
        }
        return this.agl.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.agl == null) {
            return null;
        }
        return this.agl.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.agl == null) {
            return 0;
        }
        return this.agl.getCurrentPosition();
    }
}
