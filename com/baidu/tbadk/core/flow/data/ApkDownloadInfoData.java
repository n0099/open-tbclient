package com.baidu.tbadk.core.flow.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.h75;
import com.baidu.tieba.hl0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ApkDownloadInfoData implements h75, Serializable, Comparable<ApkDownloadInfoData> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SOURCE_PRIORITY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public hl0 adDownloadBean;
    public File apkFile;
    public String apkIcon;
    public String apkName;
    public String apkPackageName;
    public String apkPath;
    public String backAlertRemindType;
    public String downloadUrl;
    public long finishDownloadTime;
    public int itemId;
    public int itemSource;
    public String notificationShowContent;
    public int notificationShowCount;
    public AdDownloadStatus status;
    public String title;

    private int getPriority(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (i == 5) {
                return 100;
            }
            if (i == 2) {
                return 99;
            }
            if (i == 3 || i == 4) {
                return 98;
            }
            return i == 1 ? 97 : 96;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.h75
    public String getPicLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h75
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public ApkDownloadInfoData() {
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
        this.finishDownloadTime = -1L;
        this.itemSource = 1;
        this.notificationShowCount = 0;
        this.notificationShowContent = "";
    }

    public hl0 getAdDownloadBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.adDownloadBean;
        }
        return (hl0) invokeV.objValue;
    }

    public File getApkFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.apkFile;
        }
        return (File) invokeV.objValue;
    }

    public String getApkIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.apkIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getApkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.apkName;
        }
        return (String) invokeV.objValue;
    }

    public String getApkPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.apkPackageName;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.apkPath;
        }
        return (String) invokeV.objValue;
    }

    public String getBackAlertRemindType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.backAlertRemindType;
        }
        return (String) invokeV.objValue;
    }

    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.downloadUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getFinishDownloadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.finishDownloadTime;
        }
        return invokeV.longValue;
    }

    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.itemId;
        }
        return invokeV.intValue;
    }

    public int getItemSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.itemSource;
        }
        return invokeV.intValue;
    }

    public String getNotificationShowContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.notificationShowContent;
        }
        return (String) invokeV.objValue;
    }

    public int getNotificationShowCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.notificationShowCount;
        }
        return invokeV.intValue;
    }

    public AdDownloadStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.status;
        }
        return (AdDownloadStatus) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public boolean isFromBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.itemSource == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ApkDownloadInfoData apkDownloadInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apkDownloadInfoData)) == null) {
            if (apkDownloadInfoData == null) {
                return 1;
            }
            if (getPriority(this.itemSource) == getPriority(apkDownloadInfoData.itemSource)) {
                return (int) (this.finishDownloadTime - apkDownloadInfoData.finishDownloadTime);
            }
            return getPriority(this.itemSource) - getPriority(apkDownloadInfoData.itemSource);
        }
        return invokeL.intValue;
    }

    public void setAdDownloadBean(hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hl0Var) == null) {
            this.adDownloadBean = hl0Var;
        }
    }

    public void setApkFile(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, file) == null) {
            this.apkFile = file;
        }
    }

    public void setApkIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.apkIcon = str;
        }
    }

    public void setApkName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.apkName = str;
        }
    }

    public void setApkPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.apkPackageName = str;
        }
    }

    public void setApkPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.apkPath = str;
        }
    }

    public void setBackAlertRemindType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.backAlertRemindType = str;
        }
    }

    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.downloadUrl = str;
        }
    }

    public void setFinishDownloadTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.finishDownloadTime = j;
        }
    }

    public void setItemId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.itemId = i;
        }
    }

    public void setItemSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.itemSource = i;
        }
    }

    public void setNotificationShowContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.notificationShowContent = str;
        }
    }

    public void setNotificationShowCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.notificationShowCount = i;
        }
    }

    public void setStatus(AdDownloadStatus adDownloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, adDownloadStatus) == null) {
            this.status = adDownloadStatus;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.title = str;
        }
    }
}
