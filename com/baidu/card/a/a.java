package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private SparseArray<List<b>> Zt = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(C0037a c0037a);
    }

    public void c(int i, b bVar) {
        if (this.Zt == null) {
            this.Zt = new SparseArray<>();
        }
        List<b> list = this.Zt.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.Zt.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.Zt.remove(i);
            return;
        }
        List<b> list = this.Zt.get(i);
        if (!v.T(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0037a c0037a) {
        List<b> list = this.Zt.get(c0037a.Zu);
        if (v.T(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0037a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0037a {
        private int Zu;
        private Object Zv;

        public C0037a(int i, Object obj) {
            this.Zu = i;
            this.Zv = obj;
        }

        public C0037a(int i) {
            this.Zu = i;
        }

        public int getActionType() {
            return this.Zu;
        }

        public void setExtraData(Object obj) {
            this.Zv = obj;
        }

        public Object rD() {
            return this.Zv;
        }
    }
}
