package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private FrameLayout ahP;
    private boolean dAb;
    private ArrayList<a> dAa = new ArrayList<>();
    private boolean dAc = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.ahP = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ahP.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aG(view)) {
            return false;
        }
        this.ahP.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aG(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ahP.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dAb;
    }

    public void gN(boolean z) {
        this.dAb = z;
    }

    public boolean aG(View view) {
        return view != null && view.getParent() == this.ahP && this.ahP.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ahP.getContext();
    }

    public FrameLayout aQZ() {
        return this.ahP;
    }

    public boolean aRa() {
        return this.dAc;
    }

    public void gO(boolean z) {
        this.dAc = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dAa.contains(aVar)) {
                this.dAa.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dAa.remove(aVar);
        }
    }

    private synchronized a[] aRb() {
        a[] aVarArr;
        if (this.dAa.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dAa.size()];
            this.dAa.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aRc() {
        this.dAa.clear();
    }

    public void aoK() {
        a[] aRb = aRb();
        if (aRb != null) {
            for (a aVar : aRb) {
                aVar.aKI();
            }
        }
    }

    public void aoJ() {
        a[] aRb = aRb();
        if (aRb != null) {
            for (a aVar : aRb) {
                aVar.aKJ();
            }
        }
    }

    public void aRd() {
        a[] aRb = aRb();
        if (aRb != null) {
            for (a aVar : aRb) {
                aVar.onViewDestroy();
            }
        }
        aRc();
    }
}
