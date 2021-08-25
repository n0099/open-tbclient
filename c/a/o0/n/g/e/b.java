package c.a.o0.n.g.e;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f11837b;

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f11838c;

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f11839d;

    /* renamed from: e  reason: collision with root package name */
    public static final Uri f11840e;

    /* renamed from: f  reason: collision with root package name */
    public static final Uri f11841f;

    /* renamed from: g  reason: collision with root package name */
    public static final Uri f11842g;

    /* renamed from: h  reason: collision with root package name */
    public static final Uri f11843h;

    /* renamed from: i  reason: collision with root package name */
    public static final Uri f11844i;

    /* renamed from: j  reason: collision with root package name */
    public static UriMatcher f11845j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f11846a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1724896012, "Lc/a/o0/n/g/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1724896012, "Lc/a/o0/n/g/e/b;");
                return;
            }
        }
        f11837b = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
        f11838c = Uri.parse("content://" + f11837b + "/framework");
        f11839d = Uri.parse("content://" + f11837b + "/swan_app");
        f11840e = Uri.parse("content://" + f11837b + "/pkg_main");
        f11841f = Uri.parse("content://" + f11837b + "/pkg_sub");
        f11842g = Uri.parse("content://" + f11837b + "/" + ETAG.KEY_EXTENSION);
        f11843h = Uri.parse("content://" + f11837b + "/swan_plugin");
        f11844i = Uri.parse("content://" + f11837b + "/so_lib");
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11845j = uriMatcher;
        uriMatcher.addURI(f11837b, "framework", 2);
        f11845j.addURI(f11837b, "pkg_main", 0);
        f11845j.addURI(f11837b, "pkg_sub", 1);
        f11845j.addURI(f11837b, ETAG.KEY_EXTENSION, 3);
        f11845j.addURI(f11837b, "swan_app", 4);
        f11845j.addURI(f11837b, "swan_plugin", 5);
        f11845j.addURI(f11837b, "so_lib", 7);
    }

    public b(Context context) {
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
        this.f11846a = context;
    }

    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            String c2 = c(uri);
            if (TextUtils.isEmpty(c2)) {
                return 0;
            }
            boolean z = c.f11828a;
            try {
                int delete = b().getWritableDatabase().delete(c2, str, strArr);
                if (delete > 0) {
                    this.f11846a.getContentResolver().notifyChange(uri, null);
                }
                return delete;
            } catch (SQLException e2) {
                if (c.f11828a) {
                    e2.printStackTrace();
                    return 0;
                }
                return 0;
            }
        }
        return invokeLLL.intValue;
    }

    public SQLiteOpenHelper b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.g() : (SQLiteOpenHelper) invokeV.objValue;
    }

    public final String c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            int match = f11845j.match(uri);
            if (match != 0) {
                if (match != 1) {
                    if (match != 2) {
                        if (match != 3) {
                            if (match != 4) {
                                if (match != 5) {
                                    if (match != 7) {
                                        return null;
                                    }
                                    return "so_lib";
                                }
                                return "swan_plugin";
                            }
                            return "swan_app";
                        }
                        return ETAG.KEY_EXTENSION;
                    }
                    return "framework";
                }
                return "pkg_sub";
            }
            return "pkg_main";
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public String d(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public Uri e(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, contentValues)) == null) {
            String str = "name:" + Thread.currentThread().getName();
            String c2 = c(uri);
            if (!TextUtils.isEmpty(c2) && contentValues != null) {
                if (c.f11828a) {
                    String str2 = "insert:" + contentValues.toString();
                }
                try {
                    long insertWithOnConflict = b().getWritableDatabase().insertWithOnConflict(c2, null, contentValues, 5);
                    if (insertWithOnConflict > 0) {
                        Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                        this.f11846a.getContentResolver().notifyChange(withAppendedId, null);
                        return withAppendedId;
                    }
                    return uri;
                } catch (SQLException e2) {
                    if (c.f11828a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Nullable
    public Cursor f(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, uri, strArr, str, strArr2, str2)) == null) {
            if (uri.getQueryParameter("rawQuery") != null) {
                return g(uri, str);
            }
            String c2 = c(uri);
            if (TextUtils.isEmpty(c2)) {
                return null;
            }
            boolean z = c.f11828a;
            try {
                return b().getReadableDatabase().query(c2, strArr, str, strArr2, null, null, str2, null);
            } catch (SQLException e2) {
                if (c.f11828a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Nullable
    public Cursor g(@NonNull Uri uri, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, uri, str)) == null) {
            if (!TextUtils.isEmpty(c(uri))) {
                boolean z = c.f11828a;
                try {
                    return b().getReadableDatabase().rawQuery(str, null);
                } catch (SQLException e2) {
                    if (c.f11828a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Cursor) invokeLL.objValue;
    }

    public int h(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            String c2 = c(uri);
            if (TextUtils.isEmpty(c2)) {
                return 0;
            }
            boolean z = c.f11828a;
            try {
                int update = b().getWritableDatabase().update(c2, contentValues, str, strArr);
                if (update > 0) {
                    this.f11846a.getContentResolver().notifyChange(uri, null);
                }
                return update;
            } catch (SQLException e2) {
                if (c.f11828a) {
                    e2.printStackTrace();
                    return 0;
                }
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }
}
