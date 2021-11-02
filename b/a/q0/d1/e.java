package b.a.q0.d1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12089a;

    /* renamed from: b  reason: collision with root package name */
    public String f12090b;

    /* renamed from: c  reason: collision with root package name */
    public int f12091c;

    /* renamed from: d  reason: collision with root package name */
    public int f12092d;

    /* renamed from: e  reason: collision with root package name */
    public float f12093e;

    /* renamed from: f  reason: collision with root package name */
    public float f12094f;

    /* renamed from: g  reason: collision with root package name */
    public String f12095g;

    /* renamed from: h  reason: collision with root package name */
    public int f12096h;

    /* renamed from: i  reason: collision with root package name */
    public int f12097i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;

    public e() {
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
}
