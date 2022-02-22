package c.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class n4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f30620b;

    /* renamed from: c  reason: collision with root package name */
    public int f30621c;

    /* renamed from: d  reason: collision with root package name */
    public int f30622d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30623e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30624f;

    /* renamed from: g  reason: collision with root package name */
    public int f30625g;

    /* renamed from: h  reason: collision with root package name */
    public int f30626h;

    /* renamed from: i  reason: collision with root package name */
    public int f30627i;

    /* renamed from: j  reason: collision with root package name */
    public int f30628j;
    public int[] k;

    public n4() {
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
