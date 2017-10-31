package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqd = new Object();
    private static e aqe = null;
    private boolean aqf = false;
    private boolean aqg = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xm() {
        if (aqe == null) {
            synchronized (aqd) {
                if (aqe == null) {
                    aqe = new e();
                }
            }
        }
        return aqe;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eA(String str) {
        this.errorNo = -1;
        if (!this.aqf) {
            this.aqg = true;
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
        this.aqf = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xi() {
        start();
        this.aqg = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xe() {
        if (!this.aqg) {
            stop();
            this.aqg = true;
            this.aqf = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xk() {
        reset();
        this.aqf = false;
        this.aqg = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xl() {
        return this.aqf;
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
