package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
class a {
    private static ArrayList<a> bEB = new ArrayList<>(5);
    public int bEF;
    public int bEG;
    int bEH;
    public int type;

    private void UW() {
        this.bEF = 0;
        this.bEG = 0;
        this.bEH = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long UZ() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bEF, this.bEG) : ExpandableListView.getPackedPositionForGroup(this.bEF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a gb(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a j(int i, int i2, int i3, int i4) {
        a Va = Va();
        Va.type = i;
        Va.bEF = i2;
        Va.bEG = i3;
        Va.bEH = i4;
        return Va;
    }

    private static a Va() {
        a aVar;
        synchronized (bEB) {
            if (bEB.size() > 0) {
                aVar = bEB.remove(0);
                aVar.UW();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bEB) {
            if (bEB.size() < 5) {
                bEB.add(this);
            }
        }
    }
}
