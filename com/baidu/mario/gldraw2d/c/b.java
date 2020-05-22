package com.baidu.mario.gldraw2d.c;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.mario.gldraw2d.d.d;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class b extends a implements c {
    private static final String TAG = b.class.getSimpleName();
    protected d bmU;
    protected com.baidu.mario.gldraw2d.d.c bmV;
    private int bmW;
    protected int mProgramHandle;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    protected String bmS = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    protected String bmT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
    private final LinkedList<Runnable> mRunOnDraw = new LinkedList<>();

    @Override // com.baidu.mario.gldraw2d.c.c
    public void a(d dVar, com.baidu.mario.gldraw2d.d.c cVar) {
        this.bmU = dVar;
        this.bmV = cVar;
        aF(this.bmS, this.bmT);
        if (this.mProgramHandle == -1) {
            throw new RuntimeException("Unable to create program");
        }
        Kf();
    }

    @Override // com.baidu.mario.gldraw2d.c.c
    public void c(com.baidu.mario.gldraw2d.d.a aVar, com.baidu.mario.gldraw2d.params.b bVar) {
        if (this.bmU == null || !this.bmU.Kl()) {
            Log.e(TAG, "onDraw filter has not been setup!!!");
            return;
        }
        Kg();
        a(this.bmU);
        a(aVar, bVar);
        b(aVar, bVar);
        Kh();
        b(this.bmU);
        Ki();
    }

    @Override // com.baidu.mario.gldraw2d.c.c
    public void release() {
        Kj();
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void aF(String str, String str2) {
        if (this.bmU.getType() != 36197) {
            str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
        }
        this.mProgramHandle = com.baidu.mario.gldraw2d.e.a.createProgram(str, str2);
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void Kf() {
        this.bmW = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexture");
        this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void Kg() {
        GLES20.glUseProgram(this.mProgramHandle);
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void a(d dVar) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(dVar.getType(), dVar.getId());
        GLES20.glUniform1i(this.bmW, 0);
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void a(com.baidu.mario.gldraw2d.d.a aVar, com.baidu.mario.gldraw2d.params.b bVar) {
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, bVar.Kt(), 0);
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, bVar.Ku(), 0);
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GLES20.glVertexAttribPointer(this.maPositionLoc, aVar.getCoordsPerVertex(), 5126, false, aVar.getVertexStride(), (Buffer) aVar.getVertexArray());
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, aVar.getCoordsPerVertex(), 5126, false, aVar.getTexCoordStride(), (Buffer) aVar.getTexCoordArray());
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void b(com.baidu.mario.gldraw2d.d.a aVar, com.baidu.mario.gldraw2d.params.b bVar) {
        if (bVar.Kv()) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        if (bVar.Kw()) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
        }
        GLES20.glDrawArrays(5, 0, aVar.getVertexCount());
        if (bVar.Kw()) {
            GLES20.glDisable(3042);
        }
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void Kh() {
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void b(d dVar) {
        GLES20.glBindTexture(dVar.getType(), 0);
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void Ki() {
        GLES20.glUseProgram(0);
    }

    @Override // com.baidu.mario.gldraw2d.c.a
    protected void Kj() {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }
}
