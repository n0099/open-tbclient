package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes3.dex */
public class q {
    private String bYt;
    private int bYu;
    private ArrayList<s> bYv = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<s> agW() {
        return this.bYv;
    }

    public void r(ArrayList<s> arrayList) {
        this.bYv = arrayList;
    }

    public String agX() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.bYu = activityHead.activity_type.intValue();
            this.bYt = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            ap(activityHead.head_imgs);
        }
    }

    public void ap(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            s sVar = new s();
            sVar.b(headImgs);
            this.bYv.add(sVar);
        }
    }
}
