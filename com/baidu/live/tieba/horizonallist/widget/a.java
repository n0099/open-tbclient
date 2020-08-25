package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
class a {
    private static ArrayList<a> bmc = new ArrayList<>(5);
    public int bmg;
    public int bmh;
    int bmi;
    public int type;

    private void resetState() {
        this.bmg = 0;
        this.bmh = 0;
        this.bmi = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long NX() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bmg, this.bmh) : ExpandableListView.getPackedPositionForGroup(this.bmg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a eY(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a NY = NY();
        NY.type = i;
        NY.bmg = i2;
        NY.bmh = i3;
        NY.bmi = i4;
        return NY;
    }

    private static a NY() {
        a aVar;
        synchronized (bmc) {
            if (bmc.size() > 0) {
                aVar = bmc.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bmc) {
            if (bmc.size() < 5) {
                bmc.add(this);
            }
        }
    }
}
