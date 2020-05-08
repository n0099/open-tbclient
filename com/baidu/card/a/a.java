package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private SparseArray<List<b>> afH = new SparseArray<>();

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(C0095a c0095a);
    }

    public void c(int i, b bVar) {
        if (this.afH == null) {
            this.afH = new SparseArray<>();
        }
        List<b> list = this.afH.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.afH.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.afH.remove(i);
            return;
        }
        List<b> list = this.afH.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0095a c0095a) {
        List<b> list = this.afH.get(c0095a.afI);
        if (v.isEmpty(list)) {
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
    /* loaded from: classes8.dex */
    public static class C0095a {
        private int afI;
        private Object afJ;

        public C0095a(int i, Object obj) {
            this.afI = i;
            this.afJ = obj;
        }

        public C0095a(int i) {
            this.afI = i;
        }

        public int getActionType() {
            return this.afI;
        }

        public void setExtraData(Object obj) {
            this.afJ = obj;
        }

        public Object rJ() {
            return this.afJ;
        }
    }
}
