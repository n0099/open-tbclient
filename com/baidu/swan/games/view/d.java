package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private FrameLayout agu;
    private ArrayList<a> dhW = new ArrayList<>();
    private boolean dhX;

    public d(@NonNull FrameLayout frameLayout) {
        this.agu = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.agu.addView(view, layoutParams);
        return true;
    }

    public boolean av(View view) {
        if (!ax(view)) {
            return false;
        }
        this.agu.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.agu.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dhX;
    }

    public void fX(boolean z) {
        this.dhX = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.agu && this.agu.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.agu.getContext();
    }

    public FrameLayout aDF() {
        return this.agu;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dhW.contains(aVar)) {
                this.dhW.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dhW.remove(aVar);
        }
    }

    private synchronized a[] aDG() {
        a[] aVarArr;
        if (this.dhW.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dhW.size()];
            this.dhW.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aDH() {
        this.dhW.clear();
    }

    public void aDI() {
        a[] aDG = aDG();
        if (aDG != null) {
            for (a aVar : aDG) {
                aVar.axR();
            }
        }
    }

    public void aDJ() {
        a[] aDG = aDG();
        if (aDG != null) {
            for (a aVar : aDG) {
                aVar.axS();
            }
        }
    }

    public void aDK() {
        a[] aDG = aDG();
        if (aDG != null) {
            for (a aVar : aDG) {
                aVar.onViewDestroy();
            }
        }
        aDH();
    }
}
