package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r {
    private String dnD;
    private int dnE;
    private ArrayList<t> dnF = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<t> aIN() {
        return this.dnF;
    }

    public void v(ArrayList<t> arrayList) {
        this.dnF = arrayList;
    }

    public String aIO() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.dnE = activityHead.activity_type.intValue();
            this.dnD = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            aD(activityHead.head_imgs);
        }
    }

    public void aD(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            t tVar = new t();
            tVar.b(headImgs);
            this.dnF.add(tVar);
        }
    }
}
