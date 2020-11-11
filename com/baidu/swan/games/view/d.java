package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d {
    private FrameLayout aii;
    private boolean ear;
    private ArrayList<a> eaq = new ArrayList<>();
    private boolean eas = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.aii = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aii.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aM(view)) {
            return false;
        }
        this.aii.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aM(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aii.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.ear;
    }

    public void hF(boolean z) {
        this.ear = z;
    }

    public boolean aM(View view) {
        return view != null && view.getParent() == this.aii && this.aii.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.aii.getContext();
    }

    public FrameLayout aYc() {
        return this.aii;
    }

    public boolean aYd() {
        return this.eas;
    }

    public void hG(boolean z) {
        this.eas = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.eaq.contains(aVar)) {
                this.eaq.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.eaq.remove(aVar);
        }
    }

    private synchronized a[] aYe() {
        a[] aVarArr;
        if (this.eaq.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.eaq.size()];
            this.eaq.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aYf() {
        this.eaq.clear();
    }

    public void avR() {
        a[] aYe = aYe();
        if (aYe != null) {
            for (a aVar : aYe) {
                aVar.aRL();
            }
        }
    }

    public void avQ() {
        a[] aYe = aYe();
        if (aYe != null) {
            for (a aVar : aYe) {
                aVar.aRM();
            }
        }
    }

    public void aYg() {
        a[] aYe = aYe();
        if (aYe != null) {
            for (a aVar : aYe) {
                aVar.onViewDestroy();
            }
        }
        aYf();
    }
}
