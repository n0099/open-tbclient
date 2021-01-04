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
    private static d Ns;
    private static BdAsyncTaskParallel Nt = null;
    private static BdAsyncTaskParallel Nu = null;
    private final BdUniqueId Nq = BdUniqueId.gen();
    private SparseArray<e<?>> Nr;

    public static d mx() {
        if (Ns == null) {
            synchronized (d.class) {
                if (Ns == null) {
                    Ns = new d();
                }
            }
        }
        return Ns;
    }

    private d() {
        this.Nr = null;
        BdUniqueId gen = BdUniqueId.gen();
        Nt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        Nu = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.Nr = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.Nr.get(i) == null) {
                this.Nr.put(i, eVar);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.Nq);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Nq);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Nq);
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
        e<?> eVar = this.Nr.get(i);
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
        e<?> eVar = this.Nr.get(i);
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
        if (TextUtils.isEmpty(str) || (eVar = this.Nr.get(i)) == null) {
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
            aVar.setTag(this.Nq);
            int mA = eVar.mA();
            if (mA == 0) {
                mA = 1;
            }
            aVar.setPriority(mA);
            if (isWifiNet || is4GNet) {
                if (eVar.mz() == null) {
                    aVar.setParallel(Nu);
                } else {
                    aVar.setParallel(eVar.mz());
                }
            } else {
                aVar.setParallel(Nt);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String Nv;
        private final int Nw;
        private boolean Nx;
        private Object[] args;
        private int height;
        private int width;
        private int Ny = 2;
        private final Map<c<T>, BdUniqueId> NC = new HashMap();
        private final b ND = new b();
        private long Nz = System.currentTimeMillis();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.Nx = false;
            this.args = null;
            this.Nv = str;
            this.Nw = i;
            this.width = i2;
            this.height = i3;
            this.Nx = z;
            this.args = objArr;
            a(cVar, bdUniqueId);
        }

        public void a(c<T> cVar, BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (!this.NC.containsKey(cVar)) {
                this.NC.put(cVar, bdUniqueId);
            }
        }

        public void a(c<T> cVar) {
            l.checkMainThread();
            this.NC.remove(cVar);
            if (cVar != null) {
                cVar.onCancelled(this.Nv);
            }
            if (this.NC.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, c<T> cVar) {
            l.checkMainThread();
            if (this.NC.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.NC.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<c<T>, BdUniqueId> next = it.next();
                c<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == cVar) {
                    it.remove();
                }
            }
            if (this.NC.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (this.NC.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.NC.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.NC.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            Object obj;
            com.baidu.adp.lib.e.a.d(true, System.currentTimeMillis() - this.Nz);
            e eVar = (e) d.this.Nr.get(this.Nw);
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
            T t = (T) eVar.a(this.Nv, key, this.width, this.height, this.ND, this.args);
            if (t != null) {
                return t;
            }
            obj = t;
            if (isCancelled() || this.Nx) {
                return null;
            }
            this.Ny = 3;
            try {
                obj = eVar.b(this.Nv, key, this.width, this.height, this.ND, this.args);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return (T) obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.Nr.get(this.Nw)) != null) {
                eVar.a(d.this.genCacheKey(this.Nv, this.Nw), t, this.width, this.height, this.args);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.NC.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.Nv, this.Ny);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.NC.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.ND != null && this.ND.Np != null) {
                this.ND.Np.cancel();
            }
            if (this.NC.size() != 0) {
                for (Map.Entry<c<T>, BdUniqueId> entry : this.NC.entrySet()) {
                    c<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.Nv);
                    }
                }
                this.NC.clear();
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
        if (this.Nr == null) {
            return null;
        }
        return this.Nr.get(i);
    }
}
