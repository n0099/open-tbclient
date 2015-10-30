package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object afG = new Object();
    private static k afH = null;
    private boolean afI = false;
    private boolean afJ = true;
    private int afK = -1;

    private k() {
    }

    public static k vT() {
        if (afH == null) {
            synchronized (afG) {
                if (afH == null) {
                    afH = new k();
                }
            }
        }
        return afH;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dK(String str) {
        this.afK = -1;
        if (!this.afI) {
            this.afJ = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zi);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.afK = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.afK = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.afK = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.afK = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.afK = 1;
                return false;
            }
        }
        this.afI = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vP() {
        start();
        this.afJ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vJ() {
        if (!this.afJ) {
            stop();
            this.afJ = true;
            this.afI = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vQ() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vR() {
        reset();
        this.afI = false;
        this.afJ = true;
        this.afK = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jp() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean vS() {
        return this.afI;
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
        return this.afK;
    }
}
