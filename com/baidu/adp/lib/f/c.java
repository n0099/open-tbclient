package com.baidu.adp.lib.f;

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
    private static c vI;
    private static BdAsyncTaskParallel vJ = null;
    private static BdAsyncTaskParallel vK = null;
    private final BdUniqueId vG = BdUniqueId.gen();
    private SparseArray<e<?>> vH;

    public static c fJ() {
        if (vI == null) {
            synchronized (c.class) {
                if (vI == null) {
                    vI = new c();
                }
            }
        }
        return vI;
    }

    private c() {
        this.vH = null;
        BdUniqueId gen = BdUniqueId.gen();
        vJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        vK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.vH = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.vH.get(i) == null) {
                this.vH.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a al = al(f(str, i));
        if (al != null) {
            al.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> al = al(f(str, i));
        if (al != null) {
            al.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.vG);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.vG);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.vG);
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
        e<?> eVar = this.vH.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.fM();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.vH.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.b(f(str, i), str, objArr);
    }

    public <T> Object a(String str, int i, b<T> bVar, BdUniqueId bdUniqueId) {
        return a(str, i, bVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return a(str, i, bVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: com.baidu.adp.lib.f.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        e<?> eVar = this.vH.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String f = f(str, i);
        try {
            Object b = eVar.b(f, str, objArr);
            if (b != null) {
                if (bVar != 0) {
                    bVar.onLoaded(b, str, 1);
                    return b;
                }
                return b;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> al = al(f);
        if (al != null && al.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            al.a(bVar, bdUniqueId);
        } else {
            boolean hi = j.hi();
            boolean hk = j.hk();
            com.baidu.adp.lib.stats.a aVar = null;
            if (hi) {
                aVar = d.fK();
                aVar.fT();
            }
            a aVar2 = new a(str, i, i2, i3, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(f);
            aVar2.setTag(this.vG);
            int fO = eVar.fO();
            if (fO == 0) {
                fO = 1;
            }
            aVar2.setPriority(fO);
            if (hi || hk) {
                if (eVar.fN() == null) {
                    aVar2.setParallel(vK);
                } else {
                    aVar2.setParallel(eVar.fN());
                }
            } else {
                aVar2.setParallel(vJ);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private final String vL;
        private final int vM;
        private boolean vN;
        private com.baidu.adp.lib.stats.a vO;
        private int vP = 2;
        private final Map<b<T>, BdUniqueId> vQ = new HashMap();
        private final com.baidu.adp.lib.f.a vR = new com.baidu.adp.lib.f.a();
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.vN = false;
            this.args = null;
            this.vO = null;
            this.vL = str;
            this.vM = i;
            this.width = i2;
            this.height = i3;
            this.vN = z;
            this.vO = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.hw();
            if (!this.vQ.containsKey(bVar)) {
                this.vQ.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.hw();
            this.vQ.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.vL);
            }
            if (this.vQ.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.hw();
            if (this.vQ.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.vQ.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.vQ.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.hw();
            if (this.vQ.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.vQ.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.vQ.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.a aVar;
            Exception e;
            T t;
            T t2;
            Exception e2;
            Object obj;
            if (this.vO != null) {
                com.baidu.adp.lib.stats.a fK = d.fK();
                fK.fT();
                aVar = fK;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.vH.get(this.vM);
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
            t = (T) eVar.a(this.vL, key, this.vR, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.vO, aVar);
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
            if (isCancelled() && !this.vN) {
                this.vP = 3;
                try {
                    obj = eVar.a(this.vL, key, this.width, this.height, this, this.vR, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.vO, aVar);
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
            if (t != null && (eVar = (e) c.this.vH.get(this.vM)) != null) {
                eVar.a(c.this.f(this.vL, this.vM), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.vQ.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.vL, this.vP);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.vQ.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.vR != null && this.vR.vF != null) {
                this.vR.vF.cancel();
            }
            if (this.vQ.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.vQ.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.vL);
                    }
                }
                this.vQ.clear();
            }
        }
    }

    private <T> a<T> al(String str) {
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
        return str + i;
    }
}
