package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class q {
    private String bGj;
    private int bGk;
    private ArrayList<s> bGl = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<s> acL() {
        return this.bGl;
    }

    public void o(ArrayList<s> arrayList) {
        this.bGl = arrayList;
    }

    public String acM() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.bGk = activityHead.activity_type.intValue();
            this.bGj = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            S(activityHead.head_imgs);
        }
    }

    public void S(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            s sVar = new s();
            sVar.b(headImgs);
            this.bGl.add(sVar);
        }
    }
}
