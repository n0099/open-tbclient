package c.a.r0.t.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f13763b;

    /* renamed from: c  reason: collision with root package name */
    public String f13764c;

    /* renamed from: d  reason: collision with root package name */
    public int f13765d;

    /* renamed from: e  reason: collision with root package name */
    public int f13766e;

    /* renamed from: f  reason: collision with root package name */
    public int f13767f;

    /* renamed from: g  reason: collision with root package name */
    public int f13768g;

    /* renamed from: h  reason: collision with root package name */
    public int f13769h;

    public x() {
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
