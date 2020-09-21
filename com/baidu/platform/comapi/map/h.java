package com.baidu.platform.comapi.map;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements View.OnLayoutChangeListener {
    final /* synthetic */ GLTextureView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GLTextureView gLTextureView) {
        this.a = gLTextureView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a.onSurfaceTextureSizeChanged(this.a.getSurfaceTexture(), i3 - i, i4 - i2);
    }
}
