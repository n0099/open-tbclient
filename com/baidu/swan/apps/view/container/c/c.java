package com.baidu.swan.apps.view.container.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class c {
    private static String TAG = "NAViewUtils";

    public static boolean a(SwanAppNAViewContainer swanAppNAViewContainer, @NonNull com.baidu.swan.apps.view.container.a aVar) {
        if (swanAppNAViewContainer == null || swanAppNAViewContainer.getModel() == null) {
            com.baidu.swan.apps.console.c.e(TAG, "view is null or it's model is null");
            return false;
        }
        com.baidu.swan.apps.model.a.a.a model = swanAppNAViewContainer.getModel();
        if (TextUtils.isEmpty(model.aXI)) {
            if (model.aXJ == null) {
                model.aXJ = new com.baidu.swan.apps.model.a.a.b();
            }
            if (c(model)) {
                return aVar.a(b(swanAppNAViewContainer), model.aXJ);
            }
            return aVar.a(swanAppNAViewContainer, model.aXJ);
        }
        return c(swanAppNAViewContainer);
    }

    private static ScrollView b(SwanAppNAViewContainer swanAppNAViewContainer) {
        final com.baidu.swan.apps.model.a.a.a model = swanAppNAViewContainer.getModel();
        final ScrollView scrollView = new ScrollView(swanAppNAViewContainer.getContext());
        scrollView.setFillViewport(true);
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.view.container.c.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getParent() != null) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
        });
        FrameLayout frameLayout = new FrameLayout(swanAppNAViewContainer.getContext());
        frameLayout.addView(swanAppNAViewContainer, generateDefaultLayoutParams());
        scrollView.addView(frameLayout);
        swanAppNAViewContainer.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.view.container.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                scrollView.smoothScrollTo(0, model.aXD);
            }
        }, 100L);
        swanAppNAViewContainer.setScrollView(scrollView);
        return scrollView;
    }

    private static FrameLayout.LayoutParams generateDefaultLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        return layoutParams;
    }

    private static boolean c(SwanAppNAViewContainer swanAppNAViewContainer) {
        if (swanAppNAViewContainer == null) {
            com.baidu.swan.apps.console.c.e(TAG, "attach view is null");
            return false;
        }
        String parentId = swanAppNAViewContainer.getParentId();
        if (TextUtils.isEmpty(parentId)) {
            com.baidu.swan.apps.console.c.e(TAG, "parent view id is empty");
            return false;
        }
        com.baidu.swan.apps.model.a.a.a model = swanAppNAViewContainer.getModel();
        if (model == null || model.aXJ == null || !model.aXJ.isValid()) {
            com.baidu.swan.apps.console.c.e(TAG, "model is null or position is error");
            return false;
        }
        SwanAppNAViewContainer a = b.a(swanAppNAViewContainer.getSlaveId(), parentId, null);
        if (a == null) {
            com.baidu.swan.apps.console.c.e(TAG, "parent view is null");
            return false;
        }
        if (c(model)) {
            a.addView(b(swanAppNAViewContainer), model.Mr());
        } else {
            a.addView(swanAppNAViewContainer, model.Mr());
        }
        return true;
    }

    private static boolean c(com.baidu.swan.apps.model.a.a.a aVar) {
        return aVar != null && TextUtils.equals(aVar.aXE, "scroll") && TextUtils.equals(aVar.aXG, "coverView");
    }

    public static boolean b(SwanAppNAViewContainer swanAppNAViewContainer, @NonNull com.baidu.swan.apps.view.container.a aVar) {
        if (swanAppNAViewContainer == null || swanAppNAViewContainer.getModel() == null) {
            com.baidu.swan.apps.console.c.e(TAG, "view is null or it's model is null");
            return false;
        }
        com.baidu.swan.apps.model.a.a.a model = swanAppNAViewContainer.getModel();
        if (TextUtils.isEmpty(model.aXI)) {
            if (c(model)) {
                return aVar.at(swanAppNAViewContainer.getScrollView());
            }
            return aVar.at(swanAppNAViewContainer);
        }
        return d(swanAppNAViewContainer);
    }

    private static boolean d(SwanAppNAViewContainer swanAppNAViewContainer) {
        if (swanAppNAViewContainer == null || swanAppNAViewContainer.getModel() == null) {
            com.baidu.swan.apps.console.c.e(TAG, "view is null or it's model is null");
            return false;
        }
        com.baidu.swan.apps.model.a.a.a model = swanAppNAViewContainer.getModel();
        String parentId = swanAppNAViewContainer.getParentId();
        if (TextUtils.isEmpty(parentId)) {
            com.baidu.swan.apps.console.c.e(TAG, "parent view id is empty");
            return false;
        }
        SwanAppNAViewContainer a = b.a(swanAppNAViewContainer.getSlaveId(), parentId, null);
        if (a != null) {
            if (c(model)) {
                ScrollView scrollView = swanAppNAViewContainer.getScrollView();
                if (scrollView != null && scrollView.getParent() == a) {
                    a.removeView(scrollView);
                }
            } else if (a == swanAppNAViewContainer.getParent()) {
                a.removeView(swanAppNAViewContainer);
            }
            return true;
        }
        return false;
    }

    public static boolean a(SwanAppNAViewContainer swanAppNAViewContainer, com.baidu.swan.apps.model.a.a.a aVar) {
        if (swanAppNAViewContainer == null) {
            com.baidu.swan.apps.console.c.e(TAG, "view is null");
            return false;
        } else if (aVar == null || aVar.aXJ == null || !aVar.aXJ.isValid()) {
            com.baidu.swan.apps.console.c.e(TAG, "update model has error");
            return false;
        } else {
            com.baidu.swan.apps.model.a.a.a model = swanAppNAViewContainer.getModel();
            if (model == null || model.aXJ == null || !model.aXJ.isValid()) {
                com.baidu.swan.apps.console.c.e(TAG, "current model has error");
                return false;
            }
            if ((a(model, aVar).Vl() & 1) == 1) {
                a(swanAppNAViewContainer, aVar, model);
            }
            swanAppNAViewContainer.b(aVar);
            return true;
        }
    }

    private static void a(@NonNull SwanAppNAViewContainer swanAppNAViewContainer, com.baidu.swan.apps.model.a.a.a aVar, com.baidu.swan.apps.model.a.a.a aVar2) {
        String parentId = swanAppNAViewContainer.getParentId();
        if (TextUtils.isEmpty(parentId)) {
            com.baidu.swan.apps.view.container.a ji = ji(aVar.aXH);
            if (ji == null) {
                com.baidu.swan.apps.console.c.e(TAG, "root view is null");
                return;
            }
            ji.b(swanAppNAViewContainer, aVar.aXJ);
        } else {
            SwanAppNAViewContainer a = b.a(aVar.aXH, parentId, null);
            if (a == null) {
                com.baidu.swan.apps.console.c.e(TAG, "parent view is null");
                return;
            } else if (c(aVar)) {
                ScrollView scrollView = swanAppNAViewContainer.getScrollView();
                if (scrollView != null && scrollView.getParent() == a) {
                    a.updateViewLayout(swanAppNAViewContainer.getScrollView(), aVar.Mr());
                }
            } else if (a == swanAppNAViewContainer.getParent()) {
                a.updateViewLayout(swanAppNAViewContainer, aVar.Mr());
            }
        }
        if (aVar2 != null) {
            aVar2.a(aVar.aXJ);
        }
    }

    @NonNull
    public static a a(com.baidu.swan.apps.model.a.a.a aVar, com.baidu.swan.apps.model.a.a.a aVar2) {
        a aVar3 = new a();
        if (aVar != aVar2) {
            if (aVar != null && aVar2 != null) {
                aVar.a(aVar2, aVar3);
            } else {
                aVar3.fH(63);
            }
        }
        return aVar3;
    }

    public static void c(SwanAppNAViewContainer swanAppNAViewContainer, @Nullable com.baidu.swan.apps.view.container.a aVar) {
        com.baidu.swan.apps.view.container.a.a Vb;
        if (aVar == null) {
            aVar = ji(swanAppNAViewContainer.getSlaveId());
        }
        if (aVar != null && (Vb = aVar.Vb()) != null) {
            Vb.av(swanAppNAViewContainer);
        }
    }

    public static void d(SwanAppNAViewContainer swanAppNAViewContainer, com.baidu.swan.apps.view.container.a aVar) {
        com.baidu.swan.apps.view.container.a.a Vb;
        if (aVar == null) {
            aVar = ji(swanAppNAViewContainer.getSlaveId());
        }
        if (aVar != null && (Vb = aVar.Vb()) != null) {
            Vb.aw(swanAppNAViewContainer);
        }
    }

    public static com.baidu.swan.apps.view.container.a ji(String str) {
        return ac.jc(str);
    }
}
