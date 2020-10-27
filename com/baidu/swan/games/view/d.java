package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d {
    private FrameLayout aii;
    private boolean dUz;
    private ArrayList<a> dUy = new ArrayList<>();
    private boolean dUA = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.aii = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aii.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aI(view)) {
            return false;
        }
        this.aii.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aI(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aii.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dUz;
    }

    public void hw(boolean z) {
        this.dUz = z;
    }

    public boolean aI(View view) {
        return view != null && view.getParent() == this.aii && this.aii.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.aii.getContext();
    }

    public FrameLayout aVC() {
        return this.aii;
    }

    public boolean aVD() {
        return this.dUA;
    }

    public void hx(boolean z) {
        this.dUA = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dUy.contains(aVar)) {
                this.dUy.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dUy.remove(aVar);
        }
    }

    private synchronized a[] aVE() {
        a[] aVarArr;
        if (this.dUy.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dUy.size()];
            this.dUy.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aVF() {
        this.dUy.clear();
    }

    public void atr() {
        a[] aVE = aVE();
        if (aVE != null) {
            for (a aVar : aVE) {
                aVar.aPl();
            }
        }
    }

    public void atq() {
        a[] aVE = aVE();
        if (aVE != null) {
            for (a aVar : aVE) {
                aVar.aPm();
            }
        }
    }

    public void aVG() {
        a[] aVE = aVE();
        if (aVE != null) {
            for (a aVar : aVE) {
                aVar.onViewDestroy();
            }
        }
        aVF();
    }
}
