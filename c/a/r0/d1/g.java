package c.a.r0.d1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f12200b;

    /* renamed from: c  reason: collision with root package name */
    public int f12201c;

    /* renamed from: d  reason: collision with root package name */
    public int f12202d;

    /* renamed from: e  reason: collision with root package name */
    public float f12203e;

    /* renamed from: f  reason: collision with root package name */
    public float f12204f;

    /* renamed from: g  reason: collision with root package name */
    public String f12205g;

    /* renamed from: h  reason: collision with root package name */
    public int f12206h;

    /* renamed from: i  reason: collision with root package name */
    public int f12207i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12208j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12209k;
    public String l;
    public String m;

    public g() {
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
