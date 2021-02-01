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
    private com.baidu.swan.apps.component.c.a cLg;
    @NonNull
    private M cLh;
    @Nullable
    private M cLi;
    @Nullable
    private SwanAppComponentContainerView cLj;
    @Nullable
    private j cLk;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V cv(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.cLh = c((a<V, M>) m);
        this.cLg = com.baidu.swan.apps.component.container.a.e(this.cLh);
        if (this.cLg == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.cLg.cD(context);
        }
    }

    @NonNull
    @UiThread
    public final c alb() {
        String name = getName();
        c b2 = b((a<V, M>) this.cLh);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b2.msg);
            return b2;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.cLg == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.cLg.getContext();
        if (this.cLj != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = cv(this.cLg.getContext());
        as(this.mView);
        this.cLj = cw(context);
        this.cLj.setTargetView(this.mView);
        a(this.mView, this.cLh, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cLg)) {
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
    public final j alc() {
        final String name = getName();
        c b2 = b((a<V, M>) this.cLh);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b2.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.cLg == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.cLj != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.cLk != null && !this.cLk.isUnsubscribed()) {
            this.cLk.unsubscribe();
            this.cLk = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.cLj = cw(this.cLg.getContext());
        a((a<V, M>) this.cLh, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cLg)) {
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
                        com.baidu.swan.apps.component.e.a.bk("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.cLk = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.cv(a.this.cLg.getContext());
                    a.this.as(a.this.mView);
                    a.this.cLj.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.cLh, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.ald();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.cLk;
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
        if (this.cLh == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.bk("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.cLh.cLq, m.cLq)) {
            String str2 = name + " update with different id: " + this.cLh.cLq + ", " + m.cLq;
            com.baidu.swan.apps.component.e.a.bk("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.cLh.cLr, m.cLr)) {
            String str3 = name + " update with different slave id: " + this.cLh.cLr + ", " + m.cLr;
            com.baidu.swan.apps.component.e.a.bk("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.cLj == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.bk("Component-Base", str4);
            return new c(202, str4);
        } else if (this.cLg == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.cLi = this.cLh;
            com.baidu.swan.apps.component.d.b a2 = a(this.cLh, m);
            this.cLh = c((a<V, M>) m);
            a(this.mView, this.cLh, a2);
            boolean a3 = this.cLg.alv().a(this, a2);
            this.cLi = null;
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
    public final c ald() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.cLg == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.cLj == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.cLg.alv().f(this)) {
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
        alj();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M ale() {
        return this.cLh;
    }

    @NonNull
    public final M alf() {
        return c((a<V, M>) this.cLh);
    }

    @Nullable
    public final SwanAppComponentContainerView alg() {
        return this.cLj;
    }

    @NonNull
    public final String getName() {
        c b2 = b((a<V, M>) this.cLh);
        return b2.isSuccess() ? this.cLh.getName() : "【illegal component#" + b2.msg + "】";
    }

    @NonNull
    public final a gr(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean gs(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void as(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView cw(@NonNull Context context) {
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
        if (m2.cLu != null && m2.cLu.a(m.cLu)) {
            bVar.gv(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.gv(1);
        }
        if (m.cLt != m2.cLt) {
            bVar.gv(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.cLt;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.cLr, m.cLq, m.cLp) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eU(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        alj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M alh() {
        return this.cLi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ali() {
        return this.cLi != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.alv().e(this);
        eU(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.cLj == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.gw(1)) {
            this.cLj.setHidden(m.hidden);
        }
        if (bVar.gw(2)) {
            a(this.cLj, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.cLr)) {
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
            com.baidu.swan.apps.component.e.a.bk("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void alj() {
        if (this.cLk != null && !this.cLk.isUnsubscribed()) {
            this.cLk.unsubscribe();
        }
    }
}
