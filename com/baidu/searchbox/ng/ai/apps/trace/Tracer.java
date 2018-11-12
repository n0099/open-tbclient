package com.baidu.searchbox.ng.ai.apps.trace;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.facebook.common.internal.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class Tracer implements ITracer, IndexDef {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private final Map<Index<?>, Set<Callback>> mIndexPool = new HashMap();

    /* loaded from: classes2.dex */
    public interface Callback extends TypedCallback<Set<Index<?>>> {
    }

    /* loaded from: classes2.dex */
    private static class Holder {
        private static final Tracer sInstance = new Tracer();

        private Holder() {
        }
    }

    public static Tracer get() {
        return Holder.sInstance;
    }

    public Tracer record(ErrCode errCode) {
        AiAppsLog.e(ITracer.LOG_TAG_ERRCODE, errCode.toString());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tracer regIndex(Index<?>... indexArr) {
        synchronized (this.mIndexPool) {
            for (Index<?> index : indexArr) {
                if (!this.mIndexPool.containsKey(index)) {
                    this.mIndexPool.put(index, new HashSet());
                }
            }
        }
        return this;
    }

    public Tracer regCallback(Callback callback, Index<?>... indexArr) {
        if (callback != null) {
            synchronized (this.mIndexPool) {
                HashSet keySet = isEmptyArray(indexArr) ? this.mIndexPool.keySet() : h.K(indexArr);
                for (Index<?> index : keySet) {
                    if (index != null) {
                        requireCallbacks(index).add(callback);
                    }
                }
                notifyCallbacks(h.K(callback), keySet);
            }
        }
        return this;
    }

    private Set<Callback> requireCallbacks(@NonNull Index<?> index) {
        Set<Callback> set = this.mIndexPool.get(index);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.mIndexPool.put(index, hashSet);
            return hashSet;
        }
        return set;
    }

    public Tracer unRegCallback(Callback callback, Index<?>... indexArr) {
        if (callback != null) {
            synchronized (this.mIndexPool) {
                for (Index<?> index : isEmptyArray(indexArr) ? this.mIndexPool.keySet() : h.K(indexArr)) {
                    if (index != null) {
                        requireCallbacks(index).remove(callback);
                    }
                }
            }
        }
        return this;
    }

    private <T> boolean isEmptyArray(T... tArr) {
        return tArr == null || tArr.length < 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tracer notifyCallbacks(Index<?>... indexArr) {
        return notifyCallbacks(h.K(indexArr));
    }

    protected Tracer notifyCallbacks(Set<Index<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.mIndexPool) {
                for (Index<?> index : set) {
                    hashSet.addAll(requireCallbacks(index));
                }
            }
            notifyCallbacks(hashSet, set);
        }
        return this;
    }

    private Tracer notifyCallbacks(final Set<Callback> set, final Set<Index<?>> set2) {
        sHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.trace.Tracer.1
            @Override // java.lang.Runnable
            public void run() {
                for (Callback callback : set) {
                    callback.onCallback(set2);
                }
            }
        });
        return this;
    }
}
