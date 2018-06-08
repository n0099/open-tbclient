package com.baidu.baiduarsdk.gpuimage.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.baidu.baiduarsdk.gpuimage.graphics.Drawable2d;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class r extends g {
    protected Bitmap a;
    protected volatile boolean k;
    private int l;
    private int m;
    private int n;
    private FloatBuffer o;

    public r(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public r(String str, String str2) {
        super(str, str2);
        this.n = -1;
        this.k = false;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.k = false;
        this.o = Drawable2d.c;
        this.l = GLES20.glGetAttribLocation(h(), "inputTextureCoordinate2");
        this.m = GLES20.glGetUniformLocation(h(), "inputImageTexture2");
    }

    public void a(final Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.a = bitmap;
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.r.2
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.a == null || r.this.a.isRecycled()) {
                    return;
                }
                r.this.o = Drawable2d.d;
                GLES20.glActiveTexture(33986);
                if (!r.this.k && r.this.n != -1) {
                    r.this.n = com.baidu.baiduarsdk.gpuimage.graphics.a.a(bitmap, r.this.n, false);
                    return;
                }
                if (r.this.n != -1) {
                    GLES20.glDeleteTextures(1, new int[]{r.this.n}, 0);
                }
                r.this.n = com.baidu.baiduarsdk.gpuimage.graphics.a.a(bitmap, -1, false);
            }
        });
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b() {
        if (this.a == null || this.a.isRecycled()) {
            return;
        }
        a(this.a);
    }

    public void b(final int i) {
        this.o = Drawable2d.c;
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.r.1
            @Override // java.lang.Runnable
            public void run() {
                r.this.n = i;
            }
        });
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void e() {
        super.e();
        if (this.n != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.n}, 0);
            this.n = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void f() {
        super.f();
        if (this.n != -1) {
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.n);
            GLES20.glUniform1i(this.m, 2);
        }
        if (this.o == null || this.l < 0) {
            return;
        }
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 0, (Buffer) this.o);
    }
}
