package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object apU = new Object();
    private static e apV = null;
    private boolean apW = false;
    private boolean apX = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xm() {
        if (apV == null) {
            synchronized (apU) {
                if (apV == null) {
                    apV = new e();
                }
            }
        }
        return apV;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eu(String str) {
        this.errorNo = -1;
        if (!this.apW) {
            this.apX = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.zh);
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
        this.apW = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xi() {
        start();
        this.apX = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xe() {
        if (!this.apX) {
            stop();
            this.apX = true;
            this.apW = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xk() {
        reset();
        this.apW = false;
        this.apX = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xl() {
        return this.apW;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dP(int i) {
        dR(i);
    }

    public void dR(int i) {
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
