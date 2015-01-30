package com.baidu.adp.lib.f;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    private static d li;
    private static BdAsyncTaskParallel lj = null;
    private static BdAsyncTaskParallel lk = null;
    private final BdUniqueId lg = BdUniqueId.gen();
    private SparseArray<g<?>> lh;

    public static d ec() {
        if (li == null) {
            synchronized (d.class) {
                if (li == null) {
                    li = new d();
                }
            }
        }
        return li;
    }

    private d() {
        this.lh = null;
        BdUniqueId gen = BdUniqueId.gen();
        lj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        lk = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.lh = new SparseArray<>();
    }

    public synchronized <T> void a(int i, g<T> gVar) {
        if (gVar != null) {
            if (this.lh.get(i) == null) {
                this.lh.put(i, gVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        e af = af(f(str, i));
        if (af != null) {
            af.cancel();
        }
    }

    public <T> void a(String str, int i, c<T> cVar) {
        e<T> af = af(f(str, i));
        if (af != null) {
            af.a(cVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.lg);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.lg);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.lg);
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

    public boolean W(int i) {
        g<?> gVar = this.lh.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return gVar.ef();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        g<?> gVar = this.lh.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return gVar.c(f(str, i), str, objArr);
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
        g<?> gVar = this.lh.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String f = f(str, i);
        try {
            Object c = gVar.c(f, str, objArr);
            if (c != null) {
                if (cVar != 0) {
                    cVar.onLoaded(c, str, 1);
                    return c;
                }
                return c;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        e<T> af = af(f);
        if (af != null && af.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            af.a(cVar, bdUniqueId);
        } else {
            boolean fg = i.fg();
            boolean fi = i.fi();
            q qVar = null;
            if (fg) {
                qVar = f.ed();
                qVar.eK();
            }
            e eVar = new e(this, str, i, i2, i3, bdUniqueId, cVar, qVar, objArr);
            eVar.setKey(f);
            eVar.setTag(this.lg);
            int eh = gVar.eh();
            if (eh == 0) {
                eh = 1;
            }
            eVar.setPriority(eh);
            if (fg || fi) {
                if (gVar.eg() == null) {
                    eVar.setParallel(lk);
                } else {
                    eVar.setParallel(gVar.eg());
                }
            } else {
                eVar.setParallel(lj);
            }
            eVar.execute(new String[0]);
        }
        return null;
    }

    private <T> e<T> af(String str) {
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
    public String f(String str, int i) {
        if (str == null) {
            str = "";
        }
        return String.valueOf(str) + i;
    }
}
