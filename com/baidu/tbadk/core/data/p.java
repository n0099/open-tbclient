package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p {
    private String Xd;
    private int Xe;
    private ArrayList<r> Xf = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<r> qz() {
        return this.Xf;
    }

    public void f(ArrayList<r> arrayList) {
        this.Xf = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Xe = activityHead.activity_type.intValue();
            this.Xd = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                r rVar = new r();
                rVar.a(headImgs);
                this.Xf.add(rVar);
            }
        }
    }
}
