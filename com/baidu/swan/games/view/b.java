package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class b {
    private FrameLayout bEW;
    private boolean bEX;

    public b(@NonNull FrameLayout frameLayout) {
        this.bEW = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || bVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.Mt();
        this.bEW.addView(view, layoutParams);
        return true;
    }

    public boolean at(View view) {
        if (!ay(view)) {
            return false;
        }
        this.bEW.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (!ay(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.Mt();
        this.bEW.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.bEX;
    }

    public void dm(boolean z) {
        this.bEX = z;
    }

    public boolean ay(View view) {
        return view != null && view.getParent() == this.bEW && this.bEW.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.bEW.getContext();
    }

    public FrameLayout Yt() {
        return this.bEW;
    }
}
