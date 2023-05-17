package com.baidu.searchbox.cloudcontrol.data;

import java.util.List;
/* loaded from: classes3.dex */
public class ConfigModule {
    public List<ConfigAction> mConfigActions;
    public String mModule;

    public ConfigModule() {
    }

    public List<ConfigAction> getConfigActions() {
        return this.mConfigActions;
    }

    public String getModule() {
        return this.mModule;
    }

    public ConfigModule(String str, List<ConfigAction> list) {
        this.mModule = str;
        this.mConfigActions = list;
    }

    public void setConfigActions(List<ConfigAction> list) {
        this.mConfigActions = list;
    }

    public void setModule(String str) {
        this.mModule = str;
    }
}
