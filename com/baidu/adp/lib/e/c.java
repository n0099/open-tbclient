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
    private SparseArray<i> b = null;

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
        int i;
        BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(String.valueOf(str) + context.getClass().getName());
        if (searchTask != null) {
            f fVar = (f) searchTask;
            Iterator<Map.Entry<b, h>> it = fVar.a.entrySet().iterator();
            int i2 = 0;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<b, h> next = it.next();
                b key = next.getKey();
                next.getValue();
                i2 = (bVar == null || bVar.b()) ? i : i + 1;
                if (bVar == null) {
                    fVar.a(key);
                }
            }
            if (i >= 2) {
                if (fVar.a.containsKey(bVar)) {
                    fVar.a(bVar);
                    return;
                }
                return;
            }
            fVar.cancel();
        }
    }

    public Object a(String str, int i, b bVar, Context context, h hVar, BdAsyncTaskParallelType bdAsyncTaskParallelType, int i2) {
        boolean z;
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        Object a;
        if (this.a == null) {
            throw new Exception("BdLoaderCreaterAbstractFactory can not be null");
        }
        i a2 = a(i);
        if (a2 == null) {
            throw new Exception("Can't find the ResourceLoaderProc with type " + i);
        }
        Object a3 = a2.a(str, hVar);
        if (a3 == null) {
            b dVar = bVar == null ? new d(this) : bVar;
            String str2 = String.valueOf(str) + context.getClass().getName();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask(str2);
            if (hVar == null || (a = hVar.a("param_immediatelyExecut")) == null || !(a instanceof Boolean)) {
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
                ((f) bdAsyncTask).a(dVar, hVar);
            } else {
                f fVar = new f(this, str, i, dVar, hVar);
                if (bdAsyncTaskParallelType != null) {
                    fVar.setType(bdAsyncTaskParallelType);
                }
                fVar.setPriority(i2);
                fVar.setKey(String.valueOf(str) + context.getClass().getName());
                if (context != null && (context instanceof com.baidu.adp.a.a)) {
                    fVar.setTag(((com.baidu.adp.a.a) context).getUniqueId());
                }
                fVar.setImmediatelyExecut(z);
                fVar.execute(new String[0]);
            }
            return null;
        }
        return a3;
    }

    public Object a(String str, int i, b bVar, Context context, h hVar) {
        return a(str, i, bVar, context, hVar, null, 1);
    }

    public Object a(String str, int i, b bVar, Context context, h hVar, int i2) {
        return a(str, i, bVar, context, hVar, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i a(int i) {
        if (this.b == null) {
            this.b = new SparseArray<>();
        }
        i iVar = this.b.get(i);
        if (iVar == null) {
            i a = this.a.a(i);
            this.b.put(i, a);
            return a;
        }
        return iVar;
    }
}
