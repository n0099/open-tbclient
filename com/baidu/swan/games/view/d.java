package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> ctj = new ArrayList<>();
    private FrameLayout ctk;
    private boolean ctl;

    public d(@NonNull FrameLayout frameLayout) {
        this.ctk = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ctk.addView(view, layoutParams);
        return true;
    }

    public boolean au(View view) {
        if (!ax(view)) {
            return false;
        }
        this.ctk.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ctk.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.ctl;
    }

    public void eK(boolean z) {
        this.ctl = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.ctk && this.ctk.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ctk.getContext();
    }

    public FrameLayout aqv() {
        return this.ctk;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.ctj.contains(aVar)) {
                this.ctj.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.ctj.remove(aVar);
        }
    }

    private synchronized a[] aqw() {
        a[] aVarArr;
        if (this.ctj.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.ctj.size()];
            this.ctj.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aqx() {
        this.ctj.clear();
    }

    public void aqy() {
        a[] aqw = aqw();
        if (aqw != null) {
            for (a aVar : aqw) {
                aVar.akR();
            }
        }
    }

    public void aqz() {
        a[] aqw = aqw();
        if (aqw != null) {
            for (a aVar : aqw) {
                aVar.akS();
            }
        }
    }

    public void aqA() {
        a[] aqw = aqw();
        if (aqw != null) {
            for (a aVar : aqw) {
                aVar.onViewDestroy();
            }
        }
        aqx();
    }
}
