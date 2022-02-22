package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class PluginSettings implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2213073735097926380L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mContainerVersion;
    public String mForbiddenFeatures;
    public List<String> mForbiddenFeaturesList;
    public boolean mHasPatch;
    public Map<String, PluginSetting> mPlugins;

    public PluginSettings() {
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
        this.mPlugins = new ConcurrentHashMap();
        this.mHasPatch = false;
        this.mForbiddenFeaturesList = new ArrayList();
    }

    private void insertPluginSettings(PluginSetting pluginSetting, List<PluginSetting> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, pluginSetting, list) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (pluginSetting.load_priority < list.get(i2).load_priority) {
                    list.add(i2, pluginSetting);
                    return;
                }
            }
            list.add(pluginSetting);
        }
    }

    public PluginSetting findPluginSetting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mPlugins.get(str);
        }
        return (PluginSetting) invokeL.objValue;
    }

    public PluginSetting findPluginSettingByCmd(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && value.isContainCmd(i2)) {
                    return value;
                }
            }
            return null;
        }
        return (PluginSetting) invokeI.objValue;
    }

    public String getContainerVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mContainerVersion : (String) invokeV.objValue;
    }

    public String getForbiddenFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mForbiddenFeatures : (String) invokeV.objValue;
    }

    public List<PluginSetting> getPluginSettingsSortLoadPriorty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mPlugins.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
                insertPluginSettings(entry.getValue(), arrayList);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public Map<String, PluginSetting> getPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPlugins : (Map) invokeV.objValue;
    }

    public boolean hasPatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mHasPatch : invokeV.booleanValue;
    }

    public boolean insertOrUpdatePluginSetting(String str, PluginSetting pluginSetting) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, pluginSetting)) == null) {
            if (TextUtils.isEmpty(str) || pluginSetting == null) {
                return false;
            }
            this.mPlugins.put(str, pluginSetting);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isFeatureForbidden(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public boolean removePluginSetting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str) || this.mPlugins.get(str) == null) {
                return false;
            }
            this.mPlugins.remove(str);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean setAllPluginEnable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
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
        return invokeZ.booleanValue;
    }

    public void setContainerSetting(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mContainerVersion = str;
        }
    }

    public void setForbiddenFeatures(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mForbiddenFeatures = str;
            this.mForbiddenFeaturesList.clear();
            if (TextUtils.isEmpty(str) || (split = str.split(",")) == null) {
                return;
            }
            for (String str2 : split) {
                this.mForbiddenFeaturesList.add(str2);
            }
        }
    }

    public void setPatch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mHasPatch = z;
        }
    }

    public void setPlugins(Map<String, PluginSetting> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            this.mPlugins = map;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public PluginSettings m29clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PluginSettings pluginSettings = new PluginSettings();
            pluginSettings.mContainerVersion = this.mContainerVersion;
            pluginSettings.setForbiddenFeatures(this.mForbiddenFeatures);
            for (Map.Entry<String, PluginSetting> entry : this.mPlugins.entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null) {
                    pluginSettings.insertOrUpdatePluginSetting(value.packageName, value.m28clone());
                }
            }
            return pluginSettings;
        }
        return (PluginSettings) invokeV.objValue;
    }
}
