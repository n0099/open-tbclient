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
    private final HashMap<b, Rect> aGH = new HashMap<>();
    private final HashSet<b> aGI = new HashSet<>();
    private final LinkedList<C0162a> aGJ = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aGI.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aGI.remove(bVar);
        }
    }

    public void xC() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aGI.isEmpty()) {
            Iterator<b> it = this.aGI.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aGH.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }

    public void L(View view) {
        if (!this.aGJ.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            Iterator<C0162a> it = this.aGJ.iterator();
            while (it.hasNext()) {
                C0162a next = it.next();
                if (next != null && next.aGK == view) {
                    linkedList.add(next);
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    C0162a c0162a = (C0162a) it2.next();
                    if (c0162a.aGL != null) {
                        c0162a.aGL.setViewTouchable(true);
                    }
                    this.aGJ.remove(c0162a);
                }
            }
        }
    }

    /* renamed from: com.baidu.live.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0162a {
        public View aGK;
        public b aGL;

        private C0162a() {
        }
    }
}
