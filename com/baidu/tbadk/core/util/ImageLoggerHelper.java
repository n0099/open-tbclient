package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
/* loaded from: classes5.dex */
public class ImageLoggerHelper {
    public static /* synthetic */ Interceptable $ic;
    public static ImageLoggerHelper mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final long IP_EXPIRE_TIME;
    public String cachedCdnIp;
    public String cachedTiebaIp;
    public long lastGetCdnIpTime;
    public long lastGetTiebaIpTime;

    public ImageLoggerHelper() {
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
        this.lastGetTiebaIpTime = 0L;
        this.lastGetCdnIpTime = 0L;
        this.cachedTiebaIp = "";
        this.cachedCdnIp = "";
        this.IP_EXPIRE_TIME = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    }

    public static ImageLoggerHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                synchronized (ImageLoggerHelper.class) {
                    if (mInstance == null) {
                        mInstance = new ImageLoggerHelper();
                    }
                }
            }
            return mInstance;
        }
        return (ImageLoggerHelper) invokeV.objValue;
    }

    public String getDomainIp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                String host = new URL(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    return null;
                }
                return UtilHelper.getIpFromDomain(host);
            } catch (Exception e2) {
                BdLog.e(e2, true);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String getHiphotosIp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastGetCdnIpTime > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                int indexOf = str.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0 || n.B()) {
                    return "";
                }
                this.lastGetCdnIpTime = currentTimeMillis;
                String replace = str.substring(0, indexOf).replace("http://", "");
                String ipFromDomain = UtilHelper.getIpFromDomain(replace + "hiphotos.baidu.com");
                this.cachedCdnIp = ipFromDomain;
                return ipFromDomain;
            }
            return this.cachedCdnIp;
        }
        return (String) invokeL.objValue;
    }

    public String getTiebaIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastGetTiebaIpTime > AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (n.B()) {
                    return "";
                }
                this.lastGetTiebaIpTime = currentTimeMillis;
                this.cachedTiebaIp = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
            }
            return this.cachedTiebaIp;
        }
        return (String) invokeV.objValue;
    }
}
