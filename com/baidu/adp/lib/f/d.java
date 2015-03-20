package com.baidu.adp.lib.f;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    private static d ww;
    private static BdAsyncTaskParallel wx = null;
    private static BdAsyncTaskParallel wy = null;
    private final BdUniqueId wu = BdUniqueId.gen();
    private SparseArray<g<?>> wv;

    public static d hB() {
        if (ww == null) {
            synchronized (d.class) {
                if (ww == null) {
                    ww = new d();
                }
            }
        }
        return ww;
    }

    private d() {
        this.wv = null;
        BdUniqueId gen = BdUniqueId.gen();
        wx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        wy = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.wv = new SparseArray<>();
    }

    public synchronized <T> void a(int i, g<T> gVar) {
        if (gVar != null) {
            if (this.wv.get(i) == null) {
                this.wv.put(i, gVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        e am = am(f(str, i));
        if (am != null) {
            am.cancel();
        }
    }

    public <T> void a(String str, int i, c<T> cVar) {
        e<T> am = am(f(str, i));
        if (am != null) {
            am.a(cVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.wu);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wu);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wu);
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

    public boolean X(int i) {
        g<?> gVar = this.wv.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return gVar.hE();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        g<?> gVar = this.wv.get(i);
        if (gVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return gVar.c(f(str, i), str, objArr);
    }

    public <T> Object a(String str, int i, c<T> cVar, BdUniqueId bdUniqueId) {
        return a(str, i, cVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return a(str, i, cVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: com.baidu.adp.lib.f.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        g<?> gVar = this.wv.get(i);
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
        e<T> am = am(f);
        if (am != null && am.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            am.a(cVar, bdUniqueId);
        } else {
            boolean iI = k.iI();
            boolean iK = k.iK();
            q qVar = null;
            if (iI) {
                qVar = f.hC();
                qVar.il();
            }
            e eVar = new e(this, str, i, i2, i3, bdUniqueId, cVar, z, qVar, objArr);
            eVar.setKey(f);
            eVar.setTag(this.wu);
            int hG = gVar.hG();
            if (hG == 0) {
                hG = 1;
            }
            eVar.setPriority(hG);
            if (iI || iK) {
                if (gVar.hF() == null) {
                    eVar.setParallel(wy);
                } else {
                    eVar.setParallel(gVar.hF());
                }
            } else {
                eVar.setParallel(wx);
            }
            eVar.execute(new String[0]);
        }
        return null;
    }

    private <T> e<T> am(String str) {
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

    public String f(String str, int i) {
        if (str == null) {
            str = "";
        }
        return String.valueOf(str) + i;
    }
}
