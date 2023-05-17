package com.baidu.nps.pm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ce1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialOperation;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BundleInfo implements IBundleInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_MAX_VERSION = "maxV";
    public static final String KEY_MIN_VERSION = "minV";
    public static final String KEY_PACKAGE = "package";
    public transient /* synthetic */ FieldHolder $fh;
    public int abi;
    public String apkPath;
    public boolean broken;
    public String dependence;
    public List<String> dependency;
    public String description;
    public String downloadUrl;
    public String ext;
    public boolean forbidden;
    public boolean forceUpdate;
    public String iconUrl;
    public boolean isMain;
    public String mMainBundleName;
    public String md5;
    public int minVersion;
    public String name;
    public boolean needRemove;
    public String networkStrategy;
    public String packageName;
    public String patchMD5;
    public String patchUrl;
    public boolean removable;
    public String signature;
    public int silence;
    public int silenceUpdate;
    public long size;
    public List<SubBundleInfo> subBundleInfos;
    public int type;
    public long updateV;
    public int versionCode;
    public boolean visible;
    public int wifiOnly;

    public BundleInfo() {
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
        this.broken = false;
        this.visible = true;
        this.removable = false;
        this.needRemove = false;
        this.abi = -1;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.abi;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.apkPath;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.dependence;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public List<String> getDependency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.dependency;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.description;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getDownloadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!TextUtils.isEmpty(this.patchUrl) && !TextUtils.isEmpty(this.patchMD5)) {
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.downloadUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.ext;
        }
        return (String) invokeV.objValue;
    }

    public String getGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ce1.b().f(this.packageName);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMainBudble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mMainBundleName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.md5;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.minVersion;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getNetworkStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.networkStrategy;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.packageName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPatchMD5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.patchMD5;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPatchUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.patchUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.signature;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.silence;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilenceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.silenceUpdate;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.size;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public List<SubBundleInfo> getSubBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.subBundleInfos;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.updateV;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.versionCode;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getWifiOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.wifiOnly;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.broken;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.forbidden;
        }
        return invokeV.booleanValue;
    }

    public boolean isMainBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            List<SubBundleInfo> subBundle = getSubBundle();
            if (subBundle != null && !subBundle.isEmpty() && !isSubBundle()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMultiBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!isMainBundle() && !isSubBundle()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.needRemove;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.removable;
        }
        return invokeV.booleanValue;
    }

    public boolean isSubBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            List<String> dependency = getDependency();
            if (dependency != null && !dependency.isEmpty() && !TextUtils.isEmpty(getMainBudble())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.visible;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.forceUpdate;
        }
        return invokeV.booleanValue;
    }

    public BundleInfo(IBundleInfo iBundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iBundleInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.broken = false;
        this.visible = true;
        this.removable = false;
        this.needRemove = false;
        this.abi = -1;
        setPackageName(iBundleInfo.getPackageName());
        setVersionCode(iBundleInfo.getVersionCode());
        setApkPath(iBundleInfo.getApkPath());
        setUpdateV(iBundleInfo.getUpdateV());
        setType(iBundleInfo.getType());
        setBroken(iBundleInfo.isBroken());
        setForceUpdate(iBundleInfo.needForceUpdate());
        setForbidden(iBundleInfo.isForbidden());
        setMd5(iBundleInfo.getMd5());
        setSignature(iBundleInfo.getSignature());
        setName(iBundleInfo.getName());
        setDescription(iBundleInfo.getDescription());
        setDownloadUrl(iBundleInfo.getDownloadUrl());
        setIconUrl(iBundleInfo.getIconUrl());
        setDependence(iBundleInfo.getDependence());
        setVisible(iBundleInfo.isVisible());
        setRemovable(iBundleInfo.isRemovable());
        setSize(iBundleInfo.getSize());
        setNeedRemove(iBundleInfo.isNeedRemove());
        setAbi(iBundleInfo.getAbi());
        setExt(iBundleInfo.getExt());
        setPatchUrl(iBundleInfo.getPatchUrl());
        setPatchMD5(iBundleInfo.getPatchMD5());
        setNetworkStrategy(iBundleInfo.getNetworkStrategy());
        setMainBundle(iBundleInfo.getMainBudble());
    }

    public static BundleInfo toBundleInfo(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iBundleInfo)) == null) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(iBundleInfo.getPackageName());
            bundleInfo.setVersionCode(iBundleInfo.getVersionCode());
            bundleInfo.setApkPath(iBundleInfo.getApkPath());
            bundleInfo.setUpdateV(iBundleInfo.getUpdateV());
            bundleInfo.setMinVersion(iBundleInfo.getMinVersion());
            bundleInfo.setType(iBundleInfo.getType());
            bundleInfo.setBroken(iBundleInfo.isBroken());
            bundleInfo.setForceUpdate(iBundleInfo.needForceUpdate());
            bundleInfo.setForbidden(iBundleInfo.isForbidden());
            bundleInfo.setMd5(iBundleInfo.getMd5());
            bundleInfo.setSignature(iBundleInfo.getSignature());
            bundleInfo.setName(iBundleInfo.getName());
            bundleInfo.setDescription(iBundleInfo.getDescription());
            bundleInfo.setDownloadUrl(iBundleInfo.getDownloadUrl());
            bundleInfo.setIconUrl(iBundleInfo.getIconUrl());
            bundleInfo.setDependence(iBundleInfo.getDependence());
            bundleInfo.setVisible(iBundleInfo.isVisible());
            bundleInfo.setRemovable(iBundleInfo.isRemovable());
            bundleInfo.setSize(iBundleInfo.getSize());
            bundleInfo.setNeedRemove(iBundleInfo.isNeedRemove());
            bundleInfo.setAbi(iBundleInfo.getAbi());
            bundleInfo.setExt(iBundleInfo.getExt());
            bundleInfo.setSilence(iBundleInfo.getSilence());
            bundleInfo.setSilenceUpdate(iBundleInfo.getSilenceUpdate());
            bundleInfo.setWifiOnly(iBundleInfo.getWifiOnly());
            bundleInfo.setPatchUrl(iBundleInfo.getPatchUrl());
            bundleInfo.setPatchMD5(iBundleInfo.getPatchMD5());
            bundleInfo.setNetworkStrategy(iBundleInfo.getNetworkStrategy());
            bundleInfo.setSubBundle(iBundleInfo.getSubBundle());
            bundleInfo.setDependency(iBundleInfo.getDependency());
            bundleInfo.setMainBundle(iBundleInfo.getMainBudble());
            return bundleInfo;
        }
        return (BundleInfo) invokeL.objValue;
    }

    public static String dependency2Str(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list != null) {
                return TextUtils.join(ParamableElem.DIVIDE_PARAM, list);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static List<String> parseDependencyStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return Arrays.asList(TextUtils.split(str, ParamableElem.DIVIDE_PARAM));
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.abi = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.apkPath = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.broken = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    @Deprecated
    public void setDependence(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.dependence = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependency(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, list) == null) {
            this.dependency = list;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.description = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.downloadUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.ext = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.forbidden = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.forceUpdate = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.iconUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMainBundle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mMainBundleName = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.md5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.minVersion = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.name = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.needRemove = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNetworkStrategy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.networkStrategy = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.packageName = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPatchMD5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.patchMD5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPatchUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.patchUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.removable = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.signature = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            this.silence = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.silenceUpdate = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j) == null) {
            this.size = j;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSubBundle(List<SubBundleInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, list) == null) {
            this.subBundleInfos = list;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.type = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048639, this, j) == null) {
            this.updateV = j;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.versionCode = i;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.visible = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.wifiOnly = i;
        }
    }

    public static List<SubBundleInfo> parseSubBundleStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        SubBundleInfo subBundleInfo = new SubBundleInfo();
                        subBundleInfo.setPackageName(jSONObject.getString("package"));
                        subBundleInfo.setMinVersion(jSONObject.getInt(KEY_MIN_VERSION));
                        subBundleInfo.setMaxVersion(jSONObject.getInt(KEY_MAX_VERSION));
                        arrayList.add(subBundleInfo);
                    }
                } catch (JSONException unused) {
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String subBundleList2Str(List<SubBundleInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (SubBundleInfo subBundleInfo : list) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("package", subBundleInfo.getPackageName());
                        jSONObject.put(KEY_MIN_VERSION, subBundleInfo.getMinVersion());
                        jSONObject.put(KEY_MAX_VERSION, subBundleInfo.getMaxVersion());
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException unused) {
                }
                return jSONArray.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static BundleInfo toBundleInfo(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, contentValues)) == null) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(contentValues.getAsString("pkg_name"));
            bundleInfo.setVersionCode(contentValues.getAsInteger("version_code").intValue());
            bundleInfo.setApkPath(contentValues.getAsString("path"));
            bundleInfo.setUpdateV(contentValues.getAsLong("update_v").longValue());
            bundleInfo.setMinVersion(contentValues.getAsInteger("min_version").intValue());
            bundleInfo.setType(contentValues.getAsInteger("type").intValue());
            bundleInfo.setBroken(contentValues.getAsBoolean("broken").booleanValue());
            bundleInfo.setForceUpdate(contentValues.getAsBoolean("force_update").booleanValue());
            bundleInfo.setForbidden(contentValues.getAsBoolean("forbidden").booleanValue());
            bundleInfo.setMd5(contentValues.getAsString(PackageTable.MD5));
            bundleInfo.setSignature(contentValues.getAsString(SocialOperation.GAME_SIGNATURE));
            bundleInfo.setName(contentValues.getAsString("name"));
            bundleInfo.setDescription(contentValues.getAsString("description"));
            bundleInfo.setDownloadUrl(contentValues.getAsString("download_url"));
            bundleInfo.setIconUrl(contentValues.getAsString("icon_url"));
            bundleInfo.setDependence(contentValues.getAsString("dependence"));
            bundleInfo.setVisible(contentValues.getAsBoolean(MapBundleKey.MapObjKey.OBJ_SL_VISI).booleanValue());
            bundleInfo.setRemovable(contentValues.getAsBoolean("removalbe").booleanValue());
            bundleInfo.setSize(contentValues.getAsLong("size").longValue());
            bundleInfo.setNeedRemove(contentValues.getAsBoolean("need_remove").booleanValue());
            bundleInfo.setAbi(contentValues.getAsInteger(PackageTable.ABI).intValue());
            bundleInfo.setExt(contentValues.getAsString("ext"));
            bundleInfo.setSilence(contentValues.getAsInteger("silence").intValue());
            bundleInfo.setSilenceUpdate(contentValues.getAsInteger("silence_update").intValue());
            bundleInfo.setWifiOnly(contentValues.getAsInteger("wifionly").intValue());
            bundleInfo.setPatchUrl(contentValues.getAsString("patch_url"));
            bundleInfo.setPatchMD5(contentValues.getAsString("patch_md5"));
            bundleInfo.setNetworkStrategy(contentValues.getAsString("network_strategy"));
            bundleInfo.setSubBundle(parseSubBundleStr(contentValues.getAsString("sub_bundle")));
            bundleInfo.setDependency(parseDependencyStr(contentValues.getAsString("dependency")));
            bundleInfo.setMainBundle(contentValues.getAsString("main_bundle"));
            return bundleInfo;
        }
        return (BundleInfo) invokeL.objValue;
    }

    public static ContentValues toContentValues(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bundleInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            String packageName = bundleInfo.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return contentValues;
            }
            contentValues.put("pkg_name", packageName);
            contentValues.put("version_code", Integer.valueOf(bundleInfo.getVersionCode()));
            contentValues.put("path", bundleInfo.getApkPath());
            contentValues.put("min_version", Integer.valueOf(bundleInfo.getMinVersion()));
            contentValues.put("update_v", Long.valueOf(bundleInfo.getUpdateV()));
            contentValues.put("type", Integer.valueOf(bundleInfo.getType()));
            contentValues.put("broken", Boolean.valueOf(bundleInfo.isBroken()));
            contentValues.put("force_update", Boolean.valueOf(bundleInfo.needForceUpdate()));
            contentValues.put("forbidden", Boolean.valueOf(bundleInfo.isForbidden()));
            contentValues.put(PackageTable.MD5, bundleInfo.getMd5());
            contentValues.put(SocialOperation.GAME_SIGNATURE, bundleInfo.getSignature());
            contentValues.put("name", bundleInfo.getName());
            contentValues.put("dependence", bundleInfo.getDescription());
            contentValues.put("download_url", bundleInfo.getDownloadUrl());
            contentValues.put("icon_url", bundleInfo.getIconUrl());
            contentValues.put("dependence", bundleInfo.getDependence());
            contentValues.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, Boolean.valueOf(bundleInfo.isVisible()));
            contentValues.put("removalbe", Boolean.valueOf(bundleInfo.isRemovable()));
            contentValues.put("size", Long.valueOf(bundleInfo.getSize()));
            contentValues.put("need_remove", Boolean.valueOf(bundleInfo.isNeedRemove()));
            contentValues.put(PackageTable.ABI, Integer.valueOf(bundleInfo.getAbi()));
            contentValues.put("ext", bundleInfo.getExt());
            contentValues.put("silence", Integer.valueOf(bundleInfo.getSilence()));
            contentValues.put("silence_update", Integer.valueOf(bundleInfo.getSilenceUpdate()));
            contentValues.put("wifionly", Integer.valueOf(bundleInfo.getWifiOnly()));
            contentValues.put("patch_url", bundleInfo.getPatchUrl());
            contentValues.put("patch_md5", bundleInfo.getPatchMD5());
            contentValues.put("network_strategy", bundleInfo.getNetworkStrategy());
            contentValues.put("sub_bundle", subBundleList2Str(bundleInfo.getSubBundle()));
            contentValues.put("dependency", dependency2Str(bundleInfo.getDependency()));
            contentValues.put("main_bundle", bundleInfo.getMainBudble());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static Map<String, BundleInfoGroup> toBundleInfoGroups(List<BundleInfo> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65544, null, list, j)) == null) {
            HashMap hashMap = new HashMap();
            if (list == null) {
                return null;
            }
            for (BundleInfo bundleInfo : list) {
                BundleInfoGroup bundleInfoGroup = (BundleInfoGroup) hashMap.get(bundleInfo.getPackageName());
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j);
                    hashMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                }
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return hashMap;
        }
        return (Map) invokeLJ.objValue;
    }

    public static List<BundleInfo> toBundleInfoList(Cursor cursor) {
        InterceptResult invokeL;
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        int i9;
        int i10;
        int i11;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cursor)) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (cursor == null) {
                return arrayList2;
            }
            cursor.getColumnIndex("_id");
            int columnIndex = cursor.getColumnIndex("pkg_name");
            int columnIndex2 = cursor.getColumnIndex("version_code");
            int columnIndex3 = cursor.getColumnIndex("path");
            int columnIndex4 = cursor.getColumnIndex("update_v");
            int columnIndex5 = cursor.getColumnIndex("min_version");
            int columnIndex6 = cursor.getColumnIndex("type");
            int columnIndex7 = cursor.getColumnIndex("broken");
            int columnIndex8 = cursor.getColumnIndex("force_update");
            int columnIndex9 = cursor.getColumnIndex("forbidden");
            int columnIndex10 = cursor.getColumnIndex(PackageTable.MD5);
            int columnIndex11 = cursor.getColumnIndex(SocialOperation.GAME_SIGNATURE);
            int columnIndex12 = cursor.getColumnIndex("name");
            int columnIndex13 = cursor.getColumnIndex("description");
            int columnIndex14 = cursor.getColumnIndex("download_url");
            ArrayList arrayList3 = arrayList2;
            int columnIndex15 = cursor.getColumnIndex("icon_url");
            int columnIndex16 = cursor.getColumnIndex("dependence");
            int columnIndex17 = cursor.getColumnIndex(MapBundleKey.MapObjKey.OBJ_SL_VISI);
            int columnIndex18 = cursor.getColumnIndex("removalbe");
            int columnIndex19 = cursor.getColumnIndex("size");
            int columnIndex20 = cursor.getColumnIndex("need_remove");
            int columnIndex21 = cursor.getColumnIndex(PackageTable.ABI);
            int columnIndex22 = cursor.getColumnIndex("ext");
            int columnIndex23 = cursor.getColumnIndex("silence");
            int columnIndex24 = cursor.getColumnIndex("silence_update");
            int columnIndex25 = cursor.getColumnIndex("wifionly");
            int columnIndex26 = cursor.getColumnIndex("patch_url");
            int columnIndex27 = cursor.getColumnIndex("patch_md5");
            int columnIndex28 = cursor.getColumnIndex("network_strategy");
            int columnIndex29 = cursor.getColumnIndex("sub_bundle");
            int columnIndex30 = cursor.getColumnIndex("dependency");
            int columnIndex31 = cursor.getColumnIndex("main_bundle");
            try {
                if (cursor.moveToFirst()) {
                    int i12 = columnIndex31;
                    while (true) {
                        String string = cursor.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            i = columnIndex;
                            i2 = columnIndex3;
                            i5 = columnIndex17;
                            i9 = columnIndex22;
                            i11 = i12;
                            i4 = columnIndex15;
                            i10 = columnIndex20;
                            i8 = columnIndex19;
                            i7 = columnIndex18;
                            i6 = columnIndex16;
                            i3 = columnIndex2;
                            arrayList = arrayList3;
                        } else {
                            i = columnIndex;
                            BundleInfo bundleInfo = new BundleInfo();
                            bundleInfo.setPackageName(string);
                            bundleInfo.setVersionCode(cursor.getInt(columnIndex2));
                            bundleInfo.setApkPath(cursor.getString(columnIndex3));
                            int i13 = columnIndex2;
                            i2 = columnIndex3;
                            bundleInfo.setUpdateV(cursor.getLong(columnIndex4));
                            bundleInfo.setMinVersion(cursor.getInt(columnIndex5));
                            bundleInfo.setType(cursor.getInt(columnIndex6));
                            if (cursor.getInt(columnIndex7) == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bundleInfo.setBroken(z);
                            if (cursor.getInt(columnIndex8) == 1) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            bundleInfo.setForceUpdate(z2);
                            if (cursor.getInt(columnIndex9) == 1) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            bundleInfo.setForbidden(z3);
                            bundleInfo.setMd5(cursor.getString(columnIndex10));
                            bundleInfo.setSignature(cursor.getString(columnIndex11));
                            bundleInfo.setName(cursor.getString(columnIndex12));
                            bundleInfo.setDescription(cursor.getString(columnIndex13));
                            bundleInfo.setDownloadUrl(cursor.getString(columnIndex14));
                            int i14 = columnIndex15;
                            bundleInfo.setIconUrl(cursor.getString(i14));
                            int i15 = columnIndex16;
                            i3 = i13;
                            bundleInfo.setDependence(cursor.getString(i15));
                            int i16 = columnIndex17;
                            i4 = i14;
                            i5 = i16;
                            if (cursor.getInt(i16) == 1) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            bundleInfo.setVisible(z4);
                            int i17 = columnIndex18;
                            i6 = i15;
                            if (cursor.getInt(i17) == 1) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            bundleInfo.setRemovable(z5);
                            int i18 = columnIndex19;
                            i7 = i17;
                            bundleInfo.setSize(cursor.getLong(i18));
                            int i19 = columnIndex20;
                            i8 = i18;
                            if (cursor.getInt(i19) == 1) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            bundleInfo.setNeedRemove(z6);
                            int i20 = columnIndex21;
                            bundleInfo.setAbi(cursor.getInt(i20));
                            columnIndex21 = i20;
                            i9 = columnIndex22;
                            bundleInfo.setExt(cursor.getString(i9));
                            i10 = i19;
                            int i21 = columnIndex23;
                            bundleInfo.setSilence(cursor.getInt(i21));
                            columnIndex23 = i21;
                            int i22 = columnIndex24;
                            bundleInfo.setSilenceUpdate(cursor.getInt(i22));
                            columnIndex24 = i22;
                            int i23 = columnIndex25;
                            bundleInfo.setWifiOnly(cursor.getInt(i23));
                            columnIndex25 = i23;
                            int i24 = columnIndex26;
                            bundleInfo.setPatchUrl(cursor.getString(i24));
                            columnIndex26 = i24;
                            int i25 = columnIndex27;
                            bundleInfo.setPatchMD5(cursor.getString(i25));
                            columnIndex27 = i25;
                            int i26 = columnIndex28;
                            bundleInfo.setNetworkStrategy(cursor.getString(i26));
                            int i27 = columnIndex29;
                            columnIndex29 = i27;
                            bundleInfo.setSubBundle(parseSubBundleStr(cursor.getString(i27)));
                            int i28 = columnIndex30;
                            columnIndex30 = i28;
                            bundleInfo.setDependency(parseDependencyStr(cursor.getString(i28)));
                            columnIndex28 = i26;
                            i11 = i12;
                            bundleInfo.setMainBundle(cursor.getString(i11));
                            arrayList = arrayList3;
                            try {
                                arrayList.add(bundleInfo);
                            } catch (SQLiteDatabaseCorruptException unused) {
                                return arrayList;
                            }
                        }
                        if (cursor.moveToNext()) {
                            i12 = i11;
                            arrayList3 = arrayList;
                            columnIndex22 = i9;
                            columnIndex2 = i3;
                            columnIndex16 = i6;
                            columnIndex18 = i7;
                            columnIndex19 = i8;
                            columnIndex = i;
                            columnIndex3 = i2;
                            columnIndex20 = i10;
                            columnIndex15 = i4;
                            columnIndex17 = i5;
                        } else {
                            return arrayList;
                        }
                    }
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
            }
            return arrayList3;
        }
        return (List) invokeL.objValue;
    }

    public static ContentValues toContentValues(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, iBundleInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            String packageName = iBundleInfo.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return contentValues;
            }
            contentValues.put("pkg_name", packageName);
            contentValues.put("version_code", Integer.valueOf(iBundleInfo.getVersionCode()));
            contentValues.put("path", iBundleInfo.getApkPath());
            contentValues.put("min_version", Integer.valueOf(iBundleInfo.getMinVersion()));
            contentValues.put("update_v", Long.valueOf(iBundleInfo.getUpdateV()));
            contentValues.put("type", Integer.valueOf(iBundleInfo.getType()));
            contentValues.put("broken", Boolean.valueOf(iBundleInfo.isBroken()));
            contentValues.put("force_update", Boolean.valueOf(iBundleInfo.needForceUpdate()));
            contentValues.put("forbidden", Boolean.valueOf(iBundleInfo.isForbidden()));
            contentValues.put(PackageTable.MD5, iBundleInfo.getMd5());
            contentValues.put(SocialOperation.GAME_SIGNATURE, iBundleInfo.getSignature());
            contentValues.put("name", iBundleInfo.getName());
            contentValues.put("dependence", iBundleInfo.getDescription());
            contentValues.put("download_url", iBundleInfo.getDownloadUrl());
            contentValues.put("icon_url", iBundleInfo.getIconUrl());
            contentValues.put("dependence", iBundleInfo.getDependence());
            contentValues.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, Boolean.valueOf(iBundleInfo.isVisible()));
            contentValues.put("removalbe", Boolean.valueOf(iBundleInfo.isRemovable()));
            contentValues.put("size", Long.valueOf(iBundleInfo.getSize()));
            contentValues.put("need_remove", Boolean.valueOf(iBundleInfo.isNeedRemove()));
            contentValues.put(PackageTable.ABI, Integer.valueOf(iBundleInfo.getAbi()));
            contentValues.put("ext", iBundleInfo.getExt());
            contentValues.put("silence", Integer.valueOf(iBundleInfo.getSilence()));
            contentValues.put("silence_update", Integer.valueOf(iBundleInfo.getSilenceUpdate()));
            contentValues.put("wifionly", Integer.valueOf(iBundleInfo.getWifiOnly()));
            contentValues.put("patch_url", iBundleInfo.getPatchUrl());
            contentValues.put("patch_md5", iBundleInfo.getPatchMD5());
            contentValues.put("network_strategy", iBundleInfo.getNetworkStrategy());
            contentValues.put("sub_bundle", subBundleList2Str(iBundleInfo.getSubBundle()));
            contentValues.put("dependency", dependency2Str(iBundleInfo.getDependency()));
            contentValues.put("main_bundle", iBundleInfo.getMainBudble());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static void updateBundleInfoConfig(BundleInfo bundleInfo, BundleInfo bundleInfo2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, bundleInfo, bundleInfo2) == null) && bundleInfo != null && bundleInfo2 != null) {
            bundleInfo.setUpdateV(bundleInfo2.getUpdateV());
            bundleInfo.setMinVersion(bundleInfo2.getMinVersion());
            bundleInfo.setForceUpdate(bundleInfo2.needForceUpdate());
            bundleInfo.setForbidden(bundleInfo2.isForbidden());
            bundleInfo.setName(bundleInfo2.getName());
            bundleInfo.setDescription(bundleInfo2.getDescription());
            bundleInfo.setIconUrl(bundleInfo2.getIconUrl());
            bundleInfo.setDependence(bundleInfo2.getDependence());
            bundleInfo.setVisible(bundleInfo2.isVisible());
            bundleInfo.setRemovable(bundleInfo2.isRemovable());
            bundleInfo.setNeedRemove(bundleInfo2.isNeedRemove());
            bundleInfo.setExt(bundleInfo2.getExt());
            bundleInfo.setSilence(bundleInfo2.getSilence());
            bundleInfo.setSilenceUpdate(bundleInfo2.getSilenceUpdate());
            bundleInfo.setWifiOnly(bundleInfo2.getWifiOnly());
            bundleInfo.setPatchUrl(bundleInfo2.getPatchUrl());
            bundleInfo.setPatchMD5(bundleInfo2.getPatchMD5());
            bundleInfo.setNetworkStrategy(bundleInfo2.getNetworkStrategy());
            bundleInfo.setSubBundle(bundleInfo2.getSubBundle());
            bundleInfo.setDependency(bundleInfo2.getDependency());
            bundleInfo.setMainBundle(bundleInfo2.getMainBudble());
        }
    }
}
