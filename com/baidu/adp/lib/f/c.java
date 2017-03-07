package com.baidu.adp.lib.f;

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
    private static c wC;
    private static BdAsyncTaskParallel wD = null;
    private static BdAsyncTaskParallel wE = null;
    private final BdUniqueId wA = BdUniqueId.gen();
    private SparseArray<e<?>> wB;

    public static c fG() {
        if (wC == null) {
            synchronized (c.class) {
                if (wC == null) {
                    wC = new c();
                }
            }
        }
        return wC;
    }

    private c() {
        this.wB = null;
        BdUniqueId gen = BdUniqueId.gen();
        wD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        wE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.wB = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.wB.get(i) == null) {
                this.wB.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a ah = ah(f(str, i));
        if (ah != null) {
            ah.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> ah = ah(f(str, i));
        if (ah != null) {
            ah.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.wA);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wA);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wA);
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

    public boolean am(int i) {
        e<?> eVar = this.wB.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.fJ();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.wB.get(i);
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
        e<?> eVar = this.wB.get(i);
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
        a<T> ah = ah(f);
        if (ah != null && ah.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ah.a(bVar, bdUniqueId);
        } else {
            boolean hf = i.hf();
            boolean hh = i.hh();
            com.baidu.adp.lib.stats.c cVar = null;
            if (hf) {
                cVar = d.fH();
                cVar.fQ();
            }
            a aVar = new a(str, i, i2, i3, bdUniqueId, bVar, z, cVar, objArr);
            aVar.setKey(f);
            aVar.setTag(this.wA);
            int fL = eVar.fL();
            if (fL == 0) {
                fL = 1;
            }
            aVar.setPriority(fL);
            if (hf || hh) {
                if (eVar.fK() == null) {
                    aVar.setParallel(wE);
                } else {
                    aVar.setParallel(eVar.fK());
                }
            } else {
                aVar.setParallel(wD);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private final String wF;
        private final int wG;
        private boolean wH;
        private com.baidu.adp.lib.stats.c wI;
        private int wJ = 2;
        private final Map<b<T>, BdUniqueId> wK = new HashMap();
        private final com.baidu.adp.lib.f.a wL = new com.baidu.adp.lib.f.a();
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.c cVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.wH = false;
            this.args = null;
            this.wI = null;
            this.wF = str;
            this.wG = i;
            this.width = i2;
            this.height = i3;
            this.wH = z;
            this.wI = cVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.ht();
            if (!this.wK.containsKey(bVar)) {
                this.wK.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.ht();
            this.wK.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.wF);
            }
            if (this.wK.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.ht();
            if (this.wK.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.wK.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.wK.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.ht();
            if (this.wK.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.wK.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.wK.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.c cVar;
            Exception e;
            T t;
            Exception e2;
            Object obj;
            if (this.wI != null) {
                com.baidu.adp.lib.stats.c fH = d.fH();
                fH.fQ();
                cVar = fH;
            } else {
                cVar = null;
            }
            e eVar = (e) c.this.wB.get(this.wG);
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
            t = (T) eVar.a(this.wF, key, this.wL, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.wI, cVar);
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
            if (isCancelled() && !this.wH) {
                this.wJ = 3;
                try {
                    obj = eVar.a(this.wF, key, this.width, this.height, this, this.wL, this.args);
                    try {
                        if (!isCancelled()) {
                            d.b(this.wI, cVar);
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
            if (t != null && (eVar = (e) c.this.wB.get(this.wG)) != null) {
                eVar.a(c.this.f(this.wF, this.wG), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.wK.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.wF, this.wJ);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.wK.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.wL != null && this.wL.wz != null) {
                this.wL.wz.cancel();
            }
            if (this.wK.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.wK.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.wF);
                    }
                }
                this.wK.clear();
            }
        }
    }

    private <T> a<T> ah(String str) {
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
