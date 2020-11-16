package com.baidu.card.a;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private SparseArray<List<b>> aiM = new SparseArray<>();

    /* loaded from: classes20.dex */
    public interface b {
        boolean a(C0096a c0096a);
    }

    public void b(int i, b bVar) {
        if (this.aiM == null) {
            this.aiM = new SparseArray<>();
        }
        List<b> list = this.aiM.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.aiM.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C0096a c0096a) {
        List<b> list = this.aiM.get(c0096a.aiN);
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
        private int aiN;
        private Object aiO;

        public C0096a(int i, Object obj) {
            this.aiN = i;
            this.aiO = obj;
        }

        public C0096a(int i) {
            this.aiN = i;
        }

        public int getActionType() {
            return this.aiN;
        }

        public void setExtraData(Object obj) {
            this.aiO = obj;
        }

        public Object ud() {
            return this.aiO;
        }
    }
}
