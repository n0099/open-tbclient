package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Xp;

    public a(x<T> xVar) {
        super(xVar);
        this.Xp = null;
        if (xVar.rq() instanceof ac) {
            this.Xp = (ac) xVar.rq();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Xp != null) {
            this.Xp.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Xp == null) {
            return false;
        }
        return this.Xp.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Xp == null) {
            return false;
        }
        return this.Xp.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Xp == null) {
            return false;
        }
        return this.Xp.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Xp != null) {
            this.Xp.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Xp != null) {
            this.Xp.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Xp == null) {
            return null;
        }
        return this.Xp.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Xp == null) {
            return null;
        }
        return this.Xp.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Xp == null) {
            return 0;
        }
        return this.Xp.getCurrentPosition();
    }
}
