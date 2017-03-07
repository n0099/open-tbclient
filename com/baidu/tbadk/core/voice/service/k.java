package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object anU = new Object();
    private static k anV = null;
    private boolean anW = false;
    private boolean anX = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xx() {
        if (anV == null) {
            synchronized (anU) {
                if (anV == null) {
                    anV = new k();
                }
            }
        }
        return anV;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dX(String str) {
        this.errorNo = -1;
        if (!this.anW) {
            this.anX = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.Af);
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
        this.anW = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xt() {
        start();
        this.anX = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xp() {
        if (!this.anX) {
            stop();
            this.anX = true;
            this.anW = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xu() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xv() {
        reset();
        this.anW = false;
        this.anX = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int hI() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xw() {
        return this.anW;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dw(int i) {
        dy(i);
    }

    public void dy(int i) {
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
