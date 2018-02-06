package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object bgG = new Object();
    private static e bgH = null;
    private boolean bgI = false;
    private boolean bgJ = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EZ() {
        if (bgH == null) {
            synchronized (bgG) {
                if (bgH == null) {
                    bgH = new e();
                }
            }
        }
        return bgH;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ff(String str) {
        this.errorNo = -1;
        if (!this.bgI) {
            this.bgJ = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.ans);
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
        this.bgI = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EV() {
        start();
        this.bgJ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void ER() {
        if (!this.bgJ) {
            stop();
            this.bgJ = true;
            this.bgI = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EW() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EX() {
        reset();
        this.bgI = false;
        this.bgJ = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int pm() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean EY() {
        return this.bgI;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void gM(int i) {
        gO(i);
    }

    public void gO(int i) {
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
