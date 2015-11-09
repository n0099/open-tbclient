package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object afL = new Object();
    private static k afM = null;
    private boolean afN = false;
    private boolean afO = true;
    private int afP = -1;

    private k() {
    }

    public static k vX() {
        if (afM == null) {
            synchronized (afL) {
                if (afM == null) {
                    afM = new k();
                }
            }
        }
        return afM;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dK(String str) {
        this.afP = -1;
        if (!this.afN) {
            this.afO = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zi);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.afP = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.afP = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.afP = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.afP = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.afP = 1;
                return false;
            }
        }
        this.afN = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vT() {
        start();
        this.afO = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vN() {
        if (!this.afO) {
            stop();
            this.afO = true;
            this.afN = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vU() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vV() {
        reset();
        this.afN = false;
        this.afO = true;
        this.afP = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jq() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean vW() {
        return this.afN;
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
        return this.afP;
    }
}
