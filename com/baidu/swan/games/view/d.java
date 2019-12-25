package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d {
    private ArrayList<a> coI = new ArrayList<>();
    private FrameLayout coJ;
    private boolean coK;

    public d(@NonNull FrameLayout frameLayout) {
        this.coJ = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.coJ.addView(view, layoutParams);
        return true;
    }

    public boolean aq(View view) {
        if (!at(view)) {
            return false;
        }
        this.coJ.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!at(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.coJ.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.coK;
    }

    public void ex(boolean z) {
        this.coK = z;
    }

    public boolean at(View view) {
        return view != null && view.getParent() == this.coJ && this.coJ.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.coJ.getContext();
    }

    public FrameLayout anJ() {
        return this.coJ;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.coI.contains(aVar)) {
                this.coI.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.coI.remove(aVar);
        }
    }

    private synchronized a[] anK() {
        a[] aVarArr;
        if (this.coI.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.coI.size()];
            this.coI.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void anL() {
        this.coI.clear();
    }

    public void anM() {
        a[] anK = anK();
        if (anK != null) {
            for (a aVar : anK) {
                aVar.aif();
            }
        }
    }

    public void anN() {
        a[] anK = anK();
        if (anK != null) {
            for (a aVar : anK) {
                aVar.aig();
            }
        }
    }

    public void anO() {
        a[] anK = anK();
        if (anK != null) {
            for (a aVar : anK) {
                aVar.onViewDestroy();
            }
        }
        anL();
    }
}
