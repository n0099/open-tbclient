package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a {
    private final HashMap<b, Rect> aNL = new HashMap<>();
    private final HashSet<b> aNM = new HashSet<>();
    private final LinkedList<C0172a> aNN = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aNM.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aNM.remove(bVar);
        }
    }

    public void Dv() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aNM.isEmpty()) {
            Iterator<b> it = this.aNM.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aNL.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aNN.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0172a> it = this.aNN.iterator();
            while (it.hasNext()) {
                C0172a next = it.next();
                if (next != null && next.aNO == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0172a c0172a = (C0172a) it2.next();
                    if (c0172a.aNP != null) {
                        c0172a.aNP.setViewTouchable(true);
                    }
                    this.aNN.remove(c0172a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0172a {
        public View aNO;
        public b aNP;

        private C0172a() {
        }
    }
}
