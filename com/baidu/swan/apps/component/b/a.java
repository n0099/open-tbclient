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
/* loaded from: classes11.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a bUj;
    @NonNull
    private M bUk;
    @Nullable
    private M bUl;
    @Nullable
    private SwanAppComponentContainerView bUm;
    @Nullable
    private j bUn;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V aZ(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.bUk = c((a<V, M>) m);
        this.bUj = com.baidu.swan.apps.component.container.a.e(this.bUk);
        if (this.bUj == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.bUj.bC(context);
        }
    }

    @UiThread
    @NonNull
    public final c Wm() {
        String name = getName();
        c b = b((a<V, M>) this.bUk);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.bUj == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.bUj.getContext();
        if (this.bUm != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = aZ(this.bUj.getContext());
        ab(this.mView);
        this.bUm = bv(context);
        this.bUm.setTargetView(this.mView);
        a(this.mView, this.bUk, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bUj)) {
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
    public final j Wn() {
        final String name = getName();
        c b = b((a<V, M>) this.bUk);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.bUj == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.bUm != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.bUn != null && !this.bUn.isUnsubscribed()) {
            this.bUn.unsubscribe();
            this.bUn = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.bUm = bv(this.bUj.getContext());
        a((a<V, M>) this.bUk, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bUj)) {
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
                        com.baidu.swan.apps.component.e.a.aU("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.bUn = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.aZ(a.this.bUj.getContext());
                    a.this.ab(a.this.mView);
                    a.this.bUm.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.bUk, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.Wo();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.bUn;
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
        if (this.bUk == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.aU("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.bUk.bUt, m.bUt)) {
            String str2 = name + " update with different id: " + this.bUk.bUt + ", " + m.bUt;
            com.baidu.swan.apps.component.e.a.aU("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.bUk.bUu, m.bUu)) {
            String str3 = name + " update with different slave id: " + this.bUk.bUu + ", " + m.bUu;
            com.baidu.swan.apps.component.e.a.aU("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.bUm == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.aU("Component-Base", str4);
            return new c(202, str4);
        } else if (this.bUj == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.bUl = this.bUk;
            com.baidu.swan.apps.component.d.b a = a(this.bUk, m);
            this.bUk = c((a<V, M>) m);
            a(this.mView, this.bUk, a);
            boolean a2 = this.bUj.WD().a(this, a);
            this.bUl = null;
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
    public final c Wo() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.bUj == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.bUm == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.bUj.WD().f(this)) {
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
        Wu();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M Wp() {
        return this.bUk;
    }

    @NonNull
    public final M Wq() {
        return c((a<V, M>) this.bUk);
    }

    @Nullable
    public final SwanAppComponentContainerView Wr() {
        return this.bUm;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.bUk);
        return b.isSuccess() ? this.bUk.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a eF(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean eG(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView bv(@NonNull Context context) {
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
        if (m2.bUx != null && m2.bUx.a(m.bUx)) {
            bVar.eJ(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.eJ(1);
        }
        if (m.bUw != m2.bUw) {
            bVar.eJ(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.bUw;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.bUu, m.bUt, m.bUs) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ds(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        Wu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M Ws() {
        return this.bUl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Wt() {
        return this.bUl != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.WD().e(this);
        ds(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.bUm == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.eK(1)) {
            this.bUm.setHidden(m.hidden);
        }
        if (bVar.eK(2)) {
            a(this.bUm, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.bUu)) {
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
            com.baidu.swan.apps.component.e.a.aU("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void Wu() {
        if (this.bUn != null && !this.bUn.isUnsubscribed()) {
            this.bUn.unsubscribe();
        }
    }
}
