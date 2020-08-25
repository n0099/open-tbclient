package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e extends MediaPlayer implements c {
    private static Object ezt = new Object();
    private static e ezu = null;
    private boolean ezv = false;
    private boolean ezw = true;
    private int errorNo = -1;

    private e() {
    }

    public static e bmi() {
        if (ezu == null) {
            synchronized (ezt) {
                if (ezu == null) {
                    ezu = new e();
                }
            }
        }
        return ezu;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean AR(String str) {
        this.errorNo = -1;
        if (!this.ezv) {
            this.ezw = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Pd);
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
        this.ezv = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmf() {
        start();
        this.ezw = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmb() {
        if (!this.ezw) {
            stop();
            this.ezw = true;
            this.ezv = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmg() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bmh() {
        reset();
        this.ezv = false;
        this.ezw = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int om() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.ezv;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        pw(i);
    }

    public void pw(int i) {
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
