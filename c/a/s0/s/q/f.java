package c.a.s0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13371b;

    /* renamed from: c  reason: collision with root package name */
    public int f13372c;

    /* renamed from: d  reason: collision with root package name */
    public int f13373d;

    /* renamed from: e  reason: collision with root package name */
    public int f13374e;

    /* renamed from: f  reason: collision with root package name */
    public int f13375f;

    /* renamed from: g  reason: collision with root package name */
    public int f13376g;

    /* renamed from: h  reason: collision with root package name */
    public int f13377h;

    /* renamed from: i  reason: collision with root package name */
    public int f13378i;

    /* renamed from: j  reason: collision with root package name */
    public String f13379j;

    public f() {
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
        this.a = 0;
        this.f13371b = 0;
        this.f13372c = 1;
        this.f13373d = 1;
        this.f13374e = 0;
        this.f13375f = 0;
        this.f13376g = 1;
        this.f13377h = 0;
        this.f13378i = 0;
    }
}
