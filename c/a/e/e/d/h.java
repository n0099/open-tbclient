package c.a.e.e.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2212a;

    /* renamed from: b  reason: collision with root package name */
    public String f2213b;

    /* renamed from: c  reason: collision with root package name */
    public int f2214c;

    /* renamed from: d  reason: collision with root package name */
    public String f2215d;

    /* renamed from: e  reason: collision with root package name */
    public int f2216e;

    /* renamed from: f  reason: collision with root package name */
    public long f2217f;

    public h() {
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
