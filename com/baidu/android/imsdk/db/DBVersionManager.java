package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes3.dex */
public class DBVersionManager {
    public static final String TAG = DBVersionManager.class.getCanonicalName();
    private static DBVersionManager mInstance = null;
    private Context mContext;

    /* loaded from: classes3.dex */
    interface VersionHandler {
        void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    private DBVersionManager(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static DBVersionManager getInstance(Context context) {
        synchronized (DBVersionManager.class) {
            if (mInstance == null) {
                mInstance = new DBVersionManager(context);
            }
        }
        return mInstance;
    }

    /* loaded from: classes3.dex */
    public class DefaultHandler implements VersionHandler {
        public DefaultHandler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DBVersionManager.this.createDb(sQLiteDatabase);
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DBVersionManager.this.createDb(sQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDb(SQLiteDatabase sQLiteDatabase) {
        if (dropTable(sQLiteDatabase) < 0) {
            LogUtils.e(TAG, "drop table db failed when db upgrade or downgrade!");
        } else if (createTable(sQLiteDatabase) < 0) {
            LogUtils.e(TAG, "create table db failed when db upgrade or downgrade!");
        }
    }

    private int dropTable(SQLiteDatabase sQLiteDatabase) {
        int i = -1;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS message");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS userinfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chatrecord");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupinfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupmember");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS friendgroup");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS paSubscribe");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS paCmdQueue");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS friendrelation");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS zhida_info");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS dialog_record");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS stat_log");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS liveroom_message");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS duplicate_message");
                Utility.clearCache(this.mContext);
                SyncAllMessage.getInstance(this.mContext).clearCache();
                Utility.writeIntData(this.mContext, Utility.getJumpToRecentKey(this.mContext), 1);
                Utility.writeLongData(this.mContext, Constants.KEY_PA_SUBSCRIBE_SYNC_TIME + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
                i = 0;
                sQLiteDatabase.setTransactionSuccessful();
                LogUtils.d(TAG, "drop table ok");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "dropTable:", e);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
            return i;
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private int createTable(SQLiteDatabase sQLiteDatabase) {
        int i = -1;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MESSAGE);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_USERINFO);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_CHAT_SESSION);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_GROUPINFO);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_GROUP_MEMBER);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_FRIEND_GROUP);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_PA_SUBSCRIBE);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_PA_CMD_QUEUE);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_FRIEND_REALTION);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_ZHIDAINFO);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_DAILOG_RECORD);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_RELIABLE_MESSAGE);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_DUPLICATE_MESSAGE);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_INDEX);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGID_ISEXIST_INDEX);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGKEY_ISEXIST_INDEX);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_STUDIO_USE_PA_MESSAGE);
                i = 0;
                sQLiteDatabase.setTransactionSuccessful();
                LogUtils.d(TAG, "create table ok");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "createTable:", e);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
            return i;
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Version21And22Handler implements VersionHandler {
        public Version21And22Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN msg_key TEXT DEFAULT '' ");
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN sendid TEXT DEFAULT '' ");
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN buid TEXT DEFAULT '' ");
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_DAILOG_RECORD);
                sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN buid LONG  DEFAULT -1");
                sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN disturb INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN blacklist INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN detail TEXT DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN tpl LONG DEFAULT -1");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:21->22", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version22And223Handler implements VersionHandler {
        public Version22And223Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN disturb INTEGER DEFAULT 0");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:22->23", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version23And24Handler implements VersionHandler {
        public Version23And24Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version24And25Handler implements VersionHandler {
        public Version24And25Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pasubtype INTEGER DEFAULT -1 ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:24->25", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version25And26Handler implements VersionHandler {
        public Version25And26Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            LogUtils.d(LogUtils.TAG, "onUpgrade:25->26");
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version26And27Handler implements VersionHandler {
        public Version26And27Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classtype INTEGER DEFAULT 0 ");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classshow INTEGER DEFAULT 0 ");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classtitle TEXT DEFAULT '' ");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classavatar TEXT DEFAULT '' ");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classtype INTEGER DEFAULT 0 ");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classshow INTEGER DEFAULT 0 ");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classtitle TEXT DEFAULT '' ");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classavatar TEXT DEFAULT '' ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:26->27", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version22And23Handler implements VersionHandler {
        public Version22And23Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN disturb INTEGER DEFAULT 0");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:22->23", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3;
        if (i != i2) {
            if (i2 < 21 || i <= 12) {
                new DefaultHandler().onUpgrade(sQLiteDatabase, i, i2);
                return;
            }
            if (i != 21 || i2 < 22) {
                i3 = i;
            } else {
                new Version21And22Handler().onUpgrade(sQLiteDatabase, i, i2);
                i3 = 22;
            }
            if (i3 == 22 && i2 >= 23) {
                new Version22And223Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 23;
            }
            if (i3 == 23 && i2 >= 24) {
                new Version23And24Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 24;
            }
            if (i3 == 24 && i2 >= 25) {
                new Version24And25Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 25;
            }
            if (i3 == 25 && i2 >= 26) {
                new Version25And26Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 26;
            }
            if (i3 == 26 && i2 >= 27) {
                new Version26And27Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 27;
            }
            if (i3 == 28 && i2 >= 29) {
                new Version28And29Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 29;
            }
            if (i3 == 29 && i2 >= 30) {
                new Version29And30Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 30;
            }
            if (i3 == 30 && i2 >= 31) {
                new Version30And31Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 31;
            }
            if (i3 == 31 && i2 >= 32) {
                new Version31And32Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 32;
            }
            if (i3 == 32 && i2 >= 33) {
                new Version32And33Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 33;
            }
            if (i3 == 33 && i2 >= 34) {
                new Version33And34Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 34;
            }
            if (i3 == 34 && i2 >= 35) {
                new Version34And35Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 35;
            }
            if (i3 == 35 && i2 >= 36) {
                new Version35And36Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 36;
            }
            if (i3 == 36 && i2 >= 37) {
                new Version36And37Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 37;
            }
            if (i3 == 37 && i2 >= 38) {
                new Version37And38Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 38;
            }
            if (i3 == 38 && i2 >= 39) {
                new Version38And39Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 39;
            }
            if (i3 == 39 && i2 >= 40) {
                new Version39And40Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 40;
            }
            if (i3 == 40 && i2 >= 41) {
                new Version40And41Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 41;
            }
            if (i3 == 41 && i2 >= 42) {
                new Version41And42Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 42;
            }
            if (i3 == 42 && i2 >= 43) {
                new Version42And43Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 43;
            }
            if (i3 == 43 && i2 >= 44) {
                new Version43And44Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 44;
            }
            if (i3 == 44 && i2 >= 45) {
                new Version44And45Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 45;
            }
            if (i3 == 45 && i2 >= 46) {
                new Version45And46Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 46;
            }
            if (i3 == 46 && i2 >= 47) {
                new Version46And47Handler().onUpgrade(sQLiteDatabase, i3, i2);
                i3 = 47;
            }
            if (i3 <= 48 && i2 >= 49) {
                new Version48And49Handler().onUpgrade(sQLiteDatabase, i3, i2);
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE name='dialog_record' ", null);
                    if (cursor.getCount() == 0) {
                        createDb(sQLiteDatabase);
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "close curse exception");
                        }
                    }
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, "database exception, check table dialog_record exist");
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                            LogUtils.e(TAG, "close curse exception");
                        }
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                        LogUtils.e(TAG, "close curse exception");
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Version48And49Handler implements VersionHandler {
        public Version48And49Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN has_reject_menu INTEGER DEFAULT 0 ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:48->49", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version46And47Handler implements VersionHandler {
        public Version46And47Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version46And47Handler---");
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_STUDIO_USE_PA_MESSAGE);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:46->47", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version45And46Handler implements VersionHandler {
        public Version45And46Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN template_type INTEGER DEFAULT 0 ");
                if (AccountManager.getAppid(DBVersionManager.this.mContext) == 405384) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE, (Integer) 29);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(TableDefine.SessionColumns.COLUMN_CHAT_TYPE, (Integer) 29);
                    if (Constants.getEnv(DBVersionManager.this.mContext) == 0) {
                        sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592194956492L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592195132261L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592194956492L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592195132261L)});
                    } else {
                        sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592186059247L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592186061416L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592186059247L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592186061416L)});
                    }
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:45->46", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version44And45Handler implements VersionHandler {
        public Version44And45Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN user_ext TEXT ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:44->45", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version43And44Handler implements VersionHandler {
        public Version43And44Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN tips_code INTEGER ");
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN tips TEXT ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:43->44", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version42And43Handler implements VersionHandler {
        public Version42And43Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN service_type TEXT ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:42->43", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version41And42Handler implements VersionHandler {
        public Version41And42Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version41And42Handler---");
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo RENAME TO userinfo_temp");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_USERINFO);
                    sQLiteDatabase.execSQL(TableDefine.SQL_COPY_TABLE_USERINFO);
                    sQLiteDatabase.execSQL("DROP TABLE userinfo_temp");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN v_portrait  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN vip_id  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN identity  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN has_identity INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield  INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield_time  LONG DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN third_ext  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN subscribe  INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN v_portrait  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN vip_id  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN certification  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN shield  INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN shield_time  LONG DEFAULT 0 ");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:41->42", e);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                PaManager.delPaLocalInfosByPaType(DBVersionManager.this.mContext, 19);
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version40And41Handler implements VersionHandler {
        public Version40And41Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version40And41Handler---");
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_DUPLICATE_MESSAGE);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:40->41", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version39And40Handler implements VersionHandler {
        public Version39And40Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_ext  TEXT ");
                LogUtils.d(DBVersionManager.TAG, "Version39And40Handler add pa_ext");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:39->40", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version38And39Handler implements VersionHandler {
        public Version38And39Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGID_ISEXIST_INDEX);
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGKEY_ISEXIST_INDEX);
                LogUtils.d(DBVersionManager.TAG, "Version38And39Handler create msg index ok");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:38->39", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version37And38Handler implements VersionHandler {
        public Version37And38Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_INDEX);
                LogUtils.d(DBVersionManager.TAG, "Version37And38Handler create msg index ok");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:37->38", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version35And36Handler implements VersionHandler {
        public Version35And36Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version35And36Handler---");
                sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_RELIABLE_MESSAGE);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:35->36", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version36And37Handler implements VersionHandler {
        public Version36And37Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version36And37Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN extra TEXT ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:36->37", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version34And35Handler implements VersionHandler {
        public Version34And35Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version34And35Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN expires_time  LONG DEFAULT 0  ");
                ChatMessageDBManager.getInstance(DBVersionManager.this.mContext).delChatRecordForChatType(6);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:34->35", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version33And34Handler implements VersionHandler {
        public Version33And34Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version33And34Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN subset_type  INTEGER DEFAULT 0  ");
                PaManager.delPaLocalInfosByPaType(DBVersionManager.this.mContext, 16);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:33->34", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version32And33Handler implements VersionHandler {
        public Version32And33Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version32And33Handler---");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:32->33", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version31And32Handler implements VersionHandler {
        public Version31And32Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version31And32Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN replies TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN refreshtime LONG DEFAULT 0 ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:31->32", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version30And31Handler implements VersionHandler {
        public Version30And31Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version30And31Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN nickname TEXT ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:30->31", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version29And30Handler implements VersionHandler {
        public Version29And30Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version29And30Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN marktop INTEGER DEFAULT 0 ");
                sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN marktoptime LONG ");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN marktop INTEGER DEFAULT 0 ");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN marktoptime LONG ");
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:29->30", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class Version28And29Handler implements VersionHandler {
        public Version28And29Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                LogUtils.d(DBVersionManager.TAG, "---Version28And29Handler---");
                sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN status INTEGER DEFAULT 0");
                PaManager.delPaLocalInfosByPaType(DBVersionManager.this.mContext, 5);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(DBVersionManager.this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "onUpgrade:28->29", e);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            if (i == 22 && i2 <= 21) {
                new Version21And22Handler().onDowngrade(sQLiteDatabase, i, i2);
                i = 21;
            }
            if (i == 21 && i2 <= 20) {
                new DefaultHandler().onDowngrade(sQLiteDatabase, i, i2);
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createDb(sQLiteDatabase);
    }
}
