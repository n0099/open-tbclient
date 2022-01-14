package c.a.s0.e1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f12366b;

    /* renamed from: c  reason: collision with root package name */
    public int f12367c;

    /* renamed from: d  reason: collision with root package name */
    public int f12368d;

    /* renamed from: e  reason: collision with root package name */
    public float f12369e;

    /* renamed from: f  reason: collision with root package name */
    public float f12370f;

    /* renamed from: g  reason: collision with root package name */
    public String f12371g;

    /* renamed from: h  reason: collision with root package name */
    public int f12372h;

    /* renamed from: i  reason: collision with root package name */
    public int f12373i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12374j;
    public boolean k;
    public String l;
    public String m;

    public g() {
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
