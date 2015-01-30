package com.baidu.adp.lib.f;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e<T> extends BdAsyncTask<String, Object, T> {
    private Object[] args;
    private int height;
    private final String ll;
    private final int lm;
    private q ln;
    private int lo = 2;
    private final Map<c<T>, BdUniqueId> lp = new HashMap();
    private final a lq = new a();
    final /* synthetic */ d lr;
    private int width;

    public e(d dVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, q qVar, Object... objArr) {
        this.lr = dVar;
        this.width = 0;
        this.height = 0;
        this.args = null;
        this.ln = null;
        this.ll = str;
        this.lm = i;
        this.width = i2;
        this.height = i3;
        this.ln = qVar;
        this.args = objArr;
        a(cVar, bdUniqueId);
    }

    public void a(c<T> cVar, BdUniqueId bdUniqueId) {
        l.fs();
        if (!this.lp.containsKey(cVar)) {
            this.lp.put(cVar, bdUniqueId);
        }
    }

    public void a(c<T> cVar) {
        l.fs();
        this.lp.remove(cVar);
        if (cVar != null) {
            cVar.onCancelled(this.ll);
        }
        if (this.lp.size() == 0) {
            cancel();
        }
    }

    public void b(BdUniqueId bdUniqueId, c<T> cVar) {
        l.fs();
        if (this.lp.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.lp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, BdUniqueId> next = it.next();
            c<T> key = next.getKey();
            BdUniqueId value = next.getValue();
            if (value != null && value == bdUniqueId && key == cVar) {
                it.remove();
            }
        }
        if (this.lp.size() == 0) {
            cancel();
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        l.fs();
        if (this.lp.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.lp.entrySet().iterator();
        while (it.hasNext()) {
            BdUniqueId value = it.next().getValue();
            if (value != null && value == bdUniqueId) {
                it.remove();
            }
        }
        if (this.lp.size() == 0) {
            cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public T doInBackground(String... strArr) {
        q qVar;
        SparseArray sparseArray;
        Exception e;
        T t;
        Exception e2;
        Object obj;
        if (this.ln != null) {
            q ed = f.ed();
            ed.eK();
            qVar = ed;
        } else {
            qVar = null;
        }
        sparseArray = this.lr.lh;
        g gVar = (g) sparseArray.get(this.lm);
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
        t = (T) gVar.a(this.ll, key, this.lq, this.args);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.ln, qVar);
                }
                return t;
            } catch (Exception e4) {
                e = e4;
                BdLog.e(e.getMessage());
                T t2 = t;
                if (isCancelled()) {
                }
            }
        }
        T t22 = t;
        if (isCancelled()) {
            this.lo = 3;
            try {
                obj = gVar.a(this.ll, key, this.width, this.height, this, this.lq, this.args);
                try {
                    if (!isCancelled()) {
                        f.b(this.ln, qVar);
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
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        SparseArray sparseArray;
        String f;
        if (t != null) {
            sparseArray = this.lr.lh;
            g gVar = (g) sparseArray.get(this.lm);
            if (gVar != null) {
                f = this.lr.f(this.ll, this.lm);
                gVar.a(f, t, this.args);
            }
        }
        for (Map.Entry<c<T>, BdUniqueId> entry : this.lp.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onLoaded(t, this.ll, this.lo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, BdUniqueId> entry : this.lp.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onProgressUpdate(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.lq != null && this.lq.lf != null) {
            this.lq.lf.cancel();
        }
        if (this.lp.size() != 0) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.lp.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.ll);
                }
            }
            this.lp.clear();
        }
    }
}
