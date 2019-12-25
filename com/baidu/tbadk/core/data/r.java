package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes5.dex */
public class r {
    private String cJV;
    private int cJW;
    private ArrayList<t> cJX = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<t> axO() {
        return this.cJX;
    }

    public void t(ArrayList<t> arrayList) {
        this.cJX = arrayList;
    }

    public String axP() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null) {
            this.cJW = activityHead.activity_type.intValue();
            this.cJV = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            av(activityHead.head_imgs);
        }
    }

    public void av(List<HeadImgs> list) {
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
            this.cJX.add(tVar);
        }
    }
}
