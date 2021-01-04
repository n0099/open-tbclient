package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object fsk = new Object();
    private static e fsl = null;
    private boolean fsm = false;
    private boolean fsn = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bzo() {
        if (fsl == null) {
            synchronized (fsk) {
                if (fsl == null) {
                    fsl = new e();
                }
            }
        }
        return fsl;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean CM(String str) {
        this.errorNo = -1;
        if (!this.fsm) {
            this.fsn = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.QR);
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
        this.fsm = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bzl() {
        start();
        this.fsn = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bzh() {
        if (!this.fsn) {
            stop();
            this.fsn = true;
            this.fsm = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bzm() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bzn() {
        reset();
        this.fsm = false;
        this.fsn = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int nS() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.fsm;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        rN(i);
    }

    public void rN(int i) {
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
