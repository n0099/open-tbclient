package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class h {
    private String UH;
    private int UI;
    private ArrayList<i> UJ = new ArrayList<>();
    private int height;
    private int width;

    public ArrayList<i> rv() {
        return this.UJ;
    }

    public void h(ArrayList<i> arrayList) {
        this.UJ = arrayList;
    }

    public void a(ActivityHead activityHead) {
        if (activityHead != null && activityHead.head_imgs != null && activityHead.head_imgs.size() != 0) {
            this.UI = activityHead.activity_type.intValue();
            this.UH = activityHead.activity_title;
            this.width = activityHead.top_size == null ? 0 : activityHead.top_size.width.intValue();
            this.height = activityHead.top_size != null ? activityHead.top_size.height.intValue() : 0;
            for (HeadImgs headImgs : activityHead.head_imgs) {
                i iVar = new i();
                iVar.a(headImgs);
                this.UJ.add(iVar);
            }
        }
    }
}
