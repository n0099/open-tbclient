package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqc = new Object();
    private static e aqd = null;
    private boolean aqe = false;
    private boolean aqf = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xm() {
        if (aqd == null) {
            synchronized (aqc) {
                if (aqd == null) {
                    aqd = new e();
                }
            }
        }
        return aqd;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eA(String str) {
        this.errorNo = -1;
        if (!this.aqe) {
            this.aqf = true;
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
        this.aqe = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xi() {
        start();
        this.aqf = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xe() {
        if (!this.aqf) {
            stop();
            this.aqf = true;
            this.aqe = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xk() {
        reset();
        this.aqe = false;
        this.aqf = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xl() {
        return this.aqe;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dO(int i) {
        dQ(i);
    }

    public void dQ(int i) {
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
