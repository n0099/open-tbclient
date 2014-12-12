package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.q;
import java.io.IOException;
/* loaded from: classes.dex */
public class l extends MediaPlayer implements i {
    private static Object Ow = new Object();
    private static l Ox = null;
    private boolean Oy = false;
    private boolean Oz = true;
    private int OA = -1;

    private l() {
    }

    public static l qX() {
        if (Ox == null) {
            synchronized (Ow) {
                if (Ox == null) {
                    Ox = new l();
                }
            }
        }
        return Ox;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dc(String str) {
        this.OA = -1;
        if (!this.Oy) {
            this.Oz = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(q.oC);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.OA = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.OA = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.OA = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.OA = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.OA = 1;
                return false;
            }
        }
        this.Oy = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qT() {
        start();
        this.Oz = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qN() {
        if (!this.Oz) {
            stop();
            this.Oz = true;
            this.Oy = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qU() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qV() {
        reset();
        this.Oy = false;
        this.Oz = true;
        this.OA = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int fF() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean qW() {
        return this.Oy;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void seek(int i) {
        cq(i);
    }

    public void cq(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int getErrorNo() {
        return this.OA;
    }
}
