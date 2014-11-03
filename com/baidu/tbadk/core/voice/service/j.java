package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.q;
import java.io.IOException;
/* loaded from: classes.dex */
public class j extends MediaPlayer implements g {
    private static Object Jo = new Object();
    private static j Jp = null;
    private boolean Jq = false;
    private boolean Jr = true;
    private int Js = -1;

    private j() {
    }

    public static j nV() {
        if (Jp == null) {
            synchronized (Jo) {
                if (Jp == null) {
                    Jp = new j();
                }
            }
        }
        return Jp;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public boolean cj(String str) {
        this.Js = -1;
        if (!this.Jq) {
            this.Jr = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(q.oD);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.Js = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.Js = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.Js = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.Js = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.Js = 1;
                return false;
            }
        }
        this.Jq = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nR() {
        start();
        this.Jr = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nM() {
        if (!this.Jr) {
            stop();
            this.Jr = true;
            this.Jq = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nS() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void nT() {
        reset();
        this.Jq = false;
        this.Jr = true;
        this.Js = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public int fD() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public boolean nU() {
        return this.Jq;
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
        return this.Js;
    }
}
