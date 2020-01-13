package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private SparseArray<List<b>> Mq = new SparseArray<>();

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(C0050a c0050a);
    }

    public void c(int i, b bVar) {
        if (this.Mq == null) {
            this.Mq = new SparseArray<>();
        }
        List<b> list = this.Mq.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.Mq.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.Mq.remove(i);
            return;
        }
        List<b> list = this.Mq.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0050a c0050a) {
        List<b> list = this.Mq.get(c0050a.Mr);
        if (v.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0050a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0050a {
        private int Mr;
        private Object Ms;

        public C0050a(int i, Object obj) {
            this.Mr = i;
            this.Ms = obj;
        }

        public C0050a(int i) {
            this.Mr = i;
        }

        public int getActionType() {
            return this.Mr;
        }

        public void setExtraData(Object obj) {
            this.Ms = obj;
        }

        public Object mZ() {
            return this.Ms;
        }
    }
}
