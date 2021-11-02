package b.a.r0.h1.d.f;

import b.a.r0.h1.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17068a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17069b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17070c;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17068a = -1;
        this.f17069b = false;
        this.f17070c = false;
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f17069b = true;
            int i2 = this.f17068a;
            if (i2 == -1 || !this.f17070c) {
                return;
            }
            eVar.a(i2);
        }
    }

    public void b(int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, eVar) == null) {
            this.f17068a = i2;
            if (this.f17069b && this.f17070c) {
                eVar.a(i2);
            }
        }
    }
}
