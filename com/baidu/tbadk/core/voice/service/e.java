package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dlu = new Object();
    private static e dlv = null;
    private boolean dlw = false;
    private boolean dlx = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aIQ() {
        if (dlv == null) {
            synchronized (dlu) {
                if (dlv == null) {
                    dlv = new e();
                }
            }
        }
        return dlv;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ug(String str) {
        this.errorNo = -1;
        if (!this.dlw) {
            this.dlx = true;
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
        this.dlw = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIN() {
        start();
        this.dlx = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIK() {
        if (!this.dlx) {
            stop();
            this.dlx = true;
            this.dlw = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIO() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIP() {
        reset();
        this.dlw = false;
        this.dlx = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hP() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.dlw;
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
