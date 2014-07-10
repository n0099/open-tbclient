package com.baidu.adp.lib.e;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
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

    public void a(int i, f fVar) {
        if (fVar != null) {
            this.a.put(i, fVar);
        }
    }

    public void a(String str, Context context) {
        a(str, context, null);
    }

    public void a(String str, Context context, a aVar) {
        BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(String.valueOf(str) + context.getClass().getName());
        if (searchTask != null) {
            d dVar = (d) searchTask;
            int i = 0;
            for (Map.Entry<a, e> entry : dVar.a.entrySet()) {
                a key = entry.getKey();
                if (aVar != null && !aVar.b()) {
                    i++;
                }
                if (aVar == null) {
                    dVar.a(key);
                }
            }
            if (i >= 2) {
                if (dVar.a.containsKey(aVar)) {
                    dVar.a(aVar);
                    return;
                }
                return;
            }
            dVar.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, int i, a aVar, Context context, e eVar, BdAsyncTaskParallel.BdAsyncTaskParallelType bdAsyncTaskParallelType, int i2) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        boolean z;
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        d dVar;
        f a = a(i);
        if (a == null) {
            throw new Exception("Can't find the ResourceLoaderProc with type " + i);
        }
        Object a2 = a.a(str, eVar);
        if (a2 == null) {
            a cVar = aVar == null ? new c(this) : aVar;
            String str2 = String.valueOf(str) + context.getClass().getName();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(str2);
            boolean z2 = false;
            if (eVar != null) {
                Object a3 = eVar.a("param_immediatelyExecut");
                Object a4 = eVar.a("param_parallel");
                if (a3 != null && (a3 instanceof Boolean)) {
                    z2 = ((Boolean) a3).booleanValue();
                }
                if (a4 != null && (a4 instanceof BdAsyncTaskParallel)) {
                    bdAsyncTaskParallel = (BdAsyncTaskParallel) a4;
                    z = z2;
                    if (z || searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                        bdAsyncTask = searchTask;
                    } else {
                        bdAsyncTask = BdAsyncTask.searchWaitingTask(str2);
                        if (bdAsyncTask != null && bdAsyncTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                            bdAsyncTask.cancel();
                            bdAsyncTask = null;
                        }
                    }
                    if (bdAsyncTask == null && bdAsyncTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                        ((d) bdAsyncTask).a(cVar, eVar);
                    } else {
                        dVar = new d(this, str, i, cVar, eVar);
                        dVar.setPriority(i2);
                        dVar.setKey(String.valueOf(str) + context.getClass().getName());
                        if (context != null && (context instanceof BdBaseActivity)) {
                            dVar.setTag(((BdBaseActivity) context).getUniqueId());
                        }
                        if (z) {
                            dVar.setPriority(4);
                        }
                        if (bdAsyncTaskParallel != null) {
                            dVar.setParallel(bdAsyncTaskParallel);
                        }
                        dVar.execute(new String[0]);
                    }
                    return null;
                }
            }
            bdAsyncTaskParallel = null;
            z = z2;
            if (z) {
            }
            bdAsyncTask = searchTask;
            if (bdAsyncTask == null) {
            }
            dVar = new d(this, str, i, cVar, eVar);
            dVar.setPriority(i2);
            dVar.setKey(String.valueOf(str) + context.getClass().getName());
            if (context != null) {
                dVar.setTag(((BdBaseActivity) context).getUniqueId());
            }
            if (z) {
            }
            if (bdAsyncTaskParallel != null) {
            }
            dVar.execute(new String[0]);
            return null;
        }
        return a2;
    }

    public Object a(String str, int i, a aVar, Context context, e eVar, int i2) {
        return a(str, i, aVar, context, eVar, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f a(int i) {
        return this.a.get(i);
    }
}
