package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.PushType;
/* loaded from: classes.dex */
public class PushTypeData implements Serializable {
    private String mIcon;
    private String mName;
    private int mType;

    public int getType() {
        return this.mType;
    }

    public String getName() {
        return this.mName;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public void parserProtobuf(PushType pushType) {
        if (pushType != null) {
            this.mType = pushType.type.intValue();
            this.mName = pushType.name;
            this.mIcon = pushType.icon;
        }
    }
}
