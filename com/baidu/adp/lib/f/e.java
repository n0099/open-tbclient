package com.baidu.adp.lib.f;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e<T> extends BdAsyncTask<String, Object, T> {
    private Object[] args;
    private int height;
    private final String lh;
    private final int li;
    private q lj;
    private int lk = 2;
    private final Map<c<T>, BdUniqueId> ll = new HashMap();
    private final a lm = new a();
    final /* synthetic */ d ln;
    private int width;

    public e(d dVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, q qVar, Object... objArr) {
        this.ln = dVar;
        this.width = 0;
        this.height = 0;
        this.args = null;
        this.lj = null;
        this.lh = str;
        this.li = i;
        this.width = i2;
        this.height = i3;
        this.lj = qVar;
        this.args = objArr;
        a(cVar, bdUniqueId);
    }

    public void a(c<T> cVar, BdUniqueId bdUniqueId) {
        m.ft();
        if (!this.ll.containsKey(cVar)) {
            this.ll.put(cVar, bdUniqueId);
        }
    }

    public void a(c<T> cVar) {
        m.ft();
        this.ll.remove(cVar);
        if (cVar != null) {
            cVar.aa(this.lh);
        }
        if (this.ll.size() == 0) {
            cancel();
        }
    }

    public void b(BdUniqueId bdUniqueId, c<T> cVar) {
        m.ft();
        if (this.ll.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.ll.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, BdUniqueId> next = it.next();
            c<T> key = next.getKey();
            BdUniqueId value = next.getValue();
            if (value != null && value == bdUniqueId && key == cVar) {
                it.remove();
            }
        }
        if (this.ll.size() == 0) {
            cancel();
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        m.ft();
        if (this.ll.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.ll.entrySet().iterator();
        while (it.hasNext()) {
            BdUniqueId value = it.next().getValue();
            if (value != null && value == bdUniqueId) {
                it.remove();
            }
        }
        if (this.ll.size() == 0) {
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
        if (this.lj != null) {
            q logItem = f.getLogItem();
            logItem.eL();
            qVar = logItem;
        } else {
            qVar = null;
        }
        sparseArray = this.ln.ld;
        g gVar = (g) sparseArray.get(this.li);
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
        t = (T) gVar.a(this.lh, key, this.lm, this.args);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.lj, qVar);
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
            this.lk = 3;
            try {
                obj = gVar.a(this.lh, key, this.width, this.height, this, this.lm, this.args);
                try {
                    if (!isCancelled()) {
                        f.b(this.lj, qVar);
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
        String e;
        if (t != null) {
            sparseArray = this.ln.ld;
            g gVar = (g) sparseArray.get(this.li);
            if (gVar != null) {
                e = this.ln.e(this.lh, this.li);
                gVar.a(e, t, this.args);
            }
        }
        for (Map.Entry<c<T>, BdUniqueId> entry : this.ll.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.a(t, this.lh, this.lk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, BdUniqueId> entry : this.ll.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.onProgressUpdate(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.lm != null && this.lm.lb != null) {
            this.lm.lb.cancel();
        }
        if (this.ll.size() != 0) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.ll.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.aa(this.lh);
                }
            }
            this.ll.clear();
        }
    }
}
