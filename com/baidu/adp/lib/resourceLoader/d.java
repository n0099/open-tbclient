package com.baidu.adp.lib.resourceLoader;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.asyncTask.l;
import com.baidu.adp.lib.stats.s;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    private static d c;
    private static BdAsyncTaskParallel d = null;
    private static BdAsyncTaskParallel e = null;
    private final int a = -1000;
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
        l a = l.a();
        d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, a);
        e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, a);
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

    public <T> void a(String str, int i, c<T> cVar) {
        e<T> a = a(a(str, i));
        if (a != null) {
            a.a(cVar);
        }
    }

    public void a(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(-1000);
        if (searchAllTask != null && searchAllTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).a(i);
                }
            }
        }
    }

    public <T> void a(int i, c<T> cVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(-1000);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            BdLog.d("pageId-" + i);
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).a(i, cVar);
                }
            }
        }
    }

    public void b(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(-1000);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            BdLog.d("pageId-" + i);
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof e)) {
                    ((e) next).a(i);
                }
            }
        }
    }

    public boolean c(int i) {
        h<?> hVar = this.b.get(i);
        if (hVar == null) {
            BdLog.w("Can't find the ResourceLoaderProc with type " + i);
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
            BdLog.w("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return hVar.a(a(str, i), objArr);
    }

    public <T> Object a(String str, int i, c<T> cVar, int i2) {
        return a(str, i, cVar, 0, 0, i2, new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.baidu.adp.lib.resourceLoader.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, int i4, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.w("resKey can not be null");
            return null;
        }
        h<?> hVar = this.b.get(i);
        if (hVar == null) {
            BdLog.w("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String a = a(str, i);
        try {
            Object a2 = hVar.a(a, objArr);
            if (a2 != null) {
                if (cVar != 0) {
                    cVar.a(a2, str);
                    return a2;
                }
                return a2;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        e<T> a3 = a(a);
        if (a3 != null && a3.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            a3.a(cVar, i4);
        } else {
            boolean a4 = BdResourceLoaderNetHelperStatic.a();
            s sVar = null;
            if (a4) {
                sVar = f.a();
                sVar.a();
            }
            e eVar = new e(this, str, i, i2, i3, i4, cVar, sVar, objArr);
            BdLog.d("create task");
            eVar.setKey(a);
            eVar.setTag(-1000);
            if (a4) {
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
                BdLog.w("BdAsyncTask has encountered repeat key");
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
    public String a(String str, int i) {
        if (str == null) {
            str = "";
        }
        return String.valueOf(str) + i;
    }
}
