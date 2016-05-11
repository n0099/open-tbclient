package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object afi = new Object();
    private static k afj = null;
    private boolean afk = false;
    private boolean afl = true;
    private int errorNo = -1;

    private k() {
    }

    public static k wf() {
        if (afj == null) {
            synchronized (afi) {
                if (afj == null) {
                    afj = new k();
                }
            }
        }
        return afj;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dX(String str) {
        this.errorNo = -1;
        if (!this.afk) {
            this.afl = true;
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
        this.afk = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wb() {
        start();
        this.afl = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vW() {
        if (!this.afl) {
            stop();
            this.afl = true;
            this.afk = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wc() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wd() {
        reset();
        this.afk = false;
        this.afl = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int fU() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean we() {
        return this.afk;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dg(int i) {
        di(i);
    }

    public void di(int i) {
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
