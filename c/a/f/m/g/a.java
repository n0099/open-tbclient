package c.a.f.m.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f3214a;

    /* renamed from: b  reason: collision with root package name */
    public String f3215b;

    /* renamed from: c  reason: collision with root package name */
    public int f3216c;

    /* renamed from: d  reason: collision with root package name */
    public String f3217d;

    /* renamed from: e  reason: collision with root package name */
    public int f3218e;

    /* renamed from: f  reason: collision with root package name */
    public int f3219f;

    /* renamed from: g  reason: collision with root package name */
    public int f3220g;

    /* renamed from: h  reason: collision with root package name */
    public int f3221h;

    /* renamed from: i  reason: collision with root package name */
    public int f3222i;

    /* renamed from: j  reason: collision with root package name */
    public String f3223j;
    public int k;
    public int l;

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
                return;
            }
        }
        this.f3222i = 3;
    }
}
