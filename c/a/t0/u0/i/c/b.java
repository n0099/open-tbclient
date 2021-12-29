package c.a.t0.u0.i.c;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24745b;

    /* renamed from: c  reason: collision with root package name */
    public String f24746c;

    /* renamed from: d  reason: collision with root package name */
    public String f24747d;

    /* renamed from: e  reason: collision with root package name */
    public String f24748e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f24749f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24750g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24751h;

    public b() {
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
        this.f24750g = false;
        this.f24751h = false;
    }
}
