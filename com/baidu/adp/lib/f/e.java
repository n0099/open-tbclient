package com.baidu.adp.lib.f;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e<T> extends BdAsyncTask<String, Object, T> {
    private Object[] args;
    private int height;
    private final String vD;
    private final int vE;
    private boolean vF;
    private q vG;
    private int vH = 2;
    private final Map<c<T>, BdUniqueId> vI = new HashMap();
    private final a vJ = new a();
    final /* synthetic */ d vK;
    private int width;

    public e(d dVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, q qVar, Object... objArr) {
        this.vK = dVar;
        this.width = 0;
        this.height = 0;
        this.vF = false;
        this.args = null;
        this.vG = null;
        this.vD = str;
        this.vE = i;
        this.width = i2;
        this.height = i3;
        this.vF = z;
        this.vG = qVar;
        this.args = objArr;
        a(cVar, bdUniqueId);
    }

    public void a(c<T> cVar, BdUniqueId bdUniqueId) {
        n.jk();
        if (!this.vI.containsKey(cVar)) {
            this.vI.put(cVar, bdUniqueId);
        }
    }

    public void a(c<T> cVar) {
        n.jk();
        this.vI.remove(cVar);
        if (cVar != null) {
            cVar.am(this.vD);
        }
        if (this.vI.size() == 0) {
            cancel();
        }
    }

    public void b(BdUniqueId bdUniqueId, c<T> cVar) {
        n.jk();
        if (this.vI.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.vI.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, BdUniqueId> next = it.next();
            c<T> key = next.getKey();
            BdUniqueId value = next.getValue();
            if (value != null && value == bdUniqueId && key == cVar) {
                it.remove();
            }
        }
        if (this.vI.size() == 0) {
            cancel();
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        n.jk();
        if (this.vI.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.vI.entrySet().iterator();
        while (it.hasNext()) {
            BdUniqueId value = it.next().getValue();
            if (value != null && value == bdUniqueId) {
                it.remove();
            }
        }
        if (this.vI.size() == 0) {
            cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public T doInBackground(String... strArr) {
        q qVar;
        SparseArray sparseArray;
        Exception e;
        T t;
        Exception e2;
        Object obj;
        if (this.vG != null) {
            q hm = f.hm();
            hm.hU();
            qVar = hm;
        } else {
            qVar = null;
        }
        sparseArray = this.vK.vz;
        g gVar = (g) sparseArray.get(this.vE);
        if (gVar == null) {
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
        t = (T) gVar.a(this.vD, key, this.vJ, this.args);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.vG, qVar);
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
        if (isCancelled() && !this.vF) {
            this.vH = 3;
            try {
                obj = gVar.a(this.vD, key, this.width, this.height, this, this.vJ, this.args);
                try {
                    if (!isCancelled()) {
                        f.b(this.vG, qVar);
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
        SparseArray sparseArray;
        if (t != null) {
            sparseArray = this.vK.vz;
            g gVar = (g) sparseArray.get(this.vE);
            if (gVar != null) {
                gVar.a(this.vK.f(this.vD, this.vE), t, this.args);
            }
        }
        for (Map.Entry<c<T>, BdUniqueId> entry : this.vI.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.a(t, this.vD, this.vH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, BdUniqueId> entry : this.vI.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onProgressUpdate(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.vJ != null && this.vJ.vx != null) {
            this.vJ.vx.cancel();
        }
        if (this.vI.size() != 0) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.vI.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.am(this.vD);
                }
            }
            this.vI.clear();
        }
    }
}
