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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jd4;
import com.repackage.y84;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PMSDBProviderProxy extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final jd4 LOG;
    public static final String TAG = "PMSDBProviderProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile y84 mProvider;

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
        LOG = jd4.c();
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        r2.setTransactionSuccessful();
     */
    @Override // android.content.ContentProvider
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContentProviderResult[] applyBatch(@NonNull ArrayList<ContentProviderOperation> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            SQLiteDatabase writableDatabase = getProvider().a().getWritableDatabase();
            try {
                try {
                    LOG.i(TAG, "#applyBatch beginTransaction");
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
                    LOG.g(TAG, "#applyBatch error", e);
                    writableDatabase.endTransaction();
                    LOG.i(TAG, "#applyBatch endTransaction");
                    return new ContentProviderResult[0];
                }
            } finally {
                writableDatabase.endTransaction();
                LOG.i(TAG, "#applyBatch endTransaction");
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

    public y84 getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mProvider == null) {
                synchronized (y84.class) {
                    if (this.mProvider == null) {
                        this.mProvider = new y84(getContext());
                    }
                }
            }
            return this.mProvider;
        }
        return (y84) invokeV.objValue;
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
