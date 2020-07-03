package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class u {
    private String dId;
    private int dIe;
    private ArrayList<w> dIf = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<w> aQt() {
        return this.dIf;
    }

    public void v(ArrayList<w> arrayList) {
        this.dIf = arrayList;
    }

    public String aQu() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.dIe = activityHead.activity_type.intValue();
            this.dId = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            aC(activityHead.head_imgs);
        }
    }

    public void aC(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            w wVar = new w();
            wVar.b(headImgs);
            this.dIf.add(wVar);
        }
    }
}
