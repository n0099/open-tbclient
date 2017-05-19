package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object aon = new Object();
    private static k aoo = null;
    private boolean aop = false;
    private boolean aoq = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xh() {
        if (aoo == null) {
            synchronized (aon) {
                if (aoo == null) {
                    aoo = new k();
                }
            }
        }
        return aoo;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ec(String str) {
        this.errorNo = -1;
        if (!this.aop) {
            this.aoq = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zJ);
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
        this.aop = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xd() {
        start();
        this.aoq = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wZ() {
        if (!this.aoq) {
            stop();
            this.aoq = true;
            this.aop = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xe() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xf() {
        reset();
        this.aop = false;
        this.aoq = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int hN() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xg() {
        return this.aop;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dx(int i) {
        dz(i);
    }

    public void dz(int i) {
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
