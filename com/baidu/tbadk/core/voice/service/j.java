package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.q;
import java.io.IOException;
/* loaded from: classes.dex */
public class j extends MediaPlayer implements g {
    private static Object Jn = new Object();
    private static j Jo = null;
    private boolean Jp = false;
    private boolean Jq = true;
    private int Jr = -1;

    private j() {
    }

    public static j nV() {
        if (Jo == null) {
            synchronized (Jn) {
                if (Jo == null) {
                    Jo = new j();
                }
            }
        }
        return Jo;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public boolean cj(String str) {
        this.Jr = -1;
        if (!this.Jp) {
            this.Jq = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(q.oD);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.Jr = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.Jr = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.Jr = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.Jr = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.Jr = 1;
                return false;
            }
        }
        this.Jp = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nR() {
        start();
        this.Jq = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nM() {
        if (!this.Jq) {
            stop();
            this.Jq = true;
            this.Jp = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nS() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nT() {
        reset();
        this.Jp = false;
        this.Jq = true;
        this.Jr = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public int fD() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public boolean nU() {
        return this.Jp;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void bR(int i) {
        bT(i);
    }

    public void bT(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public int getErrorNo() {
        return this.Jr;
    }
}
