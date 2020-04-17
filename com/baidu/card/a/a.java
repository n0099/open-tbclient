package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private SparseArray<List<b>> afE = new SparseArray<>();

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(C0074a c0074a);
    }

    public void c(int i, b bVar) {
        if (this.afE == null) {
            this.afE = new SparseArray<>();
        }
        List<b> list = this.afE.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.afE.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.afE.remove(i);
            return;
        }
        List<b> list = this.afE.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0074a c0074a) {
        List<b> list = this.afE.get(c0074a.afF);
        if (v.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0074a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0074a {
        private int afF;
        private Object afG;

        public C0074a(int i, Object obj) {
            this.afF = i;
            this.afG = obj;
        }

        public C0074a(int i) {
            this.afF = i;
        }

        public int getActionType() {
            return this.afF;
        }

        public void setExtraData(Object obj) {
            this.afG = obj;
        }

        public Object rJ() {
            return this.afG;
        }
    }
}
