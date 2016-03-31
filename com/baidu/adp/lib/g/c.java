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
    private static c we;
    private static BdAsyncTaskParallel wf = null;
    private static BdAsyncTaskParallel wg = null;
    private final BdUniqueId wc = BdUniqueId.gen();
    private SparseArray<e<?>> wd;

    public static c hr() {
        if (we == null) {
            synchronized (c.class) {
                if (we == null) {
                    we = new c();
                }
            }
        }
        return we;
    }

    private c() {
        this.wd = null;
        BdUniqueId gen = BdUniqueId.gen();
        wf = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        wg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.wd = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.wd.get(i) == null) {
                this.wd.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a ap = ap(f(str, i));
        if (ap != null) {
            ap.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> ap = ap(f(str, i));
        if (ap != null) {
            ap.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.wc);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wc);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.wc);
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

    public boolean ah(int i) {
        e<?> eVar = this.wd.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.hu();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.wd.get(i);
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
        e<?> eVar = this.wd.get(i);
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
        a<T> ap = ap(f);
        if (ap != null && ap.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            ap.a(bVar, bdUniqueId);
        } else {
            boolean jg = i.jg();
            boolean ji = i.ji();
            com.baidu.adp.lib.stats.d dVar = null;
            if (jg) {
                dVar = d.hs();
                dVar.hP();
            }
            a aVar = new a(str, i, i2, i3, bdUniqueId, bVar, z, dVar, objArr);
            aVar.setKey(f);
            aVar.setTag(this.wc);
            int hw = eVar.hw();
            if (hw == 0) {
                hw = 1;
            }
            aVar.setPriority(hw);
            if (jg || ji) {
                if (eVar.hv() == null) {
                    aVar.setParallel(wg);
                } else {
                    aVar.setParallel(eVar.hv());
                }
            } else {
                aVar.setParallel(wf);
            }
            aVar.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private Object[] args;
        private int height;
        private final String wh;
        private final int wi;
        private int width;
        private boolean wj;
        private com.baidu.adp.lib.stats.d wk;
        private int wl = 2;
        private final Map<b<T>, BdUniqueId> wm = new HashMap();
        private final com.baidu.adp.lib.g.a wn = new com.baidu.adp.lib.g.a();

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.wj = false;
            this.args = null;
            this.wk = null;
            this.wh = str;
            this.wi = i;
            this.width = i2;
            this.height = i3;
            this.wj = z;
            this.wk = dVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            k.ju();
            if (!this.wm.containsKey(bVar)) {
                this.wm.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            k.ju();
            this.wm.remove(bVar);
            if (bVar != null) {
                bVar.ao(this.wh);
            }
            if (this.wm.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            k.ju();
            if (this.wm.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.wm.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.wm.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            k.ju();
            if (this.wm.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.wm.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.wm.size() == 0) {
                cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public T doInBackground(String... strArr) {
            com.baidu.adp.lib.stats.d dVar;
            Exception e;
            T t;
            Exception e2;
            Object obj;
            if (this.wk != null) {
                com.baidu.adp.lib.stats.d hs = d.hs();
                hs.hP();
                dVar = hs;
            } else {
                dVar = null;
            }
            e eVar = (e) c.this.wd.get(this.wi);
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
            t = (T) eVar.a(this.wh, key, this.wn, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.wk, dVar);
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
            if (isCancelled() && !this.wj) {
                this.wl = 3;
                try {
                    obj = eVar.a(this.wh, key, this.width, this.height, this, this.wn, this.args);
                    try {
                        if (!isCancelled()) {
                            d.b(this.wk, dVar);
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
            if (t != null && (eVar = (e) c.this.wd.get(this.wi)) != null) {
                eVar.a(c.this.f(this.wh, this.wi), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.wm.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.a(t, this.wh, this.wl);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.wm.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.wn != null && this.wn.wb != null) {
                this.wn.wb.cancel();
            }
            if (this.wm.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.wm.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.ao(this.wh);
                    }
                }
                this.wm.clear();
            }
        }
    }

    private <T> a<T> ap(String str) {
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
