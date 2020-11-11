package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object fbT = new Object();
    private static e fbU = null;
    private boolean fbV = false;
    private boolean fbW = true;
    private int errorNo = -1;

    private e() {
    }

    public static e buf() {
        if (fbU == null) {
            synchronized (fbT) {
                if (fbU == null) {
                    fbU = new e();
                }
            }
        }
        return fbU;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean CH(String str) {
        this.errorNo = -1;
        if (!this.fbV) {
            this.fbW = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.PR);
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
        this.fbV = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void buc() {
        start();
        this.fbW = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void btY() {
        if (!this.fbW) {
            stop();
            this.fbW = true;
            this.fbV = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bud() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bue() {
        reset();
        this.fbV = false;
        this.fbW = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int os() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.fbV;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        qC(i);
    }

    public void qC(int i) {
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
