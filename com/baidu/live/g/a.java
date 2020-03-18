package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a {
    private final HashMap<b, Rect> afi = new HashMap<>();
    private final HashSet<b> afj = new HashSet<>();
    private final LinkedList<Object> afk = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.afj.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.afj.remove(bVar);
        }
    }

    public void qV() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.afj.isEmpty()) {
            Iterator<b> it = this.afj.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.afi.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }
}
