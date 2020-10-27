package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class v {
    private String eux;
    private int euy;
    private ArrayList<y> euz = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<y> bie() {
        return this.euz;
    }

    public void C(ArrayList<y> arrayList) {
        this.euz = arrayList;
    }

    public String bif() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.euy = activityHead.activity_type.intValue();
            this.eux = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            ba(activityHead.head_imgs);
        }
    }

    public void ba(List<HeadImgs> list) {
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
            this.euz.add(yVar);
        }
    }
}
