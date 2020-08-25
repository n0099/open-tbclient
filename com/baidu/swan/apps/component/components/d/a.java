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
/* loaded from: classes8.dex */
public final class a extends com.baidu.swan.apps.component.b.a<CanvasView, com.baidu.swan.apps.canvas.b.a> {
    @NonNull
    public CanvasView cbc;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.canvas.b.a aVar) {
        super(context, aVar);
        this.cbc = new CanvasView(context);
        this.cbc.setInterceptTouchEvent(aVar.bZZ);
        this.cbc.setHide(aVar.hidden);
        this.cbc.setGesture(aVar.caW);
        if (aVar.caW) {
            this.cbc.setInterceptTouchEvent(false);
        }
    }

    public boolean a(com.baidu.swan.apps.canvas.b.a aVar, final CanvasView.b bVar) {
        if (aVar == null || !(aVar instanceof b)) {
            c.e("Component-Canvas", "some params is invalid");
            return false;
        }
        com.baidu.swan.apps.canvas.b.a adc = adc();
        if (!TextUtils.equals(adc.caT, aVar.caT) || !TextUtils.equals(adc.caU, aVar.caU)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Canvas", "drawCanvas with illegal ids!");
        }
        b bVar2 = (b) aVar;
        this.cbc.g(bVar2.acP(), bVar2.acQ());
        this.cbc.postInvalidate();
        this.cbc.post(new Runnable() { // from class: com.baidu.swan.apps.component.components.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.acJ();
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
        final boolean z = aVar.caW;
        final boolean z2 = aVar.bZZ;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(aVar.caU, aVar.caT, aVar.caS) { // from class: com.baidu.swan.apps.component.components.d.a.2
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
    /* renamed from: bJ */
    public CanvasView bf(@NonNull Context context) {
        return this.cbc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        this.cbc.onRelease();
    }
}
