package com.baidu.swan.games.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d {
    private FrameLayout aiT;
    private boolean emc;
    private ArrayList<a> emb = new ArrayList<>();
    private boolean emd = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.aiT = frameLayout;
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aiT.addView(view, layoutParams);
        return true;
    }

    public boolean removeView(View view) {
        if (!aT(view)) {
            return false;
        }
        this.aiT.removeView(view);
        return true;
    }

    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!aT(view)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        layoutParams.leftMargin = aVar.getLeft();
        layoutParams.topMargin = aVar.getTop();
        this.aiT.updateViewLayout(view, layoutParams);
        return true;
    }

    public boolean isLandScape() {
        return this.emc;
    }

    public void in(boolean z) {
        this.emc = z;
    }

    public boolean aT(View view) {
        return view != null && view.getParent() == this.aiT && this.aiT.indexOfChild(view) >= 0;
    }

    public Context getContext() {
        return this.aiT.getContext();
    }

    public FrameLayout aZl() {
        return this.aiT;
    }

    public boolean aZm() {
        return this.emd;
    }

    public void io(boolean z) {
        this.emd = z;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (!this.emb.contains(aVar)) {
                this.emb.add(aVar);
            }
        }
    }

    public synchronized void b(a aVar) {
        if (aVar != null) {
            this.emb.remove(aVar);
        }
    }

    private synchronized a[] aZn() {
        a[] aVarArr;
        if (this.emb.isEmpty()) {
            aVarArr = null;
        } else {
            aVarArr = new a[this.emb.size()];
            this.emb.toArray(aVarArr);
        }
        return aVarArr;
    }

    private synchronized void aZo() {
        this.emb.clear();
    }

    public void awn() {
        a[] aZn = aZn();
        if (aZn != null) {
            for (a aVar : aZn) {
                aVar.aSV();
            }
        }
    }

    public void awm() {
        a[] aZn = aZn();
        if (aZn != null) {
            for (a aVar : aZn) {
                aVar.aSW();
            }
        }
    }

    public void onPageDestroy() {
        a[] aZn = aZn();
        if (aZn != null) {
            for (a aVar : aZn) {
                aVar.aSX();
            }
        }
        aZo();
    }
}
