package com.baidu.adp.lib.f;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    private static d le;
    private static BdAsyncTaskParallel lf = null;
    private static BdAsyncTaskParallel lg = null;
    private final BdUniqueId lc = BdUniqueId.gen();
    private SparseArray<g<?>> ld;

    public static d ef() {
        if (le == null) {
            synchronized (d.class) {
                if (le == null) {
                    le = new d();
                }
            }
        }
        return le;
    }

    private d() {
        this.ld = null;
        BdUniqueId gen = BdUniqueId.gen();
        lf = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        lg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.ld = new SparseArray<>();
    }

    public synchronized <T> void a(int i, g<T> gVar) {
        if (gVar != null) {
            if (this.ld.get(i) == null) {
                this.ld.put(i, gVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void d(String str, int i) {
        e ab = ab(e(str, i));
        if (ab != null) {
            ab.cancel();
        }
    }

    public <T> void a(String str, int i, c<T> cVar) {
        e<T> ab = ab(e(str, i));
        if (ab != null) {
            ab.a(cVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.lc);
        if (searchAllTask != null && searchAllTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).f(bdUniqueId);
                }
            }
        }
    }

    public <T> void a(BdUniqueId bdUniqueId, c<T> cVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.lc);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).b(bdUniqueId, cVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.lc);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).f(bdUniqueId);
                }
            }
        }
    }

    public boolean J(int i) {
        g<?> gVar = this.ld.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return gVar.eh();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        g<?> gVar = this.ld.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return gVar.a(e(str, i), str, objArr);
    }

    public <T> Object a(String str, int i, c<T> cVar, BdUniqueId bdUniqueId) {
        return a(str, i, cVar, 0, 0, bdUniqueId, new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: com.baidu.adp.lib.f.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        g<?> gVar = this.ld.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String e = e(str, i);
        try {
            Object a = gVar.a(e, str, objArr);
            if (a != null) {
                if (cVar != 0) {
                    cVar.a(a, str, 1);
                    return a;
                }
                return a;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        e<T> ab = ab(e);
        if (ab != null && ab.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ab.a(cVar, bdUniqueId);
        } else {
            boolean fi = j.fi();
            boolean fk = j.fk();
            q qVar = null;
            if (fi) {
                qVar = f.getLogItem();
                qVar.eL();
            }
            e eVar = new e(this, str, i, i2, i3, bdUniqueId, cVar, qVar, objArr);
            eVar.setKey(e);
            eVar.setTag(this.lc);
            int ej = gVar.ej();
            if (ej == 0) {
                ej = 1;
            }
            eVar.setPriority(ej);
            if (fi || fk) {
                if (gVar.ei() == null) {
                    eVar.setParallel(lg);
                } else {
                    eVar.setParallel(gVar.ei());
                }
            } else {
                eVar.setParallel(lf);
            }
            eVar.execute(new String[0]);
        }
        return null;
    }

    private <T> e<T> ab(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (!TextUtils.isEmpty(str) && (searchTask = BdAsyncTask.searchTask(str)) != null) {
            if (!(searchTask instanceof e)) {
                BdLog.e("BdAsyncTask has encountered repeat key");
                return null;
            }
            try {
                return (e) searchTask;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str, int i) {
        if (str == null) {
            str = "";
        }
        return String.valueOf(str) + i;
    }
}
