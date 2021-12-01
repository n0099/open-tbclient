package com.baidu.adp.plugin.packageManager.pluginServerConfig;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PluginNetConfigInfos extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2500429455834004772L;
    public transient /* synthetic */ FieldHolder $fh;
    public String config_version;
    public List<PluginConfig> plugin_config;

    /* loaded from: classes8.dex */
    public static class Newest extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8713611233991534353L;
        public transient /* synthetic */ FieldHolder $fh;
        public String change_log;
        public int download_type;
        public int is_force_update;
        public String md5;
        public String newest_ext;
        public int size;
        public String url;
        public String version;
        public int version_code;

        public Newest() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.version = null;
            this.version_code = 0;
            this.change_log = null;
            this.url = null;
            this.md5 = null;
            this.size = 0;
            this.download_type = 0;
            this.is_force_update = 0;
            this.newest_ext = null;
        }
    }

    /* loaded from: classes8.dex */
    public static class PluginConfig extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5184076118455114028L;
        public transient /* synthetic */ FieldHolder $fh;
        public int can_forbidden;
        public String display_name;
        public int enable;
        public int[] enable_version_code;
        public String ext;
        public int forbidden;
        public String forbidden_features;
        public String icon;
        public int load_priority;
        public Newest newest;
        public String package_name;
        public int priority;
        public String verbose;
        public int version_code;

        public PluginConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.package_name = null;
            this.version_code = 0;
            this.display_name = null;
            this.forbidden_features = null;
            this.forbidden = -1;
            this.verbose = null;
            this.icon = null;
            this.newest = null;
            this.priority = -1;
            this.load_priority = -1;
            this.ext = null;
            this.can_forbidden = 0;
        }
    }

    public PluginNetConfigInfos() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.plugin_config = new ArrayList();
    }

    public static PluginNetConfigInfos parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return (PluginNetConfigInfos) OrmObject.objectWithJsonStr(str, PluginNetConfigInfos.class);
        }
        return (PluginNetConfigInfos) invokeL.objValue;
    }

    public void addOrUpdateConfig(PluginConfig pluginConfig) {
        List<PluginConfig> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pluginConfig) == null) || (list = this.plugin_config) == null || list.size() == 0 || pluginConfig == null) {
            return;
        }
        for (int i2 = 0; i2 < this.plugin_config.size(); i2++) {
            PluginConfig pluginConfig2 = this.plugin_config.get(i2);
            if (pluginConfig2 != null && !TextUtils.isEmpty(pluginConfig2.package_name) && pluginConfig2.package_name.equals(pluginConfig.package_name)) {
                this.plugin_config.set(i2, pluginConfig2);
                return;
            }
        }
        this.plugin_config.add(pluginConfig);
    }

    public String getConfig_version() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.config_version : (String) invokeV.objValue;
    }

    public List<PluginConfig> getConfigs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.plugin_config : (List) invokeV.objValue;
    }

    public PluginConfig getPluginConfig(String str) {
        InterceptResult invokeL;
        List<PluginConfig> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.plugin_config) != null && list.size() != 0) {
                for (PluginConfig pluginConfig : this.plugin_config) {
                    if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name) && pluginConfig.package_name.equals(str)) {
                        return pluginConfig;
                    }
                }
            }
            return null;
        }
        return (PluginConfig) invokeL.objValue;
    }
}
