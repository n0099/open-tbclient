package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class g {
    private String UE;
    private int UF;
    private ArrayList<h> UG = new ArrayList<>();
    private int height;
    private int width;

    public ArrayList<h> rx() {
        return this.UG;
    }

    public void h(ArrayList<h> arrayList) {
        this.UG = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.UF = activityHead.activity_type.intValue();
            this.UE = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                h hVar = new h();
                hVar.a(headImgs);
                this.UG.add(hVar);
            }
        }
    }
}
