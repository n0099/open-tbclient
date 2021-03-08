package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private SparseArray<List<b>> akD = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0095a c0095a);
    }

    public void b(int i, b bVar) {
        if (this.akD == null) {
            this.akD = new SparseArray<>();
        }
        List<b> list = this.akD.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.akD.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C0095a c0095a) {
        List<b> list = this.akD.get(c0095a.akE);
        if (y.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0095a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0095a {
        private int akE;
        private Object akF;

        public C0095a(int i, Object obj) {
            this.akE = i;
            this.akF = obj;
        }

        public C0095a(int i) {
            this.akE = i;
        }

        public int getActionType() {
            return this.akE;
        }

        public void setExtraData(Object obj) {
            this.akF = obj;
        }

        public Object tr() {
            return this.akF;
        }
    }
}
