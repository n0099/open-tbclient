package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class a {
    private final HashMap<b, Rect> aLR = new HashMap<>();
    private final HashSet<b> aLS = new HashSet<>();
    private final LinkedList<C0170a> aLT = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aLS.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aLS.remove(bVar);
        }
    }

    public void Df() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aLS.isEmpty()) {
            Iterator<b> it = this.aLS.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aLR.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aLT.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0170a> it = this.aLT.iterator();
            while (it.hasNext()) {
                C0170a next = it.next();
                if (next != null && next.aLU == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0170a c0170a = (C0170a) it2.next();
                    if (c0170a.aLV != null) {
                        c0170a.aLV.setViewTouchable(true);
                    }
                    this.aLT.remove(c0170a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0170a {
        public View aLU;
        public b aLV;

        private C0170a() {
        }
    }
}
