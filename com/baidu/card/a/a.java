package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private SparseArray<List<b>> Ha = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(C0044a c0044a);
    }

    public void c(int i, b bVar) {
        if (this.Ha == null) {
            this.Ha = new SparseArray<>();
        }
        List<b> list = this.Ha.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.Ha.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.Ha.remove(i);
            return;
        }
        List<b> list = this.Ha.get(i);
        if (!v.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0044a c0044a) {
        List<b> list = this.Ha.get(c0044a.Hb);
        if (v.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0044a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0044a {
        private int Hb;
        private Object Hc;

        public C0044a(int i, Object obj) {
            this.Hb = i;
            this.Hc = obj;
        }

        public C0044a(int i) {
            this.Hb = i;
        }

        public int getActionType() {
            return this.Hb;
        }

        public void setExtraData(Object obj) {
            this.Hc = obj;
        }

        public Object mb() {
            return this.Hc;
        }
    }
}
