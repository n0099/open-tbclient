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
    private static c lX;
    private static BdAsyncTaskParallel lY = null;
    private static BdAsyncTaskParallel lZ = null;
    private final BdUniqueId lV = BdUniqueId.gen();
    private SparseArray<e<?>> lW;

    public static c dG() {
        if (lX == null) {
            synchronized (c.class) {
                if (lX == null) {
                    lX = new c();
                }
            }
        }
        return lX;
    }

    private c() {
        this.lW = null;
        BdUniqueId gen = BdUniqueId.gen();
        lY = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        lZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.lW = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.lW.get(i) == null) {
                this.lW.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a ag = ag(f(str, i));
        if (ag != null) {
            ag.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> ag = ag(f(str, i));
        if (ag != null) {
            ag.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.lV);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.lV);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.lV);
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

    public boolean V(int i) {
        e<?> eVar = this.lW.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.dJ();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.lW.get(i);
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

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: com.baidu.adp.lib.g.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        e<?> eVar = this.lW.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String f = f(str, i);
        try {
            Object b = eVar.b(f, str, objArr);
            if (b != null) {
                if (bVar != 0) {
                    bVar.a(b, str, 1);
                    return b;
                }
                return b;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> ag = ag(f);
        if (ag != null && ag.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ag.a(bVar, bdUniqueId);
        } else {
            boolean fs = i.fs();
            boolean fu = i.fu();
            com.baidu.adp.lib.stats.d dVar = null;
            if (fs) {
                dVar = d.dH();
                dVar.ee();
            }
            a aVar = new a(str, i, i2, i3, bdUniqueId, bVar, z, dVar, objArr);
            aVar.setKey(f);
            aVar.setTag(this.lV);
            int dL = eVar.dL();
            if (dL == 0) {
                dL = 1;
            }
            aVar.setPriority(dL);
            if (fs || fu) {
                if (eVar.dK() == null) {
                    aVar.setParallel(lZ);
                } else {
                    aVar.setParallel(eVar.dK());
                }
            } else {
                aVar.setParallel(lY);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private final String ma;
        private final int mb;
        private boolean mc;
        private com.baidu.adp.lib.stats.d md;
        private int mf = 2;
        private final Map<b<T>, BdUniqueId> mg = new HashMap();
        private final com.baidu.adp.lib.g.a mh = new com.baidu.adp.lib.g.a();
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.mc = false;
            this.args = null;
            this.md = null;
            this.ma = str;
            this.mb = i;
            this.width = i2;
            this.height = i3;
            this.mc = z;
            this.md = dVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.fG();
            if (!this.mg.containsKey(bVar)) {
                this.mg.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.fG();
            this.mg.remove(bVar);
            if (bVar != null) {
                bVar.af(this.ma);
            }
            if (this.mg.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.fG();
            if (this.mg.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.mg.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.mg.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.fG();
            if (this.mg.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.mg.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.mg.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.d dVar;
            Exception e;
            T t;
            Exception e2;
            Object obj;
            if (this.md != null) {
                com.baidu.adp.lib.stats.d dH = d.dH();
                dH.ee();
                dVar = dH;
            } else {
                dVar = null;
            }
            e eVar = (e) c.this.lW.get(this.mb);
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
            t = (T) eVar.a(this.ma, key, this.mh, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.md, dVar);
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
            if (isCancelled() && !this.mc) {
                this.mf = 3;
                try {
                    obj = eVar.a(this.ma, key, this.width, this.height, this, this.mh, this.args);
                    try {
                        if (!isCancelled()) {
                            d.b(this.md, dVar);
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
            if (t != null && (eVar = (e) c.this.lW.get(this.mb)) != null) {
                eVar.a(c.this.f(this.ma, this.mb), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.mg.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.a(t, this.ma, this.mf);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.mg.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.mh != null && this.mh.lU != null) {
                this.mh.lU.cancel();
            }
            if (this.mg.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.mg.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.af(this.ma);
                    }
                }
                this.mg.clear();
            }
        }
    }

    private <T> a<T> ag(String str) {
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
