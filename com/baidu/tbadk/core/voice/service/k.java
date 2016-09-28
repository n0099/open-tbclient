package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object aiU = new Object();
    private static k aiV = null;
    private boolean aiW = false;
    private boolean aiX = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xp() {
        if (aiV == null) {
            synchronized (aiU) {
                if (aiV == null) {
                    aiV = new k();
                }
            }
        }
        return aiV;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean eg(String str) {
        this.errorNo = -1;
        if (!this.aiW) {
            this.aiX = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.sV);
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
        this.aiW = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xl() {
        start();
        this.aiX = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xg() {
        if (!this.aiX) {
            stop();
            this.aiX = true;
            this.aiW = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xm() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xn() {
        reset();
        this.aiW = false;
        this.aiX = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int gQ() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xo() {
        return this.aiW;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dv(int i) {
        dx(i);
    }

    public void dx(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int getErrorNo() {
        return this.errorNo;
    }
}
