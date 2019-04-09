package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object bVW = new Object();
    private static e bVX = null;
    private boolean bVY = false;
    private boolean bVZ = true;
    private int errorNo = -1;

    private e() {
    }

    public static e afD() {
        if (bVX == null) {
            synchronized (bVW) {
                if (bVX == null) {
                    bVX = new e();
                }
            }
        }
        return bVX;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean nB(String str) {
        this.errorNo = -1;
        if (!this.bVY) {
            this.bVZ = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Hb);
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
        this.bVY = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afz() {
        start();
        this.bVZ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afv() {
        if (!this.bVZ) {
            stop();
            this.bVZ = true;
            this.bVY = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afA() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void afB() {
        reset();
        this.bVY = false;
        this.bVZ = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lA() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean afC() {
        return this.bVY;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        iv(i);
    }

    public void iv(int i) {
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
