package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class NetworkParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String LAST_NETWORK_TYPE = "last network type";
    public static final String NET_TYPE_ID_DISCONNECT = "5_0";
    public static String TAG = null;
    public static final int UNKOWN_NET_TYPE = 5;
    public static HashMap<String, Integer> netType2Id;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(253984962, "Lcom/baidu/searchbox/logsystem/basic/upload/identity/NetworkParam;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(253984962, "Lcom/baidu/searchbox/logsystem/basic/upload/identity/NetworkParam;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        TAG = "networkparam";
        HashMap<String, Integer> hashMap = new HashMap<>();
        netType2Id = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        netType2Id.put("3GNET", 21);
        netType2Id.put("3GWAP", 22);
        netType2Id.put("CMNET", 31);
        netType2Id.put("UNINET", 32);
        netType2Id.put("CTNET", 33);
        netType2Id.put("CMWAP", 41);
        netType2Id.put("UNIWAP", 42);
        netType2Id.put("CTWAP", 43);
    }

    public NetworkParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = AppRuntime.getAppContext();
    }

    public String addNetWorkParam(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                String currentNetTypeId = getCurrentNetTypeId();
                if (TextUtils.equals(currentNetTypeId, NET_TYPE_ID_DISCONNECT)) {
                    return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).getString(LAST_NETWORK_TYPE, NET_TYPE_ID_DISCONNECT));
                }
                if (TextUtils.isEmpty(currentNetTypeId)) {
                    return str;
                }
                if (!TextUtils.equals(currentNetTypeId, NET_TYPE_ID_DISCONNECT)) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext.getApplicationContext()).edit();
                    edit.putString(LAST_NETWORK_TYPE, currentNetTypeId);
                    edit.apply();
                }
                return UrlUtil.addParam(str, "network", currentNetTypeId);
            }
            return UrlUtil.addParam(str, "network", getCurrentNetTypeId());
        }
        return (String) invokeLZ.objValue;
    }

    public String getCurrentNetTypeId() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long uptimeMillis = DEBUG ? SystemClock.uptimeMillis() : 0L;
            ConnectManager connectManager = new ConnectManager(this.mContext);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            if (!TextUtils.isEmpty(netType)) {
                netType = netType.toUpperCase();
                Integer num = netType2Id.get(netType);
                if (num == null) {
                    num = 5;
                }
                str = num + "_" + subType;
            } else {
                str = ((Object) 5) + "_" + subType;
            }
            if (DEBUG) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                Log.i(TAG, "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
