package b.q.a;

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
    public final /* synthetic */ u f33394a;

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
        this.f33394a = uVar;
    }

    @Override // b.q.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // b.q.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            u uVar = this.f33394a;
            if (a2.d(uVar.f33504c, uVar.f33509h)) {
                this.f33394a.f33509h = System.currentTimeMillis();
                u uVar2 = this.f33394a;
                a2.a(uVar2.f33502a, str, uVar2.f33504c, uVar2.f33508g, str2);
                y2 a2 = c3.a(this.f33394a.f33502a);
                a2.h(new g3(this.f33394a.f33504c), str);
                a2.l("desc", str2);
                a2.m();
                s sVar = this.f33394a.f33507f;
                if (sVar != null) {
                    sVar.onClicked();
                }
                r0.p(this.f33394a.f33504c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
