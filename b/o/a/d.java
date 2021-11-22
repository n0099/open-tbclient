package b.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes6.dex */
public class d implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f34112a;

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
        this.f34112a = lVar;
    }

    @Override // b.o.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // b.o.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            l lVar = this.f34112a;
            if (a2.d(lVar.f34211c, lVar.f34216h)) {
                this.f34112a.f34216h = System.currentTimeMillis();
                l lVar2 = this.f34112a;
                a2.a(lVar2.f34209a, str, lVar2.f34211c, lVar2.f34215g, str2);
                y2 a2 = c3.a(this.f34112a.f34209a);
                a2.h(new g3(this.f34112a.f34211c), str);
                a2.l("desc", str2);
                a2.m();
                PBNativeListener pBNativeListener = this.f34112a.f34214f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                r0.p(this.f34112a.f34211c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
