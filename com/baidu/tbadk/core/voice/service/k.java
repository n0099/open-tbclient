package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ajs = new Object();
    private static k ajt = null;
    private boolean aju = false;
    private boolean ajv = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xn() {
        if (ajt == null) {
            synchronized (ajs) {
                if (ajt == null) {
                    ajt = new k();
                }
            }
        }
        return ajt;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ed(String str) {
        this.errorNo = -1;
        if (!this.aju) {
            this.ajv = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.sV);
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
        this.aju = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xj() {
        start();
        this.ajv = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xe() {
        if (!this.ajv) {
            stop();
            this.ajv = true;
            this.aju = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xk() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xl() {
        reset();
        this.aju = false;
        this.ajv = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int gQ() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xm() {
        return this.aju;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dv(int i) {
        dx(i);
    }

    public void dx(int i) {
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
