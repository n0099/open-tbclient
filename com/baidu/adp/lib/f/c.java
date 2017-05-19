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
    private static c wk;
    private static BdAsyncTaskParallel wl = null;
    private static BdAsyncTaskParallel wm = null;
    private final BdUniqueId wi = BdUniqueId.gen();
    private SparseArray<e<?>> wj;

    public static c fM() {
        if (wk == null) {
            synchronized (c.class) {
                if (wk == null) {
                    wk = new c();
                }
            }
        }
        return wk;
    }

    private c() {
        this.wj = null;
        BdUniqueId gen = BdUniqueId.gen();
        wl = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        wm = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.wj = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.wj.get(i) == null) {
                this.wj.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a ad = ad(f(str, i));
        if (ad != null) {
            ad.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> ad = ad(f(str, i));
        if (ad != null) {
            ad.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.wi);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wi);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wi);
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

    public boolean ak(int i) {
        e<?> eVar = this.wj.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.fP();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.wj.get(i);
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
        e<?> eVar = this.wj.get(i);
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
        a<T> ad = ad(f);
        if (ad != null && ad.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ad.a(bVar, bdUniqueId);
        } else {
            boolean hl = i.hl();
            boolean hn = i.hn();
            com.baidu.adp.lib.stats.c cVar = null;
            if (hl) {
                cVar = d.fN();
                cVar.fW();
            }
            a aVar = new a(str, i, i2, i3, bdUniqueId, bVar, z, cVar, objArr);
            aVar.setKey(f);
            aVar.setTag(this.wi);
            int fR = eVar.fR();
            if (fR == 0) {
                fR = 1;
            }
            aVar.setPriority(fR);
            if (hl || hn) {
                if (eVar.fQ() == null) {
                    aVar.setParallel(wm);
                } else {
                    aVar.setParallel(eVar.fQ());
                }
            } else {
                aVar.setParallel(wl);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private int width;
        private final String wn;
        private final int wo;
        private boolean wp;
        private com.baidu.adp.lib.stats.c wq;
        private int wr = 2;
        private final Map<b<T>, BdUniqueId> ws = new HashMap();
        private final com.baidu.adp.lib.f.a wt = new com.baidu.adp.lib.f.a();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.c cVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.wp = false;
            this.args = null;
            this.wq = null;
            this.wn = str;
            this.wo = i;
            this.width = i2;
            this.height = i3;
            this.wp = z;
            this.wq = cVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.hz();
            if (!this.ws.containsKey(bVar)) {
                this.ws.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.hz();
            this.ws.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.wn);
            }
            if (this.ws.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.hz();
            if (this.ws.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.ws.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.ws.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.hz();
            if (this.ws.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.ws.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.ws.size() == 0) {
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
            if (this.wq != null) {
                com.baidu.adp.lib.stats.c fN = d.fN();
                fN.fW();
                cVar = fN;
            } else {
                cVar = null;
            }
            e eVar = (e) c.this.wj.get(this.wo);
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
            t = (T) eVar.a(this.wn, key, this.wt, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.wq, cVar);
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
            if (isCancelled() && !this.wp) {
                this.wr = 3;
                try {
                    obj = eVar.a(this.wn, key, this.width, this.height, this, this.wt, this.args);
                    try {
                        if (!isCancelled()) {
                            d.b(this.wq, cVar);
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
            if (t != null && (eVar = (e) c.this.wj.get(this.wo)) != null) {
                eVar.a(c.this.f(this.wn, this.wo), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.ws.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.wn, this.wr);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.ws.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.wt != null && this.wt.wh != null) {
                this.wt.wh.cancel();
            }
            if (this.ws.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.ws.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.wn);
                    }
                }
                this.ws.clear();
            }
        }
    }

    private <T> a<T> ad(String str) {
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
