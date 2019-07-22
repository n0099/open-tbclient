package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private SparseArray<List<b>> XH = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(C0038a c0038a);
    }

    public void c(int i, b bVar) {
        if (this.XH == null) {
            this.XH = new SparseArray<>();
        }
        List<b> list = this.XH.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.XH.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.XH.remove(i);
            return;
        }
        List<b> list = this.XH.get(i);
        if (!v.aa(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0038a c0038a) {
        List<b> list = this.XH.get(c0038a.XI);
        if (v.aa(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0038a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0038a {
        private int XI;
        private Object XJ;

        public C0038a(int i, Object obj) {
            this.XI = i;
            this.XJ = obj;
        }

        public C0038a(int i) {
            this.XI = i;
        }

        public int getActionType() {
            return this.XI;
        }

        public void setExtraData(Object obj) {
            this.XJ = obj;
        }

        public Object qV() {
            return this.XJ;
        }
    }
}
