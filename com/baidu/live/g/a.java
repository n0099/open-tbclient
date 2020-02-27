package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a {
    private final HashMap<b, Rect> aeY = new HashMap<>();
    private final HashSet<b> aeZ = new HashSet<>();
    private final LinkedList<Object> afa = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.aeZ.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aeZ.remove(bVar);
        }
    }

    public void qQ() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.aeZ.isEmpty()) {
            Iterator<b> it = this.aeZ.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.aeY.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }
}
