package com.baidu.live.i;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a {
    private final HashMap<b, Rect> aUt = new HashMap<>();
    private final HashSet<b> aUu = new HashSet<>();
    private final LinkedList<C0190a> aUv = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aUu.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aUu.remove(bVar);
        }
    }

    public void Gh() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aUu.isEmpty()) {
            Iterator<b> it = this.aUu.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aUt.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aUv.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0190a> it = this.aUv.iterator();
            while (it.hasNext()) {
                C0190a next = it.next();
                if (next != null && next.aUw == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0190a c0190a = (C0190a) it2.next();
                    if (c0190a.aUx != null) {
                        c0190a.aUx.setViewTouchable(true);
                    }
                    this.aUv.remove(c0190a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0190a {
        public View aUw;
        public b aUx;

        private C0190a() {
        }
    }
}
