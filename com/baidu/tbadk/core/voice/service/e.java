package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object ctq = new Object();
    private static e ctr = null;
    private boolean cts = false;
    private boolean ctt = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aoH() {
        if (ctr == null) {
            synchronized (ctq) {
                if (ctr == null) {
                    ctr = new e();
                }
            }
        }
        return ctr;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean oI(String str) {
        this.errorNo = -1;
        if (!this.cts) {
            this.ctt = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.rC);
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
        this.cts = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoD() {
        start();
        this.ctt = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoz() {
        if (!this.ctt) {
            stop();
            this.ctt = true;
            this.cts = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoE() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoF() {
        reset();
        this.cts = false;
        this.ctt = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hf() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean aoG() {
        return this.cts;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        je(i);
    }

    public void je(int i) {
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
