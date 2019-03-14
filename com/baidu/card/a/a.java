package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private SparseArray<List<b>> Zu = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(C0039a c0039a);
    }

    public void c(int i, b bVar) {
        if (this.Zu == null) {
            this.Zu = new SparseArray<>();
        }
        List<b> list = this.Zu.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.Zu.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.Zu.remove(i);
            return;
        }
        List<b> list = this.Zu.get(i);
        if (!v.T(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0039a c0039a) {
        List<b> list = this.Zu.get(c0039a.Zv);
        if (v.T(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0039a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0039a {
        private int Zv;
        private Object Zw;

        public C0039a(int i, Object obj) {
            this.Zv = i;
            this.Zw = obj;
        }

        public C0039a(int i) {
            this.Zv = i;
        }

        public int getActionType() {
            return this.Zv;
        }

        public void setExtraData(Object obj) {
            this.Zw = obj;
        }

        public Object rD() {
            return this.Zw;
        }
    }
}
