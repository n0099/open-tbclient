package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginNetConfigInfos extends OrmObject implements Serializable {
    private static final long serialVersionUID = 2500429455834004772L;
    private String config_version;
    private List<PluginConfig> plugin_config = new ArrayList();

    /* loaded from: classes.dex */
    public static class Newest extends OrmObject implements Serializable {
        private static final long serialVersionUID = 8713611233991534353L;
        public String version = null;
        public int version_code = 0;
        public String change_log = null;
        public String url = null;
        public String md5 = null;
        public int size = 0;
        public int download_type = 0;
        public int is_force_update = 0;
        public String newest_ext = null;
    }

    /* loaded from: classes.dex */
    public static class PluginConfig extends OrmObject implements Serializable {
        private static final long serialVersionUID = -5184076118455114028L;
        public int enable;
        public int[] enable_version_code;
        public String package_name = null;
        public int version_code = 0;
        public String display_name = null;
        public String forbidden_features = null;
        public int forbidden = -1;
        public String verbose = null;
        public String icon = null;
        public Newest newest = null;
        public int priority = -1;
        public int load_priority = -1;
        public String ext = null;
        public int can_forbidden = 0;
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
        return (PluginNetConfigInfos) OrmObject.objectWithJsonStr(str, PluginNetConfigInfos.class);
    }

    public void addOrUpdateConfig(PluginConfig pluginConfig) {
        if (this.plugin_config != null && this.plugin_config.size() != 0 && pluginConfig != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.plugin_config.size()) {
                    PluginConfig pluginConfig2 = this.plugin_config.get(i2);
                    if (pluginConfig2 == null || TextUtils.isEmpty(pluginConfig2.package_name) || !pluginConfig2.package_name.equals(pluginConfig.package_name)) {
                        i = i2 + 1;
                    } else {
                        this.plugin_config.set(i2, pluginConfig2);
                        return;
                    }
                } else {
                    this.plugin_config.add(pluginConfig);
                    return;
                }
            }
        }
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
