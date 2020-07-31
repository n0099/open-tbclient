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
    private static c LK;
    private static BdAsyncTaskParallel LM = null;
    private static BdAsyncTaskParallel LN = null;
    private final BdUniqueId LI = BdUniqueId.gen();
    private SparseArray<e<?>> LJ;

    public static c ln() {
        if (LK == null) {
            synchronized (c.class) {
                if (LK == null) {
                    LK = new c();
                }
            }
        }
        return LK;
    }

    private c() {
        this.LJ = null;
        BdUniqueId gen = BdUniqueId.gen();
        LM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        LN = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.LJ = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.LJ.get(i) == null) {
                this.LJ.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void k(String str, int i) {
        a bN = bN(genCacheKey(str, i));
        if (bN != null) {
            bN.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> bN = bN(genCacheKey(str, i));
        if (bN != null) {
            bN.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.LI);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.LI);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.LI);
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

    public boolean ao(int i) {
        e<?> eVar = this.LJ.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.lq();
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.LJ.get(i);
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
        e<?> eVar = this.LJ.get(i);
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
        a<T> bN = bN(genCacheKey);
        if (bN != null && bN.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            bN.a(bVar, bdUniqueId);
        } else {
            boolean isWifiNet = j.isWifiNet();
            boolean is4GNet = j.is4GNet();
            com.baidu.adp.lib.stats.a aVar = null;
            if (isWifiNet) {
                aVar = d.lo();
                aVar.startTimer();
            }
            a aVar2 = new a(str, i, i4, i5, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(genCacheKey);
            aVar2.setTag(this.LI);
            int ls = eVar.ls();
            if (ls == 0) {
                ls = 1;
            }
            aVar2.setPriority(ls);
            if (isWifiNet || is4GNet) {
                if (eVar.lr() == null) {
                    aVar2.setParallel(LN);
                } else {
                    aVar2.setParallel(eVar.lr());
                }
            } else {
                aVar2.setParallel(LM);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String LO;
        private final int LQ;
        private boolean LR;
        private com.baidu.adp.lib.stats.a LS;
        private int LU = 2;
        private final Map<b<T>, BdUniqueId> LV = new HashMap();
        private final com.baidu.adp.lib.e.a LW = new com.baidu.adp.lib.e.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.LR = false;
            this.args = null;
            this.LS = null;
            this.LO = str;
            this.LQ = i;
            this.width = i2;
            this.height = i3;
            this.LR = z;
            this.LS = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (!this.LV.containsKey(bVar)) {
                this.LV.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.checkMainThread();
            this.LV.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.LO);
            }
            if (this.LV.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.checkMainThread();
            if (this.LV.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.LV.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.LV.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (this.LV.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.LV.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.LV.size() == 0) {
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
            if (this.LS != null) {
                com.baidu.adp.lib.stats.a lo = d.lo();
                lo.startTimer();
                aVar = lo;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.LJ.get(this.LQ);
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
            t = (T) eVar.a(this.LO, key, this.width, this.height, this.LW, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.LS, aVar);
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
            if (isCancelled() && !this.LR) {
                this.LU = 3;
                try {
                    obj = eVar.a(this.LO, key, this.width, this.height, this, this.LW, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.LS, aVar);
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
            if (t != null && (eVar = (e) c.this.LJ.get(this.LQ)) != null) {
                eVar.a(c.this.genCacheKey(this.LO, this.LQ), t, this.width, this.height, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.LV.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.LO, this.LU);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.LV.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.LW != null && this.LW.LH != null) {
                this.LW.LH.cancel();
            }
            if (this.LV.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.LV.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.LO);
                    }
                }
                this.LV.clear();
            }
        }
    }

    private <T> a<T> bN(String str) {
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

    public e ap(int i) {
        if (this.LJ == null) {
            return null;
        }
        return this.LJ.get(i);
    }
}
