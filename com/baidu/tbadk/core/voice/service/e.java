package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aJo = new Object();
    private static e aJp = null;
    private boolean aJq = false;
    private boolean aJr = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EU() {
        if (aJp == null) {
            synchronized (aJo) {
                if (aJp == null) {
                    aJp = new e();
                }
            }
        }
        return aJp;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean gh(String str) {
        this.errorNo = -1;
        if (!this.aJq) {
            this.aJr = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Hc);
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
        this.aJq = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EQ() {
        start();
        this.aJr = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EM() {
        if (!this.aJr) {
            stop();
            this.aJr = true;
            this.aJq = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void ER() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void ES() {
        reset();
        this.aJq = false;
        this.aJr = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lw() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ET() {
        return this.aJq;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        eB(i);
    }

    public void eB(int i) {
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
