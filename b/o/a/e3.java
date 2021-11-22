package b.o.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class e3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public u2 f34131a;

    /* renamed from: b  reason: collision with root package name */
    public i3 f34132b;

    public e3(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        u2 u2Var = new u2(context, str);
        this.f34131a = u2Var;
        u2Var.f34357f = new a3(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f34131a != null) {
                    this.f34131a.a();
                    this.f34131a = null;
                }
                if (this.f34132b != null) {
                    this.f34132b = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public Info b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            u2 u2Var = this.f34131a;
            if (u2Var == null || !u2Var.e()) {
                return null;
            }
            return u2Var.f34354c;
        }
        return (Info) invokeV.objValue;
    }
}
