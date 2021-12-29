package c.a.k0.b.a.i;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentProvider a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4208b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4209c;

    public a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4208b = i2;
        this.f4209c = i3;
    }

    public ContentProviderResult[] a(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            int size = arrayList.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i2 = 0; i2 < size; i2++) {
                contentProviderResultArr[i2] = arrayList.get(i2).apply(this.a, contentProviderResultArr, i2);
            }
            return contentProviderResultArr;
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    public void b(ContentProvider contentProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentProvider) == null) && this.a == null) {
            this.a = contentProvider;
        }
    }

    public int c(int i2, Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, uri, contentValuesArr)) == null) {
            int length = contentValuesArr.length;
            for (ContentValues contentValues : contentValuesArr) {
                insert(i2, uri, contentValues);
            }
            return length;
        }
        return invokeILL.intValue;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public boolean d(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, bundle)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public abstract int delete(int i2, Uri uri, String str, String[] strArr);

    public void e(Uri uri, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, uri, i2) == null) && Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract void f(UriMatcher uriMatcher, String str);

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f4209c : invokeV.intValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    public abstract String getType(int i2, Uri uri);

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f4208b : invokeV.intValue;
    }

    public void i(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
        }
    }

    public abstract Uri insert(int i2, Uri uri, ContentValues contentValues);

    public abstract boolean j();

    public AssetFileDescriptor k(int i2, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048591, this, i2, uri, str)) == null) {
            m(i2, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeILL.objValue;
    }

    public AssetFileDescriptor l(int i2, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), uri, str, cancellationSignal})) == null) {
            k(i2, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeCommon.objValue;
    }

    public ParcelFileDescriptor m(int i2, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048593, this, i2, uri, str)) == null) {
            throw new FileNotFoundException("No files supported by provider at " + uri);
        }
        return (ParcelFileDescriptor) invokeILL.objValue;
    }

    public abstract Cursor query(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public Cursor query(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), uri, strArr, str, strArr2, str2, cancellationSignal})) == null) ? query(i2, uri, strArr, str, strArr2, str2) : (Cursor) invokeCommon.objValue;
    }

    public abstract int update(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr);
}
