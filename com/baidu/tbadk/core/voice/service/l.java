package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.q;
import java.io.IOException;
/* loaded from: classes.dex */
public class l extends MediaPlayer implements i {
    private static Object OX = new Object();
    private static l OY = null;
    private boolean OZ = false;
    private boolean Pa = true;
    private int Pb = -1;

    private l() {
    }

    public static l rc() {
        if (OY == null) {
            synchronized (OX) {
                if (OY == null) {
                    OY = new l();
                }
            }
        }
        return OY;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean cY(String str) {
        this.Pb = -1;
        if (!this.OZ) {
            this.Pa = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(q.oH);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.Pb = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.Pb = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.Pb = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.Pb = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.Pb = 1;
                return false;
            }
        }
        this.OZ = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qY() {
        start();
        this.Pa = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qS() {
        if (!this.Pa) {
            stop();
            this.Pa = true;
            this.OZ = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qZ() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void ra() {
        reset();
        this.OZ = false;
        this.Pa = true;
        this.Pb = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int fE() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean rb() {
        return this.OZ;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void seek(int i) {
        cx(i);
    }

    public void cx(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int getErrorNo() {
        return this.Pb;
    }
}
