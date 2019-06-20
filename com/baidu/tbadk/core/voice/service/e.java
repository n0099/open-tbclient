package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object cdS = new Object();
    private static e cdT = null;
    private boolean cdU = false;
    private boolean cdV = true;
    private int errorNo = -1;

    private e() {
    }

    public static e akC() {
        if (cdT == null) {
            synchronized (cdS) {
                if (cdT == null) {
                    cdT = new e();
                }
            }
        }
        return cdT;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean oK(String str) {
        this.errorNo = -1;
        if (!this.cdU) {
            this.cdV = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.EK);
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
        this.cdU = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aky() {
        start();
        this.cdV = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aku() {
        if (!this.cdV) {
            stop();
            this.cdV = true;
            this.cdU = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void akz() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void akA() {
        reset();
        this.cdU = false;
        this.cdV = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int ku() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean akB() {
        return this.cdU;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        jj(i);
    }

    public void jj(int i) {
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
