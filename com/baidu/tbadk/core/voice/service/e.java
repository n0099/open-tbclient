package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object apI = new Object();
    private static e apJ = null;
    private boolean apK = false;
    private boolean apL = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xf() {
        if (apJ == null) {
            synchronized (apI) {
                if (apJ == null) {
                    apJ = new e();
                }
            }
        }
        return apJ;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean et(String str) {
        this.errorNo = -1;
        if (!this.apK) {
            this.apL = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.zi);
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
        this.apK = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xb() {
        start();
        this.apL = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void wX() {
        if (!this.apL) {
            stop();
            this.apL = true;
            this.apK = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xc() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xd() {
        reset();
        this.apK = false;
        this.apL = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xe() {
        return this.apK;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dO(int i) {
        dQ(i);
    }

    public void dQ(int i) {
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
