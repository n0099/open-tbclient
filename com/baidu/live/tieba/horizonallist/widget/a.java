package com.baidu.live.tieba.horizonallist.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class a {
    private static ArrayList<a> amB = new ArrayList<>(5);
    public int amF;
    public int amG;
    int amH;
    public int type;

    private void vg() {
        this.amF = 0;
        this.amG = 0;
        this.amH = 0;
        this.type = 0;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long vj() {
        return this.type == 1 ? ExpandableListView.getPackedPositionForChild(this.amF, this.amG) : ExpandableListView.getPackedPositionForGroup(this.amF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bO(int i) {
        return f(2, i, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a f(int i, int i2, int i3, int i4) {
        a vk = vk();
        vk.type = i;
        vk.amF = i2;
        vk.amG = i3;
        vk.amH = i4;
        return vk;
    }

    private static a vk() {
        a aVar;
        synchronized (amB) {
            if (amB.size() > 0) {
                aVar = amB.remove(0);
                aVar.vg();
            } else {
                aVar = new a();
            }
        }
        return aVar;
    }

    public void recycle() {
        synchronized (amB) {
            if (amB.size() < 5) {
                amB.add(this);
            }
        }
    }
}
