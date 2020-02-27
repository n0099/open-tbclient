package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private SparseArray<List<b>> MS = new SparseArray<>();

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(C0052a c0052a);
    }

    public void c(int i, b bVar) {
        if (this.MS == null) {
            this.MS = new SparseArray<>();
        }
        List<b> list = this.MS.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.MS.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.MS.remove(i);
            return;
        }
        List<b> list = this.MS.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0052a c0052a) {
        List<b> list = this.MS.get(c0052a.MT);
        if (v.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0052a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0052a {
        private int MT;
        private Object MU;

        public C0052a(int i, Object obj) {
            this.MT = i;
            this.MU = obj;
        }

        public C0052a(int i) {
            this.MT = i;
        }

        public int getActionType() {
            return this.MT;
        }

        public void setExtraData(Object obj) {
            this.MU = obj;
        }

        public Object nq() {
            return this.MU;
        }
    }
}
