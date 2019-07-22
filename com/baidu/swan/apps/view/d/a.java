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
    private T arO;
    private com.baidu.swan.apps.b.c.c aut;
    private FrameLayout bdh;
    private FrameLayout bdi;
    private PullToRefreshBaseWebView bdj;
    private com.baidu.swan.apps.view.container.a.a bdk = new com.baidu.swan.apps.view.container.a.a();
    private Context mContext;

    public a(Context context, @NonNull com.baidu.swan.apps.b.c.c<T> cVar, @NonNull FrameLayout frameLayout) {
        this.mContext = context;
        this.bdh = frameLayout;
        this.aut = cVar;
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
        this.bdi.addView(view, c.a(this.arO, bVar));
        return true;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean an(View view) {
        if (this.bdi == null) {
            return false;
        }
        if (!a(view, this.bdi)) {
            if (DEBUG) {
                Log.d("NAParentViewManager", "removeView failed");
                return false;
            }
            return false;
        }
        try {
            this.bdi.removeView(view);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        if (view == null || this.bdi == null || bVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("NAParentViewManager", "updateView pos: " + bVar);
        }
        if (a(view, this.bdi)) {
            Object tag = view.getTag(a.f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar2 = (b) tag;
                c.a(bVar2, bVar);
                view.setTag(a.f.aiapps_na_root_view_tag, bVar2);
            }
            this.bdi.updateViewLayout(view, c.a(this.arO, bVar));
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.view.container.a
    public com.baidu.swan.apps.view.container.a.a Qh() {
        return this.bdk;
    }

    private boolean a(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    private boolean g(com.baidu.swan.apps.b.c.c<T> cVar) {
        if (DEBUG) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        cVar.a(this);
        this.arO = cVar.xt();
        if (this.arO == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.mContext);
        this.bdh.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.bdi = new FrameLayout(this.mContext);
        swanAppNARootViewScrollView.addView(this.bdi, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        this.bdj = cVar.xn();
        if (this.bdj != null) {
            this.bdj.setOnPullToRefreshScrollChangeListener(this);
            return true;
        }
        return true;
    }

    public void eM(int i) {
        this.bdi.setVisibility(i);
    }

    @Override // com.baidu.swan.apps.core.f.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bdi.getLayoutParams();
        marginLayoutParams.leftMargin = -i;
        marginLayoutParams.topMargin = -i2;
        this.bdi.setLayoutParams(marginLayoutParams);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.bdi.getChildCount()) {
                View childAt = this.bdi.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(a.f.aiapps_na_root_view_tag);
                    b bVar = null;
                    if (tag instanceof b) {
                        bVar = (b) tag;
                    }
                    if (bVar != null && bVar.isFixed()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.QB() + i;
                        marginLayoutParams2.topMargin = bVar.QC() + i2;
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
    public void d(int i, int i2, int i3, int i4) {
        this.bdi.scrollTo(i, i2);
    }

    public void destroy() {
        this.bdk.clear();
        this.aut.b(this);
    }
}
