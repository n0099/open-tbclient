package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static ArrayList<a> bga = new ArrayList<>(5);
    public int bge;
    public int bgf;
    int bgg;
    public int type;

    private void resetState() {
        this.bge = 0;
        this.bgf = 0;
        this.bgg = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long HY() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bge, this.bgf) : ExpandableListView.getPackedPositionForGroup(this.bge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a df(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a HZ = HZ();
        HZ.type = i;
        HZ.bge = i2;
        HZ.bgf = i3;
        HZ.bgg = i4;
        return HZ;
    }

    private static a HZ() {
        a aVar;
        synchronized (bga) {
            if (bga.size() > 0) {
                aVar = bga.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bga) {
            if (bga.size() < 5) {
                bga.add(this);
            }
        }
    }
}
