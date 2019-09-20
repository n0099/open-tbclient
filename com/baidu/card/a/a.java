package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private SparseArray<List<b>> XG = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(C0038a c0038a);
    }

    public void c(int i, b bVar) {
        if (this.XG == null) {
            this.XG = new SparseArray<>();
        }
        List<b> list = this.XG.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.XG.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.XG.remove(i);
            return;
        }
        List<b> list = this.XG.get(i);
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
        List<b> list = this.XG.get(c0038a.XH);
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
        private int XH;
        private Object XI;

        public C0038a(int i, Object obj) {
            this.XH = i;
            this.XI = obj;
        }

        public C0038a(int i) {
            this.XH = i;
        }

        public int getActionType() {
            return this.XH;
        }

        public void setExtraData(Object obj) {
            this.XI = obj;
        }

        public Object qW() {
            return this.XI;
        }
    }
}
