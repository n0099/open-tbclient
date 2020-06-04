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
    private T bHi;
    private FrameLayout cNk;
    private FrameLayout cNl;
    private PullToRefreshBaseWebView cNm;
    private com.baidu.swan.apps.adaptation.b.c caK;
    private Context mContext;

    public a(Context context, @NonNull com.baidu.swan.apps.adaptation.b.c<T> cVar, @NonNull FrameLayout frameLayout) {
        this.mContext = context;
        this.cNk = frameLayout;
        this.caK = cVar;
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
        if (this.cNl.indexOfChild(view) >= 0) {
            com.baidu.swan.apps.component.e.a.aS("NAParentViewManager", "repeat insert view!");
            this.cNl.removeView(view);
        }
        this.cNl.addView(view, c.a(this.bHi, aVar));
        return true;
    }

    @Override // com.baidu.swan.apps.view.b.a
    public boolean av(View view) {
        if (a(view, this.cNl)) {
            try {
                this.cNl.removeView(view);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return true;
        } else if (aw(view)) {
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
        if (view == null || this.cNl == null || aVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("NAParentViewManager", "updateView pos: " + aVar);
        }
        if (a(view, this.cNl)) {
            Object tag = view.getTag(a.f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar = (b) tag;
                c.a(bVar, aVar);
                view.setTag(a.f.aiapps_na_root_view_tag, bVar);
            }
            this.cNl.updateViewLayout(view, c.a(this.bHi, aVar));
            return true;
        } else if (aw(view)) {
            Object tag2 = view.getTag(a.f.aiapps_na_root_view_tag);
            if (tag2 instanceof b) {
                b bVar2 = (b) tag2;
                c.a(bVar2, aVar);
                view.setTag(a.f.aiapps_na_root_view_tag, bVar2);
            }
            ((ViewGroup) view.getParent()).updateViewLayout(view, c.a(this.bHi, aVar));
            return true;
        } else {
            return false;
        }
    }

    private boolean a(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    private boolean aw(View view) {
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
        this.bHi = cVar.Th();
        if (this.bHi == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.mContext);
        this.cNk.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.cNl = new FrameLayout(this.mContext);
        swanAppNARootViewScrollView.addView(this.cNl, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        this.cNm = cVar.Ta();
        if (this.cNm != null) {
            this.cNm.setOnPullToRefreshScrollChangeListener(this);
            return true;
        }
        return true;
    }

    public void hR(int i) {
        this.cNl.setVisibility(i);
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cNl.getLayoutParams();
        marginLayoutParams.leftMargin = -i;
        marginLayoutParams.topMargin = -i2;
        this.cNl.setLayoutParams(marginLayoutParams);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < this.cNl.getChildCount()) {
                View childAt = this.cNl.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(a.f.aiapps_na_root_view_tag);
                    b bVar = null;
                    if (tag instanceof b) {
                        bVar = (b) tag;
                    }
                    if (bVar != null && bVar.isFixed()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.auF() + i;
                        marginLayoutParams2.topMargin = bVar.auG() + i2;
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
    public void i(int i, int i2, int i3, int i4) {
        this.cNl.scrollTo(i, i2);
    }

    public void destroy() {
        this.caK.b(this);
    }
}
