package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class n<T> {
    private static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private final Object mDataLock = new Object();
    private android.arch.a.b.b<q<T>, n<T>.c> mObservers = new android.arch.a.b.b<>();
    private int mActiveCount = 0;
    private volatile Object mData = NOT_SET;
    private volatile Object mPendingData = NOT_SET;
    private int mVersion = -1;
    private final Runnable mPostValueRunnable = new Runnable() { // from class: android.arch.lifecycle.n.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: android.arch.lifecycle.n */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (n.this.mDataLock) {
                obj = n.this.mPendingData;
                n.this.mPendingData = n.NOT_SET;
            }
            n.this.setValue(obj);
        }
    };

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: android.arch.lifecycle.q<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void considerNotify(n<T>.c cVar) {
        if (cVar.yQ) {
            if (!cVar.gl()) {
                cVar.Y(false);
            } else if (cVar.yR < this.mVersion) {
                cVar.yR = this.mVersion;
                cVar.yP.onChanged(this.mData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchingValue(@Nullable n<T>.c cVar) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (cVar != null) {
                considerNotify(cVar);
                cVar = null;
            } else {
                android.arch.a.b.b<q<T>, n<T>.c>.d gd = this.mObservers.gd();
                while (gd.hasNext()) {
                    considerNotify((c) gd.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @MainThread
    public void observe(@NonNull j jVar, @NonNull q<T> qVar) {
        if (jVar.getLifecycle().gh() != Lifecycle.State.DESTROYED) {
            b bVar = new b(jVar, qVar);
            n<T>.c c2 = this.mObservers.c(qVar, bVar);
            if (c2 != null && !c2.i(jVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (c2 == null) {
                jVar.getLifecycle().a(bVar);
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull q<T> qVar) {
        a aVar = new a(qVar);
        n<T>.c c2 = this.mObservers.c(qVar, aVar);
        if (c2 != null && (c2 instanceof b)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (c2 == null) {
            aVar.Y(true);
        }
    }

    @MainThread
    public void removeObserver(@NonNull q<T> qVar) {
        assertMainThread("removeObserver");
        n<T>.c remove = this.mObservers.remove(qVar);
        if (remove != null) {
            remove.gm();
            remove.Y(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull j jVar) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<q<T>, n<T>.c>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry<q<T>, n<T>.c> next = it.next();
            if (next.getValue().i(jVar)) {
                removeObserver(next.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            android.arch.a.a.a.gb().f(this.mPostValueRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    @Nullable
    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    int getVersion() {
        return this.mVersion;
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    /* loaded from: classes6.dex */
    class b extends n<T>.c implements h {
        @NonNull
        final j yO;

        b(@NonNull j jVar, q<T> qVar) {
            super(qVar);
            this.yO = jVar;
        }

        @Override // android.arch.lifecycle.n.c
        boolean gl() {
            return this.yO.getLifecycle().gh().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // android.arch.lifecycle.h
        public void a(j jVar, Lifecycle.Event event) {
            if (this.yO.getLifecycle().gh() == Lifecycle.State.DESTROYED) {
                n.this.removeObserver(this.yP);
            } else {
                Y(gl());
            }
        }

        @Override // android.arch.lifecycle.n.c
        boolean i(j jVar) {
            return this.yO == jVar;
        }

        @Override // android.arch.lifecycle.n.c
        void gm() {
            this.yO.getLifecycle().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public abstract class c {
        final q<T> yP;
        boolean yQ;
        int yR = -1;

        abstract boolean gl();

        c(q<T> qVar) {
            this.yP = qVar;
        }

        boolean i(j jVar) {
            return false;
        }

        void gm() {
        }

        void Y(boolean z) {
            if (z != this.yQ) {
                this.yQ = z;
                boolean z2 = n.this.mActiveCount == 0;
                n nVar = n.this;
                nVar.mActiveCount = (this.yQ ? 1 : -1) + nVar.mActiveCount;
                if (z2 && this.yQ) {
                    n.this.onActive();
                }
                if (n.this.mActiveCount == 0 && !this.yQ) {
                    n.this.onInactive();
                }
                if (this.yQ) {
                    n.this.dispatchingValue(this);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class a extends n<T>.c {
        a(q<T> qVar) {
            super(qVar);
        }

        @Override // android.arch.lifecycle.n.c
        boolean gl() {
            return true;
        }
    }

    private static void assertMainThread(String str) {
        if (!android.arch.a.a.a.gb().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
