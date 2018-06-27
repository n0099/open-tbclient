package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aAZ = new Object();
    private static e aBa = null;
    private boolean aBb = false;
    private boolean aBc = true;
    private int errorNo = -1;

    private e() {
    }

    public static e BE() {
        if (aBa == null) {
            synchronized (aAZ) {
                if (aBa == null) {
                    aBa = new e();
                }
            }
        }
        return aBa;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean fz(String str) {
        this.errorNo = -1;
        if (!this.aBb) {
            this.aBc = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.DY);
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
        this.aBb = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void BA() {
        start();
        this.aBc = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bx() {
        if (!this.aBc) {
            stop();
            this.aBc = true;
            this.aBb = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void BB() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void BC() {
        reset();
        this.aBb = false;
        this.aBc = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kg() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean BD() {
        return this.aBb;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dO(int i) {
        dQ(i);
    }

    public void dQ(int i) {
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
