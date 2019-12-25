package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dhc = new Object();
    private static e dhd = null;
    private boolean dhe = false;
    private boolean dhf = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aGj() {
        if (dhd == null) {
            synchronized (dhc) {
                if (dhd == null) {
                    dhd = new e();
                }
            }
        }
        return dhd;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean tM(String str) {
        this.errorNo = -1;
        if (!this.dhe) {
            this.dhf = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.ux);
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
        this.dhe = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGf() {
        start();
        this.dhf = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGc() {
        if (!this.dhf) {
            stop();
            this.dhf = true;
            this.dhe = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGg() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aGh() {
        reset();
        this.dhe = false;
        this.dhf = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hC() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean aGi() {
        return this.dhe;
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
