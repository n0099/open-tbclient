package com.baidu.swan.apps.view.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
/* loaded from: classes2.dex */
public class a<T extends d> implements PullToRefreshBaseWebView.a, com.baidu.swan.apps.core.f.b, com.baidu.swan.apps.view.container.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private T aLD;
    private com.baidu.swan.apps.b.c.c aOi;
    private FrameLayout bwC;
    private FrameLayout bwD;
    private PullToRefreshBaseWebView bwE;
    private com.baidu.swan.apps.view.container.a.a bwF = new com.baidu.swan.apps.view.container.a.a();
    private Context mContext;

    public a(Context context, @NonNull com.baidu.swan.apps.b.c.c<T> cVar, @NonNull FrameLayout frameLayout) {
        this.mContext = context;
        this.bwC = frameLayout;
        this.aOi = cVar;
        g(cVar);
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean a(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (this.mContext == null || bVar == null) {
            if (DEBUG) {
                Log.d("NAParentViewManager", "insertView failed");
            }
            return false;
        }
        b bVar2 = new b();
        c.a(bVar2, bVar);
        view.setTag(a.f.aiapps_na_root_view_tag, bVar2);
        this.bwD.addView(view, c.a(this.aLD, bVar));
        return true;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean at(View view) {
        if (this.bwD == null) {
            return false;
        }
        if (!a(view, this.bwD)) {
            if (DEBUG) {
                Log.d("NAParentViewManager", "removeView failed");
                return false;
            }
            return false;
        }
        try {
            this.bwD.removeView(view);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || this.bwD == null || bVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("NAParentViewManager", "updateView pos: " + bVar);
        }
        if (a(view, this.bwD)) {
            Object tag = view.getTag(a.f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar2 = (b) tag;
                c.a(bVar2, bVar);
                view.setTag(a.f.aiapps_na_root_view_tag, bVar2);
            }
            this.bwD.updateViewLayout(view, c.a(this.aLD, bVar));
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public com.baidu.swan.apps.view.container.a.a Vb() {
        return this.bwF;
    }

    private boolean a(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    private boolean g(com.baidu.swan.apps.b.c.c<T> cVar) {
        if (DEBUG) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        cVar.a(this);
        this.aLD = cVar.Cr();
        if (this.aLD == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.mContext);
        this.bwC.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.bwD = new FrameLayout(this.mContext);
        swanAppNARootViewScrollView.addView(this.bwD, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        this.bwE = cVar.Cl();
        if (this.bwE != null) {
            this.bwE.setOnPullToRefreshScrollChangeListener(this);
            return true;
        }
        return true;
    }

    public void fI(int i) {
        this.bwD.setVisibility(i);
    }

    @Override // com.baidu.swan.apps.core.f.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bwD.getLayoutParams();
        marginLayoutParams.leftMargin = -i;
        marginLayoutParams.topMargin = -i2;
        this.bwD.setLayoutParams(marginLayoutParams);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.bwD.getChildCount()) {
                View childAt = this.bwD.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(a.f.aiapps_na_root_view_tag);
                    b bVar = null;
                    if (tag instanceof b) {
                        bVar = (b) tag;
                    }
                    if (bVar != null && bVar.isFixed()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.Vv() + i;
                        marginLayoutParams2.topMargin = bVar.Vw() + i2;
                        childAt.setLayoutParams(marginLayoutParams2);
                    }
                }
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void h(int i, int i2, int i3, int i4) {
        this.bwD.scrollTo(i, i2);
    }

    public void destroy() {
        this.bwF.clear();
        this.aOi.b(this);
    }
}
