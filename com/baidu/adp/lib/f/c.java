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
    private static c xO;
    private static BdAsyncTaskParallel xP = null;
    private static BdAsyncTaskParallel xQ = null;
    private final BdUniqueId xM = BdUniqueId.gen();
    private SparseArray<e<?>> xN;

    public static c fU() {
        if (xO == null) {
            synchronized (c.class) {
                if (xO == null) {
                    xO = new c();
                }
            }
        }
        return xO;
    }

    private c() {
        this.xN = null;
        BdUniqueId gen = BdUniqueId.gen();
        xP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        xQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.xN = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.xN.get(i) == null) {
                this.xN.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a ar = ar(f(str, i));
        if (ar != null) {
            ar.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> ar = ar(f(str, i));
        if (ar != null) {
            ar.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.xM);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.xM);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.xM);
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
        e<?> eVar = this.xN.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.fX();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.xN.get(i);
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
        e<?> eVar = this.xN.get(i);
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
        a<T> ar = ar(f);
        if (ar != null && ar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ar.a(bVar, bdUniqueId);
        } else {
            boolean hs = i.hs();
            boolean hu = i.hu();
            com.baidu.adp.lib.stats.a aVar = null;
            if (hs) {
                aVar = d.fV();
                aVar.startTimer();
            }
            a aVar2 = new a(str, i, i2, i3, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(f);
            aVar2.setTag(this.xM);
            int fZ = eVar.fZ();
            if (fZ == 0) {
                fZ = 1;
            }
            aVar2.setPriority(fZ);
            if (hs || hu) {
                if (eVar.fY() == null) {
                    aVar2.setParallel(xQ);
                } else {
                    aVar2.setParallel(eVar.fY());
                }
            } else {
                aVar2.setParallel(xP);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private int width;
        private final String xR;
        private final int xS;
        private boolean xT;
        private com.baidu.adp.lib.stats.a xU;
        private int xV = 2;
        private final Map<b<T>, BdUniqueId> xW = new HashMap();
        private final com.baidu.adp.lib.f.a xX = new com.baidu.adp.lib.f.a();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.xT = false;
            this.args = null;
            this.xU = null;
            this.xR = str;
            this.xS = i;
            this.width = i2;
            this.height = i3;
            this.xT = z;
            this.xU = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.hG();
            if (!this.xW.containsKey(bVar)) {
                this.xW.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.hG();
            this.xW.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.xR);
            }
            if (this.xW.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.hG();
            if (this.xW.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.xW.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.xW.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.hG();
            if (this.xW.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.xW.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.xW.size() == 0) {
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
            if (this.xU != null) {
                com.baidu.adp.lib.stats.a fV = d.fV();
                fV.startTimer();
                aVar = fV;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.xN.get(this.xS);
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
            t = (T) eVar.a(this.xR, key, this.xX, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.xU, aVar);
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
            if (isCancelled() && !this.xT) {
                this.xV = 3;
                try {
                    obj = eVar.a(this.xR, key, this.width, this.height, this, this.xX, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.xU, aVar);
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
            if (t != null && (eVar = (e) c.this.xN.get(this.xS)) != null) {
                eVar.a(c.this.f(this.xR, this.xS), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.xW.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.xR, this.xV);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.xW.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.xX != null && this.xX.xL != null) {
                this.xX.xL.cancel();
            }
            if (this.xW.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.xW.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.xR);
                    }
                }
                this.xW.clear();
            }
        }
    }

    private <T> a<T> ar(String str) {
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
