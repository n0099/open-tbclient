package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aAQ = new Object();
    private static e aAR = null;
    private boolean aAS = false;
    private boolean aAT = true;
    private int errorNo = -1;

    private e() {
    }

    public static e Bt() {
        if (aAR == null) {
            synchronized (aAQ) {
                if (aAR == null) {
                    aAR = new e();
                }
            }
        }
        return aAR;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean fx(String str) {
        this.errorNo = -1;
        if (!this.aAS) {
            this.aAT = true;
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
        this.aAS = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bp() {
        start();
        this.aAT = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bl() {
        if (!this.aAT) {
            stop();
            this.aAT = true;
            this.aAS = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bq() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Br() {
        reset();
        this.aAS = false;
        this.aAT = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kh() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Bs() {
        return this.aAS;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dQ(int i) {
        dS(i);
    }

    public void dS(int i) {
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
