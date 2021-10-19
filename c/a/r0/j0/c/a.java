package c.a.r0.j0.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import c.a.e.e.p.k;
import c.a.e.e.p.m;
import c.a.q0.u.d;
import c.a.r0.j0.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.data.ItemData;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.j0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0933a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f19313a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117451271, "Lc/a/r0/j0/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2117451271, "Lc/a/r0/j0/c/a$a;");
                    return;
                }
            }
            f19313a = new a();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0933a.f19313a : (a) invokeV.objValue;
    }

    public final ContentValues a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, bVar.f19309e.pkgName);
            contentValues.put("download_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("item_info", g(bVar.f19309e));
            contentValues.put("item_source", Integer.valueOf(bVar.f19310f));
            contentValues.put("storage_location", Integer.valueOf(bVar.f19311g));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final d b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            d dVar = new d();
            dVar.f15046a = cursor.getString(cursor.getColumnIndex(EmotionResourceInfo.JSON_KEY_PKG_NAME));
            cursor.getLong(cursor.getColumnIndex("download_time"));
            dVar.f15048c = cursor.getString(cursor.getColumnIndex("item_info"));
            dVar.f15049d = cursor.getInt(cursor.getColumnIndex("item_source"));
            dVar.f15050e = cursor.getInt(cursor.getColumnIndex("storage_location"));
            return dVar;
        }
        return (d) invokeL.objValue;
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

    public synchronized List<d> d() {
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
                    d b2 = b(rawQuery);
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

    public final long f(SQLiteDatabase sQLiteDatabase, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, sQLiteDatabase, bVar)) == null) {
            try {
                return sQLiteDatabase.insert("download_info", null, a(bVar));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final String g(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, itemData)) == null) {
            if (itemData == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("item_id", itemData.itemId);
                jSONObject.put("item_name", itemData.mTitle);
                jSONObject.put("icon_size", itemData.mIconSize);
                jSONObject.put("icon_url", itemData.mIconUrl);
                if (!ListUtils.isEmpty(itemData.mTags)) {
                    jSONObject.put(CommandMessage.TYPE_TAGS, new JSONArray((Collection) itemData.mTags));
                }
                jSONObject.put("score", itemData.mScore);
                jSONObject.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, itemData.mStar);
                jSONObject.put("button_name", itemData.buttonName);
                jSONObject.put("button_link", itemData.buttonLink);
                jSONObject.put("button_link_type", itemData.buttonLinkType);
                jSONObject.put("apk_name", itemData.pkgName);
                jSONObject.put("forum_name", itemData.forumName);
                jSONObject.put("item_appid", itemData.appId);
                if (itemData.apkDetail != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("developer", itemData.apkDetail.developer);
                    jSONObject2.put("publisher", itemData.apkDetail.publisher);
                    jSONObject2.put("version", itemData.apkDetail.version);
                    jSONObject2.put("version_code", itemData.apkDetail.version_code);
                    jSONObject2.put("update_time", itemData.apkDetail.update_time);
                    jSONObject2.put("size", itemData.apkDetail.size);
                    jSONObject2.put("need_network", itemData.apkDetail.need_network);
                    jSONObject2.put("need_inner_buy", itemData.apkDetail.need_inner_buy);
                    jSONObject2.put("authority_url", itemData.apkDetail.authority_url);
                    jSONObject2.put("privacy_url", itemData.apkDetail.privacy_url);
                    jSONObject2.put("pkg_source", itemData.apkDetail.pkg_source);
                    jSONObject.put("apk_detail", jSONObject2);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, bVar)) == null) {
            try {
                return sQLiteDatabase.update("download_info", a(bVar), "pkg_name = ?", new String[]{String.valueOf(bVar.f19309e.pkgName)});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(b bVar) {
        InterceptResult invokeL;
        long f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return -1L;
                }
                SQLiteDatabase f3 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f3.beginTransaction();
                Cursor rawQuery = f3.rawQuery("SELECT * FROM download_info where pkg_name = ?", new String[]{bVar.f19309e.pkgName});
                if (rawQuery.getCount() > 0) {
                    f2 = h(f3, bVar);
                } else {
                    f2 = f(f3, bVar);
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
