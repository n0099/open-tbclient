package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static ArrayList<a> azD = new ArrayList<>(5);
    public int azH;
    public int azI;
    int azJ;
    public int type;

    private void resetState() {
        this.azH = 0;
        this.azI = 0;
        this.azJ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long zQ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.azH, this.azI) : ExpandableListView.getPackedPositionForGroup(this.azH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cx(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a zR = zR();
        zR.type = i;
        zR.azH = i2;
        zR.azI = i3;
        zR.azJ = i4;
        return zR;
    }

    private static a zR() {
        a aVar;
        synchronized (azD) {
            if (azD.size() > 0) {
                aVar = azD.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (azD) {
            if (azD.size() < 5) {
                azD.add(this);
            }
        }
    }
}
