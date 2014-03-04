package com.baidu.adp.lib.e;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {
    private static c c;
    private a a = null;
    private SparseArray<g> b = null;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.lib.e.e.a(java.lang.String[]):java.lang.Object] */
    public static /* synthetic */ a a(c cVar) {
        return cVar.a;
    }

    public final c a(a aVar) {
        this.a = aVar;
        return this;
    }

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    public final void a(String str, Context context) {
        Map map;
        BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(String.valueOf(str) + context.getClass().getName());
        if (searchTask == null) {
            return;
        }
        e eVar = (e) searchTask;
        map = eVar.d;
        for (Map.Entry entry : map.entrySet()) {
            entry.getValue();
            eVar.a((b) entry.getKey());
        }
        eVar.cancel();
    }

    private Object a(String str, int i, b bVar, Context context, f fVar, BdAsyncTaskParallelType bdAsyncTaskParallelType, int i2) {
        boolean z;
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        Object a;
        if (this.a == null) {
            throw new Exception("BdLoaderCreaterAbstractFactory can not be null");
        }
        g a2 = a(i);
        if (a2 == null) {
            throw new Exception("Can't find the ResourceLoaderProc with type " + i);
        }
        Object a3 = a2.a(str, fVar);
        if (a3 == null) {
            b dVar = bVar == null ? new d(this) : bVar;
            String str2 = String.valueOf(str) + context.getClass().getName();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(str2);
            if (fVar == null || (a = fVar.a("param_immediatelyExecut")) == null || !(a instanceof Boolean)) {
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
                ((e) bdAsyncTask).a(dVar, fVar);
            } else {
                e eVar = new e(this, str, i, dVar, fVar);
                eVar.setPriority(i2);
                eVar.setKey(String.valueOf(str) + context.getClass().getName());
                if (context != null && (context instanceof com.baidu.adp.a.a)) {
                    eVar.setTag(((com.baidu.adp.a.a) context).getUniqueId());
                }
                eVar.setImmediatelyExecut(z);
                eVar.execute(new String[0]);
            }
            return null;
        }
        return a3;
    }

    public final Object a(String str, int i, b bVar, Context context, f fVar) {
        return a(str, i, bVar, context, fVar, null, 1);
    }

    public final Object a(String str, int i, b bVar, Context context, f fVar, int i2) {
        return a(str, i, bVar, context, fVar, null, i2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.lib.e.e.a(java.lang.String[]):java.lang.Object] */
    public static /* synthetic */ g a(c cVar, int i) {
        return cVar.a(i);
    }

    public g a(int i) {
        if (this.b == null) {
            this.b = new SparseArray<>();
        }
        g gVar = this.b.get(i);
        if (gVar == null) {
            g a = this.a.a(i);
            this.b.put(i, a);
            return a;
        }
        return gVar;
    }
}
