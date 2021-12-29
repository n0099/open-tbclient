package c.a.t0.s1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = new d();
            }
            return a;
        }
        return (d) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                h.d().delete("tb_group_news", "notice_id = ?", new String[]{str});
                bool = Boolean.TRUE;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.deleteByNoticeId", new Object[0]);
                e2.printStackTrace();
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public boolean b(List<UpdatesItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            Boolean bool = Boolean.FALSE;
            if (list == null || list.isEmpty()) {
                return false;
            }
            try {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    UpdatesItemData updatesItemData = list.get(i2);
                    if (updatesItemData != null) {
                        h.d().delete("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                    }
                }
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
                e2.printStackTrace();
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public LinkedList<GroupNewsPojo> c(long j2, int i2, int i3, String str) {
        InterceptResult invokeCommon;
        Cursor e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str})) == null) {
            if (i3 < 0) {
                i3 = 0;
            }
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            if (i2 <= 0) {
                i2 = 20;
            }
            Cursor cursor = null;
            try {
                try {
                    if (j2 <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            e2 = h.d().e("select * from tb_group_news ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, null);
                        } else {
                            e2 = h.d().e(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, str), null);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        e2 = h.d().e("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, new String[]{String.valueOf(j2)});
                    } else {
                        e2 = h.d().e("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, new String[]{String.valueOf(j2), str});
                    }
                    cursor = e2;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            linkedList.add(groupNewsPojo);
                        }
                    }
                } catch (Exception e3) {
                    TiebaStatic.printDBExceptionLog(e3, "GroupNewsDao.getAllByCmd", new Object[0]);
                    e3.printStackTrace();
                }
                o.a(cursor);
                return m(linkedList);
            } catch (Throwable th) {
                o.a(cursor);
                throw th;
            }
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public GroupNewsPojo d(String str) {
        InterceptResult invokeL;
        GroupNewsPojo groupNewsPojo;
        Exception e2;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (GroupNewsPojo) invokeL.objValue;
        }
        Cursor cursor2 = null;
        r1 = null;
        GroupNewsPojo groupNewsPojo2 = null;
        try {
            cursor = h.d().e("select * from tb_group_news WHERE notice_id = ?", new String[]{str});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            groupNewsPojo = new GroupNewsPojo();
                            try {
                                groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                                groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                                groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                                groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                                groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                                groupNewsPojo2 = groupNewsPojo;
                            } catch (Exception e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getByNoticeId", new Object[0]);
                                o.a(cursor);
                                return groupNewsPojo;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            o.a(cursor2);
                            throw th;
                        }
                    } catch (Exception e4) {
                        groupNewsPojo = groupNewsPojo2;
                        e2 = e4;
                    }
                }
            }
            o.a(cursor);
            return groupNewsPojo2;
        } catch (Exception e5) {
            groupNewsPojo = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            o.a(cursor2);
            throw th;
        }
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Cursor cursor = null;
            int i2 = 0;
            try {
                try {
                    cursor = h.d().e(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str), null);
                    i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                } catch (SQLiteException e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e2.printStackTrace();
                } catch (Exception e3) {
                    TiebaStatic.printDBExceptionLog(e3, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e3.printStackTrace();
                }
                return i2;
            } finally {
                o.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public int g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            Cursor cursor = null;
            int i3 = 0;
            try {
                try {
                    try {
                        cursor = h.d().e(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i2), null);
                        i3 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                        e2.printStackTrace();
                    }
                } catch (SQLiteException e3) {
                    TiebaStatic.printDBExceptionLog(e3, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e3.printStackTrace();
                }
                return i3;
            } finally {
                o.a(cursor);
            }
        }
        return invokeLI.intValue;
    }

    public int h(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content_status", (Integer) 3);
                    return h.d().update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
                }
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
                e2.printStackTrace();
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public final long i(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, groupNewsPojo)) == null) {
            try {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("INSERT INTO ");
                    stringBuffer.append("tb_group_news");
                    stringBuffer.append("(");
                    stringBuffer.append("cmd");
                    stringBuffer.append(",");
                    stringBuffer.append("content");
                    stringBuffer.append(",");
                    stringBuffer.append("content_status");
                    stringBuffer.append(",");
                    stringBuffer.append("ext");
                    stringBuffer.append(",");
                    stringBuffer.append("gid");
                    stringBuffer.append(",");
                    stringBuffer.append("notice_id");
                    stringBuffer.append(",");
                    stringBuffer.append("time");
                    stringBuffer.append(") VALUES(?,?,?,?,?,?,?)");
                    SQLiteStatement a2 = h.d().a(stringBuffer.toString());
                    if (a2 == null) {
                        o.c(a2);
                        return -1L;
                    }
                    a2.clearBindings();
                    f.b(a2, 1, groupNewsPojo.getCmd());
                    f.b(a2, 2, groupNewsPojo.getContent());
                    a2.bindLong(3, groupNewsPojo.getContent_status());
                    f.b(a2, 4, groupNewsPojo.getExt());
                    f.b(a2, 5, groupNewsPojo.getGid());
                    f.b(a2, 6, groupNewsPojo.getNotice_id());
                    a2.bindLong(7, groupNewsPojo.getTime());
                    long executeInsert = a2.executeInsert();
                    o.c(a2);
                    return executeInsert;
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.insertByStatement", new Object[0]);
                    o.c(null);
                    return -1L;
                }
            } catch (Throwable th) {
                o.c(null);
                throw th;
            }
        }
        return invokeL.longValue;
    }

    public boolean j(ValidateItemData validateItemData) {
        InterceptResult invokeL;
        List<ValidateItemData> convertToValidateItemDataList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, validateItemData)) == null) {
            if (validateItemData == null || ModelHelper.getInstance().getValidateModel() == null || (convertToValidateItemDataList = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(c(0L, Integer.MAX_VALUE, 0, "apply_join_group"))) == null || convertToValidateItemDataList.size() == 0) {
                return false;
            }
            int size = convertToValidateItemDataList.size();
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ValidateItemData validateItemData2 = convertToValidateItemDataList.get(i3);
                if (validateItemData2.getGroupId().equals(validateItemData.getGroupId()) && validateItemData2.getUserId().equals(validateItemData.getUserId()) && validateItemData.isPass()) {
                    validateItemData2.setPass(true);
                    if (validateItemData.isShown()) {
                        validateItemData2.setShown(true);
                    }
                    linkedList.add(validateItemData2.toGroupNewsPojo());
                    i2++;
                }
            }
            BdLog.i("affectCount:" + i2);
            return n(linkedList).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 2);
                h.d().update("tb_group_news", contentValues, "cmd=?", new String[]{str});
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.markReadByCmd", new Object[0]);
                e2.printStackTrace();
            }
        }
    }

    public boolean l(String str, int i2) {
        InterceptResult invokeLI;
        Cursor e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i2)) == null) {
            Cursor cursor = null;
            cursor = null;
            if (i2 < 1000) {
                i2 = 1000;
            }
            try {
                try {
                    h d2 = h.d();
                    e2 = d2.e("SELECT * FROM tb_group_news ORDER BY notice_id DESC LIMIT " + i2 + ", 1", null);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = e2.moveToNext() ? e2.getString(e2.getColumnIndex("notice_id")) : null;
                o.a(e2);
                if (string != null) {
                    h.d().delete("tb_group_news", "notice_id<?", new String[]{string});
                }
                o.a(e2);
                return true;
            } catch (Exception e4) {
                e = e4;
                cursor = e2;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                o.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = e2;
                o.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public final LinkedList<GroupNewsPojo> m(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, linkedList)) == null) {
            LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                GroupNewsPojo groupNewsPojo = linkedList.get(i2);
                boolean z = false;
                for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                    if (linkedList2.get(i3).getContent().equals(groupNewsPojo.getContent())) {
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(groupNewsPojo.getNotice_id());
                } else {
                    linkedList2.add(groupNewsPojo);
                }
                int size2 = arrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    h((String) arrayList.get(i4), 3);
                }
            }
            return linkedList2;
        }
        return (LinkedList) invokeL.objValue;
    }

    public Boolean n(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, linkedList)) == null) {
            Boolean bool = Boolean.FALSE;
            if (linkedList != null && linkedList.size() != 0) {
                try {
                    try {
                        h.d().f();
                        Iterator<GroupNewsPojo> it = linkedList.iterator();
                        LinkedList<GroupNewsPojo> linkedList2 = null;
                        List<ValidateItemData> list = null;
                        while (it.hasNext()) {
                            GroupNewsPojo next = it.next();
                            if (next.getCmd().equals("apply_join_group")) {
                                if (linkedList2 == null) {
                                    linkedList2 = c(0L, Integer.MAX_VALUE, 0, "apply_join_group");
                                    if (ModelHelper.getInstance().getValidateModel() != null) {
                                        list = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(linkedList2);
                                    }
                                    if (list == null) {
                                        list = new LinkedList<>();
                                    }
                                }
                                if (list != null) {
                                    ValidateItemData convertToValidateItemData = ModelHelper.getInstance().getValidateModel() != null ? ModelHelper.getInstance().getValidateModel().convertToValidateItemData(next) : null;
                                    if (convertToValidateItemData != null) {
                                        for (ValidateItemData validateItemData : list) {
                                            if (convertToValidateItemData.getUserId() != null && convertToValidateItemData.getUserId().equals(validateItemData.getUserId()) && convertToValidateItemData.getGroupId() != null && convertToValidateItemData.getGroupId().equals(validateItemData.getGroupId())) {
                                                a(validateItemData.getNotice_id());
                                            }
                                        }
                                    }
                                }
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("cmd", next.getCmd());
                            contentValues.put("content", next.getContent());
                            contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put("gid", next.getGid());
                            contentValues.put("notice_id", next.getNotice_id());
                            contentValues.put("time", Long.valueOf(next.getTime()));
                            if (h.d().update("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                                i(next);
                            }
                            bool = Boolean.valueOf(bool.booleanValue() & true);
                        }
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.updateData", new Object[0]);
                        e2.printStackTrace();
                        bool = Boolean.FALSE;
                    }
                    return bool;
                } finally {
                    h.d().b();
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }
}
