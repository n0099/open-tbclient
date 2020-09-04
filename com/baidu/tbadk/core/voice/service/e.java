package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object ezx = new Object();
    private static e ezy = null;
    private boolean ezz = false;
    private boolean ezA = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bmi() {
        if (ezy == null) {
            synchronized (ezx) {
                if (ezy == null) {
                    ezy = new e();
                }
            }
        }
        return ezy;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean AS(String str) {
        this.errorNo = -1;
        if (!this.ezz) {
            this.ezA = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Pd);
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
        this.ezz = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmf() {
        start();
        this.ezA = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmb() {
        if (!this.ezA) {
            stop();
            this.ezA = true;
            this.ezz = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmg() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmh() {
        reset();
        this.ezz = false;
        this.ezA = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int om() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.ezz;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        pw(i);
    }

    public void pw(int i) {
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
