package com.baidu.adp.lib.g;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static c vB;
    private static BdAsyncTaskParallel vC = null;
    private static BdAsyncTaskParallel vD = null;
    private SparseArray<e<?>> vA;
    private final BdUniqueId vz = BdUniqueId.gen();

    public static c hd() {
        if (vB == null) {
            synchronized (c.class) {
                if (vB == null) {
                    vB = new c();
                }
            }
        }
        return vB;
    }

    private c() {
        this.vA = null;
        BdUniqueId gen = BdUniqueId.gen();
        vC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        vD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.vA = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.vA.get(i) == null) {
                this.vA.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a ao = ao(f(str, i));
        if (ao != null) {
            ao.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> ao = ao(f(str, i));
        if (ao != null) {
            ao.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.vz);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.vz);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.vz);
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

    public boolean X(int i) {
        e<?> eVar = this.vA.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.hg();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.vA.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.c(f(str, i), str, objArr);
    }

    public <T> Object a(String str, int i, b<T> bVar, BdUniqueId bdUniqueId) {
        return a(str, i, bVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return a(str, i, bVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: com.baidu.adp.lib.g.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        e<?> eVar = this.vA.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String f = f(str, i);
        try {
            Object c = eVar.c(f, str, objArr);
            if (c != null) {
                if (bVar != 0) {
                    bVar.a(c, str, 1);
                    return c;
                }
                return c;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> ao = ao(f);
        if (ao != null && ao.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ao.a(bVar, bdUniqueId);
        } else {
            boolean iQ = i.iQ();
            boolean iS = i.iS();
            com.baidu.adp.lib.stats.d dVar = null;
            if (iQ) {
                dVar = d.he();
                dVar.hB();
            }
            a aVar = new a(str, i, i2, i3, bdUniqueId, bVar, z, dVar, objArr);
            aVar.setKey(f);
            aVar.setTag(this.vz);
            int hi = eVar.hi();
            if (hi == 0) {
                hi = 1;
            }
            aVar.setPriority(hi);
            if (iQ || iS) {
                if (eVar.hh() == null) {
                    aVar.setParallel(vD);
                } else {
                    aVar.setParallel(eVar.hh());
                }
            } else {
                aVar.setParallel(vC);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private final String vE;
        private final int vF;
        private boolean vG;
        private com.baidu.adp.lib.stats.d vH;
        private int vI = 2;
        private final Map<b<T>, BdUniqueId> vJ = new HashMap();
        private final com.baidu.adp.lib.g.a vK = new com.baidu.adp.lib.g.a();
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.vG = false;
            this.args = null;
            this.vH = null;
            this.vE = str;
            this.vF = i;
            this.width = i2;
            this.height = i3;
            this.vG = z;
            this.vH = dVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.je();
            if (!this.vJ.containsKey(bVar)) {
                this.vJ.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.je();
            this.vJ.remove(bVar);
            if (bVar != null) {
                bVar.an(this.vE);
            }
            if (this.vJ.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.je();
            if (this.vJ.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.vJ.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.vJ.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.je();
            if (this.vJ.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.vJ.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.vJ.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.d dVar;
            Exception e;
            T t;
            Exception e2;
            Object obj;
            if (this.vH != null) {
                com.baidu.adp.lib.stats.d he = d.he();
                he.hB();
                dVar = he;
            } else {
                dVar = null;
            }
            e eVar = (e) c.this.vA.get(this.vF);
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
            t = (T) eVar.a(this.vE, key, this.vK, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.vH, dVar);
                    }
                    return t;
                } catch (Exception e4) {
                    e = e4;
                    BdLog.e(e.getMessage());
                    T t2 = t;
                    return isCancelled() ? null : null;
                }
            }
            T t22 = t;
            if (isCancelled() && !this.vG) {
                this.vI = 3;
                try {
                    obj = eVar.a(this.vE, key, this.width, this.height, this, this.vK, this.args);
                    try {
                        if (!isCancelled()) {
                            d.b(this.vH, dVar);
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        BdLog.e(e2.getMessage());
                        return (T) obj;
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    obj = t22;
                }
                return (T) obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) c.this.vA.get(this.vF)) != null) {
                eVar.a(c.this.f(this.vE, this.vF), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.vJ.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.a(t, this.vE, this.vI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.vJ.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.vK != null && this.vK.vy != null) {
                this.vK.vy.cancel();
            }
            if (this.vJ.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.vJ.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.an(this.vE);
                    }
                }
                this.vJ.clear();
            }
        }
    }

    private <T> a<T> ao(String str) {
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

    public String f(String str, int i) {
        if (str == null) {
            str = "";
        }
        return String.valueOf(str) + i;
    }
}
