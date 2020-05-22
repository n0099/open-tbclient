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
    private final HashMap<b, Rect> aCU = new HashMap<>();
    private final HashSet<b> aCV = new HashSet<>();
    private final LinkedList<C0161a> aCW = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aCV.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aCV.remove(bVar);
        }
    }

    public void wB() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aCV.isEmpty()) {
            Iterator<b> it = this.aCV.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aCU.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public boolean J(View view) {
        Log.e("LiveDrag", "start checkOverlayView");
        if (view == null || this.aCU.isEmpty()) {
            return false;
        }
        K(view);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Log.e("LiveDrag", "drag left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
        boolean z = false;
        for (Map.Entry<b, Rect> entry : this.aCU.entrySet()) {
            if (entry.getKey() != null && entry.getKey().wC() && entry.getValue() != null && a(rect, entry.getValue())) {
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

    public void K(View view) {
        if (!this.aCW.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0161a> it = this.aCW.iterator();
            while (it.hasNext()) {
                C0161a next = it.next();
                if (next != null && next.aCX == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0161a c0161a = (C0161a) it2.next();
                    if (c0161a.aCY != null) {
                        c0161a.aCY.setViewTouchable(true);
                    }
                    this.aCW.remove(c0161a);
                }
            }
        }
    }

    private void a(View view, b bVar) {
        C0161a c0161a = new C0161a();
        c0161a.aCX = view;
        c0161a.aCY = bVar;
        this.aCW.add(c0161a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0161a {
        public View aCX;
        public b aCY;

        private C0161a() {
        }
    }
}
