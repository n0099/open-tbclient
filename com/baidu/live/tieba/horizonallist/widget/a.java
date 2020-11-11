package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
class a {
    private static ArrayList<a> bBe = new ArrayList<>(5);
    public int bBi;
    public int bBj;
    int bBk;
    public int type;

    private void resetState() {
        this.bBi = 0;
        this.bBj = 0;
        this.bBk = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Ti() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.bBi, this.bBj) : ExpandableListView.getPackedPositionForGroup(this.bBi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a fH(int i) {
        return g(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(int i, int i2, int i3, int i4) {
        a Tj = Tj();
        Tj.type = i;
        Tj.bBi = i2;
        Tj.bBj = i3;
        Tj.bBk = i4;
        return Tj;
    }

    private static a Tj() {
        a aVar;
        synchronized (bBe) {
            if (bBe.size() > 0) {
                aVar = bBe.remove(0);
                aVar.resetState();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (bBe) {
            if (bBe.size() < 5) {
                bBe.add(this);
            }
        }
    }
}
