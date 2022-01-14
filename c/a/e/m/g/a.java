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
    public String f3470b;

    /* renamed from: c  reason: collision with root package name */
    public int f3471c;

    /* renamed from: d  reason: collision with root package name */
    public String f3472d;

    /* renamed from: e  reason: collision with root package name */
    public int f3473e;

    /* renamed from: f  reason: collision with root package name */
    public int f3474f;

    /* renamed from: g  reason: collision with root package name */
    public int f3475g;

    /* renamed from: h  reason: collision with root package name */
    public int f3476h;

    /* renamed from: i  reason: collision with root package name */
    public int f3477i;

    /* renamed from: j  reason: collision with root package name */
    public String f3478j;
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
        this.f3477i = 3;
    }
}
