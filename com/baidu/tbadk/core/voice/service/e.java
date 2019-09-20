package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object cfV = new Object();
    private static e cfW = null;
    private boolean cfX = false;
    private boolean cfY = true;
    private int errorNo = -1;

    private e() {
    }

    public static e alV() {
        if (cfW == null) {
            synchronized (cfV) {
                if (cfW == null) {
                    cfW = new e();
                }
            }
        }
        return cfW;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean pj(String str) {
        this.errorNo = -1;
        if (!this.cfX) {
            this.cfY = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.ES);
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
        this.cfX = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alR() {
        start();
        this.cfY = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alN() {
        if (!this.cfY) {
            stop();
            this.cfY = true;
            this.cfX = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alS() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alT() {
        reset();
        this.cfX = false;
        this.cfY = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kF() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean alU() {
        return this.cfX;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        jt(i);
    }

    public void jt(int i) {
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
