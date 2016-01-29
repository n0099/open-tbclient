package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ajg = new Object();
    private static k ajh = null;
    private boolean aji = false;
    private boolean ajj = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xL() {
        if (ajh == null) {
            synchronized (ajg) {
                if (ajh == null) {
                    ajh = new k();
                }
            }
        }
        return ajh;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dU(String str) {
        this.errorNo = -1;
        if (!this.aji) {
            this.ajj = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zy);
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
        this.aji = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xH() {
        start();
        this.ajj = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xB() {
        if (!this.ajj) {
            stop();
            this.ajj = true;
            this.aji = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xI() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xJ() {
        reset();
        this.aji = false;
        this.ajj = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jB() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xK() {
        return this.aji;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dv(int i) {
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
