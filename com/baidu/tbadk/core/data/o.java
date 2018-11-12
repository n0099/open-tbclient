package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes6.dex */
public class o {
    private String amY;
    private int amZ;
    private ArrayList<q> ana = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> xf() {
        return this.ana;
    }

    public void j(ArrayList<q> arrayList) {
        this.ana = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.amZ = activityHead.activity_type.intValue();
            this.amY = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            B(activityHead.head_imgs);
        }
    }

    public void B(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            q qVar = new q();
            qVar.b(headImgs);
            this.ana.add(qVar);
        }
    }
}
