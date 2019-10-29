package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class a {
    private static ArrayList<a> amT = new ArrayList<>(5);
    public int amX;
    public int amY;
    int amZ;
    public int type;

    private void vf() {
        this.amX = 0;
        this.amY = 0;
        this.amZ = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long vi() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.amX, this.amY) : ExpandableListView.getPackedPositionForGroup(this.amX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bO(int i) {
        return f(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a f(int i, int i2, int i3, int i4) {
        a vj = vj();
        vj.type = i;
        vj.amX = i2;
        vj.amY = i3;
        vj.amZ = i4;
        return vj;
    }

    private static a vj() {
        a aVar;
        synchronized (amT) {
            if (amT.size() > 0) {
                aVar = amT.remove(0);
                aVar.vf();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (amT) {
            if (amT.size() < 5) {
                amT.add(this);
            }
        }
    }
}
