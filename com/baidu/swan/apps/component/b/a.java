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
/* loaded from: classes8.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a cIS;
    @NonNull
    private M cIT;
    @Nullable
    private M cIU;
    @Nullable
    private SwanAppComponentContainerView cIV;
    @Nullable
    private j cIW;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V cw(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.cIT = c((a<V, M>) m);
        this.cIS = com.baidu.swan.apps.component.container.a.e(this.cIT);
        if (this.cIS == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.cIS.cE(context);
        }
    }

    @NonNull
    @UiThread
    public final c akD() {
        String name = getName();
        c b2 = b((a<V, M>) this.cIT);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b2.msg);
            return b2;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.cIS == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.cIS.getContext();
        if (this.cIV != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = cw(this.cIS.getContext());
        ax(this.mView);
        this.cIV = cx(context);
        this.cIV.setTargetView(this.mView);
        a(this.mView, this.cIT, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cIS)) {
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
    public final j akE() {
        final String name = getName();
        c b2 = b((a<V, M>) this.cIT);
        if (!b2.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b2.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.cIS == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.cIV != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.cIW != null && !this.cIW.isUnsubscribed()) {
            this.cIW.unsubscribe();
            this.cIW = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.cIV = cx(this.cIS.getContext());
        a((a<V, M>) this.cIT, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cIS)) {
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
                        com.baidu.swan.apps.component.e.a.bq("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.cIW = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.cw(a.this.cIS.getContext());
                    a.this.ax(a.this.mView);
                    a.this.cIV.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.cIT, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.akF();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.cIW;
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
        if (this.cIT == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.bq("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.cIT.cJc, m.cJc)) {
            String str2 = name + " update with different id: " + this.cIT.cJc + ", " + m.cJc;
            com.baidu.swan.apps.component.e.a.bq("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.cIT.cJd, m.cJd)) {
            String str3 = name + " update with different slave id: " + this.cIT.cJd + ", " + m.cJd;
            com.baidu.swan.apps.component.e.a.bq("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.cIV == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.bq("Component-Base", str4);
            return new c(202, str4);
        } else if (this.cIS == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.cIU = this.cIT;
            com.baidu.swan.apps.component.d.b a2 = a(this.cIT, m);
            this.cIT = c((a<V, M>) m);
            a(this.mView, this.cIT, a2);
            boolean a3 = this.cIS.akX().a(this, a2);
            this.cIU = null;
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
    public final c akF() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.cIS == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.cIV == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.cIS.akX().f(this)) {
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
        akL();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M akG() {
        return this.cIT;
    }

    @NonNull
    public final M akH() {
        return c((a<V, M>) this.cIT);
    }

    @Nullable
    public final SwanAppComponentContainerView akI() {
        return this.cIV;
    }

    @NonNull
    public final String getName() {
        c b2 = b((a<V, M>) this.cIT);
        return b2.isSuccess() ? this.cIT.getName() : "【illegal component#" + b2.msg + "】";
    }

    @NonNull
    public final a gn(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean gp(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ax(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView cx(@NonNull Context context) {
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
        if (m2.cJg != null && m2.cJg.a(m.cJg)) {
            bVar.gs(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.gs(1);
        }
        if (m.cJf != m2.cJf) {
            bVar.gs(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.cJf;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.cJd, m.cJc, m.cJb) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        akL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M akJ() {
        return this.cIU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean akK() {
        return this.cIU != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.akX().e(this);
        eS(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.cIV == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.gt(1)) {
            this.cIV.setHidden(m.hidden);
        }
        if (bVar.gt(2)) {
            a(this.cIV, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.cJd)) {
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
            com.baidu.swan.apps.component.e.a.bq("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void akL() {
        if (this.cIW != null && !this.cIW.isUnsubscribed()) {
            this.cIW.unsubscribe();
        }
    }
}
