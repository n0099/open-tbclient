package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dLQ = new Object();
    private static e dLR = null;
    private boolean dLS = false;
    private boolean dLT = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aRu() {
        if (dLR == null) {
            synchronized (dLQ) {
                if (dLR == null) {
                    dLR = new e();
                }
            }
        }
        return dLR;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean vv(String str) {
        this.errorNo = -1;
        if (!this.dLS) {
            this.dLT = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.NH);
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
        this.dLS = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRr() {
        start();
        this.dLT = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRn() {
        if (!this.dLT) {
            stop();
            this.dLT = true;
            this.dLS = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRs() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRt() {
        reset();
        this.dLS = false;
        this.dLT = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int mt() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.dLS;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        lW(i);
    }

    public void lW(int i) {
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
