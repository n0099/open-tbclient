package com.baidu.swan.apps.canvas;

import android.content.Context;
import android.text.TextUtils;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.canvas.c.g;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.model.a.a.b;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.canvas.b.a {
    private a() {
    }

    /* renamed from: com.baidu.swan.apps.canvas.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0135a {
        private static final a amp = new a();
    }

    public static a xT() {
        return C0135a.amp;
    }

    public boolean a(Context context, AbsoluteLayout absoluteLayout, com.baidu.swan.apps.canvas.c.a aVar) {
        if (context == null || absoluteLayout == null || aVar == null) {
            c.e("SwanAppCanvas", "some params is invalid");
            return false;
        }
        String str = aVar.id;
        b bVar = aVar.aEu;
        if (TextUtils.isEmpty(str) || bVar == null || !bVar.isValid()) {
            c.e("SwanAppCanvas", "canvas id is empty or position is null");
            return false;
        }
        g gVar = new g(context, str, aVar);
        com.baidu.swan.apps.b.c.c cVar = (com.baidu.swan.apps.b.c.c) e.GJ().ea(aVar.aEs);
        if (cVar != null) {
            cVar.a(gVar);
        }
        new SwanAppNAViewContainer(absoluteLayout.getContext()).a(gVar.anO, aVar);
        return true;
    }

    public boolean a(AbsoluteLayout absoluteLayout, com.baidu.swan.apps.canvas.c.a aVar) {
        com.baidu.swan.apps.b.c.c cVar;
        boolean z = false;
        if (absoluteLayout == null || aVar == null) {
            c.e("SwanAppCanvas", "some params is invalid");
            return false;
        }
        g a = a(aVar);
        if (a == null) {
            c.e("SwanAppCanvas", "get canvas view model is null");
            return false;
        }
        CanvasView canvasView = a.anO;
        if (canvasView != null) {
            canvasView.xO();
        }
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a2 != null && a2.Qm()) {
            z = true;
        }
        if (z && (cVar = (com.baidu.swan.apps.b.c.c) e.GJ().ea(aVar.aEs)) != null) {
            cVar.b(a);
        }
        return true;
    }

    public boolean b(AbsoluteLayout absoluteLayout, com.baidu.swan.apps.canvas.c.a aVar) {
        SwanAppNAViewContainer a;
        if (absoluteLayout == null || aVar == null) {
            c.e("SwanAppCanvas", "some params is invalid");
            return false;
        }
        String str = aVar.id;
        b bVar = aVar.aEu;
        return (TextUtils.isEmpty(str) || bVar == null || !bVar.isValid() || (a = com.baidu.swan.apps.view.container.c.b.a(aVar, null)) == null || !a.a(aVar)) ? false : true;
    }

    public boolean a(Context context, com.baidu.swan.apps.canvas.c.a aVar, final CanvasView.b bVar) {
        d Aw;
        if (context == null || aVar == null || !(aVar instanceof com.baidu.swan.apps.canvas.c.b)) {
            c.e("SwanAppCanvas", "some params is invalid");
            return false;
        }
        String str = aVar.id;
        if (TextUtils.isEmpty(str)) {
            c.e("SwanAppCanvas", "drawCanvas canvasId = " + str);
            return false;
        }
        if (TextUtils.isEmpty(aVar.aEs) && (Aw = e.GJ().Aw()) != null) {
            aVar.aEs = Aw.Ag();
        }
        CanvasView b = b(aVar);
        if (b == null) {
            c.e("SwanAppCanvas", "drawCanvas get canvas view is null");
            return false;
        }
        com.baidu.swan.apps.canvas.c.b bVar2 = (com.baidu.swan.apps.canvas.c.b) aVar;
        b.c(bVar2.yb(), bVar2.yc());
        b.postInvalidate();
        b.post(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.xV();
                }
            }
        });
        return true;
    }
}
