package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> cSj = new ArrayList<>();
    private FrameLayout cSk;
    private boolean cSl;

    public d(@NonNull FrameLayout frameLayout) {
        this.cSk = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.cSk.addView(view, layoutParams);
        return true;
    }

    public boolean av(View view) {
        if (!ay(view)) {
            return false;
        }
        this.cSk.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ay(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.cSk.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.cSl;
    }

    public void fH(boolean z) {
        this.cSl = z;
    }

    public boolean ay(View view) {
        return view != null && view.getParent() == this.cSk && this.cSk.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.cSk.getContext();
    }

    public FrameLayout ayH() {
        return this.cSk;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.cSj.contains(aVar)) {
                this.cSj.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.cSj.remove(aVar);
        }
    }

    private synchronized a[] ayI() {
        a[] aVarArr;
        if (this.cSj.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.cSj.size()];
            this.cSj.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void ayJ() {
        this.cSj.clear();
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
