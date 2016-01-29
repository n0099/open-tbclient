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
    private static c vN;
    private static BdAsyncTaskParallel vO = null;
    private static BdAsyncTaskParallel vP = null;
    private final BdUniqueId vL = BdUniqueId.gen();
    private SparseArray<e<?>> vM;

    public static c hl() {
        if (vN == null) {
            synchronized (c.class) {
                if (vN == null) {
                    vN = new c();
                }
            }
        }
        return vN;
    }

    private c() {
        this.vM = null;
        BdUniqueId gen = BdUniqueId.gen();
        vO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        vP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.vM = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.vM.get(i) == null) {
                this.vM.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a an = an(f(str, i));
        if (an != null) {
            an.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> an = an(f(str, i));
        if (an != null) {
            an.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.vL);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.vL);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.vL);
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

    public boolean ai(int i) {
        e<?> eVar = this.vM.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.ho();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.vM.get(i);
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
        e<?> eVar = this.vM.get(i);
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
        a<T> an = an(f);
        if (an != null && an.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            an.a(bVar, bdUniqueId);
        } else {
            boolean ja = i.ja();
            boolean jc = i.jc();
            com.baidu.adp.lib.stats.d dVar = null;
            if (ja) {
                dVar = d.hm();
                dVar.hJ();
            }
            a aVar = new a(str, i, i2, i3, bdUniqueId, bVar, z, dVar, objArr);
            aVar.setKey(f);
            aVar.setTag(this.vL);
            int hq = eVar.hq();
            if (hq == 0) {
                hq = 1;
            }
            aVar.setPriority(hq);
            if (ja || jc) {
                if (eVar.hp() == null) {
                    aVar.setParallel(vP);
                } else {
                    aVar.setParallel(eVar.hp());
                }
            } else {
                aVar.setParallel(vO);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private final String vQ;
        private final int vR;
        private boolean vS;
        private com.baidu.adp.lib.stats.d vT;
        private int vU = 2;
        private final Map<b<T>, BdUniqueId> vV = new HashMap();
        private final com.baidu.adp.lib.g.a vW = new com.baidu.adp.lib.g.a();
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.vS = false;
            this.args = null;
            this.vT = null;
            this.vQ = str;
            this.vR = i;
            this.width = i2;
            this.height = i3;
            this.vS = z;
            this.vT = dVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.jo();
            if (!this.vV.containsKey(bVar)) {
                this.vV.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.jo();
            this.vV.remove(bVar);
            if (bVar != null) {
                bVar.am(this.vQ);
            }
            if (this.vV.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.jo();
            if (this.vV.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.vV.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.vV.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.jo();
            if (this.vV.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.vV.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.vV.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.d dVar;
            Exception e;
            T t;
            Exception e2;
            Object obj;
            if (this.vT != null) {
                com.baidu.adp.lib.stats.d hm = d.hm();
                hm.hJ();
                dVar = hm;
            } else {
                dVar = null;
            }
            e eVar = (e) c.this.vM.get(this.vR);
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
            t = (T) eVar.a(this.vQ, key, this.vW, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.vT, dVar);
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
            if (isCancelled() && !this.vS) {
                this.vU = 3;
                try {
                    obj = eVar.a(this.vQ, key, this.width, this.height, this, this.vW, this.args);
                    try {
                        if (!isCancelled()) {
                            d.b(this.vT, dVar);
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
            if (t != null && (eVar = (e) c.this.vM.get(this.vR)) != null) {
                eVar.a(c.this.f(this.vQ, this.vR), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.vV.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.a(t, this.vQ, this.vU);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.vV.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.vW != null && this.vW.vK != null) {
                this.vW.vK.cancel();
            }
            if (this.vV.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.vV.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.am(this.vQ);
                    }
                }
                this.vV.clear();
            }
        }
    }

    private <T> a<T> an(String str) {
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
