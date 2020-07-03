package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private SparseArray<List<b>> agR = new SparseArray<>();

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(C0098a c0098a);
    }

    public void c(int i, b bVar) {
        if (this.agR == null) {
            this.agR = new SparseArray<>();
        }
        List<b> list = this.agR.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.agR.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.agR.remove(i);
            return;
        }
        List<b> list = this.agR.get(i);
        if (!w.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0098a c0098a) {
        List<b> list = this.agR.get(c0098a.agS);
        if (w.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0098a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0098a {
        private int agS;
        private Object agT;

        public C0098a(int i, Object obj) {
            this.agS = i;
            this.agT = obj;
        }

        public C0098a(int i) {
            this.agS = i;
        }

        public int getActionType() {
            return this.agS;
        }

        public void setExtraData(Object obj) {
            this.agT = obj;
        }

        public Object sk() {
            return this.agT;
        }
    }
}
