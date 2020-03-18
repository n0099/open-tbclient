package com.baidu.minivideo.effect.core;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.effect.core.entity.AEffect;
import com.baidu.minivideo.effect.core.entity.AEffectEntity;
import com.baidu.minivideo.effect.core.entity.AEffectParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes13.dex */
public class a {
    private volatile boolean aNJ;
    private c aNK;
    private final FloatBuffer aNM;
    private boolean aNO;
    private Context mContext;
    private int mHeight;
    private float[] mMtx;
    private int mWidth;
    private boolean mDebug = false;
    private int[] aNP = {-1, -1};
    private int[] mFramebuffers = new int[2];
    private final LinkedList<Runnable> aNN = new LinkedList<>();
    private final FloatBuffer aNL = ByteBuffer.allocateDirect(f.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public a() {
        this.aNL.put(f.a).position(0);
        this.aNM = ByteBuffer.allocateDirect(g.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.aNM.put(g.b(Rotation.NORMAL, false, true)).position(0);
    }

    private void Ei() {
        for (int i = 0; i < this.aNP.length; i++) {
            if (this.aNP[i] == -1) {
                log("init fbo i : " + i);
                GLES20.glGenTextures(1, this.aNP, i);
                GLES20.glBindTexture(3553, this.aNP[i]);
                GLES20.glTexParameterf(3553, 10241, 9728.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.mFramebuffers, i);
                GLES20.glBindFramebuffer(36160, this.mFramebuffers[i]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.aNP[i], 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    private void Ej() {
        log("release fbo");
        if (this.aNP != null) {
            GLES20.glDeleteTextures(this.aNP.length, this.aNP, 0);
            for (int i = 0; i < this.aNP.length; i++) {
                this.aNP[i] = -1;
            }
        }
        if (this.mFramebuffers != null) {
            GLES20.glDeleteFramebuffers(this.mFramebuffers.length, this.mFramebuffers, 0);
        }
    }

    private void a(b bVar, Map<String, float[]> map) {
        bVar.q();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, float[]> entry : map.entrySet()) {
            if (bVar instanceof c) {
                for (b bVar2 : ((c) bVar).r()) {
                    bVar2.a(GLES20.glGetUniformLocation(bVar2.n(), entry.getKey()), entry.getValue());
                }
            } else {
                bVar.a(GLES20.glGetUniformLocation(bVar.n(), entry.getKey()), entry.getValue());
            }
        }
    }

    private void a(AEffect aEffect, b bVar) {
        try {
            if (aEffect.vParams != null && aEffect.vParams.size() > 0) {
                for (AEffectParams aEffectParams : aEffect.vParams) {
                    bVar.a(GLES20.glGetUniformLocation(bVar.n(), aEffectParams.name), aEffectParams.name, aEffectParams);
                }
            }
            if (aEffect.fParams != null && aEffect.fParams.size() > 0) {
                for (AEffectParams aEffectParams2 : aEffect.fParams) {
                    bVar.a(GLES20.glGetUniformLocation(bVar.n(), aEffectParams2.name), aEffectParams2.name, aEffectParams2);
                }
            }
            if (aEffect.animated) {
                if (aEffect.totalAnimGroup != null && aEffect.totalAnimGroup.size() > 0) {
                    bVar.a(aEffect.animDuration, aEffect.animRepeatMode, aEffect.totalAnimGroup);
                } else if (aEffect.animGroup != null && aEffect.animGroup.size() == 1) {
                    bVar.a(aEffect.animDuration, aEffect.animRepeatMode, aEffect.animGroup);
                }
            }
        } catch (Exception e) {
            c(e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AEffectEntity aEffectEntity) {
        if (this.aNJ || aEffectEntity == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mMtx != null) {
            d dVar = new d(this.aNO ? "#extension GL_OES_EGL_image_external : require\nprecision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}" : "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}");
            dVar.a();
            dVar.b(this.mMtx);
            arrayList.add(dVar);
        }
        for (AEffect aEffect : aEffectEntity.effectGroup) {
            if ("image".equals(aEffect.name)) {
                if (aEffect.textureParams != null && aEffect.textureParams.size() > 0) {
                    e eVar = new e(TextUtils.isEmpty(aEffect.vertexShader) ? e.b(aEffect.textureParams.size()) : aEffect.X(this.mContext, aEffectEntity.resourcePath), aEffect.W(this.mContext, aEffectEntity.resourcePath));
                    eVar.a();
                    eVar.a(this.mWidth, this.mHeight);
                    eVar.a(aEffect.U(this.mContext, aEffectEntity.resourcePath));
                    eVar.a(aEffect.V(this.mContext, aEffectEntity.resourcePath));
                    a(aEffect, eVar);
                    arrayList.add(eVar);
                }
            } else if (AEffect.AE_SIMPLE.equals(aEffect.name)) {
                b dVar2 = aEffect.animated ? new d(TextUtils.isEmpty(aEffect.vertexShader) ? "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}" : aEffect.X(this.mContext, aEffectEntity.resourcePath), aEffect.W(this.mContext, aEffectEntity.resourcePath)) : new b(TextUtils.isEmpty(aEffect.vertexShader) ? "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}" : aEffect.X(this.mContext, aEffectEntity.resourcePath), aEffect.W(this.mContext, aEffectEntity.resourcePath));
                dVar2.a();
                a(aEffect, dVar2);
                arrayList.add(dVar2);
            }
        }
        if (arrayList.size() > 0) {
            this.aNK = new c(arrayList);
            this.aNK.a();
            this.aNK.a(this.mWidth, this.mHeight);
            for (AEffect aEffect2 : aEffectEntity.effectGroup) {
                a(aEffect2, this.aNK);
            }
        }
        this.aNJ = true;
    }

    private void c(String str, Exception exc) {
        if (this.mDebug) {
            Log.d("AEffectCore", "---> " + str, exc);
        }
    }

    private void log(String str) {
        if (this.mDebug) {
            Log.d("AEffectCore", "---> " + str);
        }
    }

    private void runPendingOnDrawTasks() {
        while (!this.aNN.isEmpty()) {
            this.aNN.removeFirst().run();
        }
    }

    public int a(int i, float[] fArr, int i2, int i3, int i4, Map<String, float[]> map) {
        if (i3 != 0 && i4 != 0) {
            if (i3 != this.mWidth || i4 != this.mHeight) {
                this.mWidth = i3;
                this.mHeight = i4;
                log(" w * h : " + i3 + " * " + i4);
                release();
            }
            this.aNO = (i2 & 1) == 1;
            this.mMtx = fArr;
            try {
                runPendingOnDrawTasks();
                if (this.aNK != null) {
                    Ei();
                    if (this.aNK.o()) {
                        GLES20.glBindFramebuffer(36160, this.mFramebuffers[1]);
                        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        GLES20.glEnable(3042);
                        GLES20.glBlendFunc(1, 771);
                        this.aNK.a(0);
                        a(this.aNK, map);
                        this.aNK.b(this.aNP[0], this.aNL, this.aNM);
                        this.aNK.a(1);
                        a(this.aNK, map);
                        this.aNK.b(i, this.aNL, this.aNM);
                        GLES20.glDisable(3042);
                        GLES20.glBindFramebuffer(36160, 0);
                        i = this.aNP[1];
                    } else {
                        GLES20.glBindFramebuffer(36160, this.mFramebuffers[0]);
                        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        this.aNK.p();
                        this.aNK.b(i, this.aNL, this.aNM);
                        GLES20.glBindFramebuffer(36160, 0);
                        for (b bVar : this.aNK.r()) {
                            a(bVar, map);
                        }
                        i = this.aNK.a(i, this.aNL, this.aNM);
                    }
                    if (this.mMtx != null) {
                        Matrix.setIdentityM(fArr, 0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                c(e.toString(), e);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
        return i;
    }

    public void b(final AEffectEntity aEffectEntity) {
        this.aNN.add(new Runnable() { // from class: com.baidu.minivideo.effect.core.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aNJ) {
                    a.this.release();
                }
                a.this.c(aEffectEntity);
            }
        });
    }

    public void initialize(Context context) {
        this.mContext = context;
    }

    public void release() {
        try {
            if (this.aNJ) {
                if (this.aNK != null) {
                    Ej();
                    this.aNK.e();
                    this.aNK = null;
                }
                this.aNJ = false;
            }
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

    public void startRecordAnim(final int i, final long j) {
        this.aNN.add(new Runnable() { // from class: com.baidu.minivideo.effect.core.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aNK != null) {
                    a.this.aNK.a(i, System.currentTimeMillis() - (j > 0 ? j : 0L));
                }
            }
        });
    }
}
