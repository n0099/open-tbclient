package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object asc = new Object();
    private static e asd = null;
    private boolean ase = false;
    private boolean asf = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xM() {
        if (asd == null) {
            synchronized (asc) {
                if (asd == null) {
                    asd = new e();
                }
            }
        }
        return asd;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eX(String str) {
        this.errorNo = -1;
        if (!this.ase) {
            this.asf = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.xP);
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
        this.ase = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xI() {
        start();
        this.asf = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xF() {
        if (!this.asf) {
            stop();
            this.asf = true;
            this.ase = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xJ() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xK() {
        reset();
        this.ase = false;
        this.asf = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hs() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xL() {
        return this.ase;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dK(int i) {
        dM(i);
    }

    public void dM(int i) {
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
