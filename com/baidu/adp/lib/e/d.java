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
public class d {
    private static d Nq;
    private static BdAsyncTaskParallel Nr = null;
    private static BdAsyncTaskParallel Ns = null;
    private final BdUniqueId No = BdUniqueId.gen();
    private SparseArray<e<?>> Np;

    public static d mx() {
        if (Nq == null) {
            synchronized (d.class) {
                if (Nq == null) {
                    Nq = new d();
                }
            }
        }
        return Nq;
    }

    private d() {
        this.Np = null;
        BdUniqueId gen = BdUniqueId.gen();
        Nr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        Ns = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.Np = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.Np.get(i) == null) {
                this.Np.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void l(String str, int i) {
        a bR = bR(genCacheKey(str, i));
        if (bR != null) {
            bR.cancel();
        }
    }

    public <T> void a(String str, int i, c<T> cVar) {
        a<T> bR = bR(genCacheKey(str, i));
        if (bR != null) {
            bR.a(cVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.No);
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

    public <T> void a(BdUniqueId bdUniqueId, c<T> cVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.No);
        if (searchWaitingTask != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).b(bdUniqueId, cVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.No);
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

    public boolean ax(int i) {
        e<?> eVar = this.Np.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.my();
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.Np.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.a(genCacheKey(str, i), str, 0, 0, false, objArr);
    }

    public <T> Object a(String str, int i, c<T> cVar, BdUniqueId bdUniqueId) {
        return a(str, i, cVar, 0, 0, bdUniqueId, new Object[0]);
    }

    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        return a(str, i, cVar, i2, i3, false, bdUniqueId, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: com.baidu.adp.lib.e.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, c<T> cVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        e<?> eVar;
        int i4;
        int i5;
        if (TextUtils.isEmpty(str) || (eVar = this.Np.get(i)) == null) {
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
            Object a2 = eVar.a(genCacheKey, str, i4, i5, true, objArr);
            if (a2 != null) {
                if (cVar != 0) {
                    cVar.onLoaded(a2, str, 1);
                }
                return a2;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> bR = bR(genCacheKey);
        if (bR != null && bR.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            bR.a(cVar, bdUniqueId);
        } else {
            boolean isWifiNet = j.isWifiNet();
            boolean is4GNet = j.is4GNet();
            a aVar = new a(str, i, i4, i5, bdUniqueId, cVar, z, objArr);
            aVar.setKey(genCacheKey);
            aVar.setTag(this.No);
            int mA = eVar.mA();
            if (mA == 0) {
                mA = 1;
            }
            aVar.setPriority(mA);
            if (isWifiNet || is4GNet) {
                if (eVar.mz() == null) {
                    aVar.setParallel(Ns);
                } else {
                    aVar.setParallel(eVar.mz());
                }
            } else {
                aVar.setParallel(Nr);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String Nt;
        private final int Nu;
        private boolean Nv;
        private Object[] args;
        private int height;
        private int width;
        private int Nw = 2;
        private final Map<c<T>, BdUniqueId> Ny = new HashMap();
        private final b Nz = new b();
        private long Nx = System.currentTimeMillis();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.Nv = false;
            this.args = null;
            this.Nt = str;
            this.Nu = i;
            this.width = i2;
            this.height = i3;
            this.Nv = z;
            this.args = objArr;
            a(cVar, bdUniqueId);
        }

        public void a(c<T> cVar, BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (!this.Ny.containsKey(cVar)) {
                this.Ny.put(cVar, bdUniqueId);
            }
        }

        public void a(c<T> cVar) {
            l.checkMainThread();
            this.Ny.remove(cVar);
            if (cVar != null) {
                cVar.onCancelled(this.Nt);
            }
            if (this.Ny.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, c<T> cVar) {
            l.checkMainThread();
            if (this.Ny.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.Ny.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<c<T>, BdUniqueId> next = it.next();
                c<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == cVar) {
                    it.remove();
                }
            }
            if (this.Ny.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (this.Ny.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.Ny.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.Ny.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            Object obj;
            com.baidu.adp.lib.e.a.d(true, System.currentTimeMillis() - this.Nx);
            e eVar = (e) d.this.Np.get(this.Nu);
            if (eVar == null) {
                return null;
            }
            String key = getKey();
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                obj = null;
            }
            if (isCancelled()) {
                return null;
            }
            T t = (T) eVar.a(this.Nt, key, this.width, this.height, this.Nz, this.args);
            if (t != null) {
                return t;
            }
            obj = t;
            if (isCancelled() || this.Nv) {
                return null;
            }
            this.Nw = 3;
            try {
                obj = eVar.b(this.Nt, key, this.width, this.height, this.Nz, this.args);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return (T) obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.Np.get(this.Nu)) != null) {
                eVar.a(d.this.genCacheKey(this.Nt, this.Nu), t, this.width, this.height, this.args);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.Ny.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.Nt, this.Nw);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.Ny.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.Nz != null && this.Nz.Nn != null) {
                this.Nz.Nn.cancel();
            }
            if (this.Ny.size() != 0) {
                for (Map.Entry<c<T>, BdUniqueId> entry : this.Ny.entrySet()) {
                    c<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.Nt);
                    }
                }
                this.Ny.clear();
            }
        }
    }

    private <T> a<T> bR(String str) {
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

    public e ay(int i) {
        if (this.Np == null) {
            return null;
        }
        return this.Np.get(i);
    }
}
