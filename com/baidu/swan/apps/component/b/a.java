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
/* loaded from: classes9.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a bcX;
    @NonNull
    private M bcY;
    @Nullable
    private M bcZ;
    @Nullable
    private SwanAppComponentContainerView bda;
    @Nullable
    private j bdb;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V bj(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.bcY = c((a<V, M>) m);
        this.bcX = com.baidu.swan.apps.component.container.a.e(this.bcY);
        if (this.bcX == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.bcX.bM(context);
        }
    }

    @UiThread
    @NonNull
    public final c HS() {
        String name = getName();
        c b = b((a<V, M>) this.bcY);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.bcX == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.bcX.getContext();
        if (this.bda != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = bj(this.bcX.getContext());
        Y(this.mView);
        this.bda = bF(context);
        this.bda.setTargetView(this.mView);
        a(this.mView, this.bcY, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bcX)) {
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
    public final j HT() {
        final String name = getName();
        c b = b((a<V, M>) this.bcY);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.bcX == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.bda != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.bdb != null && !this.bdb.isUnsubscribed()) {
            this.bdb.unsubscribe();
            this.bdb = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.bda = bF(this.bcX.getContext());
        a((a<V, M>) this.bcY, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bcX)) {
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
                        com.baidu.swan.apps.component.e.a.aj("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.bdb = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.bj(a.this.bcX.getContext());
                    a.this.Y(a.this.mView);
                    a.this.bda.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.bcY, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.HU();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.bdb;
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
        if (this.bcY == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.aj("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.bcY.bdh, m.bdh)) {
            String str2 = name + " update with different id: " + this.bcY.bdh + ", " + m.bdh;
            com.baidu.swan.apps.component.e.a.aj("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.bcY.bdi, m.bdi)) {
            String str3 = name + " update with different slave id: " + this.bcY.bdi + ", " + m.bdi;
            com.baidu.swan.apps.component.e.a.aj("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.bda == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.aj("Component-Base", str4);
            return new c(202, str4);
        } else if (this.bcX == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.bcZ = this.bcY;
            com.baidu.swan.apps.component.d.b a = a(this.bcY, m);
            this.bcY = c((a<V, M>) m);
            a(this.mView, this.bcY, a);
            boolean a2 = this.bcX.Ij().a(this, a);
            this.bcZ = null;
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
    public final c HU() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.bcX == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.bda == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.bcX.Ij().f(this)) {
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
        Ia();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M HV() {
        return this.bcY;
    }

    @NonNull
    public final M HW() {
        return c((a<V, M>) this.bcY);
    }

    @Nullable
    public final SwanAppComponentContainerView HX() {
        return this.bda;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.bcY);
        return b.isSuccess() ? this.bcY.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a dN(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean dO(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView bF(@NonNull Context context) {
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
        if (m2.bdl != null && m2.bdl.a(m.bdl)) {
            bVar.dR(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.dR(1);
        }
        if (m.bdk != m2.bdk) {
            bVar.dR(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.bdk;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.bdi, m.bdh, m.bdg) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQ(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        Ia();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M HY() {
        return this.bcZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean HZ() {
        return this.bcZ != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.Ij().e(this);
        bQ(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.bda == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.dS(1)) {
            this.bda.setHidden(m.hidden);
        }
        if (bVar.dS(2)) {
            a(this.bda, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.bdi)) {
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
            com.baidu.swan.apps.component.e.a.aj("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void Ia() {
        if (this.bdb != null && !this.bdb.isUnsubscribed()) {
            this.bdb.unsubscribe();
        }
    }
}
