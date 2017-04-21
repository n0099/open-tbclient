package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object aoi = new Object();
    private static k aoj = null;
    private boolean aok = false;
    private boolean aol = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xT() {
        if (aoj == null) {
            synchronized (aoi) {
                if (aoj == null) {
                    aoj = new k();
                }
            }
        }
        return aoj;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ed(String str) {
        this.errorNo = -1;
        if (!this.aok) {
            this.aol = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zI);
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
        this.aok = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xP() {
        start();
        this.aol = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xL() {
        if (!this.aol) {
            stop();
            this.aol = true;
            this.aok = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xQ() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xR() {
        reset();
        this.aok = false;
        this.aol = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int hO() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xS() {
        return this.aok;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dz(int i) {
        dB(i);
    }

    public void dB(int i) {
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
