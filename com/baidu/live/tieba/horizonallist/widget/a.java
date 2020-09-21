package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
class a {
    private static ArrayList<a> boY = new ArrayList<>(5);
    public int bpc;
    public int bpd;
    int bpe;
    public int type;

    private void resetState() {
        this.bpc = 0;
        this.bpd = 0;
        this.bpe = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long OA() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bpc, this.bpd) : ExpandableListView.getPackedPositionForGroup(this.bpc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a fj(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a OB = OB();
        OB.type = i;
        OB.bpc = i2;
        OB.bpd = i3;
        OB.bpe = i4;
        return OB;
    }

    private static a OB() {
        a aVar;
        synchronized (boY) {
            if (boY.size() > 0) {
                aVar = boY.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (boY) {
            if (boY.size() < 5) {
                boY.add(this);
            }
        }
    }
}
