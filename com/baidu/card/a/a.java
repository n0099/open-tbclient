package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private SparseArray<List<b>> agI = new SparseArray<>();

    /* loaded from: classes15.dex */
    public interface b {
        boolean a(C0096a c0096a);
    }

    public void c(int i, b bVar) {
        if (this.agI == null) {
            this.agI = new SparseArray<>();
        }
        List<b> list = this.agI.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.agI.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.agI.remove(i);
            return;
        }
        List<b> list = this.agI.get(i);
        if (!x.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0096a c0096a) {
        List<b> list = this.agI.get(c0096a.agJ);
        if (x.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0096a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0096a {
        private int agJ;
        private Object agK;

        public C0096a(int i, Object obj) {
            this.agJ = i;
            this.agK = obj;
        }

        public C0096a(int i) {
            this.agJ = i;
        }

        public int getActionType() {
            return this.agJ;
        }

        public void setExtraData(Object obj) {
            this.agK = obj;
        }

        public Object sm() {
            return this.agK;
        }
    }
}
