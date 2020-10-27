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
    private com.baidu.swan.apps.component.c.a cxH;
    @NonNull
    private M cxI;
    @Nullable
    private M cxJ;
    @Nullable
    private SwanAppComponentContainerView cxK;
    @Nullable
    private j cxL;
    private int mFlags;
    @Nullable
    private V mView;

    @NonNull
    protected abstract V bk(@NonNull Context context);

    public a(@Nullable Context context, @NonNull M m) {
        this.cxI = c((a<V, M>) m);
        this.cxH = com.baidu.swan.apps.component.container.a.e(this.cxI);
        if (this.cxH == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", getName() + " context is null !");
        } else if (context != null) {
            this.cxH.bR(context);
        }
    }

    @UiThread
    @NonNull
    public final c ain() {
        String name = getName();
        c b = b((a<V, M>) this.cxI);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a invalid model => " + b.msg);
            return b;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insert=====================");
        }
        if (this.cxH == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert with a null component context!");
            return new c(202, "component context is null");
        }
        Context context = this.cxH.getContext();
        if (this.cxK != null || this.mView != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert");
        }
        this.mView = bk(this.cxH.getContext());
        ak(this.mView);
        this.cxK = bK(context);
        this.cxK.setTargetView(this.mView);
        a(this.mView, this.cxI, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cxH)) {
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
    public final j aio() {
        final String name = getName();
        c b = b((a<V, M>) this.cxI);
        if (!b.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " insert delayed with a invalid model => " + b.msg);
            return null;
        }
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start insertDelayed=====================");
        }
        if (this.cxH == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Base", name + " insert delayed with a null component context!");
            return null;
        }
        if (this.cxK != null) {
            com.baidu.swan.apps.console.c.w("Component-Base", name + " repeat insert delayed: container view repeat");
        }
        if (this.cxL != null && !this.cxL.isUnsubscribed()) {
            this.cxL.unsubscribe();
            this.cxL = null;
            com.baidu.swan.apps.console.c.w("Component-Base", name + " insert delayed repeat: subscriber repeat");
        }
        this.cxK = bK(this.cxH.getContext());
        a((a<V, M>) this.cxI, new com.baidu.swan.apps.component.d.b(true));
        if (a(this.cxH)) {
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
                        com.baidu.swan.apps.component.e.a.bm("Component-Base", "save subscriber and return subscriber: nolinear !");
                    }
                    a.this.cxL = jVar;
                }
            }).b(new j<Object>() { // from class: com.baidu.swan.apps.component.b.a.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.swan.apps.component.b.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.e
                public void onCompleted() {
                    a.this.mView = a.this.bk(a.this.cxH.getContext());
                    a.this.ak(a.this.mView);
                    a.this.cxK.setTargetView(a.this.mView, 0);
                    a.this.a(a.this.mView, a.this.cxI, new com.baidu.swan.apps.component.d.b(true));
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
                    a.this.aip();
                }

                @Override // rx.e
                public void onNext(Object obj) {
                    com.baidu.swan.apps.console.c.w("Component-Base", name + " success should call onCompleted");
                }
            });
            return this.cxL;
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
        if (this.cxI == m) {
            String str = name + " update with the same model";
            com.baidu.swan.apps.component.e.a.bm("Component-Base", str);
            return new c(202, str);
        } else if (!TextUtils.equals(this.cxI.cxR, m.cxR)) {
            String str2 = name + " update with different id: " + this.cxI.cxR + ", " + m.cxR;
            com.baidu.swan.apps.component.e.a.bm("Component-Base", str2);
            return new c(202, str2);
        } else if (!TextUtils.equals(this.cxI.cxS, m.cxS)) {
            String str3 = name + " update with different slave id: " + this.cxI.cxS + ", " + m.cxS;
            com.baidu.swan.apps.component.e.a.bm("Component-Base", str3);
            return new c(202, str3);
        } else if (this.mView == null || this.cxK == null) {
            String str4 = name + " update must after insert succeeded";
            com.baidu.swan.apps.component.e.a.bm("Component-Base", str4);
            return new c(202, str4);
        } else if (this.cxH == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Base", name + " update with a null component context!");
            return new c(202, "component context is null");
        } else {
            this.cxJ = this.cxI;
            com.baidu.swan.apps.component.d.b a2 = a(this.cxI, m);
            this.cxI = c((a<V, M>) m);
            a(this.mView, this.cxI, a2);
            boolean a3 = this.cxH.aiF().a(this, a2);
            this.cxJ = null;
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

    @UiThread
    @NonNull
    public final c aip() {
        String name = getName();
        if (DEBUG) {
            Log.i("Component-Base", "=====================" + name + " start remove=====================");
        }
        if (this.cxH == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Base", name + " remove with a null component context!");
            return new c(202, "component context is null");
        } else if (this.cxK == null) {
            com.baidu.swan.apps.console.c.e("Component-Base", name + " remove must after insert");
            return new c(202, "component remove must after insert");
        } else if (!this.cxH.aiF().f(this)) {
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
        aiv();
    }

    @Nullable
    public final V getView() {
        return this.mView;
    }

    @NonNull
    public final M aiq() {
        return this.cxI;
    }

    @NonNull
    public final M air() {
        return c((a<V, M>) this.cxI);
    }

    @Nullable
    public final SwanAppComponentContainerView ais() {
        return this.cxK;
    }

    @NonNull
    public final String getName() {
        c b = b((a<V, M>) this.cxI);
        return b.isSuccess() ? this.cxI.getName() : "【illegal component#" + b.msg + "】";
    }

    @NonNull
    public final a hw(int i) {
        this.mFlags |= i;
        return this;
    }

    public final boolean hx(int i) {
        return (this.mFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(@NonNull V v) {
    }

    @NonNull
    protected SwanAppComponentContainerView bK(@NonNull Context context) {
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
        if (m2.cxV != null && m2.cxV.a(m.cxV)) {
            bVar.hA(3);
        }
        if (m.hidden != m2.hidden) {
            bVar.hA(1);
        }
        if (m.cxU != m2.cxU) {
            bVar.hA(2);
        }
        return bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        final boolean z = m.cxU;
        swanAppComponentContainerView.setOnTouchListener(new com.baidu.swan.apps.view.b.a.b(m.cxS, m.cxR, m.cxQ) { // from class: com.baidu.swan.apps.component.b.a.3
            @Override // com.baidu.swan.apps.view.b.a.b, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return z && super.onTouch(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void em(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onRemove() {
        aiv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final M ait() {
        return this.cxJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aiu() {
        return this.cxJ != null;
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.c.a aVar) {
        boolean e = aVar.aiF().e(this);
        em(e);
        return e;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (this.cxK == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.hB(1)) {
            this.cxK.setHidden(m.hidden);
        }
        if (bVar.hB(2)) {
            a(this.cxK, (SwanAppComponentContainerView) m);
        }
    }

    @NonNull
    private c b(M m) {
        if (m == null) {
            return new c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.cxS)) {
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
            com.baidu.swan.apps.component.e.a.bm("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    private void aiv() {
        if (this.cxL != null && !this.cxL.isUnsubscribed()) {
            this.cxL.unsubscribe();
        }
    }
}
