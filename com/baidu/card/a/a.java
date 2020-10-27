package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private SparseArray<List<b>> aiH = new SparseArray<>();

    /* loaded from: classes21.dex */
    public interface b {
        boolean a(C0097a c0097a);
    }

    public void c(int i, b bVar) {
        if (this.aiH == null) {
            this.aiH = new SparseArray<>();
        }
        List<b> list = this.aiH.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.aiH.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.aiH.remove(i);
            return;
        }
        List<b> list = this.aiH.get(i);
        if (!y.isEmpty(list)) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    it.remove();
                }
            }
        }
    }

    public boolean b(C0097a c0097a) {
        List<b> list = this.aiH.get(c0097a.aiI);
        if (y.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0097a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0097a {
        private int aiI;
        private Object aiJ;

        public C0097a(int i, Object obj) {
            this.aiI = i;
            this.aiJ = obj;
        }

        public C0097a(int i) {
            this.aiI = i;
        }

        public int getActionType() {
            return this.aiI;
        }

        public void setExtraData(Object obj) {
            this.aiJ = obj;
        }

        public Object ud() {
            return this.aiJ;
        }
    }
}
