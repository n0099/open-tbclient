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
/* loaded from: classes10.dex */
public final class a extends com.baidu.swan.apps.component.b.a<CanvasView, com.baidu.swan.apps.canvas.b.a> {
    @NonNull
    public CanvasView cDT;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.canvas.b.a aVar) {
        super(context, aVar);
        this.cDT = new CanvasView(context);
        this.cDT.setInterceptTouchEvent(aVar.cCQ);
        this.cDT.setHide(aVar.hidden);
        this.cDT.setGesture(aVar.cDN);
        if (aVar.cDN) {
            this.cDT.setInterceptTouchEvent(false);
        }
    }

    public boolean a(com.baidu.swan.apps.canvas.b.a aVar, final CanvasView.b bVar) {
        if (aVar == null || !(aVar instanceof b)) {
            c.e("Component-Canvas", "some params is invalid");
            return false;
        }
        com.baidu.swan.apps.canvas.b.a akQ = akQ();
        if (!TextUtils.equals(akQ.cDK, aVar.cDK) || !TextUtils.equals(akQ.cDL, aVar.cDL)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Canvas", "drawCanvas with illegal ids!");
        }
        b bVar2 = (b) aVar;
        this.cDT.i(bVar2.akD(), bVar2.akE());
        this.cDT.postInvalidate();
        this.cDT.post(new Runnable() { // from class: com.baidu.swan.apps.component.components.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.akx();
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
        final boolean z = aVar.cDN;
        final boolean z2 = aVar.cCQ;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(aVar.cDL, aVar.cDK, aVar.cDJ) { // from class: com.baidu.swan.apps.component.components.d.a.2
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
    /* renamed from: bO */
    public CanvasView bk(@NonNull Context context) {
        return this.cDT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        this.cDT.onRelease();
    }
}
