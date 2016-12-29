package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ajn = new Object();
    private static k ajo = null;
    private boolean ajp = false;
    private boolean ajq = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xh() {
        if (ajo == null) {
            synchronized (ajn) {
                if (ajo == null) {
                    ajo = new k();
                }
            }
        }
        return ajo;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ef(String str) {
        this.errorNo = -1;
        if (!this.ajp) {
            this.ajq = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.sW);
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
        this.ajp = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xd() {
        start();
        this.ajq = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wY() {
        if (!this.ajq) {
            stop();
            this.ajq = true;
            this.ajp = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xe() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xf() {
        reset();
        this.ajp = false;
        this.ajq = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int gQ() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xg() {
        return this.ajp;
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
