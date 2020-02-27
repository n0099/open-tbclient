package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static ArrayList<a> azB = new ArrayList<>(5);
    public int azF;
    public int azG;
    int azH;
    public int type;

    private void resetState() {
        this.azF = 0;
        this.azG = 0;
        this.azH = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long zO() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.azF, this.azG) : ExpandableListView.getPackedPositionForGroup(this.azF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cx(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a zP = zP();
        zP.type = i;
        zP.azF = i2;
        zP.azG = i3;
        zP.azH = i4;
        return zP;
    }

    private static a zP() {
        a aVar;
        synchronized (azB) {
            if (azB.size() > 0) {
                aVar = azB.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (azB) {
            if (azB.size() < 5) {
                azB.add(this);
            }
        }
    }
}
