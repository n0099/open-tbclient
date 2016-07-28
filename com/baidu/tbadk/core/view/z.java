package com.baidu.tbadk.core.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.MediaController;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextureView.SurfaceTextureListener {
    final /* synthetic */ TextureVideoView aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextureVideoView textureVideoView) {
        this.aeo = textureVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        TextureVideoView.a aVar;
        TextureVideoView.a aVar2;
        this.aeo.mSurfaceTexture = surfaceTexture;
        this.aeo.aea = true;
        z = this.aeo.aeb;
        if (z) {
            this.aeo.aeb = false;
            this.aeo.vs();
        }
        aVar = this.aeo.aee;
        if (aVar != null) {
            aVar2 = this.aeo.aee;
            aVar2.vw();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        TextureVideoView.b bVar;
        MediaController mediaController;
        MediaController mediaController2;
        TextureVideoView.b bVar2;
        bVar = this.aeo.adX;
        if (bVar != null) {
            bVar2 = this.aeo.adX;
            bVar2.vx();
        }
        this.aeo.mSurfaceTexture = null;
        mediaController = this.aeo.adN;
        if (mediaController != null) {
            mediaController2 = this.aeo.adN;
            mediaController2.hide();
        }
        this.aeo.stopPlayback();
        this.aeo.aeb = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
