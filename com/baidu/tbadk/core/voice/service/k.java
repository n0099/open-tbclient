package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object aoX = new Object();
    private static k aoY = null;
    private boolean aoZ = false;
    private boolean apa = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xs() {
        if (aoY == null) {
            synchronized (aoX) {
                if (aoY == null) {
                    aoY = new k();
                }
            }
        }
        return aoY;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean eu(String str) {
        this.errorNo = -1;
        if (!this.aoZ) {
            this.apa = true;
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
        this.aoZ = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xo() {
        start();
        this.apa = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xk() {
        if (!this.apa) {
            stop();
            this.apa = true;
            this.aoZ = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xp() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xq() {
        reset();
        this.aoZ = false;
        this.apa = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int hM() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xr() {
        return this.aoZ;
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
