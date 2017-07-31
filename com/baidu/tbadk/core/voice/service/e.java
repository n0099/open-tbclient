package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object ari = new Object();
    private static e arj = null;
    private boolean ark = false;
    private boolean arl = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xL() {
        if (arj == null) {
            synchronized (ari) {
                if (arj == null) {
                    arj = new e();
                }
            }
        }
        return arj;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eD(String str) {
        this.errorNo = -1;
        if (!this.ark) {
            this.arl = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Bk);
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
        this.ark = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xH() {
        start();
        this.arl = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xD() {
        if (!this.arl) {
            stop();
            this.arl = true;
            this.ark = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xI() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xJ() {
        reset();
        this.ark = false;
        this.arl = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hU() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xK() {
        return this.ark;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dE(int i) {
        dG(i);
    }

    public void dG(int i) {
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
