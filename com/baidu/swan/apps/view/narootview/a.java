package com.baidu.swan.apps.view.narootview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
/* loaded from: classes11.dex */
public class a<T extends d> implements PullToRefreshBaseWebView.a, com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.view.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private T bbl;
    private com.baidu.swan.apps.adaptation.b.c bsN;
    private FrameLayout cba;
    private FrameLayout cbb;
    private PullToRefreshBaseWebView cbc;
    private Context mContext;

    public a(Context context, @NonNull com.baidu.swan.apps.adaptation.b.c<T> cVar, @NonNull FrameLayout frameLayout) {
        this.mContext = context;
        this.cba = frameLayout;
        this.bsN = cVar;
        g(cVar);
    }

    @Override // com.baidu.swan.apps.view.b.a
    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (this.mContext == null || aVar == null) {
            if (DEBUG) {
                Log.d("NAParentViewManager", "insertView failed");
            }
            return false;
        }
        b bVar = new b();
        c.a(bVar, aVar);
        view.setTag(a.f.aiapps_na_root_view_tag, bVar);
        if (this.cbb.indexOfChild(view) >= 0) {
            com.baidu.swan.apps.component.e.a.at("NAParentViewManager", "repeat insert view!");
            this.cbb.removeView(view);
        }
        this.cbb.addView(view, c.a(this.bbl, aVar));
        return true;
    }

    @Override // com.baidu.swan.apps.view.b.a
    public boolean au(View view) {
        if (a(view, this.cbb)) {
            try {
                this.cbb.removeView(view);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return true;
        } else if (av(view)) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.swan.apps.view.b.a
    public boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || this.cbb == null || aVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("NAParentViewManager", "updateView pos: " + aVar);
        }
        if (a(view, this.cbb)) {
            Object tag = view.getTag(a.f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar = (b) tag;
                c.a(bVar, aVar);
                view.setTag(a.f.aiapps_na_root_view_tag, bVar);
            }
            this.cbb.updateViewLayout(view, c.a(this.bbl, aVar));
            return true;
        } else if (av(view)) {
            Object tag2 = view.getTag(a.f.aiapps_na_root_view_tag);
            if (tag2 instanceof b) {
                b bVar2 = (b) tag2;
                c.a(bVar2, aVar);
                view.setTag(a.f.aiapps_na_root_view_tag, bVar2);
            }
            ((ViewGroup) view.getParent()).updateViewLayout(view, c.a(this.bbl, aVar));
            return true;
        } else {
            return false;
        }
    }

    private boolean a(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    private boolean av(View view) {
        if (view == null) {
            return false;
        }
        return view.getParent() instanceof SwanAppInlineFullScreenContainer;
    }

    private boolean g(com.baidu.swan.apps.adaptation.b.c<T> cVar) {
        if (DEBUG) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        cVar.a(this);
        this.bbl = cVar.IS();
        if (this.bbl == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.mContext);
        this.cba.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.cbb = new FrameLayout(this.mContext);
        swanAppNARootViewScrollView.addView(this.cbb, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        this.cbc = cVar.IL();
        if (this.cbc != null) {
            this.cbc.setOnPullToRefreshScrollChangeListener(this);
            return true;
        }
        return true;
    }

    public void hl(int i) {
        this.cbb.setVisibility(i);
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cbb.getLayoutParams();
        marginLayoutParams.leftMargin = -i;
        marginLayoutParams.topMargin = -i2;
        this.cbb.setLayoutParams(marginLayoutParams);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.cbb.getChildCount()) {
                View childAt = this.cbb.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(a.f.aiapps_na_root_view_tag);
                    b bVar = null;
                    if (tag instanceof b) {
                        bVar = (b) tag;
                    }
                    if (bVar != null && bVar.isFixed()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.ahQ() + i;
                        marginLayoutParams2.topMargin = bVar.ahR() + i2;
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
    public void j(int i, int i2, int i3, int i4) {
        this.cbb.scrollTo(i, i2);
    }

    public void destroy() {
        this.bsN.b(this);
    }
}
