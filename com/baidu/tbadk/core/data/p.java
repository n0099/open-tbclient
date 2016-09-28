package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p {
    private String Qh;
    private int Qi;
    private ArrayList<r> Qj = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<r> pw() {
        return this.Qj;
    }

    public void g(ArrayList<r> arrayList) {
        this.Qj = arrayList;
    }

    public String px() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Qi = activityHead.activity_type.intValue();
            this.Qh = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                r rVar = new r();
                rVar.a(headImgs);
                this.Qj.add(rVar);
            }
        }
    }
}
