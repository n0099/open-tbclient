package com.baidu.nps.pm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleInfo implements IBundleInfo {
    public String apkPath;
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
    public String packageName;
    public String signature;
    public int silence;
    public int silenceUpdate;
    public long size;
    public int type;
    public long updateV;
    public int versionCode;
    public int wifiOnly;
    public boolean broken = false;
    public boolean visible = true;
    public boolean removable = false;
    public boolean needRemove = false;
    public int abi = -1;

    public BundleInfo() {
    }

    public static BundleInfo toBundleInfo(IBundleInfo iBundleInfo) {
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

    public static List<BundleInfo> toBundleInfoList(Cursor cursor) {
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
        int columnIndex17 = cursor.getColumnIndex("visible");
        int columnIndex18 = cursor.getColumnIndex("removalbe");
        int columnIndex19 = cursor.getColumnIndex("size");
        int columnIndex20 = cursor.getColumnIndex("need_remove");
        int columnIndex21 = cursor.getColumnIndex("abi");
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

    public static ContentValues toContentValues(BundleInfo bundleInfo) {
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
        contentValues.put("visible", Boolean.valueOf(bundleInfo.isVisible()));
        contentValues.put("removalbe", Boolean.valueOf(bundleInfo.isRemovable()));
        contentValues.put("size", Long.valueOf(bundleInfo.getSize()));
        contentValues.put("need_remove", Boolean.valueOf(bundleInfo.isNeedRemove()));
        contentValues.put("abi", Integer.valueOf(bundleInfo.getAbi()));
        contentValues.put("ext", bundleInfo.getExt());
        contentValues.put("silence", Integer.valueOf(bundleInfo.getSilence()));
        contentValues.put("silence_update", Integer.valueOf(bundleInfo.getSilenceUpdate()));
        contentValues.put("wifionly", Integer.valueOf(bundleInfo.getWifiOnly()));
        return contentValues;
    }

    public static void updateBundleInfoConfig(BundleInfo bundleInfo, BundleInfo bundleInfo2) {
        if (bundleInfo == null || bundleInfo2 == null) {
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
        return this.abi;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getApkPath() {
        return this.apkPath;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDependence() {
        return this.dependence;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDescription() {
        return this.description;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getExt() {
        return this.ext;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getMd5() {
        return this.md5;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getMinVersion() {
        return this.minVersion;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public String getSignature() {
        return this.signature;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilence() {
        return this.silence;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getSilenceUpdate() {
        return this.silenceUpdate;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getSize() {
        return this.size;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getType() {
        return this.type;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public long getUpdateV() {
        return this.updateV;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public int getWifiOnly() {
        return this.wifiOnly;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isBroken() {
        return this.broken;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isForbidden() {
        return this.forbidden;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isNeedRemove() {
        return this.needRemove;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isRemovable() {
        return this.removable;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean isVisible() {
        return this.visible;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public boolean needForceUpdate() {
        return this.forceUpdate;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setAbi(int i2) {
        this.abi = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setApkPath(String str) {
        this.apkPath = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setBroken(boolean z) {
        this.broken = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDependence(String str) {
        this.dependence = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setExt(String str) {
        this.ext = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForbidden(boolean z) {
        this.forbidden = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setForceUpdate(boolean z) {
        this.forceUpdate = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMd5(String str) {
        this.md5 = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setMinVersion(int i2) {
        this.minVersion = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setName(String str) {
        this.name = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setNeedRemove(boolean z) {
        this.needRemove = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setPackageName(String str) {
        this.packageName = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setRemovable(boolean z) {
        this.removable = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSignature(String str) {
        this.signature = str;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilence(int i2) {
        this.silence = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSilenceUpdate(int i2) {
        this.silenceUpdate = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setSize(long j) {
        this.size = j;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setType(int i2) {
        this.type = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setUpdateV(long j) {
        this.updateV = j;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVersionCode(int i2) {
        this.versionCode = i2;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setVisible(boolean z) {
        this.visible = z;
    }

    @Override // com.baidu.nps.pm.IBundleInfo
    public void setWifiOnly(int i2) {
        this.wifiOnly = i2;
    }

    public Map<String, BundleInfoGroup> toBundleInfoGroups(List<BundleInfo> list, long j) {
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

    public BundleInfo(IBundleInfo iBundleInfo) {
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
        bundleInfo.setVisible(contentValues.getAsBoolean("visible").booleanValue());
        bundleInfo.setRemovable(contentValues.getAsBoolean("removalbe").booleanValue());
        bundleInfo.setSize(contentValues.getAsLong("size").longValue());
        bundleInfo.setNeedRemove(contentValues.getAsBoolean("need_remove").booleanValue());
        bundleInfo.setAbi(contentValues.getAsInteger("abi").intValue());
        bundleInfo.setExt(contentValues.getAsString("ext"));
        bundleInfo.setSilence(contentValues.getAsInteger("silence").intValue());
        bundleInfo.setSilenceUpdate(contentValues.getAsInteger("silence_update").intValue());
        bundleInfo.setWifiOnly(contentValues.getAsInteger("wifionly").intValue());
        return bundleInfo;
    }

    public static ContentValues toContentValues(IBundleInfo iBundleInfo) {
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
        contentValues.put("visible", Boolean.valueOf(iBundleInfo.isVisible()));
        contentValues.put("removalbe", Boolean.valueOf(iBundleInfo.isRemovable()));
        contentValues.put("size", Long.valueOf(iBundleInfo.getSize()));
        contentValues.put("need_remove", Boolean.valueOf(iBundleInfo.isNeedRemove()));
        contentValues.put("abi", Integer.valueOf(iBundleInfo.getAbi()));
        contentValues.put("ext", iBundleInfo.getExt());
        contentValues.put("silence", Integer.valueOf(iBundleInfo.getSilence()));
        contentValues.put("silence_update", Integer.valueOf(iBundleInfo.getSilenceUpdate()));
        contentValues.put("wifionly", Integer.valueOf(iBundleInfo.getWifiOnly()));
        return contentValues;
    }
}
