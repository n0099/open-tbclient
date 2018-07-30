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
    private static c Aq;
    private static BdAsyncTaskParallel Ar = null;
    private static BdAsyncTaskParallel As = null;
    private final BdUniqueId Ao = BdUniqueId.gen();
    private SparseArray<e<?>> Ap;

    public static c ih() {
        if (Aq == null) {
            synchronized (c.class) {
                if (Aq == null) {
                    Aq = new c();
                }
            }
        }
        return Aq;
    }

    private c() {
        this.Ap = null;
        BdUniqueId gen = BdUniqueId.gen();
        Ar = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        As = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.Ap = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.Ap.get(i) == null) {
                this.Ap.put(i, eVar);
            } else {
                throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
            }
        }
    }

    public void e(String str, int i) {
        a aF = aF(f(str, i));
        if (aF != null) {
            aF.cancel();
        }
    }

    public <T> void a(String str, int i, b<T> bVar) {
        a<T> aF = aF(f(str, i));
        if (aF != null) {
            aF.a(bVar);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.Ao);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Ao);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.Ao);
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

    public boolean aj(int i) {
        e<?> eVar = this.Ap.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.ik();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.Ap.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        return eVar.f(f(str, i), str, objArr);
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
        e<?> eVar = this.Ap.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return null;
        }
        String f = f(str, i);
        try {
            Object f2 = eVar.f(f, str, objArr);
            if (f2 != null) {
                if (bVar != 0) {
                    bVar.onLoaded(f2, str, 1);
                    return f2;
                }
                return f2;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        a<T> aF = aF(f);
        if (aF != null && aF.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            aF.a(bVar, bdUniqueId);
        } else {
            boolean jF = j.jF();
            boolean jH = j.jH();
            com.baidu.adp.lib.stats.a aVar = null;
            if (jF) {
                aVar = d.ii();
                aVar.ir();
            }
            a aVar2 = new a(str, i, i2, i3, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(f);
            aVar2.setTag(this.Ao);
            int im = eVar.im();
            if (im == 0) {
                im = 1;
            }
            aVar2.setPriority(im);
            if (jF || jH) {
                if (eVar.il() == null) {
                    aVar2.setParallel(As);
                } else {
                    aVar2.setParallel(eVar.il());
                }
            } else {
                aVar2.setParallel(Ar);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String At;
        private final int Au;
        private boolean Av;
        private com.baidu.adp.lib.stats.a Aw;
        private int Ax = 2;
        private final Map<b<T>, BdUniqueId> Ay = new HashMap();
        private final com.baidu.adp.lib.f.a Az = new com.baidu.adp.lib.f.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.Av = false;
            this.args = null;
            this.Aw = null;
            this.At = str;
            this.Au = i;
            this.width = i2;
            this.height = i3;
            this.Av = z;
            this.Aw = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.jT();
            if (!this.Ay.containsKey(bVar)) {
                this.Ay.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.jT();
            this.Ay.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.At);
            }
            if (this.Ay.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.jT();
            if (this.Ay.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.Ay.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.Ay.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.jT();
            if (this.Ay.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.Ay.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.Ay.size() == 0) {
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
            if (this.Aw != null) {
                com.baidu.adp.lib.stats.a ii = d.ii();
                ii.ir();
                aVar = ii;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.Ap.get(this.Au);
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
            t = (T) eVar.a(this.At, key, this.Az, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.Aw, aVar);
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
            if (isCancelled() && !this.Av) {
                this.Ax = 3;
                try {
                    obj = eVar.a(this.At, key, this.width, this.height, this, this.Az, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.Aw, aVar);
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
            if (t != null && (eVar = (e) c.this.Ap.get(this.Au)) != null) {
                eVar.a(c.this.f(this.At, this.Au), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.Ay.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.At, this.Ax);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.Ay.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.Az != null && this.Az.An != null) {
                this.Az.An.cancel();
            }
            if (this.Ay.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.Ay.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.At);
                    }
                }
                this.Ay.clear();
            }
        }
    }

    private <T> a<T> aF(String str) {
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
