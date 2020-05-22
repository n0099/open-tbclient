package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object eal = new Object();
    private static e eam = null;
    private boolean ean = false;
    private boolean eao = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aXy() {
        if (eam == null) {
            synchronized (eal) {
                if (eam == null) {
                    eam = new e();
                }
            }
        }
        return eam;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xe(String str) {
        this.errorNo = -1;
        if (!this.ean) {
            this.eao = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.NV);
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
        this.ean = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aXv() {
        start();
        this.eao = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aXr() {
        if (!this.eao) {
            stop();
            this.eao = true;
            this.ean = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aXw() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aXx() {
        reset();
        this.ean = false;
        this.eao = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int mv() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.ean;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        mz(i);
    }

    public void mz(int i) {
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
