package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object aiy = new Object();
    private static k aiz = null;
    private boolean aiA = false;
    private boolean aiB = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xb() {
        if (aiz == null) {
            synchronized (aiy) {
                if (aiz == null) {
                    aiz = new k();
                }
            }
        }
        return aiz;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ed(String str) {
        this.errorNo = -1;
        if (!this.aiA) {
            this.aiB = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.sN);
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
        this.aiA = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wX() {
        start();
        this.aiB = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wS() {
        if (!this.aiB) {
            stop();
            this.aiB = true;
            this.aiA = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wY() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wZ() {
        reset();
        this.aiA = false;
        this.aiB = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int gO() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xa() {
        return this.aiA;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dA(int i) {
        dC(i);
    }

    public void dC(int i) {
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
