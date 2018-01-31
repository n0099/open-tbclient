package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class o {
    private ArrayList<q> aKA = new ArrayList<>();
    private String aKy;
    private int aKz;
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> xm() {
        return this.aKA;
    }

    public void g(ArrayList<q> arrayList) {
        this.aKA = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.aKz = activityHead.activity_type.intValue();
            this.aKy = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                q qVar = new q();
                qVar.a(headImgs);
                this.aKA.add(qVar);
            }
        }
    }
}
