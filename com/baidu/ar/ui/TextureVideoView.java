package com.baidu.ar.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.ar.util.o;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Map;
/* loaded from: classes3.dex */
public class TextureVideoView extends TextureView implements TextureView.SurfaceTextureListener {
    MediaPlayer.OnVideoSizeChangedListener a;
    MediaPlayer.OnPreparedListener b;
    private int c;
    private int d;
    private MediaPlayer e;
    private MediaPlayer.OnCompletionListener f;
    private MediaPlayer.OnPreparedListener g;
    private MediaPlayer.OnErrorListener h;
    private MediaPlayer.OnInfoListener i;
    private int j;
    private int k;
    private Surface l;
    private Uri m;
    private int n;
    private int o;
    private int p;
    private int q;
    private MediaPlayer.OnCompletionListener r;
    private MediaPlayer.OnInfoListener s;
    private MediaPlayer.OnErrorListener t;
    private MediaPlayer.OnBufferingUpdateListener u;

    public TextureVideoView(Context context) {
        this(context, null);
        f();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = 0;
        this.q = 2;
        this.a = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.ar.ui.TextureVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                TextureVideoView.this.o = mediaPlayer.getVideoWidth();
                TextureVideoView.this.p = mediaPlayer.getVideoHeight();
                TextureVideoView.this.d();
            }
        };
        this.b = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.ui.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                TextureVideoView.this.c = 2;
                if (TextureVideoView.this.g != null) {
                    TextureVideoView.this.g.onPrepared(TextureVideoView.this.e);
                }
                TextureVideoView.this.o = mediaPlayer.getVideoWidth();
                TextureVideoView.this.p = mediaPlayer.getVideoHeight();
                TextureVideoView.this.d();
                int i = TextureVideoView.this.k;
                if (i != 0) {
                    TextureVideoView.this.a(i);
                }
                if (TextureVideoView.this.d == 3) {
                    TextureVideoView.this.b();
                }
            }
        };
        this.r = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.ui.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                TextureVideoView.this.c = 5;
                TextureVideoView.this.d = 5;
                if (TextureVideoView.this.f != null) {
                    TextureVideoView.this.f.onCompletion(TextureVideoView.this.e);
                }
            }
        };
        this.s = new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.ui.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return TextureVideoView.this.i != null && TextureVideoView.this.i.onInfo(mediaPlayer, i, i2);
            }
        };
        this.t = new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.ui.TextureVideoView.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.ar.util.b.a("Error: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
                TextureVideoView.this.c = -1;
                TextureVideoView.this.d = -1;
                if (TextureVideoView.this.h == null || TextureVideoView.this.h.onError(TextureVideoView.this.e, i, i2)) {
                }
                return true;
            }
        };
        this.u = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.ui.TextureVideoView.6
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                TextureVideoView.this.j = i;
            }
        };
        f();
    }

    private void a(boolean z) {
        if (this.e != null) {
            this.e.reset();
            this.e.release();
            this.e = null;
            this.c = 0;
            if (z) {
                this.d = 0;
            }
        }
    }

    private boolean a(Surface surface) {
        if (this.m == null) {
            String e = o.e();
            if (!TextUtils.isEmpty(e)) {
                File file = new File(e);
                if (file.exists() && e.endsWith(".mp4")) {
                    this.m = Uri.fromFile(file);
                }
            }
        }
        if (this.m == null || surface == null) {
            if (this.m == null) {
                com.baidu.ar.util.b.d("bdar: mUri is NULL!!");
            }
            if (surface == null) {
                com.baidu.ar.util.b.d("bdar: mSurfaceHolder is NULL!!");
            }
            return false;
        }
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
        a(false);
        try {
            this.e = new MediaPlayer();
            if (this.n != 0) {
                this.e.setAudioSessionId(this.n);
            } else {
                this.n = this.e.getAudioSessionId();
            }
            this.e.setOnPreparedListener(this.b);
            this.e.setOnVideoSizeChangedListener(this.a);
            this.e.setOnCompletionListener(this.r);
            this.e.setOnErrorListener(this.t);
            this.e.setOnInfoListener(this.s);
            this.e.setOnBufferingUpdateListener(this.u);
            this.j = 0;
            this.e.setDataSource(getContext(), this.m);
            this.e.setLooping(true);
            this.e.setSurface(surface);
            this.e.setAudioStreamType(3);
            this.e.setScreenOnWhilePlaying(true);
            this.e.prepareAsync();
            this.c = 1;
            return true;
        } catch (Exception e2) {
            com.baidu.ar.util.b.c("Unable to open content: " + this.m + e2);
            this.c = -1;
            this.d = -1;
            this.t.onError(this.e, 1, 0);
            return false;
        }
    }

    private void f() {
        setSurfaceTextureListener(this);
        this.c = 0;
        this.d = 0;
    }

    private boolean g() {
        return (this.e == null || this.c == -1 || this.c == 0 || this.c == 1) ? false : true;
    }

    private void h() {
        float width = getWidth() / this.o;
        float height = getHeight() / this.p;
        Matrix matrix = new Matrix();
        float max = Math.max(width, height);
        matrix.preTranslate((getWidth() - this.o) / 2, (getHeight() - this.p) / 2);
        matrix.preScale(this.o / getWidth(), this.p / getHeight());
        matrix.postScale(max, max, getWidth() / 2, getHeight() / 2);
        setTransform(matrix);
        postInvalidate();
    }

    private void i() {
        float width = getWidth() / this.o;
        float height = getHeight() / this.p;
        Matrix matrix = new Matrix();
        matrix.preTranslate((getWidth() - this.o) / 2, (getHeight() - this.p) / 2);
        matrix.preScale(this.o / getWidth(), this.p / getHeight());
        if (width >= height) {
            matrix.postScale(height, height, getWidth() / 2, getHeight() / 2);
        } else {
            matrix.postScale(width, width, getWidth() / 2, getHeight() / 2);
        }
        setTransform(matrix);
        postInvalidate();
    }

    public void a() {
        b();
    }

    public void a(int i) {
        if (g()) {
            this.e.seekTo(i);
        } else {
            this.k = i;
        }
    }

    public void a(Uri uri, Map<String, String> map) {
        this.m = uri;
        this.k = 0;
    }

    public void b() {
        try {
            if (g()) {
                this.e.start();
                com.baidu.ar.util.b.d("bdar: mMediaPlayer start");
                this.c = 3;
            }
            this.d = 3;
        } catch (Exception e) {
            e.printStackTrace();
            this.c = -1;
            this.d = -1;
            this.t.onError(this.e, 1, 0);
        }
    }

    public void c() {
        if (g() && this.e.isPlaying()) {
            this.k = this.e.getCurrentPosition();
            this.e.pause();
            this.c = 4;
        }
        this.d = 4;
    }

    public void d() {
        if ((getWidth() - getHeight()) * (this.o - this.p) > 0) {
            h();
        } else {
            i();
        }
    }

    public void e() {
        a(true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.l == null) {
            this.l = new Surface(surfaceTexture);
        }
        a(this.l);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.l != null) {
            this.l.release();
            this.l = null;
        }
        a(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        d();
        com.baidu.ar.util.b.d("width = " + i + ", height = " + i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.h = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.i = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.g = onPreparedListener;
    }

    public void setVideoMode(int i) {
        this.q = i;
    }

    public void setVideoPath(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            setVideoURI(Uri.parse(str));
        } else {
            setVideoURI(Uri.fromFile(new File(str)));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }
}
