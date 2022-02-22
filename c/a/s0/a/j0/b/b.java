package c.a.s0.a.j0.b;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f7515b;

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f7516c;
    public transient /* synthetic */ FieldHolder $fh;
    public UriMatcher a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1045992043, "Lc/a/s0/a/j0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1045992043, "Lc/a/s0/a/j0/b/b;");
                return;
            }
        }
        f7515b = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
        f7516c = Uri.parse("content://" + f7515b);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.a = uriMatcher;
        uriMatcher.addURI(f7515b, "favorite", 0);
        this.a.addURI(f7515b, "favorite_and_aps", 1);
        this.a.addURI(f7515b, "history", 2);
        this.a.addURI(f7515b, "history_with_app", 3);
        this.a.addURI(f7515b, "favorite_with_aps_pms", 4);
        this.a.addURI(f7515b, "history_with_aps_pms", 5);
        this.a.addURI(f7515b, "user_behavior", 6);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            AppRuntime.getAppContext().getContentResolver().notifyChange(c.a.s0.a.j0.c.a.b(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(c.a.s0.a.j0.c.a.c(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(c.a.s0.a.j0.c.a.a(), (ContentObserver) null, false);
        }
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public final String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 != 6) {
                if (k.a) {
                    throw new NullPointerException("tableName must not Null");
                }
                return "";
            }
            return "user_behavior";
        }
        return (String) invokeI.objValue;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        SQLiteDatabase e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            int match = this.a.match(uri);
            if (match != 0) {
                if (match != 2) {
                    if (match == 6 && (e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                        return e2.delete(a(match), str, strArr);
                    }
                    return 0;
                }
                int c2 = SwanAppDbControl.f(AppRuntime.getAppContext()).c(str, strArr);
                if (c2 > 0) {
                    b();
                }
                return c2;
            }
            return SwanAppDbControl.f(AppRuntime.getAppContext()).b(str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        SQLiteDatabase e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            int match = this.a.match(uri);
            if (match == 0) {
                long i2 = SwanAppDbControl.f(AppRuntime.getAppContext()).i(contentValues);
                if (i2 < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(f7516c.buildUpon().build(), i2);
            } else if (match != 2) {
                if (match == 6 && (e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                    e2.insertWithOnConflict(a(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            } else {
                long j2 = SwanAppDbControl.f(AppRuntime.getAppContext()).j(contentValues);
                if (j2 < 0) {
                    return null;
                }
                b();
                return ContentUris.withAppendedId(f7516c.buildUpon().build(), j2);
            }
        }
        return (Uri) invokeLL.objValue;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            int match = this.a.match(uri);
            switch (match) {
                case 0:
                    Cursor l = SwanAppDbControl.f(AppRuntime.getAppContext()).l(strArr, str, strArr2, str2);
                    l.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return l;
                case 1:
                    Cursor k = SwanAppDbControl.f(AppRuntime.getAppContext()).k(strArr, str, strArr2, str2);
                    k.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return k;
                case 2:
                    Cursor n = SwanAppDbControl.f(AppRuntime.getAppContext()).n(strArr, str, strArr2, str2);
                    n.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return n;
                case 3:
                    Cursor m = SwanAppDbControl.f(AppRuntime.getAppContext()).m(strArr, str, strArr2, str2);
                    m.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return m;
                case 4:
                    Cursor s = a.s();
                    s.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return s;
                case 5:
                    int i2 = -1;
                    try {
                        i2 = Integer.valueOf(uri.getQueryParameter("query_limit")).intValue();
                    } catch (Exception e2) {
                        if (k.a) {
                            e2.printStackTrace();
                        }
                    }
                    String queryParameter = uri.getQueryParameter("query_word");
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Cursor o = c.a.s0.a.j0.c.b.o(queryParameter, i2);
                    o.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return o;
                case 6:
                    SQLiteDatabase e3 = SwanAppDbControl.f(AppRuntime.getAppContext()).e();
                    if (e3 != null) {
                        return e3.query(a(match), strArr, str, strArr2, null, null, str2);
                    }
                    return null;
                default:
                    return null;
            }
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        SQLiteDatabase e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            int match = this.a.match(uri);
            if (match != 0) {
                if (match != 2) {
                    if (match == 6 && (e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                        return e2.update(a(match), contentValues, str, strArr);
                    }
                    return 0;
                }
                int r = SwanAppDbControl.f(AppRuntime.getAppContext()).r(contentValues, str, strArr);
                if (r > 0) {
                    b();
                }
                return r;
            }
            return SwanAppDbControl.f(AppRuntime.getAppContext()).q(contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
