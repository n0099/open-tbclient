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
    public int f31368b;

    /* renamed from: c  reason: collision with root package name */
    public int f31369c;

    /* renamed from: d  reason: collision with root package name */
    public int f31370d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31371e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31372f;

    /* renamed from: g  reason: collision with root package name */
    public int f31373g;

    /* renamed from: h  reason: collision with root package name */
    public int f31374h;

    /* renamed from: i  reason: collision with root package name */
    public int f31375i;

    /* renamed from: j  reason: collision with root package name */
    public int f31376j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f31377k;

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
