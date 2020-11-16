package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object fbb = new Object();
    private static e fbc = null;
    private boolean fbd = false;
    private boolean fbe = true;
    private int errorNo = -1;

    private e() {
    }

    public static e btv() {
        if (fbc == null) {
            synchronized (fbb) {
                if (fbc == null) {
                    fbc = new e();
                }
            }
        }
        return fbc;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Cg(String str) {
        this.errorNo = -1;
        if (!this.fbd) {
            this.fbe = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.PT);
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
        this.fbd = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bts() {
        start();
        this.fbe = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bto() {
        if (!this.fbe) {
            stop();
            this.fbe = true;
            this.fbd = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void btt() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void btu() {
        reset();
        this.fbd = false;
        this.fbe = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int os() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.fbd;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        ra(i);
    }

    public void ra(int i) {
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
