package c.m.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes3.dex */
public class d implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ l a;

    public d(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lVar;
    }

    @Override // c.m.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.m.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            l lVar = this.a;
            if (v1.d(lVar.f23481c, lVar.f23486h)) {
                this.a.f23486h = System.currentTimeMillis();
                l lVar2 = this.a;
                v1.a(lVar2.a, str, lVar2.f23481c, lVar2.f23485g, str2);
                t2 a = x2.a(this.a.a);
                a.h(new b3(this.a.f23481c), str);
                a.l("desc", str2);
                a.m();
                PBNativeListener pBNativeListener = this.a.f23484f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                r0.p(this.a.f23481c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
