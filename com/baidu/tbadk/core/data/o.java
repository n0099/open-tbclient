package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class o {
    private String aKx;
    private int aKy;
    private ArrayList<q> aKz = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> xm() {
        return this.aKz;
    }

    public void g(ArrayList<q> arrayList) {
        this.aKz = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.aKy = activityHead.activity_type.intValue();
            this.aKx = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                q qVar = new q();
                qVar.a(headImgs);
                this.aKz.add(qVar);
            }
        }
    }
}
