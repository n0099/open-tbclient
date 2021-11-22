package b.a.q0.c1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12763a;

    /* renamed from: b  reason: collision with root package name */
    public String f12764b;

    /* renamed from: c  reason: collision with root package name */
    public int f12765c;

    /* renamed from: d  reason: collision with root package name */
    public int f12766d;

    /* renamed from: e  reason: collision with root package name */
    public float f12767e;

    /* renamed from: f  reason: collision with root package name */
    public float f12768f;

    /* renamed from: g  reason: collision with root package name */
    public String f12769g;

    /* renamed from: h  reason: collision with root package name */
    public int f12770h;

    /* renamed from: i  reason: collision with root package name */
    public int f12771i;
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
