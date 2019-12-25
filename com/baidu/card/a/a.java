package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private SparseArray<List<b>> Ml = new SparseArray<>();

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(C0050a c0050a);
    }

    public void c(int i, b bVar) {
        if (this.Ml == null) {
            this.Ml = new SparseArray<>();
        }
        List<b> list = this.Ml.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.Ml.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.Ml.remove(i);
            return;
        }
        List<b> list = this.Ml.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0050a c0050a) {
        List<b> list = this.Ml.get(c0050a.Mm);
        if (v.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0050a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0050a {
        private int Mm;
        private Object Mn;

        public C0050a(int i, Object obj) {
            this.Mm = i;
            this.Mn = obj;
        }

        public C0050a(int i) {
            this.Mm = i;
        }

        public int getActionType() {
            return this.Mm;
        }

        public void setExtraData(Object obj) {
            this.Mn = obj;
        }

        public Object mY() {
            return this.Mn;
        }
    }
}
