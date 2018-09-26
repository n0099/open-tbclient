package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes2.dex */
public class o {
    private String ahp;
    private int ahq;
    private ArrayList<q> ahr = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> uO() {
        return this.ahr;
    }

    public void j(ArrayList<q> arrayList) {
        this.ahr = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.ahq = activityHead.activity_type.intValue();
            this.ahp = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            s(activityHead.head_imgs);
        }
    }

    public void s(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.z(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            q qVar = new q();
            qVar.b(headImgs);
            this.ahr.add(qVar);
        }
    }
}
