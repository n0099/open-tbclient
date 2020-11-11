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
    private final HashMap<b, Rect> aTc = new HashMap<>();
    private final HashSet<b> aTd = new HashSet<>();
    private final LinkedList<C0181a> aTe = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aTd.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aTd.remove(bVar);
        }
    }

    public void Ff() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aTd.isEmpty()) {
            Iterator<b> it = this.aTd.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aTc.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aTe.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0181a> it = this.aTe.iterator();
            while (it.hasNext()) {
                C0181a next = it.next();
                if (next != null && next.aTf == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0181a c0181a = (C0181a) it2.next();
                    if (c0181a.aTg != null) {
                        c0181a.aTg.setViewTouchable(true);
                    }
                    this.aTe.remove(c0181a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0181a {
        public View aTf;
        public b aTg;

        private C0181a() {
        }
    }
}
