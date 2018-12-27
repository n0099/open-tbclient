package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aMQ = new Object();
    private static e aMR = null;
    private boolean aMS = false;
    private boolean aMT = true;
    private int errorNo = -1;

    private e() {
    }

    public static e FZ() {
        if (aMR == null) {
            synchronized (aMQ) {
                if (aMR == null) {
                    aMR = new e();
                }
            }
        }
        return aMR;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean gB(String str) {
        this.errorNo = -1;
        if (!this.aMS) {
            this.aMT = true;
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
        this.aMS = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FV() {
        start();
        this.aMT = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FR() {
        if (!this.aMT) {
            stop();
            this.aMT = true;
            this.aMS = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FW() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void FX() {
        reset();
        this.aMS = false;
        this.aMT = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lv() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean FY() {
        return this.aMS;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        eQ(i);
    }

    public void eQ(int i) {
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
