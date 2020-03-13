package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dlI = new Object();
    private static e dlJ = null;
    private boolean dlK = false;
    private boolean dlL = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aIT() {
        if (dlJ == null) {
            synchronized (dlI) {
                if (dlJ == null) {
                    dlJ = new e();
                }
            }
        }
        return dlJ;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean uh(String str) {
        this.errorNo = -1;
        if (!this.dlK) {
            this.dlL = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.uR);
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
        this.dlK = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIQ() {
        start();
        this.dlL = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIN() {
        if (!this.dlL) {
            stop();
            this.dlL = true;
            this.dlK = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIR() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIS() {
        reset();
        this.dlK = false;
        this.dlL = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hP() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.dlK;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        lI(i);
    }

    public void lI(int i) {
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
