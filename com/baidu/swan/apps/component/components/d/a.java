package com.baidu.swan.apps.component.components.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.canvas.b.b;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public final class a extends com.baidu.swan.apps.component.b.a<CanvasView, com.baidu.swan.apps.canvas.b.a> {
    @NonNull
    public CanvasView cJn;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.canvas.b.a aVar) {
        super(context, aVar);
        this.cJn = new CanvasView(context);
        this.cJn.setInterceptTouchEvent(aVar.cIh);
        this.cJn.setHide(aVar.hidden);
        this.cJn.setGesture(aVar.cJf);
        if (aVar.cJf) {
            this.cJn.setInterceptTouchEvent(false);
        }
    }

    public boolean a(com.baidu.swan.apps.canvas.b.a aVar, final CanvasView.b bVar) {
        if (aVar == null || !(aVar instanceof b)) {
            c.e("Component-Canvas", "some params is invalid");
            return false;
        }
        com.baidu.swan.apps.canvas.b.a akG = akG();
        if (!TextUtils.equals(akG.cJc, aVar.cJc) || !TextUtils.equals(akG.cJd, aVar.cJd)) {
            com.baidu.swan.apps.component.e.a.bq("Component-Canvas", "drawCanvas with illegal ids!");
        }
        b bVar2 = (b) aVar;
        this.cJn.i(bVar2.akt(), bVar2.aku());
        this.cJn.postInvalidate();
        this.cJn.post(new Runnable() { // from class: com.baidu.swan.apps.component.components.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.ako();
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
        final boolean z = aVar.cJf;
        final boolean z2 = aVar.cIh;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(aVar.cJd, aVar.cJc, aVar.cJb) { // from class: com.baidu.swan.apps.component.components.d.a.2
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
    /* renamed from: cB */
    public CanvasView cw(@NonNull Context context) {
        return this.cJn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    public void onRemove() {
        super.onRemove();
        this.cJn.onRelease();
    }
}
