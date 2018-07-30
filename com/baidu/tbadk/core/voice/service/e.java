package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aAT = new Object();
    private static e aAU = null;
    private boolean aAV = false;
    private boolean aAW = true;
    private int errorNo = -1;

    private e() {
    }

    public static e Bw() {
        if (aAU == null) {
            synchronized (aAT) {
                if (aAU == null) {
                    aAU = new e();
                }
            }
        }
        return aAU;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean fx(String str) {
        this.errorNo = -1;
        if (!this.aAV) {
            this.aAW = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.DV);
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
        this.aAV = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bs() {
        start();
        this.aAW = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bo() {
        if (!this.aAW) {
            stop();
            this.aAW = true;
            this.aAV = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bt() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bu() {
        reset();
        this.aAV = false;
        this.aAW = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kh() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Bv() {
        return this.aAV;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dR(int i) {
        dT(i);
    }

    public void dT(int i) {
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
