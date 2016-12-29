package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p {
    private String Qw;
    private int Qx;
    private ArrayList<r> Qy = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<r> pz() {
        return this.Qy;
    }

    public void g(ArrayList<r> arrayList) {
        this.Qy = arrayList;
    }

    public String pA() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Qx = activityHead.activity_type.intValue();
            this.Qw = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                r rVar = new r();
                rVar.a(headImgs);
                this.Qy.add(rVar);
            }
        }
    }
}
