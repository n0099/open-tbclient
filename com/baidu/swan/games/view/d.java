package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d {
    private ArrayList<a> ddk = new ArrayList<>();
    private FrameLayout ddl;
    private boolean ddm;

    public d(@NonNull FrameLayout frameLayout) {
        this.ddl = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ddl.addView(view, layoutParams);
        return true;
    }

    public boolean av(View view) {
        if (!ax(view)) {
            return false;
        }
        this.ddl.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!ax(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.ddl.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.ddm;
    }

    public void fS(boolean z) {
        this.ddm = z;
    }

    public boolean ax(View view) {
        return view != null && view.getParent() == this.ddl && this.ddl.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ddl.getContext();
    }

    public FrameLayout aCz() {
        return this.ddl;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.ddk.contains(aVar)) {
                this.ddk.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.ddk.remove(aVar);
        }
    }

    private synchronized a[] aCA() {
        a[] aVarArr;
        if (this.ddk.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.ddk.size()];
            this.ddk.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aCB() {
        this.ddk.clear();
    }

    public void aCC() {
        a[] aCA = aCA();
        if (aCA != null) {
            for (a aVar : aCA) {
                aVar.awL();
            }
        }
    }

    public void aCD() {
        a[] aCA = aCA();
        if (aCA != null) {
            for (a aVar : aCA) {
                aVar.awM();
            }
        }
    }

    public void aCE() {
        a[] aCA = aCA();
        if (aCA != null) {
            for (a aVar : aCA) {
                aVar.onViewDestroy();
            }
        }
        aCB();
    }
}
