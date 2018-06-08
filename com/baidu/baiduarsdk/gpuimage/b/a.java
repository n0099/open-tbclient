package com.baidu.baiduarsdk.gpuimage.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.baidu.baiduarsdk.gpuimage.a.g;
/* loaded from: classes3.dex */
public class a extends g {
    private int a;
    private int[] k;
    private int[] l;
    private int m;
    private Bitmap[] n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String[] strArr, String str) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", str);
        this.a = 0;
        if (strArr == null) {
            this.a = 0;
            return;
        }
        this.a = strArr.length;
        this.n = new Bitmap[this.a];
        this.k = new int[this.a];
        this.l = new int[this.a];
        for (int i = 0; i < this.a; i++) {
            this.n[i] = BitmapFactory.decodeFile(strArr[i]);
        }
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        for (int i = 0; i < this.a; i++) {
            this.l[i] = GLES20.glGetUniformLocation(h(), "inputImageTexture" + (i + 2));
        }
        this.m = GLES20.glGetUniformLocation(h(), "strength");
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b() {
        super.b();
        a(this.m, 1.0f);
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < a.this.a; i++) {
                    a.this.k[i] = com.baidu.baiduarsdk.gpuimage.graphics.a.a(a.this.n[i], -1, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void e() {
        super.e();
        GLES20.glDeleteTextures(this.k.length, this.k, 0);
        for (int i = 0; i < this.a; i++) {
            this.k[i] = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void f() {
        for (int i = 0; i < this.a && this.k[i] != -1; i++) {
            GLES20.glActiveTexture(33984 + i + 3);
            GLES20.glBindTexture(3553, this.k[i]);
            GLES20.glUniform1i(this.l[i], i + 3);
        }
    }
}
