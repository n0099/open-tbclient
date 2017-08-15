package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object arj = new Object();
    private static e ark = null;
    private boolean arl = false;
    private boolean arm = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xL() {
        if (ark == null) {
            synchronized (arj) {
                if (ark == null) {
                    ark = new e();
                }
            }
        }
        return ark;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eD(String str) {
        this.errorNo = -1;
        if (!this.arl) {
            this.arm = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Bm);
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
        this.arl = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xH() {
        start();
        this.arm = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xD() {
        if (!this.arm) {
            stop();
            this.arm = true;
            this.arl = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xI() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xJ() {
        reset();
        this.arl = false;
        this.arm = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hU() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xK() {
        return this.arl;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dE(int i) {
        dG(i);
    }

    public void dG(int i) {
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
