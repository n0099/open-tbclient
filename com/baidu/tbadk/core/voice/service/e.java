package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object eph = new Object();
    private static e epi = null;
    private boolean epj = false;
    private boolean epk = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bdC() {
        if (epi == null) {
            synchronized (eph) {
                if (epi == null) {
                    epi = new e();
                }
            }
        }
        return epi;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean yC(String str) {
        this.errorNo = -1;
        if (!this.epj) {
            this.epk = true;
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
        this.epj = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bdz() {
        start();
        this.epk = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bdv() {
        if (!this.epk) {
            stop();
            this.epk = true;
            this.epj = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bdA() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bdB() {
        reset();
        this.epj = false;
        this.epk = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int mM() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.epj;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        nn(i);
    }

    public void nn(int i) {
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
