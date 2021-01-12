package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class w {
    private String eKL;
    private int eKM;
    private ArrayList<z> eKN = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<z> blz() {
        return this.eKN;
    }

    public void x(ArrayList<z> arrayList) {
        this.eKN = arrayList;
    }

    public String blA() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.eKM = activityHead.activity_type.intValue();
            this.eKL = activityHead.activity_title;
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
            this.eKN.add(zVar);
        }
    }
}
