package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class d {
    private FrameLayout ajk;
    private boolean efI;
    private ArrayList<a> efH = new ArrayList<>();
    private boolean efJ = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.ajk = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ajk.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aO(view)) {
            return false;
        }
        this.ajk.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aO(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ajk.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.efI;
    }

    public void hX(boolean z) {
        this.efI = z;
    }

    public boolean aO(View view) {
        return view != null && view.getParent() == this.ajk && this.ajk.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ajk.getContext();
    }

    public FrameLayout baz() {
        return this.ajk;
    }

    public boolean baA() {
        return this.efJ;
    }

    public void hY(boolean z) {
        this.efJ = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.efH.contains(aVar)) {
                this.efH.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.efH.remove(aVar);
        }
    }

    private synchronized a[] baB() {
        a[] aVarArr;
        if (this.efH.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.efH.size()];
            this.efH.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void baC() {
        this.efH.clear();
    }

    public void ayr() {
        a[] baB = baB();
        if (baB != null) {
            for (a aVar : baB) {
                aVar.aUi();
            }
        }
    }

    public void ayq() {
        a[] baB = baB();
        if (baB != null) {
            for (a aVar : baB) {
                aVar.aUj();
            }
        }
    }

    public void baD() {
        a[] baB = baB();
        if (baB != null) {
            for (a aVar : baB) {
                aVar.onViewDestroy();
            }
        }
        baC();
    }
}
