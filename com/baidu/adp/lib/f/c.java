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
    private static c ajP;
    private static BdAsyncTaskParallel ajQ = null;
    private static BdAsyncTaskParallel ajR = null;
    private final BdUniqueId ajN = BdUniqueId.gen();
    private SparseArray<e<?>> ajO;

    public static c nm() {
        if (ajP == null) {
            synchronized (c.class) {
                if (ajP == null) {
                    ajP = new c();
                }
            }
        }
        return ajP;
    }

    private c() {
        this.ajO = null;
        BdUniqueId gen = BdUniqueId.gen();
        ajQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        ajR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.ajO = new SparseArray<>();
    }

    public synchronized <T> void a(int i, e<T> eVar) {
        if (eVar != null) {
            if (this.ajO.get(i) == null) {
                this.ajO.put(i, eVar);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(this.ajN);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.ajN);
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
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask = BdAsyncTask.searchWaitingTask(this.ajN);
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
        e<?> eVar = this.ajO.get(i);
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
        e<?> eVar = this.ajO.get(i);
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
        e<?> eVar = this.ajO.get(i);
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
            aVar2.setTag(this.ajN);
            int nr = eVar.nr();
            if (nr == 0) {
                nr = 1;
            }
            aVar2.setPriority(nr);
            if (oK || oM) {
                if (eVar.nq() == null) {
                    aVar2.setParallel(ajR);
                } else {
                    aVar2.setParallel(eVar.nq());
                }
            } else {
                aVar2.setParallel(ajQ);
            }
            aVar2.execute(new String[0]);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        private final String ajS;
        private final int ajT;
        private boolean ajU;
        private com.baidu.adp.lib.stats.a ajV;
        private int ajW = 2;
        private final Map<b<T>, BdUniqueId> ajX = new HashMap();
        private final com.baidu.adp.lib.f.a ajY = new com.baidu.adp.lib.f.a();
        private Object[] args;
        private int height;
        private int width;

        public a(String str, int i, int i2, int i3, BdUniqueId bdUniqueId, b<T> bVar, boolean z, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
            this.width = 0;
            this.height = 0;
            this.ajU = false;
            this.args = null;
            this.ajV = null;
            this.ajS = str;
            this.ajT = i;
            this.width = i2;
            this.height = i3;
            this.ajU = z;
            this.ajV = aVar;
            this.args = objArr;
            a(bVar, bdUniqueId);
        }

        public void a(b<T> bVar, BdUniqueId bdUniqueId) {
            l.oY();
            if (!this.ajX.containsKey(bVar)) {
                this.ajX.put(bVar, bdUniqueId);
            }
        }

        public void a(b<T> bVar) {
            l.oY();
            this.ajX.remove(bVar);
            if (bVar != null) {
                bVar.onCancelled(this.ajS);
            }
            if (this.ajX.size() == 0) {
                cancel();
            }
        }

        public void b(BdUniqueId bdUniqueId, b<T> bVar) {
            l.oY();
            if (this.ajX.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.ajX.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b<T>, BdUniqueId> next = it.next();
                b<T> key = next.getKey();
                BdUniqueId value = next.getValue();
                if (value != null && value == bdUniqueId && key == bVar) {
                    it.remove();
                }
            }
            if (this.ajX.size() == 0) {
                cancel();
            }
        }

        public void f(BdUniqueId bdUniqueId) {
            l.oY();
            if (this.ajX.size() == 0) {
                cancel();
                return;
            }
            Iterator<Map.Entry<b<T>, BdUniqueId>> it = this.ajX.entrySet().iterator();
            while (it.hasNext()) {
                BdUniqueId value = it.next().getValue();
                if (value != null && value == bdUniqueId) {
                    it.remove();
                }
            }
            if (this.ajX.size() == 0) {
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
            if (this.ajV != null) {
                com.baidu.adp.lib.stats.a nn = d.nn();
                nn.nw();
                aVar = nn;
            } else {
                aVar = null;
            }
            e eVar = (e) c.this.ajO.get(this.ajT);
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
            t = (T) eVar.a(this.ajS, key, this.ajY, this.args);
            if (t != null) {
                try {
                    if (!isCancelled()) {
                        d.a(this.ajV, aVar);
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
            if (isCancelled() && !this.ajU) {
                this.ajW = 3;
                try {
                    obj = eVar.a(this.ajS, key, this.width, this.height, this, this.ajY, this.args);
                } catch (Exception e5) {
                    e2 = e5;
                    obj = t2;
                }
                try {
                    if (!isCancelled()) {
                        d.b(this.ajV, aVar);
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
            if (t != null && (eVar = (e) c.this.ajO.get(this.ajT)) != null) {
                eVar.a(c.this.g(this.ajS, this.ajT), t, this.args);
            }
            for (Map.Entry<b<T>, BdUniqueId> entry : this.ajX.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onLoaded(t, this.ajS, this.ajW);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            for (Map.Entry<b<T>, BdUniqueId> entry : this.ajX.entrySet()) {
                b<T> key = entry.getKey();
                if (key != null) {
                    key.onProgressUpdate(objArr);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.ajY != null && this.ajY.ajM != null) {
                this.ajY.ajM.cancel();
            }
            if (this.ajX.size() != 0) {
                for (Map.Entry<b<T>, BdUniqueId> entry : this.ajX.entrySet()) {
                    b<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.ajS);
                    }
                }
                this.ajX.clear();
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
