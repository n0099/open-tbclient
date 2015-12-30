package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object aiu = new Object();
    private static k aiv = null;
    private boolean aiw = false;
    private boolean aix = true;
    private int errorNo = -1;

    private k() {
    }

    public static k wx() {
        if (aiv == null) {
            synchronized (aiu) {
                if (aiv == null) {
                    aiv = new k();
                }
            }
        }
        return aiv;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dV(String str) {
        this.errorNo = -1;
        if (!this.aiw) {
            this.aix = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zq);
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
        this.aiw = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wt() {
        start();
        this.aix = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wn() {
        if (!this.aix) {
            stop();
            this.aix = true;
            this.aiw = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wu() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wv() {
        reset();
        this.aiw = false;
        this.aix = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int js() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ww() {
        return this.aiw;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void cZ(int i) {
        db(i);
    }

    public void db(int i) {
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
