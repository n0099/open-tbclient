package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqu = new Object();
    private static e aqv = null;
    private boolean aqw = false;
    private boolean aqx = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xn() {
        if (aqv == null) {
            synchronized (aqu) {
                if (aqv == null) {
                    aqv = new e();
                }
            }
        }
        return aqv;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eF(String str) {
        this.errorNo = -1;
        if (!this.aqw) {
            this.aqx = true;
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
        this.aqw = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xj() {
        start();
        this.aqx = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xf() {
        if (!this.aqx) {
            stop();
            this.aqx = true;
            this.aqw = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xk() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xl() {
        reset();
        this.aqw = false;
        this.aqx = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xm() {
        return this.aqw;
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
