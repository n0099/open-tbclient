package com.baidu.swan.apps.component.components.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.canvas.b.b;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.console.c;
/* loaded from: classes3.dex */
public final class a extends com.baidu.swan.apps.component.b.a<CanvasView, com.baidu.swan.apps.canvas.b.a> {
    @NonNull
    public CanvasView cdi;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.canvas.b.a aVar) {
        super(context, aVar);
        this.cdi = new CanvasView(context);
        this.cdi.setInterceptTouchEvent(aVar.cce);
        this.cdi.setHide(aVar.hidden);
        this.cdi.setGesture(aVar.cdc);
        if (aVar.cdc) {
            this.cdi.setInterceptTouchEvent(false);
        }
    }

    public boolean a(com.baidu.swan.apps.canvas.b.a aVar, final CanvasView.b bVar) {
        if (aVar == null || !(aVar instanceof b)) {
            c.e("Component-Canvas", "some params is invalid");
            return false;
        }
        com.baidu.swan.apps.canvas.b.a adL = adL();
        if (!TextUtils.equals(adL.ccZ, aVar.ccZ) || !TextUtils.equals(adL.cda, aVar.cda)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Canvas", "drawCanvas with illegal ids!");
        }
        b bVar2 = (b) aVar;
        this.cdi.g(bVar2.ady(), bVar2.adz());
        this.cdi.postInvalidate();
        this.cdi.post(new Runnable() { // from class: com.baidu.swan.apps.component.components.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.ads();
                }
            }
        });
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.canvas.b.a aVar) {
        final boolean z = aVar.cdc;
        final boolean z2 = aVar.cce;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(aVar.cda, aVar.ccZ, aVar.ccY) { // from class: com.baidu.swan.apps.component.components.d.a.2
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent) && z2;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bI */
    public CanvasView be(@NonNull Context context) {
        return this.cdi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        this.cdi.onRelease();
    }
}
