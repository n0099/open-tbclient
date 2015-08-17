package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PluginSettings implements Serializable, Cloneable {
    private static final long serialVersionUID = 2213073735097926380L;
    private String mContainerVersion;
    private String mForbiddenFeatures;
    private Map<String, PluginSetting> mPlugins = new ConcurrentHashMap();
    private List<String> mForbiddenFeaturesList = new ArrayList();

    public Map<String, PluginSetting> getPlugins() {
        return this.mPlugins;
    }

    public void setPlugins(Map<String, PluginSetting> map) {
        this.mPlugins = map;
    }

    public String getContainerVersion() {
        return this.mContainerVersion;
    }

    public void setContainerSetting(String str) {
        this.mContainerVersion = str;
    }

    public String getForbiddenFeatures() {
        return this.mForbiddenFeatures;
    }

    public void setForbiddenFeatures(String str) {
        String[] split;
        this.mForbiddenFeatures = str;
        this.mForbiddenFeaturesList.clear();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                this.mForbiddenFeaturesList.add(str2);
            }
        }
    }

    public boolean isFeatureForbidden(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (String str2 : this.mForbiddenFeaturesList) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean insertOrUpdatePluginSetting(String str, PluginSetting pluginSetting) {
        if (TextUtils.isEmpty(str) || pluginSetting == null) {
            return false;
        }
        findPluginSetting(str);
        removePluginSetting(str);
        this.mPlugins.put(str, pluginSetting);
        return true;
    }

    public boolean removePluginSetting(String str) {
        if (TextUtils.isEmpty(str) || this.mPlugins.get(str) == null) {
            return false;
        }
        this.mPlugins.remove(str);
        return true;
    }

    public PluginSetting findPluginSetting(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mPlugins.get(str);
    }

    public PluginSetting findPluginSettingByCmd(int i) {
        for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && value.isContainCmd(i)) {
                return value;
            }
        }
        return null;
    }

    public boolean setAllPluginEnable(boolean z) {
        boolean z2 = false;
        for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && value.enable != z) {
                value.enable = z;
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public PluginSettings m5clone() {
        PluginSettings pluginSettings = new PluginSettings();
        pluginSettings.mContainerVersion = this.mContainerVersion;
        pluginSettings.setForbiddenFeatures(this.mForbiddenFeatures);
        for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null) {
                pluginSettings.insertOrUpdatePluginSetting(value.packageName, value.m4clone());
            }
        }
        return pluginSettings;
    }
}
