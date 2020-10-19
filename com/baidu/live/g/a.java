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
    private final HashMap<b, Rect> aQW = new HashMap<>();
    private final HashSet<b> aQX = new HashSet<>();
    private final LinkedList<C0178a> aQY = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aQX.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aQX.remove(bVar);
        }
    }

    public void Es() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aQX.isEmpty()) {
            Iterator<b> it = this.aQX.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aQW.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aQY.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0178a> it = this.aQY.iterator();
            while (it.hasNext()) {
                C0178a next = it.next();
                if (next != null && next.aQZ == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0178a c0178a = (C0178a) it2.next();
                    if (c0178a.aRa != null) {
                        c0178a.aRa.setViewTouchable(true);
                    }
                    this.aQY.remove(c0178a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0178a {
        public View aQZ;
        public b aRa;

        private C0178a() {
        }
    }
}
