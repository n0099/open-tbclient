package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object frt = new Object();
    private static e fru = null;
    private boolean frv = false;
    private boolean frw = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bvR() {
        if (fru == null) {
            synchronized (frt) {
                if (fru == null) {
                    fru = new e();
                }
            }
        }
        return fru;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean BY(String str) {
        this.errorNo = -1;
        if (!this.frv) {
            this.frw = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Si);
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
        this.frv = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvO() {
        start();
        this.frw = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvL() {
        if (!this.frw) {
            stop();
            this.frw = true;
            this.frv = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvP() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvQ() {
        reset();
        this.frv = false;
        this.frw = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int nR() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.frv;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        qn(i);
    }

    public void qn(int i) {
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
