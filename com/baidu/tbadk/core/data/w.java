package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class w {
    private String eyH;
    private int eyI;
    private ArrayList<z> eyJ = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<z> bjG() {
        return this.eyJ;
    }

    public void C(ArrayList<z> arrayList) {
        this.eyJ = arrayList;
    }

    public String bjH() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.eyI = activityHead.activity_type.intValue();
            this.eyH = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            bh(activityHead.head_imgs);
        }
    }

    public void bh(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            z zVar = new z();
            zVar.b(headImgs);
            this.eyJ.add(zVar);
        }
    }
}
