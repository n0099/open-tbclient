package b.a.r0.t.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import b.a.e.f.p.m;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static f f25104a;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    public static f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (f.class) {
                if (f25104a == null) {
                    f25104a = new f();
                }
            }
            return f25104a;
        }
        return (f) invokeV.objValue;
    }

    public boolean a(b.a.q0.t.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            SQLiteDatabase b2 = h.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b2 != null && aVar != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c2 = c(aVar);
                    if (b2.update("table_" + currentAccount, c2, "id = ?", new String[]{String.valueOf(aVar.e())}) == 0) {
                        b2.insert("table_" + currentAccount, null, c2);
                    }
                    return true;
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.addContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            synchronized (this) {
                SQLiteDatabase b2 = h.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b2 != null && aVar != null && !TextUtils.isEmpty(currentAccount)) {
                    b2.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b2.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b2.beginTransaction();
                    try {
                        for (e eVar : aVar.a()) {
                            for (b.a.q0.t.f.a aVar2 : eVar.a()) {
                                ContentValues c2 = c(aVar2);
                                b2.insert("table_" + currentAccount, null, c2);
                            }
                        }
                        b2.setTransactionSuccessful();
                        b2.endTransaction();
                        return true;
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                        TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.addContactItems", new Object[0]);
                        b2.endTransaction();
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final ContentValues c(b.a.q0.t.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", aVar.f());
            contentValues.put("id", Long.valueOf(aVar.e()));
            contentValues.put("user_type", Integer.valueOf(aVar.i()));
            contentValues.put("portrait", aVar.h());
            contentValues.put("quanpin", aVar.d());
            contentValues.put("first_letter", aVar.a());
            contentValues.put("name_show", aVar.g());
            if (aVar.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(aVar.b().b()));
                contentValues.put("location_distance", aVar.b().a());
                contentValues.put("location_time", Long.valueOf(aVar.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SQLiteDatabase b2 = h.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b2 != null && j >= 0 && !TextUtils.isEmpty(currentAccount)) {
                try {
                    b2.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
                    return true;
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.deleteContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public synchronized List<b.a.q0.t.f.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b2 = h.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b2 != null && !TextUtils.isEmpty(currentAccount)) {
                    b2.beginTransaction();
                    char c2 = 0;
                    try {
                        String[] strArr = b.a.q0.t.f.c.f14779a;
                        int length = strArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            String str = strArr[i2];
                            ArrayList arrayList2 = new ArrayList();
                            b.a.q0.t.f.a aVar = new b.a.q0.t.f.a();
                            aVar.k(str);
                            arrayList2.add(aVar);
                            String[] strArr2 = new String[1];
                            strArr2[c2] = str;
                            cursor = b2.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    b.a.q0.t.f.a aVar2 = new b.a.q0.t.f.a();
                                    aVar2.k(str);
                                    aVar2.o(cursor.getString(cursor.getColumnIndex("name")));
                                    aVar2.p(cursor.getString(cursor.getColumnIndex("name_show")));
                                    aVar2.n(cursor.getLong(cursor.getColumnIndex("id")));
                                    aVar2.r(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    aVar2.q(cursor.getString(cursor.getColumnIndex("portrait")));
                                    aVar2.m(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    aVar2.l(new b.a.q0.t.f.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(aVar2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            m.a(cursor);
                            i2++;
                            c2 = 0;
                        }
                        b2.setTransactionSuccessful();
                        m.a(cursor);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                        TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.getContactList", new Object[0]);
                        m.a(cursor);
                    }
                    b2.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized ArrayList<b.a.q0.t.f.a> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b2 = h.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<b.a.q0.t.f.a> arrayList = new ArrayList<>();
                if (b2 != null && !TextUtils.isEmpty(currentAccount)) {
                    b2.beginTransaction();
                    char c2 = 0;
                    try {
                        String[] strArr = b.a.q0.t.f.c.f14779a;
                        int length = strArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            String str = strArr[i2];
                            ArrayList arrayList2 = new ArrayList();
                            b.a.q0.t.f.a aVar = new b.a.q0.t.f.a();
                            aVar.k(str);
                            arrayList2.add(aVar);
                            String[] strArr2 = new String[2];
                            strArr2[c2] = str;
                            strArr2[1] = "1";
                            cursor = b2.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    b.a.q0.t.f.a aVar2 = new b.a.q0.t.f.a();
                                    aVar2.k(str);
                                    aVar2.o(cursor.getString(cursor.getColumnIndex("name")));
                                    aVar2.p(cursor.getString(cursor.getColumnIndex("name_show")));
                                    aVar2.n(cursor.getLong(cursor.getColumnIndex("id")));
                                    aVar2.r(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    aVar2.q(cursor.getString(cursor.getColumnIndex("portrait")));
                                    aVar2.m(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    aVar2.l(new b.a.q0.t.f.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(aVar2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            m.a(cursor);
                            i2++;
                            c2 = 0;
                        }
                        b2.setTransactionSuccessful();
                        m.a(cursor);
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                        TiebaStatic.printDBExceptionLog(e2, "RelationshipDao.getOfficialAccountList", new Object[0]);
                        m.a(cursor);
                    }
                    b2.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (ArrayList) invokeV.objValue;
    }
}
