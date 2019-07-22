package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class b {
    private FrameLayout blL;
    private boolean blM;

    public b(@NonNull FrameLayout frameLayout) {
        this.blL = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || bVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.Hv();
        this.blL.addView(view, layoutParams);
        return true;
    }

    public boolean an(View view) {
        if (!as(view)) {
            return false;
        }
        this.blL.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (!as(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.Hv();
        this.blL.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.blM;
    }

    public void cV(boolean z) {
        this.blM = z;
    }

    public boolean as(View view) {
        return view != null && view.getParent() == this.blL && this.blL.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.blL.getContext();
    }

    public FrameLayout Ty() {
        return this.blL;
    }
}
