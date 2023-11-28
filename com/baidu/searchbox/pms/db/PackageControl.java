package com.baidu.searchbox.pms.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.init.response.ParseUtils;
import com.baidu.searchbox.pms.utils.ABIUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PackageControl {
    public static volatile PackageControl sInstance;
    public Context mContext = AppRuntime.getAppContext();

    public static PackageControl getInstance() {
        if (sInstance == null) {
            synchronized (PackageControl.class) {
                if (sInstance == null) {
                    sInstance = new PackageControl();
                }
            }
        }
        return sInstance;
    }

    private Cursor getQueryCursor() {
        return PmsContentProviderImpl.queryExt(this.mContext, "select * from package_info", null);
    }

    public List<PackageInfo> queryAllItems() {
        Cursor cursor;
        Throwable th;
        List<PackageInfo> list = null;
        try {
            cursor = getQueryCursor();
            if (cursor != null) {
                try {
                    try {
                        list = getPackageFiles(cursor);
                    } catch (Exception e) {
                        e = e;
                        DebugUtils.printStackTrace(e);
                        Closeables.closeSafely(cursor);
                        return list;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            Closeables.closeSafely(cursor);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return list;
    }

    private ContentValues getContentValues(PackageInfo packageInfo) {
        ContentValues contentValues = new ContentValues();
        if (!TextUtils.isEmpty(packageInfo.packageName)) {
            contentValues.put("package_name", packageInfo.packageName);
        }
        if (!TextUtils.isEmpty(packageInfo.name)) {
            contentValues.put("name", packageInfo.name);
        }
        contentValues.put("version", Long.valueOf(packageInfo.version));
        contentValues.put("update_version", Long.valueOf(packageInfo.updateVersion));
        if (!TextUtils.isEmpty(packageInfo.downloadUrl)) {
            contentValues.put("download_url", packageInfo.downloadUrl);
        }
        if (!TextUtils.isEmpty(packageInfo.channelId)) {
            contentValues.put("channel_id", packageInfo.channelId);
        }
        if (!TextUtils.isEmpty(packageInfo.md5)) {
            contentValues.put("md5", packageInfo.md5);
        }
        contentValues.put(PackageTable.MIN_HOST_VERSION, packageInfo.minHostVersion);
        contentValues.put(PackageTable.MAX_HOST_VERSION, packageInfo.maxHostVersion);
        if (!TextUtils.isEmpty(packageInfo.size)) {
            contentValues.put("size", packageInfo.size);
        }
        contentValues.put("wifi", Integer.valueOf(packageInfo.wifi));
        contentValues.put(PackageTable.IS_SILENCE, Integer.valueOf(packageInfo.isSilence));
        contentValues.put(PackageTable.DISABLE, Integer.valueOf(packageInfo.disable));
        contentValues.put("sign", packageInfo.sign);
        contentValues.put(PackageTable.DOWNLOAD_OPTION, Integer.valueOf(packageInfo.downloadOption));
        if (!TextUtils.isEmpty(packageInfo.extraServer)) {
            contentValues.put(PackageTable.EXTRA_FROM_SERVER, packageInfo.extraServer);
        }
        contentValues.put("type", Integer.valueOf(packageInfo.type));
        if (!TextUtils.isEmpty(packageInfo.extraLocal)) {
            contentValues.put(PackageTable.EXTRA_FROM_LOCAL, packageInfo.extraLocal);
        }
        contentValues.put(PackageTable.FILE_PATH, packageInfo.filePath);
        contentValues.put(PackageTable.TOTAL_SIZE, Long.valueOf(packageInfo.totalSize));
        contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(packageInfo.currentSize));
        contentValues.put("create_time", Long.valueOf(packageInfo.createTime));
        contentValues.put("update_time", Long.valueOf(packageInfo.updateTime));
        contentValues.put(PackageTable.IS_MAIN_ENTRANCE, Integer.valueOf(packageInfo.isMainEntrance() ? 1 : 0));
        if (!TextUtils.isEmpty(packageInfo.getDependenciesString())) {
            contentValues.put(PackageTable.DEPENDENCY_PACKAGE, packageInfo.getDependenciesString());
        }
        if (!TextUtils.isEmpty(packageInfo.updateSign)) {
            contentValues.put(PackageTable.UPDATE_SIGN, packageInfo.updateSign);
        }
        if (!TextUtils.isEmpty(packageInfo.abi)) {
            contentValues.put("abi", packageInfo.abi);
        }
        return contentValues;
    }

    private Cursor getPackageFileCursorByGroup(List<Pair<String, String>> list, boolean z, String str, String str2, String str3) {
        Pair<String, String> pair;
        String str4;
        int size = list.size();
        String[] strArr = new String[size];
        String str5 = "SELECT * FROM package_info";
        if (list.size() > 0 || !TextUtils.isEmpty(str)) {
            String str6 = "SELECT * FROM package_info WHERE ";
            int i = 0;
            while (i < size) {
                str6 = str6 + ((String) pair.first) + " = ? ";
                strArr[i] = (String) list.get(i).second;
                i++;
                if (i < size) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str6);
                    if (z) {
                        str4 = "AND ";
                    } else {
                        str4 = "OR ";
                    }
                    sb.append(str4);
                    str6 = sb.toString();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                str5 = str6 + "ORDER BY " + str;
                if (!TextUtils.isEmpty(str3)) {
                    str5 = str5 + " " + str3;
                }
            } else {
                str5 = str6;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            str5 = "SELECT * FROM (" + str5 + " ) AS a GROUP BY a." + str2;
        }
        return PmsContentProviderImpl.queryExt(this.mContext, str5, strArr);
    }

    private List<PackageInfo> getPackageFiles(Cursor cursor) {
        int i;
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
        int i13;
        int i14;
        int i15;
        int i16;
        ArrayList arrayList;
        Cursor cursor2 = cursor;
        ArrayList arrayList2 = new ArrayList();
        if (cursor2 != null && cursor.getCount() > 0) {
            int columnIndex = cursor2.getColumnIndex("package_name");
            int columnIndex2 = cursor2.getColumnIndex("update_version");
            int columnIndex3 = cursor2.getColumnIndex("download_url");
            int columnIndex4 = cursor2.getColumnIndex("version");
            int columnIndex5 = cursor2.getColumnIndex("name");
            int columnIndex6 = cursor2.getColumnIndex("md5");
            int columnIndex7 = cursor2.getColumnIndex("size");
            int columnIndex8 = cursor2.getColumnIndex(PackageTable.EXTRA_FROM_SERVER);
            int columnIndex9 = cursor2.getColumnIndex(PackageTable.MIN_HOST_VERSION);
            int columnIndex10 = cursor2.getColumnIndex(PackageTable.MAX_HOST_VERSION);
            int columnIndex11 = cursor2.getColumnIndex(PackageTable.DOWNLOAD_OPTION);
            int columnIndex12 = cursor2.getColumnIndex("channel_id");
            int columnIndex13 = cursor2.getColumnIndex("wifi");
            ArrayList arrayList3 = arrayList2;
            int columnIndex14 = cursor2.getColumnIndex(PackageTable.IS_SILENCE);
            int columnIndex15 = cursor2.getColumnIndex(PackageTable.DISABLE);
            int columnIndex16 = cursor2.getColumnIndex("sign");
            int columnIndex17 = cursor2.getColumnIndex("type");
            int columnIndex18 = cursor2.getColumnIndex(PackageTable.EXTRA_FROM_LOCAL);
            int columnIndex19 = cursor2.getColumnIndex(PackageTable.FILE_PATH);
            int columnIndex20 = cursor2.getColumnIndex(PackageTable.TOTAL_SIZE);
            int columnIndex21 = cursor2.getColumnIndex(PackageTable.CURRENT_SIZE);
            int columnIndex22 = cursor2.getColumnIndex("create_time");
            int columnIndex23 = cursor2.getColumnIndex("update_time");
            int columnIndex24 = cursor2.getColumnIndex("_id");
            int columnIndex25 = cursor2.getColumnIndex(PackageTable.UPDATE_SIGN);
            int columnIndex26 = cursor2.getColumnIndex(PackageTable.IS_MAIN_ENTRANCE);
            int i17 = columnIndex13;
            int columnIndex27 = cursor2.getColumnIndex(PackageTable.DEPENDENCY_PACKAGE);
            int columnIndex28 = cursor2.getColumnIndex("abi");
            if (!cursor.moveToFirst()) {
                return arrayList3;
            }
            while (true) {
                String string = cursor2.getString(columnIndex);
                if (TextUtils.isEmpty(string)) {
                    i2 = columnIndex26;
                    i = columnIndex;
                    arrayList = arrayList3;
                    i16 = columnIndex27;
                    int i18 = columnIndex20;
                    i7 = columnIndex2;
                    i13 = columnIndex25;
                    i15 = i18;
                    int i19 = i17;
                    i6 = columnIndex3;
                    i14 = columnIndex28;
                    i4 = columnIndex14;
                    i5 = columnIndex12;
                    i3 = i19;
                    int i20 = columnIndex21;
                    i8 = columnIndex4;
                    i11 = columnIndex23;
                    i12 = columnIndex22;
                    i9 = columnIndex5;
                    i10 = i20;
                } else {
                    i = columnIndex;
                    int i21 = columnIndex28;
                    int i22 = cursor2.getInt(columnIndex26);
                    i2 = columnIndex26;
                    boolean z = true;
                    if (i22 != 1) {
                        z = false;
                    }
                    PackageInfo packageInfo = new PackageInfo(z);
                    packageInfo.errNo = 0;
                    packageInfo.packageName = string;
                    int i23 = columnIndex12;
                    packageInfo.updateVersion = cursor2.getLong(columnIndex2);
                    packageInfo.downloadUrl = cursor2.getString(columnIndex3);
                    packageInfo.version = cursor2.getLong(columnIndex4);
                    packageInfo.name = cursor2.getString(columnIndex5);
                    packageInfo.maxHostVersion = cursor2.getString(columnIndex10);
                    packageInfo.minHostVersion = cursor2.getString(columnIndex9);
                    packageInfo.md5 = cursor2.getString(columnIndex6);
                    packageInfo.size = cursor2.getString(columnIndex7);
                    packageInfo.downloadOption = cursor2.getInt(columnIndex11);
                    String string2 = cursor2.getString(columnIndex8);
                    packageInfo.extraServer = string2;
                    if (!TextUtils.isEmpty(string2)) {
                        try {
                            packageInfo.uniqueVersion = new JSONObject(packageInfo.extraServer).optString(ParseUtils.UNIQUE_VERSION);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    packageInfo.channelId = cursor2.getString(i23);
                    i3 = i17;
                    packageInfo.wifi = cursor2.getInt(i3);
                    i4 = columnIndex14;
                    packageInfo.isSilence = cursor2.getInt(i4);
                    i5 = i23;
                    packageInfo.disable = cursor2.getInt(columnIndex15);
                    packageInfo.sign = cursor2.getString(columnIndex16);
                    packageInfo.type = cursor2.getInt(columnIndex17);
                    packageInfo.extraLocal = cursor2.getString(columnIndex18);
                    packageInfo.filePath = cursor2.getString(columnIndex19);
                    i6 = columnIndex3;
                    int i24 = columnIndex20;
                    i7 = columnIndex2;
                    packageInfo.totalSize = cursor2.getLong(i24);
                    int i25 = columnIndex21;
                    i8 = columnIndex4;
                    packageInfo.currentSize = cursor2.getLong(i25);
                    int i26 = columnIndex22;
                    i9 = columnIndex5;
                    packageInfo.createTime = cursor2.getLong(i26);
                    i10 = i25;
                    i11 = columnIndex23;
                    i12 = i26;
                    packageInfo.updateTime = cursor2.getLong(i11);
                    packageInfo.rawId = cursor2.getInt(columnIndex24);
                    i13 = columnIndex25;
                    packageInfo.updateSign = cursor2.getString(i13);
                    i14 = i21;
                    packageInfo.abi = cursor2.getString(i14);
                    i15 = i24;
                    i16 = columnIndex27;
                    String string3 = cursor2.getString(i16);
                    if (!TextUtils.isEmpty(string3)) {
                        try {
                            packageInfo.setDependenciesString(new JSONObject(string3));
                        } catch (Exception unused) {
                        }
                    }
                    arrayList = arrayList3;
                    arrayList.add(packageInfo);
                }
                if (cursor.moveToNext()) {
                    arrayList3 = arrayList;
                    columnIndex27 = i16;
                    columnIndex = i;
                    columnIndex26 = i2;
                    cursor2 = cursor;
                    int i27 = i15;
                    columnIndex25 = i13;
                    columnIndex2 = i7;
                    columnIndex20 = i27;
                    int i28 = i4;
                    columnIndex28 = i14;
                    columnIndex3 = i6;
                    i17 = i3;
                    columnIndex12 = i5;
                    columnIndex14 = i28;
                    int i29 = i12;
                    columnIndex23 = i11;
                    columnIndex4 = i8;
                    columnIndex21 = i10;
                    columnIndex5 = i9;
                    columnIndex22 = i29;
                } else {
                    return arrayList;
                }
            }
        } else {
            return arrayList2;
        }
    }

    public synchronized long addOrUpdate(PackageInfo packageInfo) {
        PackageInfo lastPackageFile;
        if (packageInfo == null) {
            return 0L;
        }
        packageInfo.updateTime = System.currentTimeMillis();
        if (packageInfo.rawId <= 0 && (lastPackageFile = PackageManager.getLastPackageFile(packageInfo.channelId, packageInfo.packageName, packageInfo.md5)) != null) {
            packageInfo.rawId = lastPackageFile.rawId;
        }
        ContentValues contentValues = getContentValues(packageInfo);
        if (packageInfo.rawId > 0) {
            String[] strArr = {String.valueOf(packageInfo.rawId)};
            DebugUtils.log("【更新db】", packageInfo);
            if (PmsContentProviderImpl.updateExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, contentValues, "_id =? ", strArr) <= 0) {
                return 0L;
            }
            return packageInfo.rawId;
        }
        packageInfo.createTime = packageInfo.updateTime;
        DebugUtils.log("【插入db】", packageInfo);
        packageInfo.rawId = PmsContentProviderImpl.insertExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, contentValues);
        if (packageInfo.rawId > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair<>("channel_id", packageInfo.channelId));
            arrayList.add(new Pair<>("package_name", packageInfo.packageName));
            if (ABIUtils.checkCpuAbiIs64()) {
                arrayList.add(new Pair<>("abi", "1"));
            } else {
                arrayList.add(new Pair<>("abi", "2"));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Pair<>("update_time", "" + packageInfo.updateTime));
            deleteItemExceptByKeValues(arrayList, arrayList2, true);
        }
        return packageInfo.rawId;
    }

    public boolean deleteFinishedItem(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair<>("channel_id", str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new Pair<>("package_name", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new Pair<>("update_version", str3));
        }
        arrayList.add(new Pair<>("type", "10"));
        return deleteItemByKeValues(arrayList, true);
    }

    public boolean deleteItemByKeValues(List<Pair<String, String>> list, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[list.size()];
        int i = 0;
        for (Pair<String, String> pair : list) {
            if (i == 0) {
                sb.append(pair.first + " =? ");
            } else {
                if (z) {
                    str = " AND ";
                } else {
                    str = " OR ";
                }
                sb.append(str);
                sb.append(pair.first + " =? ");
            }
            strArr[i] = "" + pair.second;
            i++;
        }
        if (PmsContentProviderImpl.deleteExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, sb.toString(), strArr) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0054 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0046 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.searchbox.pms.db.PackageControl] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.database.Cursor] */
    @Nullable
    public List<PackageInfo> queryFinishedItems(@NonNull String str, @Nullable List<String> list) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("channel_id", str));
        arrayList.add(new Pair("type", "10"));
        ?? arrayList2 = new ArrayList();
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                arrayList2.add(new Pair("package_name", str2));
            }
        }
        List<PackageInfo> list2 = null;
        try {
            try {
                cursor = getPackageFileCursor(arrayList, arrayList2, "update_version", "DESC");
                try {
                    list2 = safeLoadPackageFile(cursor);
                    arrayList2 = cursor;
                } catch (Exception e) {
                    e = e;
                    DebugUtils.printStackTrace(e);
                    arrayList2 = cursor;
                    Closeables.closeSafely((Cursor) arrayList2);
                    return list2;
                }
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Cursor) arrayList2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            arrayList2 = 0;
            Closeables.closeSafely((Cursor) arrayList2);
            throw th;
        }
        Closeables.closeSafely((Cursor) arrayList2);
        return list2;
    }

    public boolean deleteItemExceptByKeValues(List<Pair<String, String>> list, List<Pair<String, String>> list2, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[list.size() + list2.size()];
        Iterator<Pair<String, String>> it = list.iterator();
        int i = 0;
        while (true) {
            String str2 = " AND ";
            if (!it.hasNext()) {
                break;
            }
            Pair<String, String> next = it.next();
            if (i == 0) {
                sb.append(next.first + " =? ");
            } else {
                if (!z) {
                    str2 = " OR ";
                }
                sb.append(str2);
                sb.append(next.first + " =? ");
            }
            strArr[i] = "" + next.second;
            i++;
        }
        for (Pair<String, String> pair : list2) {
            if (i == 0) {
                sb.append(pair.first + " !=? ");
            } else {
                if (z) {
                    str = " AND ";
                } else {
                    str = " OR ";
                }
                sb.append(str);
                sb.append(pair.first + " !=? ");
            }
            strArr[i] = "" + pair.second;
            i++;
        }
        if (PmsContentProviderImpl.deleteExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, sb.toString(), strArr) <= 0) {
            return false;
        }
        return true;
    }

    public boolean deleteRedundantItem(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair<>(PackageTable.FILE_PATH, str));
        return deleteItemByKeValues(arrayList, true);
    }

    public List<PackageInfo> safeLoadPackageFile(Cursor cursor) {
        ArrayList arrayList = new ArrayList(0);
        if (cursor != null) {
            return getPackageFiles(cursor);
        }
        return arrayList;
    }

    public Cursor getPackageFileCursor(List<Pair<String, String>> list, List<Pair<String, String>> list2, String str, String str2) {
        int i;
        Pair<String, String> pair;
        Pair<String, String> pair2;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        int size = list.size() + list2.size();
        String[] strArr = new String[size];
        String str3 = "SELECT * FROM package_info";
        if (list.size() > 0 || list2.size() > 0 || str != null) {
            str3 = "SELECT * FROM package_info WHERE ";
        }
        int i2 = 0;
        if (list.size() > 0) {
            int i3 = 0;
            i = 0;
            while (i3 < list.size()) {
                str3 = str3 + ((String) pair2.first) + " = ? ";
                int i4 = i + 1;
                strArr[i] = (String) list.get(i3).second;
                if (i4 < size) {
                    str3 = str3 + "AND ";
                }
                i3++;
                i = i4;
            }
        } else {
            i = 0;
        }
        if (list2.size() > 0) {
            String str4 = str3 + " ( ";
            while (i2 < list2.size()) {
                str4 = str4 + ((String) pair.first) + " = ? ";
                int i5 = i + 1;
                strArr[i] = (String) list2.get(i2).second;
                if (i5 < size) {
                    str4 = str4 + "OR ";
                }
                i2++;
                i = i5;
            }
            str3 = str4 + ") ";
        }
        if (!TextUtils.isEmpty(str)) {
            str3 = str3 + "ORDER BY " + str;
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + " " + str2;
            }
        }
        return PmsContentProviderImpl.queryExt(this.mContext, str3, strArr);
    }

    public List<PackageInfo> queryFinishedItems(String str, String str2, String str3) {
        return queryItems(str, str2, str3, "", 10);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x005e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0072 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x004c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.lang.String] */
    public List<PackageInfo> queryItems(String str, String str2, String str3, String str4, int i) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair<>("channel_id", str));
        if (str2 != null) {
            arrayList.add(new Pair<>("package_name", str2));
        }
        if (i >= 0) {
            str2 = i + "";
            arrayList.add(new Pair<>("type", str2));
        }
        Cursor cursor2 = str2;
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new Pair<>("md5", str3));
            cursor2 = "md5";
        }
        List<PackageInfo> list = null;
        try {
            try {
                cursor = getPackageFileCursorByGroup(arrayList, true, "update_version", str4, null);
                try {
                    list = safeLoadPackageFile(cursor);
                    cursor2 = cursor;
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                        cursor2 = cursor;
                    }
                    Closeables.closeSafely(cursor2);
                    return list;
                }
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor2 = null;
            th = th3;
            Closeables.closeSafely(cursor2);
            throw th;
        }
        Closeables.closeSafely(cursor2);
        return list;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0011 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x0022 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.util.Pair, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.baidu.searchbox.pms.db.PackageControl] */
    public List<PackageInfo> queryRedundantItems(String str) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        ?? pair = new Pair(PackageTable.FILE_PATH, str);
        arrayList.add(pair);
        List<PackageInfo> list = null;
        try {
            try {
                cursor = getPackageFileCursorByGroup(arrayList, true, "update_version", "package_name", null);
                try {
                    list = safeLoadPackageFile(cursor);
                    pair = cursor;
                } catch (Exception e) {
                    e = e;
                    pair = cursor;
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                        pair = cursor;
                    }
                    Closeables.closeSafely((Cursor) pair);
                    return list;
                }
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Cursor) pair);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            pair = 0;
            th = th3;
            Closeables.closeSafely((Cursor) pair);
            throw th;
        }
        Closeables.closeSafely((Cursor) pair);
        return list;
    }

    public int resetFinishedUpdateVersion(String str, List<String> list) {
        int i;
        int i2 = 2;
        if (list != null) {
            i = list.size() + 2;
        } else {
            i = 2;
        }
        String[] strArr = new String[i];
        strArr[0] = str;
        strArr[1] = "10";
        String str2 = "channel_id =? AND type =? ";
        if (list != null && list.size() > 0) {
            String str3 = str2 + "AND (";
            for (String str4 : list) {
                str3 = str3 + "package_name =? ";
                int i3 = i2 + 1;
                strArr[i2] = str4;
                if (i3 < i) {
                    str3 = str3 + "OR ";
                }
                i2 = i3;
            }
            str2 = str3 + SmallTailInfo.EMOTION_SUFFIX;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("update_version", "-1");
        return PmsContentProviderImpl.updateExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, contentValues, str2, strArr);
    }
}
