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
    private final HashMap<b, Rect> aRK = new HashMap<>();
    private final HashSet<b> aRL = new HashSet<>();
    private final LinkedList<C0179a> aRM = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aRL.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aRL.remove(bVar);
        }
    }

    public void EE() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aRL.isEmpty()) {
            Iterator<b> it = this.aRL.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aRK.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aRM.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0179a> it = this.aRM.iterator();
            while (it.hasNext()) {
                C0179a next = it.next();
                if (next != null && next.aRN == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0179a c0179a = (C0179a) it2.next();
                    if (c0179a.aRO != null) {
                        c0179a.aRO.setViewTouchable(true);
                    }
                    this.aRM.remove(c0179a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0179a {
        public View aRN;
        public b aRO;

        private C0179a() {
        }
    }
}
