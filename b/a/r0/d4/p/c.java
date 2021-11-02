package b.a.r0.d4.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15978a;

    /* renamed from: b  reason: collision with root package name */
    public String f15979b;

    /* renamed from: c  reason: collision with root package name */
    public String f15980c;

    /* renamed from: d  reason: collision with root package name */
    public String f15981d;

    /* renamed from: e  reason: collision with root package name */
    public String f15982e;

    /* renamed from: f  reason: collision with root package name */
    public String f15983f;

    /* renamed from: g  reason: collision with root package name */
    public String f15984g;

    /* renamed from: h  reason: collision with root package name */
    public String f15985h;

    /* renamed from: i  reason: collision with root package name */
    public String f15986i;
    public String j;
    public String k;
    public String l;
    public String m;

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
            }
        }
    }
}
