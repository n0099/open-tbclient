package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.NoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PackageInfo implements NoProGuard, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_FILTERD = 1102;
    public static final int CODE_HOST_VERSION = 1103;
    public static final int CODE_NOT_EXISTS = 1101;
    public static final int CODE_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String channelId;
    public long createTime;
    public long currentSize;
    public HashMap<String, String> dependencies;
    public String dependenciesString;
    public int disable;
    public int downloadOption;
    public String downloadUrl;
    public int errNo;
    public String extraLocal;
    public String extraServer;
    public volatile String filePath;
    public boolean isMainEntrance;
    public int isSilence;
    public int isSilentUpgrade;
    public String key;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String packageName;
    public volatile long rawId;
    public int retryCount;
    public String sign;
    public String size;
    public long totalSize;
    public volatile int type;
    public String uniqueID;
    public String updateSign;
    public long updateTime;
    public long updateVersion;
    public long version;
    public int wifi;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PackageInfo() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addDependencies(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) {
            if (this.dependencies == null) {
                this.dependencies = new HashMap<>();
            }
            this.dependencies.put(str, str2);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public void copyDownloadInfo(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo) == null) {
            packageInfo.errNo = this.errNo;
            packageInfo.type = this.type;
            packageInfo.filePath = this.filePath;
            packageInfo.totalSize = this.totalSize;
            packageInfo.currentSize = this.currentSize;
            packageInfo.createTime = this.createTime;
            packageInfo.updateTime = this.updateTime;
        }
    }

    public void copyTo(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, packageInfo) == null) {
            packageInfo.name = this.name;
            packageInfo.extraLocal = this.extraLocal;
            packageInfo.downloadOption = this.downloadOption;
            packageInfo.channelId = this.channelId;
            packageInfo.version = this.version;
            packageInfo.updateVersion = this.updateVersion;
            packageInfo.minHostVersion = this.minHostVersion;
            packageInfo.maxHostVersion = this.maxHostVersion;
            packageInfo.extraServer = this.extraServer;
            packageInfo.downloadUrl = this.downloadUrl;
            packageInfo.packageName = this.packageName;
            packageInfo.disable = this.disable;
            packageInfo.wifi = this.wifi;
            packageInfo.isSilence = this.isSilence;
            packageInfo.isSilentUpgrade = this.isSilentUpgrade;
            packageInfo.sign = this.sign;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj != null && (obj instanceof PackageInfo)) {
                return TextUtils.equals(getKey(), ((PackageInfo) obj).getKey());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Map<String, String> getDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.dependencies : (Map) invokeV.objValue;
    }

    @Nullable
    public String getDependenciesString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.dependenciesString : (String) invokeV.objValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.key) && !TextUtils.isEmpty(this.channelId) && !TextUtils.isEmpty(this.packageName) && !TextUtils.isEmpty(this.md5)) {
                this.key = this.channelId + "_" + this.packageName + "_" + this.md5;
            }
            return this.key;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAllowSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isSilence == 1 : invokeV.booleanValue;
    }

    public boolean isAllowSilenceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isSilentUpgrade == 1 : invokeV.booleanValue;
    }

    public boolean isDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.disable == 1 : invokeV.booleanValue;
    }

    public boolean isMainEntrance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isMainEntrance : invokeV.booleanValue;
    }

    public boolean isOlderThan(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, packageInfo)) == null) ? this.version < packageInfo.version : invokeL.booleanValue;
    }

    public boolean isOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.wifi == 1 : invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.errNo != 0 || TextUtils.isEmpty(this.channelId) || TextUtils.isEmpty(this.packageName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.updateVersion < 0) ? false : true : invokeV.booleanValue;
    }

    public void setDependenciesString(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(next)) {
                addDependencies(next, optString);
            }
        }
        this.dependenciesString = jSONObject.toString();
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "channelId=" + this.channelId + ",packageName=" + this.packageName + ",version=" + this.version + ",updateVersion=" + this.updateVersion + ",name=" + this.name + ",md5=" + this.md5 + ",type=" + this.type + ",downloadUrl=" + this.downloadUrl;
        }
        return (String) invokeV.objValue;
    }

    public PackageInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.errNo = -1;
        this.version = -1L;
        this.updateVersion = 0L;
        this.type = 0;
        this.retryCount = 0;
        this.filePath = "";
        this.totalSize = 0L;
        this.currentSize = 0L;
        this.createTime = 0L;
        this.updateTime = 0L;
        this.rawId = 0L;
        this.uniqueID = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(1000);
        this.isMainEntrance = true;
        this.isMainEntrance = z;
    }
}
