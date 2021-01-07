package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d {
    private FrameLayout ajW;
    private boolean eoK;
    private ArrayList<a> eoJ = new ArrayList<>();
    private boolean eoL = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.ajW = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.aGa();
        this.ajW.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aX(view)) {
            return false;
        }
        this.ajW.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aX(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.aGa();
        this.ajW.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.eoK;
    }

    public void ip(boolean z) {
        this.eoK = z;
    }

    public boolean aX(View view) {
        return view != null && view.getParent() == this.ajW && this.ajW.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ajW.getContext();
    }

    public FrameLayout bcT() {
        return this.ajW;
    }

    public boolean bcU() {
        return this.eoL;
    }

    public void iq(boolean z) {
        this.eoL = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.eoJ.contains(aVar)) {
                this.eoJ.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.eoJ.remove(aVar);
        }
    }

    private synchronized a[] bcV() {
        a[] aVarArr;
        if (this.eoJ.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.eoJ.size()];
            this.eoJ.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void bcW() {
        this.eoJ.clear();
    }

    public void azJ() {
        a[] bcV = bcV();
        if (bcV != null) {
            for (a aVar : bcV) {
                aVar.aWD();
            }
        }
    }

    public void azI() {
        a[] bcV = bcV();
        if (bcV != null) {
            for (a aVar : bcV) {
                aVar.aWE();
            }
        }
    }

    public void onPageDestroy() {
        a[] bcV = bcV();
        if (bcV != null) {
            for (a aVar : bcV) {
                aVar.aWF();
            }
        }
        bcW();
    }
}
