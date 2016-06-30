package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class o {
    private String NE;
    private int NF;
    private ArrayList<p> NG = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<p> oK() {
        return this.NG;
    }

    public void f(ArrayList<p> arrayList) {
        this.NG = arrayList;
    }

    public String oL() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.NF = activityHead.activity_type.intValue();
            this.NE = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                p pVar = new p();
                pVar.a(headImgs);
                this.NG.add(pVar);
            }
        }
    }
}
