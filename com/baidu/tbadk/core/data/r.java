package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r {
    private String Wf;
    private int Wg;
    private ArrayList<t> Wh = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<t> pO() {
        return this.Wh;
    }

    public void f(ArrayList<t> arrayList) {
        this.Wh = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Wg = activityHead.activity_type.intValue();
            this.Wf = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                t tVar = new t();
                tVar.a(headImgs);
                this.Wh.add(tVar);
            }
        }
    }
}
