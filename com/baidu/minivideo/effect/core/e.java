package com.baidu.minivideo.effect.core;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.view.Surface;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends b {
    private static String d = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n";
    private static int[] h = {33987, 33988, 33989, 33990, 33991, 33992, 33993, 33994, 33995, 33996};
    private static int t = 1;
    private Bitmap[] aIL;
    private MediaPlayer aIM;
    private SurfaceTexture aIN;
    private Surface aIO;
    private int[] aIP;
    private d aIQ;
    private int[] e;
    private int[] f;
    private int[] g;
    private FloatBuffer i;
    private List<Object> k;
    private FloatBuffer q;
    private FloatBuffer r;
    private int s;

    public e(String str, String str2) {
        super(str, str2);
        this.aIP = new int[1];
        this.s = -1;
        this.e = new int[t];
        this.f = new int[t];
        this.g = new int[t];
        for (int i = 0; i < t; i++) {
            this.g[i] = -1;
        }
        this.i = ByteBuffer.allocateDirect(g.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(Rotation.NORMAL, false, false);
    }

    private void a(Rotation rotation, boolean z, boolean z2) {
        this.i.clear();
        this.i.put(g.b(rotation, z, z2)).position(0);
    }

    public static String b(int i) {
        if (t > h.length) {
            throw new RuntimeException("too many textures !!!");
        }
        t = i;
        StringBuilder sb = new StringBuilder(d);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("attribute vec4 inputTextureCoordinate" + (i2 + 2));
            sb.append(";\n");
            sb.append("varying vec2 textureCoordinate" + (i2 + 2));
            sb.append(";\n");
        }
        sb.append("\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n");
        for (int i3 = 0; i3 < i; i3++) {
            sb.append("    ");
            sb.append("textureCoordinate" + (i3 + 2));
            sb.append(" = ");
            sb.append("inputTextureCoordinate" + (i3 + 2));
            sb.append(".xy");
            sb.append(";\n");
        }
        sb.append("}");
        return sb.toString();
    }

    private void c(int i) {
        GLES20.glTexImage2D(3553, 0, 6408, l(), m(), 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        GLES20.glGenFramebuffers(1, this.aIP, 0);
        GLES20.glBindFramebuffer(36160, this.aIP[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.aIL != null && this.aIL.length > i && this.aIL[i] != null && !this.aIL[i].isRecycled()) {
            this.aIL[i].recycle();
            this.aIL[i] = null;
        }
        if (this.aIL == null || i != this.aIL.length - 1) {
            return;
        }
        this.aIL = null;
    }

    private void t() {
        GLES20.glDeleteFramebuffers(1, this.aIP, 0);
    }

    private void u() {
        if (this.aIL == null || this.aIL.length <= 0) {
            return;
        }
        for (int i = 0; i < this.aIL.length; i++) {
            d(i);
        }
    }

    private void v() {
        if (this.aIN != null) {
            this.aIN.release();
        }
        if (this.aIO != null) {
            this.aIO.release();
        }
        if (this.aIM != null) {
            this.aIM.pause();
            this.aIM.stop();
            this.aIM.release();
        }
        t();
        if (this.aIQ != null) {
            this.aIQ.e();
        }
        if (this.s != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.s}, 0);
            this.s = -1;
        }
    }

    public void a(List<Object> list) {
        this.k = list;
        if (this.k == null || this.k.size() == 0) {
            return;
        }
        Object obj = list.get(0);
        this.aIM = new MediaPlayer();
        this.aIM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.minivideo.effect.core.e.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.this.aIM.start();
            }
        });
        this.aIM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.minivideo.effect.core.e.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.this.aIM.start();
            }
        });
        this.aIM.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.minivideo.effect.core.e.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            }
        });
        this.aIM.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.minivideo.effect.core.e.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        this.aIM.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.minivideo.effect.core.e.5
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        try {
            this.aIM.setVolume(0.0f, 0.0f);
            if (obj instanceof AssetFileDescriptor) {
                this.aIM.setDataSource(((AssetFileDescriptor) obj).getFileDescriptor(), ((AssetFileDescriptor) obj).getStartOffset(), ((AssetFileDescriptor) obj).getLength());
                ((AssetFileDescriptor) obj).close();
            } else {
                this.aIM.setDataSource((String) obj);
            }
            int length = this.aIL != null ? this.aIL.length : 0;
            this.s = f.b();
            this.aIQ = new d("#extension GL_OES_EGL_image_external : require\nprecision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}");
            this.aIQ.a();
            this.q = ByteBuffer.allocateDirect(f.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.q.put(f.a).position(0);
            this.r = ByteBuffer.allocateDirect(g.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.r.put(g.b(Rotation.NORMAL, false, true)).position(0);
            this.aIN = new SurfaceTexture(this.s);
            if (this.g[length] == -1) {
                GLES20.glActiveTexture(h[length]);
                this.g[length] = f.a();
                c(this.g[length]);
            }
            this.aIN.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.minivideo.effect.core.e.6
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
                    e.this.a(new Runnable() { // from class: com.baidu.minivideo.effect.core.e.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (surfaceTexture != null) {
                                surfaceTexture.updateTexImage();
                                float[] fArr = new float[16];
                                surfaceTexture.getTransformMatrix(fArr);
                                e.this.aIQ.b(fArr);
                            }
                        }
                    });
                }
            });
            this.aIO = new Surface(this.aIN);
            this.aIM.setSurface(this.aIO);
            this.aIM.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(final Bitmap[] bitmapArr) {
        this.aIL = bitmapArr;
        if (this.aIL == null || bitmapArr.length == 0) {
            return;
        }
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.e.7
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < bitmapArr.length; i++) {
                    if (e.this.g[i] == -1) {
                        if (bitmapArr[i] == null || bitmapArr[i].isRecycled()) {
                            return;
                        }
                        GLES20.glActiveTexture(e.h[i]);
                        e.this.g[i] = f.a(bitmapArr[i], -1, false);
                        e.this.d(i);
                    }
                }
            }
        });
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void b() {
        super.b();
        for (int i = 0; i < this.e.length; i++) {
            this.e[i] = GLES20.glGetAttribLocation(n(), "inputTextureCoordinate" + (i + 2));
            this.f[i] = GLES20.glGetUniformLocation(n(), "inputImageTexture" + (i + 2));
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void c() {
        super.c();
        if (this.aIL != null) {
            a(this.aIL);
        }
        if (this.k != null) {
            a(this.k);
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void f() {
        super.f();
        v();
        r();
        u();
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void h() {
        if (this.aIQ != null) {
            GLES20.glBindFramebuffer(36160, this.aIP[0]);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            this.aIQ.p();
            this.aIQ.b(this.s, this.q, this.r);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    protected void i() {
        for (int i = 0; i < this.e.length; i++) {
            if (this.g[i] != -1) {
                GLES20.glEnableVertexAttribArray(this.e[i]);
                GLES20.glActiveTexture(h[i]);
                GLES20.glBindTexture(3553, this.g[i]);
                GLES20.glUniform1i(this.f[i], i + 3);
                this.i.position(0);
                GLES20.glVertexAttribPointer(this.e[i], 2, 5126, false, 0, (Buffer) this.i);
            }
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    protected void j() {
        for (int i = 0; i < this.e.length; i++) {
            GLES20.glDisableVertexAttribArray(this.e[i]);
        }
    }

    public void r() {
        for (int i = 0; i < this.g.length; i++) {
            if (this.g[i] != -1) {
                GLES20.glDeleteTextures(1, new int[]{this.g[i]}, 0);
                this.g[i] = -1;
            }
        }
    }
}
