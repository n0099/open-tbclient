package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static ArrayList<a> azC = new ArrayList<>(5);
    public int azG;
    public int azH;
    int azI;
    public int type;

    private void resetState() {
        this.azG = 0;
        this.azH = 0;
        this.azI = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long zQ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.azG, this.azH) : ExpandableListView.getPackedPositionForGroup(this.azG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cx(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a zR = zR();
        zR.type = i;
        zR.azG = i2;
        zR.azH = i3;
        zR.azI = i4;
        return zR;
    }

    private static a zR() {
        a aVar;
        synchronized (azC) {
            if (azC.size() > 0) {
                aVar = azC.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (azC) {
            if (azC.size() < 5) {
                azC.add(this);
            }
        }
    }
}
