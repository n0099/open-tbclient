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
    private static c ajT;
    private static BdAsyncTaskParallel ajU = null;
    private static BdAsyncTaskParallel ajV = null;
    private final BdUniqueId ajR = BdUniqueId.gen();
    private SparseArray<e<?>> ajS;

    public static c nl() {
        if (ajT == null) {
            synchronized (c.class) {
                if (ajT == null) {
                    ajT = new c();
                }
            }
        }
        return ajT;
    }

    private c() {
        this.ajS = null;
        BdUniqueId gen = BdUniqueId.gen();
        ajU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        ajV = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.ajS = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.ajS.get(i) == null) {
                this.ajS.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void f(String str, int i) {
        a at = at(g(str, i));
        if (at != null) {
            at.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> at = at(g(str, i));
        if (at != null) {
            at.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.ajR);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.ajR);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.ajR);
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

    public boolean dh(int i) {
        e<?> eVar = this.ajS.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.no();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.ajS.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.f(g(str, i), str, objArr);
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
        e<?> eVar = this.ajS.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String g = g(str, i);
        try {
            Object f = eVar.f(g, str, objArr);
            if (f != null) {
                if (bVar != 0) {
                    bVar.onLoaded(f, str, 1);
                    return f;
                }
                return f;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> at = at(g);
        if (at != null && at.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            at.a(bVar, bdUniqueId);
        } else {
            boolean oJ = j.oJ();
            boolean oL = j.oL();
            com.baidu.adp.lib.stats.a aVar = null;
            if (oJ) {
                aVar = d.nm();
                aVar.nv();
            }
            a aVar2 = new a(str, i, i2, i3, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(g);
            aVar2.setTag(this.ajR);
            int nq = eVar.nq();
            if (nq == 0) {
                nq = 1;
            }
            aVar2.setPriority(nq);
            if (oJ || oL) {
                if (eVar.np() == null) {
                    aVar2.setParallel(ajV);
                } else {
                    aVar2.setParallel(eVar.np());
                }
            } else {
                aVar2.setParallel(ajU);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String ajW;
        private final int ajX;
        private boolean ajY;
        private com.baidu.adp.lib.stats.a ajZ;
        private int aka = 2;
        private final Map<b<T>, BdUniqueId> akb = new HashMap();
        private final com.baidu.adp.lib.f.a akc = new com.baidu.adp.lib.f.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.ajY = false;
            this.args = null;
            this.ajZ = null;
            this.ajW = str;
            this.ajX = i;
            this.width = i2;
            this.height = i3;
            this.ajY = z;
            this.ajZ = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.oX();
            if (!this.akb.containsKey(bVar)) {
                this.akb.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.oX();
            this.akb.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.ajW);
            }
            if (this.akb.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.oX();
            if (this.akb.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.akb.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.akb.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.oX();
            if (this.akb.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.akb.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.akb.size() == 0) {
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
            if (this.ajZ != null) {
                com.baidu.adp.lib.stats.a nm = d.nm();
                nm.nv();
                aVar = nm;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.ajS.get(this.ajX);
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
            t = (T) eVar.a(this.ajW, key, this.akc, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.ajZ, aVar);
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
            if (isCancelled() && !this.ajY) {
                this.aka = 3;
                try {
                    obj = eVar.a(this.ajW, key, this.width, this.height, this, this.akc, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.ajZ, aVar);
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
            if (t != null && (eVar = (e) c.this.ajS.get(this.ajX)) != null) {
                eVar.a(c.this.g(this.ajW, this.ajX), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.akb.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.ajW, this.aka);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.akb.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.akc != null && this.akc.ajQ != null) {
                this.akc.ajQ.cancel();
            }
            if (this.akb.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.akb.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.ajW);
                    }
                }
                this.akb.clear();
            }
        }
    }

    private <T> a<T> at(String str) {
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

    public String g(String str, int i) {
        if (str == null) {
            str = "";
        }
        return str + i;
    }
}
