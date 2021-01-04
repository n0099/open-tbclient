package com.baidu.live.j;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class a {
    private final HashMap<b, Rect> aVL = new HashMap<>();
    private final HashSet<b> aVM = new HashSet<>();
    private final LinkedList<C0191a> aVN = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aVM.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aVM.remove(bVar);
        }
    }

    public void FA() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aVM.isEmpty()) {
            Iterator<b> it = this.aVM.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aVL.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aVN.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0191a> it = this.aVN.iterator();
            while (it.hasNext()) {
                C0191a next = it.next();
                if (next != null && next.aVO == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0191a c0191a = (C0191a) it2.next();
                    if (c0191a.aVP != null) {
                        c0191a.aVP.setViewTouchable(true);
                    }
                    this.aVN.remove(c0191a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0191a {
        public View aVO;
        public b aVP;

        private C0191a() {
        }
    }
}
