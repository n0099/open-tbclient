package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class a {
    private static ArrayList<a> avl = new ArrayList<>(5);
    public int avp;
    public int avq;
    int avr;
    public int type;

    private void resetState() {
        this.avp = 0;
        this.avq = 0;
        this.avr = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long xx() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.avp, this.avq) : ExpandableListView.getPackedPositionForGroup(this.avp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ch(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a xy = xy();
        xy.type = i;
        xy.avp = i2;
        xy.avq = i3;
        xy.avr = i4;
        return xy;
    }

    private static a xy() {
        a aVar;
        synchronized (avl) {
            if (avl.size() > 0) {
                aVar = avl.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (avl) {
            if (avl.size() < 5) {
                avl.add(this);
            }
        }
    }
}
