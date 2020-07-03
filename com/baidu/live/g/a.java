package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a {
    private final HashMap<b, Rect> aFm = new HashMap<>();
    private final HashSet<b> aFn = new HashSet<>();
    private final LinkedList<C0163a> aFo = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aFn.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aFn.remove(bVar);
        }
    }

    public void wZ() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aFn.isEmpty()) {
            Iterator<b> it = this.aFn.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aFm.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void I(View view) {
        if (!this.aFo.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0163a> it = this.aFo.iterator();
            while (it.hasNext()) {
                C0163a next = it.next();
                if (next != null && next.aFp == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0163a c0163a = (C0163a) it2.next();
                    if (c0163a.aFq != null) {
                        c0163a.aFq.setViewTouchable(true);
                    }
                    this.aFo.remove(c0163a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0163a {
        public View aFp;
        public b aFq;

        private C0163a() {
        }
    }
}
