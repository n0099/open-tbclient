package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q {
    private String dBI;
    private int dBJ;
    private ArrayList<s> dBK = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<s> aOG() {
        return this.dBK;
    }

    public void v(ArrayList<s> arrayList) {
        this.dBK = arrayList;
    }

    public String aOH() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.dBJ = activityHead.activity_type.intValue();
            this.dBI = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            ay(activityHead.head_imgs);
        }
    }

    public void ay(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            s sVar = new s();
            sVar.b(headImgs);
            this.dBK.add(sVar);
        }
    }
}
