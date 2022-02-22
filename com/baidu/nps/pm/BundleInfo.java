package com.baidu.nps.pm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class BundleInfo implements IBundleInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int abi;
    public String apkPath;
    public boolean broken;
    public String dependence;
    public String description;
    public String downloadUrl;
    public String ext;
    public boolean forbidden;
    public boolean forceUpdate;
    public String iconUrl;
    public String md5;
    public int minVersion;
    public String name;
    public boolean needRemove;
    public String packageName;
    public boolean removable;
    public String signature;
    public int silence;
    public int silenceUpdate;
    public long size;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static BundleInfo toBundleInfo(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iBundleInfo)) == null) {
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
            return bundleInfo;
        }
        return (BundleInfo) invokeL.objValue;
    }

    public static List<BundleInfo> toBundleInfoList(Cursor cursor) {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cursor)) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (cursor == null) {
                return arrayList2;
            }
            cursor.getColumnIndex("_id");
            int columnIndex = cursor.getColumnIndex(EmotionResourceInfo.JSON_KEY_PKG_NAME);
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
            int columnIndex17 = cursor.getColumnIndex(TKBase.VISIBILITY_VISIBLE);
            int columnIndex18 = cursor.getColumnIndex("removalbe");
            int columnIndex19 = cursor.getColumnIndex("size");
            int columnIndex20 = cursor.getColumnIndex("need_remove");
            int columnIndex21 = cursor.getColumnIndex(PackageTable.ABI);
            int columnIndex22 = cursor.getColumnIndex("ext");
            int columnIndex23 = cursor.getColumnIndex("silence");
            int columnIndex24 = cursor.getColumnIndex("silence_update");
            int columnIndex25 = cursor.getColumnIndex("wifionly");
            try {
                if (cursor.moveToFirst()) {
                    int i13 = columnIndex25;
                    while (true) {
                        String string = cursor.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            i2 = columnIndex;
                            i3 = columnIndex3;
                            i6 = columnIndex17;
                            i10 = columnIndex22;
                            i12 = i13;
                            i5 = columnIndex15;
                            i11 = columnIndex20;
                            i9 = columnIndex19;
                            i8 = columnIndex18;
                            i7 = columnIndex16;
                            i4 = columnIndex2;
                            arrayList = arrayList3;
                        } else {
                            i2 = columnIndex;
                            BundleInfo bundleInfo = new BundleInfo();
                            bundleInfo.setPackageName(string);
                            bundleInfo.setVersionCode(cursor.getInt(columnIndex2));
                            bundleInfo.setApkPath(cursor.getString(columnIndex3));
                            int i14 = columnIndex2;
                            i3 = columnIndex3;
                            bundleInfo.setUpdateV(cursor.getLong(columnIndex4));
                            bundleInfo.setMinVersion(cursor.getInt(columnIndex5));
                            bundleInfo.setType(cursor.getInt(columnIndex6));
                            bundleInfo.setBroken(cursor.getInt(columnIndex7) == 1);
                            bundleInfo.setForceUpdate(cursor.getInt(columnIndex8) == 1);
                            bundleInfo.setForbidden(cursor.getInt(columnIndex9) == 1);
                            bundleInfo.setMd5(cursor.getString(columnIndex10));
                            bundleInfo.setSignature(cursor.getString(columnIndex11));
                            bundleInfo.setName(cursor.getString(columnIndex12));
                            bundleInfo.setDescription(cursor.getString(columnIndex13));
                            bundleInfo.setDownloadUrl(cursor.getString(columnIndex14));
                            int i15 = columnIndex15;
                            bundleInfo.setIconUrl(cursor.getString(i15));
                            int i16 = columnIndex16;
                            i4 = i14;
                            bundleInfo.setDependence(cursor.getString(i16));
                            int i17 = columnIndex17;
                            i5 = i15;
                            i6 = i17;
                            bundleInfo.setVisible(cursor.getInt(i17) == 1);
                            int i18 = columnIndex18;
                            i7 = i16;
                            bundleInfo.setRemovable(cursor.getInt(i18) == 1);
                            int i19 = columnIndex19;
                            i8 = i18;
                            bundleInfo.setSize(cursor.getLong(i19));
                            int i20 = columnIndex20;
                            i9 = i19;
                            bundleInfo.setNeedRemove(cursor.getInt(i20) == 1);
                            int i21 = columnIndex21;
                            bundleInfo.setAbi(cursor.getInt(i21));
                            columnIndex21 = i21;
                            i10 = columnIndex22;
                            bundleInfo.setExt(cursor.getString(i10));
                            i11 = i20;
                            int i22 = columnIndex23;
                            bundleInfo.setSilence(cursor.getInt(i22));
                            columnIndex23 = i22;
                            int i23 = columnIndex24;
                            bundleInfo.setSilenceUpdate(cursor.getInt(i23));
                            columnIndex24 = i23;
                            i12 = i13;
                            bundleInfo.setWifiOnly(cursor.getInt(i12));
                            arrayList = arrayList3;
                            try {
                                arrayList.add(bundleInfo);
                            } catch (SQLiteDatabaseCorruptException unused) {
                                return arrayList;
                            }
                        }
                        if (!cursor.moveToNext()) {
                            return arrayList;
                        }
                        i13 = i12;
                        arrayList3 = arrayList;
                        columnIndex22 = i10;
                        columnIndex2 = i4;
                        columnIndex16 = i7;
                        columnIndex18 = i8;
                        columnIndex19 = i9;
                        columnIndex = i2;
                        columnIndex3 = i3;
                        columnIndex20 = i11;
                        columnIndex15 = i5;
                        columnIndex17 = i6;
                    }
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
            }
            return arrayList3;
        }
        return (List) invokeL.objValue;
    }

    public static ContentValues toContentValues(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bundleInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            String packageName = bundleInfo.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return contentValues;
            }
            contentValues.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, packageName);
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
            contentValues.put(TKBase.VISIBILITY_VISIBLE, Boolean.valueOf(bundleInfo.isVisible()));
            contentValues.put("removalbe", Boolean.valueOf(bundleInfo.isRemovable()));
            contentValues.put("size", Long.valueOf(bundleInfo.getSize()));
            contentValues.put("need_remove", Boolean.valueOf(bundleInfo.isNeedRemove()));
            contentValues.put(PackageTable.ABI, Integer.valueOf(bundleInfo.getAbi()));
            contentValues.put("ext", bundleInfo.getExt());
            contentValues.put("silence", Integer.valueOf(bundleInfo.getSilence()));
            contentValues.put("silence_update", Integer.valueOf(bundleInfo.getSilenceUpdate()));
            contentValues.put("wifionly", Integer.valueOf(bundleInfo.getWifiOnly()));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static void updateBundleInfoConfig(BundleInfo bundleInfo, BundleInfo bundleInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, bundleInfo, bundleInfo2) == null) || bundleInfo == null || bundleInfo2 == null) {
            return;
        }
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
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.abi : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.apkPath : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dependence : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.description : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.downloadUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ext : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.md5 : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.minVersion : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.signature : (String) invokeV.objValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.silence : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilenceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.silenceUpdate : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.size : invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.type : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.updateV : invokeV.longValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.versionCode : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getWifiOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.wifiOnly : invokeV.intValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.broken : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.forbidden : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.needRemove : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.removable : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.visible : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.forceUpdate : invokeV.booleanValue;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.abi = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.apkPath = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.broken = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.dependence = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.description = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.downloadUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.ext = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.forbidden = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.forceUpdate = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.iconUrl = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.md5 = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.minVersion = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.name = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.needRemove = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.packageName = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.removable = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.signature = str;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.silence = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.silenceUpdate = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) {
            this.size = j2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.type = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j2) == null) {
            this.updateV = j2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.versionCode = i2;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.visible = z;
        }
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.wifiOnly = i2;
        }
    }

    public Map<String, BundleInfoGroup> toBundleInfoGroups(List<BundleInfo> list, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048626, this, list, j2)) == null) {
            HashMap hashMap = new HashMap();
            if (list == null) {
                return null;
            }
            for (BundleInfo bundleInfo : list) {
                BundleInfoGroup bundleInfoGroup = (BundleInfoGroup) hashMap.get(bundleInfo.getPackageName());
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j2);
                    hashMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                }
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return hashMap;
        }
        return (Map) invokeLJ.objValue;
    }

    public BundleInfo(IBundleInfo iBundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iBundleInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    }

    public static BundleInfo toBundleInfo(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, contentValues)) == null) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(contentValues.getAsString(EmotionResourceInfo.JSON_KEY_PKG_NAME));
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
            bundleInfo.setVisible(contentValues.getAsBoolean(TKBase.VISIBILITY_VISIBLE).booleanValue());
            bundleInfo.setRemovable(contentValues.getAsBoolean("removalbe").booleanValue());
            bundleInfo.setSize(contentValues.getAsLong("size").longValue());
            bundleInfo.setNeedRemove(contentValues.getAsBoolean("need_remove").booleanValue());
            bundleInfo.setAbi(contentValues.getAsInteger(PackageTable.ABI).intValue());
            bundleInfo.setExt(contentValues.getAsString("ext"));
            bundleInfo.setSilence(contentValues.getAsInteger("silence").intValue());
            bundleInfo.setSilenceUpdate(contentValues.getAsInteger("silence_update").intValue());
            bundleInfo.setWifiOnly(contentValues.getAsInteger("wifionly").intValue());
            return bundleInfo;
        }
        return (BundleInfo) invokeL.objValue;
    }

    public static ContentValues toContentValues(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, iBundleInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            String packageName = iBundleInfo.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return contentValues;
            }
            contentValues.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, packageName);
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
            contentValues.put(TKBase.VISIBILITY_VISIBLE, Boolean.valueOf(iBundleInfo.isVisible()));
            contentValues.put("removalbe", Boolean.valueOf(iBundleInfo.isRemovable()));
            contentValues.put("size", Long.valueOf(iBundleInfo.getSize()));
            contentValues.put("need_remove", Boolean.valueOf(iBundleInfo.isNeedRemove()));
            contentValues.put(PackageTable.ABI, Integer.valueOf(iBundleInfo.getAbi()));
            contentValues.put("ext", iBundleInfo.getExt());
            contentValues.put("silence", Integer.valueOf(iBundleInfo.getSilence()));
            contentValues.put("silence_update", Integer.valueOf(iBundleInfo.getSilenceUpdate()));
            contentValues.put("wifionly", Integer.valueOf(iBundleInfo.getWifiOnly()));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }
}
