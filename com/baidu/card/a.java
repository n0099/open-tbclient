package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac EN;

    public a(x<T> xVar) {
        super(xVar);
        this.EN = null;
        if (xVar.lO() instanceof ac) {
            this.EN = (ac) xVar.lO();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.EN != null) {
            this.EN.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.EN == null) {
            return false;
        }
        return this.EN.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.EN == null) {
            return false;
        }
        return this.EN.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.EN == null) {
            return false;
        }
        return this.EN.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.EN != null) {
            this.EN.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.EN != null) {
            this.EN.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.EN == null) {
            return null;
        }
        return this.EN.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.EN == null) {
            return null;
        }
        return this.EN.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.EN == null) {
            return 0;
        }
        return this.EN.getCurrentPosition();
    }
}
