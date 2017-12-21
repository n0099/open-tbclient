package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqA = new Object();
    private static e aqB = null;
    private boolean aqC = false;
    private boolean aqD = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xm() {
        if (aqB == null) {
            synchronized (aqA) {
                if (aqB == null) {
                    aqB = new e();
                }
            }
        }
        return aqB;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eF(String str) {
        this.errorNo = -1;
        if (!this.aqC) {
            this.aqD = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.zg);
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
        this.aqC = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xi() {
        start();
        this.aqD = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xe() {
        if (!this.aqD) {
            stop();
            this.aqD = true;
            this.aqC = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xk() {
        reset();
        this.aqC = false;
        this.aqD = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xl() {
        return this.aqC;
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
