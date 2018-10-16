package com.baidu.searchbox.ng.ai.apps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.database.cloudconfig.AiAppsConfTokenTable;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageTable;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class AiAppsDbControl {
    private static final String DB_NAME = "ai_apps.db";
    private static final int DB_VERSION = 8;
    private static final int DB_VERSION_10_10_V1 = 7;
    private static final int DB_VERSION_10_12_V1 = 8;
    private static final int DB_VERSION_10_3_6 = 1;
    private static final int DB_VERSION_10_5 = 2;
    private static final int DB_VERSION_10_6 = 3;
    private static final int DB_VERSION_10_7 = 4;
    private static final int DB_VERSION_10_9 = 5;
    private static final int DB_VERSION_10_9_V1 = 6;
    private static final boolean DEBUG = false;
    private static final int DEF_TYPE = 0;
    private static final int ERROR_CODE = 0;
    private static final int HAVE_ZIP = 2;
    private static final int INSERT_DB_ERROR_CODE = -1;
    private static final String TAG = "AiAppsDbControl";
    private static Executor sExecutor;
    private static AiAppsDbHelper sHelper;
    private static volatile AiAppsDbControl sInstance;

    /* loaded from: classes2.dex */
    public enum AiAppsTable {
        _id,
        app_id,
        app_key,
        version,
        description,
        error_code,
        error_detail,
        error_msg,
        resume_date,
        icon,
        icon_url,
        max_swan_version,
        min_swan_version,
        name,
        service_category,
        subject_info,
        sign,
        type,
        is_have_zip,
        app_open_url,
        app_download_url,
        target_swan_version,
        app_zip_size,
        pending_aps_errcode,
        version_code;
        
        public static final String TABLE_NAME = "ai_apps_aps_data";
    }

    public static AiAppsDbControl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AiAppsDbControl.class) {
                if (sInstance == null) {
                    sExecutor = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    sHelper = new AiAppsDbHelper(context.getApplicationContext(), DB_NAME, DB_VERSION);
                    sInstance = new AiAppsDbControl();
                }
            }
        }
        return sInstance;
    }

    /* loaded from: classes2.dex */
    public static final class AiAppsDbHelper extends SQLiteOpenHelper {
        public AiAppsDbHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            createAiAppsTable(sQLiteDatabase);
            AiAppsConfTokenTable.createConfTokenTable(sQLiteDatabase);
            SubPackageTable.createSubPackageTable(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            while (i < i2) {
                switch (i) {
                    case 1:
                        updateAiAppsTableV105(sQLiteDatabase);
                        break;
                    case 2:
                        updateAiAppsTableV106(sQLiteDatabase);
                        AiAppsConfTokenTable.createConfTokenTable(sQLiteDatabase);
                        break;
                    case 3:
                        updateAiAppsTableV107(sQLiteDatabase);
                        break;
                    case 4:
                        updateAiAppsTableV109(sQLiteDatabase);
                        break;
                    case 5:
                        updateAiAppsTableV109_V1(sQLiteDatabase);
                        break;
                    case 6:
                        updateAiAppsTableV1010_V1(sQLiteDatabase);
                        break;
                    case 7:
                        updateAiAppsTableV1012_V1(sQLiteDatabase);
                        break;
                }
                i++;
            }
        }

        private void createAiAppsTable(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(AiAppsDbControl.getCreateTableSql());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        private void updateAiAppsTableV105(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.app_key + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.type + " INTEGER default 0;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateAiAppsTableV106(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.icon_url + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateAiAppsTableV107(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.app_open_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.app_download_url + " TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.target_swan_version + " TEXT;");
                SubPackageTable.createSubPackageTable(sQLiteDatabase);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateAiAppsTableV109(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.app_zip_size + " LONG;");
                sQLiteDatabase.execSQL("ALTER TABLE ai_app_sub_package_data ADD " + SubPackageTable.Table.version + " TEXT;");
                copyVersionFromAiAppsTable(sQLiteDatabase);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateAiAppsTableV109_V1(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.pending_aps_errcode + " INTEGER;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateAiAppsTableV1010_V1(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_app_sub_package_data ADD " + SubPackageTable.Table.aps_package_name + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void updateAiAppsTableV1012_V1(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE ai_apps_aps_data ADD " + AiAppsTable.version_code + " TEXT;");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void copyVersionFromAiAppsTable(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            try {
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT " + AiAppsTable.app_id + "," + AiAppsTable.version + " FROM " + AiAppsTable.TABLE_NAME + " ORDER BY " + AiAppsTable.app_id, new String[0]);
                    if (rawQuery != null) {
                        try {
                            fillSubPackageTableVersion(sQLiteDatabase, rawQuery);
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            AiAppsFileUtils.closeSafely(cursor);
                            throw th;
                        }
                    }
                    AiAppsFileUtils.closeSafely(rawQuery);
                } catch (Exception e) {
                    AiAppsFileUtils.closeSafely(null);
                }
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
            }
        }

        private void fillSubPackageTableVersion(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
            if (cursor != null && sQLiteDatabase != null) {
                String str = SubPackageTable.Table.app_id + "=?";
                ContentValues contentValues = new ContentValues();
                int columnIndex = cursor.getColumnIndex(AiAppsTable.app_id.name());
                int columnIndex2 = cursor.getColumnIndex(AiAppsTable.version.name());
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(columnIndex);
                        contentValues.put(SubPackageTable.Table.version.toString(), cursor.getString(columnIndex2));
                        sQLiteDatabase.update(SubPackageTable.Table.TABLE_NAME, contentValues, str, new String[]{string});
                    } while (cursor.moveToNext());
                }
            }
        }
    }

    public SQLiteOpenHelper getSQLiteOpenHelper() {
        return sHelper;
    }

    public boolean insertAiAppsItem(final AiAppsDbInfo aiAppsDbInfo, boolean z) {
        SQLiteTransaction sQLiteTransaction = new SQLiteTransaction() { // from class: com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.SQLiteTransaction
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                if (sQLiteDatabase.insert(AiAppsTable.TABLE_NAME, null, AiAppsDbControl.this.getAiAppsItemValue(aiAppsDbInfo)) != -1) {
                    return true;
                }
                return false;
            }
        };
        if (z) {
            return runTransactionSyncWithReturn(sQLiteTransaction);
        }
        runTransactionAsync(sQLiteTransaction);
        return true;
    }

    public boolean updateAiAppsItem(final AiAppsDbInfo aiAppsDbInfo, boolean z) {
        SQLiteTransaction sQLiteTransaction = new SQLiteTransaction() { // from class: com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.SQLiteTransaction
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                try {
                    if (sQLiteDatabase.update(AiAppsTable.TABLE_NAME, AiAppsDbControl.this.getAiAppsItemValue(aiAppsDbInfo), AiAppsTable.app_id.name() + " =? ", new String[]{aiAppsDbInfo.appId}) > 0) {
                        return true;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        };
        if (z) {
            return runTransactionSyncWithReturn(sQLiteTransaction);
        }
        runTransactionAsync(sQLiteTransaction);
        return true;
    }

    public boolean updateAiAppsPendingErrcode(final String str, final int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SQLiteTransaction sQLiteTransaction = new SQLiteTransaction() { // from class: com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.SQLiteTransaction
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(AiAppsTable.pending_aps_errcode.name(), Integer.valueOf(i));
                try {
                    if (sQLiteDatabase.update(AiAppsTable.TABLE_NAME, contentValues, AiAppsTable.app_id.name() + " =? ", new String[]{str}) > 0) {
                        return true;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        };
        if (z) {
            return runTransactionSyncWithReturn(sQLiteTransaction);
        }
        runTransactionAsync(sQLiteTransaction);
        return true;
    }

    public void insertOrUpdateAiAppsDataBase(AiAppsDbInfo aiAppsDbInfo) {
        if (!updateAiAppsItem(aiAppsDbInfo, true)) {
            insertAiAppsItem(aiAppsDbInfo, true);
        }
    }

    public boolean deleteAiAppsItemByAppid(final String str, boolean z) {
        SQLiteTransaction sQLiteTransaction = new SQLiteTransaction() { // from class: com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.SQLiteTransaction
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                try {
                    if (sQLiteDatabase.delete(AiAppsTable.TABLE_NAME, AiAppsTable.app_id.name() + " =? ", new String[]{str}) > 0) {
                        return true;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        };
        if (z) {
            return runTransactionSyncWithReturn(sQLiteTransaction);
        }
        runTransactionAsync(sQLiteTransaction);
        return true;
    }

    public AiAppsDbInfo queryAiAppsItem(String str) {
        AiAppsDbInfo aiAppsDbInfo = new AiAppsDbInfo();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = getQueryCursor(str);
                if (cursor != null) {
                    updateQueryAiAppsItemList(cursor, aiAppsDbInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                AiAppsFileUtils.closeSafely(cursor);
            }
        }
        return aiAppsDbInfo;
    }

    public HashMap<String, String> queryAiAppsConfTokens(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            cursor = sHelper.getReadableDatabase().rawQuery("select * from ai_apps_cloud_config_tokens where " + AiAppsConfTokenTable.Table.app_id.name() + " = ? ", new String[]{str});
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    hashMap.put(cursor.getString(cursor.getColumnIndex(AiAppsConfTokenTable.Table.action.name())), cursor.getString(cursor.getColumnIndex(AiAppsConfTokenTable.Table.token.name())));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
        } finally {
            AiAppsFileUtils.closeSafely(cursor);
        }
        return hashMap;
    }

    public boolean updateAiAppsConfTokens(final String str, final HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() <= 0) {
            return false;
        }
        return runTransactionSyncWithReturn(new SQLiteTransaction() { // from class: com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.SQLiteTransaction
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                try {
                    int size = hashMap.size();
                    int i = 0;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AiAppsConfTokenTable.Table.app_id.name(), str);
                        contentValues.put(AiAppsConfTokenTable.Table.action.name(), (String) entry.getKey());
                        contentValues.put(AiAppsConfTokenTable.Table.token.name(), (String) entry.getValue());
                        i = sQLiteDatabase.insertWithOnConflict(AiAppsConfTokenTable.TABLE_NAME, null, contentValues, 5) >= 0 ? i + 1 : i;
                    }
                    if (size == i) {
                        return true;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
    }

    private void updateQueryAiAppsItemList(Cursor cursor, AiAppsDbInfo aiAppsDbInfo) {
        if (cursor != null && cursor.getCount() > 0) {
            int columnIndex = cursor.getColumnIndex(AiAppsTable.app_id.name());
            int columnIndex2 = cursor.getColumnIndex(AiAppsTable.app_key.name());
            int columnIndex3 = cursor.getColumnIndex(AiAppsTable.description.name());
            int columnIndex4 = cursor.getColumnIndex(AiAppsTable.error_code.name());
            int columnIndex5 = cursor.getColumnIndex(AiAppsTable.error_detail.name());
            int columnIndex6 = cursor.getColumnIndex(AiAppsTable.error_msg.name());
            int columnIndex7 = cursor.getColumnIndex(AiAppsTable.resume_date.name());
            int columnIndex8 = cursor.getColumnIndex(AiAppsTable.icon.name());
            int columnIndex9 = cursor.getColumnIndex(AiAppsTable.icon_url.name());
            int columnIndex10 = cursor.getColumnIndex(AiAppsTable.max_swan_version.name());
            int columnIndex11 = cursor.getColumnIndex(AiAppsTable.min_swan_version.name());
            int columnIndex12 = cursor.getColumnIndex(AiAppsTable.name.name());
            int columnIndex13 = cursor.getColumnIndex(AiAppsTable.service_category.name());
            int columnIndex14 = cursor.getColumnIndex(AiAppsTable.subject_info.name());
            int columnIndex15 = cursor.getColumnIndex(AiAppsTable.sign.name());
            int columnIndex16 = cursor.getColumnIndex(AiAppsTable.type.name());
            int columnIndex17 = cursor.getColumnIndex(AiAppsTable.is_have_zip.name());
            int columnIndex18 = cursor.getColumnIndex(AiAppsTable.version.name());
            int columnIndex19 = cursor.getColumnIndex(AiAppsTable.app_open_url.name());
            int columnIndex20 = cursor.getColumnIndex(AiAppsTable.app_download_url.name());
            int columnIndex21 = cursor.getColumnIndex(AiAppsTable.target_swan_version.name());
            int columnIndex22 = cursor.getColumnIndex(AiAppsTable.app_zip_size.name());
            int columnIndex23 = cursor.getColumnIndex(AiAppsTable.pending_aps_errcode.name());
            int columnIndex24 = cursor.getColumnIndex(AiAppsTable.version_code.name());
            if (cursor.moveToFirst() && !TextUtils.isEmpty(cursor.getString(columnIndex))) {
                aiAppsDbInfo.appId = cursor.getString(columnIndex);
                aiAppsDbInfo.appKey = cursor.getString(columnIndex2);
                aiAppsDbInfo.description = cursor.getString(columnIndex3);
                aiAppsDbInfo.errorCode = cursor.getInt(columnIndex4);
                aiAppsDbInfo.errorDetail = cursor.getString(columnIndex5);
                aiAppsDbInfo.errorMsg = cursor.getString(columnIndex6);
                aiAppsDbInfo.resumeDate = cursor.getString(columnIndex7);
                aiAppsDbInfo.icon = cursor.getString(columnIndex8);
                aiAppsDbInfo.iconUrl = cursor.getString(columnIndex9);
                aiAppsDbInfo.maxSwanVersion = cursor.getString(columnIndex10);
                aiAppsDbInfo.minSwanVersion = cursor.getString(columnIndex11);
                aiAppsDbInfo.name = cursor.getString(columnIndex12);
                aiAppsDbInfo.serviceCategory = cursor.getString(columnIndex13);
                aiAppsDbInfo.subjectInfo = cursor.getString(columnIndex14);
                aiAppsDbInfo.sign = cursor.getString(columnIndex15);
                aiAppsDbInfo.type = cursor.getInt(columnIndex16);
                aiAppsDbInfo.isHaveZip = cursor.getInt(columnIndex17);
                aiAppsDbInfo.version = cursor.getString(columnIndex18);
                aiAppsDbInfo.appOpenUrl = cursor.getString(columnIndex19);
                aiAppsDbInfo.appDownloadUrl = cursor.getString(columnIndex20);
                aiAppsDbInfo.targetSwanVersion = cursor.getString(columnIndex21);
                aiAppsDbInfo.mAppZipSize = cursor.getLong(columnIndex22);
                aiAppsDbInfo.mPendingApsErrcode = cursor.getInt(columnIndex23);
                aiAppsDbInfo.versionCode = cursor.getString(columnIndex24);
            }
        }
    }

    private Cursor getQueryCursor(String str) {
        try {
            return sHelper.getReadableDatabase().rawQuery("select * from ai_apps_aps_data where " + AiAppsTable.app_id.name() + " = ? ", new String[]{str});
        } catch (SQLException e) {
            return null;
        }
    }

    public static String getCreateTableSql() {
        return "CREATE TABLE ai_apps_aps_data (" + AiAppsTable._id + " INTEGER PRIMARY KEY AUTOINCREMENT," + AiAppsTable.app_id + " TEXT UNIQUE," + AiAppsTable.app_key + " TEXT," + AiAppsTable.version + " TEXT," + AiAppsTable.description + " TEXT," + AiAppsTable.error_code + " INTEGER," + AiAppsTable.error_detail + " TEXT," + AiAppsTable.error_msg + " TEXT," + AiAppsTable.resume_date + " TEXT," + AiAppsTable.icon + " TEXT," + AiAppsTable.icon_url + " TEXT," + AiAppsTable.max_swan_version + " TEXT," + AiAppsTable.min_swan_version + " TEXT," + AiAppsTable.name + " TEXT," + AiAppsTable.service_category + " TEXT," + AiAppsTable.subject_info + " TEXT," + AiAppsTable.sign + " TEXT," + AiAppsTable.type + " INTEGER," + AiAppsTable.is_have_zip + " INTEGER," + AiAppsTable.app_open_url + " TEXT," + AiAppsTable.app_download_url + " TEXT," + AiAppsTable.target_swan_version + " TEXT," + AiAppsTable.app_zip_size + " LONG," + AiAppsTable.pending_aps_errcode + " INTEGER," + AiAppsTable.version_code + " TEXT);";
    }

    public boolean runTransactionSyncWithReturn(SQLiteTransaction sQLiteTransaction) {
        sQLiteTransaction.run(sHelper.getWritableDatabase());
        return sQLiteTransaction.isTransactionSuccess();
    }

    public void runTransactionAsync(final SQLiteTransaction sQLiteTransaction) {
        sExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl.6
            @Override // java.lang.Runnable
            public void run() {
                sQLiteTransaction.run(AiAppsDbControl.sHelper.getWritableDatabase());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContentValues getAiAppsItemValue(AiAppsDbInfo aiAppsDbInfo) {
        ContentValues contentValues = new ContentValues();
        if (aiAppsDbInfo.appId != null) {
            contentValues.put(AiAppsTable.app_id.name(), aiAppsDbInfo.appId);
        }
        if (aiAppsDbInfo.appKey != null) {
            contentValues.put(AiAppsTable.app_key.name(), aiAppsDbInfo.appKey);
        }
        if (aiAppsDbInfo.description != null) {
            contentValues.put(AiAppsTable.description.name(), aiAppsDbInfo.description);
        }
        if (aiAppsDbInfo.errorCode >= 0) {
            contentValues.put(AiAppsTable.error_code.name(), Integer.valueOf(aiAppsDbInfo.errorCode));
        }
        if (aiAppsDbInfo.errorDetail != null) {
            contentValues.put(AiAppsTable.error_detail.name(), aiAppsDbInfo.errorDetail);
        }
        if (aiAppsDbInfo.errorMsg != null) {
            contentValues.put(AiAppsTable.error_msg.name(), aiAppsDbInfo.errorMsg);
        }
        if (aiAppsDbInfo.resumeDate != null) {
            contentValues.put(AiAppsTable.resume_date.name(), aiAppsDbInfo.resumeDate);
        }
        if (aiAppsDbInfo.icon != null) {
            contentValues.put(AiAppsTable.icon.name(), aiAppsDbInfo.icon);
        }
        if (aiAppsDbInfo.iconUrl != null) {
            contentValues.put(AiAppsTable.icon_url.name(), aiAppsDbInfo.iconUrl);
        }
        if (aiAppsDbInfo.maxSwanVersion != null) {
            contentValues.put(AiAppsTable.max_swan_version.name(), aiAppsDbInfo.maxSwanVersion);
        }
        if (aiAppsDbInfo.minSwanVersion != null) {
            contentValues.put(AiAppsTable.min_swan_version.name(), aiAppsDbInfo.minSwanVersion);
        }
        if (aiAppsDbInfo.name != null) {
            contentValues.put(AiAppsTable.name.name(), aiAppsDbInfo.name);
        }
        if (aiAppsDbInfo.serviceCategory != null) {
            contentValues.put(AiAppsTable.service_category.name(), aiAppsDbInfo.serviceCategory);
        }
        if (aiAppsDbInfo.subjectInfo != null) {
            contentValues.put(AiAppsTable.subject_info.name(), aiAppsDbInfo.subjectInfo);
        }
        if (aiAppsDbInfo.sign != null) {
            contentValues.put(AiAppsTable.sign.name(), aiAppsDbInfo.sign);
        }
        if (aiAppsDbInfo.isHaveZip < 2) {
            contentValues.put(AiAppsTable.is_have_zip.name(), Integer.valueOf(aiAppsDbInfo.isHaveZip));
        }
        if (aiAppsDbInfo.version != null) {
            contentValues.put(AiAppsTable.version.name(), aiAppsDbInfo.version);
        }
        if (aiAppsDbInfo.type >= 0) {
            contentValues.put(AiAppsTable.type.name(), Integer.valueOf(aiAppsDbInfo.type));
        }
        if (aiAppsDbInfo.appOpenUrl != null) {
            contentValues.put(AiAppsTable.app_open_url.name(), aiAppsDbInfo.appOpenUrl);
        }
        if (aiAppsDbInfo.appDownloadUrl != null) {
            contentValues.put(AiAppsTable.app_download_url.name(), aiAppsDbInfo.appDownloadUrl);
        }
        if (aiAppsDbInfo.targetSwanVersion != null) {
            contentValues.put(AiAppsTable.target_swan_version.name(), aiAppsDbInfo.targetSwanVersion);
        }
        contentValues.put(AiAppsTable.app_zip_size.name(), Long.valueOf(aiAppsDbInfo.mAppZipSize));
        contentValues.put(AiAppsTable.pending_aps_errcode.name(), Integer.valueOf(aiAppsDbInfo.mPendingApsErrcode));
        if (aiAppsDbInfo.versionCode != null) {
            contentValues.put(AiAppsTable.version_code.name(), aiAppsDbInfo.versionCode);
        }
        return contentValues;
    }

    /* loaded from: classes2.dex */
    public abstract class SQLiteTransaction {
        private boolean mIsSuccess = false;

        protected abstract boolean performTransaction(SQLiteDatabase sQLiteDatabase);

        public SQLiteTransaction() {
        }

        public void run(SQLiteDatabase sQLiteDatabase) {
            this.mIsSuccess = false;
            try {
                sQLiteDatabase.beginTransaction();
                if (performTransaction(sQLiteDatabase)) {
                    sQLiteDatabase.setTransactionSuccessful();
                    this.mIsSuccess = true;
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                }
                throw th;
            }
        }

        protected boolean isTransactionSuccess() {
            return this.mIsSuccess;
        }
    }
}
