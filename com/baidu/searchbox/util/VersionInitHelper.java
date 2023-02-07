package com.baidu.searchbox.util;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VersionInitHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VersionInitHelper() {
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

    public static boolean hasInitFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!TextUtils.isEmpty(TbConfig.getVersion()) && TbConfig.getVersionType() != -1) {
                if (TbConfig.getVersionType() != 1 || !TextUtils.isEmpty(TbConfig.getSubVersion())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = TbadkCoreApplication.getInst().getContext().getPackageManager().getApplicationInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 128);
                TbConfig.setVersionType(dh.e(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
            } catch (Exception e) {
                TbConfig.setVersionType(3);
                BdLog.e(e.getMessage());
            }
            try {
                if (TbConfig.getVersionType() == 2) {
                    if (applicationInfo != null) {
                        TbConfig.setVersion(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                        return;
                    }
                    return;
                }
                TbConfig.setVersion(TbadkCoreApplication.getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 0).versionName);
                if (TbConfig.getVersionType() == 1 && applicationInfo != null) {
                    TbConfig.setSubVersion(String.valueOf(applicationInfo.metaData.get("subVersion")));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
