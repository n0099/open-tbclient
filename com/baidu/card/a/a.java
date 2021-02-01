package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private SparseArray<List<b>> ajl = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0089a c0089a);
    }

    public void b(int i, b bVar) {
        if (this.ajl == null) {
            this.ajl = new SparseArray<>();
        }
        List<b> list = this.ajl.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.ajl.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C0089a c0089a) {
        List<b> list = this.ajl.get(c0089a.ajm);
        if (y.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0089a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0089a {
        private int ajm;
        private Object ajn;

        public C0089a(int i, Object obj) {
            this.ajm = i;
            this.ajn = obj;
        }

        public C0089a(int i) {
            this.ajm = i;
        }

        public int getActionType() {
            return this.ajm;
        }

        public void setExtraData(Object obj) {
            this.ajn = obj;
        }

        public Object tr() {
            return this.ajn;
        }
    }
}
