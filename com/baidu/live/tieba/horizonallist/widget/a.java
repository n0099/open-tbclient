package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
class a {
    private static ArrayList<a> bsL = new ArrayList<>(5);
    public int bsP;
    public int bsQ;
    int bsR;
    public int type;

    private void resetState() {
        this.bsP = 0;
        this.bsQ = 0;
        this.bsR = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long PF() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bsP, this.bsQ) : ExpandableListView.getPackedPositionForGroup(this.bsP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a fs(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a PG = PG();
        PG.type = i;
        PG.bsP = i2;
        PG.bsQ = i3;
        PG.bsR = i4;
        return PG;
    }

    private static a PG() {
        a aVar;
        synchronized (bsL) {
            if (bsL.size() > 0) {
                aVar = bsL.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bsL) {
            if (bsL.size() < 5) {
                bsL.add(this);
            }
        }
    }
}
