package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> cSe = new ArrayList<>();
    private FrameLayout cSf;
    private boolean cSg;

    public d(@NonNull FrameLayout frameLayout) {
        this.cSf = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.cSf.addView(view, layoutParams);
        return true;
    }

    public boolean av(View view) {
        if (!ay(view)) {
            return false;
        }
        this.cSf.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ay(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.cSf.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.cSg;
    }

    public void fH(boolean z) {
        this.cSg = z;
    }

    public boolean ay(View view) {
        return view != null && view.getParent() == this.cSf && this.cSf.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.cSf.getContext();
    }

    public FrameLayout ayH() {
        return this.cSf;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.cSe.contains(aVar)) {
                this.cSe.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.cSe.remove(aVar);
        }
    }

    private synchronized a[] ayI() {
        a[] aVarArr;
        if (this.cSe.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.cSe.size()];
            this.cSe.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void ayJ() {
        this.cSe.clear();
    }

    public void ayK() {
        a[] ayI = ayI();
        if (ayI != null) {
            for (a aVar : ayI) {
                aVar.ate();
            }
        }
    }

    public void ayL() {
        a[] ayI = ayI();
        if (ayI != null) {
            for (a aVar : ayI) {
                aVar.atf();
            }
        }
    }

    public void ayM() {
        a[] ayI = ayI();
        if (ayI != null) {
            for (a aVar : ayI) {
                aVar.onViewDestroy();
            }
        }
        ayJ();
    }
}
