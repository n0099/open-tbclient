package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes2.dex */
public class o {
    private String aeO;
    private int aeP;
    private ArrayList<q> aeQ = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> tM() {
        return this.aeQ;
    }

    public void j(ArrayList<q> arrayList) {
        this.aeQ = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.aeP = activityHead.activity_type.intValue();
            this.aeO = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            s(activityHead.head_imgs);
        }
    }

    public void s(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.w.z(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            q qVar = new q();
            qVar.b(headImgs);
            this.aeQ.add(qVar);
        }
    }
}
