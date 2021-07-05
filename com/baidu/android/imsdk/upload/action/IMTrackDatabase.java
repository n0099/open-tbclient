package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.track.Ack;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Crash;
import com.baidu.android.imsdk.upload.action.track.Db;
import com.baidu.android.imsdk.upload.action.track.Msg;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.upload.action.track.Ui;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class IMTrackDatabase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_NAME = "im_track.db";
    public static final int DB_VERSION = 1;
    public static final int MAX_QUERY_COUNT = 1000;
    public static String TAG = "IMTrackDatabase";
    public static DbOpenHelper dbOpenHelper;
    @SuppressLint({"StaticFieldLeak"})
    public static IMTrackDatabase instance;
    public static final Object myLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class AckEnum {
        public static final /* synthetic */ AckEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "ack";
        public static final AckEnum ackId;
        public static final AckEnum aliasId;
        public static final AckEnum ext;
        public static final AckEnum timestamp;
        public static final AckEnum type;
        public static final AckEnum value;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1265264987, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$AckEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1265264987, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$AckEnum;");
                    return;
                }
            }
            ackId = new AckEnum("ackId", 0);
            type = new AckEnum("type", 1);
            value = new AckEnum("value", 2);
            timestamp = new AckEnum("timestamp", 3);
            ext = new AckEnum("ext", 4);
            AckEnum ackEnum = new AckEnum("aliasId", 5);
            aliasId = ackEnum;
            $VALUES = new AckEnum[]{ackId, type, value, timestamp, ext, ackEnum};
        }

        public AckEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AckEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AckEnum) Enum.valueOf(AckEnum.class, str) : (AckEnum) invokeL.objValue;
        }

        public static AckEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AckEnum[]) $VALUES.clone() : (AckEnum[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ConnectionEnum {
        public static final /* synthetic */ ConnectionEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "connection";
        public static final ConnectionEnum aliasId;
        public static final ConnectionEnum connectionId;
        public static final ConnectionEnum ext;
        public static final ConnectionEnum reason;
        public static final ConnectionEnum retryCount;
        public static final ConnectionEnum retryTime;
        public static final ConnectionEnum startTime;
        public static final ConnectionEnum stopTime;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(502934088, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$ConnectionEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(502934088, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$ConnectionEnum;");
                    return;
                }
            }
            connectionId = new ConnectionEnum("connectionId", 0);
            startTime = new ConnectionEnum("startTime", 1);
            stopTime = new ConnectionEnum("stopTime", 2);
            reason = new ConnectionEnum("reason", 3);
            retryTime = new ConnectionEnum("retryTime", 4);
            retryCount = new ConnectionEnum("retryCount", 5);
            ext = new ConnectionEnum("ext", 6);
            ConnectionEnum connectionEnum = new ConnectionEnum("aliasId", 7);
            aliasId = connectionEnum;
            $VALUES = new ConnectionEnum[]{connectionId, startTime, stopTime, reason, retryTime, retryCount, ext, connectionEnum};
        }

        public ConnectionEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ConnectionEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ConnectionEnum) Enum.valueOf(ConnectionEnum.class, str) : (ConnectionEnum) invokeL.objValue;
        }

        public static ConnectionEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ConnectionEnum[]) $VALUES.clone() : (ConnectionEnum[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class CrashEnum {
        public static final /* synthetic */ CrashEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "crash";
        public static final CrashEnum aliasId;
        public static final CrashEnum crashId;
        public static final CrashEnum exception;
        public static final CrashEnum ext;
        public static final CrashEnum timestamp;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-472733369, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$CrashEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-472733369, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$CrashEnum;");
                    return;
                }
            }
            crashId = new CrashEnum("crashId", 0);
            exception = new CrashEnum("exception", 1);
            timestamp = new CrashEnum("timestamp", 2);
            ext = new CrashEnum("ext", 3);
            CrashEnum crashEnum = new CrashEnum("aliasId", 4);
            aliasId = crashEnum;
            $VALUES = new CrashEnum[]{crashId, exception, timestamp, ext, crashEnum};
        }

        public CrashEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CrashEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CrashEnum) Enum.valueOf(CrashEnum.class, str) : (CrashEnum) invokeL.objValue;
        }

        public static CrashEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CrashEnum[]) $VALUES.clone() : (CrashEnum[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class DbEnum {
        public static final /* synthetic */ DbEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "db";
        public static final DbEnum action;
        public static final DbEnum aliasId;
        public static final DbEnum className;
        public static final DbEnum dbId;
        public static final DbEnum duration;
        public static final DbEnum endTime;
        public static final DbEnum ext;
        public static final DbEnum method;
        public static final DbEnum startTime;
        public static final DbEnum tableName;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2005011624, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$DbEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2005011624, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$DbEnum;");
                    return;
                }
            }
            dbId = new DbEnum("dbId", 0);
            tableName = new DbEnum("tableName", 1);
            className = new DbEnum(PushClientConstants.TAG_CLASS_NAME, 2);
            method = new DbEnum("method", 3);
            action = new DbEnum("action", 4);
            startTime = new DbEnum("startTime", 5);
            endTime = new DbEnum("endTime", 6);
            duration = new DbEnum("duration", 7);
            ext = new DbEnum("ext", 8);
            DbEnum dbEnum = new DbEnum("aliasId", 9);
            aliasId = dbEnum;
            $VALUES = new DbEnum[]{dbId, tableName, className, method, action, startTime, endTime, duration, ext, dbEnum};
        }

        public DbEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DbEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DbEnum) Enum.valueOf(DbEnum.class, str) : (DbEnum) invokeL.objValue;
        }

        public static DbEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DbEnum[]) $VALUES.clone() : (DbEnum[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final String SQL_TABLE_CREATE_ACK;
        public static final String SQL_TABLE_CREATE_CONNECTION;
        public static final String SQL_TABLE_CREATE_CRASH;
        public static final String SQL_TABLE_CREATE_DB;
        public static final String SQL_TABLE_CREATE_MESSAGE;
        public static final String SQL_TABLE_CREATE_REQUEST;
        public static final String SQL_TABLE_CREATE_UI;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(254599025, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$DbOpenHelper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(254599025, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$DbOpenHelper;");
                    return;
                }
            }
            SQL_TABLE_CREATE_UI = "CREATE TABLE ui (" + UiEnum.uiId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UiEnum.category.name() + " TEXT, " + UiEnum.page.name() + " TEXT, " + UiEnum.startTime.name() + " LONG, " + UiEnum.endTime.name() + " LONG, " + UiEnum.duration.name() + " LONG, " + UiEnum.ext.name() + " TEXT, " + UiEnum.aliasId.name() + " LONG NOT NULL );";
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE crash (");
            sb.append(CrashEnum.crashId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(CrashEnum.exception.name());
            sb.append(" TEXT, ");
            sb.append(CrashEnum.timestamp.name());
            sb.append(" LONG, ");
            sb.append(CrashEnum.ext.name());
            sb.append(" TEXT, ");
            sb.append(CrashEnum.aliasId.name());
            sb.append(" LONG NOT NULL );");
            SQL_TABLE_CREATE_CRASH = sb.toString();
            SQL_TABLE_CREATE_DB = "CREATE TABLE db (" + DbEnum.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DbEnum.tableName.name() + " TEXT, " + DbEnum.className.name() + " TEXT, " + DbEnum.method.name() + " TEXT, " + DbEnum.action.name() + " TEXT, " + DbEnum.startTime.name() + " LONG, " + DbEnum.endTime.name() + " LONG, " + DbEnum.duration.name() + " LONG, " + DbEnum.ext.name() + " TEXT, " + DbEnum.aliasId.name() + " LONG NOT NULL );";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE connection (");
            sb2.append(ConnectionEnum.connectionId.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(ConnectionEnum.startTime.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.stopTime.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.reason.name());
            sb2.append(" TEXT, ");
            sb2.append(ConnectionEnum.retryTime.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.retryCount.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.ext.name());
            sb2.append(" TEXT, ");
            sb2.append(ConnectionEnum.aliasId.name());
            sb2.append(" LONG NOT NULL );");
            SQL_TABLE_CREATE_CONNECTION = sb2.toString();
            SQL_TABLE_CREATE_REQUEST = "CREATE TABLE request (" + RequestEnum.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RequestEnum.method.name() + " TEXT, " + RequestEnum.requestId.name() + " TEXT, " + RequestEnum.timestamp.name() + " LONG, " + RequestEnum.responseTime.name() + " LONG, " + RequestEnum.errorCode.name() + " LONG, " + RequestEnum.ext.name() + " TEXT, " + RequestEnum.aliasId.name() + " LONG NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE ack (");
            sb3.append(AckEnum.ackId.name());
            sb3.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb3.append(AckEnum.type.name());
            sb3.append(" TEXT, ");
            sb3.append(AckEnum.value.name());
            sb3.append(" TEXT, ");
            sb3.append(AckEnum.timestamp.name());
            sb3.append(" LONG, ");
            sb3.append(AckEnum.ext.name());
            sb3.append(" TEXT, ");
            sb3.append(AckEnum.aliasId.name());
            sb3.append(" LONG NOT NULL);");
            SQL_TABLE_CREATE_ACK = sb3.toString();
            SQL_TABLE_CREATE_MESSAGE = "CREATE TABLE msg (" + MsgEnum.msgId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MsgEnum.msgCount.name() + " LONG, " + MsgEnum.roomId.name() + " TEXT, " + MsgEnum.duration.name() + " LONG, " + MsgEnum.startMsgId.name() + " LONG, " + MsgEnum.endMsgId.name() + " LONG, " + MsgEnum.ext.name() + " TEXT, " + MsgEnum.aliasId.name() + " LONG NOT NULL);";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DbOpenHelper(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2), databaseErrorHandler};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ui");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS connection");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS db");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
                } catch (Exception e2) {
                    String str = IMTrackDatabase.TAG;
                    LogUtils.d(str, "dropTables Exception: " + e2);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_UI);
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_CRASH);
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_DB);
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_CONNECTION);
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_REQUEST);
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_ACK);
                    sQLiteDatabase.execSQL(SQL_TABLE_CREATE_MESSAGE);
                } catch (Exception e2) {
                    String str = IMTrackDatabase.TAG;
                    LogUtils.d(str, "DbOpenHelper onCreate E: " + e2);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                dropTables(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DbOpenHelper(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.context = context;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class MsgEnum {
        public static final /* synthetic */ MsgEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "msg";
        public static final MsgEnum aliasId;
        public static final MsgEnum duration;
        public static final MsgEnum endMsgId;
        public static final MsgEnum ext;
        public static final MsgEnum msgCount;
        public static final MsgEnum msgId;
        public static final MsgEnum roomId;
        public static final MsgEnum startMsgId;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-625737043, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$MsgEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-625737043, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$MsgEnum;");
                    return;
                }
            }
            msgId = new MsgEnum("msgId", 0);
            msgCount = new MsgEnum("msgCount", 1);
            roomId = new MsgEnum(ILiveNPSPlugin.PARAMS_ROOM_ID, 2);
            duration = new MsgEnum("duration", 3);
            startMsgId = new MsgEnum("startMsgId", 4);
            endMsgId = new MsgEnum("endMsgId", 5);
            ext = new MsgEnum("ext", 6);
            MsgEnum msgEnum = new MsgEnum("aliasId", 7);
            aliasId = msgEnum;
            $VALUES = new MsgEnum[]{msgId, msgCount, roomId, duration, startMsgId, endMsgId, ext, msgEnum};
        }

        public MsgEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MsgEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MsgEnum) Enum.valueOf(MsgEnum.class, str) : (MsgEnum) invokeL.objValue;
        }

        public static MsgEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MsgEnum[]) $VALUES.clone() : (MsgEnum[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class RequestEnum {
        public static final /* synthetic */ RequestEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "request";
        public static final RequestEnum aliasId;
        public static final RequestEnum errorCode;
        public static final RequestEnum ext;
        public static final RequestEnum id;
        public static final RequestEnum method;
        public static final RequestEnum requestId;
        public static final RequestEnum responseTime;
        public static final RequestEnum timestamp;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-603052449, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$RequestEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-603052449, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$RequestEnum;");
                    return;
                }
            }
            id = new RequestEnum("id", 0);
            method = new RequestEnum("method", 1);
            requestId = new RequestEnum("requestId", 2);
            timestamp = new RequestEnum("timestamp", 3);
            responseTime = new RequestEnum("responseTime", 4);
            errorCode = new RequestEnum("errorCode", 5);
            ext = new RequestEnum("ext", 6);
            RequestEnum requestEnum = new RequestEnum("aliasId", 7);
            aliasId = requestEnum;
            $VALUES = new RequestEnum[]{id, method, requestId, timestamp, responseTime, errorCode, ext, requestEnum};
        }

        public RequestEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RequestEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RequestEnum) Enum.valueOf(RequestEnum.class, str) : (RequestEnum) invokeL.objValue;
        }

        public static RequestEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RequestEnum[]) $VALUES.clone() : (RequestEnum[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class UiEnum {
        public static final /* synthetic */ UiEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TABLE_NAME = "ui";
        public static final UiEnum aliasId;
        public static final UiEnum category;
        public static final UiEnum duration;
        public static final UiEnum endTime;
        public static final UiEnum ext;
        public static final UiEnum page;
        public static final UiEnum startTime;
        public static final UiEnum uiId;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(113109074, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$UiEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(113109074, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase$UiEnum;");
                    return;
                }
            }
            uiId = new UiEnum("uiId", 0);
            category = new UiEnum("category", 1);
            page = new UiEnum("page", 2);
            startTime = new UiEnum("startTime", 3);
            endTime = new UiEnum("endTime", 4);
            duration = new UiEnum("duration", 5);
            ext = new UiEnum("ext", 6);
            UiEnum uiEnum = new UiEnum("aliasId", 7);
            aliasId = uiEnum;
            $VALUES = new UiEnum[]{uiId, category, page, startTime, endTime, duration, ext, uiEnum};
        }

        public UiEnum(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static UiEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UiEnum) Enum.valueOf(UiEnum.class, str) : (UiEnum) invokeL.objValue;
        }

        public static UiEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UiEnum[]) $VALUES.clone() : (UiEnum[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1906764213, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1906764213, "Lcom/baidu/android/imsdk/upload/action/IMTrackDatabase;");
                return;
            }
        }
        myLock = new Object();
    }

    public IMTrackDatabase(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
    }

    @Nullable
    private void checkDadabaseMaxCount(SQLiteDatabase sQLiteDatabase, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, this, sQLiteDatabase, str) != null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select count(*) from " + str, null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst() && rawQuery.getInt(0) > 1000) {
                            sQLiteDatabase.delete(str, null, null);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = rawQuery;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.close();
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.close();
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e3) {
                e = e3;
            }
            sQLiteDatabase.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static SQLiteDatabase getDb(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            if (dbOpenHelper == null) {
                dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
            }
            try {
                return dbOpenHelper.getWritableDatabase();
            } catch (Throwable th) {
                LogUtils.e(TAG, "getDb Exception: ", th);
                return null;
            }
        }
        return (SQLiteDatabase) invokeL.objValue;
    }

    public static IMTrackDatabase getInstance(Context context) {
        InterceptResult invokeL;
        IMTrackDatabase iMTrackDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            synchronized (myLock) {
                if (instance == null) {
                    instance = new IMTrackDatabase(context.getApplicationContext());
                }
                iMTrackDatabase = instance;
            }
            return iMTrackDatabase;
        }
        return (IMTrackDatabase) invokeL.objValue;
    }

    public void clearAllTables() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    db.delete(UiEnum.TABLE_NAME, null, null);
                    db.delete("crash", null, null);
                    db.delete(DbEnum.TABLE_NAME, null, null);
                    db.delete("connection", null, null);
                    db.delete("request", null, null);
                    db.delete(AckEnum.TABLE_NAME, null, null);
                    db.delete("msg", null, null);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack clearAllTables Exception: " + e2);
                }
                db.close();
            }
        }
    }

    public void clearCrashTable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    db.delete("crash", null, null);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack clearCrashTable Exception: " + e2);
                }
                db.close();
            }
        }
    }

    public List<Ack> getAcks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from ack limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Ack ack = new Ack();
                        ack.type = cursor.getString(cursor.getColumnIndex(AckEnum.type.name()));
                        ack.value = cursor.getString(cursor.getColumnIndex(AckEnum.value.name()));
                        ack.timestamp = cursor.getLong(cursor.getColumnIndex(AckEnum.timestamp.name()));
                        ack.ext = cursor.getString(cursor.getColumnIndex(AckEnum.ext.name()));
                        ack.aliasId = cursor.getLong(cursor.getColumnIndex(AckEnum.aliasId.name()));
                        arrayList.add(ack);
                    }
                    checkDadabaseMaxCount(db, AckEnum.TABLE_NAME);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getAcks error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public long getConnectionCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (myLock) {
                long j = 0;
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return 0L;
                }
                Cursor cursor = null;
                try {
                    cursor = db.rawQuery("select count(*) from connection", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return j;
            }
        }
        return invokeV.longValue;
    }

    public List<Connection> getConnections() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from connection limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Connection connection = new Connection();
                        connection.startTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.startTime.name()));
                        connection.stopTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.stopTime.name()));
                        connection.reason = cursor.getString(cursor.getColumnIndex(ConnectionEnum.reason.name()));
                        connection.retryTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.retryTime.name()));
                        connection.retryCount = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.retryCount.name()));
                        connection.ext = cursor.getString(cursor.getColumnIndex(ConnectionEnum.ext.name()));
                        connection.aliasId = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.aliasId.name()));
                        arrayList.add(connection);
                    }
                    checkDadabaseMaxCount(db, "connection");
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getConnections error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public long getCrashCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (myLock) {
                long j = 0;
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return 0L;
                }
                Cursor cursor = null;
                try {
                    cursor = db.rawQuery("select count(*) from crash", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return j;
            }
        }
        return invokeV.longValue;
    }

    public List<Crash> getCrashes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from crash limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Crash crash = new Crash();
                        crash.exception = cursor.getString(cursor.getColumnIndex(CrashEnum.exception.name()));
                        crash.timestamp = cursor.getLong(cursor.getColumnIndex(CrashEnum.timestamp.name()));
                        crash.ext = cursor.getString(cursor.getColumnIndex(CrashEnum.ext.name()));
                        crash.aliasId = cursor.getLong(cursor.getColumnIndex(CrashEnum.aliasId.name()));
                        arrayList.add(crash);
                    }
                    checkDadabaseMaxCount(db, "crash");
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getCrashes error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<Db> getDbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from db limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Db db2 = new Db();
                        db2.table = cursor.getString(cursor.getColumnIndex(DbEnum.tableName.name()));
                        db2.className = cursor.getString(cursor.getColumnIndex(DbEnum.className.name()));
                        db2.method = cursor.getString(cursor.getColumnIndex(DbEnum.method.name()));
                        db2.action = cursor.getString(cursor.getColumnIndex(DbEnum.action.name()));
                        db2.startTime = cursor.getLong(cursor.getColumnIndex(DbEnum.startTime.name()));
                        db2.endTime = cursor.getLong(cursor.getColumnIndex(DbEnum.endTime.name()));
                        db2.duration = cursor.getLong(cursor.getColumnIndex(DbEnum.duration.name()));
                        db2.ext = cursor.getString(cursor.getColumnIndex(DbEnum.ext.name()));
                        db2.aliasId = cursor.getLong(cursor.getColumnIndex(DbEnum.aliasId.name()));
                        arrayList.add(db2);
                    }
                    checkDadabaseMaxCount(db, DbEnum.TABLE_NAME);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getDbs error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<Msg> getMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from msg limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Msg msg = new Msg();
                        msg.msgCount = cursor.getLong(cursor.getColumnIndex(MsgEnum.msgCount.name()));
                        msg.roomId = cursor.getString(cursor.getColumnIndex(MsgEnum.roomId.name()));
                        msg.duration = cursor.getLong(cursor.getColumnIndex(MsgEnum.duration.name()));
                        msg.startMsgId = cursor.getLong(cursor.getColumnIndex(MsgEnum.startMsgId.name()));
                        msg.endMsgId = cursor.getLong(cursor.getColumnIndex(MsgEnum.endMsgId.name()));
                        msg.ext = cursor.getString(cursor.getColumnIndex(MsgEnum.ext.name()));
                        msg.aliasId = cursor.getLong(cursor.getColumnIndex(MsgEnum.aliasId.name()));
                        arrayList.add(msg);
                    }
                    checkDadabaseMaxCount(db, "msg");
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getMsgs error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public long getRequestCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (myLock) {
                long j = 0;
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return 0L;
                }
                Cursor cursor = null;
                try {
                    cursor = db.rawQuery("select count(*) from request", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return j;
            }
        }
        return invokeV.longValue;
    }

    public List<Request> getRequests() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from request limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Request request = new Request();
                        request.method = cursor.getString(cursor.getColumnIndex(RequestEnum.method.name()));
                        request.requestId = cursor.getString(cursor.getColumnIndex(RequestEnum.requestId.name()));
                        request.timestamp = cursor.getLong(cursor.getColumnIndex(RequestEnum.timestamp.name()));
                        request.responseTime = cursor.getLong(cursor.getColumnIndex(RequestEnum.responseTime.name()));
                        request.errorCode = cursor.getLong(cursor.getColumnIndex(RequestEnum.errorCode.name()));
                        request.ext = cursor.getString(cursor.getColumnIndex(RequestEnum.ext.name()));
                        request.aliasId = cursor.getLong(cursor.getColumnIndex(RequestEnum.aliasId.name()));
                        arrayList.add(request);
                    }
                    checkDadabaseMaxCount(db, "request");
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getRequests error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<Ui> getUis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                Cursor cursor = null;
                if (db == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    cursor = db.rawQuery("select * from ui limit 1000", null);
                    while (cursor != null && cursor.moveToNext()) {
                        Ui ui = new Ui();
                        ui.category = cursor.getString(cursor.getColumnIndex(UiEnum.category.name()));
                        ui.page = cursor.getString(cursor.getColumnIndex(UiEnum.page.name()));
                        ui.startTime = cursor.getLong(cursor.getColumnIndex(UiEnum.startTime.name()));
                        ui.endTime = cursor.getLong(cursor.getColumnIndex(UiEnum.endTime.name()));
                        ui.duration = cursor.getLong(cursor.getColumnIndex(UiEnum.duration.name()));
                        ui.ext = cursor.getString(cursor.getColumnIndex(UiEnum.ext.name()));
                        ui.aliasId = cursor.getLong(cursor.getColumnIndex(UiEnum.aliasId.name()));
                        arrayList.add(ui);
                    }
                    checkDadabaseMaxCount(db, UiEnum.TABLE_NAME);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack getUis error " + e2.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                db.close();
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public void insertAck(Ack ack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ack) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AckEnum.type.name(), ack.type);
                    contentValues.put(AckEnum.value.name(), ack.value);
                    contentValues.put(AckEnum.timestamp.name(), Long.valueOf(ack.timestamp));
                    contentValues.put(AckEnum.ext.name(), ack.ext);
                    contentValues.put(AckEnum.aliasId.name(), Long.valueOf(ack.aliasId));
                    db.insert(AckEnum.TABLE_NAME, null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert Ack exception : " + e2);
                }
                db.close();
            }
        }
    }

    public void insertConnection(Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, connection) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ConnectionEnum.startTime.name(), Long.valueOf(connection.startTime));
                    contentValues.put(ConnectionEnum.stopTime.name(), Long.valueOf(connection.stopTime));
                    contentValues.put(ConnectionEnum.reason.name(), connection.reason);
                    contentValues.put(ConnectionEnum.retryTime.name(), Long.valueOf(connection.retryTime));
                    contentValues.put(ConnectionEnum.retryCount.name(), Long.valueOf(connection.retryCount));
                    contentValues.put(ConnectionEnum.ext.name(), connection.ext);
                    contentValues.put(ConnectionEnum.aliasId.name(), Long.valueOf(connection.aliasId));
                    db.insert("connection", null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert Connection exception : " + e2);
                }
                db.close();
            }
        }
    }

    public void insertCrash(Crash crash) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, crash) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(CrashEnum.exception.name(), crash.exception);
                    contentValues.put(CrashEnum.timestamp.name(), Long.valueOf(crash.timestamp));
                    contentValues.put(CrashEnum.ext.name(), crash.ext);
                    contentValues.put(CrashEnum.aliasId.name(), Long.valueOf(crash.aliasId));
                    db.insert("crash", null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert Crash exception : " + e2);
                }
                db.close();
            }
        }
    }

    public void insertDb(Db db) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, db) == null) {
            synchronized (myLock) {
                SQLiteDatabase db2 = getDb(this.context);
                if (db2 == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DbEnum.tableName.name(), db.table);
                    contentValues.put(DbEnum.className.name(), db.className);
                    contentValues.put(DbEnum.method.name(), db.method);
                    contentValues.put(DbEnum.action.name(), db.action);
                    contentValues.put(DbEnum.startTime.name(), Long.valueOf(db.startTime));
                    contentValues.put(DbEnum.endTime.name(), Long.valueOf(db.endTime));
                    contentValues.put(DbEnum.duration.name(), Long.valueOf(db.duration));
                    contentValues.put(DbEnum.ext.name(), db.ext);
                    contentValues.put(DbEnum.aliasId.name(), Long.valueOf(db.aliasId));
                    db2.insert(DbEnum.TABLE_NAME, null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert Db exception : " + e2);
                }
                db2.close();
            }
        }
    }

    public void insertMsg(Msg msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, msg) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MsgEnum.msgCount.name(), Long.valueOf(msg.msgCount));
                    contentValues.put(MsgEnum.roomId.name(), msg.roomId);
                    contentValues.put(MsgEnum.duration.name(), Long.valueOf(msg.duration));
                    contentValues.put(MsgEnum.startMsgId.name(), Long.valueOf(msg.startMsgId));
                    contentValues.put(MsgEnum.endMsgId.name(), Long.valueOf(msg.endMsgId));
                    contentValues.put(MsgEnum.ext.name(), msg.ext);
                    contentValues.put(MsgEnum.aliasId.name(), Long.valueOf(msg.aliasId));
                    db.insert("msg", null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert Ack exception : " + e2);
                }
                db.close();
            }
        }
    }

    public void insertRequest(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, request) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(RequestEnum.method.name(), request.method);
                    contentValues.put(RequestEnum.requestId.name(), request.requestId);
                    contentValues.put(RequestEnum.timestamp.name(), Long.valueOf(request.timestamp));
                    contentValues.put(RequestEnum.responseTime.name(), Long.valueOf(request.responseTime));
                    contentValues.put(RequestEnum.errorCode.name(), Long.valueOf(request.errorCode));
                    contentValues.put(RequestEnum.ext.name(), request.ext);
                    contentValues.put(RequestEnum.aliasId.name(), Long.valueOf(request.aliasId));
                    db.insert("request", null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert Request exception : " + e2);
                }
                db.close();
            }
        }
    }

    public void insertUi(Ui ui) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ui) == null) {
            synchronized (myLock) {
                SQLiteDatabase db = getDb(this.context);
                if (db == null) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(UiEnum.category.name(), ui.category);
                    contentValues.put(UiEnum.page.name(), ui.page);
                    contentValues.put(UiEnum.startTime.name(), Long.valueOf(ui.startTime));
                    contentValues.put(UiEnum.endTime.name(), Long.valueOf(ui.endTime));
                    contentValues.put(UiEnum.duration.name(), Long.valueOf(ui.duration));
                    contentValues.put(UiEnum.ext.name(), ui.ext);
                    contentValues.put(UiEnum.aliasId.name(), Long.valueOf(ui.aliasId));
                    db.insert(UiEnum.TABLE_NAME, null, contentValues);
                } catch (Exception e2) {
                    String str = TAG;
                    LogUtils.e(str, "IMTrack insert ui exception : " + e2);
                }
                db.close();
            }
        }
    }
}
