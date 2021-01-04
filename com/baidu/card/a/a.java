package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private SparseArray<List<b>> akn = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0090a c0090a);
    }

    public void b(int i, b bVar) {
        if (this.akn == null) {
            this.akn = new SparseArray<>();
        }
        List<b> list = this.akn.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.akn.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C0090a c0090a) {
        List<b> list = this.akn.get(c0090a.ako);
        if (x.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0090a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.card.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0090a {
        private int ako;
        private Object akp;

        public C0090a(int i, Object obj) {
            this.ako = i;
            this.akp = obj;
        }

        public C0090a(int i) {
            this.ako = i;
        }

        public int getActionType() {
            return this.ako;
        }

        public void setExtraData(Object obj) {
            this.akp = obj;
        }

        public Object tF() {
            return this.akp;
        }
    }
}
