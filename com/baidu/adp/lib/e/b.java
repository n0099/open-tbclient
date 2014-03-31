package com.baidu.adp.lib.e;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
import java.util.Map;
/* loaded from: classes.dex */
public final class b {
    private static b b;
    private SparseArray<f> a;

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public b() {
        this.a = null;
        this.a = new SparseArray<>();
    }

    public final void a(int i, f fVar) {
        if (fVar != null) {
            this.a.put(i, fVar);
        }
    }

    public final void a(String str, Context context) {
        BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(String.valueOf(str) + context.getClass().getName());
        if (searchTask != null) {
            d dVar = (d) searchTask;
            for (Map.Entry<a, e> entry : dVar.a.entrySet()) {
                dVar.a(entry.getKey());
            }
            dVar.cancel();
        }
    }

    private Object a(String str, int i, a aVar, Context context, e eVar, BdAsyncTaskParallelType bdAsyncTaskParallelType, int i2) {
        boolean z;
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        Object a;
        f a2 = a(i);
        if (a2 == null) {
            throw new Exception("Can't find the ResourceLoaderProc with type " + i);
        }
        Object fromMemory = a2.getFromMemory(str, eVar);
        if (fromMemory == null) {
            a cVar = aVar == null ? new c(this) : aVar;
            String str2 = String.valueOf(str) + context.getClass().getName();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(str2);
            if (eVar == null || (a = eVar.a("param_immediatelyExecut")) == null || !(a instanceof Boolean)) {
                z = false;
            } else {
                z = ((Boolean) a).booleanValue();
            }
            if (!z || searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                bdAsyncTask = searchTask;
            } else {
                bdAsyncTask = BdAsyncTask.searchWaitingTask(str2);
                if (bdAsyncTask != null && bdAsyncTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                    bdAsyncTask.cancel();
                    bdAsyncTask = null;
                }
            }
            if (bdAsyncTask != null && bdAsyncTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                ((d) bdAsyncTask).a(cVar, eVar);
            } else {
                d dVar = new d(this, str, i, cVar, eVar);
                dVar.setPriority(i2);
                dVar.setKey(String.valueOf(str) + context.getClass().getName());
                if (context != null && (context instanceof com.baidu.adp.a.a)) {
                    dVar.setTag(((com.baidu.adp.a.a) context).getUniqueId());
                }
                dVar.setImmediatelyExecut(z);
                dVar.execute(new String[0]);
            }
            return null;
        }
        return fromMemory;
    }

    public final Object a(String str, int i, a aVar, Context context, e eVar) {
        return a(str, i, aVar, context, eVar, null, 1);
    }

    public final Object a(String str, int i, a aVar, Context context, e eVar, int i2) {
        return a(str, i, aVar, context, eVar, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f a(int i) {
        return this.a.get(i);
    }
}
