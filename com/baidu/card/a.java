package com.baidu.card;

import android.view.View;
import com.baidu.tbadk.core.data.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tbadk.core.data.a> extends z<T> implements com.baidu.tieba.play.f {
    private ac Fo;

    public a(x<T> xVar) {
        super(xVar);
        this.Fo = null;
        if (xVar.lO() instanceof ac) {
            this.Fo = (ac) xVar.lO();
        }
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.Fo != null) {
            this.Fo.a(zVar);
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.Fo == null) {
            return false;
        }
        return this.Fo.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.Fo == null) {
            return false;
        }
        return this.Fo.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Fo == null) {
            return false;
        }
        return this.Fo.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.Fo != null) {
            this.Fo.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.Fo != null) {
            this.Fo.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.Fo == null) {
            return null;
        }
        return this.Fo.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Fo == null) {
            return null;
        }
        return this.Fo.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.Fo == null) {
            return 0;
        }
        return this.Fo.getCurrentPosition();
    }
}
