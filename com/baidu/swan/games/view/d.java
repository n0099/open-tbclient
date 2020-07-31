package com.baidu.swan.games.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d {
    private FrameLayout agl;
    private boolean dnS;
    private ArrayList<a> dnR = new ArrayList<>();
    private boolean dnT = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.agl = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.agl.addView(view, layoutParams);
        return true;
    }

    public boolean ay(View view) {
        if (!aC(view)) {
            return false;
        }
        this.agl.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aC(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.agl.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.dnS;
    }

    public void gs(boolean z) {
        this.dnS = z;
    }

    public boolean aC(View view) {
        return view != null && view.getParent() == this.agl && this.agl.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.agl.getContext();
    }

    public FrameLayout aHv() {
        return this.agl;
    }

    public boolean aHw() {
        return this.dnT;
    }

    public void gt(boolean z) {
        this.dnT = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.dnR.contains(aVar)) {
                this.dnR.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.dnR.remove(aVar);
        }
    }

    private synchronized a[] aHx() {
        a[] aVarArr;
        if (this.dnR.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.dnR.size()];
            this.dnR.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aHy() {
        this.dnR.clear();
    }

    public void aHz() {
        a[] aHx = aHx();
        if (aHx != null) {
            for (a aVar : aHx) {
                aVar.aBh();
            }
        }
    }

    public void aHA() {
        a[] aHx = aHx();
        if (aHx != null) {
            for (a aVar : aHx) {
                aVar.aBi();
            }
        }
    }

    public void aHB() {
        a[] aHx = aHx();
        if (aHx != null) {
            for (a aVar : aHx) {
                aVar.onViewDestroy();
            }
        }
        aHy();
    }
}
