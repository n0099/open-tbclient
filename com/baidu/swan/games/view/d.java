package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> csX = new ArrayList<>();
    private FrameLayout csY;
    private boolean csZ;

    public d(@NonNull FrameLayout frameLayout) {
        this.csY = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.csY.addView(view, layoutParams);
        return true;
    }

    public boolean au(View view) {
        if (!ax(view)) {
            return false;
        }
        this.csY.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.csY.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.csZ;
    }

    public void eJ(boolean z) {
        this.csZ = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.csY && this.csY.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.csY.getContext();
    }

    public FrameLayout aqs() {
        return this.csY;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.csX.contains(aVar)) {
                this.csX.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.csX.remove(aVar);
        }
    }

    private synchronized a[] aqt() {
        a[] aVarArr;
        if (this.csX.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.csX.size()];
            this.csX.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aqu() {
        this.csX.clear();
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
