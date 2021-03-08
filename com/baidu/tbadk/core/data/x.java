package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class x {
    private ArrayList<aa> eOA = new ArrayList<>();
    private String eOy;
    private int eOz;
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<aa> blT() {
        return this.eOA;
    }

    public void x(ArrayList<aa> arrayList) {
        this.eOA = arrayList;
    }

    public String blU() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.eOz = activityHead.activity_type.intValue();
            this.eOy = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            bm(activityHead.head_imgs);
        }
    }

    public void bm(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            aa aaVar = new aa();
            aaVar.b(headImgs);
            this.eOA.add(aaVar);
        }
    }
}
