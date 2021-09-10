package c.a.r0.i0.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import c.a.e.e.p.k;
import c.a.e.e.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Item;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.i0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0926a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f19129a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-398690713, "Lc/a/r0/i0/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-398690713, "Lc/a/r0/i0/b/a$a;");
                    return;
                }
            }
            f19129a = new a();
        }
    }

    public a() {
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

    public static final a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0926a.f19129a : (a) invokeV.objValue;
    }

    public final ContentValues a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, item)) == null) {
            if (item == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, item.apk_name);
            contentValues.put("download_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("item_info", g(item));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final b b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            b bVar = new b();
            bVar.f19130a = cursor.getString(cursor.getColumnIndex(EmotionResourceInfo.JSON_KEY_PKG_NAME));
            cursor.getLong(cursor.getColumnIndex("download_time"));
            bVar.f19132c = cursor.getString(cursor.getColumnIndex("item_info"));
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (k.isEmpty(str)) {
                    return false;
                }
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                int delete = f2.delete("download_info", "pkg_name = ?", new String[]{str});
                f2.setTransactionSuccessful();
                f2.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<b> d() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f2.rawQuery(String.format("SELECT * FROM %s ORDER BY %s DESC", "download_info", "download_time"), null);
                while (rawQuery.moveToNext()) {
                    b b2 = b(rawQuery);
                    if (b2 != null) {
                        linkedList.add(b2);
                    }
                }
                f2.setTransactionSuccessful();
                m.a(rawQuery);
                f2.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long f(SQLiteDatabase sQLiteDatabase, Item item) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, sQLiteDatabase, item)) == null) {
            try {
                return sQLiteDatabase.insert("download_info", null, a(item));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final String g(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, item)) == null) {
            if (item == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("item_id", item.item_id);
                jSONObject.put("item_name", item.item_name);
                jSONObject.put("icon_size", item.icon_size);
                jSONObject.put("icon_url", item.icon_url);
                if (!ListUtils.isEmpty(item.tags)) {
                    jSONObject.put(CommandMessage.TYPE_TAGS, new JSONArray((Collection) item.tags));
                }
                jSONObject.put("score", item.score);
                jSONObject.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, item.star);
                jSONObject.put("button_name", item.button_name);
                jSONObject.put("button_link", item.button_link);
                jSONObject.put("button_link_type", item.button_link_type);
                jSONObject.put("apk_name", item.apk_name);
                jSONObject.put("forum_name", item.forum_name);
                if (item.apk_detail != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("developer", item.apk_detail.developer);
                    jSONObject2.put("publisher", item.apk_detail.publisher);
                    jSONObject2.put("version", item.apk_detail.version);
                    jSONObject2.put("version_code", item.apk_detail.version_code);
                    jSONObject2.put("update_time", item.apk_detail.update_time);
                    jSONObject2.put("size", item.apk_detail.size);
                    jSONObject2.put("need_network", item.apk_detail.need_network);
                    jSONObject2.put("need_inner_buy", item.apk_detail.need_inner_buy);
                    jSONObject2.put("authority_url", item.apk_detail.authority_url);
                    jSONObject2.put("privacy_url", item.apk_detail.privacy_url);
                    jSONObject2.put("pkg_source", item.apk_detail.pkg_source);
                    jSONObject.put("apk_detail", jSONObject2);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, Item item) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, item)) == null) {
            try {
                return sQLiteDatabase.update("download_info", a(item), "pkg_name = ?", new String[]{String.valueOf(item.apk_name)});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(Item item) {
        InterceptResult invokeL;
        long f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, item)) == null) {
            synchronized (this) {
                if (item == null) {
                    return -1L;
                }
                SQLiteDatabase f3 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f3.beginTransaction();
                Cursor rawQuery = f3.rawQuery("SELECT * FROM download_info where pkg_name = ?", new String[]{item.apk_name});
                if (rawQuery.getCount() > 0) {
                    f2 = h(f3, item);
                } else {
                    f2 = f(f3, item);
                }
                f3.setTransactionSuccessful();
                m.a(rawQuery);
                f3.endTransaction();
                return f2;
            }
        }
        return invokeL.longValue;
    }
}
