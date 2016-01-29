package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class j {
    private String Vj;
    private int Vk;
    private ArrayList<k> Vl = new ArrayList<>();
    private int height;
    private int width;

    public ArrayList<k> rW() {
        return this.Vl;
    }

    public void i(ArrayList<k> arrayList) {
        this.Vl = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.Vk = activityHead.activity_type.intValue();
            this.Vj = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                k kVar = new k();
                kVar.a(headImgs);
                this.Vl.add(kVar);
            }
        }
    }
}
