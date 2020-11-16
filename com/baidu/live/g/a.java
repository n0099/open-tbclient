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
    private final HashMap<b, Rect> aRr = new HashMap<>();
    private final HashSet<b> aRs = new HashSet<>();
    private final LinkedList<C0179a> aRt = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aRs.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aRs.remove(bVar);
        }
    }

    public void Ew() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aRs.isEmpty()) {
            Iterator<b> it = this.aRs.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aRr.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aRt.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0179a> it = this.aRt.iterator();
            while (it.hasNext()) {
                C0179a next = it.next();
                if (next != null && next.aRu == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0179a c0179a = (C0179a) it2.next();
                    if (c0179a.aRv != null) {
                        c0179a.aRv.setViewTouchable(true);
                    }
                    this.aRt.remove(c0179a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0179a {
        public View aRu;
        public b aRv;

        private C0179a() {
        }
    }
}
