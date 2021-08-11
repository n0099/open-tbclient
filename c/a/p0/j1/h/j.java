package c.a.p0.j1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static j f20468a;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    public static synchronized j f() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (j.class) {
                if (f20468a == null) {
                    synchronized (j.class) {
                        if (f20468a == null) {
                            f20468a = new j();
                        }
                    }
                }
                jVar = f20468a;
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_count", (Integer) 0);
        h.e().j("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i2)});
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? h.e().b("tb_message_center", "custom_group_type=? AND is_friend!=?", new String[]{String.valueOf(2), String.valueOf(1)}) : invokeV.booleanValue;
    }

    public boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            try {
                return h.e().b("tb_message_center", "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i2)});
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.deleteByGid", new Object[0]);
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public LinkedList<ImMessageCenterPojo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
            Cursor h2 = h.e().h("SELECT * FROM tb_message_center", null);
            if (h2 != null) {
                while (h2.moveToNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setPulled_msgId(c.a.e.e.m.b.f(h2.getString(h2.getColumnIndex("pull_msgid")), 0L));
                    imMessageCenterPojo.setGid(h2.getString(h2.getColumnIndex("gid")));
                    imMessageCenterPojo.setGroup_name(h2.getString(h2.getColumnIndex("group_name")));
                    imMessageCenterPojo.setNameShow(h2.getString(h2.getColumnIndex("group_name_show")));
                    imMessageCenterPojo.setGroup_head(h2.getString(h2.getColumnIndex("group_head")));
                    imMessageCenterPojo.setCustomGroupType(h2.getInt(h2.getColumnIndex("custom_group_type")));
                    imMessageCenterPojo.setIsFriend(h2.getInt(h2.getColumnIndex("is_friend")));
                    imMessageCenterPojo.setUnread_count(h2.getInt(h2.getColumnIndex("unread_count")));
                    imMessageCenterPojo.setLast_rid(h2.getLong(h2.getColumnIndex("last_msgId")));
                    imMessageCenterPojo.setLast_user_name(h2.getString(h2.getColumnIndex("last_user_name")));
                    imMessageCenterPojo.setLast_content_time(h2.getLong(h2.getColumnIndex("last_content_time")));
                    imMessageCenterPojo.setSend_status(h2.getInt(h2.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                    imMessageCenterPojo.setLast_content(h2.getString(h2.getColumnIndex("last_content")));
                    imMessageCenterPojo.setPulled_msgId(h2.getLong(h2.getColumnIndex("pull_msgid")));
                    imMessageCenterPojo.setIs_hidden(h2.getInt(h2.getColumnIndex("is_hidden")));
                    imMessageCenterPojo.setSent_msgId(h2.getLong(h2.getColumnIndex("sent_mid")));
                    imMessageCenterPojo.setRead_msgId(h2.getLong(h2.getColumnIndex("read_mid")));
                    imMessageCenterPojo.setUserType(h2.getInt(h2.getColumnIndex("user_type")));
                    imMessageCenterPojo.setSid(h2.getLong(h2.getColumnIndex("sid")));
                    imMessageCenterPojo.setTaskId(h2.getString(h2.getColumnIndex("task_id")));
                    imMessageCenterPojo.setServiceId(h2.getString(h2.getColumnIndex("service_id")));
                    imMessageCenterPojo.setPushIds(h2.getString(h2.getColumnIndex("ext1")));
                    n(imMessageCenterPojo, h2.getString(h2.getColumnIndex("ext2")));
                    linkedList.add(imMessageCenterPojo);
                }
            }
            c.a.e.e.p.m.a(h2);
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public LinkedList<ImMessageCenterPojo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
            Cursor h2 = h.e().h("SELECT * FROM tb_message_center", null);
            if (h2 != null) {
                while (h2.moveToNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setPulled_msgId(c.a.e.e.m.b.f(h2.getString(h2.getColumnIndex("pull_msgid")), 0L));
                    imMessageCenterPojo.setGid(h2.getString(h2.getColumnIndex("gid")));
                    imMessageCenterPojo.setGroup_name(h2.getString(h2.getColumnIndex("group_name")));
                    imMessageCenterPojo.setNameShow(h2.getString(h2.getColumnIndex("group_name_show")));
                    imMessageCenterPojo.setGroup_head(h2.getString(h2.getColumnIndex("group_head")));
                    imMessageCenterPojo.setCustomGroupType(h2.getInt(h2.getColumnIndex("custom_group_type")));
                    imMessageCenterPojo.setIsFriend(h2.getInt(h2.getColumnIndex("is_friend")));
                    imMessageCenterPojo.setUnread_count(h2.getInt(h2.getColumnIndex("unread_count")));
                    imMessageCenterPojo.setLast_rid(h2.getLong(h2.getColumnIndex("last_msgId")));
                    imMessageCenterPojo.setLast_user_name(h2.getString(h2.getColumnIndex("last_user_name")));
                    imMessageCenterPojo.setLast_content_time(h2.getLong(h2.getColumnIndex("last_content_time")));
                    imMessageCenterPojo.setSend_status(h2.getInt(h2.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                    imMessageCenterPojo.setLast_content(h2.getString(h2.getColumnIndex("last_content")));
                    imMessageCenterPojo.setPulled_msgId(h2.getLong(h2.getColumnIndex("pull_msgid")));
                    imMessageCenterPojo.setIs_hidden(h2.getInt(h2.getColumnIndex("is_hidden")));
                    n(imMessageCenterPojo, h2.getString(h2.getColumnIndex("ext2")));
                    linkedList.add(imMessageCenterPojo);
                }
            }
            c.a.e.e.p.m.a(h2);
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public ImMessageCenterPojo g(String str, int i2) {
        InterceptResult invokeLI;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) != null) {
            return (ImMessageCenterPojo) invokeLI.objValue;
        }
        Cursor cursor = null;
        r2 = null;
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        cursor = null;
        try {
            try {
                Cursor h2 = h.e().h("select * from tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i2)});
                if (h2 != null) {
                    try {
                        try {
                            if (h2.moveToNext()) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                try {
                                    imMessageCenterPojo.setPulled_msgId(c.a.e.e.m.b.f(h2.getString(h2.getColumnIndex("pull_msgid")), 0L));
                                    imMessageCenterPojo.setGid(h2.getString(h2.getColumnIndex("gid")));
                                    imMessageCenterPojo.setGroup_name(h2.getString(h2.getColumnIndex("group_name")));
                                    imMessageCenterPojo.setNameShow(h2.getString(h2.getColumnIndex("group_name_show")));
                                    imMessageCenterPojo.setGroup_head(h2.getString(h2.getColumnIndex("group_head")));
                                    imMessageCenterPojo.setCustomGroupType(h2.getInt(h2.getColumnIndex("custom_group_type")));
                                    imMessageCenterPojo.setIsFriend(h2.getInt(h2.getColumnIndex("is_friend")));
                                    imMessageCenterPojo.setUnread_count(h2.getInt(h2.getColumnIndex("unread_count")));
                                    imMessageCenterPojo.setLast_rid(h2.getLong(h2.getColumnIndex("last_msgId")));
                                    imMessageCenterPojo.setLast_user_name(h2.getString(h2.getColumnIndex("last_user_name")));
                                    imMessageCenterPojo.setLast_content_time(h2.getLong(h2.getColumnIndex("last_content_time")));
                                    imMessageCenterPojo.setSend_status(h2.getInt(h2.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                                    imMessageCenterPojo.setLast_content(h2.getString(h2.getColumnIndex("last_content")));
                                    imMessageCenterPojo.setPulled_msgId(h2.getLong(h2.getColumnIndex("pull_msgid")));
                                    imMessageCenterPojo.setIs_hidden(h2.getInt(h2.getColumnIndex("is_hidden")));
                                    imMessageCenterPojo.setSent_msgId(h2.getLong(h2.getColumnIndex("sent_mid")));
                                    imMessageCenterPojo.setRead_msgId(h2.getLong(h2.getColumnIndex("read_mid")));
                                    imMessageCenterPojo.setUserType(h2.getInt(h2.getColumnIndex("user_type")));
                                    imMessageCenterPojo.setSid(h2.getLong(h2.getColumnIndex("sid")));
                                    imMessageCenterPojo.setTaskId(h2.getString(h2.getColumnIndex("task_id")));
                                    imMessageCenterPojo.setServiceId(h2.getString(h2.getColumnIndex("service_id")));
                                    imMessageCenterPojo.setPushIds(h2.getString(h2.getColumnIndex("ext1")));
                                    n(imMessageCenterPojo, h2.getString(h2.getColumnIndex("ext2")));
                                    imMessageCenterPojo2 = imMessageCenterPojo;
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor = h2;
                                    e.printStackTrace();
                                    TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getGroupInfo", new Object[0]);
                                    c.a.e.e.p.m.a(cursor);
                                    return imMessageCenterPojo;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = h2;
                            c.a.e.e.p.m.a(cursor);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        imMessageCenterPojo = null;
                    }
                }
                c.a.e.e.p.m.a(h2);
                return imMessageCenterPojo2;
            } catch (Exception e4) {
                e = e4;
                imMessageCenterPojo = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public LinkedList<ImMessageCenterPojo> h() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return (LinkedList) invokeV.objValue;
        }
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor cursor2 = null;
        try {
            cursor = h.e().h("SELECT * FROM tb_message_center WHERE  custom_group_type IN (?,?,?,?,?)", new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(4), String.valueOf(-2)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                            linkedList.add(imMessageCenterPojo);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getShrinkData", new Object[0]);
                            c.a.e.e.p.m.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        c.a.e.e.p.m.a(cursor2);
                        throw th;
                    }
                }
            }
            c.a.e.e.p.m.a(cursor);
            return linkedList;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            c.a.e.e.p.m.a(cursor2);
            throw th;
        }
    }

    public final void i(ContentValues contentValues, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, contentValues, imMessageCenterPojo) == null) || contentValues == null || imMessageCenterPojo == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                jSONObject.put("bjhAvatar", imMessageCenterPojo.getBjhAvatar());
            }
            contentValues.put("ext2", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void j(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo) == null) {
            k(imMessageCenterPojo, 1);
        }
    }

    public void k(ImMessageCenterPojo imMessageCenterPojo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, imMessageCenterPojo, i2) == null) {
            l(imMessageCenterPojo, i2, 1);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x00ab */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x00f5 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v6, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(ImMessageCenterPojo imMessageCenterPojo, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048586, this, imMessageCenterPojo, i2, i3) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("gid", imMessageCenterPojo.getGid());
        contentValues.put("sid", Long.valueOf(imMessageCenterPojo.getSid()));
        contentValues.put("task_id", imMessageCenterPojo.getTaskId());
        contentValues.put("service_id", imMessageCenterPojo.getServiceId());
        if (i3 == 2) {
            contentValues.put("ext1", imMessageCenterPojo.getPushIds());
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
            contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
            contentValues.put("group_name_show", imMessageCenterPojo.getNameShow());
        }
        i(contentValues, imMessageCenterPojo);
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
            contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
        }
        contentValues.put("custom_group_type", Integer.valueOf(imMessageCenterPojo.getCustomGroupType()));
        int unread_count = imMessageCenterPojo.getUnread_count();
        Cursor cursor = null;
        if (i2 == 2) {
            contentValues.put("unread_count", Integer.valueOf(unread_count));
        } else if (i2 == 3) {
            try {
                if (unread_count > 0) {
                    try {
                        i2 = h.e().h("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                    } catch (Exception e2) {
                        e = e2;
                        i2 = 0;
                    } catch (Throwable th) {
                        th = th;
                        c.a.e.e.p.m.a(cursor);
                        throw th;
                    }
                    if (i2 != 0) {
                        try {
                        } catch (Exception e3) {
                            e = e3;
                            i2 = i2;
                            BdLog.e(e);
                            c.a.e.e.p.m.a(i2);
                            contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
                            if (imMessageCenterPojo.getLast_user_name() != null) {
                            }
                            if (imMessageCenterPojo.getLast_content_time() != 0) {
                            }
                            if (imMessageCenterPojo.getLast_content() != null) {
                            }
                            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
                            contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                            contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
                            if (imMessageCenterPojo.getPulled_msgId() != 0) {
                            }
                            if (imMessageCenterPojo.getSent_msgId() > 0) {
                            }
                            if (imMessageCenterPojo.getRead_msgId() > 0) {
                            }
                            contentValues.put("user_type", Integer.valueOf(imMessageCenterPojo.getUserType()));
                            BdLog.i("sql-" + contentValues);
                            if (h.e().j("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                            }
                        }
                        if (i2.moveToNext()) {
                            int i4 = unread_count + i2.getInt(i2.getColumnIndex("unread_count"));
                            if (i4 > 0) {
                                contentValues.put("unread_count", Integer.valueOf(i4));
                            }
                            c.a.e.e.p.m.a(i2);
                        }
                    }
                    contentValues.put("unread_count", Integer.valueOf(unread_count));
                    c.a.e.e.p.m.a(i2);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = i2;
            }
        }
        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
        if (imMessageCenterPojo.getLast_user_name() != null) {
            contentValues.put("last_user_name", imMessageCenterPojo.getLast_user_name());
        }
        if (imMessageCenterPojo.getLast_content_time() != 0) {
            contentValues.put("last_content_time", Long.valueOf(imMessageCenterPojo.getLast_content_time()));
        }
        if (imMessageCenterPojo.getLast_content() != null) {
            contentValues.put("last_content", imMessageCenterPojo.getLast_content());
        }
        contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
        if (imMessageCenterPojo.getPulled_msgId() != 0) {
            contentValues.put("pull_msgid", Long.valueOf(imMessageCenterPojo.getPulled_msgId()));
        }
        if (imMessageCenterPojo.getSent_msgId() > 0) {
            contentValues.put("sent_mid", Long.valueOf(imMessageCenterPojo.getSent_msgId()));
        }
        if (imMessageCenterPojo.getRead_msgId() > 0) {
            contentValues.put("read_mid", Long.valueOf(imMessageCenterPojo.getRead_msgId()));
        }
        contentValues.put("user_type", Integer.valueOf(imMessageCenterPojo.getUserType()));
        BdLog.i("sql-" + contentValues);
        if (h.e().j("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
            BdLog.i("insert");
            h.e().g("tb_message_center", null, contentValues);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(ImMessageCenterPojo imMessageCenterPojo, int i2) {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, imMessageCenterPojo, i2) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("gid", imMessageCenterPojo.getGid());
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
            contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
            contentValues.put("group_name_show", imMessageCenterPojo.getNameShow());
        }
        i(contentValues, imMessageCenterPojo);
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
            contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
        }
        contentValues.put("custom_group_type", Integer.valueOf(imMessageCenterPojo.getCustomGroupType()));
        int unread_count = imMessageCenterPojo.getUnread_count();
        Cursor cursor2 = null;
        if (i2 == 2) {
            contentValues.put("unread_count", Integer.valueOf(unread_count));
        } else if (i2 == 3 && unread_count > 0) {
            try {
                cursor = h.e().h("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                c.a.e.e.p.m.a(cursor2);
                throw th;
            }
            if (cursor != null) {
                try {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        BdLog.e(e);
                        c.a.e.e.p.m.a(cursor);
                        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
                        if (imMessageCenterPojo.getLast_user_name() != null) {
                        }
                        if (imMessageCenterPojo.getLast_content_time() != 0) {
                        }
                        if (imMessageCenterPojo.getLast_content() != null) {
                        }
                        contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
                        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
                        if (imMessageCenterPojo.getPulled_msgId() != 0) {
                        }
                        BdLog.i("sql-" + contentValues);
                        if (h.e().j("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                        }
                    }
                    if (cursor.moveToNext()) {
                        int i3 = unread_count + cursor.getInt(cursor.getColumnIndex("unread_count"));
                        if (i3 > 0) {
                            contentValues.put("unread_count", Integer.valueOf(i3));
                        }
                        c.a.e.e.p.m.a(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    c.a.e.e.p.m.a(cursor2);
                    throw th;
                }
            }
            contentValues.put("unread_count", Integer.valueOf(unread_count));
            c.a.e.e.p.m.a(cursor);
        }
        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
        if (imMessageCenterPojo.getLast_user_name() != null) {
            contentValues.put("last_user_name", imMessageCenterPojo.getLast_user_name());
        }
        if (imMessageCenterPojo.getLast_content_time() != 0) {
            contentValues.put("last_content_time", Long.valueOf(imMessageCenterPojo.getLast_content_time()));
        }
        if (imMessageCenterPojo.getLast_content() != null) {
            contentValues.put("last_content", imMessageCenterPojo.getLast_content());
        }
        contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
        if (imMessageCenterPojo.getPulled_msgId() != 0) {
            contentValues.put("pull_msgid", Long.valueOf(imMessageCenterPojo.getPulled_msgId()));
        }
        BdLog.i("sql-" + contentValues);
        if (h.e().j("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
            BdLog.i("insert");
            h.e().g("tb_message_center", null, contentValues);
        }
    }

    public final void n(ImMessageCenterPojo imMessageCenterPojo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, imMessageCenterPojo, str) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            imMessageCenterPojo.setBjhAvatar(new JSONObject(str).optString("bjhAvatar", null));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
