package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class v {
    private String elX;
    private int elY;
    private ArrayList<y> elZ = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<y> bgl() {
        return this.elZ;
    }

    public void C(ArrayList<y> arrayList) {
        this.elZ = arrayList;
    }

    public String bgm() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.elY = activityHead.activity_type.intValue();
            this.elX = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            aQ(activityHead.head_imgs);
        }
    }

    public void aQ(List<HeadImgs> list) {
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
            this.elZ.add(yVar);
        }
    }
}
