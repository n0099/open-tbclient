package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class b {
    private FrameLayout bfG;
    private boolean bfH;

    public b(@NonNull FrameLayout frameLayout) {
        this.bfG = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || bVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.getTop();
        this.bfG.addView(view, layoutParams);
        return true;
    }

    public boolean ai(View view) {
        if (!an(view)) {
            return false;
        }
        this.bfG.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (!an(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.getTop();
        this.bfG.updateViewLayout(view, layoutParams);
        return true;
    }

    public void cB(boolean z) {
        this.bfH = z;
    }

    public boolean an(View view) {
        return view != null && view.getParent() == this.bfG && this.bfG.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.bfG.getContext();
    }

    public FrameLayout Po() {
        return this.bfG;
    }
}
