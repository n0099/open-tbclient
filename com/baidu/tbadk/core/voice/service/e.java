package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object eBB = new Object();
    private static e eBC = null;
    private boolean eBD = false;
    private boolean eBE = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bnc() {
        if (eBC == null) {
            synchronized (eBB) {
                if (eBC == null) {
                    eBC = new e();
                }
            }
        }
        return eBC;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Bo(String str) {
        this.errorNo = -1;
        if (!this.eBD) {
            this.eBE = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Pv);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.errorNo = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.errorNo = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.errorNo = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.errorNo = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.errorNo = 1;
                return false;
            }
        }
        this.eBD = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmZ() {
        start();
        this.eBE = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmV() {
        if (!this.eBE) {
            stop();
            this.eBE = true;
            this.eBD = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bna() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bnb() {
        reset();
        this.eBD = false;
        this.eBE = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int or() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.eBD;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        pJ(i);
    }

    public void pJ(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int getErrorNo() {
        return this.errorNo;
    }
}
