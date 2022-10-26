package com.baidu.swan.pms.database.provider;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dc4;
import com.baidu.tieba.og4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PMSDBProviderProxy extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final og4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile dc4 a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1600686017, "Lcom/baidu/swan/pms/database/provider/PMSDBProviderProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1600686017, "Lcom/baidu/swan/pms/database/provider/PMSDBProviderProxy;");
                return;
            }
        }
        b = og4.c();
    }

    public PMSDBProviderProxy() {
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

    public dc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                synchronized (dc4.class) {
                    if (this.a == null) {
                        this.a = new dc4(getContext());
                    }
                }
            }
            return this.a;
        }
        return (dc4) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        r2.setTransactionSuccessful();
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            SQLiteDatabase writableDatabase = a().a().getWritableDatabase();
            try {
                try {
                    b.i("PMSDBProviderProxy", "#applyBatch beginTransaction");
                    writableDatabase.beginTransaction();
                    ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                    int length = applyBatch.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            ContentProviderResult contentProviderResult = applyBatch[i];
                            if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    return applyBatch;
                } catch (Exception e) {
                    b.g("PMSDBProviderProxy", "#applyBatch error", e);
                    writableDatabase.endTransaction();
                    b.i("PMSDBProviderProxy", "#applyBatch endTransaction");
                    return new ContentProviderResult[0];
                }
            } finally {
                writableDatabase.endTransaction();
                b.i("PMSDBProviderProxy", "#applyBatch endTransaction");
            }
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, uri, str, strArr)) == null) {
            return a().delete(uri, str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            return a().getType(uri);
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, contentValues)) == null) {
            return a().insert(uri, contentValues);
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) {
            return a().query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            return a().update(uri, contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
