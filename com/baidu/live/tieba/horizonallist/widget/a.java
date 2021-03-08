package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
class a {
    private static ArrayList<a> bJN = new ArrayList<>(5);
    public int bJR;
    public int bJS;
    int bJT;
    public int type;

    private void TS() {
        this.bJR = 0;
        this.bJS = 0;
        this.bJT = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long TU() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bJR, this.bJS) : ExpandableListView.getPackedPositionForGroup(this.bJR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a eB(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a j(int i, int i2, int i3, int i4) {
        a TV = TV();
        TV.type = i;
        TV.bJR = i2;
        TV.bJS = i3;
        TV.bJT = i4;
        return TV;
    }

    private static a TV() {
        a aVar;
        synchronized (bJN) {
            if (bJN.size() > 0) {
                aVar = bJN.remove(0);
                aVar.TS();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bJN) {
            if (bJN.size() < 5) {
                bJN.add(this);
            }
        }
    }
}
