package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ajw = new Object();
    private static k ajx = null;
    private boolean ajy = false;
    private boolean ajz = true;
    private int errorNo = -1;

    private k() {
    }

    public static k ym() {
        if (ajx == null) {
            synchronized (ajw) {
                if (ajx == null) {
                    ajx = new k();
                }
            }
        }
        return ajx;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean eb(String str) {
        this.errorNo = -1;
        if (!this.ajy) {
            this.ajz = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zQ);
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
        this.ajy = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void yi() {
        start();
        this.ajz = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void yc() {
        if (!this.ajz) {
            stop();
            this.ajz = true;
            this.ajy = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void yj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void yk() {
        reset();
        this.ajy = false;
        this.ajz = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jH() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean yl() {
        return this.ajy;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dA(int i) {
        dC(i);
    }

    public void dC(int i) {
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
