package com.baidu.swan.apps.component.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.component.b.b;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import rx.d;
import rx.j;
/* loaded from: classes9.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a cNE;
    @NonNull
    private M cNF;
    @Nullable
    private M cNG;
    @Nullable
    private SwanAppComponentContainerView cNH;
    @Nullable
    private j cNI;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V cx(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.cNF = c((a<V, M>) m);
        this.cNE = com.baidu.swan.apps.component.container.a.e(this.cNF);
        if (this.cNE == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.cNE.cF(context);
        }
    }

    @NonNull
    @UiThread
    public final c aow() {
        String name = getName();
        c b2 = b((a<V, M>) this.cNF);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b2.msg);
            return b2;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.cNE == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.cNE.getContext();
        if (this.cNH != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = cx(this.cNE.getContext());
        ax(this.mView);
        this.cNH = cy(context);
        this.cNH.setTargetView(this.mView);
        a(this.mView, this.cNF, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cNE)) {
            if (DEBUG) {
                Log.d("Component-Base", name + " insert: success");
            }
            return new c(0, "success");
        }
        com.baidu.swan.apps.console.c.e("Component-Base", name + " insert: attach fail");
        return new c(1001, "attach fail");
    }

    @Nullable
    @UiThread
    public final j aox() {
        final String name = getName();
        c b2 = b((a<V, M>) this.cNF);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b2.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.cNE == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.cNH != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.cNI != null && !this.cNI.isUnsubscribed()) {
            this.cNI.unsubscribe();
            this.cNI = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.cNH = cy(this.cNE.getContext());
        a((a<V, M>) this.cNF, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cNE)) {
            if (DEBUG) {
                Log.d("Component-Base", name + " insert delayed（container view）: success");
            }
            final long id = Thread.currentThread().getId();
            d.a((d.a) new d.a<Object>() { // from class: com.baidu.swan.apps.component.b.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super Object> jVar) {
                    if (a.DEBUG) {
                        Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                    }
                    if (id != Thread.currentThread().getId()) {
                        com.baidu.swan.apps.component.e.a.br("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.cNI = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.cx(a.this.cNE.getContext());
                    a.this.ax(a.this.mView);
                    a.this.cNH.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.cNF, new com.baidu.swan.apps.component.d.b(true));
                    if (a.DEBUG) {
                        Log.d("Component-Base", name + " insert delayed（view）: success");
                    }
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed（view）: fail");
                    if (a.DEBUG && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                        throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                    }
                    a.this.aoy();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.cNI;
        }
        com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed: attach fail");
        return null;
    }

    @NonNull
    @UiThread
    public final c a(@NonNull M m) {
        String name = getName();
        c b2 = b((a<V, M>) m);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " update with a invalid model => " + b2.msg);
            return b2;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start update=====================");
        }
        if (this.cNF == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.br("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.cNF.cNO, m.cNO)) {
            String str2 = name + " update with different id: " + this.cNF.cNO + ", " + m.cNO;
            com.baidu.swan.apps.component.e.a.br("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.cNF.cNP, m.cNP)) {
            String str3 = name + " update with different slave id: " + this.cNF.cNP + ", " + m.cNP;
            com.baidu.swan.apps.component.e.a.br("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.cNH == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.br("Component-Base", str4);
            return new c(202, str4);
        } else if (this.cNE == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.cNG = this.cNF;
            com.baidu.swan.apps.component.d.b a2 = a(this.cNF, m);
            this.cNF = c((a<V, M>) m);
            a(this.mView, this.cNF, a2);
            boolean a3 = this.cNE.aoQ().a(this, a2);
            this.cNG = null;
            if (!a3) {
                String str5 = name + " update component fail";
                com.baidu.swan.apps.console.c.e("Component-Base", str5);
                return new c(1001, str5);
            }
            if (DEBUG) {
                Log.d("Component-Base", name + " component update: success");
            }
            return new c(0, "success");
        }
    }

    @NonNull
    @UiThread
    public final c aoy() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.cNE == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.cNH == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.cNE.aoQ().f(this)) {
            String str = name + " remove fail";
            com.baidu.swan.apps.console.c.e("Component-Base", str);
            return new c(1001, str);
        } else {
            onRemove();
            if (DEBUG) {
                Log.d("Component-Base", name + " remove: success");
            }
            return new c(0, "success");
        }
    }

    @CallSuper
    public void onDestroy() {
        if (DEBUG) {
            Log.d("Component-Base", getName() + " onDestroy");
        }
        aoE();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M aoz() {
        return this.cNF;
    }

    @NonNull
    public final M aoA() {
        return c((a<V, M>) this.cNF);
    }

    @Nullable
    public final SwanAppComponentContainerView aoB() {
        return this.cNH;
    }

    @NonNull
    public final String getName() {
        c b2 = b((a<V, M>) this.cNF);
        return b2.isSuccess() ? this.cNF.getName() : "【illegal component#" + b2.msg + "】";
    }

    @NonNull
    public final a hU(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean hV(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ax(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView cy(@NonNull Context context) {
        return new SwanAppComponentContainerView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        a((a<V, M>) m, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    @CallSuper
    public com.baidu.swan.apps.component.d.b a(@NonNull M m, @NonNull M m2) {
        com.baidu.swan.apps.component.d.b bVar = new com.baidu.swan.apps.component.d.b();
        if (m2.cNS != null && m2.cNS.a(m.cNS)) {
            bVar.hY(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.hY(1);
        }
        if (m.cNR != m2.cNR) {
            bVar.hY(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.cNR;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.cNP, m.cNO, m.cNN) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eW(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        aoE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M aoC() {
        return this.cNG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aoD() {
        return this.cNG != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.aoQ().e(this);
        eW(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.cNH == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.hZ(1)) {
            this.cNH.setHidden(m.hidden);
        }
        if (bVar.hZ(2)) {
            a(this.cNH, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.cNP)) {
            return new c(202, "slave id is empty");
        }
        if (!m.isValid()) {
            return new c(202, "model is invalid");
        }
        return new c(0, "model is valid");
    }

    @NonNull
    private M c(@NonNull M m) {
        b bVar;
        try {
            bVar = (b) m.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            com.baidu.swan.apps.component.e.a.f("Component-Base", "model must implement cloneable", e);
            bVar = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.swan.apps.component.e.a.f("Component-Base", "clone model fail ！", e2);
            bVar = null;
        }
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void aoE() {
        if (this.cNI != null && !this.cNI.isUnsubscribed()) {
            this.cNI.unsubscribe();
        }
    }
}
