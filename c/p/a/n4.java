package c.p.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f30855b;

    /* renamed from: c  reason: collision with root package name */
    public int f30856c;

    /* renamed from: d  reason: collision with root package name */
    public int f30857d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30858e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30859f;

    /* renamed from: g  reason: collision with root package name */
    public int f30860g;

    /* renamed from: h  reason: collision with root package name */
    public int f30861h;

    /* renamed from: i  reason: collision with root package name */
    public int f30862i;

    /* renamed from: j  reason: collision with root package name */
    public int f30863j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f30864k;

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
