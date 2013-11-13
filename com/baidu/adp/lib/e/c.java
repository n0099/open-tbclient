package com.baidu.adp.lib.e;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskType;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static c c;

    /* renamed from: a */
    private a f479a = null;
    private SparseArray<g> b = null;

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.lib.e.e.a(java.lang.String[]):java.lang.Object] */
    public static /* synthetic */ a a(c cVar) {
        return cVar.f479a;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.lib.e.e.a(java.lang.String[]):java.lang.Object] */
    public static /* synthetic */ g a(c cVar, int i) {
        return cVar.a(i);
    }

    public c a(a aVar) {
        this.f479a = aVar;
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

    public Object a(String str, int i, b bVar, Context context, f fVar, BdAsyncTaskType bdAsyncTaskType, int i2) {
        boolean z;
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        Object a2;
        if (this.f479a == null) {
            throw new Exception("BdLoaderCreaterAbstractFactory can not be null");
        }
        g a3 = a(i);
        if (a3 == null) {
            throw new Exception("Can't find the ResourceLoaderProc with type " + i);
        }
        Object a4 = a3.a(str, fVar);
        if (a4 == null) {
            b dVar = bVar == null ? new d(this) : bVar;
            String str2 = str + context.getClass().getName();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(str2);
            if (fVar == null || (a2 = fVar.a("param_immediatelyExecut")) == null || !(a2 instanceof Boolean)) {
                z = false;
            } else {
                z = ((Boolean) a2).booleanValue();
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
                if (bdAsyncTaskType != null) {
                    eVar.setType(bdAsyncTaskType);
                }
                eVar.setPriority(i2);
                eVar.setKey(str + context.getClass().getName());
                if (context != null) {
                    eVar.setTag(context.getClass().getName());
                }
                eVar.setImmediatelyExecut(z);
                eVar.execute(new String[0]);
            }
            return null;
        }
        return a4;
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
            g a2 = this.f479a.a(i);
            this.b.put(i, a2);
            return a2;
        }
        return gVar;
    }
}
