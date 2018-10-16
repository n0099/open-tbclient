package com.baidu.searchbox.ng.ai.apps.database.subpackage;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageTable;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SubPackageInfoHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "SubPackageInfoHelper";
    private static SubPackageInfoHelper sInstance;
    private Context mContext = AppRuntime.getAppContext();

    private SubPackageInfoHelper() {
    }

    public static SubPackageInfoHelper getInstance() {
        if (sInstance == null) {
            synchronized (SubPackageInfoHelper.class) {
                if (sInstance == null) {
                    sInstance = new SubPackageInfoHelper();
                }
            }
        }
        return sInstance;
    }

    public void initSubPackageStatus(String str, String str2, AiAppsConfigData aiAppsConfigData) {
        if (aiAppsConfigData != null && aiAppsConfigData.mSubPackageList != null) {
            List<AiAppsConfigData.SubPackage> list = aiAppsConfigData.mSubPackageList.mPackageList;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
                clearSubPackageInfo(str, str2);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                ContentValues contentValues = new ContentValues();
                for (AiAppsConfigData.SubPackage subPackage : list) {
                    if (subPackage != null) {
                        contentValues.clear();
                        contentValues.put(SubPackageTable.Table.app_id.toString(), str);
                        contentValues.put(SubPackageTable.Table.version.toString(), str2);
                        contentValues.put(SubPackageTable.Table.package_name.toString(), subPackage.mRoot);
                        contentValues.put(SubPackageTable.Table.is_exist.toString(), (Integer) 0);
                        if (aiAppsConfigData.mSubPackagesPath != null && aiAppsConfigData.mSubPackagesPath.mSubPackagesPathMap != null) {
                            String str3 = aiAppsConfigData.mSubPackagesPath.mSubPackagesPathMap.get(subPackage.mRoot);
                            if (!TextUtils.isEmpty(str3)) {
                                contentValues.put(SubPackageTable.Table.aps_package_name.toString(), str3);
                            }
                        }
                        arrayList.add(ContentProviderOperation.newInsert(SubPackageProvider.getUri()).withValues(contentValues).withYieldAllowed(true).build());
                    }
                }
                try {
                    this.mContext.getContentResolver().applyBatch(SubPackageProvider.AUTHORITY, arrayList);
                } catch (OperationApplicationException e) {
                } catch (RemoteException e2) {
                }
            }
        }
    }

    public void clearSubPackageInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mContext.getContentResolver().delete(SubPackageProvider.getUri(), SubPackageTable.Table.app_id + "=? AND " + SubPackageTable.Table.version + "=?", new String[]{str, str2});
        }
    }

    public void clearAllVersionSubPackageInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mContext.getContentResolver().delete(SubPackageProvider.getUri(), SubPackageTable.Table.app_id + "=?", new String[]{str});
        }
    }

    public void downloadSubPackageSuccess(String str, String str2, String str3) {
        updateSubPackageStatus(str, str2, str3, true);
    }

    public void updateSubPackageStatus(String str, String str2, String str3, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(SubPackageTable.Table.is_exist.toString(), Integer.valueOf(z ? 1 : 0));
            this.mContext.getContentResolver().update(SubPackageProvider.getUri(), contentValues, SubPackageTable.Table.app_id + "=? AND " + SubPackageTable.Table.package_name + "=? AND " + SubPackageTable.Table.version + "=?", new String[]{str, str3, str2});
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    public boolean isSubPackageExist(String str, String str2, String str3) {
        Cursor cursor;
        boolean z = false;
        ?? r1 = "=?";
        try {
            try {
                cursor = this.mContext.getContentResolver().query(SubPackageProvider.getUri(), new String[]{SubPackageTable.Table.is_exist.toString()}, SubPackageTable.Table.app_id + "=? AND " + SubPackageTable.Table.package_name + "=? AND " + SubPackageTable.Table.version + "=?", new String[]{str, str3, str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            z = cursor.getInt(cursor.getColumnIndex(SubPackageTable.Table.is_exist.toString())) == 1;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.e(TAG, "isSubPackageExist:" + e.getMessage());
                        AiAppsFileUtils.closeSafely(cursor);
                        return z;
                    }
                }
                AiAppsFileUtils.closeSafely(cursor);
            } catch (Throwable th) {
                th = th;
                AiAppsFileUtils.closeSafely(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            AiAppsFileUtils.closeSafely(r1);
            throw th;
        }
        return z;
    }
}
