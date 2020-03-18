package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dlV = new Object();
    private static e dlW = null;
    private boolean dlX = false;
    private boolean dlY = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aIX() {
        if (dlW == null) {
            synchronized (dlV) {
                if (dlW == null) {
                    dlW = new e();
                }
            }
        }
        return dlW;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ug(String str) {
        this.errorNo = -1;
        if (!this.dlX) {
            this.dlY = true;
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
        this.dlX = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIU() {
        start();
        this.dlY = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIR() {
        if (!this.dlY) {
            stop();
            this.dlY = true;
            this.dlX = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIV() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aIW() {
        reset();
        this.dlX = false;
        this.dlY = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hP() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.dlX;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        lK(i);
    }

    public void lK(int i) {
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
