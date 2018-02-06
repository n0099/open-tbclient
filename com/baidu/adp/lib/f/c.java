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
    private static c ajV;
    private static BdAsyncTaskParallel ajW = null;
    private static BdAsyncTaskParallel ajX = null;
    private final BdUniqueId ajT = BdUniqueId.gen();
    private SparseArray<e<?>> ajU;

    public static c nm() {
        if (ajV == null) {
            synchronized (c.class) {
                if (ajV == null) {
                    ajV = new c();
                }
            }
        }
        return ajV;
    }

    private c() {
        this.ajU = null;
        BdUniqueId gen = BdUniqueId.gen();
        ajW = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        ajX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.ajU = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.ajU.get(i) == null) {
                this.ajU.put(i, eVar);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.ajT);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.ajT);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.ajT);
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
        e<?> eVar = this.ajU.get(i);
        if (eVar == null) {
            BdLog.e("Can't find the ResourceLoaderProc with type " + i);
            return false;
        }
        return eVar.np();
    }

    public Object a(String str, int i, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("resKey can not be null");
        }
        e<?> eVar = this.ajU.get(i);
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
        e<?> eVar = this.ajU.get(i);
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
            boolean oK = j.oK();
            boolean oM = j.oM();
            com.baidu.adp.lib.stats.a aVar = null;
            if (oK) {
                aVar = d.nn();
                aVar.nw();
            }
            a aVar2 = new a(str, i, i2, i3, bdUniqueId, bVar, z, aVar, objArr);
            aVar2.setKey(g);
            aVar2.setTag(this.ajT);
            int nr = eVar.nr();
            if (nr == 0) {
                nr = 1;
            }
            aVar2.setPriority(nr);
            if (oK || oM) {
                if (eVar.nq() == null) {
                    aVar2.setParallel(ajX);
                } else {
                    aVar2.setParallel(eVar.nq());
                }
            } else {
                aVar2.setParallel(ajW);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String ajY;
        private final int ajZ;
        private boolean aka;
        private com.baidu.adp.lib.stats.a akb;
        private int akc = 2;
        private final Map<b<T>, BdUniqueId> akd = new HashMap();
        private final com.baidu.adp.lib.f.a ake = new com.baidu.adp.lib.f.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.aka = false;
            this.args = null;
            this.akb = null;
            this.ajY = str;
            this.ajZ = i;
            this.width = i2;
            this.height = i3;
            this.aka = z;
            this.akb = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.oY();
            if (!this.akd.containsKey(bVar)) {
                this.akd.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.oY();
            this.akd.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.ajY);
            }
            if (this.akd.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.oY();
            if (this.akd.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.akd.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.akd.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.oY();
            if (this.akd.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.akd.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.akd.size() == 0) {
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
            if (this.akb != null) {
                com.baidu.adp.lib.stats.a nn = d.nn();
                nn.nw();
                aVar = nn;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.ajU.get(this.ajZ);
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
            t = (T) eVar.a(this.ajY, key, this.ake, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.akb, aVar);
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
            if (isCancelled() && !this.aka) {
                this.akc = 3;
                try {
                    obj = eVar.a(this.ajY, key, this.width, this.height, this, this.ake, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.akb, aVar);
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
            if (t != null && (eVar = (e) c.this.ajU.get(this.ajZ)) != null) {
                eVar.a(c.this.g(this.ajY, this.ajZ), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.akd.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.ajY, this.akc);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.akd.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.ake != null && this.ake.ajS != null) {
                this.ake.ajS.cancel();
            }
            if (this.akd.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.akd.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.ajY);
                    }
                }
                this.akd.clear();
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
