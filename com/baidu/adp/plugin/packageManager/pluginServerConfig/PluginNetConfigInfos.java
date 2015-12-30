package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import android.text.TextUtils;
import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginNetConfigInfos extends i implements Serializable {
    private static final long serialVersionUID = 2500429455834004772L;
    private String config_version;
    private List<PluginConfig> plugin_config = new ArrayList();

    /* loaded from: classes.dex */
    public static class Newest extends i implements Serializable {
        private static final long serialVersionUID = 8713611233991534353L;
        public String change_log;
        public int download_type;
        public int is_force_update;
        public String md5;
        public String newest_ext;
        public int size;
        public String url;
        public String version;
        public int version_code;
    }

    /* loaded from: classes.dex */
    public static class PluginConfig extends i implements Serializable {
        private static final long serialVersionUID = -5184076118455114028L;
        public String display_name;
        public int enable;
        public String ext;
        public int forbidden;
        public String forbidden_features;
        public String icon;
        public Newest newest;
        public String package_name;
        public String verbose;
        public int version_code;
        public int priority = 1000;
        public int load_priority = 1000;
    }

    public String getConfig_version() {
        return this.config_version;
    }

    public List<PluginConfig> getConfigs() {
        return this.plugin_config;
    }

    public static PluginNetConfigInfos parse(String str) {
        if (str == null) {
            return null;
        }
        return (PluginNetConfigInfos) i.objectWithJsonStr(str, PluginNetConfigInfos.class);
    }

    public PluginConfig getPluginConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.plugin_config == null || this.plugin_config.size() == 0) {
            return null;
        }
        for (PluginConfig pluginConfig : this.plugin_config) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name) && pluginConfig.package_name.equals(str)) {
                return pluginConfig;
            }
        }
        return null;
    }
}
