package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p {
    private String afu;
    private int afv;
    private ArrayList<r> afw = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<r> ua() {
        return this.afw;
    }

    public void j(ArrayList<r> arrayList) {
        this.afw = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.afv = activityHead.activity_type.intValue();
            this.afu = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            t(activityHead.head_imgs);
        }
    }

    public void t(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.w.A(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            r rVar = new r();
            rVar.b(headImgs);
            this.afw.add(rVar);
        }
    }
}
