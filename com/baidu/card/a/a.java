package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private SparseArray<List<b>> ajL = new SparseArray<>();

    /* loaded from: classes21.dex */
    public interface b {
        boolean a(C0097a c0097a);
    }

    public void b(int i, b bVar) {
        if (this.ajL == null) {
            this.ajL = new SparseArray<>();
        }
        List<b> list = this.ajL.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.ajL.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C0097a c0097a) {
        List<b> list = this.ajL.get(c0097a.ajM);
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
        private int ajM;
        private Object ajN;

        public C0097a(int i, Object obj) {
            this.ajM = i;
            this.ajN = obj;
        }

        public C0097a(int i) {
            this.ajM = i;
        }

        public int getActionType() {
            return this.ajM;
        }

        public void setExtraData(Object obj) {
            this.ajN = obj;
        }

        public Object ug() {
            return this.ajN;
        }
    }
}
