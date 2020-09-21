package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private SparseArray<List<b>> aio = new SparseArray<>();

    /* loaded from: classes20.dex */
    public interface b {
        boolean a(C0096a c0096a);
    }

    public void c(int i, b bVar) {
        if (this.aio == null) {
            this.aio = new SparseArray<>();
        }
        List<b> list = this.aio.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.aio.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.aio.remove(i);
            return;
        }
        List<b> list = this.aio.get(i);
        if (!y.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0096a c0096a) {
        List<b> list = this.aio.get(c0096a.aip);
        if (y.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0096a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0096a {
        private int aip;
        private Object aiq;

        public C0096a(int i, Object obj) {
            this.aip = i;
            this.aiq = obj;
        }

        public C0096a(int i) {
            this.aip = i;
        }

        public int getActionType() {
            return this.aip;
        }

        public void setExtraData(Object obj) {
            this.aiq = obj;
        }

        public Object ud() {
            return this.aiq;
        }
    }
}
