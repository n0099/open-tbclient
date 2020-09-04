package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private SparseArray<List<b>> ahT = new SparseArray<>();

    /* loaded from: classes15.dex */
    public interface b {
        boolean a(C0095a c0095a);
    }

    public void c(int i, b bVar) {
        if (this.ahT == null) {
            this.ahT = new SparseArray<>();
        }
        List<b> list = this.ahT.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.ahT.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.ahT.remove(i);
            return;
        }
        List<b> list = this.ahT.get(i);
        if (!y.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0095a c0095a) {
        List<b> list = this.ahT.get(c0095a.ahU);
        if (y.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0095a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0095a {
        private int ahU;
        private Object ahV;

        public C0095a(int i, Object obj) {
            this.ahU = i;
            this.ahV = obj;
        }

        public C0095a(int i) {
            this.ahU = i;
        }

        public int getActionType() {
            return this.ahU;
        }

        public void setExtraData(Object obj) {
            this.ahV = obj;
        }

        public Object tX() {
            return this.ahV;
        }
    }
}
