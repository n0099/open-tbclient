package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class m {
    private String NF;
    private int NG;
    private ArrayList<n> NH = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<n> oS() {
        return this.NH;
    }

    public void f(ArrayList<n> arrayList) {
        this.NH = arrayList;
    }

    public String oT() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.NG = activityHead.activity_type.intValue();
            this.NF = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                n nVar = new n();
                nVar.a(headImgs);
                this.NH.add(nVar);
            }
        }
    }
}
