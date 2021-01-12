package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
class a {
    private static ArrayList<a> bED = new ArrayList<>(5);
    public int bEH;
    public int bEI;
    int bEJ;
    public int type;

    private void Si() {
        this.bEH = 0;
        this.bEI = 0;
        this.bEJ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Sk() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bEH, this.bEI) : ExpandableListView.getPackedPositionForGroup(this.bEH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ew(int i) {
        return j(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a j(int i, int i2, int i3, int i4) {
        a Sl = Sl();
        Sl.type = i;
        Sl.bEH = i2;
        Sl.bEI = i3;
        Sl.bEJ = i4;
        return Sl;
    }

    private static a Sl() {
        a aVar;
        synchronized (bED) {
            if (bED.size() > 0) {
                aVar = bED.remove(0);
                aVar.Si();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bED) {
            if (bED.size() < 5) {
                bED.add(this);
            }
        }
    }
}
