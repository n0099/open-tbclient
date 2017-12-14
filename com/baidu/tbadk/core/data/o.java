package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class o {
    private String VX;
    private int VY;
    private ArrayList<q> VZ = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> pJ() {
        return this.VZ;
    }

    public void f(ArrayList<q> arrayList) {
        this.VZ = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.VY = activityHead.activity_type.intValue();
            this.VX = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                q qVar = new q();
                qVar.a(headImgs);
                this.VZ.add(qVar);
            }
        }
    }
}
