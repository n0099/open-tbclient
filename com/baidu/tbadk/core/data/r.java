package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r {
    private String VA;
    private int VB;
    private ArrayList<t> VC = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<t> pK() {
        return this.VC;
    }

    public void f(ArrayList<t> arrayList) {
        this.VC = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.VB = activityHead.activity_type.intValue();
            this.VA = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                t tVar = new t();
                tVar.a(headImgs);
                this.VC.add(tVar);
            }
        }
    }
}
