package com.baidu.swan.pms.database.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.n.c;
import b.a.p0.n.g.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class PMSDBProviderProxy extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PMSDBProviderProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile b mProvider;

    public PMSDBProviderProxy() {
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

    @Override // android.content.ContentProvider
    @NonNull
    public ContentProviderResult[] applyBatch(@NonNull ArrayList<ContentProviderOperation> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            SQLiteDatabase writableDatabase = getProvider().a().getWritableDatabase();
            try {
                try {
                    boolean z = c.f11048a;
                    writableDatabase.beginTransaction();
                    ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                    for (ContentProviderResult contentProviderResult : applyBatch) {
                        if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                            return applyBatch;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    return applyBatch;
                } catch (Exception e2) {
                    if (c.f11048a) {
                        String str = "applyBatch Exception:" + e2.getMessage();
                    }
                    writableDatabase.endTransaction();
                    boolean z2 = c.f11048a;
                    return new ContentProviderResult[0];
                }
            } finally {
                writableDatabase.endTransaction();
                boolean z3 = c.f11048a;
            }
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) ? getProvider().delete(uri, str, strArr) : invokeLLL.intValue;
    }

    public b getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mProvider == null) {
                synchronized (b.class) {
                    if (this.mProvider == null) {
                        this.mProvider = new b(getContext());
                    }
                }
            }
            return this.mProvider;
        }
        return (b) invokeV.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) ? getProvider().getType(uri) : (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, contentValues)) == null) ? getProvider().insert(uri, contentValues) : (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) ? getProvider().query(uri, strArr, str, strArr2, str2) : (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) ? getProvider().update(uri, contentValues, str, strArr) : invokeLLLL.intValue;
    }
}
