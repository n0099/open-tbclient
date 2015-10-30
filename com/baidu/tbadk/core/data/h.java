package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class h {
    private String UG;
    private int UH;
    private ArrayList<i> UI = new ArrayList<>();
    private int height;
    private int width;

    public ArrayList<i> ru() {
        return this.UI;
    }

    public void h(ArrayList<i> arrayList) {
        this.UI = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.UH = activityHead.activity_type.intValue();
            this.UG = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                i iVar = new i();
                iVar.a(headImgs);
                this.UI.add(iVar);
            }
        }
    }
}
