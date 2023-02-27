package com.baidu.sofire.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.b.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String apkMD5;
    public int apkParseSuc;
    public int applicationTheme;
    public ClassLoader classLoader;
    public String className;
    public PackageInfo cloudPkgInfo;
    public String dataDir;
    public String dexPath;
    public String downloadURL;
    public int duration;
    public String es;
    public Context hostContext;
    public int initStatus;
    public List<j> intentFilters;
    public boolean isMem;
    public int isOnce;
    public int key;
    public String libPath;
    public int network;
    public String packageName;
    public String pkgPath;
    public int priority;
    public String signMD5;
    public long startTime;
    public String versionName;

    public ApkInfo() {
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
        this.priority = -1;
        this.isMem = false;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.packageName;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode + 31;
        }
        return invokeV.intValue;
    }

    public ApkInfo(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.priority = -1;
        this.isMem = false;
        this.key = i;
        this.versionName = str;
        this.pkgPath = str2;
    }

    public ApkInfo(int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.priority = -1;
        this.isMem = false;
        this.key = i;
        this.packageName = str;
        this.versionName = str2;
        this.downloadURL = str3;
        this.apkMD5 = str4;
    }

    public ApkInfo(ApkInfo apkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apkInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.priority = -1;
        this.isMem = false;
        this.key = apkInfo.key;
        this.initStatus = apkInfo.initStatus;
        this.packageName = apkInfo.packageName;
        this.versionName = apkInfo.versionName;
        this.pkgPath = apkInfo.pkgPath;
        this.hostContext = apkInfo.hostContext;
        this.libPath = apkInfo.libPath;
        this.downloadURL = apkInfo.downloadURL;
        this.apkMD5 = apkInfo.apkMD5;
        this.signMD5 = apkInfo.signMD5;
        this.dataDir = apkInfo.dataDir;
        this.dexPath = apkInfo.dexPath;
        this.className = apkInfo.className;
        this.apkParseSuc = apkInfo.apkParseSuc;
        this.applicationTheme = apkInfo.applicationTheme;
        this.intentFilters = apkInfo.intentFilters;
        this.cloudPkgInfo = apkInfo.cloudPkgInfo;
        this.startTime = apkInfo.startTime;
        this.duration = apkInfo.duration;
        this.network = apkInfo.network;
        this.isOnce = apkInfo.isOnce;
        this.priority = apkInfo.priority;
        this.isMem = apkInfo.isMem;
        this.es = apkInfo.es;
    }

    public ApkInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.priority = -1;
        this.isMem = false;
        this.versionName = str;
        this.pkgPath = str2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ApkInfo.class != obj.getClass()) {
                return false;
            }
            ApkInfo apkInfo = (ApkInfo) obj;
            String str = this.packageName;
            if (str == null) {
                if (apkInfo.packageName != null) {
                    return false;
                }
            } else if (!str.equals(apkInfo.packageName)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
