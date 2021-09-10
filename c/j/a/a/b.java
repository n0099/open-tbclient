package c.j.a.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34296a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f34297b;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext() : (Context) invokeL.objValue;
    }
}
