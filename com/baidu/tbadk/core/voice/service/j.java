package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.io.IOException;
/* loaded from: classes.dex */
public class j extends MediaPlayer implements g {
    private static Object a = new Object();
    private static j b = null;
    private boolean c = false;
    private boolean d = true;
    private int e = -1;

    private j() {
    }

    public static j h() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new j();
                }
            }
        }
        return b;
    }

    public void b(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public boolean a(String str) {
        this.e = -1;
        if (!this.c) {
            this.d = true;
            reset();
            try {
                setDataSource(str);
                b(VoiceManager.CURR_STREAM_TYPE);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.e = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.e = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.e = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.e = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.e = 1;
                return false;
            }
        }
        this.c = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void a() {
        start();
        this.d = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void b() {
        if (!this.d) {
            stop();
            this.d = true;
            this.c = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void c() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void d() {
        reset();
        this.c = false;
        this.d = true;
        this.e = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public int e() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public boolean f() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public void a(int i) {
        c(i);
    }

    public void c(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.g
    public int g() {
        return this.e;
    }
}
