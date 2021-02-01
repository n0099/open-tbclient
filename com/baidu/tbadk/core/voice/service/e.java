package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object fpS = new Object();
    private static e fpT = null;
    private boolean fpU = false;
    private boolean fpV = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bvO() {
        if (fpT == null) {
            synchronized (fpS) {
                if (fpT == null) {
                    fpT = new e();
                }
            }
        }
        return fpT;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean BR(String str) {
        this.errorNo = -1;
        if (!this.fpU) {
            this.fpV = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.QM);
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
        this.fpU = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvL() {
        start();
        this.fpV = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvI() {
        if (!this.fpV) {
            stop();
            this.fpV = true;
            this.fpU = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvM() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bvN() {
        reset();
        this.fpU = false;
        this.fpV = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int nR() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.fpU;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        qm(i);
    }

    public void qm(int i) {
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
