package c.a.q0.c1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f12177b;

    /* renamed from: c  reason: collision with root package name */
    public int f12178c;

    /* renamed from: d  reason: collision with root package name */
    public int f12179d;

    /* renamed from: e  reason: collision with root package name */
    public float f12180e;

    /* renamed from: f  reason: collision with root package name */
    public float f12181f;

    /* renamed from: g  reason: collision with root package name */
    public String f12182g;

    /* renamed from: h  reason: collision with root package name */
    public int f12183h;

    /* renamed from: i  reason: collision with root package name */
    public int f12184i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12185j;
    public boolean k;
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
