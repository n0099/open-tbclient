package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object fiB = new Object();
    private static e fiC = null;
    private boolean fiD = false;
    private boolean fiE = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bwV() {
        if (fiC == null) {
            synchronized (fiB) {
                if (fiC == null) {
                    fiC = new e();
                }
            }
        }
        return fiC;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean CO(String str) {
        this.errorNo = -1;
        if (!this.fiD) {
            this.fiE = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.QN);
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
        this.fiD = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bwS() {
        start();
        this.fiE = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bwO() {
        if (!this.fiE) {
            stop();
            this.fiE = true;
            this.fiD = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bwT() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bwU() {
        reset();
        this.fiD = false;
        this.fiE = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int or() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.fiD;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        rB(i);
    }

    public void rB(int i) {
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
