package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private final HashMap<b, Rect> axy = new HashMap<>();
    private final HashSet<b> axz = new HashSet<>();
    private final LinkedList<C0109a> axA = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.axz.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.axz.remove(bVar);
        }
    }

    public void vm() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.axz.isEmpty()) {
            Iterator<b> it = this.axz.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.axy.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public boolean K(View view) {
        Log.e("LiveDrag", "start checkOverlayView");
        if (view == null || this.axy.isEmpty()) {
            return false;
        }
        L(view);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Log.e("LiveDrag", "drag left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
        boolean z = false;
        for (Map.Entry<b, Rect> entry : this.axy.entrySet()) {
            if (entry.getKey() != null && entry.getKey().vn() && entry.getValue() != null && a(rect, entry.getValue())) {
                a(view, entry.getKey());
                entry.getKey().setViewTouchable(false);
                z = true;
            }
            z = z;
        }
        Log.e("LiveDrag", "end checkOverlayView " + z);
        return z;
    }

    private boolean a(Rect rect, Rect rect2) {
        if (rect == null || rect2 == null || !Rect.intersects(rect, rect2)) {
            return false;
        }
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3.height() * rect3.width() > 0;
    }

    public void L(View view) {
        if (!this.axA.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0109a> it = this.axA.iterator();
            while (it.hasNext()) {
                C0109a next = it.next();
                if (next != null && next.axB == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0109a c0109a = (C0109a) it2.next();
                    if (c0109a.axC != null) {
                        c0109a.axC.setViewTouchable(true);
                    }
                    this.axA.remove(c0109a);
                }
            }
        }
    }

    private void a(View view, b bVar) {
        C0109a c0109a = new C0109a();
        c0109a.axB = view;
        c0109a.axC = bVar;
        this.axA.add(c0109a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0109a {
        public View axB;
        public b axC;

        private C0109a() {
        }
    }
}
