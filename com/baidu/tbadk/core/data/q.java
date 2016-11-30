package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q {
    private int QA;
    private ArrayList<s> QB = new ArrayList<>();
    private String Qz;
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<s> pz() {
        return this.QB;
    }

    public void g(ArrayList<s> arrayList) {
        this.QB = arrayList;
    }

    public String pA() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.QA = activityHead.activity_type.intValue();
            this.Qz = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                s sVar = new s();
                sVar.a(headImgs);
                this.QB.add(sVar);
            }
        }
    }
}
