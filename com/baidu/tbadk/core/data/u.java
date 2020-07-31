package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class u {
    private String dOo;
    private int dOp;
    private ArrayList<x> dOq = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<x> aUp() {
        return this.dOq;
    }

    public void w(ArrayList<x> arrayList) {
        this.dOq = arrayList;
    }

    public String aUq() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.dOp = activityHead.activity_type.intValue();
            this.dOo = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            aJ(activityHead.head_imgs);
        }
    }

    public void aJ(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            x xVar = new x();
            xVar.b(headImgs);
            this.dOq.add(xVar);
        }
    }
}
