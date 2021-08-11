package c.a.o0.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12748a;

    /* renamed from: b  reason: collision with root package name */
    public int f12749b;

    /* renamed from: c  reason: collision with root package name */
    public String f12750c;

    /* renamed from: d  reason: collision with root package name */
    public String f12751d;

    /* renamed from: e  reason: collision with root package name */
    public String f12752e;

    /* renamed from: f  reason: collision with root package name */
    public int f12753f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12748a = -1;
        this.f12749b = -1;
        this.f12753f = -1;
    }
}
