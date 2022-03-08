package com.baidu.searchbox.pms.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.utils.ABIUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PackageControl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile PackageControl sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public PackageControl() {
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
        this.mContext = AppRuntime.getAppContext();
    }

    private ContentValues getContentValues(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, packageInfo)) == null) {
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
                contentValues.put(PackageTable.MD5, packageInfo.md5);
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
                contentValues.put(PackageTable.ABI, packageInfo.abi);
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static PackageControl getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (PackageControl.class) {
                    if (sInstance == null) {
                        sInstance = new PackageControl();
                    }
                }
            }
            return sInstance;
        }
        return (PackageControl) invokeV.objValue;
    }

    private Cursor getPackageFileCursorByGroup(List<Pair<String, String>> list, boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Pair<String, String> pair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{list, Boolean.valueOf(z), str, str2, str3})) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            String str4 = "SELECT * FROM package_info";
            if (list.size() > 0 || !TextUtils.isEmpty(str)) {
                String str5 = "SELECT * FROM package_info WHERE ";
                int i2 = 0;
                while (i2 < size) {
                    str5 = str5 + ((String) pair.first) + " = ? ";
                    strArr[i2] = (String) list.get(i2).second;
                    i2++;
                    if (i2 < size) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str5);
                        sb.append(z ? "AND " : "OR ");
                        str5 = sb.toString();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str4 = str5;
                } else {
                    str4 = str5 + "ORDER BY " + str;
                    if (!TextUtils.isEmpty(str3)) {
                        str4 = str4 + " " + str3;
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                str4 = "SELECT * FROM (" + str4 + " ) AS a GROUP BY a." + str2;
            }
            return PmsContentProviderImpl.queryExt(this.mContext, str4, strArr);
        }
        return (Cursor) invokeCommon.objValue;
    }

    private List<PackageInfo> getPackageFiles(Cursor cursor) {
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
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cursor)) != null) {
            return (List) invokeL.objValue;
        }
        Cursor cursor2 = cursor;
        ArrayList arrayList2 = new ArrayList();
        if (cursor2 == null || cursor.getCount() <= 0) {
            return arrayList2;
        }
        int columnIndex = cursor2.getColumnIndex("package_name");
        int columnIndex2 = cursor2.getColumnIndex("update_version");
        int columnIndex3 = cursor2.getColumnIndex("download_url");
        int columnIndex4 = cursor2.getColumnIndex("version");
        int columnIndex5 = cursor2.getColumnIndex("name");
        int columnIndex6 = cursor2.getColumnIndex(PackageTable.MD5);
        int columnIndex7 = cursor2.getColumnIndex("size");
        int columnIndex8 = cursor2.getColumnIndex(PackageTable.EXTRA_FROM_SERVER);
        int columnIndex9 = cursor2.getColumnIndex(PackageTable.MIN_HOST_VERSION);
        int columnIndex10 = cursor2.getColumnIndex(PackageTable.MAX_HOST_VERSION);
        int columnIndex11 = cursor2.getColumnIndex(PackageTable.DOWNLOAD_OPTION);
        int columnIndex12 = cursor2.getColumnIndex("channel_id");
        int columnIndex13 = cursor2.getColumnIndex("wifi");
        int columnIndex14 = cursor2.getColumnIndex(PackageTable.IS_SILENCE);
        ArrayList arrayList3 = arrayList2;
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
        int i19 = columnIndex14;
        int columnIndex27 = cursor2.getColumnIndex(PackageTable.DEPENDENCY_PACKAGE);
        int columnIndex28 = cursor2.getColumnIndex(PackageTable.ABI);
        if (!cursor.moveToFirst()) {
            return arrayList3;
        }
        int i20 = columnIndex28;
        while (true) {
            String string = cursor2.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                i4 = columnIndex26;
                i2 = columnIndex;
                i3 = columnIndex13;
                arrayList = arrayList3;
                i6 = columnIndex15;
                i5 = i19;
                i18 = columnIndex27;
                i7 = columnIndex2;
                i17 = columnIndex25;
                i15 = columnIndex20;
                i9 = columnIndex19;
                i8 = columnIndex3;
                i16 = i20;
                int i21 = columnIndex21;
                i10 = columnIndex4;
                i13 = columnIndex23;
                i14 = columnIndex22;
                i11 = columnIndex5;
                i12 = i21;
            } else {
                i2 = columnIndex;
                i3 = columnIndex13;
                i4 = columnIndex26;
                PackageInfo packageInfo = new PackageInfo(cursor2.getInt(columnIndex26) == 1);
                packageInfo.errNo = 0;
                packageInfo.packageName = string;
                packageInfo.updateVersion = cursor2.getLong(columnIndex2);
                packageInfo.downloadUrl = cursor2.getString(columnIndex3);
                packageInfo.version = cursor2.getLong(columnIndex4);
                packageInfo.name = cursor2.getString(columnIndex5);
                packageInfo.maxHostVersion = cursor2.getString(columnIndex10);
                packageInfo.minHostVersion = cursor2.getString(columnIndex9);
                packageInfo.md5 = cursor2.getString(columnIndex6);
                packageInfo.size = cursor2.getString(columnIndex7);
                packageInfo.downloadOption = cursor2.getInt(columnIndex11);
                packageInfo.extraServer = cursor2.getString(columnIndex8);
                packageInfo.channelId = cursor2.getString(columnIndex12);
                packageInfo.wifi = cursor2.getInt(i3);
                i5 = i19;
                packageInfo.isSilence = cursor2.getInt(i5);
                i6 = columnIndex15;
                packageInfo.disable = cursor2.getInt(i6);
                i7 = columnIndex2;
                packageInfo.sign = cursor2.getString(columnIndex16);
                packageInfo.type = cursor2.getInt(columnIndex17);
                packageInfo.extraLocal = cursor2.getString(columnIndex18);
                int i22 = columnIndex19;
                packageInfo.filePath = cursor2.getString(i22);
                i8 = columnIndex3;
                int i23 = columnIndex20;
                i9 = i22;
                packageInfo.totalSize = cursor2.getLong(i23);
                int i24 = columnIndex21;
                i10 = columnIndex4;
                packageInfo.currentSize = cursor2.getLong(i24);
                int i25 = columnIndex22;
                i11 = columnIndex5;
                packageInfo.createTime = cursor2.getLong(i25);
                i12 = i24;
                i13 = columnIndex23;
                i14 = i25;
                packageInfo.updateTime = cursor2.getLong(i13);
                packageInfo.rawId = cursor2.getInt(columnIndex24);
                int i26 = columnIndex25;
                packageInfo.updateSign = cursor2.getString(i26);
                i15 = i23;
                i16 = i20;
                packageInfo.abi = cursor2.getString(i16);
                i17 = i26;
                i18 = columnIndex27;
                String string2 = cursor2.getString(i18);
                if (!TextUtils.isEmpty(string2)) {
                    try {
                        packageInfo.setDependenciesString(new JSONObject(string2));
                    } catch (Exception unused) {
                    }
                }
                arrayList = arrayList3;
                arrayList.add(packageInfo);
            }
            if (!cursor.moveToNext()) {
                return arrayList;
            }
            arrayList3 = arrayList;
            columnIndex27 = i18;
            i20 = i16;
            columnIndex2 = i7;
            columnIndex3 = i8;
            columnIndex19 = i9;
            columnIndex20 = i15;
            columnIndex25 = i17;
            columnIndex = i2;
            columnIndex26 = i4;
            cursor2 = cursor;
            i19 = i5;
            columnIndex15 = i6;
            columnIndex13 = i3;
            int i27 = i14;
            columnIndex23 = i13;
            columnIndex4 = i10;
            columnIndex21 = i12;
            columnIndex5 = i11;
            columnIndex22 = i27;
        }
    }

    private Cursor getQueryCursor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? PmsContentProviderImpl.queryExt(this.mContext, "select * from package_info", null) : (Cursor) invokeV.objValue;
    }

    public synchronized long addOrUpdate(PackageInfo packageInfo) {
        InterceptResult invokeL;
        PackageInfo lastPackageFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, packageInfo)) == null) {
            synchronized (this) {
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
                        arrayList.add(new Pair<>(PackageTable.ABI, "1"));
                    } else {
                        arrayList.add(new Pair<>(PackageTable.ABI, "2"));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Pair<>("update_time", "" + packageInfo.updateTime));
                    deleteItemExceptByKeValues(arrayList, arrayList2, true);
                }
                return packageInfo.rawId;
            }
        }
        return invokeL.longValue;
    }

    public boolean deleteFinishedItem(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
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
        return invokeLLL.booleanValue;
    }

    public boolean deleteItemByKeValues(List<Pair<String, String>> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[list.size()];
            int i2 = 0;
            for (Pair<String, String> pair : list) {
                if (i2 == 0) {
                    sb.append(pair.first + " =? ");
                } else {
                    sb.append(z ? " AND " : " OR ");
                    sb.append(pair.first + " =? ");
                }
                strArr[i2] = "" + pair.second;
                i2++;
            }
            return PmsContentProviderImpl.deleteExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, sb.toString(), strArr) > 0;
        }
        return invokeLZ.booleanValue;
    }

    public boolean deleteItemExceptByKeValues(List<Pair<String, String>> list, List<Pair<String, String>> list2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, list, list2, z)) == null) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[list.size() + list2.size()];
            Iterator<Pair<String, String>> it = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<String, String> next = it.next();
                if (i2 == 0) {
                    sb.append(next.first + " =? ");
                } else {
                    sb.append(z ? " AND " : " OR ");
                    sb.append(next.first + " =? ");
                }
                strArr[i2] = "" + next.second;
                i2++;
            }
            for (Pair<String, String> pair : list2) {
                if (i2 == 0) {
                    sb.append(pair.first + " !=? ");
                } else {
                    sb.append(z ? " AND " : " OR ");
                    sb.append(pair.first + " !=? ");
                }
                strArr[i2] = "" + pair.second;
                i2++;
            }
            return PmsContentProviderImpl.deleteExt(this.mContext, PmsContentProviderImpl.CONTENT_URI_PACKAGE_INFO, sb.toString(), strArr) > 0;
        }
        return invokeLLZ.booleanValue;
    }

    public Cursor getPackageFileCursor(List<Pair<String, String>> list, List<Pair<String, String>> list2, String str, String str2) {
        InterceptResult invokeLLLL;
        int i2;
        Pair<String, String> pair;
        Pair<String, String> pair2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, list, list2, str, str2)) == null) {
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
            int i3 = 0;
            if (list.size() > 0) {
                int i4 = 0;
                i2 = 0;
                while (i4 < list.size()) {
                    str3 = str3 + ((String) pair2.first) + " = ? ";
                    int i5 = i2 + 1;
                    strArr[i2] = (String) list.get(i4).second;
                    if (i5 < size) {
                        str3 = str3 + "AND ";
                    }
                    i4++;
                    i2 = i5;
                }
            } else {
                i2 = 0;
            }
            if (list2.size() > 0) {
                String str4 = str3 + " ( ";
                while (i3 < list2.size()) {
                    str4 = str4 + ((String) pair.first) + " = ? ";
                    int i6 = i2 + 1;
                    strArr[i2] = (String) list2.get(i3).second;
                    if (i6 < size) {
                        str4 = str4 + "OR ";
                    }
                    i3++;
                    i2 = i6;
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
        return (Cursor) invokeLLLL.objValue;
    }

    public List<PackageInfo> queryAllItems() {
        InterceptResult invokeV;
        Cursor cursor;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<PackageInfo> list = null;
            try {
                cursor = getQueryCursor();
                if (cursor != null) {
                    try {
                        try {
                            list = getPackageFiles(cursor);
                        } catch (Exception e2) {
                            e = e2;
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
            } catch (Exception e3) {
                e = e3;
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
        return (List) invokeV.objValue;
    }

    public List<PackageInfo> queryFinishedItems(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) ? queryItems(str, str2, str3, "package_name", 10) : (List) invokeLLL.objValue;
    }

    public List<PackageInfo> queryItems(String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair<>("channel_id", str));
            if (str2 != null) {
                arrayList.add(new Pair<>("package_name", str2));
            }
            if (i2 >= 0) {
                arrayList.add(new Pair<>("type", i2 + ""));
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new Pair<>(PackageTable.MD5, str3));
            }
            List<PackageInfo> list = null;
            try {
                cursor = getPackageFileCursorByGroup(arrayList, true, "update_version", str4, null);
                try {
                    try {
                        list = safeLoadPackageFile(cursor);
                    } catch (Exception e2) {
                        e = e2;
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return list;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
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
        return (List) invokeCommon.objValue;
    }

    public int resetFinishedUpdateVersion(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, list)) == null) {
            int i2 = 2;
            int size = list != null ? list.size() + 2 : 2;
            String[] strArr = new String[size];
            strArr[0] = str;
            strArr[1] = "10";
            String str2 = "channel_id =? AND type =? ";
            if (list != null && list.size() > 0) {
                String str3 = str2 + "AND (";
                for (String str4 : list) {
                    str3 = str3 + "package_name =? ";
                    int i3 = i2 + 1;
                    strArr[i2] = str4;
                    if (i3 < size) {
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
        return invokeLL.intValue;
    }

    public List<PackageInfo> safeLoadPackageFile(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cursor)) == null) {
            return cursor != null ? getPackageFiles(cursor) : new ArrayList(0);
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0065 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0048 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, com.baidu.searchbox.pms.db.PackageControl] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.database.Cursor] */
    @Nullable
    public List<PackageInfo> queryFinishedItems(@NonNull String str, @Nullable List<String> list) {
        InterceptResult invokeLL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, list)) == null) {
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
                    } catch (Exception e2) {
                        e = e2;
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
            } catch (Exception e3) {
                e = e3;
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
        return (List) invokeLL.objValue;
    }
}
