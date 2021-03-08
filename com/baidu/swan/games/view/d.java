package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    private FrameLayout akl;
    private boolean enF;
    private ArrayList<a> enE = new ArrayList<>();
    private boolean enG = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.akl = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.akl.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aT(view)) {
            return false;
        }
        this.akl.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aT(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.akl.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.enF;
    }

    public void in(boolean z) {
        this.enF = z;
    }

    public boolean aT(View view) {
        return view != null && view.getParent() == this.akl && this.akl.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.akl.getContext();
    }

    public FrameLayout aZo() {
        return this.akl;
    }

    public boolean aZp() {
        return this.enG;
    }

    public void io(boolean z) {
        this.enG = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.enE.contains(aVar)) {
                this.enE.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.enE.remove(aVar);
        }
    }

    private synchronized a[] aZq() {
        a[] aVarArr;
        if (this.enE.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.enE.size()];
            this.enE.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aZr() {
        this.enE.clear();
    }

    public void awq() {
        a[] aZq = aZq();
        if (aZq != null) {
            for (a aVar : aZq) {
                aVar.aSY();
            }
        }
    }

    public void awp() {
        a[] aZq = aZq();
        if (aZq != null) {
            for (a aVar : aZq) {
                aVar.aSZ();
            }
        }
    }

    public void onPageDestroy() {
        a[] aZq = aZq();
        if (aZq != null) {
            for (a aVar : aZq) {
                aVar.aTa();
            }
        }
        aZr();
    }
}
