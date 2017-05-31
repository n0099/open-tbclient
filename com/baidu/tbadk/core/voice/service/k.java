package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object anX = new Object();
    private static k anY = null;
    private boolean anZ = false;
    private boolean aoa = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xa() {
        if (anY == null) {
            synchronized (anX) {
                if (anY == null) {
                    anY = new k();
                }
            }
        }
        return anY;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ea(String str) {
        this.errorNo = -1;
        if (!this.anZ) {
            this.aoa = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zJ);
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
        this.anZ = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wW() {
        start();
        this.aoa = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wS() {
        if (!this.aoa) {
            stop();
            this.aoa = true;
            this.anZ = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wX() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wY() {
        reset();
        this.anZ = false;
        this.aoa = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int hN() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean wZ() {
        return this.anZ;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dy(int i) {
        dA(i);
    }

    public void dA(int i) {
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
