package c.a.p0.l3.g0.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c.a.d.f.p.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.l3.g0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1211a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(704279877, "Lc/a/p0/l3/g0/n/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(704279877, "Lc/a/p0/l3/g0/n/a$a;");
                    return;
                }
            }
            a = new a();
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C1211a.a : (a) invokeV.objValue;
    }

    public final ContentValues a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.a)) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("download_key", bVar.a);
            contentValues.put("package_name", bVar.f16174b);
            contentValues.put("finish_download_time", String.valueOf(bVar.f16175c));
            contentValues.put("show_times", String.valueOf(bVar.f16176d));
            contentValues.put("last_show_time", String.valueOf(bVar.f16177e));
            contentValues.put("ad_string", bVar.f16178f);
            contentValues.put("cmatch", bVar.f16179g);
            contentValues.put("install_status", Integer.valueOf(bVar.f16180h));
            contentValues.put("ad_extension_info1", bVar.i);
            contentValues.put("ad_extension_info2", bVar.j);
            contentValues.put("ad_extension_info3", bVar.k);
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final b b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                try {
                    b bVar = new b();
                    bVar.a = cursor.getString(cursor.getColumnIndex("download_key"));
                    bVar.f16174b = cursor.getString(cursor.getColumnIndex("package_name"));
                    bVar.f16175c = Long.parseLong(cursor.getString(cursor.getColumnIndex("finish_download_time")));
                    bVar.f16176d = Integer.parseInt(cursor.getString(cursor.getColumnIndex("show_times")));
                    bVar.f16177e = Long.parseLong(cursor.getString(cursor.getColumnIndex("last_show_time")));
                    bVar.f16178f = cursor.getString(cursor.getColumnIndex("ad_string"));
                    bVar.f16179g = cursor.getString(cursor.getColumnIndex("cmatch"));
                    bVar.f16180h = Integer.parseInt(cursor.getString(cursor.getColumnIndex("install_status")));
                    bVar.i = cursor.getString(cursor.getColumnIndex("ad_extension_info1"));
                    bVar.j = cursor.getString(cursor.getColumnIndex("ad_extension_info2"));
                    bVar.k = cursor.getString(cursor.getColumnIndex("ad_extension_info3"));
                    return bVar;
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public synchronized void c(Integer num, Integer num2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, num, num2) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                f2.delete("ad_follow_up_info_table", "finish_download_time < ? and show_times >= ?", new String[]{String.valueOf(System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000)), String.valueOf(num2)});
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
        }
    }

    public synchronized void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                f2.delete("ad_follow_up_info_table", "download_key = ?", new String[]{str});
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
        }
    }

    public synchronized List<b> f(Integer num, Integer num2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, num, num2)) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                long currentTimeMillis = System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000);
                arrayList = new ArrayList();
                Cursor rawQuery = f2.rawQuery("SELECT * FROM ad_follow_up_info_table where finish_download_time > ? and show_times < ? and install_status = ? order by finish_download_time desc", new String[]{String.valueOf(currentTimeMillis), String.valueOf(num2), String.valueOf(1)});
                while (rawQuery.moveToNext()) {
                    b b2 = b(rawQuery);
                    if (b2 != null && !arrayList.contains(b2)) {
                        arrayList.add(b2);
                    }
                }
                f2.setTransactionSuccessful();
                o.a(rawQuery);
                f2.endTransaction();
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public synchronized void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            synchronized (this) {
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.a) && !TextUtils.isEmpty(bVar.f16174b)) {
                        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                        f2.beginTransaction();
                        f2.replace("ad_follow_up_info_table", null, a(bVar));
                        f2.setTransactionSuccessful();
                        f2.endTransaction();
                    }
                }
            }
        }
    }
}
