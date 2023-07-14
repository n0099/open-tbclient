package com.baidu.tbadk.core.flow.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.gm0;
import com.baidu.tieba.h85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ApkDownloadInfoData implements h85, Serializable, Comparable<ApkDownloadInfoData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gm0 adDownloadBean;
    public String apkPackageName;
    public long finishDownloadTime;
    public String mApkImgUrl;
    public String mApkName;
    public File mApkPath;
    public AdDownloadStatus status;

    @Override // com.baidu.tieba.h85
    public String getPicLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h85
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public ApkDownloadInfoData(String str, File file, String str2, AdDownloadStatus adDownloadStatus, String str3, long j, gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file, str2, adDownloadStatus, str3, Long.valueOf(j), gm0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.finishDownloadTime = -1L;
        this.mApkImgUrl = str;
        this.mApkPath = file;
        this.mApkName = str2;
        this.status = adDownloadStatus;
        this.apkPackageName = str3;
        this.finishDownloadTime = j;
        this.adDownloadBean = gm0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apkDownloadInfoData)) == null) {
            if (apkDownloadInfoData == null || apkDownloadInfoData.finishDownloadTime > this.finishDownloadTime) {
                return 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public gm0 getAdDownloadBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.adDownloadBean;
        }
        return (gm0) invokeV.objValue;
    }

    public String getApkPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.apkPackageName;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public AdDownloadStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.status;
        }
        return (AdDownloadStatus) invokeV.objValue;
    }

    public String getmApkImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.mApkImgUrl;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getmApkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.mApkName;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public File getmApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mApkPath;
        }
        return (File) invokeV.objValue;
    }
}
