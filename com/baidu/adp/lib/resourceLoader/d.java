package com.baidu.adp.lib.resourceLoader;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    private static d c;
    private static BdAsyncTaskParallel d = null;
    private static BdAsyncTaskParallel e = null;
    private final BdUniqueId a = BdUniqueId.gen();
    private SparseArray<h<?>> b;

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    private d() {
        this.b = null;
        BdUniqueId gen = BdUniqueId.gen();
        d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.b = new SparseArray<>();
    }

    public synchronized <T> void a(int i, h<T> hVar) {
        if (hVar != null) {
            if (this.b.get(i) == null) {
                this.b.put(i, hVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void a(String str, int i) {
        e a = a(b(str, i));
        if (a != null) {
            a.cancel();
        }
    }

    public <T> void a(String str, int i, c<T> cVar) {
        e<T> a = a(b(str, i));
        if (a != null) {
            a.a(cVar);
        }
    }

    public void a(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.a);
        if (searchAllTask != null && searchAllTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).a(bdUniqueId);
                }
            }
        }
    }

    public <T> void a(BdUniqueId bdUniqueId, c<T> cVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).a(bdUniqueId, cVar);
                }
            }
        }
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).a(bdUniqueId);
                }
            }
        }
    }

    public boolean a(int i) {
        h<?> hVar = this.b.get(i);
        if (hVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return hVar.a();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        h<?> hVar = this.b.get(i);
        if (hVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return hVar.a(b(str, i), str, objArr);
    }

    public <T> Object a(String str, int i, c<T> cVar, BdUniqueId bdUniqueId) {
        return a(str, i, cVar, 0, 0, bdUniqueId, new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.baidu.adp.lib.resourceLoader.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        h<?> hVar = this.b.get(i);
        if (hVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String b = b(str, i);
        try {
            Object a = hVar.a(b, str, objArr);
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
        e<T> a2 = a(b);
        if (a2 != null && a2.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            a2.a(cVar, bdUniqueId);
        } else {
            boolean a3 = BdResourceLoaderNetHelperStatic.a();
            q qVar = null;
            if (a3) {
                qVar = f.a();
                qVar.a();
            }
            e eVar = new e(this, str, i, i2, i3, bdUniqueId, cVar, qVar, objArr);
            eVar.setKey(b);
            eVar.setTag(this.a);
            if (hVar.c() == 0) {
            }
            if (a3) {
                if (hVar.b() == null) {
                    eVar.setParallel(e);
                } else {
                    eVar.setParallel(hVar.b());
                }
            } else {
                eVar.setParallel(d);
            }
            eVar.execute(new String[0]);
        }
        return null;
    }

    private <T> e<T> a(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (!TextUtils.isEmpty(str) && (searchTask = BdAsyncTask.searchTask(str)) != null) {
            if (!(searchTask instanceof e)) {
                BdLog.e("BdAsyncTask has encountered repeat key");
                return null;
            }
            try {
                return (e) searchTask;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str, int i) {
        if (str == null) {
            str = "";
        }
        return String.valueOf(str) + i;
    }
}
