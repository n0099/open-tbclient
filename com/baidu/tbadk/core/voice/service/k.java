package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object agi = new Object();
    private static k agj = null;
    private boolean agk = false;
    private boolean agl = true;
    private int agm = -1;

    private k() {
    }

    public static k vY() {
        if (agj == null) {
            synchronized (agi) {
                if (agj == null) {
                    agj = new k();
                }
            }
        }
        return agj;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dz(String str) {
        this.agm = -1;
        if (!this.agk) {
            this.agl = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zj);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.agm = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.agm = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.agm = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.agm = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.agm = 1;
                return false;
            }
        }
        this.agk = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vU() {
        start();
        this.agl = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vO() {
        if (!this.agl) {
            stop();
            this.agl = true;
            this.agk = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vV() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void vW() {
        reset();
        this.agk = false;
        this.agl = true;
        this.agm = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jr() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean vX() {
        return this.agk;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void cK(int i) {
        cM(i);
    }

    public void cM(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int getErrorNo() {
        return this.agm;
    }
}
