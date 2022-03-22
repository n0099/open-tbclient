package com.baidu.sofire.rp.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ReportConfigInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String aliveLogId;
    public String installLogId;
    public String pkgName;
    public String sdkName;
    public String sdkVersion;

    public ReportConfigInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String configInfoToString(ReportConfigInfo reportConfigInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, reportConfigInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("0", reportConfigInfo.sdkName);
                jSONObject.put("1", reportConfigInfo.sdkVersion);
                jSONObject.put("2", reportConfigInfo.aliveLogId);
                jSONObject.put("3", reportConfigInfo.installLogId);
                jSONObject.put("4", reportConfigInfo.pkgName);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static ReportConfigInfo stringToConfigInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ReportConfigInfo reportConfigInfo = new ReportConfigInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                reportConfigInfo.sdkName = jSONObject.optString("0");
                reportConfigInfo.sdkVersion = jSONObject.optString("1");
                reportConfigInfo.aliveLogId = jSONObject.optString("2");
                reportConfigInfo.installLogId = jSONObject.optString("3");
                reportConfigInfo.pkgName = jSONObject.optString("4");
                return reportConfigInfo;
            } catch (Exception e2) {
                CommonMethods.handleNuLException(e2);
                return null;
            }
        }
        return (ReportConfigInfo) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ReportConfigInfo.class == obj.getClass()) {
                ReportConfigInfo reportConfigInfo = (ReportConfigInfo) obj;
                String str = this.aliveLogId;
                if (str == null) {
                    if (reportConfigInfo.aliveLogId != null) {
                        return false;
                    }
                } else if (!str.equals(reportConfigInfo.aliveLogId)) {
                    return false;
                }
                String str2 = this.installLogId;
                if (str2 == null) {
                    if (reportConfigInfo.installLogId != null) {
                        return false;
                    }
                } else if (!str2.equals(reportConfigInfo.installLogId)) {
                    return false;
                }
                String str3 = this.pkgName;
                if (str3 == null) {
                    if (reportConfigInfo.pkgName != null) {
                        return false;
                    }
                } else if (!str3.equals(reportConfigInfo.pkgName)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.aliveLogId;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.installLogId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.pkgName;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
        return invokeV.intValue;
    }
}
