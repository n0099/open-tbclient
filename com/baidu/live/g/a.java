package com.baidu.live.g;

import android.graphics.Rect;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class a {
    private final HashMap<b, Rect> acV = new HashMap<>();
    private final HashSet<b> acW = new HashSet<>();
    private final LinkedList<Object> acX = new LinkedList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.acW.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.acW.remove(bVar);
        }
    }

    public void qf() {
        Log.e("LiveDrag", "start refreshViewRect");
        if (!this.acW.isEmpty()) {
            Iterator<b> it = this.acW.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getOverlayView() != null) {
                    Rect rect = new Rect();
                    next.getOverlayView().getGlobalVisibleRect(rect);
                    this.acV.put(next, rect);
                    Log.e("LiveDrag", "view" + next.getOverlayView().getId() + " left=" + rect.left + " top=" + rect.top + " right=" + rect.right + " bottom=" + rect.bottom);
                }
            }
        }
        Log.e("LiveDrag", "end refreshViewRect");
    }
}
