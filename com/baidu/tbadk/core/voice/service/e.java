package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object bVT = new Object();
    private static e bVU = null;
    private boolean bVV = false;
    private boolean bVW = true;
    private int errorNo = -1;

    private e() {
    }

    public static e afG() {
        if (bVU == null) {
            synchronized (bVT) {
                if (bVU == null) {
                    bVU = new e();
                }
            }
        }
        return bVU;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean nA(String str) {
        this.errorNo = -1;
        if (!this.bVV) {
            this.bVW = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Hb);
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
        this.bVV = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afC() {
        start();
        this.bVW = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afy() {
        if (!this.bVW) {
            stop();
            this.bVW = true;
            this.bVV = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afD() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afE() {
        reset();
        this.bVV = false;
        this.bVW = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lA() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean afF() {
        return this.bVV;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        iw(i);
    }

    public void iw(int i) {
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
