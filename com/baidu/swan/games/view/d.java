package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d {
    private FrameLayout aih;
    private boolean dMc;
    private ArrayList<a> dMb = new ArrayList<>();
    private boolean dMd = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.aih = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aih.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aH(view)) {
            return false;
        }
        this.aih.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aH(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aih.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dMc;
    }

    public void hj(boolean z) {
        this.dMc = z;
    }

    public boolean aH(View view) {
        return view != null && view.getParent() == this.aih && this.aih.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.aih.getContext();
    }

    public FrameLayout aTI() {
        return this.aih;
    }

    public boolean aTJ() {
        return this.dMd;
    }

    public void hk(boolean z) {
        this.dMd = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dMb.contains(aVar)) {
                this.dMb.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dMb.remove(aVar);
        }
    }

    private synchronized a[] aTK() {
        a[] aVarArr;
        if (this.dMb.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dMb.size()];
            this.dMb.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aTL() {
        this.dMb.clear();
    }

    public void arw() {
        a[] aTK = aTK();
        if (aTK != null) {
            for (a aVar : aTK) {
                aVar.aNr();
            }
        }
    }

    public void arv() {
        a[] aTK = aTK();
        if (aTK != null) {
            for (a aVar : aTK) {
                aVar.aNs();
            }
        }
    }

    public void aTM() {
        a[] aTK = aTK();
        if (aTK != null) {
            for (a aVar : aTK) {
                aVar.onViewDestroy();
            }
        }
        aTL();
    }
}
