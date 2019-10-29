package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object cuh = new Object();
    private static e cui = null;
    private boolean cuj = false;
    private boolean cuk = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aoJ() {
        if (cui == null) {
            synchronized (cuh) {
                if (cui == null) {
                    cui = new e();
                }
            }
        }
        return cui;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean oI(String str) {
        this.errorNo = -1;
        if (!this.cuj) {
            this.cuk = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.sc);
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
        this.cuj = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoF() {
        start();
        this.cuk = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoB() {
        if (!this.cuk) {
            stop();
            this.cuk = true;
            this.cuj = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoG() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aoH() {
        reset();
        this.cuj = false;
        this.cuk = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hf() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean aoI() {
        return this.cuj;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        jf(i);
    }

    public void jf(int i) {
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
