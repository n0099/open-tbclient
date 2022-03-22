package c.b.b;

import c.b.b.q.n;
import com.badlogic.gdx.Input;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class b implements Input {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean[] a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean[] f22327b;

    /* renamed from: c  reason: collision with root package name */
    public final n f22328c;

    /* renamed from: d  reason: collision with root package name */
    public int f22329d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22330e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22328c = new n();
        this.a = new boolean[256];
        this.f22327b = new boolean[256];
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.f22328c.c(i) : invokeI.booleanValue;
    }

    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (!z) {
                this.f22328c.f(i);
            } else {
                this.f22328c.a(i);
            }
        }
    }
}
