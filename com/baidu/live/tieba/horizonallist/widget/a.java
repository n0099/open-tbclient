package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static ArrayList<a> aTD = new ArrayList<>(5);
    public int aTH;
    public int aTI;
    int aTJ;
    public int type;

    private void resetState() {
        this.aTH = 0;
        this.aTI = 0;
        this.aTJ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long EU() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.aTH, this.aTI) : ExpandableListView.getPackedPositionForGroup(this.aTH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cM(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a EV = EV();
        EV.type = i;
        EV.aTH = i2;
        EV.aTI = i3;
        EV.aTJ = i4;
        return EV;
    }

    private static a EV() {
        a aVar;
        synchronized (aTD) {
            if (aTD.size() > 0) {
                aVar = aTD.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (aTD) {
            if (aTD.size() < 5) {
                aTD.add(this);
            }
        }
    }
}
