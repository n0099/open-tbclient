package com.baidu.swan.apps.component.container;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
/* loaded from: classes25.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(@NonNull com.baidu.swan.apps.component.b.b bVar) {
        return (bVar instanceof com.baidu.swan.apps.component.components.e.c.b) && TextUtils.equals(((com.baidu.swan.apps.component.components.e.c.b) bVar).cJs, "scroll");
    }

    @Nullable
    static ScrollView b(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        if (!(bVar instanceof com.baidu.swan.apps.component.components.e.c.b)) {
            return null;
        }
        final com.baidu.swan.apps.component.components.e.c.b bVar2 = (com.baidu.swan.apps.component.components.e.c.b) bVar;
        final ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
        scrollView.setFillViewport(true);
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.component.container.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getParent() != null) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
        });
        FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
        frameLayout.addView(swanAppComponentContainerView, generateDefaultLayoutParams());
        scrollView.addView(frameLayout);
        swanAppComponentContainerView.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.component.container.b.2
            @Override // java.lang.Runnable
            public void run() {
                scrollView.smoothScrollTo(0, bVar2.cJr);
            }
        }, 100L);
        swanAppComponentContainerView.setScrollView(scrollView);
        return scrollView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NonNull c cVar, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        boolean z = true;
        com.baidu.swan.apps.console.c.e("Component-Container-Scroll", "insert component（scroll）");
        if (bVar.cIZ == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container-Scroll", "insert component（scroll） with a null position");
            return false;
        } else if (TextUtils.isEmpty(bVar.cIX)) {
            ScrollView b = b(swanAppComponentContainerView, bVar);
            if (b == null || !cVar.cKc.a(b, bVar.cIZ)) {
                z = false;
            }
            return z;
        } else {
            SwanAppComponentContainerView mP = cVar.mP(bVar.cIX);
            if (mP == null) {
                com.baidu.swan.apps.console.c.e("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                return false;
            }
            ScrollView b2 = b(swanAppComponentContainerView, bVar);
            if (b2 == null) {
                com.baidu.swan.apps.console.c.e("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                return false;
            }
            mP.addView(b2, bVar.anw());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(@NonNull c cVar, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        if (DEBUG) {
            Log.d("Component-Container-Scroll", "update component（scroll）position");
        }
        String str = bVar.cIX;
        if (TextUtils.isEmpty(str)) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            ScrollView scrollView2 = swanAppComponentContainerView;
            if (scrollView != null) {
                scrollView2 = swanAppComponentContainerView.getScrollView();
            }
            return cVar.cKc.b(scrollView2, bVar.cIZ);
        }
        SwanAppComponentContainerView mP = cVar.mP(str);
        if (mP == null) {
            com.baidu.swan.apps.console.c.e("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
            return false;
        }
        ScrollView scrollView3 = swanAppComponentContainerView.getScrollView();
        if (scrollView3 != null && scrollView3.getParent() == mP) {
            mP.updateViewLayout(scrollView3, bVar.anw());
            return true;
        }
        com.baidu.swan.apps.component.e.a.bs("Component-Container-Scroll", "update component（scroll）to parent with a illegal parent view (Scroll) " + (scrollView3 == null));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NonNull c cVar, @NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        if (bVar instanceof com.baidu.swan.apps.component.components.e.c.b) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.m32if(7)) {
                if (DEBUG) {
                    Log.d("Component-Container-Scroll", "update component（scroll）overflow_y");
                }
                if (scrollView != null) {
                    if (scrollView.getParent() == null) {
                        return false;
                    }
                    ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                    ((ViewGroup) scrollView.getParent()).removeView(scrollView);
                    swanAppComponentContainerView.setScrollView(null);
                } else {
                    ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                }
                if (cVar.e(aVar)) {
                    return true;
                }
                com.baidu.swan.apps.component.e.a.bs("Component-Container-Scroll", "update component（scroll） overflow_y fail");
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull c cVar, @NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        if (bVar instanceof com.baidu.swan.apps.component.components.e.c.b) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.m32if(8)) {
                if (DEBUG) {
                    Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
                }
                if (scrollView != null) {
                    scrollView.smoothScrollTo(0, ((com.baidu.swan.apps.component.components.e.c.b) bVar).cJr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(@NonNull c cVar, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        if (TextUtils.isEmpty(bVar.cIX)) {
            return cVar.cKc.removeView(swanAppComponentContainerView.getScrollView());
        }
        SwanAppComponentContainerView mP = cVar.mP(bVar.cIX);
        if (mP == null) {
            com.baidu.swan.apps.console.c.e("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
            return false;
        }
        ScrollView scrollView = swanAppComponentContainerView.getScrollView();
        if (scrollView != null && scrollView.getParent() == mP) {
            mP.removeView(scrollView);
            return true;
        }
        com.baidu.swan.apps.component.e.a.bs("Component-Container-Scroll", "remove component（scroll）to parent with a illegal parent view" + (scrollView == null));
        return false;
    }

    private static FrameLayout.LayoutParams generateDefaultLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        return layoutParams;
    }
}
