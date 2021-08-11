package c.a.g0.b.a.i;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
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

    /* renamed from: a  reason: collision with root package name */
    public ContentProvider f3242a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3243b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3244c;

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
        this.f3243b = i2;
        this.f3244c = i3;
    }

    public ContentProviderResult[] a(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            int size = arrayList.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            for (int i2 = 0; i2 < size; i2++) {
                contentProviderResultArr[i2] = arrayList.get(i2).apply(this.f3242a, contentProviderResultArr, i2);
            }
            return contentProviderResultArr;
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    public void b(ContentProvider contentProvider) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentProvider) == null) && this.f3242a == null) {
            this.f3242a = contentProvider;
        }
    }

    public int c(int i2, Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, uri, contentValuesArr)) == null) {
            int length = contentValuesArr.length;
            for (ContentValues contentValues : contentValuesArr) {
                j(i2, uri, contentValues);
            }
            return length;
        }
        return invokeILL.intValue;
    }

    public Bundle d(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public boolean e(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, bundle)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public abstract int f(int i2, Uri uri, String str, String[] strArr);

    public void g(Uri uri, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, uri, i2) == null) && Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract void h(UriMatcher uriMatcher, String str);

    public abstract String i(int i2, Uri uri);

    public abstract Uri j(int i2, Uri uri, ContentValues contentValues);

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3244c : invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f3243b : invokeV.intValue;
    }

    public void m(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
        }
    }

    public abstract boolean n();

    public AssetFileDescriptor o(int i2, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i2, uri, str)) == null) {
            q(i2, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeILL.objValue;
    }

    public AssetFileDescriptor p(int i2, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), uri, str, cancellationSignal})) == null) {
            o(i2, uri, str);
            throw null;
        }
        return (AssetFileDescriptor) invokeCommon.objValue;
    }

    public ParcelFileDescriptor q(int i2, Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048592, this, i2, uri, str)) == null) {
            throw new FileNotFoundException("No files supported by provider at " + uri);
        }
        return (ParcelFileDescriptor) invokeILL.objValue;
    }

    public abstract Cursor r(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public Cursor s(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), uri, strArr, str, strArr2, str2, cancellationSignal})) == null) ? r(i2, uri, strArr, str, strArr2, str2) : (Cursor) invokeCommon.objValue;
    }

    public abstract int t(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr);
}
