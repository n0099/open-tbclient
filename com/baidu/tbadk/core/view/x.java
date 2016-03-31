package com.baidu.tbadk.core.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.MediaController;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextureView.SurfaceTextureListener {
    final /* synthetic */ TextureVideoView ahp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TextureVideoView textureVideoView) {
        this.ahp = textureVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        this.ahp.mSurfaceTexture = surfaceTexture;
        this.ahp.ahh = true;
        z = this.ahp.ahi;
        if (z) {
            this.ahp.ahi = false;
            this.ahp.xA();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        TextureVideoView.a aVar;
        MediaController mediaController;
        MediaController mediaController2;
        TextureVideoView.a aVar2;
        aVar = this.ahp.ahe;
        if (aVar != null) {
            aVar2 = this.ahp.ahe;
            aVar2.xF();
        }
        this.ahp.mSurfaceTexture = null;
        mediaController = this.ahp.agU;
        if (mediaController != null) {
            mediaController2 = this.ahp.agU;
            mediaController2.hide();
        }
        this.ahp.aC(true);
        this.ahp.ahi = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
