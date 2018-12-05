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
    private static BdAsyncTaskParallel DA = null;
    private static BdAsyncTaskParallel DB = null;
    private static c Dz;
    private final BdUniqueId Dx = BdUniqueId.gen();
    private SparseArray<e<?>> Dy;

    public static c jA() {
        if (Dz == null) {
            synchronized (c.class) {
                if (Dz == null) {
                    Dz = new c();
                }
            }
        }
        return Dz;
    }

    private c() {
        this.Dy = null;
        BdUniqueId gen = BdUniqueId.gen();
        DA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        DB = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.Dy = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.Dy.get(i) == null) {
                this.Dy.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void j(String str, int i) {
        a aV = aV(k(str, i));
        if (aV != null) {
            aV.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> aV = aV(k(str, i));
        if (aV != null) {
            aV.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.Dx);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Dx);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Dx);
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

    public boolean aI(int i) {
        e<?> eVar = this.Dy.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.jD();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.Dy.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.a(k(str, i), str, 0, 0, objArr);
    }

    public <T> Object a(String str, int i, b<T> bVar, BdUniqueId bdUniqueId) {
        return a(str, i, bVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return a(str, i, bVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: com.baidu.adp.lib.f.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        int i4;
        int i5;
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        e<?> eVar = this.Dy.get(i);
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
        String k = k(str, i);
        try {
            Object a2 = eVar.a(k, str, i4, i5, objArr);
            if (a2 != null) {
                if (bVar != 0) {
                    bVar.onLoaded(a2, str, 1);
                }
                return a2;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> aV = aV(k);
        if (aV != null && aV.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            aV.a(bVar, bdUniqueId);
        } else {
            boolean kW = j.kW();
            boolean kY = j.kY();
            com.baidu.adp.lib.stats.a aVar = null;
            if (kW) {
                aVar = d.jB();
                aVar.startTimer();
            }
            a aVar2 = new a(str, i, i4, i5, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(k);
            aVar2.setTag(this.Dx);
            int jF = eVar.jF();
            if (jF == 0) {
                jF = 1;
            }
            aVar2.setPriority(jF);
            if (kW || kY) {
                if (eVar.jE() == null) {
                    aVar2.setParallel(DB);
                } else {
                    aVar2.setParallel(eVar.jE());
                }
            } else {
                aVar2.setParallel(DA);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String DC;
        private final int DD;
        private boolean DE;
        private com.baidu.adp.lib.stats.a DF;
        private int DG = 2;
        private final Map<b<T>, BdUniqueId> DH = new HashMap();
        private final com.baidu.adp.lib.f.a DI = new com.baidu.adp.lib.f.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.DE = false;
            this.args = null;
            this.DF = null;
            this.DC = str;
            this.DD = i;
            this.width = i2;
            this.height = i3;
            this.DE = z;
            this.DF = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.lj();
            if (!this.DH.containsKey(bVar)) {
                this.DH.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.lj();
            this.DH.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.DC);
            }
            if (this.DH.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.lj();
            if (this.DH.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.DH.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.DH.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.lj();
            if (this.DH.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.DH.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.DH.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.a aVar;
            Exception e;
            T t;
            T t2;
            Exception e2;
            Object obj;
            if (this.DF != null) {
                com.baidu.adp.lib.stats.a jB = d.jB();
                jB.startTimer();
                aVar = jB;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.Dy.get(this.DD);
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
            t = (T) eVar.a(this.DC, key, this.width, this.height, this.DI, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.DF, aVar);
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
            if (isCancelled() && !this.DE) {
                this.DG = 3;
                try {
                    obj = eVar.a(this.DC, key, this.width, this.height, this, this.DI, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.DF, aVar);
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
            if (t != null && (eVar = (e) c.this.Dy.get(this.DD)) != null) {
                eVar.a(c.this.k(this.DC, this.DD), t, this.width, this.height, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.DH.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.DC, this.DG);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.DH.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.DI != null && this.DI.Dw != null) {
                this.DI.Dw.cancel();
            }
            if (this.DH.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.DH.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.DC);
                    }
                }
                this.DH.clear();
            }
        }
    }

    private <T> a<T> aV(String str) {
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

    public String k(String str, int i) {
        if (str == null) {
            str = "";
        }
        return str + i;
    }
}
