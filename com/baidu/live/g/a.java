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
    private final HashMap<b, Rect> axE = new HashMap<>();
    private final HashSet<b> axF = new HashSet<>();
    private final LinkedList<C0130a> axG = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.axF.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.axF.remove(bVar);
        }
    }

    public void vl() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.axF.isEmpty()) {
            Iterator<b> it = this.axF.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.axE.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public boolean K(View view) {
        Log.e("LiveDrag", "start checkOverlayView");
        if (view == null || this.axE.isEmpty()) {
            return false;
        }
        L(view);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Log.e("LiveDrag", "drag left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
        boolean z = false;
        for (Map.Entry<b, Rect> entry : this.axE.entrySet()) {
            if (entry.getKey() != null && entry.getKey().vm() && entry.getValue() != null && a(rect, entry.getValue())) {
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
        if (!this.axG.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0130a> it = this.axG.iterator();
            while (it.hasNext()) {
                C0130a next = it.next();
                if (next != null && next.axH == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0130a c0130a = (C0130a) it2.next();
                    if (c0130a.axI != null) {
                        c0130a.axI.setViewTouchable(true);
                    }
                    this.axG.remove(c0130a);
                }
            }
        }
    }

    private void a(View view, b bVar) {
        C0130a c0130a = new C0130a();
        c0130a.axH = view;
        c0130a.axI = bVar;
        this.axG.add(c0130a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0130a {
        public View axH;
        public b axI;

        private C0130a() {
        }
    }
}
