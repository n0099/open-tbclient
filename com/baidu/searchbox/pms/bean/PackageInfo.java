package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PackageInfo implements NoProGuard, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_FILTERD = 1102;
    public static final int CODE_HOST_VERSION = 1103;
    public static final int CODE_NOT_EXISTS = 1101;
    public static final int CODE_SUCCESS = 0;
    public static final String TAG = "PackageInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public String abi;
    public String channelId;
    public long createTime;
    public long currentSize;
    public HashMap<String, String> dependencies;
    public String dependenciesString;
    public int disable;
    public int downloadOption;
    public String downloadUrl;
    public boolean enableXCDN;
    public int errNo;
    public String extraLocal;
    public String extraServer;
    public volatile String filePath;
    public boolean isHitTrafficLimit;
    public boolean isMainEntrance;
    public int isSilence;
    public int isSilentUpgrade;
    public boolean isTrafficForbid;
    public String key;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String netWorkStrategy;
    public String packageName;
    public String patchMD5;
    public String patchUrl;
    public volatile long rawId;
    public int retryCount;
    public String sign;
    public String size;
    public long totalSize;
    public String trafficUrl;
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

    private void appendTrafficParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.downloadUrl);
            if (this.downloadUrl.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("sle=1&split=100&sl=");
            sb.append(str);
            this.trafficUrl = sb.toString();
        }
    }

    private boolean checkTrafficLimitTime(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
            String optString = jSONObject.optString("startTime");
            String optString2 = jSONObject.optString("endTime");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return false;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date parse = simpleDateFormat.parse(optString);
                Date parse2 = simpleDateFormat.parse(optString2);
                long currentTimeMillis = System.currentTimeMillis();
                if (parse == null || parse2 == null || parse.getTime() >= currentTimeMillis) {
                    return false;
                }
                return parse2.getTime() > currentTimeMillis;
            } catch (Exception e2) {
                if (PmsConstant.DEBUG) {
                    String str = "checkTrafficLimitTime fail, exception = " + e2.toString();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean checkTrafficRatio(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, this, str, j2)) == null) {
            CRC32 crc32 = new CRC32();
            crc32.update(str.getBytes());
            boolean z = crc32.getValue() % 100 < j2;
            this.isHitTrafficLimit = z;
            return z;
        }
        return invokeLJ.booleanValue;
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
            packageInfo.abi = this.abi;
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

    public String getNetWorkStrategyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = TextUtils.isEmpty(this.trafficUrl) ? this.downloadUrl : this.trafficUrl;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append(this.netWorkStrategy);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getTrafficUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextUtils.isEmpty(this.trafficUrl) ? this.downloadUrl : this.trafficUrl : (String) invokeV.objValue;
    }

    public boolean isAllowSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isSilence == 1 : invokeV.booleanValue;
    }

    public boolean isAllowSilenceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isSilentUpgrade == 1 : invokeV.booleanValue;
    }

    public boolean isDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.disable == 1 : invokeV.booleanValue;
    }

    public boolean isHitNetWorkStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.enableXCDN : invokeV.booleanValue;
    }

    public boolean isHitTrafficLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isHitTrafficLimit : invokeV.booleanValue;
    }

    public boolean isMainEntrance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.isMainEntrance : invokeV.booleanValue;
    }

    public boolean isOlderThan(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, packageInfo)) == null) ? this.version < packageInfo.version : invokeL.booleanValue;
    }

    public boolean isOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.wifi == 1 : invokeV.booleanValue;
    }

    public boolean isTrafficForbid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.isTrafficForbid : invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.errNo != 0 || TextUtils.isEmpty(this.channelId) || TextUtils.isEmpty(this.packageName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.updateVersion < 0) ? false : true : invokeV.booleanValue;
    }

    public void parseTrafficLimit() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || TextUtils.isEmpty(this.extraServer)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.extraServer);
            if (checkTrafficLimitTime(jSONObject)) {
                if (jSONObject.optInt("limitEnable") == 1) {
                    String optString = jSONObject.optString("speed");
                    if (Long.parseLong(optString) == 0) {
                        return;
                    }
                    long optLong = jSONObject.optLong("ratio");
                    if (optLong == 0) {
                        return;
                    }
                    String cuid = AppCuidManager.getInstance().getCuid();
                    if (TextUtils.isEmpty(cuid)) {
                        return;
                    }
                    if (!checkTrafficRatio(cuid, optLong)) {
                        this.isTrafficForbid = true;
                    } else {
                        appendTrafficParam(optString);
                    }
                }
            }
        } catch (Exception e2) {
            if (PmsConstant.DEBUG) {
                String str = "parseTrafficLimit fail, exception = " + e2.toString();
            }
        }
    }

    public void setDependenciesString(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, jSONObject) == null) || jSONObject == null) {
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

    public void setXCDNEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.enableXCDN = z;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "channelId=" + this.channelId + ",packageName=" + this.packageName + ",version=" + this.version + ",updateVersion=" + this.updateVersion + ",name=" + this.name + ",md5=" + this.md5 + ",type=" + this.type + ",downloadUrl=" + this.downloadUrl + ",extraServer=" + this.extraServer;
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
        this.abi = "";
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
        this.isTrafficForbid = false;
        this.isHitTrafficLimit = false;
        this.isMainEntrance = z;
    }
}
