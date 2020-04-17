package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
class a {
    private static ArrayList<a> aTy = new ArrayList<>(5);
    public int aTC;
    public int aTD;
    int aTE;
    public int type;

    private void resetState() {
        this.aTC = 0;
        this.aTD = 0;
        this.aTE = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long EV() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.aTC, this.aTD) : ExpandableListView.getPackedPositionForGroup(this.aTC);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cM(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a EW = EW();
        EW.type = i;
        EW.aTC = i2;
        EW.aTD = i3;
        EW.aTE = i4;
        return EW;
    }

    private static a EW() {
        a aVar;
        synchronized (aTy) {
            if (aTy.size() > 0) {
                aVar = aTy.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (aTy) {
            if (aTy.size() < 5) {
                aTy.add(this);
            }
        }
    }
}
