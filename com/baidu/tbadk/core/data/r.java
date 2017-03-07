package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r {
    private String UT;
    private int UU;
    private ArrayList<t> UV = new ArrayList<>();
    private int height;
    private String obj_id;
    private int width;

    public ArrayList<t> pK() {
        return this.UV;
    }

    public void f(ArrayList<t> arrayList) {
        this.UV = arrayList;
    }

    public String pL() {
        return this.obj_id;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.UU = activityHead.activity_type.intValue();
            this.UT = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            this.obj_id = activityHead.obj_id;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                t tVar = new t();
                tVar.a(headImgs);
                this.UV.add(tVar);
            }
        }
    }
}
