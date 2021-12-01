package c.p.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lVar;
    }

    @Override // c.p.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.p.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            l lVar = this.a;
            if (a2.d(lVar.f30827c, lVar.f30832h)) {
                this.a.f30832h = System.currentTimeMillis();
                l lVar2 = this.a;
                a2.a(lVar2.a, str, lVar2.f30827c, lVar2.f30831g, str2);
                y2 a = c3.a(this.a.a);
                a.h(new g3(this.a.f30827c), str);
                a.l("desc", str2);
                a.m();
                PBNativeListener pBNativeListener = this.a.f30830f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                r0.p(this.a.f30827c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
