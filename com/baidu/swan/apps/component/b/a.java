package com.baidu.swan.apps.component.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.component.b.b;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import rx.d;
import rx.j;
/* loaded from: classes3.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a ccP;
    @NonNull
    private M ccQ;
    @Nullable
    private M ccR;
    @Nullable
    private SwanAppComponentContainerView ccS;
    @Nullable
    private j ccT;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V be(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.ccQ = c((a<V, M>) m);
        this.ccP = com.baidu.swan.apps.component.container.a.e(this.ccQ);
        if (this.ccP == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.ccP.bL(context);
        }
    }

    @UiThread
    @NonNull
    public final c adI() {
        String name = getName();
        c b = b((a<V, M>) this.ccQ);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.ccP == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.ccP.getContext();
        if (this.ccS != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = be(this.ccP.getContext());
        ah(this.mView);
        this.ccS = bE(context);
        this.ccS.setTargetView(this.mView);
        a(this.mView, this.ccQ, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.ccP)) {
            if (DEBUG) {
                Log.d("Component-Base", name + " insert: success");
            }
            return new c(0, "success");
        }
        com.baidu.swan.apps.console.c.e("Component-Base", name + " insert: attach fail");
        return new c(1001, "attach fail");
    }

    @UiThread
    @Nullable
    public final j adJ() {
        final String name = getName();
        c b = b((a<V, M>) this.ccQ);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.ccP == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.ccS != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.ccT != null && !this.ccT.isUnsubscribed()) {
            this.ccT.unsubscribe();
            this.ccT = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.ccS = bE(this.ccP.getContext());
        a((a<V, M>) this.ccQ, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.ccP)) {
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
                        com.baidu.swan.apps.component.e.a.ba("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.ccT = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.be(a.this.ccP.getContext());
                    a.this.ah(a.this.mView);
                    a.this.ccS.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.ccQ, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.adK();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.ccT;
        }
        com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed: attach fail");
        return null;
    }

    @UiThread
    @NonNull
    public final c a(@NonNull M m) {
        String name = getName();
        c b = b((a<V, M>) m);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " update with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start update=====================");
        }
        if (this.ccQ == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.ccQ.ccZ, m.ccZ)) {
            String str2 = name + " update with different id: " + this.ccQ.ccZ + ", " + m.ccZ;
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.ccQ.cda, m.cda)) {
            String str3 = name + " update with different slave id: " + this.ccQ.cda + ", " + m.cda;
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.ccS == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str4);
            return new c(202, str4);
        } else if (this.ccP == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.ccR = this.ccQ;
            com.baidu.swan.apps.component.d.b a = a(this.ccQ, m);
            this.ccQ = c((a<V, M>) m);
            a(this.mView, this.ccQ, a);
            boolean a2 = this.ccP.aea().a(this, a);
            this.ccR = null;
            if (!a2) {
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

    @UiThread
    @NonNull
    public final c adK() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.ccP == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.ccS == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.ccP.aea().f(this)) {
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
        adQ();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M adL() {
        return this.ccQ;
    }

    @NonNull
    public final M adM() {
        return c((a<V, M>) this.ccQ);
    }

    @Nullable
    public final SwanAppComponentContainerView adN() {
        return this.ccS;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.ccQ);
        return b.isSuccess() ? this.ccQ.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a gO(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean gP(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView bE(@NonNull Context context) {
        return new SwanAppComponentContainerView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        a((a<V, M>) m, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull M m, @NonNull M m2) {
        com.baidu.swan.apps.component.d.b bVar = new com.baidu.swan.apps.component.d.b();
        if (m2.cdd != null && m2.cdd.a(m.cdd)) {
            bVar.gS(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.gS(1);
        }
        if (m.cdc != m2.cdc) {
            bVar.gS(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.cdc;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.cda, m.ccZ, m.ccY) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dD(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        adQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M adO() {
        return this.ccR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean adP() {
        return this.ccR != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.aea().e(this);
        dD(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.ccS == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.gT(1)) {
            this.ccS.setHidden(m.hidden);
        }
        if (bVar.gT(2)) {
            a(this.ccS, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.cda)) {
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
            com.baidu.swan.apps.component.e.a.c("Component-Base", "model must implement cloneable", e);
            bVar = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.swan.apps.component.e.a.c("Component-Base", "clone model fail ！", e2);
            bVar = null;
        }
        if (bVar == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void adQ() {
        if (this.ccT != null && !this.ccT.isUnsubscribed()) {
            this.ccT.unsubscribe();
        }
    }
}
