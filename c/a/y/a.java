package c.a.y;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31126a;

    /* renamed from: b  reason: collision with root package name */
    public String f31127b;

    /* renamed from: c  reason: collision with root package name */
    public String f31128c;

    /* renamed from: d  reason: collision with root package name */
    public String f31129d;

    /* renamed from: e  reason: collision with root package name */
    public String f31130e;

    /* renamed from: f  reason: collision with root package name */
    public String f31131f;

    /* renamed from: g  reason: collision with root package name */
    public int f31132g;

    public a() {
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
