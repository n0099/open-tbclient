package c.a.r0.k3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20960a;

    /* renamed from: b  reason: collision with root package name */
    public String f20961b;

    /* renamed from: c  reason: collision with root package name */
    public String f20962c;

    /* renamed from: d  reason: collision with root package name */
    public String f20963d;

    /* renamed from: e  reason: collision with root package name */
    public String f20964e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f20965f;

    /* renamed from: g  reason: collision with root package name */
    public String f20966g;

    /* renamed from: h  reason: collision with root package name */
    public int f20967h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f20968i;

    public c0() {
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
