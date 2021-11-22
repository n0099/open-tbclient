package b.a.r0.m3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22383a;

    /* renamed from: b  reason: collision with root package name */
    public String f22384b;

    /* renamed from: c  reason: collision with root package name */
    public String f22385c;

    /* renamed from: d  reason: collision with root package name */
    public String f22386d;

    /* renamed from: e  reason: collision with root package name */
    public String f22387e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f22388f;

    /* renamed from: g  reason: collision with root package name */
    public String f22389g;

    /* renamed from: h  reason: collision with root package name */
    public int f22390h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f22391i;

    public d0() {
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
