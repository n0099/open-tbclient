package com.baidu.ar.arrender;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ar.arplay.core.engine.ARPEngine;
/* loaded from: classes.dex */
public class d extends c implements IGLRenderer {
    public String hb;
    public String hc;

    public d(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, looper, bVar, eGLContext, str);
        this.hb = "";
        this.hc = "";
        this.hb = Build.HARDWARE.toLowerCase();
        this.hc = Build.BOARD.toLowerCase();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void bindTargetSurface(Surface surface) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().bindTargetSurface(surface);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public Texture createTexture(int i, int i2, int i3) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return null;
        }
        Texture texture = new Texture();
        long createTexture = this.hx.getARPRenderer().createTexture(i, i2, i3);
        texture.setHandle(createTexture);
        texture.setId(this.hx.getARPRenderer().getTextureId(createTexture));
        texture.setType(i);
        return texture;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void destroyTexture(Texture texture) {
        ARPEngine aRPEngine;
        if (texture == null || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().destroyTexture(texture.getHandle());
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        super.onRenderFinished(j);
        if (TextUtils.isEmpty(this.hb) || !this.hb.contains("qcom") || TextUtils.isEmpty(this.hc)) {
            return;
        }
        if (this.hc.contains("msm8953") || this.hc.contains("sdm632")) {
            GLES20.glFinish();
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arrender.f
    public void release() {
        super.release();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runSyncOnIOContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setInputTexture(i, i2, i3, i4);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void swapBuffer() {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().swapBuffer();
    }
}
