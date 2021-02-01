package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
class a {
    private static ArrayList<a> bIn = new ArrayList<>(5);
    public int bIr;
    public int bIs;
    int bIt;
    public int type;

    private void TP() {
        this.bIr = 0;
        this.bIs = 0;
        this.bIt = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long TR() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bIr, this.bIs) : ExpandableListView.getPackedPositionForGroup(this.bIr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a eA(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a j(int i, int i2, int i3, int i4) {
        a TS = TS();
        TS.type = i;
        TS.bIr = i2;
        TS.bIs = i3;
        TS.bIt = i4;
        return TS;
    }

    private static a TS() {
        a aVar;
        synchronized (bIn) {
            if (bIn.size() > 0) {
                aVar = bIn.remove(0);
                aVar.TP();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bIn) {
            if (bIn.size() < 5) {
                bIn.add(this);
            }
        }
    }
}
