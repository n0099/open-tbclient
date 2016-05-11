package com.baidu.tbadk.core.data;

import tbclient.PushType;
/* loaded from: classes.dex */
public class aj {
    private String NM;
    private String mName;
    private int mType;

    public void a(PushType pushType) {
        if (pushType != null) {
            this.mType = pushType.type.intValue();
            this.mName = pushType.name;
            this.NM = pushType.icon;
        }
    }
}
