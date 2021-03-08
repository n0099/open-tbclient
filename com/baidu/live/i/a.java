package com.baidu.live.i;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class a {
    private final HashMap<b, Rect> aVD = new HashMap<>();
    private final HashSet<b> aVE = new HashSet<>();
    private final LinkedList<C0182a> aVF = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aVE.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aVE.remove(bVar);
        }
    }

    public void CX() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aVE.isEmpty()) {
            Iterator<b> it = this.aVE.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aVD.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aVF.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0182a> it = this.aVF.iterator();
            while (it.hasNext()) {
                C0182a next = it.next();
                if (next != null && next.aVG == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0182a c0182a = (C0182a) it2.next();
                    if (c0182a.aVH != null) {
                        c0182a.aVH.setViewTouchable(true);
                    }
                    this.aVF.remove(c0182a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0182a {
        public View aVG;
        public b aVH;

        private C0182a() {
        }
    }
}
