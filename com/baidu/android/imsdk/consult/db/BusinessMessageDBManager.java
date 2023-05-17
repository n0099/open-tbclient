package com.baidu.android.imsdk.consult.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.AdvAdBtnShowInfo;
import com.baidu.android.imsdk.chatmessage.ChatAdvCustomMsg;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.consult.listener.IBusiSessionChangeListener;
import com.baidu.android.imsdk.consult.listener.IBusinessSessionUnReadListener;
import com.baidu.android.imsdk.db.CursorWrapper;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class BusinessMessageDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSINESS_ADV_AD_BTN_SHOW_REPLACE_SQL = "REPLACE INTO advisory_ad_btn_show(uk,has_clicked_today,last_show_time,show_times_today) VALUES(?, ?, ?, ?)";
    public static final String BUSINESS_ADV_MSG_REPLACE_SQL = "REPLACE INTO advisory_custom_msg(target_msgid,role,aid,uk,source,order_type,replyer_uid,eva_is_eva,eva_star_num,eva_star_desc,eva_msg,eva_tags,eva_amount,eva_is_free,eva_has_refund,refund_status,refund_title,refund_text,refund_url_text,allow_refund,eva_type,eva_title,eva_subtitle,eva_tag_list,cardTip,sopTitle,sopList) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String BUSINESS_DIALOGUEID_INSERT_SQL = "INSERT INTO business_dialogueid(business_type,resource_id,dialogue_id) VALUES(?, ?, ?)";
    public static final String BUSINESS_MSG_INSERT_SQL = "REPLACE INTO busisessmsg(msgid,from_user,category,contacter,type,content,time,is_read,status,cmd,device_flag,from_buid,msg_key,tips_code,tips,to_buid,contacter_is_read,dialogue_id,business_type,sendid,session_type,logic_del) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String TAG = "BusinessMessageDBManager";
    public static BusinessMessageDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<IBusiSessionChangeListener> mSessionListeners;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1241190900, "Lcom/baidu/android/imsdk/consult/db/BusinessMessageDBManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1241190900, "Lcom/baidu/android/imsdk/consult/db/BusinessMessageDBManager;");
        }
    }

    public BusinessMessageDBManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSessionListeners = null;
        setContext(context.getApplicationContext());
    }

    private AdvAdBtnShowInfo parseBusinessAdvAdBtnShowInfo(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            return new AdvAdBtnShowInfo(CursorWrapper.getString(cursor, "uk"), CursorWrapper.getInt(cursor, TableDefine.BusiAdvAdBtnShowColumns.COLUMN_HAS_CLICKED_TODAY), CursorWrapper.getLong(cursor, TableDefine.BusiAdvAdBtnShowColumns.COLUMN_LAST_SHOW_TIME), CursorWrapper.getInt(cursor, TableDefine.BusiAdvAdBtnShowColumns.COLUMN_SHOW_TIMES_TODAY));
        }
        return (AdvAdBtnShowInfo) invokeL.objValue;
    }

    public synchronized void notifySessionChange(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            synchronized (this) {
                LogUtils.d(TAG, "notifySessionChange");
                if (this.mSessionListeners != null && this.mSessionListeners.size() != 0) {
                    for (IBusiSessionChangeListener iBusiSessionChangeListener : this.mSessionListeners) {
                        if (iBusiSessionChangeListener != null) {
                            iBusiSessionChangeListener.notifyBusiSessionChange(27, i);
                        }
                    }
                }
            }
        }
    }

    public void notifyUnreadSessionChange(int i) {
        List<IBusiSessionChangeListener> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (list = this.mSessionListeners) != null && list.size() != 0) {
            for (IBusiSessionChangeListener iBusiSessionChangeListener : this.mSessionListeners) {
                if (iBusiSessionChangeListener != null && (iBusiSessionChangeListener instanceof IBusinessSessionUnReadListener)) {
                    ((IBusinessSessionUnReadListener) iBusiSessionChangeListener).notifyBusinessSessionUnread(i);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x017e, code lost:
        if (r10.isClosed() == false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01aa A[Catch: all -> 0x01df, TRY_ENTER, TryCatch #13 {all -> 0x01df, blocks: (B:72:0x01aa, B:54:0x0180, B:75:0x01b1, B:80:0x01d0, B:82:0x01d6, B:83:0x01d9, B:52:0x017a, B:86:0x01dd), top: B:99:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0 A[Catch: all -> 0x01df, TRY_ENTER, TryCatch #13 {all -> 0x01df, blocks: (B:72:0x01aa, B:54:0x0180, B:75:0x01b1, B:80:0x01d0, B:82:0x01d6, B:83:0x01d9, B:52:0x017a, B:86:0x01dd), top: B:99:0x005c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<ChatSession> getBusiSessionWithAdditional(int i, int i2, long j, long j2, long j3, int i3, String str) {
        InterceptResult invokeCommon;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), str})) == null) {
            LogUtils.d(TAG, "getBusiSessionWithAdditional businessType = " + i + " contacterImUk = " + j + " beginMsgid = " + j2 + " endMsgid = " + j3 + " count = " + i3 + " additional = " + str);
            Cursor cursor2 = null;
            if (i3 == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (DBBase.mSyncLock) {
                try {
                    try {
                        SQLiteDatabase openDatabase = openDatabase();
                        if (openDatabase == null) {
                            return null;
                        }
                        String str3 = "ASC";
                        if (i3 < 0) {
                            str3 = "DESC";
                        }
                        try {
                            StringBuilder sb = new StringBuilder();
                            try {
                                sb.append("SELECT * FROM busisession WHERE business = ");
                                sb.append(i);
                                String sb2 = sb.toString();
                                if (j > 0) {
                                    try {
                                        str2 = sb2 + " AND contacter = " + j;
                                    } catch (Exception e) {
                                        e = e;
                                        cursor2 = null;
                                        LogUtils.e(TAG, "getBusiChatSessions:", e);
                                        if (cursor2 != null) {
                                        }
                                        LogUtils.d(TAG, "getBusiChatSessions sessions = " + arrayList.size());
                                        return arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = null;
                                        if (cursor2 != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    str2 = sb2 + " AND " + TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID + " >= " + j2 + " AND " + TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID + " <= " + j3;
                                }
                                if (i2 >= 0) {
                                    str2 = str2 + " AND session_type = " + i2;
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    str2 = str2 + " AND " + str;
                                }
                                String str4 = str2 + " ORDER BY last_msg_time " + str3 + " LIMIT " + Math.abs(i3);
                                LogUtils.d(TAG, "sql = " + str4);
                                cursor = null;
                                try {
                                    cursor2 = openDatabase.rawQuery(str4, null);
                                    if (cursor2 != null) {
                                        while (cursor2.moveToNext()) {
                                            try {
                                                try {
                                                    try {
                                                        ChatSession parseBusinessSession = parseBusinessSession(cursor2);
                                                        if (parseBusinessSession != null) {
                                                            arrayList.add(parseBusinessSession);
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        LogUtils.e(TAG, "getBusiChatSessions:", e);
                                                        if (cursor2 != null && !cursor2.isClosed()) {
                                                            cursor2.close();
                                                        }
                                                        LogUtils.d(TAG, "getBusiChatSessions sessions = " + arrayList.size());
                                                        return arrayList;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (cursor2 != null && !cursor2.isClosed()) {
                                                        cursor2.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                LogUtils.e(TAG, "getBusiChatSessions:", e);
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                LogUtils.d(TAG, "getBusiChatSessions sessions = " + arrayList.size());
                                                return arrayList;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                    if (cursor2 != null) {
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    cursor2 = cursor;
                                    LogUtils.e(TAG, "getBusiChatSessions:", e);
                                    if (cursor2 != null) {
                                    }
                                    LogUtils.d(TAG, "getBusiChatSessions sessions = " + arrayList.size());
                                    return arrayList;
                                } catch (Throwable th4) {
                                    th = th4;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                cursor = null;
                            } catch (Throwable th5) {
                                th = th5;
                                cursor = null;
                            }
                        } catch (Exception e6) {
                            e = e6;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        LogUtils.d(TAG, "getBusiChatSessions sessions = " + arrayList.size());
                        return arrayList;
                    } catch (Throwable th7) {
                        th = th7;
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        } else {
            return (List) invokeCommon.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        if (r4.isClosed() == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long getBusinessChatLastMagTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            LogUtils.d(TAG, "getBusinessChatLastMagTime  contacterImUk = " + j);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                long j2 = -1;
                if (openDatabase == null) {
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    cursor = openDatabase.rawQuery("SELECT time FROM busisessmsg WHERE business_type = 27 AND contacter = " + j + " AND session_type = 0 ORDER BY time DESC  LIMIT 1", null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            j2 = CursorWrapper.getLong(cursor, "time");
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "getBusinessChatLastMagTime:", e);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                LogUtils.d(TAG, "getBusinessChatLastMagTime chatmsgs = " + j2);
                return j2;
            }
        }
        return invokeJ.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
        if (r0.isClosed() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatAdvCustomMsg getBusiAdvCustomMsgByMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            LogUtils.d(TAG, "getBusiAdvCustomMsgByMsgId targetMsgId = " + j);
            Cursor cursor = null;
            if (j == 0) {
                return null;
            }
            ChatAdvCustomMsg chatAdvCustomMsg = new ChatAdvCustomMsg();
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    String str = "SELECT * FROM advisory_custom_msg WHERE target_msgid = " + j;
                    LogUtils.d(TAG, "sql = " + str);
                    cursor = openDatabase.rawQuery(str, null);
                    if (cursor != null && cursor.moveToNext()) {
                        chatAdvCustomMsg = parseBusinessAdvCustomMsg(cursor);
                    }
                    if (cursor != null) {
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "getBusiAdvCustomMsgByMsgId:", e);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                LogUtils.d(TAG, "getBusiAdvCustomMsgByMsgId targetMsgId = " + chatAdvCustomMsg.targetMsgId);
                return chatAdvCustomMsg;
            }
        }
        return (ChatAdvCustomMsg) invokeJ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r9.isClosed() == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdvAdBtnShowInfo getBusinessAdvAdShowInfoByUK(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            LogUtils.d(TAG, "getBusinessAdvAdShowInfoByUK targetUK = " + str);
            AdvAdBtnShowInfo advAdBtnShowInfo = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    LogUtils.d(TAG, "sql = SELECT * FROM advisory_ad_btn_show WHERE uk = ?");
                    cursor = openDatabase.rawQuery("SELECT * FROM advisory_ad_btn_show WHERE uk = ?", new String[]{str});
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToNext()) {
                                    advAdBtnShowInfo = parseBusinessAdvAdBtnShowInfo(cursor);
                                }
                            } catch (Exception e) {
                                e = e;
                                LogUtils.e(TAG, "getBusinessAdvAdShowInfoByUK:", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (advAdBtnShowInfo != null) {
                                }
                                return advAdBtnShowInfo;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                if (advAdBtnShowInfo != null) {
                    LogUtils.d(TAG, "getBusinessAdvAdShowInfoByUK adBtnShowInfo = " + advAdBtnShowInfo);
                }
                return advAdBtnShowInfo;
            }
        }
        return (AdvAdBtnShowInfo) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r3.inTransaction() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long saveBusinessAdvAdShowInfo(AdvAdBtnShowInfo advAdBtnShowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, advAdBtnShowInfo)) == null) {
            long j = -1;
            if (advAdBtnShowInfo == null) {
                return -1L;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1L;
                }
                try {
                    SQLiteStatement compileStatement = openDatabase.compileStatement(BUSINESS_ADV_AD_BTN_SHOW_REPLACE_SQL);
                    openDatabase.beginTransaction();
                    compileStatement.bindString(1, advAdBtnShowInfo.getUk());
                    compileStatement.bindLong(2, advAdBtnShowInfo.getHasClickedToday());
                    compileStatement.bindLong(3, advAdBtnShowInfo.getLastShowTime());
                    compileStatement.bindLong(4, advAdBtnShowInfo.getShowTimesToday());
                    compileStatement.execute();
                    j = 0;
                    openDatabase.setTransactionSuccessful();
                    if (openDatabase != null) {
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "replaceBusinessAdvAdShow:", e);
                    if (openDatabase != null && openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                }
                LogUtils.d(TAG, "replaceBusinessAdvAdShow result = " + j);
                return j;
            }
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b3, code lost:
        if (r0.isClosed() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<ChatSession> getBusinessSessionWithNewMsg(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2, str)) == null) {
            LogUtils.d(TAG, "getBusinessSession businessType = " + i + " count = " + i2 + " additional = " + str);
            Cursor cursor = null;
            if (i2 == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    String str2 = "SELECT * FROM busisession WHERE business = " + i;
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str2 + " AND " + str;
                    }
                    String str3 = str2 + " LIMIT " + Math.abs(i2);
                    LogUtils.d(TAG, "sql = " + str3);
                    cursor = openDatabase.rawQuery(str3, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            ChatSession parseBusinessSession = parseBusinessSession(cursor);
                            if (parseBusinessSession != null) {
                                arrayList.add(parseBusinessSession);
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "getBusiChatSessions:", e);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeIIL.objValue;
    }

    public static BusinessMessageDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (mInstance == null) {
                synchronized (BusinessMessageDBManager.class) {
                    if (mInstance == null) {
                        mInstance = new BusinessMessageDBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (BusinessMessageDBManager) invokeL.objValue;
    }

    public synchronized void registerSessionChangeListener(IBusiSessionChangeListener iBusiSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iBusiSessionChangeListener) == null) {
            synchronized (this) {
                LogUtils.d(TAG, "registerSessionChangeListener");
                if (iBusiSessionChangeListener == null) {
                    return;
                }
                if (this.mSessionListeners == null) {
                    this.mSessionListeners = new LinkedList();
                }
                this.mSessionListeners.add(iBusiSessionChangeListener);
            }
        }
    }

    public synchronized void unRegisterSessionChangeListener(IBusiSessionChangeListener iBusiSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iBusiSessionChangeListener) == null) {
            synchronized (this) {
                LogUtils.d(TAG, "unRegisterSessionChangeListener");
                if (this.mSessionListeners == null) {
                    return;
                }
                this.mSessionListeners.remove(iBusiSessionChangeListener);
            }
        }
    }

    private void parseAdvCustomMsgTags(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, this, str, list) == null) && list != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length > 0) {
                Collections.addAll(list, split);
            }
        }
    }

    private ChatAdvCustomMsg parseBusinessAdvCustomMsg(Cursor cursor) {
        InterceptResult invokeL;
        ArrayList arrayList;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            long j = CursorWrapper.getLong(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_TARGET_MSGID);
            int i = CursorWrapper.getInt(cursor, "role");
            String string = CursorWrapper.getString(cursor, "aid");
            String string2 = CursorWrapper.getString(cursor, "uk");
            int i2 = CursorWrapper.getInt(cursor, "source");
            int i3 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_ORDER_TYPE);
            String string3 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_REPLAYER_UID);
            int i4 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_IS_EVA);
            int i5 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_STAR_NUM);
            String string4 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_STAR_DESC);
            String string5 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_MSG);
            String string6 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TAGS);
            ArrayList arrayList2 = new ArrayList();
            parseAdvCustomMsgTags(string6, arrayList2);
            int i6 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_AMOUNT);
            int i7 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_IS_FREE);
            int i8 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_HAS_REFUND);
            int i9 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_REFUND_STATUS);
            String string7 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_REFUND_TITLE);
            String string8 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_REFUND_TEXT);
            String string9 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_REFUND_URL_TEXT);
            int i10 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_ALLOW_REFUND_STATUS);
            int i11 = CursorWrapper.getInt(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TYPE);
            String string10 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TITLE);
            String string11 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_SUBTITLE);
            String string12 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TAG_LIST);
            ArrayList arrayList3 = new ArrayList();
            parseAdvCustomMsgTags(string12, arrayList3);
            String string13 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_CARD_TIP);
            String string14 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_SOP_TITLE);
            String string15 = CursorWrapper.getString(cursor, TableDefine.BusiAdvCustomMsgColumns.COLUMN_SOP_LIST);
            ArrayList arrayList4 = new ArrayList();
            parseAdvCustomMsgTags(string15, arrayList4);
            if (i8 == 1) {
                arrayList = arrayList4;
                z = true;
            } else {
                arrayList = arrayList4;
                z = false;
            }
            return new ChatAdvCustomMsg(j, i, string, string2, i11, string10, string11, i4, i5, string4, string5, arrayList2, arrayList3, i6, i7, z, i9, string7, string8, string9, i2, i3, string3, i10, string13, string14, arrayList);
        }
        return (ChatAdvCustomMsg) invokeL.objValue;
    }

    private ChatMsg parseBusinessChatMsg(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            int i = CursorWrapper.getInt(cursor, "_id");
            long j = CursorWrapper.getLong(cursor, "msgid");
            long j2 = CursorWrapper.getLong(cursor, "from_user");
            int i2 = CursorWrapper.getInt(cursor, "category");
            long j3 = CursorWrapper.getLong(cursor, "contacter");
            int i3 = CursorWrapper.getInt(cursor, "type");
            String string = CursorWrapper.getString(cursor, "content");
            long j4 = CursorWrapper.getLong(cursor, "time");
            int i4 = CursorWrapper.getInt(cursor, "is_read");
            int i5 = CursorWrapper.getInt(cursor, "status");
            int i6 = CursorWrapper.getInt(cursor, "cmd");
            int i7 = CursorWrapper.getInt(cursor, "device_flag");
            String string2 = CursorWrapper.getString(cursor, "msg_key");
            String string3 = CursorWrapper.getString(cursor, "from_buid");
            int i8 = CursorWrapper.getInt(cursor, "tips_code");
            String string4 = CursorWrapper.getString(cursor, "tips");
            String string5 = CursorWrapper.getString(cursor, TableDefine.BusiChatMsgColumns.COLUMN_TO_BDUID);
            int i9 = CursorWrapper.getInt(cursor, TableDefine.BusiChatMsgColumns.COLUMN_CONTACTER_IS_READ);
            long j5 = CursorWrapper.getLong(cursor, "dialogue_id");
            String string6 = CursorWrapper.getString(cursor, "sendid");
            int i10 = CursorWrapper.getInt(cursor, "session_type");
            int i11 = CursorWrapper.getInt(cursor, "logic_del");
            ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i2, i3, i6);
            if (newChatMsg == null) {
                return null;
            }
            newChatMsg.setCategory(i2);
            newChatMsg.setContacter(j3);
            newChatMsg.setFromUser(j2);
            newChatMsg.setMsgContent(string);
            newChatMsg.setRowId(i);
            newChatMsg.setMsgId(j);
            newChatMsg.setMsgTime(j4);
            newChatMsg.setMsgReaded(i4);
            newChatMsg.setStatus(i5);
            newChatMsg.setNotifyCmd(i6);
            newChatMsg.setDeviceFlag(i7);
            newChatMsg.setMsgKey(string2);
            newChatMsg.setTips(string4);
            newChatMsg.setTipsCode(i8);
            newChatMsg.setContacterIsRead(i9);
            newChatMsg.setDialogueId(j5);
            newChatMsg.setSenderUid(string3);
            newChatMsg.setContacterBduid(string5);
            newChatMsg.setSendMsgId(string6);
            newChatMsg.setSessionType(i10);
            newChatMsg.setLogicDel(i11);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    private ChatSession parseBusinessSession(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            int i = CursorWrapper.getInt(cursor, "business");
            int i2 = CursorWrapper.getInt(cursor, "category");
            long j = CursorWrapper.getLong(cursor, "contacter");
            String string = CursorWrapper.getString(cursor, "name");
            String string2 = CursorWrapper.getString(cursor, "last_msg");
            long j2 = CursorWrapper.getLong(cursor, "last_msg_time");
            long j3 = CursorWrapper.getLong(cursor, "new_msg_sum");
            String string3 = CursorWrapper.getString(cursor, "icon_url");
            long j4 = CursorWrapper.getLong(cursor, "bduid");
            long j5 = CursorWrapper.getLong(cursor, TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID);
            int i3 = CursorWrapper.getInt(cursor, "session_type");
            long j6 = CursorWrapper.getLong(cursor, TableDefine.BusiSessionColumns.COLUMN_LAST_DIALOGUE_ID);
            String string4 = CursorWrapper.getString(cursor, TableDefine.BusiSessionColumns.COLUMN_LAST_RESOURCE_ID);
            int i4 = CursorWrapper.getInt(cursor, TableDefine.BusiSessionColumns.COLUMN_AID_TYPE);
            int i5 = CursorWrapper.getInt(cursor, TableDefine.BusiSessionColumns.COLUMN_DIALOGUE_STATUS);
            int i6 = CursorWrapper.getInt(cursor, "chat_type");
            String string5 = CursorWrapper.getString(cursor, "extra");
            String string6 = CursorWrapper.getString(cursor, "v_portrait");
            long j7 = CursorWrapper.getLong(cursor, TableDefine.BusiSessionColumns.COLUMN_LAST_ASK_UK);
            long j8 = CursorWrapper.getLong(cursor, TableDefine.BusiSessionColumns.COLUMN_LAST_ANSWER_UK);
            String string7 = CursorWrapper.getString(cursor, TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_DESC);
            String string8 = CursorWrapper.getString(cursor, TableDefine.BusiSessionColumns.COLUMN_DRAFT);
            String string9 = CursorWrapper.getString(cursor, TableDefine.BusiSessionColumns.COLUMN_STATUS_SHOW);
            int i7 = CursorWrapper.getInt(cursor, "classtype");
            int i8 = CursorWrapper.getInt(cursor, "classshow");
            String string10 = CursorWrapper.getString(cursor, "classtitle");
            String string11 = CursorWrapper.getString(cursor, "classavatar");
            int i9 = CursorWrapper.getInt(cursor, "subscribe_status");
            int i10 = CursorWrapper.getInt(cursor, TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS);
            ChatSession chatSession = new ChatSession(i2, j, j4, string);
            chatSession.setBusinessType(i);
            chatSession.setLastMsg(string2);
            chatSession.setLastMsgTime(j2);
            chatSession.setNewMsgSum(j3);
            chatSession.setIconUrl(string3);
            chatSession.setLastMsgId(j5);
            chatSession.setSessionType(i3);
            chatSession.setLastDialogueStatus(i5);
            chatSession.setAidType(i4);
            chatSession.setLastResourceId(string4);
            chatSession.setLastDialogueId(j6);
            chatSession.setChatType(i6);
            chatSession.setExt(string5);
            chatSession.setVPortrait(string6);
            chatSession.setLastAskUk(j7);
            chatSession.setLastAnswerUk(j8);
            chatSession.setDesc(string7);
            chatSession.setDraft(string8);
            chatSession.setLastStatusShow(string9);
            chatSession.setClassTitle(string10);
            chatSession.setClassAvatar(string11);
            chatSession.setClassShow(i8);
            chatSession.setClassType(i7);
            chatSession.setSubscribe(i9);
            chatSession.setCollectState(i10);
            return chatSession;
        }
        return (ChatSession) invokeL.objValue;
    }

    public int delBusiChatSession(int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i3 = -1;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    i3 = openDatabase.delete(TableDefine.DB_TABLE_BUSINESS_SESSION, "contacter = ? AND business = ? AND session_type = ? ", new String[]{String.valueOf(j), String.valueOf(i), String.valueOf(i2)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "delBusiChatSession:", e);
                }
                if (i3 > 0) {
                    BIMManager.handleConsultMsgNotify(this.mContext, i, i2, j, 3, -1L);
                    notifySessionChange(2);
                }
                return i3;
            }
        }
        return invokeCommon.intValue;
    }

    public int deleteLogicBusiMsgBatch(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                } else if (j2 <= 0 || i <= 0) {
                    return -1;
                } else {
                    int i2 = 0;
                    try {
                        String[] strArr = {String.valueOf(j2), String.valueOf(i), String.valueOf(j)};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("logic_del", (Integer) 1);
                        i2 = (int) (0 + openDatabase.update(TableDefine.DB_TABLE_BUSINESS_CHAT_MSG, contentValues, "business_type = ? and session_type = ? and contacter = ? ", strArr));
                    } catch (Exception e) {
                        LogUtils.e(TAG, "delMsg:", e);
                    }
                    return i2;
                }
            }
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r12 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r12 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDraftMsg(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                String str = "";
                Cursor cursor = null;
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getReadableDb fail!");
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_BUSINESS_SESSION, null, "category=? AND contacter=? AND session_type=?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(i2)}, null, null, null, null);
                    if (cursor != null && cursor.moveToNext()) {
                        str = CursorWrapper.getString(cursor, TableDefine.BusiSessionColumns.COLUMN_DRAFT);
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "getDraftMsg:", e);
                }
            }
        } else {
            return (String) invokeCommon.objValue;
        }
    }

    public int setSessionSubscribeStatusByBusiness(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                int i3 = 0;
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("subscribe_status", Integer.valueOf(i2));
                    i3 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateSessionSubscribeStatus:", e);
                }
                LogUtils.d(TAG, "updateSessionSubscribeStatus result = " + i3);
                return i3;
            }
        }
        return invokeCommon.intValue;
    }

    public int deleteDraft(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            synchronized (DBBase.mSyncLock) {
                long businessChatLastMagTime = getBusinessChatLastMagTime(j);
                SQLiteDatabase openDatabase = openDatabase();
                int i2 = -1;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.BusiSessionColumns.COLUMN_DRAFT, "");
                    if (businessChatLastMagTime > 0) {
                        contentValues.put("last_msg_time", Long.valueOf(businessChatLastMagTime));
                    }
                    i2 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "category=? AND contacter=?", new String[]{String.valueOf(i), String.valueOf(j)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteDraft:", e);
                }
                LogUtils.d(TAG, "deleteDraft result = " + i2);
                if (i2 > 0) {
                    notifySessionChange(4);
                }
                return i2;
            }
        }
        return invokeCommon.intValue;
    }

    public int deleteExpiredBusinessSession(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            LogUtils.d(TAG, "deleteExpiredBusinessSession businessType = " + i + " time = " + j);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i2 = -1;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    i2 = openDatabase.delete(TableDefine.DB_TABLE_BUSINESS_SESSION, "business= ? AND last_msg_time <= ?", new String[]{String.valueOf(i), String.valueOf(j)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredBusinessSession:", e);
                }
                LogUtils.d(TAG, "deleteExpiredBusinessSession result = " + i2);
                if (i2 > 0) {
                    notifySessionChange(2);
                }
                return i2;
            }
        }
        return invokeCommon.intValue;
    }

    public long setBusinessAdvAdShowClickedInfoByUK(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, str, z)) == null) {
            LogUtils.d(TAG, "setBusinessAdvAdShowClickedInfoByUK uk = " + str);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                long j = -1;
                if (openDatabase == null) {
                    return -1L;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    contentValues.put(TableDefine.BusiAdvAdBtnShowColumns.COLUMN_HAS_CLICKED_TODAY, Integer.valueOf(i));
                    j = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_ADVISORY_AD_BTN_SHOW, contentValues, "uk = ? ", new String[]{str});
                } catch (Exception e) {
                    LogUtils.e(TAG, "setBusinessAdvAdShowClickedInfoByUK:", e);
                }
                LogUtils.d(TAG, "setBusinessAdvAdShowClickedInfoByUK result = " + j);
                return j;
            }
        }
        return invokeLZ.longValue;
    }

    public int deleteLogicBusiMsgBatch(long j, long j2, int i, long[] jArr) {
        InterceptResult invokeCommon;
        SQLiteDatabase openDatabase;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), jArr})) == null) {
            synchronized (DBBase.mSyncLock) {
                int i2 = -1;
                if (openDatabase() == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                if (jArr != null) {
                    int i3 = 0;
                    try {
                    } catch (Exception e) {
                        e = e;
                    }
                    if (jArr.length > 0) {
                        LogUtils.d(TAG, "deleteLogicBusiMsgBatch:" + Arrays.toString(jArr));
                        try {
                            String[] strArr = {String.valueOf(j2), String.valueOf(i), String.valueOf(j), ""};
                            for (long j3 : jArr) {
                                try {
                                    strArr[3] = String.valueOf(j3);
                                    new ContentValues().put("logic_del", (Integer) 1);
                                    i3 = (int) (i3 + openDatabase.update(TableDefine.DB_TABLE_BUSINESS_CHAT_MSG, contentValues, "business_type = ? and session_type = ? and contacter = ? and msgid = ? ", strArr));
                                } catch (Exception e2) {
                                    e = e2;
                                    i2 = i3;
                                    LogUtils.e(TAG, "deleteLogicBusiMsgBatch:", e);
                                    i3 = i2;
                                    return i3;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i2 = 0;
                        }
                        return i3;
                    }
                }
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public int setBusinessChatMsgRead(int i, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            LogUtils.d(TAG, "setBusinessChatMsgRead businessType = " + i + " sessionType = " + i2 + " contacterImUk = " + j);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i3 = -1;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_read", (Integer) 1);
                    i3 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_CHAT_MSG, contentValues, "business_type = ? AND contacter = ? AND session_type = ? AND msgid <= ? AND is_read = ?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(i2), String.valueOf(j2), String.valueOf(0)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "setBusinessChatMsgRead:", e);
                }
                LogUtils.d(TAG, "setBusinessChatMsgRead result = " + i3);
                return i3;
            }
        }
        return invokeCommon.intValue;
    }

    public List<ChatSession> getBusiChatSessions(int i, int i2, long j, long j2, long j3, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            LogUtils.d(TAG, "getBusiChatSessions businessType = " + i + " contacterImUk = " + j + " beginMsgid = " + j2 + " endMsgid = " + j3 + " count = " + i3);
            List<ChatSession> list = null;
            if (i3 == 0) {
                return null;
            }
            if (i4 == 2) {
                list = getBusiSessionWithAdditional(i, i2, j, j2, j3, i3, "last_dialogue_status = 1");
            }
            if (list == null || list.size() == 0) {
                return getBusiSessionWithAdditional(i, i2, j, j2, j3, i3, null);
            }
            return list;
        }
        return (List) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f7, code lost:
        if (r8.isClosed() == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatMsg> getBusinessChatMsgs(int i, int i2, long j, long j2, long j3, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)})) == null) {
            LogUtils.d(TAG, "getBusiChatMsgs businessType = " + i + " contacterImUk = " + j + " beginMsgid = " + j2 + " endMsgid = " + j3 + " count = " + i3);
            Cursor cursor = null;
            if (i3 == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (DBBase.mSyncLock) {
                try {
                    try {
                        SQLiteDatabase openDatabase = openDatabase();
                        if (openDatabase == null) {
                            return null;
                        }
                        String str = "ASC";
                        if (i3 < 0) {
                            str = "DESC";
                        }
                        try {
                            cursor = openDatabase.rawQuery("SELECT * FROM busisessmsg WHERE business_type = " + i + " AND contacter = " + j + " AND session_type = " + i2 + " AND msgid >= " + j2 + " AND msgid <= " + j3 + " ORDER BY msgid " + str + " LIMIT " + Math.abs(i3), null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        try {
                                            ChatMsg parseBusinessChatMsg = parseBusinessChatMsg(cursor);
                                            if (parseBusinessChatMsg != null) {
                                                arrayList.add(parseBusinessChatMsg);
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            LogUtils.e(TAG, "getBusiChatMsgs:", e);
                                            if (cursor != null && !cursor.isClosed()) {
                                                cursor.close();
                                            }
                                            LogUtils.d(TAG, "getBusiChatMsgs chatmsgs = " + arrayList.size());
                                            return arrayList;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursor != null && !cursor.isClosed()) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (cursor != null) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                        LogUtils.d(TAG, "getBusiChatMsgs chatmsgs = " + arrayList.size());
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } else {
            return (List) invokeCommon.objValue;
        }
    }

    public List<ChatSession> getBusinessChatSessions(int i, int i2, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (i2 == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (j2 > 0) {
                sb.append("last_msg_time");
                sb.append(" > ");
                sb.append(j2 - j);
                sb.append(" AND ");
            }
            sb.append(TableDefine.BusiSessionColumns.COLUMN_LAST_ASK_UK);
            sb.append(" = ");
            sb.append(AccountManager.getUK(this.mContext));
            if (z) {
                sb.append(" AND ");
                sb.append("new_msg_sum");
                sb.append(" > ");
                sb.append(0);
            }
            sb.append(" ORDER BY ");
            sb.append("last_msg_time");
            sb.append(" ");
            sb.append("DESC");
            return getBusinessSessionWithNewMsg(i, i2, sb.toString());
        }
        return (List) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x015a, code lost:
        if (r3.inTransaction() != false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long insertBusinessChatMsg(int i, List<ChatMsg> list) {
        InterceptResult invokeIL;
        long j;
        String senderUid;
        String tips;
        String toBduid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, list)) == null) {
            long j2 = -1;
            if (list == null || list.size() == 0) {
                return -1L;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1L;
                }
                LogUtils.d(TAG, "insertBusinessChatMsg size = " + list.size());
                try {
                    SQLiteStatement compileStatement = openDatabase.compileStatement(BUSINESS_MSG_INSERT_SQL);
                    openDatabase.beginTransaction();
                    for (ChatMsg chatMsg : list) {
                        compileStatement.bindLong(1, chatMsg.getMsgId());
                        compileStatement.bindLong(2, chatMsg.getFromUser());
                        compileStatement.bindLong(3, chatMsg.getCategory());
                        compileStatement.bindLong(4, chatMsg.getContacter());
                        compileStatement.bindLong(5, chatMsg.getMsgType());
                        compileStatement.bindString(6, chatMsg.getMsgContent());
                        compileStatement.bindLong(7, chatMsg.getMsgTime());
                        if (chatMsg.isMsgRead()) {
                            j = 1;
                        } else {
                            j = 0;
                        }
                        compileStatement.bindLong(8, j);
                        compileStatement.bindLong(9, chatMsg.getStatus());
                        compileStatement.bindLong(10, chatMsg.getNotifyCmd());
                        compileStatement.bindLong(11, chatMsg.getDeviceFlag());
                        if (TextUtils.isEmpty(chatMsg.getSenderUid())) {
                            senderUid = "0";
                        } else {
                            senderUid = chatMsg.getSenderUid();
                        }
                        compileStatement.bindString(12, senderUid);
                        if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                            compileStatement.bindNull(13);
                        } else {
                            compileStatement.bindString(13, chatMsg.getMsgKey());
                        }
                        compileStatement.bindLong(14, chatMsg.getTipsCode());
                        if (chatMsg.getTips() == null) {
                            tips = "";
                        } else {
                            tips = chatMsg.getTips();
                        }
                        compileStatement.bindString(15, tips);
                        if (TextUtils.isEmpty(chatMsg.getToBduid())) {
                            toBduid = "0";
                        } else {
                            toBduid = chatMsg.getToBduid();
                        }
                        compileStatement.bindString(16, toBduid);
                        compileStatement.bindLong(17, chatMsg.getContacterIsRead());
                        compileStatement.bindLong(18, chatMsg.getDialogueId());
                        compileStatement.bindLong(19, i);
                        compileStatement.bindString(20, chatMsg.getSendMsgId());
                        compileStatement.bindLong(21, chatMsg.getSessionType());
                        compileStatement.bindLong(22, chatMsg.getLogicDel());
                        j2 = compileStatement.executeInsert();
                    }
                    openDatabase.setTransactionSuccessful();
                    if (openDatabase != null) {
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "insertBusinessChatMsg:", e);
                    if (openDatabase != null && openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                }
                LogUtils.d(TAG, "insertBusinessChatMsg result = " + j2);
                return j2;
            }
        }
        return invokeIL.longValue;
    }

    public long insertBusinessDialogueId(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                long j2 = -1;
                if (openDatabase == null) {
                    return -1L;
                }
                LogUtils.d(TAG, "insertBusinessDialogueId businessType = " + i + " resourceId = " + str + " dialogueId = " + j);
                try {
                    SQLiteStatement compileStatement = openDatabase.compileStatement(BUSINESS_DIALOGUEID_INSERT_SQL);
                    compileStatement.bindLong(1, i);
                    compileStatement.bindString(2, str);
                    compileStatement.bindLong(3, j);
                    j2 = compileStatement.executeInsert();
                } catch (Exception e) {
                    LogUtils.e(TAG, "insertBusinessDialogueId:", e);
                }
                LogUtils.d(TAG, "insertBusinessDialogueId result = " + j2);
                return j2;
            }
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r9.isClosed() == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long queryBusinessDialogueId(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, str)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1L;
                }
                LogUtils.d(TAG, "queryBusinessDialogueId businessType = " + i + " resourceId = " + str);
                Cursor cursor = null;
                long j = 0;
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_BUSINESS_DIALOGUEID, new String[]{"dialogue_id"}, "business_type = ?  AND resource_id = ?", new String[]{String.valueOf(i), String.valueOf(str)}, null, null, null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getLong(cursor.getColumnIndex("dialogue_id"));
                    }
                    if (cursor != null) {
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "queryBusinessDialogueId:", e);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                LogUtils.d(TAG, "queryBusinessDialogueId dialogueId = " + j);
                return j;
            }
        }
        return invokeIL.longValue;
    }

    public int saveDraft(int i, ChatMsg chatMsg) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, chatMsg)) == null) {
            int i2 = -1;
            if (chatMsg == null) {
                return -1;
            }
            LogUtils.d(TAG, "updateBusiChatSession businessType = " + i + " msg = " + chatMsg.toString());
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.BusiSessionColumns.COLUMN_DRAFT, chatMsg.getRecommendDescription());
                    contentValues.put("last_msg_time", Long.valueOf(chatMsg.getMsgTime()));
                    i2 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND session_type = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(chatMsg.getSessionType()), String.valueOf(chatMsg.getContacter())});
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateBusiChatSession:", e);
                }
                LogUtils.d(TAG, "updateBusiChatSession result = " + i2);
                if (i2 > 0) {
                    notifySessionChange(4);
                }
                return i2;
            }
        }
        return invokeIL.intValue;
    }

    public long replaceBusinessAdvCustomMsg(ChatAdvCustomMsg chatAdvCustomMsg) {
        InterceptResult invokeL;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, chatAdvCustomMsg)) == null) {
            long j2 = -1;
            if (chatAdvCustomMsg == null) {
                return -1L;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1L;
                }
                long j3 = 0;
                try {
                    SQLiteStatement compileStatement = openDatabase.compileStatement(BUSINESS_ADV_MSG_REPLACE_SQL);
                    openDatabase.beginTransaction();
                    compileStatement.bindLong(1, chatAdvCustomMsg.targetMsgId);
                    compileStatement.bindLong(2, chatAdvCustomMsg.role);
                    compileStatement.bindString(3, chatAdvCustomMsg.aid);
                    compileStatement.bindString(4, chatAdvCustomMsg.uk);
                    compileStatement.bindLong(5, chatAdvCustomMsg.source);
                    compileStatement.bindLong(6, chatAdvCustomMsg.orderType);
                    compileStatement.bindString(7, chatAdvCustomMsg.replyerUid);
                    compileStatement.bindLong(8, chatAdvCustomMsg.evaIsEvaluated);
                    compileStatement.bindLong(9, chatAdvCustomMsg.evaStarNum);
                    compileStatement.bindString(10, chatAdvCustomMsg.evaStarDesc);
                    compileStatement.bindString(11, chatAdvCustomMsg.evaMsg);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < chatAdvCustomMsg.evaTags.size(); i++) {
                        sb.append(chatAdvCustomMsg.evaTags.get(i));
                        if (i < chatAdvCustomMsg.evaTags.size() - 1) {
                            sb.append(",");
                        }
                    }
                    compileStatement.bindString(12, sb.toString());
                    compileStatement.bindLong(13, chatAdvCustomMsg.evaAmount);
                    compileStatement.bindLong(14, chatAdvCustomMsg.evaIsFree);
                    if (chatAdvCustomMsg.evaHasRefund) {
                        j = 1;
                    } else {
                        j = 0;
                    }
                    compileStatement.bindLong(15, j);
                    compileStatement.bindLong(16, chatAdvCustomMsg.refundStatus);
                    compileStatement.bindString(17, chatAdvCustomMsg.refundTitle);
                    compileStatement.bindString(18, chatAdvCustomMsg.refundText);
                    if (TextUtils.isEmpty(chatAdvCustomMsg.refundUrlText)) {
                        str = "";
                    } else {
                        str = chatAdvCustomMsg.refundUrlText;
                    }
                    compileStatement.bindString(19, str);
                    compileStatement.bindLong(20, chatAdvCustomMsg.allowRefund);
                    compileStatement.bindLong(21, chatAdvCustomMsg.evaType);
                    compileStatement.bindString(22, chatAdvCustomMsg.evaTitle);
                    compileStatement.bindString(23, chatAdvCustomMsg.evaSubTitle);
                    String str2 = "";
                    if (chatAdvCustomMsg.evaTagList != null) {
                        str2 = TextUtils.join(",", chatAdvCustomMsg.evaTagList);
                    }
                    compileStatement.bindString(24, str2);
                    compileStatement.bindString(25, chatAdvCustomMsg.cardTip);
                    compileStatement.bindString(26, chatAdvCustomMsg.sopTitle);
                    String str3 = "";
                    if (chatAdvCustomMsg.sopList != null) {
                        str3 = TextUtils.join(",", chatAdvCustomMsg.sopList);
                    }
                    compileStatement.bindString(27, str3);
                    compileStatement.execute();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    openDatabase.setTransactionSuccessful();
                    if (openDatabase != null && openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                } catch (Exception e2) {
                    e = e2;
                    j2 = 0;
                    LogUtils.e(TAG, "replaceBusinessAdvCustomMsg:", e);
                    if (openDatabase != null && openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                    j3 = j2;
                    LogUtils.d(TAG, "replaceBusinessAdvCustomMsg result = " + j3);
                    return j3;
                }
                LogUtils.d(TAG, "replaceBusinessAdvCustomMsg result = " + j3);
                return j3;
            }
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0265  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long replaceBusinessSession(List<ChatSession> list) {
        InterceptResult invokeL;
        long j;
        String iconUrl;
        String ext;
        String vPortrait;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
            long j2 = -1;
            if (list == null || list.size() == 0) {
                return -1L;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1L;
                }
                LogUtils.d(TAG, "replaceBusinessSession size = " + list.size());
                try {
                    openDatabase.beginTransaction();
                    j = -1;
                    for (ChatSession chatSession : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("business", Integer.valueOf(chatSession.getBusinessType()));
                            contentValues.put("name", chatSession.getName());
                            if (chatSession.getLastMsg() != null) {
                                contentValues.put("last_msg", chatSession.getLastMsg());
                            }
                            String draftMsg = getDraftMsg(chatSession.getCategory(), chatSession.getContacter(), chatSession.getSessionType());
                            if (chatSession.getLastDialogueStatus() == 2 || TextUtils.isEmpty(draftMsg)) {
                                contentValues.put("last_msg_time", Long.valueOf(chatSession.getLastMsgTime()));
                            }
                            contentValues.put("new_msg_sum", Long.valueOf(chatSession.getNewMsgSum()));
                            contentValues.put("category", Integer.valueOf(chatSession.getCategory()));
                            contentValues.put("contacter", Long.valueOf(chatSession.getContacter()));
                            contentValues.put("bduid", Long.valueOf(chatSession.getContacterId()));
                            if (chatSession.getIconUrl() == null) {
                                iconUrl = "";
                            } else {
                                iconUrl = chatSession.getIconUrl();
                            }
                            contentValues.put("icon_url", iconUrl);
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, Long.valueOf(chatSession.getLastMsgId()));
                            contentValues.put("session_type", Integer.valueOf(chatSession.getSessionType()));
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_DIALOGUE_ID, Long.valueOf(chatSession.getLastDialogueId()));
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_RESOURCE_ID, chatSession.getLastResourceId());
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_AID_TYPE, Integer.valueOf(chatSession.getAidType()));
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_DIALOGUE_STATUS, Integer.valueOf(chatSession.getLastDialogueStatus()));
                            contentValues.put("chat_type", Integer.valueOf(chatSession.getChatType()));
                            if (chatSession.getExt() == null) {
                                ext = "";
                            } else {
                                ext = chatSession.getExt();
                            }
                            contentValues.put("extra", ext);
                            if (chatSession.getVPortrait() == null) {
                                vPortrait = "";
                            } else {
                                vPortrait = chatSession.getVPortrait();
                            }
                            contentValues.put("v_portrait", vPortrait);
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_ASK_UK, Long.valueOf(chatSession.getLastAskUk()));
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_ANSWER_UK, Long.valueOf(chatSession.getLastAnswerUk()));
                            if (chatSession.getDesc() != null) {
                                contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_DESC, chatSession.getDesc());
                            }
                            if (chatSession.getLastDialogueStatus() == 2) {
                                contentValues.put(TableDefine.BusiSessionColumns.COLUMN_DRAFT, "");
                            }
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_STATUS_SHOW, chatSession.getLastStatusShow());
                            contentValues.put("classtype", Integer.valueOf(chatSession.getClassType()));
                            contentValues.put("classtitle", chatSession.getClassTitle());
                            contentValues.put("classshow", Integer.valueOf(chatSession.getClassShow()));
                            contentValues.put("classavatar", chatSession.getClassAvatar());
                            contentValues.put("subscribe_status", Integer.valueOf(chatSession.getSubscribe()));
                            contentValues.put(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, Integer.valueOf(chatSession.getCollectState()));
                            if (openDatabase.insertWithOnConflict(TableDefine.DB_TABLE_BUSINESS_SESSION, null, contentValues, 4) == -1) {
                                openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND session_type = ? AND contacter = ?", new String[]{String.valueOf(chatSession.getBusinessType()), String.valueOf(chatSession.getSessionType()), String.valueOf(chatSession.getContacter())});
                            }
                            j++;
                        } catch (Exception e) {
                            e = e;
                            j2 = j;
                            LogUtils.e(TAG, "replaceBusinessSession:", e);
                            if (openDatabase != null && openDatabase.inTransaction()) {
                                openDatabase.endTransaction();
                            }
                            j = j2;
                            LogUtils.d(TAG, "replaceBusinessSession result = " + j);
                            if (j >= 0) {
                            }
                            return j;
                        }
                    }
                    openDatabase.setTransactionSuccessful();
                    if (openDatabase != null && openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                LogUtils.d(TAG, "replaceBusinessSession result = " + j);
                if (j >= 0) {
                    notifySessionChange(1);
                }
                return j;
            }
        }
        return invokeL.longValue;
    }

    public int setAllBusinessSessionRead(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            LogUtils.d(TAG, "setAllBusinessSessionRead businessType = " + i);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i2 = -1;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("new_msg_sum", (Integer) 0);
                    i2 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND new_msg_sum != ?", new String[]{String.valueOf(i), String.valueOf(0)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "setAllBusinessSessionRead:", e);
                }
                LogUtils.d(TAG, "setAllBusinessSessionRead result = " + i2);
                if (i2 > 0) {
                    notifySessionChange(3);
                }
                return i2;
            }
        }
        return invokeI.intValue;
    }

    public int setBusinessChatMsgContacterRead(int i, int i2, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        int i3;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            LogUtils.d(TAG, "setBusinessChatMsgContacterRead businessType = " + i + " sessionType = " + i2 + " contacterImUk = " + j + " maxId = " + j2 + " dialogId = " + j3);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.BusiChatMsgColumns.COLUMN_CONTACTER_IS_READ, (Integer) 1);
                    String str = "business_type = ? AND contacter = ? AND session_type = ? AND msgid <= ? AND contacter_is_read = ? AND from_user = ?";
                    if (j3 > 0) {
                        str = "business_type = ? AND contacter = ? AND session_type = ? AND msgid <= ? AND contacter_is_read = ? AND from_user = ? AND dialogue_id = ?";
                        strArr = new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(i2), String.valueOf(j2), String.valueOf(0), String.valueOf(AccountManager.getUK(this.mContext)), String.valueOf(j3)};
                    } else {
                        strArr = new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(i2), String.valueOf(j2), String.valueOf(0), String.valueOf(AccountManager.getUK(this.mContext))};
                    }
                    i3 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_CHAT_MSG, contentValues, str, strArr);
                } catch (Exception e) {
                    LogUtils.e(TAG, "setBusinessChatMsgContacterRead:", e);
                    i3 = -1;
                }
                LogUtils.d(TAG, "setBusinessChatMsgContacterRead result = " + i3);
                return i3;
            }
        }
        return invokeCommon.intValue;
    }

    public int setBusinessSessionRead(int i, int i2, long j, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)})) == null) {
            LogUtils.d(TAG, "setBusinessSessionRead businessType = " + i + " contacterImUk = " + j + " unread = " + i3);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("new_msg_sum", Integer.valueOf(i3));
                    i4 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND contacter = ? AND session_type = ?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(i2)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "setBusinessSessionRead:", e);
                    i4 = -1;
                }
                LogUtils.d(TAG, "setBusinessSessionRead result = " + i4);
                if (i4 > 0) {
                    BIMManager.handleConsultMsgNotify(this.mContext, i, i2, j, 1, -1L);
                    notifySessionChange(3);
                }
                return i4;
            }
        }
        return invokeCommon.intValue;
    }

    public int updateBusiChatSession(int i, ChatMsg chatMsg) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i, chatMsg)) == null) {
            int i2 = -1;
            if (chatMsg == null) {
                return -1;
            }
            LogUtils.d(TAG, "updateBusiChatSession businessType = " + i + " msg = " + chatMsg.toString());
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("last_msg", chatMsg.getRecommendDescription());
                    contentValues.put("last_msg_time", Long.valueOf(chatMsg.getMsgTime()));
                    contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_DIALOGUE_ID, Long.valueOf(chatMsg.getDialogueId()));
                    contentValues.put(TableDefine.BusiSessionColumns.COLUMN_LAST_RESOURCE_ID, chatMsg.getResourceId());
                    i2 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND session_type = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(chatMsg.getSessionType()), String.valueOf(chatMsg.getContacter())});
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateBusiChatSession:", e);
                }
                LogUtils.d(TAG, "updateBusiChatSession result = " + i2);
                if (i2 > 0) {
                    notifySessionChange(4);
                }
                return i2;
            }
        }
        return invokeIL.intValue;
    }

    public int updateSessionCollectStatus(int i, long j, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                int i4 = 0;
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, Integer.valueOf(i3));
                    i4 = openDatabase.update(TableDefine.DB_TABLE_BUSINESS_SESSION, contentValues, "business = ? AND contacter = ? AND session_type = ?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(i2)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateSessionCollectStatus:", e);
                }
                LogUtils.d(TAG, "updateSessionCollectStatus result = " + i4);
                return i4;
            }
        }
        return invokeCommon.intValue;
    }
}
