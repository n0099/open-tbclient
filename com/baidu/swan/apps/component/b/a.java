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
/* loaded from: classes10.dex */
public abstract class a<V extends View, M extends b> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Nullable
    private com.baidu.swan.apps.component.c.a bdL;
    @NonNull
    private M bdM;
    @Nullable
    private M bdN;
    @Nullable
    private SwanAppComponentContainerView bdO;
    @Nullable
    private j bdP;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V bj(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.bdM = c((a<V, M>) m);
        this.bdL = com.baidu.swan.apps.component.container.a.e(this.bdM);
        if (this.bdL == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.bdL.bM(context);
        }
    }

    @UiThread
    @NonNull
    public final c Io() {
        String name = getName();
        c b = b((a<V, M>) this.bdM);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.bdL == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.bdL.getContext();
        if (this.bdO != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = bj(this.bdL.getContext());
        ac(this.mView);
        this.bdO = bF(context);
        this.bdO.setTargetView(this.mView);
        a(this.mView, this.bdM, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bdL)) {
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
    public final j Ip() {
        final String name = getName();
        c b = b((a<V, M>) this.bdM);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.bdL == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.bdO != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.bdP != null && !this.bdP.isUnsubscribed()) {
            this.bdP.unsubscribe();
            this.bdP = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.bdO = bF(this.bdL.getContext());
        a((a<V, M>) this.bdM, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.bdL)) {
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
                        com.baidu.swan.apps.component.e.a.ak("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.bdP = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.bj(a.this.bdL.getContext());
                    a.this.ac(a.this.mView);
                    a.this.bdO.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.bdM, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.Iq();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.bdP;
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
        if (this.bdM == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.ak("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.bdM.bdV, m.bdV)) {
            String str2 = name + " update with different id: " + this.bdM.bdV + ", " + m.bdV;
            com.baidu.swan.apps.component.e.a.ak("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.bdM.bdW, m.bdW)) {
            String str3 = name + " update with different slave id: " + this.bdM.bdW + ", " + m.bdW;
            com.baidu.swan.apps.component.e.a.ak("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.bdO == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.ak("Component-Base", str4);
            return new c(202, str4);
        } else if (this.bdL == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.bdN = this.bdM;
            com.baidu.swan.apps.component.d.b a = a(this.bdM, m);
            this.bdM = c((a<V, M>) m);
            a(this.mView, this.bdM, a);
            boolean a2 = this.bdL.IF().a(this, a);
            this.bdN = null;
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
    public final c Iq() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.bdL == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.bdO == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.bdL.IF().f(this)) {
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
        Iw();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M Ir() {
        return this.bdM;
    }

    @NonNull
    public final M Is() {
        return c((a<V, M>) this.bdM);
    }

    @Nullable
    public final SwanAppComponentContainerView It() {
        return this.bdO;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.bdM);
        return b.isSuccess() ? this.bdM.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a dO(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean dP(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac(@NonNull V v) {
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
        if (m2.bdZ != null && m2.bdZ.a(m.bdZ)) {
            bVar.dS(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.dS(1);
        }
        if (m.bdY != m2.bdY) {
            bVar.dS(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.bdY;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.bdW, m.bdV, m.bdU) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bV(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        Iw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M Iu() {
        return this.bdN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Iv() {
        return this.bdN != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.IF().e(this);
        bV(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.bdO == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.dT(1)) {
            this.bdO.setHidden(m.hidden);
        }
        if (bVar.dT(2)) {
            a(this.bdO, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.bdW)) {
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
            com.baidu.swan.apps.component.e.a.ak("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void Iw() {
        if (this.bdP != null && !this.bdP.isUnsubscribed()) {
            this.bdP.unsubscribe();
        }
    }
}
