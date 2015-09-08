package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ags = new Object();
    private static k agt = null;
    private boolean agu = false;
    private boolean agv = true;
    private int agw = -1;

    private k() {
    }

    public static k wd() {
        if (agt == null) {
            synchronized (ags) {
                if (agt == null) {
                    agt = new k();
                }
            }
        }
        return agt;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dG(String str) {
        this.agw = -1;
        if (!this.agu) {
            this.agv = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zh);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.agw = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.agw = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.agw = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.agw = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.agw = 1;
                return false;
            }
        }
        this.agu = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vZ() {
        start();
        this.agv = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vT() {
        if (!this.agv) {
            stop();
            this.agv = true;
            this.agu = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wa() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wb() {
        reset();
        this.agu = false;
        this.agv = true;
        this.agw = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jo() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean wc() {
        return this.agu;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void cQ(int i) {
        cS(i);
    }

    public void cS(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int getErrorNo() {
        return this.agw;
    }
}
