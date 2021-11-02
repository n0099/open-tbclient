package b.i.b.a.y;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f32891a;

    /* renamed from: b  reason: collision with root package name */
    public int f32892b;

    /* renamed from: c  reason: collision with root package name */
    public int f32893c;

    /* renamed from: d  reason: collision with root package name */
    public int f32894d;

    /* renamed from: e  reason: collision with root package name */
    public int f32895e;

    /* renamed from: f  reason: collision with root package name */
    public int f32896f;

    /* renamed from: g  reason: collision with root package name */
    public int f32897g;

    /* renamed from: h  reason: collision with root package name */
    public int f32898h;

    /* renamed from: i  reason: collision with root package name */
    public int f32899i;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
            }
        }
    }
}
