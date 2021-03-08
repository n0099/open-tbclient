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
    private static d OP;
    private static BdAsyncTaskParallel OQ = null;
    private static BdAsyncTaskParallel OR = null;
    private final BdUniqueId OM = BdUniqueId.gen();
    private SparseArray<e<?>> OO;

    public static d mw() {
        if (OP == null) {
            synchronized (d.class) {
                if (OP == null) {
                    OP = new d();
                }
            }
        }
        return OP;
    }

    private d() {
        this.OO = null;
        BdUniqueId gen = BdUniqueId.gen();
        OQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        OR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.OO = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.OO.get(i) == null) {
                this.OO.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void l(String str, int i) {
        a bV = bV(genCacheKey(str, i));
        if (bV != null) {
            bV.cancel();
        }
    }

    public <T> void a(String str, int i, c<T> cVar) {
        a<T> bV = bV(genCacheKey(str, i));
        if (bV != null) {
            bV.a(cVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.OM);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.OM);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.OM);
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
        e<?> eVar = this.OO.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.mx();
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e<?> eVar = this.OO.get(i);
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
        if (TextUtils.isEmpty(str) || (eVar = this.OO.get(i)) == null) {
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
        a<T> bV = bV(genCacheKey);
        if (bV != null && bV.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            bV.a(cVar, bdUniqueId);
        } else {
            boolean isWifiNet = j.isWifiNet();
            boolean is4GNet = j.is4GNet();
            a aVar = new a(str, i, i4, i5, bdUniqueId, cVar, z, objArr);
            aVar.setKey(genCacheKey);
            aVar.setTag(this.OM);
            int mz = eVar.mz();
            if (mz == 0) {
                mz = 1;
            }
            aVar.setPriority(mz);
            if (isWifiNet || is4GNet) {
                if (eVar.my() == null) {
                    aVar.setParallel(OR);
                } else {
                    aVar.setParallel(eVar.my());
                }
            } else {
                aVar.setParallel(OQ);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String OT;
        private final int OU;
        private boolean OV;
        private Object[] args;
        private int height;
        private int width;
        private int OW = 2;
        private final Map<c<T>, BdUniqueId> OY = new HashMap();
        private final b OZ = new b();
        private long OX = System.currentTimeMillis();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.OV = false;
            this.args = null;
            this.OT = str;
            this.OU = i;
            this.width = i2;
            this.height = i3;
            this.OV = z;
            this.args = objArr;
            a(cVar, bdUniqueId);
        }

        public void a(c<T> cVar, BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (!this.OY.containsKey(cVar)) {
                this.OY.put(cVar, bdUniqueId);
            }
        }

        public void a(c<T> cVar) {
            l.checkMainThread();
            this.OY.remove(cVar);
            if (cVar != null) {
                cVar.onCancelled(this.OT);
            }
            if (this.OY.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, c<T> cVar) {
            l.checkMainThread();
            if (this.OY.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.OY.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<c<T>, BdUniqueId> next = it.next();
                c<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == cVar) {
                    it.remove();
                }
            }
            if (this.OY.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.checkMainThread();
            if (this.OY.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.OY.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.OY.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public T doInBackground(String... strArr) {
            Object obj;
            com.baidu.adp.lib.e.a.e(true, System.currentTimeMillis() - this.OX);
            e eVar = (e) d.this.OO.get(this.OU);
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
            T t = (T) eVar.a(this.OT, key, this.width, this.height, this.OZ, this.args);
            if (t != null) {
                return t;
            }
            obj = t;
            if (isCancelled() || this.OV) {
                return null;
            }
            this.OW = 3;
            try {
                obj = eVar.b(this.OT, key, this.width, this.height, this.OZ, this.args);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return (T) obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            if (t != null && (eVar = (e) d.this.OO.get(this.OU)) != null) {
                eVar.a(d.this.genCacheKey(this.OT, this.OU), t, this.width, this.height, this.args);
            }
            for (Map.Entry<c<T>, BdUniqueId> entry : this.OY.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.OT, this.OW);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.OY.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.OZ != null && this.OZ.OL != null) {
                this.OZ.OL.cancel();
            }
            if (this.OY.size() != 0) {
                for (Map.Entry<c<T>, BdUniqueId> entry : this.OY.entrySet()) {
                    c<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.OT);
                    }
                }
                this.OY.clear();
            }
        }
    }

    private <T> a<T> bV(String str) {
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
        if (this.OO == null) {
            return null;
        }
        return this.OO.get(i);
    }
}
