package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes6.dex */
public class w implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f33546a;

    public w(H5Activity h5Activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h5Activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33546a = h5Activity;
    }

    @Override // b.q.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            H5Activity h5Activity = this.f33546a;
            if (a2.d(h5Activity.f70482e, h5Activity.f70485h)) {
                this.f33546a.f70485h = System.currentTimeMillis();
                H5Activity h5Activity2 = this.f33546a;
                a2.a(h5Activity2.f70478a, str, h5Activity2.f70482e, h5Activity2.f70486i, str2);
                y2 a2 = c3.a(this.f33546a.f70478a);
                a2.h(new g3(this.f33546a.f70482e), str);
                a2.l("desc", str2);
                a2.m();
                q0.c(this.f33546a.f70482e.getId() + this.f33546a.f70483f, "is_click", null);
                r0.p(this.f33546a.f70482e, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.q.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f33546a.f70484g = str;
        }
    }
}
