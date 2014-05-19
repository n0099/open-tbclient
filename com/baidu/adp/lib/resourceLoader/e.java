package com.baidu.adp.lib.resourceLoader;

import android.util.SparseArray;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.h;
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
    private final Map<c<T>, Integer> g = new HashMap();
    private final a h = new a();

    public e(d dVar, String str, int i, int i2, int i3, int i4, c<T> cVar, Object... objArr) {
        this.a = dVar;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = objArr;
        a(cVar, i4);
    }

    public void a(c<T> cVar, int i) {
        h.b();
        if (this.g.containsKey(cVar)) {
            BdLog.d("the resKey and callback had existed , direct return.");
        } else {
            this.g.put(cVar, Integer.valueOf(i));
        }
    }

    public void a(c<T> cVar) {
        h.b();
        this.g.remove(cVar);
        if (cVar != null) {
            cVar.a(this.b);
        }
        BdLog.d("cancel callback");
        if (this.g.size() == 0) {
            cancel();
        }
    }

    public void a(int i, c<T> cVar) {
        h.b();
        if (this.g.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, Integer>> it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<c<T>, Integer> next = it.next();
            c<T> key = next.getKey();
            Integer value = next.getValue();
            if (value != null && value.intValue() == i && key == cVar) {
                it.remove();
            }
        }
        if (this.g.size() == 0) {
            BdLog.d("cancelByPageIdAndCallback-callbacks.size equals 0, to cancel task.");
            cancel();
        }
    }

    public void a(int i) {
        h.b();
        if (this.g.size() == 0) {
            cancel();
            return;
        }
        Iterator<Map.Entry<c<T>, Integer>> it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            Integer value = it.next().getValue();
            if (value != null && value.intValue() == i) {
                it.remove();
            }
        }
        if (this.g.size() == 0) {
            BdLog.d("cancelByPageId-callbacks.size equals 0, to cancel task.");
            cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public T doInBackground(String... strArr) {
        SparseArray sparseArray;
        Object obj;
        sparseArray = this.a.b;
        g gVar = (g) sparseArray.get(this.c);
        if (gVar == null) {
            return null;
        }
        String key = getKey();
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            obj = null;
        }
        if (isCancelled()) {
            return null;
        }
        T t = (T) gVar.a(key, this.h, this.f);
        if (t != null) {
            return t;
        }
        obj = t;
        if (isCancelled()) {
            return null;
        }
        try {
            obj = gVar.a(this.b, key, this.d, this.e, this, this.h, this.f);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        return (T) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(T t) {
        SparseArray sparseArray;
        String a;
        if (t != null) {
            sparseArray = this.a.b;
            g gVar = (g) sparseArray.get(this.c);
            if (gVar != null) {
                a = this.a.a(this.b, this.c);
                gVar.a(a, t, this.f);
            }
        }
        for (Map.Entry<c<T>, Integer> entry : this.g.entrySet()) {
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
        for (Map.Entry<c<T>, Integer> entry : this.g.entrySet()) {
            c<T> key = entry.getKey();
            if (key != null) {
                key.a(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.h != null && this.h.a != null) {
            this.h.a.a();
        }
        BdLog.d("asynctask cancel called");
        if (this.g.size() != 0) {
            for (Map.Entry<c<T>, Integer> entry : this.g.entrySet()) {
                c<T> key = entry.getKey();
                if (key != null) {
                    key.a(this.b);
                }
            }
            this.g.clear();
        }
    }
}
