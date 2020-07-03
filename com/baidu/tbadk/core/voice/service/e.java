package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object eiV = new Object();
    private static e eiW = null;
    private boolean eiX = false;
    private boolean eiY = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aZF() {
        if (eiW == null) {
            synchronized (eiV) {
                if (eiW == null) {
                    eiW = new e();
                }
            }
        }
        return eiW;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xx(String str) {
        this.errorNo = -1;
        if (!this.eiX) {
            this.eiY = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Ox);
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
        this.eiX = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aZC() {
        start();
        this.eiY = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aZy() {
        if (!this.eiY) {
            stop();
            this.eiY = true;
            this.eiX = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aZD() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aZE() {
        reset();
        this.eiX = false;
        this.eiY = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int mL() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.eiX;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        mV(i);
    }

    public void mV(int i) {
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
