package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class v {
    private String dXL;
    private int dXM;
    private ArrayList<y> dXN = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<y> bcI() {
        return this.dXN;
    }

    public void C(ArrayList<y> arrayList) {
        this.dXN = arrayList;
    }

    public String bcJ() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.dXM = activityHead.activity_type.intValue();
            this.dXL = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            aJ(activityHead.head_imgs);
        }
    }

    public void aJ(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            y yVar = new y();
            yVar.b(headImgs);
            this.dXN.add(yVar);
        }
    }
}
