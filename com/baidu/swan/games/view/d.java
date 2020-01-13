package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d {
    private ArrayList<a> coV = new ArrayList<>();
    private FrameLayout coW;
    private boolean coX;

    public d(@NonNull FrameLayout frameLayout) {
        this.coW = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.coW.addView(view, layoutParams);
        return true;
    }

    public boolean au(View view) {
        if (!ax(view)) {
            return false;
        }
        this.coW.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.coW.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.coX;
    }

    public void eC(boolean z) {
        this.coX = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.coW && this.coW.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.coW.getContext();
    }

    public FrameLayout aoc() {
        return this.coW;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.coV.contains(aVar)) {
                this.coV.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.coV.remove(aVar);
        }
    }

    private synchronized a[] aod() {
        a[] aVarArr;
        if (this.coV.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.coV.size()];
            this.coV.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aoe() {
        this.coV.clear();
    }

    public void aof() {
        a[] aod = aod();
        if (aod != null) {
            for (a aVar : aod) {
                aVar.aiy();
            }
        }
    }

    public void aog() {
        a[] aod = aod();
        if (aod != null) {
            for (a aVar : aod) {
                aVar.aiz();
            }
        }
    }

    public void aoh() {
        a[] aod = aod();
        if (aod != null) {
            for (a aVar : aod) {
                aVar.onViewDestroy();
            }
        }
        aoe();
    }
}
