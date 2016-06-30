package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object afJ = new Object();
    private static k afK = null;
    private boolean afL = false;
    private boolean afM = true;
    private int errorNo = -1;

    private k() {
    }

    public static k wj() {
        if (afK == null) {
            synchronized (afJ) {
                if (afK == null) {
                    afK = new k();
                }
            }
        }
        return afK;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean eb(String str) {
        this.errorNo = -1;
        if (!this.afL) {
            this.afM = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.qd);
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
        this.afL = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wf() {
        start();
        this.afM = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wa() {
        if (!this.afM) {
            stop();
            this.afM = true;
            this.afL = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wg() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wh() {
        reset();
        this.afL = false;
        this.afM = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int fV() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean wi() {
        return this.afL;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dh(int i) {
        dj(i);
    }

    public void dj(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int getErrorNo() {
        return this.errorNo;
    }
}
