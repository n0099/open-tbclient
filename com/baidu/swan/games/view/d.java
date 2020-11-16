package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d {
    private FrameLayout ail;
    private boolean dYJ;
    private ArrayList<a> dYI = new ArrayList<>();
    private boolean dYK = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.ail = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ail.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aM(view)) {
            return false;
        }
        this.ail.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aM(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ail.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dYJ;
    }

    public void hI(boolean z) {
        this.dYJ = z;
    }

    public boolean aM(View view) {
        return view != null && view.getParent() == this.ail && this.ail.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ail.getContext();
    }

    public FrameLayout aXu() {
        return this.ail;
    }

    public boolean aXv() {
        return this.dYK;
    }

    public void hJ(boolean z) {
        this.dYK = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dYI.contains(aVar)) {
                this.dYI.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dYI.remove(aVar);
        }
    }

    private synchronized a[] aXw() {
        a[] aVarArr;
        if (this.dYI.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dYI.size()];
            this.dYI.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aXx() {
        this.dYI.clear();
    }

    public void avj() {
        a[] aXw = aXw();
        if (aXw != null) {
            for (a aVar : aXw) {
                aVar.aRd();
            }
        }
    }

    public void avi() {
        a[] aXw = aXw();
        if (aXw != null) {
            for (a aVar : aXw) {
                aVar.aRe();
            }
        }
    }

    public void aXy() {
        a[] aXw = aXw();
        if (aXw != null) {
            for (a aVar : aXw) {
                aVar.onViewDestroy();
            }
        }
        aXx();
    }
}
