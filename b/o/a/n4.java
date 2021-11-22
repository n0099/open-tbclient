package b.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34242a;

    /* renamed from: b  reason: collision with root package name */
    public int f34243b;

    /* renamed from: c  reason: collision with root package name */
    public int f34244c;

    /* renamed from: d  reason: collision with root package name */
    public int f34245d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34246e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34247f;

    /* renamed from: g  reason: collision with root package name */
    public int f34248g;

    /* renamed from: h  reason: collision with root package name */
    public int f34249h;

    /* renamed from: i  reason: collision with root package name */
    public int f34250i;
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
