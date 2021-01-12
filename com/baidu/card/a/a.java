package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private SparseArray<List<b>> ajw = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0089a c0089a);
    }

    public void b(int i, b bVar) {
        if (this.ajw == null) {
            this.ajw = new SparseArray<>();
        }
        List<b> list = this.ajw.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.ajw.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C0089a c0089a) {
        List<b> list = this.ajw.get(c0089a.ajx);
        if (x.isEmpty(list)) {
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
        private int ajx;
        private Object ajy;

        public C0089a(int i, Object obj) {
            this.ajx = i;
            this.ajy = obj;
        }

        public C0089a(int i) {
            this.ajx = i;
        }

        public int getActionType() {
            return this.ajx;
        }

        public void setExtraData(Object obj) {
            this.ajy = obj;
        }

        public Object tu() {
            return this.ajy;
        }
    }
}
