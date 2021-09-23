package c.a.r0.k1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c f21352a;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized c h() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (c.class) {
                if (f21352a == null) {
                    f21352a = new c();
                }
                cVar = f21352a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        h.e().d("CREATE TABLE IF NOT EXISTS " + ("tb_group_msg_" + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);");
    }

    public void b(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.createMsgTable", new Object[0]);
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (!linkedList.contains("tb_group_msg_" + imMessageCenterPojo.getGid())) {
                    a(imMessageCenterPojo.getGid());
                }
            }
        } finally {
            c.a.e.e.p.m.a(cursor);
        }
    }

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                h.e().b("tb_group_msg_" + str, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.deleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                h e2 = h.e();
                e2.d("delete from " + ("tb_group_msg_" + str));
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                TiebaStatic.printDBExceptionLog(e3, "GroupMsgDao.deleteMsgTableById", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                h e2 = h.e();
                e2.d("DROP TABLE IF EXISTS " + ("tb_group_msg_" + str));
            } catch (Exception e3) {
                e3.printStackTrace();
                TiebaStatic.printDBExceptionLog(e3, "GroupMsgDao.dropMsgTableById", new Object[0]);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public LinkedHashMap<String, String> f(String str, int i2, String str2, int i3) {
        InterceptResult invokeCommon;
        Cursor h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)})) == null) {
            Cursor cursor = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i4 = i3 <= 0 ? 20 : i3;
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            String str3 = "tb_group_msg_" + str;
            try {
                try {
                    if (TextUtils.isEmpty(str2)) {
                        h2 = h.e().h("select * from " + str3 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i4, new String[]{String.valueOf(i2), String.valueOf(0)});
                    } else {
                        h2 = h.e().h("select * from " + str3 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i4, new String[]{str2, String.valueOf(i2), String.valueOf(0)});
                    }
                    Cursor cursor2 = h2;
                    if (cursor2 != null) {
                        while (cursor2.moveToNext()) {
                            try {
                                linkedHashMap.put(cursor2.getString(cursor2.getColumnIndex("mid")), cursor2.getString(cursor2.getColumnIndex("content")));
                            } catch (SQLiteException e2) {
                                e = e2;
                                cursor = cursor2;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i2, new Object[0]);
                                c.a.e.e.p.m.a(cursor);
                                return linkedHashMap;
                            } catch (Exception e3) {
                                e = e3;
                                cursor = cursor2;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i2, new Object[0]);
                                c.a.e.e.p.m.a(cursor);
                                return linkedHashMap;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                c.a.e.e.p.m.a(cursor);
                                throw th;
                            }
                        }
                    }
                    c.a.e.e.p.m.a(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            return linkedHashMap;
        }
        return (LinkedHashMap) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0112 A[EXC_TOP_SPLITTER, LOOP:0: B:53:0x0112->B:28:0x0118, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList<ChatMessage> g(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        Cursor cursor;
        Cursor h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048582, this, str, str2, str3, i2)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i3 = i2 <= 0 ? 20 : i2;
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            String str4 = "tb_group_msg_" + str;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    c.a.e.e.p.m.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                c.a.e.e.p.m.a(cursor2);
                throw th;
            }
            if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
                h2 = h.e().h("select * from " + str4 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{str3, String.valueOf(0)});
                cursor = h2;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            CommonGroupChatMessage commonGroupChatMessage = new CommonGroupChatMessage();
                            commonGroupChatMessage.setGroupId(str);
                            commonGroupChatMessage.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonGroupChatMessage.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonGroupChatMessage.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            commonGroupChatMessage.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            MsgLocalData msgLocalData = new MsgLocalData();
                            commonGroupChatMessage.setLocalData(msgLocalData);
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                            commonGroupChatMessage.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonGroupChatMessage.setUserId(cursor.getColumnIndex("uid"));
                            commonGroupChatMessage.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                            commonGroupChatMessage.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            c.a.r0.k1.w.c.n(commonGroupChatMessage);
                            linkedList.addFirst(commonGroupChatMessage);
                        } catch (SQLiteException e4) {
                            e = e4;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                            a(str);
                            c.a.e.e.p.m.a(cursor);
                            return linkedList;
                        } catch (Exception e5) {
                            e = e5;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                            c.a.e.e.p.m.a(cursor);
                            return linkedList;
                        }
                    }
                }
                c.a.e.e.p.m.a(cursor);
                return linkedList;
            }
            if (TextUtils.isEmpty(str2)) {
                h2 = h.e().h("select * from " + str4 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i3, new String[]{String.valueOf(0)});
            } else {
                h2 = h.e().h("select * from " + str4 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i3, new String[]{str2, String.valueOf(0)});
            }
            cursor = h2;
            if (cursor != null) {
            }
            c.a.e.e.p.m.a(cursor);
            return linkedList;
        }
        return (LinkedList) invokeLLLI.objValue;
    }

    public long i(String str) {
        InterceptResult invokeL;
        long j2;
        Cursor h2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, str)) != null) {
            return invokeL.longValue;
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String str2 = "tb_group_msg_" + str;
        Cursor cursor = null;
        try {
            try {
                Cursor h3 = h.e().h("select max(mid) from " + str2, null);
                if (h3 != null) {
                    try {
                        if (h3.moveToNext()) {
                            j2 = h3.getLong(0);
                            h2 = h.e().h("select count(*) from " + str2, null);
                            if (((h2 == null && h2.moveToNext()) ? h2.getInt(0) : 0) == 1 || j2 % 100 == 0) {
                                c.a.e.e.p.m.a(h2);
                                return j2;
                            }
                            long a2 = c.a.r0.k1.w.b.a(j2);
                            c.a.e.e.p.m.a(h2);
                            return a2;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = h3;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        a(str);
                        c.a.e.e.p.m.a(cursor);
                        return 0L;
                    } catch (Exception e3) {
                        e = e3;
                        cursor = h3;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        c.a.e.e.p.m.a(cursor);
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        cursor = h3;
                        c.a.e.e.p.m.a(cursor);
                        throw th;
                    }
                }
                j2 = 0;
                h2 = h.e().h("select count(*) from " + str2, null);
                if (((h2 == null && h2.moveToNext()) ? h2.getInt(0) : 0) == 1) {
                }
                c.a.e.e.p.m.a(h2);
                return j2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Exception e5) {
            e = e5;
        }
    }

    public CommonMsgPojo j(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "tb_group_msg_" + str;
            try {
                try {
                    cursor = h.e().h("select * from " + str2 + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                        if (cursor != null && cursor.moveToNext()) {
                            commonMsgPojo.setGid(str);
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            c.a.e.e.p.m.a(cursor);
                            return commonMsgPojo;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        a(str);
                        c.a.e.e.p.m.a(cursor);
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        c.a.e.e.p.m.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = str2;
                    c.a.e.e.p.m.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.e.e.p.m.a(cursor2);
                throw th;
            }
            c.a.e.e.p.m.a(cursor);
            return null;
        }
        return (CommonMsgPojo) invokeL.objValue;
    }

    public int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = h.e().h("select count(*) from " + ("tb_group_msg_" + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                        if (cursor != null && cursor.moveToNext()) {
                            return cursor.getInt(0);
                        }
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getUnreadcount", new Object[0]);
                        e2.printStackTrace();
                    }
                } catch (SQLiteException e3) {
                    TiebaStatic.printDBExceptionLog(e3, "GroupMsgDao.getUnreadcount", new Object[0]);
                    e3.printStackTrace();
                }
                return 0;
            } finally {
                c.a.e.e.p.m.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff A[Catch: all -> 0x0103, Exception -> 0x0108, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0108, all -> 0x0103, blocks: (B:27:0x00d5, B:37:0x00ff), top: B:102:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019c A[Catch: all -> 0x024c, Exception -> 0x0251, TryCatch #9 {Exception -> 0x0251, all -> 0x024c, blocks: (B:34:0x00f7, B:43:0x010d, B:45:0x019c, B:48:0x01ac), top: B:108:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(String str, List<CommonMsgPojo> list, boolean z) {
        InterceptResult invokeLLZ;
        Cursor cursor;
        SQLiteStatement sQLiteStatement;
        Iterator<CommonMsgPojo> it;
        String str2;
        SQLiteStatement sQLiteStatement2;
        SQLiteStatement sQLiteStatement3;
        ContentValues contentValues;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(1048586, this, str, list, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        String str4 = "is_delete";
        String str5 = "read_flag";
        String str6 = "rid";
        if (list == null || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return false;
        }
        String str7 = "tb_group_msg_" + str;
        try {
            sQLiteStatement = h.e().a(" INSERT INTO " + str7 + "(content,create_time,ext,mid," + IMConstants.MSG_STATUS + ",msg_type,uid,user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            try {
                Iterator<CommonMsgPojo> it2 = list.iterator();
                while (it2.hasNext()) {
                    CommonMsgPojo next = it2.next();
                    try {
                        if (z) {
                            try {
                                if (next.isSelf() && next.getRid() != 0) {
                                    it = it2;
                                    str2 = str4;
                                    sQLiteStatement2 = sQLiteStatement;
                                    try {
                                        h.e().b(str7, "mid=?", new String[]{String.valueOf(next.getRid())});
                                        String str8 = "";
                                        if (next.getContent() == null) {
                                            next.setContent("");
                                        }
                                        contentValues = new ContentValues();
                                        contentValues.put("content", next.getContent());
                                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                        contentValues.put("ext", next.getExt());
                                        contentValues.put("mid", Long.valueOf(next.getMid()));
                                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                                        contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                                        contentValues.put("uid", next.getUid());
                                        contentValues.put("user_info", next.getUser_info());
                                        contentValues.put(str6, Long.valueOf(next.getRid()));
                                        contentValues.put(str5, Integer.valueOf(next.getRead_flag()));
                                        String str9 = str5;
                                        String str10 = str2;
                                        contentValues.put(str10, Integer.valueOf(next.getIs_delete()));
                                        String str11 = str6;
                                        if (h.e().j(str7, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                                            sQLiteStatement2.clearBindings();
                                            sQLiteStatement3 = sQLiteStatement2;
                                            try {
                                                sQLiteStatement3.bindString(1, TextUtils.isEmpty(next.getContent()) ? "" : next.getContent());
                                                str3 = str7;
                                                sQLiteStatement3.bindLong(2, next.getCreate_time());
                                                sQLiteStatement3.bindString(3, TextUtils.isEmpty(next.getExt()) ? "" : next.getExt());
                                                sQLiteStatement3.bindLong(4, next.getMid());
                                                sQLiteStatement3.bindLong(5, next.getMsg_status());
                                                sQLiteStatement3.bindLong(6, next.getMsg_type());
                                                sQLiteStatement3.bindString(7, TextUtils.isEmpty(next.getUid()) ? "" : next.getUid());
                                                if (!TextUtils.isEmpty(next.getUser_info())) {
                                                    str8 = next.getUser_info();
                                                }
                                                sQLiteStatement3.bindString(8, str8);
                                                sQLiteStatement3.bindLong(9, next.getRid());
                                                sQLiteStatement3.bindLong(10, next.getRead_flag());
                                                sQLiteStatement3.bindLong(11, next.getIs_delete());
                                                h.e().f(sQLiteStatement3);
                                            } catch (Exception e2) {
                                                e = e2;
                                                sQLiteStatement = sQLiteStatement3;
                                                try {
                                                    e.printStackTrace();
                                                    TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                                    c.a.e.e.p.m.a(null);
                                                    c.a.e.e.p.m.c(sQLiteStatement);
                                                    return false;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cursor = null;
                                                    c.a.e.e.p.m.a(cursor);
                                                    c.a.e.e.p.m.c(sQLiteStatement);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                sQLiteStatement = sQLiteStatement3;
                                                cursor = null;
                                                c.a.e.e.p.m.a(cursor);
                                                c.a.e.e.p.m.c(sQLiteStatement);
                                                throw th;
                                            }
                                        } else {
                                            str3 = str7;
                                            sQLiteStatement3 = sQLiteStatement2;
                                        }
                                        it2 = it;
                                        sQLiteStatement = sQLiteStatement3;
                                        str7 = str3;
                                        str4 = str10;
                                        str5 = str9;
                                        str6 = str11;
                                    } catch (Exception e3) {
                                        e = e3;
                                        sQLiteStatement = sQLiteStatement2;
                                        e.printStackTrace();
                                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                        c.a.e.e.p.m.a(null);
                                        c.a.e.e.p.m.c(sQLiteStatement);
                                        return false;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteStatement = sQLiteStatement2;
                                        cursor = null;
                                        c.a.e.e.p.m.a(cursor);
                                        c.a.e.e.p.m.c(sQLiteStatement);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        String str82 = "";
                        if (next.getContent() == null) {
                        }
                        contentValues = new ContentValues();
                        contentValues.put("content", next.getContent());
                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                        contentValues.put("ext", next.getExt());
                        contentValues.put("mid", Long.valueOf(next.getMid()));
                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                        contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                        contentValues.put("uid", next.getUid());
                        contentValues.put("user_info", next.getUser_info());
                        contentValues.put(str6, Long.valueOf(next.getRid()));
                        contentValues.put(str5, Integer.valueOf(next.getRead_flag()));
                        String str92 = str5;
                        String str102 = str2;
                        contentValues.put(str102, Integer.valueOf(next.getIs_delete()));
                        String str112 = str6;
                        if (h.e().j(str7, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                        }
                        it2 = it;
                        sQLiteStatement = sQLiteStatement3;
                        str7 = str3;
                        str4 = str102;
                        str5 = str92;
                        str6 = str112;
                    } catch (Exception e5) {
                        e = e5;
                        sQLiteStatement3 = sQLiteStatement2;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteStatement3 = sQLiteStatement2;
                    }
                    str2 = str4;
                    sQLiteStatement2 = sQLiteStatement;
                    it = it2;
                }
                c.a.e.e.p.m.a(null);
                c.a.e.e.p.m.c(sQLiteStatement);
                return true;
            } catch (Exception e6) {
                e = e6;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e7) {
            e = e7;
            sQLiteStatement = null;
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
            sQLiteStatement = null;
            c.a.e.e.p.m.a(cursor);
            c.a.e.e.p.m.c(sQLiteStatement);
            throw th;
        }
    }

    public boolean m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", (Integer) 1);
                h.e().j("tb_group_msg_" + str, contentValues, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean n(String str, int i2) {
        InterceptResult invokeLI;
        String str2;
        Cursor h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) {
            Cursor cursor = null;
            cursor = null;
            try {
                try {
                    str2 = "tb_group_msg_" + str;
                    if (i2 < 1000) {
                        i2 = 1000;
                    }
                    h2 = h.e().h("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i2 + ", 1", null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = h2.moveToNext() ? h2.getString(h2.getColumnIndex("mid")) : null;
                c.a.e.e.p.m.a(h2);
                if (string != null) {
                    h.e().b(str2, "mid<?", new String[]{string});
                }
                c.a.e.e.p.m.a(h2);
                return true;
            } catch (Exception e3) {
                e = e3;
                cursor = h2;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                c.a.e.e.p.m.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = h2;
                c.a.e.e.p.m.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean o(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048589, this, str, str2, str3, i2)) == null) {
            Boolean bool2 = Boolean.FALSE;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return false;
            }
            String str4 = "tb_group_msg_" + str;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", str3);
                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i2));
                if (h.e().j(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                bool2 = bool;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.updateState", new Object[0]);
                e2.printStackTrace();
            }
            return bool2.booleanValue();
        }
        return invokeLLLI.booleanValue;
    }
}
