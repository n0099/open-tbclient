package com.baidu.adp.lib.resourceLoader;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e<T> extends BdAsyncTask<String, Object, T> {
    final /* synthetic */ d a;
    private final String b;
    private final int c;
    private int d;
    private int e;
    private Object[] f;
    private q g;
    private int h = 2;
    private final Map<c<T>, BdUniqueId> i = new HashMap();
    private final a j = new a();

    public e(d dVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, c<T> cVar, q qVar, Object... objArr) {
        this.a = dVar;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.g = qVar;
        this.f = objArr;
        a(cVar, bdUniqueId);
    }

    public void a(c<T> cVar, BdUniqueId bdUniqueId) {
        j.a();
        if (!this.i.containsKey(cVar)) {
            this.i.put(cVar, bdUniqueId);
        }
    }

    public void a(c<T> cVar) {
        j.a();
        this.i.remove(cVar);
        if (cVar != null) {
            cVar.a(this.b);
        }
        if (this.i.size() == 0) {
            cancel();
        }
    }

    public void a(BdUniqueId bdUniqueId, c<T> cVar) {
        j.a();
        if (this.i.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, BdUniqueId> next = it.next();
            c<T> key = next.getKey();
            BdUniqueId value = next.getValue();
            if (value != null && value == bdUniqueId && key == cVar) {
                it.remove();
            }
        }
        if (this.i.size() == 0) {
            cancel();
        }
    }

    public void a(BdUniqueId bdUniqueId) {
        j.a();
        if (this.i.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            BdUniqueId value = it.next().getValue();
            if (value != null && value == bdUniqueId) {
                it.remove();
            }
        }
        if (this.i.size() == 0) {
            cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
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
        if (this.g != null) {
            q a = f.a();
            a.a();
            qVar = a;
        } else {
            qVar = null;
        }
        sparseArray = this.a.b;
        h hVar = (h) sparseArray.get(this.c);
        if (hVar == null) {
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
        t = (T) hVar.a(this.b, key, this.j, this.f);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.g, qVar);
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
            this.h = 3;
            try {
                obj = hVar.a(this.b, key, this.d, this.e, this, this.j, this.f);
                try {
                    if (!isCancelled()) {
                        f.b(this.g, qVar);
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
        String b;
        if (t != null) {
            sparseArray = this.a.b;
            h hVar = (h) sparseArray.get(this.c);
            if (hVar != null) {
                b = this.a.b(this.b, this.c);
                hVar.a(b, t, this.f);
            }
        }
        for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.a(t, this.b, this.h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.a(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.j != null && this.j.a != null) {
            this.j.a.a();
        }
        if (this.i.size() != 0) {
            for (Map.Entry<c<T>, BdUniqueId> entry : this.i.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.a(this.b);
                }
            }
            this.i.clear();
        }
    }
}
