package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aDU = new Object();
    private static e aDV = null;
    private boolean aDW = false;
    private boolean aDX = true;
    private int errorNo = -1;

    private e() {
    }

    public static e CF() {
        if (aDV == null) {
            synchronized (aDU) {
                if (aDV == null) {
                    aDV = new e();
                }
            }
        }
        return aDV;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean fS(String str) {
        this.errorNo = -1;
        if (!this.aDW) {
            this.aDX = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Gp);
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
        this.aDW = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void CB() {
        start();
        this.aDX = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Cx() {
        if (!this.aDX) {
            stop();
            this.aDX = true;
            this.aDW = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void CC() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void CD() {
        reset();
        this.aDW = false;
        this.aDX = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int ln() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean CE() {
        return this.aDW;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void ec(int i) {
        ee(i);
    }

    public void ee(int i) {
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
