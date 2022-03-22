package c.a.p0.w0.j.c;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f19446b;

    /* renamed from: c  reason: collision with root package name */
    public String f19447c;

    /* renamed from: d  reason: collision with root package name */
    public String f19448d;

    /* renamed from: e  reason: collision with root package name */
    public String f19449e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f19450f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19451g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19452h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19451g = false;
        this.f19452h = false;
    }
}
