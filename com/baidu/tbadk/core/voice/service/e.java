package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dho = new Object();
    private static e dhp = null;
    private boolean dhq = false;
    private boolean dhr = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aGC() {
        if (dhp == null) {
            synchronized (dho) {
                if (dhp == null) {
                    dhp = new e();
                }
            }
        }
        return dhp;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean tQ(String str) {
        this.errorNo = -1;
        if (!this.dhq) {
            this.dhr = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.uA);
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
        this.dhq = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGy() {
        start();
        this.dhr = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGv() {
        if (!this.dhr) {
            stop();
            this.dhr = true;
            this.dhq = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGz() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGA() {
        reset();
        this.dhq = false;
        this.dhr = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hB() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean aGB() {
        return this.dhq;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        lr(i);
    }

    public void lr(int i) {
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
