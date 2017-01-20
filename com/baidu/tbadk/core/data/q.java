package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q {
    private String PG;
    private int PH;
    private ArrayList<s> PI = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<s> ps() {
        return this.PI;
    }

    public void g(ArrayList<s> arrayList) {
        this.PI = arrayList;
    }

    public String pt() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.PH = activityHead.activity_type.intValue();
            this.PG = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                s sVar = new s();
                sVar.a(headImgs);
                this.PI.add(sVar);
            }
        }
    }
}
