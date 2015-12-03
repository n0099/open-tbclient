package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ahr = new Object();
    private static k ahs = null;
    private boolean aht = false;
    private boolean ahu = true;
    private int errorNo = -1;

    private k() {
    }

    public static k wO() {
        if (ahs == null) {
            synchronized (ahr) {
                if (ahs == null) {
                    ahs = new k();
                }
            }
        }
        return ahs;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean dS(String str) {
        this.errorNo = -1;
        if (!this.aht) {
            this.ahu = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.zo);
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
        this.aht = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wK() {
        start();
        this.ahu = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wE() {
        if (!this.ahu) {
            stop();
            this.ahu = true;
            this.aht = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wL() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void wM() {
        reset();
        this.aht = false;
        this.ahu = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int jr() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean wN() {
        return this.aht;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dg(int i) {
        di(i);
    }

    public void di(int i) {
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
