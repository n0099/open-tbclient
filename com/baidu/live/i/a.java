package com.baidu.live.i;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public class a {
    private final HashMap<b, Rect> aUd = new HashMap<>();
    private final HashSet<b> aUe = new HashSet<>();
    private final LinkedList<C0176a> aUf = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aUe.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aUe.remove(bVar);
        }
    }

    public void CU() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aUe.isEmpty()) {
            Iterator<b> it = this.aUe.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aUd.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aUf.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0176a> it = this.aUf.iterator();
            while (it.hasNext()) {
                C0176a next = it.next();
                if (next != null && next.aUg == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0176a c0176a = (C0176a) it2.next();
                    if (c0176a.aUh != null) {
                        c0176a.aUh.setViewTouchable(true);
                    }
                    this.aUf.remove(c0176a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0176a {
        public View aUg;
        public b aUh;

        private C0176a() {
        }
    }
}
