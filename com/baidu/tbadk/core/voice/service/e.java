package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqx = new Object();
    private static e aqy = null;
    private boolean aqz = false;
    private boolean aqA = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xm() {
        if (aqy == null) {
            synchronized (aqx) {
                if (aqy == null) {
                    aqy = new e();
                }
            }
        }
        return aqy;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eF(String str) {
        this.errorNo = -1;
        if (!this.aqz) {
            this.aqA = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.zf);
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
        this.aqz = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xi() {
        start();
        this.aqA = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xe() {
        if (!this.aqA) {
            stop();
            this.aqA = true;
            this.aqz = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xk() {
        reset();
        this.aqz = false;
        this.aqA = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xl() {
        return this.aqz;
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
