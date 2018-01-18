package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object beF = new Object();
    private static e beG = null;
    private boolean beH = false;
    private boolean beI = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EC() {
        if (beG == null) {
            synchronized (beF) {
                if (beG == null) {
                    beG = new e();
                }
            }
        }
        return beG;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eM(String str) {
        this.errorNo = -1;
        if (!this.beH) {
            this.beI = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.anq);
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
        this.beH = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Ey() {
        start();
        this.beI = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Eu() {
        if (!this.beI) {
            stop();
            this.beI = true;
            this.beH = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Ez() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EA() {
        reset();
        this.beH = false;
        this.beI = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int pl() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean EB() {
        return this.beH;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void gK(int i) {
        gM(i);
    }

    public void gM(int i) {
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
