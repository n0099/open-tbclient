package com.baidu.android.imsdk.db;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.DBVersionManager;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes.dex */
public class DBConnection extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBConnection";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i, i2) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class Version27And28Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version27And28Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupmember", "nickname")) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN nickname TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:27->28", e);
                }
                Log.d(LogUtils.TAG, "DBConnection onUpgrade:27->28");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version47And48Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version47And48Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", "marktop")) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN marktop INTEGER DEFAULT 1");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", "marktoptime")) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN marktoptime LONG ");
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:27->28", e);
                }
                Log.d(LogUtils.TAG, "DBConnection onUpgrade:27->28");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version49And50Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version49And50Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_notice TEXT");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_desc TEXT");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN local_members_version LONG DEFAULT '0'");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_VERSION)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN groupinfo_version LONG DEFAULT '0'");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_LOCAL_VERSION)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN local_groupinfo_version LONG DEFAULT '0'");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupmember", "avatar")) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN avatar TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:49->50", e);
                }
                Log.d(LogUtils.TAG, "DBConnection onUpgrade:49->50");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version54And55Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version54And55Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SUB_TYPE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_sub_type INTEGER DEFAULT '0'");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SETTING_INFO)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_setting_info TEXT");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupmember", DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DISPLAY_NAME)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN role_display_name TEXT");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupmember", DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DECORATION)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN role_decoration TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:54->55", e);
                }
                LogUtils.d(LogUtils.TAG, "DBConnection onUpgrade:54->55");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version58And59Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version58And59Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version58And59Handler---");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("disturb", (Integer) 0);
                    sQLiteDatabase.update("groupinfo", contentValues, null, null);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("disturb", (Integer) 1);
                    sQLiteDatabase.update("groupinfo", contentValues2, "group_type = ? OR (group_type = ? AND group_sub_type = ? )", new String[]{String.valueOf(1), String.valueOf(3), String.valueOf(0)});
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "onUpgrade:58->59", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version66And67Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version66And67Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version66And67Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN homepage TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:59->60", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version68And69Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version68And69Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version68And69Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupmember", DBTableDefine.GroupMemberColumns.COLUMN_AVATAR_EXT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN avatar_ext TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:67->68", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version71And72Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version71And72Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version71And72Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_ADMIN_SIZE_LIMIT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN max_admin_size INTEGER DEFAULT '0'");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBConnection.TAG, "DBConnection onUpgrade:71->72", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version72And73Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version72And73Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version72And73Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_AUDIT_STATE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_audit_state INTEGER DEFAULT '0'");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBConnection.TAG, "DBConnection onUpgrade:72->73", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version73And74Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version73And74Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version73And74Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HAS_NOTICE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_has_notice INTEGER DEFAULT '0'");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE_EXT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_notice_ext TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBConnection.TAG, "DBConnection onUpgrade:73->74", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version75And76Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version75And76Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version75And76Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "groupinfo", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_WELCOME_JSON_TEXT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_welcome_json_text TEXT");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBConnection.TAG, "DBConnection onUpgrade:75->76", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version78And79Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version78And79Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBConnection.TAG, "---Version78And79Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, "auto_risk_control_status")) {
                        sQLiteDatabase.execSQL("ALTER TABLE grouplocalmessage ADD COLUMN auto_risk_control_status  INTEGER DEFAULT '0'");
                    }
                    Iterator<String> it = GroupMessageDAOImpl.getExistGroupTableNames(sQLiteDatabase).iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        LogUtils.d(DBConnection.TAG, "update group message table name:" + next);
                        if (!TextUtils.isEmpty(next) && !this.this$0.checkColumnExists(sQLiteDatabase, next, "auto_risk_control_status")) {
                            LogUtils.d(DBConnection.TAG, "update group message table");
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD COLUMN auto_risk_control_status  INTEGER DEFAULT '0'");
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(DBConnection.TAG, "DBConnection onUpgrade:78>79", e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBConnection(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (r2.isClosed() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkColumnExists(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, sQLiteDatabase, str, str2)) == null) {
            boolean z = false;
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where name = ? and sql like ?", new String[]{str, "%" + str2 + "%"});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            z = true;
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "checkColumnExists..." + e.getMessage());
                    if (cursor != null) {
                    }
                }
                return z;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    private void createDb(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, sQLiteDatabase) == null) {
            if (dropTable(sQLiteDatabase) < 0) {
                LogUtils.d(TAG, "drop table db failed when db upgrade or downgrade!");
            } else if (createTable(sQLiteDatabase) < 0) {
                LogUtils.d(TAG, "create table db failed when db upgrade or downgrade!");
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            createDb(sQLiteDatabase);
        }
    }

    private int createTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, sQLiteDatabase)) == null) {
            int i = -1;
            if (sQLiteDatabase != null) {
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_LOCALMESSAGE);
                        sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_GROUPINFO);
                        sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_GROUP_MEMBER);
                        i = 0;
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception e) {
                        LogUtils.e(LogUtils.TAG, "createTable:", e);
                    }
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    private int dropTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, sQLiteDatabase)) == null) {
            int i = -1;
            if (sQLiteDatabase != null) {
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS grouplocalmessage");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupinfo");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupmember");
                        i = 0;
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception e) {
                        LogUtils.e(LogUtils.TAG, "dropTable:", e);
                    }
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            super.onConfigure(sQLiteDatabase);
            if (Build.VERSION.SDK_INT > 10) {
                try {
                    boolean enableWriteAheadLogging = sQLiteDatabase.enableWriteAheadLogging();
                    LogUtils.d(TAG, "enableWAL : " + enableWriteAheadLogging);
                } catch (Exception e) {
                    LogUtils.e(TAG, "onConfigure", e);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i, i2) == null) {
            if (i <= 27 && i2 >= 28) {
                new Version27And28Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 28;
            }
            if (i <= 47 && i2 >= 48) {
                new Version47And48Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 48;
            }
            if (i <= 49 && i2 >= 50) {
                new Version49And50Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 50;
            }
            if (i <= 54 && i2 >= 55) {
                new Version54And55Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 55;
            }
            if (i <= 58 && i2 >= 59) {
                new Version58And59Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 59;
            }
            if (i <= 66 && i2 >= 67) {
                new Version66And67Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 67;
            }
            if (i <= 68 && i2 >= 69) {
                new Version68And69Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 69;
            }
            if (i <= 71 && i2 >= 72) {
                new Version71And72Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 72;
            }
            if (i <= 72 && i2 >= 73) {
                new Version72And73Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 73;
            }
            if (i <= 73 && i2 >= 74) {
                new Version73And74Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 74;
            }
            if (i <= 75 && i2 >= 76) {
                new Version75And76Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 76;
            }
            if (i <= 78 && i2 >= 79) {
                new Version78And79Handler(this).onUpgrade(sQLiteDatabase, i, i2);
            }
        }
    }
}
