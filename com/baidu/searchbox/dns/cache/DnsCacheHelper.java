package com.baidu.searchbox.dns.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DnsCacheHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIR_NAME = "dns";
    public static final String SP_BACKUPIP_KEY = "SP_BACKUPIP_KEY";
    public static final String SP_BACKUPIP_VERSION_KEY = "SP_BACKUPIP_VERSION_KEY";
    public static final String SP_DNS_KEY = "dns_prefs";
    public static volatile DnsCacheHelper cacheHelper;
    public transient /* synthetic */ FieldHolder $fh;
    public ICache backupCache;
    public ICache cache;
    public boolean isIPv6TestArea;
    public volatile int mAddressType;
    public volatile String mAreaInfo;
    public volatile String mClientIp;
    public volatile String mHttpdnsIp;
    public volatile boolean mIdcToBgp;
    public volatile long mLastAreaInfoUpdateTime;

    public DnsCacheHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isIPv6TestArea = false;
        this.mIdcToBgp = false;
        this.cache = new MemCache();
        this.backupCache = new MemCache();
    }

    public static DnsCacheHelper getCacheHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return cacheHelper;
        }
        return (DnsCacheHelper) invokeV.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.cache.clear();
            this.backupCache.clear();
            this.isIPv6TestArea = false;
            this.mAreaInfo = null;
            this.mClientIp = null;
            this.mLastAreaInfoUpdateTime = -1L;
        }
    }

    public int getAddressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAddressType;
        }
        return invokeV.intValue;
    }

    public String getAreaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mAreaInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getClientIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mClientIp;
        }
        return (String) invokeV.objValue;
    }

    public String getDiskBackUpIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).getString(SP_BACKUPIP_KEY, "");
        }
        return (String) invokeV.objValue;
    }

    public String getDiskBackUpIpVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).getString(SP_BACKUPIP_VERSION_KEY, "0");
        }
        return (String) invokeV.objValue;
    }

    public String getHttpdnsIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mHttpdnsIp;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIdcToBgp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mIdcToBgp;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsIPv6TestArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isIPv6TestArea;
        }
        return invokeV.booleanValue;
    }

    public long getLastAreaInfoUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mLastAreaInfoUpdateTime;
        }
        return invokeV.longValue;
    }

    public boolean isIPv6TestArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isIPv6TestArea;
        }
        return invokeV.booleanValue;
    }

    public static void initCacheHelper(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, context) == null) && cacheHelper == null) {
            synchronized (DnsCacheHelper.class) {
                if (cacheHelper == null) {
                    cacheHelper = new DnsCacheHelper();
                }
            }
        }
    }

    public void cacheBackUpIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SharedPreferences.Editor edit = KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).edit();
            edit.putString(SP_BACKUPIP_KEY, str);
            edit.apply();
        }
    }

    public void cacheBackUpIpVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            SharedPreferences.Editor edit = KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).edit();
            edit.putString(SP_BACKUPIP_VERSION_KEY, str);
            edit.apply();
        }
    }

    public DnsModel get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String str2 = this.cache.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return new DnsModel(str2);
            }
            return null;
        }
        return (DnsModel) invokeL.objValue;
    }

    public void setAddressType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mAddressType = i;
        }
    }

    public void setAreaInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mAreaInfo = str;
        }
    }

    public void setClientIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mClientIp = str;
        }
    }

    public void setHttpdnsIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mHttpdnsIp = str;
        }
    }

    public void setIdcToBgp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mIdcToBgp = z;
        }
    }

    public void setIsIPv6TestArea(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.isIPv6TestArea = z;
        }
    }

    public void setLastAreaInfoUpdateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.mLastAreaInfoUpdateTime = j;
        }
    }

    public DnsModel getBackup(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                if (this.backupCache.isEmpty()) {
                    String diskBackUpIp = getDiskBackUpIp();
                    if (TextUtils.isEmpty(diskBackUpIp)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(diskBackUpIp);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject = jSONObject.optJSONObject(next);
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("ip");
                            ArrayList arrayList = new ArrayList(optJSONArray.length());
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.getString(i));
                            }
                            if (!arrayList.isEmpty()) {
                                putBackup(next, new DnsModel(null, 0, null, null, getHttpdnsIp(), getAddressType(), getIdcToBgp(), 0L, arrayList, null));
                            }
                        }
                    }
                }
                String str2 = this.backupCache.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    return new DnsModel(str2);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (DnsModel) invokeL.objValue;
    }

    public void put(String str, DnsModel dnsModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, dnsModel) == null) && dnsModel != null) {
            String dnsModel2 = dnsModel.toString();
            if (!TextUtils.isEmpty(dnsModel2)) {
                this.cache.put(str, dnsModel2);
            }
        }
    }

    public void putBackup(String str, DnsModel dnsModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, str, dnsModel) == null) && dnsModel != null) {
            String dnsModel2 = dnsModel.toString();
            if (!TextUtils.isEmpty(dnsModel2)) {
                this.backupCache.put(str, dnsModel2);
            }
        }
    }
}
