package com.baidu.searchbox.player.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(api = 21)
/* loaded from: classes4.dex */
public class RoundOutlineProvider extends ViewOutlineProvider {
    public float mRadius;

    public RoundOutlineProvider() {
    }

    public RoundOutlineProvider(float f) {
        this.mRadius = f;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view2, Outline outline) {
        outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), this.mRadius);
        view2.setClipToOutline(true);
    }
}
