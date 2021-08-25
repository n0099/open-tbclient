package c.a.q0.m0.i.c;

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
    public String f22052a;

    /* renamed from: b  reason: collision with root package name */
    public String f22053b;

    /* renamed from: c  reason: collision with root package name */
    public String f22054c;

    /* renamed from: d  reason: collision with root package name */
    public String f22055d;

    /* renamed from: e  reason: collision with root package name */
    public String f22056e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f22057f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22058g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22059h;

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
        this.f22058g = false;
        this.f22059h = false;
    }
}
