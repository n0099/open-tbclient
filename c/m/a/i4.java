package c.m.a;

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
    public int f23459b;

    /* renamed from: c  reason: collision with root package name */
    public int f23460c;

    /* renamed from: d  reason: collision with root package name */
    public int f23461d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23462e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23463f;

    /* renamed from: g  reason: collision with root package name */
    public int f23464g;

    /* renamed from: h  reason: collision with root package name */
    public int f23465h;
    public int i;
    public int j;
    public int[] k;

    public i4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
