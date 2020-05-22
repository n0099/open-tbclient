package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private SparseArray<List<b>> agd = new SparseArray<>();

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(C0097a c0097a);
    }

    public void c(int i, b bVar) {
        if (this.agd == null) {
            this.agd = new SparseArray<>();
        }
        List<b> list = this.agd.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.agd.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.agd.remove(i);
            return;
        }
        List<b> list = this.agd.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0097a c0097a) {
        List<b> list = this.agd.get(c0097a.agf);
        if (v.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0097a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0097a {
        private int agf;
        private Object agg;

        public C0097a(int i, Object obj) {
            this.agf = i;
            this.agg = obj;
        }

        public C0097a(int i) {
            this.agf = i;
        }

        public int getActionType() {
            return this.agf;
        }

        public void setExtraData(Object obj) {
            this.agg = obj;
        }

        public Object rS() {
            return this.agg;
        }
    }
}
