package com.baidu.tbadk.core.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.MediaController;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextureView.SurfaceTextureListener {
    final /* synthetic */ TextureVideoView adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextureVideoView textureVideoView) {
        this.adC = textureVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        TextureVideoView.a aVar;
        TextureVideoView.a aVar2;
        this.adC.mSurfaceTexture = surfaceTexture;
        this.adC.adq = true;
        z = this.adC.adr;
        if (z) {
            this.adC.adr = false;
            this.adC.vs();
        }
        aVar = this.adC.adu;
        if (aVar != null) {
            aVar2 = this.adC.adu;
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
        bVar = this.adC.adn;
        if (bVar != null) {
            bVar2 = this.adC.adn;
            bVar2.vx();
        }
        this.adC.mSurfaceTexture = null;
        mediaController = this.adC.adc;
        if (mediaController != null) {
            mediaController2 = this.adC.adc;
            mediaController2.hide();
        }
        this.adC.stopPlayback();
        this.adC.adr = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
