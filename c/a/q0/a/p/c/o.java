package c.a.q0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.a.q0.a.f2.f.o;
import c.a.q0.a.z2.t0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class o implements c.a.q0.a.p.d.c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    @Override // c.a.q0.a.p.d.c0
    public boolean a(Activity activity, String str, o.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, bVar)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // c.a.q0.a.p.d.c0
    public boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.q0.a.p.d.c0
    public boolean c(Activity activity, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, uri, str)) == null) {
            if (activity == null || uri == null || uri.getPath() == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.a.q0.a.z2.d.i()) {
                uri = t0.a(activity, new File(uri.getPath()));
            }
            d(activity, uri, str);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void d(Activity activity, Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, uri, str) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(uri, str);
            c.a.q0.a.z2.f.f(activity, intent);
        }
    }
}
