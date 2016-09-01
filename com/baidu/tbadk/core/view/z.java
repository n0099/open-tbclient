package com.baidu.tbadk.core.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.MediaController;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextureView.SurfaceTextureListener {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        TextureVideoView.a aVar;
        TextureVideoView.a aVar2;
        this.ahh.mSurfaceTexture = surfaceTexture;
        this.ahh.agR = true;
        z = this.ahh.agS;
        if (z) {
            this.ahh.agS = false;
            this.ahh.ww();
        }
        aVar = this.ahh.agV;
        if (aVar != null) {
            aVar2 = this.ahh.agV;
            aVar2.wB();
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
        bVar = this.ahh.agO;
        if (bVar != null) {
            bVar2 = this.ahh.agO;
            bVar2.onSurfaceDestroyed();
        }
        this.ahh.mSurfaceTexture = null;
        mediaController = this.ahh.agE;
        if (mediaController != null) {
            mediaController2 = this.ahh.agE;
            mediaController2.hide();
        }
        this.ahh.stopPlayback();
        this.ahh.agS = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
