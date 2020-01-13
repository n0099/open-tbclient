package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes6.dex */
public class r {
    private String cKg;
    private int cKh;
    private ArrayList<t> cKi = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<t> ayh() {
        return this.cKi;
    }

    public void t(ArrayList<t> arrayList) {
        this.cKi = arrayList;
    }

    public String ayi() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.cKh = activityHead.activity_type.intValue();
            this.cKg = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            au(activityHead.head_imgs);
        }
    }

    public void au(List<HeadImgs> list) {
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
            this.cKi.add(tVar);
        }
    }
}
