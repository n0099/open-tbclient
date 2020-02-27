package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> csW = new ArrayList<>();
    private FrameLayout csX;
    private boolean csY;

    public d(@NonNull FrameLayout frameLayout) {
        this.csX = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.csX.addView(view, layoutParams);
        return true;
    }

    public boolean au(View view) {
        if (!ax(view)) {
            return false;
        }
        this.csX.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.csX.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.csY;
    }

    public void eJ(boolean z) {
        this.csY = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.csX && this.csX.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.csX.getContext();
    }

    public FrameLayout aqq() {
        return this.csX;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.csW.contains(aVar)) {
                this.csW.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.csW.remove(aVar);
        }
    }

    private synchronized a[] aqr() {
        a[] aVarArr;
        if (this.csW.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.csW.size()];
            this.csW.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aqs() {
        this.csW.clear();
    }

    public void aqt() {
        a[] aqr = aqr();
        if (aqr != null) {
            for (a aVar : aqr) {
                aVar.akM();
            }
        }
    }

    public void aqu() {
        a[] aqr = aqr();
        if (aqr != null) {
            for (a aVar : aqr) {
                aVar.akN();
            }
        }
    }

    public void aqv() {
        a[] aqr = aqr();
        if (aqr != null) {
            for (a aVar : aqr) {
                aVar.onViewDestroy();
            }
        }
        aqs();
    }
}
