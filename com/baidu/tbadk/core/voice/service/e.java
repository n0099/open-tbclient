package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aqM = new Object();
    private static e aqN = null;
    private boolean aqO = false;
    private boolean aqP = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xN() {
        if (aqN == null) {
            synchronized (aqM) {
                if (aqN == null) {
                    aqN = new e();
                }
            }
        }
        return aqN;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eA(String str) {
        this.errorNo = -1;
        if (!this.aqO) {
            this.aqP = true;
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
        this.aqO = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xJ() {
        start();
        this.aqP = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xF() {
        if (!this.aqP) {
            stop();
            this.aqP = true;
            this.aqO = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xK() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xL() {
        reset();
        this.aqO = false;
        this.aqP = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hL() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xM() {
        return this.aqO;
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
