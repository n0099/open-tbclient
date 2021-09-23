package c.a.r0.n0.i.c;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22636a;

    /* renamed from: b  reason: collision with root package name */
    public String f22637b;

    /* renamed from: c  reason: collision with root package name */
    public String f22638c;

    /* renamed from: d  reason: collision with root package name */
    public String f22639d;

    /* renamed from: e  reason: collision with root package name */
    public String f22640e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f22641f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22642g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22643h;

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
        this.f22642g = false;
        this.f22643h = false;
    }
}
