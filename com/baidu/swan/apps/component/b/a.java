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
/* loaded from: classes8.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a caN;
    @NonNull
    private M caO;
    @Nullable
    private M caP;
    @Nullable
    private SwanAppComponentContainerView caQ;
    @Nullable
    private j caR;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V bf(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.caO = c((a<V, M>) m);
        this.caN = com.baidu.swan.apps.component.container.a.e(this.caO);
        if (this.caN == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.caN.bM(context);
        }
    }

    @UiThread
    @NonNull
    public final c acZ() {
        String name = getName();
        c b = b((a<V, M>) this.caO);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.caN == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.caN.getContext();
        if (this.caQ != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = bf(this.caN.getContext());
        af(this.mView);
        this.caQ = bF(context);
        this.caQ.setTargetView(this.mView);
        a(this.mView, this.caO, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.caN)) {
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
    public final j ada() {
        final String name = getName();
        c b = b((a<V, M>) this.caO);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.caN == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.caQ != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.caR != null && !this.caR.isUnsubscribed()) {
            this.caR.unsubscribe();
            this.caR = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.caQ = bF(this.caN.getContext());
        a((a<V, M>) this.caO, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.caN)) {
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
                    a.this.caR = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.bf(a.this.caN.getContext());
                    a.this.af(a.this.mView);
                    a.this.caQ.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.caO, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.adb();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.caR;
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
        if (this.caO == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.caO.caX, m.caX)) {
            String str2 = name + " update with different id: " + this.caO.caX + ", " + m.caX;
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.caO.caY, m.caY)) {
            String str3 = name + " update with different slave id: " + this.caO.caY + ", " + m.caY;
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.caQ == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.ba("Component-Base", str4);
            return new c(202, str4);
        } else if (this.caN == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.caP = this.caO;
            com.baidu.swan.apps.component.d.b a = a(this.caO, m);
            this.caO = c((a<V, M>) m);
            a(this.mView, this.caO, a);
            boolean a2 = this.caN.adq().a(this, a);
            this.caP = null;
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
    public final c adb() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.caN == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.caQ == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.caN.adq().f(this)) {
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
        adh();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M adc() {
        return this.caO;
    }

    @NonNull
    public final M add() {
        return c((a<V, M>) this.caO);
    }

    @Nullable
    public final SwanAppComponentContainerView ade() {
        return this.caQ;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.caO);
        return b.isSuccess() ? this.caO.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a gF(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean gG(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af(@NonNull V v) {
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
        if (m2.cbb != null && m2.cbb.a(m.cbb)) {
            bVar.gJ(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.gJ(1);
        }
        if (m.cba != m2.cba) {
            bVar.gJ(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.cba;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.caY, m.caX, m.caW) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dF(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        adh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M adf() {
        return this.caP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean adg() {
        return this.caP != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.adq().e(this);
        dF(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.caQ == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.gK(1)) {
            this.caQ.setHidden(m.hidden);
        }
        if (bVar.gK(2)) {
            a(this.caQ, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.caY)) {
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

    private void adh() {
        if (this.caR != null && !this.caR.isUnsubscribed()) {
            this.caR.unsubscribe();
        }
    }
}
