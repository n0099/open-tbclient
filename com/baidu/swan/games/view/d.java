package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    private FrameLayout aht;
    private boolean dxW;
    private ArrayList<a> dxV = new ArrayList<>();
    private boolean dxX = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.aht = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aht.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aE(view)) {
            return false;
        }
        this.aht.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aE(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aht.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dxW;
    }

    public void gO(boolean z) {
        this.dxW = z;
    }

    public boolean aE(View view) {
        return view != null && view.getParent() == this.aht && this.aht.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.aht.getContext();
    }

    public FrameLayout aQn() {
        return this.aht;
    }

    public boolean aQo() {
        return this.dxX;
    }

    public void gP(boolean z) {
        this.dxX = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dxV.contains(aVar)) {
                this.dxV.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dxV.remove(aVar);
        }
    }

    private synchronized a[] aQp() {
        a[] aVarArr;
        if (this.dxV.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dxV.size()];
            this.dxV.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aQq() {
        this.dxV.clear();
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
