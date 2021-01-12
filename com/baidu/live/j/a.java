package com.baidu.live.j;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class a {
    private final HashMap<b, Rect> aQY = new HashMap<>();
    private final HashSet<b> aQZ = new HashSet<>();
    private final LinkedList<C0182a> aRa = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aQZ.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aQZ.remove(bVar);
        }
    }

    public void BF() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aQZ.isEmpty()) {
            Iterator<b> it = this.aQZ.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aQY.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aRa.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0182a> it = this.aRa.iterator();
            while (it.hasNext()) {
                C0182a next = it.next();
                if (next != null && next.aRb == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0182a c0182a = (C0182a) it2.next();
                    if (c0182a.aRc != null) {
                        c0182a.aRc.setViewTouchable(true);
                    }
                    this.aRa.remove(c0182a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0182a {
        public View aRb;
        public b aRc;

        private C0182a() {
        }
    }
}
