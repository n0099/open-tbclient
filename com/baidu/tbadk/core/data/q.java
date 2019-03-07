package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class q {
    private String bxQ;
    private int bxR;
    private ArrayList<s> bxS = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<s> Xf() {
        return this.bxS;
    }

    public void l(ArrayList<s> arrayList) {
        this.bxS = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.bxR = activityHead.activity_type.intValue();
            this.bxQ = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            L(activityHead.head_imgs);
        }
    }

    public void L(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            s sVar = new s();
            sVar.b(headImgs);
            this.bxS.add(sVar);
        }
    }
}
