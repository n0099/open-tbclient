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
/* loaded from: classes12.dex */
public class a {
    private volatile boolean aJo;
    private c aJp;
    private final FloatBuffer aJr;
    private boolean aJt;
    private Context mContext;
    private int mHeight;
    private float[] mMtx;
    private int mWidth;
    private boolean mDebug = false;
    private int[] aJu = {-1, -1};
    private int[] mFramebuffers = new int[2];
    private final LinkedList<Runnable> aJs = new LinkedList<>();
    private final FloatBuffer aJq = ByteBuffer.allocateDirect(f.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public a() {
        this.aJq.put(f.a).position(0);
        this.aJr = ByteBuffer.allocateDirect(g.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.aJr.put(g.b(Rotation.NORMAL, false, true)).position(0);
    }

    private void BJ() {
        for (int i = 0; i < this.aJu.length; i++) {
            if (this.aJu[i] == -1) {
                log("init fbo i : " + i);
                GLES20.glGenTextures(1, this.aJu, i);
                GLES20.glBindTexture(3553, this.aJu[i]);
                GLES20.glTexParameterf(3553, 10241, 9728.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.mFramebuffers, i);
                GLES20.glBindFramebuffer(36160, this.mFramebuffers[i]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.aJu[i], 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    private void BK() {
        log("release fbo");
        if (this.aJu != null) {
            GLES20.glDeleteTextures(this.aJu.length, this.aJu, 0);
            for (int i = 0; i < this.aJu.length; i++) {
                this.aJu[i] = -1;
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
        if (this.aJo || aEffectEntity == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mMtx != null) {
            d dVar = new d(this.aJt ? "#extension GL_OES_EGL_image_external : require\nprecision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}" : "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}");
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
            this.aJp = new c(arrayList);
            this.aJp.a();
            this.aJp.a(this.mWidth, this.mHeight);
            for (AEffect aEffect2 : aEffectEntity.effectGroup) {
                a(aEffect2, this.aJp);
            }
        }
        this.aJo = true;
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
        while (!this.aJs.isEmpty()) {
            this.aJs.removeFirst().run();
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
            this.aJt = (i2 & 1) == 1;
            this.mMtx = fArr;
            try {
                runPendingOnDrawTasks();
                if (this.aJp != null) {
                    BJ();
                    if (this.aJp.o()) {
                        GLES20.glBindFramebuffer(36160, this.mFramebuffers[1]);
                        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        GLES20.glEnable(3042);
                        GLES20.glBlendFunc(1, 771);
                        this.aJp.a(0);
                        a(this.aJp, map);
                        this.aJp.b(this.aJu[0], this.aJq, this.aJr);
                        this.aJp.a(1);
                        a(this.aJp, map);
                        this.aJp.b(i, this.aJq, this.aJr);
                        GLES20.glDisable(3042);
                        GLES20.glBindFramebuffer(36160, 0);
                        i = this.aJu[1];
                    } else {
                        GLES20.glBindFramebuffer(36160, this.mFramebuffers[0]);
                        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        this.aJp.p();
                        this.aJp.b(i, this.aJq, this.aJr);
                        GLES20.glBindFramebuffer(36160, 0);
                        for (b bVar : this.aJp.r()) {
                            a(bVar, map);
                        }
                        i = this.aJp.a(i, this.aJq, this.aJr);
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
        this.aJs.add(new Runnable() { // from class: com.baidu.minivideo.effect.core.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aJo) {
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
            if (this.aJo) {
                if (this.aJp != null) {
                    BK();
                    this.aJp.e();
                    this.aJp = null;
                }
                this.aJo = false;
            }
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

    public void startRecordAnim(final int i, final long j) {
        this.aJs.add(new Runnable() { // from class: com.baidu.minivideo.effect.core.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aJp != null) {
                    a.this.aJp.a(i, System.currentTimeMillis() - (j > 0 ? j : 0L));
                }
            }
        });
    }
}
