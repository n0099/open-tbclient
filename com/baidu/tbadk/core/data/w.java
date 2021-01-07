package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class w {
    private String ePw;
    private int ePx;
    private ArrayList<z> ePy = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<z> bpt() {
        return this.ePy;
    }

    public void C(ArrayList<z> arrayList) {
        this.ePy = arrayList;
    }

    public String bpu() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.ePx = activityHead.activity_type.intValue();
            this.ePw = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            br(activityHead.head_imgs);
        }
    }

    public void br(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            z zVar = new z();
            zVar.b(headImgs);
            this.ePy.add(zVar);
        }
    }
}
