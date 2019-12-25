package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class a {
    private static ArrayList<a> auz = new ArrayList<>(5);
    public int auD;
    public int auE;
    int auF;
    public int type;

    private void resetState() {
        this.auD = 0;
        this.auE = 0;
        this.auF = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long xh() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.auD, this.auE) : ExpandableListView.getPackedPositionForGroup(this.auD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cg(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a xi = xi();
        xi.type = i;
        xi.auD = i2;
        xi.auE = i3;
        xi.auF = i4;
        return xi;
    }

    private static a xi() {
        a aVar;
        synchronized (auz) {
            if (auz.size() > 0) {
                aVar = auz.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (auz) {
            if (auz.size() < 5) {
                auz.add(this);
            }
        }
    }
}
