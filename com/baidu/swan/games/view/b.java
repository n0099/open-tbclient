package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class b {
    private FrameLayout bkY;
    private boolean bkZ;

    public b(@NonNull FrameLayout frameLayout) {
        this.bkY = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || bVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.getTop();
        this.bkY.addView(view, layoutParams);
        return true;
    }

    public boolean al(View view) {
        if (!aq(view)) {
            return false;
        }
        this.bkY.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (!aq(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        layoutParams.leftMargin = bVar.getLeft();
        layoutParams.topMargin = bVar.getTop();
        this.bkY.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.bkZ;
    }

    public void cS(boolean z) {
        this.bkZ = z;
    }

    public boolean aq(View view) {
        return view != null && view.getParent() == this.bkY && this.bkY.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.bkY.getContext();
    }

    public FrameLayout SF() {
        return this.bkY;
    }
}
