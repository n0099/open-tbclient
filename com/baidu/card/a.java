package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes5.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends af<T> implements com.baidu.tieba.play.f {
    private al Jv;

    public a(ad<T> adVar) {
        super(adVar);
        this.Jv = null;
        if (adVar.mM() instanceof al) {
            this.Jv = (al) adVar.mM();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.Jv != null) {
            this.Jv.a(yVar);
        }
    }

    public al mC() {
        return this.Jv;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Jv == null) {
            return false;
        }
        return this.Jv.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Jv == null) {
            return false;
        }
        return this.Jv.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Jv == null) {
            return false;
        }
        return this.Jv.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Jv != null) {
            this.Jv.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Jv != null) {
            this.Jv.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Jv == null) {
            return null;
        }
        return this.Jv.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Jv == null) {
            return null;
        }
        return this.Jv.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Jv == null) {
            return 0;
        }
        return this.Jv.getCurrentPosition();
    }
}
