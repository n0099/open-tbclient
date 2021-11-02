package b.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f33408a;

    /* renamed from: b  reason: collision with root package name */
    public int f33409b;

    /* renamed from: c  reason: collision with root package name */
    public int f33410c;

    /* renamed from: d  reason: collision with root package name */
    public int f33411d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33412e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33413f;

    /* renamed from: g  reason: collision with root package name */
    public int f33414g;

    /* renamed from: h  reason: collision with root package name */
    public int f33415h;

    /* renamed from: i  reason: collision with root package name */
    public int f33416i;
    public int j;
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
