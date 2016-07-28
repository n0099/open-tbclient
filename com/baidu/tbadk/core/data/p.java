package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p {
    private String NL;
    private int NM;
    private ArrayList<q> NN = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> oz() {
        return this.NN;
    }

    public void g(ArrayList<q> arrayList) {
        this.NN = arrayList;
    }

    public String oA() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.NM = activityHead.activity_type.intValue();
            this.NL = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                q qVar = new q();
                qVar.a(headImgs);
                this.NN.add(qVar);
            }
        }
    }
}
