package com.baidu.tbadk.core.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.MediaController;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextureView.SurfaceTextureListener {
    final /* synthetic */ TextureVideoView ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextureVideoView textureVideoView) {
        this.ade = textureVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        TextureVideoView.a aVar;
        TextureVideoView.a aVar2;
        this.ade.mSurfaceTexture = surfaceTexture;
        this.ade.acU = true;
        z = this.ade.acV;
        if (z) {
            this.ade.acV = false;
            this.ade.vq();
        }
        aVar = this.ade.acW;
        if (aVar != null) {
            aVar2 = this.ade.acW;
            aVar2.vu();
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
        bVar = this.ade.acR;
        if (bVar != null) {
            bVar2 = this.ade.acR;
            bVar2.vv();
        }
        this.ade.mSurfaceTexture = null;
        mediaController = this.ade.acH;
        if (mediaController != null) {
            mediaController2 = this.ade.acH;
            mediaController2.hide();
        }
        this.ade.aH(true);
        this.ade.acV = false;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
