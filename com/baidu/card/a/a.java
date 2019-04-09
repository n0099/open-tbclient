package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private SparseArray<List<b>> Zv = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(C0039a c0039a);
    }

    public void c(int i, b bVar) {
        if (this.Zv == null) {
            this.Zv = new SparseArray<>();
        }
        List<b> list = this.Zv.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.Zv.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.Zv.remove(i);
            return;
        }
        List<b> list = this.Zv.get(i);
        if (!v.T(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0039a c0039a) {
        List<b> list = this.Zv.get(c0039a.Zw);
        if (v.T(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0039a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0039a {
        private int Zw;
        private Object Zx;

        public C0039a(int i, Object obj) {
            this.Zw = i;
            this.Zx = obj;
        }

        public C0039a(int i) {
            this.Zw = i;
        }

        public int getActionType() {
            return this.Zw;
        }

        public void setExtraData(Object obj) {
            this.Zx = obj;
        }

        public Object rD() {
            return this.Zx;
        }
    }
}
