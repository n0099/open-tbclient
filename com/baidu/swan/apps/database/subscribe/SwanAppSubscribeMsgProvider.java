package com.baidu.swan.apps.database.subscribe;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.tieba.fm2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SwanAppSubscribeMsgProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public static final Uri c;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public SQLiteDatabase a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(440665615, "Lcom/baidu/swan/apps/database/subscribe/SwanAppSubscribeMsgProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(440665615, "Lcom/baidu/swan/apps/database/subscribe/SwanAppSubscribeMsgProvider;");
                return;
            }
        }
        b = fm2.c().getPackageName() + ".swan.subscribe_msg";
        c = Uri.parse("content://" + b);
    }

    public SwanAppSubscribeMsgProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    return false;
                }
                SQLiteOpenHelper h = SwanAppDbControl.f(fm2.c()).h();
                if (h != null) {
                    SQLiteDatabase writableDatabase = h.getWritableDatabase();
                    this.a = writableDatabase;
                    return writableDatabase == null;
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public int delete(@Nullable Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            if (a()) {
                return 0;
            }
            return this.a.delete("swanapp_subscribe_msg", str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) ? b : (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            if (!a() && this.a.insert("swanapp_subscribe_msg", null, contentValues) > 0) {
                return uri;
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@Nullable Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, uri, strArr, str, strArr2, str2)) == null) {
            if (a()) {
                return null;
            }
            return this.a.query("swanapp_subscribe_msg", strArr, str, strArr2, null, null, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, uri, contentValues, str, strArr)) == null) {
            if (a()) {
                return 0;
            }
            return this.a.update("swanapp_subscribe_msg", contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
