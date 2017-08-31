package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqP = new Object();
    private static e aqQ = null;
    private boolean aqR = false;
    private boolean aqS = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xN() {
        if (aqQ == null) {
            synchronized (aqP) {
                if (aqQ == null) {
                    aqQ = new e();
                }
            }
        }
        return aqQ;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eA(String str) {
        this.errorNo = -1;
        if (!this.aqR) {
            this.aqS = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.zf);
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
        this.aqR = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xJ() {
        start();
        this.aqS = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xF() {
        if (!this.aqS) {
            stop();
            this.aqS = true;
            this.aqR = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xK() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xL() {
        reset();
        this.aqR = false;
        this.aqS = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hL() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xM() {
        return this.aqR;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dF(int i) {
        dH(i);
    }

    public void dH(int i) {
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
