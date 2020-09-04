package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    private FrameLayout ahv;
    private boolean dya;
    private ArrayList<a> dxZ = new ArrayList<>();
    private boolean dyb = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.ahv = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ahv.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aE(view)) {
            return false;
        }
        this.ahv.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aE(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ahv.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dya;
    }

    public void gP(boolean z) {
        this.dya = z;
    }

    public boolean aE(View view) {
        return view != null && view.getParent() == this.ahv && this.ahv.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ahv.getContext();
    }

    public FrameLayout aQn() {
        return this.ahv;
    }

    public boolean aQo() {
        return this.dyb;
    }

    public void gQ(boolean z) {
        this.dyb = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dxZ.contains(aVar)) {
                this.dxZ.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dxZ.remove(aVar);
        }
    }

    private synchronized a[] aQp() {
        a[] aVarArr;
        if (this.dxZ.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dxZ.size()];
            this.dxZ.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aQq() {
        this.dxZ.clear();
    }

    public void aoa() {
        a[] aQp = aQp();
        if (aQp != null) {
            for (a aVar : aQp) {
                aVar.aJX();
            }
        }
    }

    public void anZ() {
        a[] aQp = aQp();
        if (aQp != null) {
            for (a aVar : aQp) {
                aVar.aJY();
            }
        }
    }

    public void aQr() {
        a[] aQp = aQp();
        if (aQp != null) {
            for (a aVar : aQp) {
                aVar.onViewDestroy();
            }
        }
        aQq();
    }
}
