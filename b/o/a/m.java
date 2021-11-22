package b.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f34228a;

    public m(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34228a = uVar;
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
            u uVar = this.f34228a;
            if (a2.d(uVar.f34338c, uVar.f34343h)) {
                this.f34228a.f34343h = System.currentTimeMillis();
                u uVar2 = this.f34228a;
                a2.a(uVar2.f34336a, str, uVar2.f34338c, uVar2.f34342g, str2);
                y2 a2 = c3.a(this.f34228a.f34336a);
                a2.h(new g3(this.f34228a.f34338c), str);
                a2.l("desc", str2);
                a2.m();
                s sVar = this.f34228a.f34341f;
                if (sVar != null) {
                    sVar.onClicked();
                }
                r0.p(this.f34228a.f34338c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
