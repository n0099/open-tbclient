package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    private FrameLayout ajf;
    private boolean ejV;
    private ArrayList<a> ejU = new ArrayList<>();
    private boolean ejW = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.ajf = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.aCg();
        this.ajf.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aX(view)) {
            return false;
        }
        this.ajf.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aX(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.aCg();
        this.ajf.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.ejV;
    }

    public void il(boolean z) {
        this.ejV = z;
    }

    public boolean aX(View view) {
        return view != null && view.getParent() == this.ajf && this.ajf.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.ajf.getContext();
    }

    public FrameLayout aYZ() {
        return this.ajf;
    }

    public boolean aZa() {
        return this.ejW;
    }

    public void im(boolean z) {
        this.ejW = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.ejU.contains(aVar)) {
                this.ejU.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.ejU.remove(aVar);
        }
    }

    private synchronized a[] aZb() {
        a[] aVarArr;
        if (this.ejU.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.ejU.size()];
            this.ejU.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aZc() {
        this.ejU.clear();
    }

    public void avP() {
        a[] aZb = aZb();
        if (aZb != null) {
            for (a aVar : aZb) {
                aVar.aSJ();
            }
        }
    }

    public void avO() {
        a[] aZb = aZb();
        if (aZb != null) {
            for (a aVar : aZb) {
                aVar.aSK();
            }
        }
    }

    public void onPageDestroy() {
        a[] aZb = aZb();
        if (aZb != null) {
            for (a aVar : aZb) {
                aVar.aSL();
            }
        }
        aZc();
    }
}
