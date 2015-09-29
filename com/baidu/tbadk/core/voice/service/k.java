package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object afF = new Object();
    private static k afG = null;
    private boolean afH = false;
    private boolean afI = true;
    private int afJ = -1;

    private k() {
    }

    public static k vW() {
        if (afG == null) {
            synchronized (afF) {
                if (afG == null) {
                    afG = new k();
                }
            }
        }
        return afG;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dK(String str) {
        this.afJ = -1;
        if (!this.afH) {
            this.afI = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zi);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.afJ = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.afJ = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.afJ = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.afJ = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.afJ = 1;
                return false;
            }
        }
        this.afH = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vS() {
        start();
        this.afI = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vM() {
        if (!this.afI) {
            stop();
            this.afI = true;
            this.afH = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vT() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vU() {
        reset();
        this.afH = false;
        this.afI = true;
        this.afJ = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jp() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean vV() {
        return this.afH;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void cR(int i) {
        cT(i);
    }

    public void cT(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int getErrorNo() {
        return this.afJ;
    }
}
