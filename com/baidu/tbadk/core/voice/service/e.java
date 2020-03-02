package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dlv = new Object();
    private static e dlw = null;
    private boolean dlx = false;
    private boolean dly = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aIS() {
        if (dlw == null) {
            synchronized (dlv) {
                if (dlw == null) {
                    dlw = new e();
                }
            }
        }
        return dlw;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ug(String str) {
        this.errorNo = -1;
        if (!this.dlx) {
            this.dly = true;
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
        this.dlx = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIP() {
        start();
        this.dly = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIM() {
        if (!this.dly) {
            stop();
            this.dly = true;
            this.dlx = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIQ() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIR() {
        reset();
        this.dlx = false;
        this.dly = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hP() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.dlx;
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
