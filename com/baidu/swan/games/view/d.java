package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> csY = new ArrayList<>();
    private FrameLayout csZ;
    private boolean cta;

    public d(@NonNull FrameLayout frameLayout) {
        this.csZ = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.csZ.addView(view, layoutParams);
        return true;
    }

    public boolean au(View view) {
        if (!ax(view)) {
            return false;
        }
        this.csZ.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.csZ.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.cta;
    }

    public void eJ(boolean z) {
        this.cta = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.csZ && this.csZ.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.csZ.getContext();
    }

    public FrameLayout aqs() {
        return this.csZ;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.csY.contains(aVar)) {
                this.csY.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.csY.remove(aVar);
        }
    }

    private synchronized a[] aqt() {
        a[] aVarArr;
        if (this.csY.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.csY.size()];
            this.csY.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aqu() {
        this.csY.clear();
    }

    public void aqv() {
        a[] aqt = aqt();
        if (aqt != null) {
            for (a aVar : aqt) {
                aVar.akO();
            }
        }
    }

    public void aqw() {
        a[] aqt = aqt();
        if (aqt != null) {
            for (a aVar : aqt) {
                aVar.akP();
            }
        }
    }

    public void aqx() {
        a[] aqt = aqt();
        if (aqt != null) {
            for (a aVar : aqt) {
                aVar.onViewDestroy();
            }
        }
        aqu();
    }
}
