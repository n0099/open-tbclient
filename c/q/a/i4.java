package c.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f28984b;

    /* renamed from: c  reason: collision with root package name */
    public int f28985c;

    /* renamed from: d  reason: collision with root package name */
    public int f28986d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28987e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28988f;

    /* renamed from: g  reason: collision with root package name */
    public int f28989g;

    /* renamed from: h  reason: collision with root package name */
    public int f28990h;

    /* renamed from: i  reason: collision with root package name */
    public int f28991i;

    /* renamed from: j  reason: collision with root package name */
    public int f28992j;
    public int[] k;

    public i4() {
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
