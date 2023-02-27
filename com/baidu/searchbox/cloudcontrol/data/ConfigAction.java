package com.baidu.searchbox.cloudcontrol.data;
/* loaded from: classes2.dex */
public class ConfigAction {
    public String mAction;
    public String mVersion;

    public ConfigAction(String str, String str2) {
        this.mAction = str;
        this.mVersion = str2;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }
}
