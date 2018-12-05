package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aMO = new Object();
    private static e aMP = null;
    private boolean aMQ = false;
    private boolean aMR = true;
    private int errorNo = -1;

    private e() {
    }

    public static e FY() {
        if (aMP == null) {
            synchronized (aMO) {
                if (aMP == null) {
                    aMP = new e();
                }
            }
        }
        return aMP;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean gA(String str) {
        this.errorNo = -1;
        if (!this.aMQ) {
            this.aMR = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Hc);
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
        this.aMQ = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FU() {
        start();
        this.aMR = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FQ() {
        if (!this.aMR) {
            stop();
            this.aMR = true;
            this.aMQ = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FV() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FW() {
        reset();
        this.aMQ = false;
        this.aMR = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lv() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean FX() {
        return this.aMQ;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        eP(i);
    }

    public void eP(int i) {
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
