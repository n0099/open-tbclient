package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class PluginSetting implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6614934206499164039L;
    public transient /* synthetic */ FieldHolder $fh;
    public String abandon_apk_path;
    public String apkPath;
    public int[] cmdRangeInt;
    public String cmdRangeStr;
    public String displayName;
    public boolean enable;
    public String ext;
    public boolean forbidden;
    public boolean hasRes;
    public int installStatus;
    public int install_fail_count;
    public boolean isPatch;
    public boolean isThird;
    public int is_inject_classloader;
    public int load_priority;
    public String md5;
    public String packageName;
    public int priority;
    public String replaceMethodClasses;
    public String requireLoad;
    public int rollback;
    public int size;
    public String tempMd5;
    public int tempVersionCode;
    public String url;
    public String version;
    public int versionCode;

    public PluginSetting() {
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
        this.priority = 1000;
        this.load_priority = 1000;
        this.hasRes = false;
        this.isThird = false;
        this.isPatch = false;
        this.replaceMethodClasses = null;
        this.ext = null;
        this.rollback = 0;
    }

    private int[] cmdRange2Int(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (split = str.split(",")) == null) {
                return null;
            }
            int length = split.length;
            int[] iArr = new int[length * 2];
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.isEmpty(split[i2])) {
                    BdLog.e("cmdRange2Int is null");
                    return null;
                }
                String[] split2 = split[i2].split("-");
                if (split2 != null && split2.length == 2) {
                    int d2 = b.d(split2[0], -1);
                    int d3 = b.d(split2[1], -1);
                    if (d2 >= 0 && d3 >= 0 && d2 <= d3) {
                        int i3 = i2 * 2;
                        iArr[i3] = d2;
                        iArr[i3 + 1] = d3;
                    } else {
                        BdLog.e("cmdRange2Int split  toInt error");
                        return null;
                    }
                } else {
                    BdLog.e("cmdRange2Int split by '-' error");
                    return null;
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    private String cmdRange2String(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, iArr)) == null) {
            if (iArr == null || iArr.length == 0 || iArr.length % 2 != 0) {
                return null;
            }
            int length = iArr.length;
            StringBuilder sb = new StringBuilder(50);
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(iArr[i2]);
                if (i2 != length - 1) {
                    if (i2 % 2 == 0) {
                        sb.append("-");
                    } else {
                        sb.append(",");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void addAbandonApk(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.abandon_apk_path)) {
            this.abandon_apk_path = str;
            return;
        }
        this.abandon_apk_path += "," + str;
    }

    public String getAbandon_apk_path() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.abandon_apk_path : (String) invokeV.objValue;
    }

    public String getCmdRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cmdRangeStr : (String) invokeV.objValue;
    }

    public boolean isContainCmd(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int[] iArr = this.cmdRangeInt;
            if (iArr == null) {
                return false;
            }
            int length = iArr.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i3 = 0; i3 < length - 1; i3 += 2) {
                int[] iArr2 = this.cmdRangeInt;
                if (i2 >= iArr2[i3] && i2 <= iArr2[i3 + 1]) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean isInjectClassloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.is_inject_classloader != 0 : invokeV.booleanValue;
    }

    public void setAbandon_apk_path(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.abandon_apk_path = str;
        }
    }

    public void setCmdRange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.cmdRangeInt = cmdRange2Int(str);
            this.cmdRangeStr = str;
        }
    }

    public void setInjectClassloader(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.is_inject_classloader = 1;
            } else {
                this.is_inject_classloader = 0;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public PluginSetting m8clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PluginSetting pluginSetting = new PluginSetting();
            pluginSetting.apkPath = this.apkPath;
            pluginSetting.setCmdRange(this.cmdRangeStr);
            pluginSetting.displayName = this.displayName;
            pluginSetting.enable = this.enable;
            pluginSetting.forbidden = this.forbidden;
            pluginSetting.installStatus = this.installStatus;
            pluginSetting.md5 = this.md5;
            pluginSetting.packageName = this.packageName;
            pluginSetting.requireLoad = this.requireLoad;
            pluginSetting.size = this.size;
            pluginSetting.tempMd5 = this.tempMd5;
            pluginSetting.tempVersionCode = this.tempVersionCode;
            pluginSetting.url = this.url;
            pluginSetting.version = this.version;
            pluginSetting.versionCode = this.versionCode;
            pluginSetting.is_inject_classloader = this.is_inject_classloader;
            pluginSetting.abandon_apk_path = this.abandon_apk_path;
            pluginSetting.install_fail_count = this.install_fail_count;
            pluginSetting.priority = this.priority;
            pluginSetting.hasRes = this.hasRes;
            pluginSetting.isThird = this.isThird;
            pluginSetting.isPatch = this.isPatch;
            pluginSetting.load_priority = this.load_priority;
            pluginSetting.replaceMethodClasses = this.replaceMethodClasses;
            pluginSetting.ext = this.ext;
            pluginSetting.rollback = this.rollback;
            return pluginSetting;
        }
        return (PluginSetting) invokeV.objValue;
    }
}
