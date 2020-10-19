package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object eNI = new Object();
    private static e eNJ = null;
    private boolean eNK = false;
    private boolean eNL = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bpM() {
        if (eNJ == null) {
            synchronized (eNI) {
                if (eNJ == null) {
                    eNJ = new e();
                }
            }
        }
        return eNJ;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Ca(String str) {
        this.errorNo = -1;
        if (!this.eNK) {
            this.eNL = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.PQ);
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
        this.eNK = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bpJ() {
        start();
        this.eNL = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bpF() {
        if (!this.eNL) {
            stop();
            this.eNL = true;
            this.eNK = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bpK() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bpL() {
        reset();
        this.eNK = false;
        this.eNL = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int os() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.eNK;
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
