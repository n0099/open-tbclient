package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object agy = new Object();
    private static k agz = null;
    private boolean agA = false;
    private boolean agB = true;
    private int errorNo = -1;

    private k() {
    }

    public static k wj() {
        if (agz == null) {
            synchronized (agy) {
                if (agz == null) {
                    agz = new k();
                }
            }
        }
        return agz;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ea(String str) {
        this.errorNo = -1;
        if (!this.agA) {
            this.agB = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.qF);
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
        this.agA = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wf() {
        start();
        this.agB = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wa() {
        if (!this.agB) {
            stop();
            this.agB = true;
            this.agA = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wg() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wh() {
        reset();
        this.agA = false;
        this.agB = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int fU() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean wi() {
        return this.agA;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dh(int i) {
        dj(i);
    }

    public void dj(int i) {
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
