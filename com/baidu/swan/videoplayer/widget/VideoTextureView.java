package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
/* loaded from: classes3.dex */
public class VideoTextureView extends TextureView {
    public VideoTextureView(Context context) {
        super(context);
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
