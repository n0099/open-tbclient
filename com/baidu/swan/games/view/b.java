package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class b {
    private FrameLayout bEf;
    private boolean bEg;

    public b(@NonNull FrameLayout frameLayout) {
        this.bEf = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || bVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.Mu();
        this.bEf.addView(view, layoutParams);
        return true;
    }

    public boolean at(View view) {
        if (!ay(view)) {
            return false;
        }
        this.bEf.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (!ay(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.Mu();
        this.bEf.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.bEg;
    }

    public void dm(boolean z) {
        this.bEg = z;
    }

    public boolean ay(View view) {
        return view != null && view.getParent() == this.bEf && this.bEf.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.bEf.getContext();
    }

    public FrameLayout Yr() {
        return this.bEf;
    }
}
