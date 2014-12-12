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
    private final String li;
    private final int lj;
    private q lk;
    private int ll = 2;
    private final Map<c<T>, BdUniqueId> lm = new HashMap();
    private final a ln = new a();
    final /* synthetic */ d lo;
    private int width;

    public e(d dVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, q qVar, Object... objArr) {
        this.lo = dVar;
        this.width = 0;
        this.height = 0;
        this.args = null;
        this.lk = null;
        this.li = str;
        this.lj = i;
        this.width = i2;
        this.height = i3;
        this.lk = qVar;
        this.args = objArr;
        a(cVar, bdUniqueId);
    }

    public void a(c<T> cVar, BdUniqueId bdUniqueId) {
        l.ft();
        if (!this.lm.containsKey(cVar)) {
            this.lm.put(cVar, bdUniqueId);
        }
    }

    public void a(c<T> cVar) {
        l.ft();
        this.lm.remove(cVar);
        if (cVar != null) {
            cVar.onCancelled(this.li);
        }
        if (this.lm.size() == 0) {
            cancel();
        }
    }

    public void b(BdUniqueId bdUniqueId, c<T> cVar) {
        l.ft();
        if (this.lm.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.lm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, BdUniqueId> next = it.next();
            c<T> key = next.getKey();
            BdUniqueId value = next.getValue();
            if (value != null && value == bdUniqueId && key == cVar) {
                it.remove();
            }
        }
        if (this.lm.size() == 0) {
            cancel();
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        l.ft();
        if (this.lm.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.lm.entrySet().iterator();
        while (it.hasNext()) {
            BdUniqueId value = it.next().getValue();
            if (value != null && value == bdUniqueId) {
                it.remove();
            }
        }
        if (this.lm.size() == 0) {
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
        if (this.lk != null) {
            q ef = f.ef();
            ef.startTimer();
            qVar = ef;
        } else {
            qVar = null;
        }
        sparseArray = this.lo.le;
        g gVar = (g) sparseArray.get(this.lj);
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
        t = (T) gVar.a(this.li, key, this.ln, this.args);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.lk, qVar);
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
            this.ll = 3;
            try {
                obj = gVar.a(this.li, key, this.width, this.height, this, this.ln, this.args);
                try {
                    if (!isCancelled()) {
                        f.b(this.lk, qVar);
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
            sparseArray = this.lo.le;
            g gVar = (g) sparseArray.get(this.lj);
            if (gVar != null) {
                f = this.lo.f(this.li, this.lj);
                gVar.a(f, t, this.args);
            }
        }
        for (Map.Entry<c<T>, BdUniqueId> entry : this.lm.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onLoaded(t, this.li, this.ll);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, BdUniqueId> entry : this.lm.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onProgressUpdate(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.ln != null && this.ln.lc != null) {
            this.ln.lc.cancel();
        }
        if (this.lm.size() != 0) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.lm.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.onCancelled(this.li);
                }
            }
            this.lm.clear();
        }
    }
}
