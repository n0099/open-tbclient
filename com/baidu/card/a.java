package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac VA;

    public a(x<T> xVar) {
        super(xVar);
        this.VA = null;
        if (xVar.qI() instanceof ac) {
            this.VA = (ac) xVar.qI();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.VA != null) {
            this.VA.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.VA == null) {
            return false;
        }
        return this.VA.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.VA == null) {
            return false;
        }
        return this.VA.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.VA == null) {
            return false;
        }
        return this.VA.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.VA != null) {
            this.VA.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.VA != null) {
            this.VA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.VA == null) {
            return null;
        }
        return this.VA.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.VA == null) {
            return null;
        }
        return this.VA.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.VA == null) {
            return 0;
        }
        return this.VA.getCurrentPosition();
    }
}
