package com.baidu.swan.apps.view.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.b.c.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
/* loaded from: classes2.dex */
public class a<T extends d> implements PullToRefreshBaseWebView.a, com.baidu.swan.apps.core.e.b, com.baidu.swan.apps.view.container.a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private FrameLayout aZD;
    private FrameLayout aZE;
    private PullToRefreshBaseWebView aZF;
    private com.baidu.swan.apps.view.container.a.a aZG = new com.baidu.swan.apps.view.container.a.a();
    private T ara;
    private com.baidu.swan.apps.b.c.c atv;
    private Context mContext;

    public a(Context context, @NonNull com.baidu.swan.apps.b.c.c<T> cVar, @NonNull FrameLayout frameLayout) {
        this.mContext = context;
        this.aZD = frameLayout;
        this.atv = cVar;
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
        view.setTag(b.f.aiapps_na_root_view_tag, bVar2);
        this.aZE.addView(view, c.a(this.ara, bVar));
        return true;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean ai(View view) {
        if (this.aZE == null) {
            return false;
        }
        if (!a(view, this.aZE)) {
            if (DEBUG) {
                Log.d("NAParentViewManager", "removeView failed");
                return false;
            }
            return false;
        }
        try {
            this.aZE.removeView(view);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || this.aZE == null || bVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("NAParentViewManager", "updateView pos: " + bVar);
        }
        if (a(view, this.aZE)) {
            Object tag = view.getTag(b.f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar2 = (b) tag;
                c.a(bVar2, bVar);
                view.setTag(b.f.aiapps_na_root_view_tag, bVar2);
            }
            this.aZE.updateViewLayout(view, c.a(this.ara, bVar));
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public com.baidu.swan.apps.view.container.a.a MJ() {
        return this.aZG;
    }

    private boolean a(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    private boolean g(com.baidu.swan.apps.b.c.c<T> cVar) {
        if (DEBUG) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        cVar.a(this);
        this.ara = cVar.wc();
        if (this.ara == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.mContext);
        this.aZD.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.aZE = new FrameLayout(this.mContext);
        swanAppNARootViewScrollView.addView(this.aZE, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        this.aZF = cVar.vW();
        if (this.aZF != null) {
            this.aZF.setOnPullToRefreshScrollChangeListener(this);
            return true;
        }
        return true;
    }

    public void ey(int i) {
        this.aZE.setVisibility(i);
    }

    @Override // com.baidu.swan.apps.core.e.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aZE.getLayoutParams();
        marginLayoutParams.leftMargin = -i;
        marginLayoutParams.topMargin = -i2;
        this.aZE.setLayoutParams(marginLayoutParams);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.aZE.getChildCount()) {
                View childAt = this.aZE.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(b.f.aiapps_na_root_view_tag);
                    b bVar = null;
                    if (tag instanceof b) {
                        bVar = (b) tag;
                    }
                    if (bVar != null && bVar.isFixed()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.Nc() + i;
                        marginLayoutParams2.topMargin = bVar.Nd() + i2;
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
    public void e(int i, int i2, int i3, int i4) {
        this.aZE.scrollTo(i, i2);
    }

    public void destroy() {
        this.aZG.clear();
        this.atv.b(this);
    }
}
