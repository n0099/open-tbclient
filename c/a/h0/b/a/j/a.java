package c.a.h0.b.a.j;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.b.a.b;
import c.a.h0.b.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c.a.h0.b.a.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(0, 100);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.h0.b.a.i.a
    public Bundle d(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) {
            if ("_get_service_handler".equals(str)) {
                return b.a();
            }
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // c.a.h0.b.a.i.a
    public boolean e(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, bundle)) == null) ? "_get_service_handler".equals(str) : invokeLLL.booleanValue;
    }

    @Override // c.a.h0.b.a.i.a
    public int f(int i2, Uri uri, String str, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), uri, str, strArr})) == null) {
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // c.a.h0.b.a.i.a
    public void g(Uri uri, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, uri, i2) == null) || i2 == 3) {
            return;
        }
        super.g(uri, i2);
    }

    @Override // c.a.h0.b.a.i.a
    public void h(UriMatcher uriMatcher, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, uriMatcher, str) == null) {
            uriMatcher.addURI(str, "ipc_manager/method/get_service_handler", 1);
        }
    }

    @Override // c.a.h0.b.a.i.a
    public String i(int i2, Uri uri) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, uri)) == null) {
            return null;
        }
        return (String) invokeIL.objValue;
    }

    @Override // c.a.h0.b.a.i.a
    public Uri j(int i2, Uri uri, ContentValues contentValues) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeILL.objValue;
    }

    @Override // c.a.h0.b.a.i.a
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.h0.b.a.i.a
    public Cursor r(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), uri, strArr, str, strArr2, str2})) == null) {
            if (i2 == 1) {
                return new c(b.a());
            }
            return null;
        }
        return (Cursor) invokeCommon.objValue;
    }

    @Override // c.a.h0.b.a.i.a
    public int t(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), uri, contentValues, str, strArr})) == null) {
            return 0;
        }
        return invokeCommon.intValue;
    }
}
