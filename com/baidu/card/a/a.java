package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private SparseArray<List<b>> aiG = new SparseArray<>();

    /* loaded from: classes21.dex */
    public interface b {
        boolean a(C0097a c0097a);
    }

    public void c(int i, b bVar) {
        if (this.aiG == null) {
            this.aiG = new SparseArray<>();
        }
        List<b> list = this.aiG.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.aiG.put(i, list);
        }
        list.add(bVar);
    }

    public void d(int i, b bVar) {
        if (bVar == null) {
            this.aiG.remove(i);
            return;
        }
        List<b> list = this.aiG.get(i);
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
        List<b> list = this.aiG.get(c0097a.aiH);
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
        private int aiH;
        private Object aiI;

        public C0097a(int i, Object obj) {
            this.aiH = i;
            this.aiI = obj;
        }

        public C0097a(int i) {
            this.aiH = i;
        }

        public int getActionType() {
            return this.aiH;
        }

        public void setExtraData(Object obj) {
            this.aiI = obj;
        }

        public Object ud() {
            return this.aiI;
        }
    }
}
