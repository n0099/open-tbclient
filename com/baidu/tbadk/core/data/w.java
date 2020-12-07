package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class w {
    private String eFG;
    private int eFH;
    private ArrayList<z> eFI = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<z> bmT() {
        return this.eFI;
    }

    public void C(ArrayList<z> arrayList) {
        this.eFI = arrayList;
    }

    public String bmU() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.eFH = activityHead.activity_type.intValue();
            this.eFG = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            bk(activityHead.head_imgs);
        }
    }

    public void bk(List<HeadImgs> list) {
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
            this.eFI.add(zVar);
        }
    }
}
