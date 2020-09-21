package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class v {
    private String dZV;
    private int dZW;
    private ArrayList<y> dZX = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<y> bdC() {
        return this.dZX;
    }

    public void C(ArrayList<y> arrayList) {
        this.dZX = arrayList;
    }

    public String bdD() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.dZW = activityHead.activity_type.intValue();
            this.dZV = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            aN(activityHead.head_imgs);
        }
    }

    public void aN(List<HeadImgs> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            for (HeadImgs headImgs : list) {
                a(headImgs);
            }
        }
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            y yVar = new y();
            yVar.b(headImgs);
            this.dZX.add(yVar);
        }
    }
}
