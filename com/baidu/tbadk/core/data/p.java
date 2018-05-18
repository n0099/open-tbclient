package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p {
    private String Xe;
    private int Xf;
    private ArrayList<r> Xg = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<r> qy() {
        return this.Xg;
    }

    public void f(ArrayList<r> arrayList) {
        this.Xg = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Xf = activityHead.activity_type.intValue();
            this.Xe = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                r rVar = new r();
                rVar.a(headImgs);
                this.Xg.add(rVar);
            }
        }
    }
}
