package com.baidu.adp.lib.resourceLoader;

import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.s;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
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
    private s g;
    private final Map<c<T>, Integer> h = new HashMap();
    private final a i = new a();

    public e(d dVar, String str, int i, int i2, int i3, int i4, c<T> cVar, s sVar, Object... objArr) {
        this.a = dVar;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.g = sVar;
        this.f = objArr;
        a(cVar, i4);
    }

    public void a(c<T> cVar, int i) {
        k.b();
        if (this.h.containsKey(cVar)) {
            BdLog.d("the resKey and callback had existed , direct return.");
        } else {
            this.h.put(cVar, Integer.valueOf(i));
        }
    }

    public void a(c<T> cVar) {
        k.b();
        this.h.remove(cVar);
        if (cVar != null) {
            cVar.a(this.b);
        }
        BdLog.d("cancel callback");
        if (this.h.size() == 0) {
            cancel();
        }
    }

    public void a(int i, c<T> cVar) {
        k.b();
        if (this.h.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, Integer>> it = this.h.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, Integer> next = it.next();
            c<T> key = next.getKey();
            Integer value = next.getValue();
            if (value != null && value.intValue() == i && key == cVar) {
                it.remove();
            }
        }
        if (this.h.size() == 0) {
            BdLog.d("cancelByPageIdAndCallback-callbacks.size equals 0, to cancel task.");
            cancel();
        }
    }

    public void a(int i) {
        k.b();
        if (this.h.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, Integer>> it = this.h.entrySet().iterator();
        while (it.hasNext()) {
            Integer value = it.next().getValue();
            if (value != null && value.intValue() == i) {
                it.remove();
            }
        }
        if (this.h.size() == 0) {
            BdLog.d("cancelByPageId-callbacks.size equals 0, to cancel task.");
            cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public T doInBackground(String... strArr) {
        s sVar;
        SparseArray sparseArray;
        Exception e;
        T t;
        Exception e2;
        Object obj;
        if (this.g != null) {
            s a = f.a();
            a.a();
            sVar = a;
        } else {
            sVar = null;
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
        t = (T) hVar.a(key, this.i, this.f);
        if (t != null) {
            try {
                if (!isCancelled()) {
                    f.a(this.g, sVar);
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
            try {
                obj = hVar.a(this.b, key, this.d, this.e, this, this.i, this.f);
            } catch (Exception e5) {
                e2 = e5;
                obj = t22;
            }
            try {
                if (!isCancelled()) {
                    f.b(this.g, sVar);
                }
            } catch (Exception e6) {
                e2 = e6;
                BdLog.e(e2.getMessage());
                return (T) obj;
            }
            return (T) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        SparseArray sparseArray;
        String a;
        if (t != null) {
            sparseArray = this.a.b;
            h hVar = (h) sparseArray.get(this.c);
            if (hVar != null) {
                a = this.a.a(this.b, this.c);
                hVar.a(a, t, this.f);
            }
        }
        for (Map.Entry<c<T>, Integer> entry : this.h.entrySet()) {
            c<T> key = entry.getKey();
            BdLog.d("callback called");
            if (key != null) {
                key.a(t, this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onProgressUpdate(Object... objArr) {
        for (Map.Entry<c<T>, Integer> entry : this.h.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.a(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.i != null && this.i.a != null) {
            this.i.a.a();
        }
        BdLog.d("asynctask cancel called");
        if (this.h.size() != 0) {
            for (Map.Entry<c<T>, Integer> entry : this.h.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.a(this.b);
                }
            }
            this.h.clear();
        }
    }
}
