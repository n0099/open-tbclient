package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object apP = new Object();
    private static e apQ = null;
    private boolean apR = false;
    private boolean apS = true;
    private int errorNo = -1;

    private e() {
    }

    public static e xD() {
        if (apQ == null) {
            synchronized (apP) {
                if (apQ == null) {
                    apQ = new e();
                }
            }
        }
        return apQ;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ex(String str) {
        this.errorNo = -1;
        if (!this.apR) {
            this.apS = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.zJ);
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
        this.apR = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xz() {
        start();
        this.apS = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xv() {
        if (!this.apS) {
            stop();
            this.apS = true;
            this.apR = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xA() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void xB() {
        reset();
        this.apR = false;
        this.apS = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int hK() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean xC() {
        return this.apR;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dC(int i) {
        dE(i);
    }

    public void dE(int i) {
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
