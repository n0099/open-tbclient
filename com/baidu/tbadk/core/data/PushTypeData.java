package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.PushType;
/* loaded from: classes3.dex */
public class PushTypeData implements Serializable {
    public String mIcon;
    public String mName;
    public int mType;

    public String getIcon() {
        return this.mIcon;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }

    public void parserProtobuf(PushType pushType) {
        if (pushType == null) {
            return;
        }
        this.mType = pushType.type.intValue();
        this.mName = pushType.name;
        this.mIcon = pushType.icon;
    }
}
