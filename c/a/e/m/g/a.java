package c.a.e.m.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f2705b;

    /* renamed from: c  reason: collision with root package name */
    public int f2706c;

    /* renamed from: d  reason: collision with root package name */
    public String f2707d;

    /* renamed from: e  reason: collision with root package name */
    public int f2708e;

    /* renamed from: f  reason: collision with root package name */
    public int f2709f;

    /* renamed from: g  reason: collision with root package name */
    public int f2710g;

    /* renamed from: h  reason: collision with root package name */
    public int f2711h;
    public int i;
    public String j;
    public int k;
    public int l;

    public a() {
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
        this.i = 3;
    }
}
