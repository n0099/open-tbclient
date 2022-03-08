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

    /* renamed from: e  reason: collision with root package name */
    public final boolean[] f27069e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f27070f;

    /* renamed from: g  reason: collision with root package name */
    public final n f27071g;

    /* renamed from: h  reason: collision with root package name */
    public int f27072h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27073i;

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
        this.f27071g = new n();
        this.f27069e = new boolean[256];
        this.f27070f = new boolean[256];
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f27071g.c(i2) : invokeI.booleanValue;
    }

    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (!z) {
                this.f27071g.f(i2);
            } else {
                this.f27071g.a(i2);
            }
        }
    }
}
