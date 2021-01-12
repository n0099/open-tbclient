package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object fnz = new Object();
    private static e fnA = null;
    private boolean fnB = false;
    private boolean fnC = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bvv() {
        if (fnA == null) {
            synchronized (fnz) {
                if (fnA == null) {
                    fnA = new e();
                }
            }
        }
        return fnA;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean BA(String str) {
        this.errorNo = -1;
        if (!this.fnB) {
            this.fnC = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.QO);
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
        this.fnB = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvs() {
        start();
        this.fnC = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvo() {
        if (!this.fnC) {
            stop();
            this.fnC = true;
            this.fnB = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvt() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvu() {
        reset();
        this.fnB = false;
        this.fnC = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int nS() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.fnB;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        qh(i);
    }

    public void qh(int i) {
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
