package com.baidu.adp.lib.e;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static c c;
    private a a = null;
    private SparseArray<g> b = null;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.lib.e.e.a(java.lang.String[]):java.lang.Object] */
    public static /* synthetic */ a a(c cVar) {
        return cVar.a;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.lib.e.e.a(java.lang.String[]):java.lang.Object] */
    public static /* synthetic */ g a(c cVar, int i) {
        return cVar.a(i);
    }

    public c a(a aVar) {
        this.a = aVar;
        return this;
    }

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    public void a(String str, Context context) {
        a(str, context, null);
    }

    public void a(String str, Context context, b bVar) {
        Map map;
        int i;
        Map map2;
        BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(str + context.getClass().getName());
        if (searchTask != null) {
            e eVar = (e) searchTask;
            map = eVar.d;
            Iterator it = map.entrySet().iterator();
            int i2 = 0;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                b bVar2 = (b) entry.getKey();
                f fVar = (f) entry.getValue();
                i2 = (bVar == null || bVar.b()) ? i : i + 1;
                if (bVar == null) {
                    eVar.a(bVar2);
                }
            }
            if (i < 2) {
                eVar.cancel();
                return;
            }
            map2 = eVar.d;
            if (map2.containsKey(bVar)) {
                eVar.a(bVar);
            }
        }
    }

    public Object a(String str, int i, b bVar, Context context, f fVar, BdAsyncTaskParallelType bdAsyncTaskParallelType, int i2) {
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
            String str2 = str + context.getClass().getName();
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
                if (bdAsyncTaskParallelType != null) {
                    eVar.setType(bdAsyncTaskParallelType);
                }
                eVar.setPriority(i2);
                eVar.setKey(str + context.getClass().getName());
                if (context != null) {
                }
                eVar.setImmediatelyExecut(z);
                eVar.execute(new String[0]);
            }
            return null;
        }
        return a3;
    }

    public Object a(String str, int i, b bVar, Context context, f fVar) {
        return a(str, i, bVar, context, fVar, null, 1);
    }

    public Object a(String str, int i, b bVar, Context context, f fVar, int i2) {
        return a(str, i, bVar, context, fVar, null, i2);
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
