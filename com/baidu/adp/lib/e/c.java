package com.baidu.adp.lib.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static c Lj;
    private static BdAsyncTaskParallel Lk = null;
    private static BdAsyncTaskParallel Ll = null;
    private final BdUniqueId Lh = BdUniqueId.gen();
    private SparseArray<e<?>> Li;

    public static c kX() {
        if (Lj == null) {
            synchronized (c.class) {
                if (Lj == null) {
                    Lj = new c();
                }
            }
        }
        return Lj;
    }

    private c() {
        this.Li = null;
        BdUniqueId gen = BdUniqueId.gen();
        Lk = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        Ll = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.Li = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.Li.get(i) == null) {
                this.Li.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void k(String str, int i) {
        a bO = bO(genCacheKey(str, i));
        if (bO != null) {
            bO.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> bO = bO(genCacheKey(str, i));
        if (bO != null) {
            bO.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.Lh);
        if (searchAllTask != null && searchAllTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).f(bdUniqueId);
                }
            }
        }
    }

    public <T> void a(BdUniqueId bdUniqueId, b<T> bVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Lh);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).b(bdUniqueId, bVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Lh);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).f(bdUniqueId);
                }
            }
        }
    }

    public boolean ag(int i) {
        e<?> eVar = this.Li.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.la();
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.Li.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.a(genCacheKey(str, i), str, 0, 0, objArr);
    }

    public <T> Object a(String str, int i, b<T> bVar, BdUniqueId bdUniqueId) {
        return a(str, i, bVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return a(str, i, bVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: com.baidu.adp.lib.e.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        int i4;
        int i5;
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        e<?> eVar = this.Li.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        if (i2 < 0 || i3 < 0) {
            i4 = 0;
            i5 = 0;
        } else {
            i5 = i3;
            i4 = i2;
        }
        String genCacheKey = genCacheKey(str, i);
        try {
            Object a2 = eVar.a(genCacheKey, str, i4, i5, objArr);
            if (a2 != null) {
                if (bVar != 0) {
                    bVar.onLoaded(a2, str, 1);
                }
                return a2;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> bO = bO(genCacheKey);
        if (bO != null && bO.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            bO.a(bVar, bdUniqueId);
        } else {
            boolean isWifiNet = j.isWifiNet();
            boolean is4GNet = j.is4GNet();
            com.baidu.adp.lib.stats.a aVar = null;
            if (isWifiNet) {
                aVar = d.kY();
                aVar.startTimer();
            }
            a aVar2 = new a(str, i, i4, i5, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(genCacheKey);
            aVar2.setTag(this.Lh);
            int lc = eVar.lc();
            if (lc == 0) {
                lc = 1;
            }
            aVar2.setPriority(lc);
            if (isWifiNet || is4GNet) {
                if (eVar.lb() == null) {
                    aVar2.setParallel(Ll);
                } else {
                    aVar2.setParallel(eVar.lb());
                }
            } else {
                aVar2.setParallel(Lk);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String Lm;
        private final int Ln;
        private boolean Lo;
        private com.baidu.adp.lib.stats.a Lp;
        private int Lq = 2;
        private final Map<b<T>, BdUniqueId> Lr = new HashMap();
        private final com.baidu.adp.lib.e.a Ls = new com.baidu.adp.lib.e.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.Lo = false;
            this.args = null;
            this.Lp = null;
            this.Lm = str;
            this.Ln = i;
            this.width = i2;
            this.height = i3;
            this.Lo = z;
            this.Lp = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (!this.Lr.containsKey(bVar)) {
                this.Lr.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.checkMainThread();
            this.Lr.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.Lm);
            }
            if (this.Lr.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.checkMainThread();
            if (this.Lr.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.Lr.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.Lr.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (this.Lr.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.Lr.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.Lr.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.a aVar;
            Exception e;
            T t;
            T t2;
            Exception e2;
            Object obj;
            if (this.Lp != null) {
                com.baidu.adp.lib.stats.a kY = d.kY();
                kY.startTimer();
                aVar = kY;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.Li.get(this.Ln);
            if (eVar == null) {
                return null;
            }
            String key = getKey();
            try {
            } catch (Exception e3) {
                e = e3;
                t = null;
            }
            if (isCancelled()) {
                return null;
            }
            t = (T) eVar.a(this.Lm, key, this.width, this.height, this.Ls, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.Lp, aVar);
                    }
                    return t;
                } catch (Exception e4) {
                    e = e4;
                    BdLog.e(e.getMessage());
                    t2 = t;
                    return isCancelled() ? null : null;
                }
            }
            t2 = t;
            if (isCancelled() && !this.Lo) {
                this.Lq = 3;
                try {
                    obj = eVar.a(this.Lm, key, this.width, this.height, this, this.Ls, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.Lp, aVar);
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    BdLog.e(e2.getMessage());
                    return (T) obj;
                }
                return (T) obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) c.this.Li.get(this.Ln)) != null) {
                eVar.a(c.this.genCacheKey(this.Lm, this.Ln), t, this.width, this.height, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.Lr.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.Lm, this.Lq);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.Lr.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.Ls != null && this.Ls.Lg != null) {
                this.Ls.Lg.cancel();
            }
            if (this.Lr.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.Lr.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.Lm);
                    }
                }
                this.Lr.clear();
            }
        }
    }

    private <T> a<T> bO(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        if (!TextUtils.isEmpty(str) && (searchTask = BdAsyncTask.searchTask(str)) != null) {
            if (!(searchTask instanceof a)) {
                BdLog.e("BdAsyncTask has encountered repeat key");
                return null;
            }
            try {
                return (a) searchTask;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public String genCacheKey(String str, int i) {
        if (str == null) {
            str = "";
        }
        return str + i;
    }

    public e ah(int i) {
        if (this.Li == null) {
            return null;
        }
        return this.Li.get(i);
    }
}
