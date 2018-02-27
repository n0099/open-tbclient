package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class o {
    private String aLH;
    private int aLI;
    private ArrayList<q> aLJ = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<q> xS() {
        return this.aLJ;
    }

    public void g(ArrayList<q> arrayList) {
        this.aLJ = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.aLI = activityHead.activity_type.intValue();
            this.aLH = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                q qVar = new q();
                qVar.a(headImgs);
                this.aLJ.add(qVar);
            }
        }
    }
}
