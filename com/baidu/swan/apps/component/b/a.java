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
/* loaded from: classes7.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a bVb;
    @NonNull
    private M bVc;
    @Nullable
    private M bVd;
    @Nullable
    private SwanAppComponentContainerView bVe;
    @Nullable
    private j bVf;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V ba(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.bVc = c((a<V, M>) m);
        this.bVb = com.baidu.swan.apps.component.container.a.e(this.bVc);
        if (this.bVb == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.bVb.bF(context);
        }
    }

    @UiThread
    @NonNull
    public final c WT() {
        String name = getName();
        c b = b((a<V, M>) this.bVc);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.bVb == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.bVb.getContext();
        if (this.bVe != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = ba(this.bVb.getContext());
        ae(this.mView);
        this.bVe = by(context);
        this.bVe.setTargetView(this.mView);
        a(this.mView, this.bVc, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bVb)) {
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
    public final j WU() {
        final String name = getName();
        c b = b((a<V, M>) this.bVc);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.bVb == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.bVe != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.bVf != null && !this.bVf.isUnsubscribed()) {
            this.bVf.unsubscribe();
            this.bVf = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.bVe = by(this.bVb.getContext());
        a((a<V, M>) this.bVc, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bVb)) {
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
                        com.baidu.swan.apps.component.e.a.aV("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.bVf = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.ba(a.this.bVb.getContext());
                    a.this.ae(a.this.mView);
                    a.this.bVe.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.bVc, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.WV();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.bVf;
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
        if (this.bVc == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.aV("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.bVc.bVl, m.bVl)) {
            String str2 = name + " update with different id: " + this.bVc.bVl + ", " + m.bVl;
            com.baidu.swan.apps.component.e.a.aV("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.bVc.bVm, m.bVm)) {
            String str3 = name + " update with different slave id: " + this.bVc.bVm + ", " + m.bVm;
            com.baidu.swan.apps.component.e.a.aV("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.bVe == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.aV("Component-Base", str4);
            return new c(202, str4);
        } else if (this.bVb == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.bVd = this.bVc;
            com.baidu.swan.apps.component.d.b a = a(this.bVc, m);
            this.bVc = c((a<V, M>) m);
            a(this.mView, this.bVc, a);
            boolean a2 = this.bVb.Xk().a(this, a);
            this.bVd = null;
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
    public final c WV() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.bVb == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.bVe == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.bVb.Xk().f(this)) {
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
        Xb();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M WW() {
        return this.bVc;
    }

    @NonNull
    public final M WX() {
        return c((a<V, M>) this.bVc);
    }

    @Nullable
    public final SwanAppComponentContainerView WY() {
        return this.bVe;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.bVc);
        return b.isSuccess() ? this.bVc.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a eH(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean eI(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView by(@NonNull Context context) {
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
        if (m2.bVp != null && m2.bVp.a(m.bVp)) {
            bVar.eL(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.eL(1);
        }
        if (m.bVo != m2.bVo) {
            bVar.eL(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.bVo;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.bVm, m.bVl, m.bVk) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dv(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        Xb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M WZ() {
        return this.bVd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Xa() {
        return this.bVd != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.Xk().e(this);
        dv(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.bVe == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.eM(1)) {
            this.bVe.setHidden(m.hidden);
        }
        if (bVar.eM(2)) {
            a(this.bVe, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.bVm)) {
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
            com.baidu.swan.apps.component.e.a.aV("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void Xb() {
        if (this.bVf != null && !this.bVf.isUnsubscribed()) {
            this.bVf.unsubscribe();
        }
    }
}
