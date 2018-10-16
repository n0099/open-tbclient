package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aIy = new Object();
    private static e aIz = null;
    private boolean aIA = false;
    private boolean aIB = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EJ() {
        if (aIz == null) {
            synchronized (aIy) {
                if (aIz == null) {
                    aIz = new e();
                }
            }
        }
        return aIz;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean gg(String str) {
        this.errorNo = -1;
        if (!this.aIA) {
            this.aIB = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.GY);
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
        this.aIA = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EF() {
        start();
        this.aIB = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EC() {
        if (!this.aIB) {
            stop();
            this.aIB = true;
            this.aIA = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EG() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EH() {
        reset();
        this.aIA = false;
        this.aIB = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int ly() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean EI() {
        return this.aIA;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        en(i);
    }

    public void en(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int getErrorNo() {
        return this.errorNo;
    }
}
