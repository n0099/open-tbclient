package c.a.k.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f3709b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f3710a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (b.class) {
                if (f3709b == null) {
                    f3709b = new b();
                }
                bVar = f3709b;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: b */
    public h getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f3710a == null) {
                this.f3710a = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
            }
            return this.f3710a;
        }
        return (h) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            if (c.a.k.a.q.d.c(this)) {
                return d.a(str, this);
            }
            return super.getSharedPreferences(str, i2);
        }
        return (SharedPreferences) invokeLI.objValue;
    }
}
