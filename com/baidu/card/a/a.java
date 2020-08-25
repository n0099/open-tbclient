package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private SparseArray<List<b>> ahR = new SparseArray<>();

    /* loaded from: classes15.dex */
    public interface b {
        boolean a(C0095a c0095a);
    }

    public void c(int i, b bVar) {
        if (this.ahR == null) {
            this.ahR = new SparseArray<>();
        }
        List<b> list = this.ahR.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.ahR.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.ahR.remove(i);
            return;
        }
        List<b> list = this.ahR.get(i);
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
        List<b> list = this.ahR.get(c0095a.ahS);
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
        private int ahS;
        private Object ahT;

        public C0095a(int i, Object obj) {
            this.ahS = i;
            this.ahT = obj;
        }

        public C0095a(int i) {
            this.ahS = i;
        }

        public int getActionType() {
            return this.ahS;
        }

        public void setExtraData(Object obj) {
            this.ahT = obj;
        }

        public Object tX() {
            return this.ahT;
        }
    }
}
