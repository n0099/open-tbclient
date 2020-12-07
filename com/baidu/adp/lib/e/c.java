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
    private static c NQ;
    private static BdAsyncTaskParallel NR = null;
    private static BdAsyncTaskParallel NT = null;
    private final BdUniqueId NN = BdUniqueId.gen();
    private SparseArray<e<?>> NP;

    public static c mS() {
        if (NQ == null) {
            synchronized (c.class) {
                if (NQ == null) {
                    NQ = new c();
                }
            }
        }
        return NQ;
    }

    private c() {
        this.NP = null;
        BdUniqueId gen = BdUniqueId.gen();
        NR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        NT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.NP = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.NP.get(i) == null) {
                this.NP.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void l(String str, int i) {
        a bX = bX(genCacheKey(str, i));
        if (bX != null) {
            bX.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> bX = bX(genCacheKey(str, i));
        if (bX != null) {
            bX.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.NN);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.NN);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.NN);
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

    public boolean aw(int i) {
        e<?> eVar = this.NP.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.mV();
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.NP.get(i);
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

    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: com.baidu.adp.lib.e.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(String str, int i, b<T> bVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        int i4;
        int i5;
        if (TextUtils.isEmpty(str)) {
            BdLog.e("resKey can not be null");
            return null;
        }
        e<?> eVar = this.NP.get(i);
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
        a<T> bX = bX(genCacheKey);
        if (bX != null && bX.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            bX.a(bVar, bdUniqueId);
        } else {
            boolean isWifiNet = j.isWifiNet();
            boolean is4GNet = j.is4GNet();
            a aVar = new a(str, i, i4, i5, bdUniqueId, bVar, z, objArr);
            aVar.setKey(genCacheKey);
            aVar.setTag(this.NN);
            int mX = eVar.mX();
            if (mX == 0) {
                mX = 1;
            }
            aVar.setPriority(mX);
            if (isWifiNet || is4GNet) {
                if (eVar.mW() == null) {
                    aVar.setParallel(NT);
                } else {
                    aVar.setParallel(eVar.mW());
                }
            } else {
                aVar.setParallel(NR);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String NU;
        private final int NV;
        private boolean NW;
        private int NX = 2;
        private final Map<b<T>, BdUniqueId> NY = new HashMap();
        private final com.baidu.adp.lib.e.a NZ = new com.baidu.adp.lib.e.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.NW = false;
            this.args = null;
            this.NU = str;
            this.NV = i;
            this.width = i2;
            this.height = i3;
            this.NW = z;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (!this.NY.containsKey(bVar)) {
                this.NY.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.checkMainThread();
            this.NY.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.NU);
            }
            if (this.NY.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.checkMainThread();
            if (this.NY.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.NY.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.NY.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (this.NY.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.NY.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.NY.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            Object obj;
            e eVar = (e) c.this.NP.get(this.NV);
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
            T t = (T) eVar.a(this.NU, key, this.width, this.height, this.NZ, this.args);
            if (t != null) {
                return t;
            }
            obj = t;
            if (isCancelled() || this.NW) {
                return null;
            }
            this.NX = 3;
            try {
                obj = eVar.a(this.NU, key, this.width, this.height, this, this.NZ, this.args);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return (T) obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) c.this.NP.get(this.NV)) != null) {
                eVar.a(c.this.genCacheKey(this.NU, this.NV), t, this.width, this.height, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.NY.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.NU, this.NX);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.NY.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.NZ != null && this.NZ.NM != null) {
                this.NZ.NM.cancel();
            }
            if (this.NY.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.NY.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.NU);
                    }
                }
                this.NY.clear();
            }
        }
    }

    private <T> a<T> bX(String str) {
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

    public e ax(int i) {
        if (this.NP == null) {
            return null;
        }
        return this.NP.get(i);
    }
}
