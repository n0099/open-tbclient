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
    private final int wA;
    private boolean wB;
    private q wC;
    private int wD = 2;
    private final Map<c<T>, BdUniqueId> wE = new HashMap();
    private final a wF = new a();
    final /* synthetic */ d wG;
    private int width;
    private final String wz;

    public e(d dVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, boolean z, q qVar, Object... objArr) {
        this.wG = dVar;
        this.width = 0;
        this.height = 0;
        this.wB = false;
        this.args = null;
        this.wC = null;
        this.wz = str;
        this.wA = i;
        this.width = i2;
        this.height = i3;
        this.wB = z;
        this.wC = qVar;
        this.args = objArr;
        a(cVar, bdUniqueId);
    }

    public void a(c<T> cVar, BdUniqueId bdUniqueId) {
        n.iV();
        if (!this.wE.containsKey(cVar)) {
            this.wE.put(cVar, bdUniqueId);
        }
    }

    public void a(c<T> cVar) {
        n.iV();
        this.wE.remove(cVar);
        if (cVar != null) {
            cVar.onCancelled(this.wz);
        }
        if (this.wE.size() == 0) {
            cancel();
        }
    }

    public void b(BdUniqueId bdUniqueId, c<T> cVar) {
        n.iV();
        if (this.wE.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.wE.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, BdUniqueId> next = it.next();
            c<T> key = next.getKey();
            BdUniqueId value = next.getValue();
            if (value != null && value == bdUniqueId && key == cVar) {
                it.remove();
            }
        }
        if (this.wE.size() == 0) {
            cancel();
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        n.iV();
        if (this.wE.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.wE.entrySet().iterator();
        while (it.hasNext()) {
            BdUniqueId value = it.next().getValue();
            if (value != null && value == bdUniqueId) {
                it.remove();
            }
        }
        if (this.wE.size() == 0) {
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
        if (this.wC != null) {
            q hC = f.hC();
            hC.il();
            qVar = hC;
        } else {
            qVar = null;
        }
        sparseArray = this.wG.wv;
        g gVar = (g) sparseArray.get(this.wA);
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
        t = (T) gVar.a(this.wz, key, this.wF, this.args);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.wC, qVar);
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
        if (isCancelled() && !this.wB) {
            this.wD = 3;
            try {
                obj = gVar.a(this.wz, key, this.width, this.height, this, this.wF, this.args);
                try {
                    if (!isCancelled()) {
                        f.b(this.wC, qVar);
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
            sparseArray = this.wG.wv;
            g gVar = (g) sparseArray.get(this.wA);
            if (gVar != null) {
                gVar.a(this.wG.f(this.wz, this.wA), t, this.args);
            }
        }
        for (Map.Entry<c<T>, BdUniqueId> entry : this.wE.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onLoaded(t, this.wz, this.wD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, BdUniqueId> entry : this.wE.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onProgressUpdate(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.wF != null && this.wF.wt != null) {
            this.wF.wt.cancel();
        }
        if (this.wE.size() != 0) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.wE.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.wz);
                }
            }
            this.wE.clear();
        }
    }
}
