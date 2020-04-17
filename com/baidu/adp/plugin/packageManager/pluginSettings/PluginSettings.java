package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class PluginSettings implements Serializable, Cloneable {
    private static final long serialVersionUID = 2213073735097926380L;
    private String mContainerVersion;
    private String mForbiddenFeatures;
    private Map<String, PluginSetting> mPlugins = new ConcurrentHashMap();
    private boolean mHasPatch = false;
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

    public boolean hasPatch() {
        return this.mHasPatch;
    }

    public void setPatch(boolean z) {
        this.mHasPatch = z;
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
        if (!TextUtils.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
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
        Iterator<Map.Entry<String, PluginSetting>> it = this.mPlugins.entrySet().iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                PluginSetting value = it.next().getValue();
                if (value != null && value.enable != z) {
                    value.enable = z;
                    z3 = true;
                }
                z2 = z3;
            } else {
                return z3;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public PluginSettings m14clone() {
        PluginSettings pluginSettings = new PluginSettings();
        pluginSettings.mContainerVersion = this.mContainerVersion;
        pluginSettings.setForbiddenFeatures(this.mForbiddenFeatures);
        for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null) {
                pluginSettings.insertOrUpdatePluginSetting(value.packageName, value.m13clone());
            }
        }
        return pluginSettings;
    }

    public List<PluginSetting> getPluginSettingsSortLoadPriorty() {
        if (this.mPlugins.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
            insertPluginSettings(entry.getValue(), arrayList);
        }
        return arrayList;
    }

    private void insertPluginSettings(PluginSetting pluginSetting, List<PluginSetting> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (pluginSetting.load_priority >= list.get(i2).load_priority) {
                    i = i2 + 1;
                } else {
                    list.add(i2, pluginSetting);
                    return;
                }
            } else {
                list.add(pluginSetting);
                return;
            }
        }
    }
}
