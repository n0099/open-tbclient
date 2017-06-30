package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s {
    private String Ur;
    private int Us;
    private ArrayList<u> Ut = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<u> pB() {
        return this.Ut;
    }

    public void f(ArrayList<u> arrayList) {
        this.Ut = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Us = activityHead.activity_type.intValue();
            this.Ur = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                u uVar = new u();
                uVar.a(headImgs);
                this.Ut.add(uVar);
            }
        }
    }
}
