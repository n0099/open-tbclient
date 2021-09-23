package c.a.r0.j3;

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
    public String f20782a;

    /* renamed from: b  reason: collision with root package name */
    public String f20783b;

    /* renamed from: c  reason: collision with root package name */
    public String f20784c;

    /* renamed from: d  reason: collision with root package name */
    public String f20785d;

    /* renamed from: e  reason: collision with root package name */
    public String f20786e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f20787f;

    /* renamed from: g  reason: collision with root package name */
    public String f20788g;

    /* renamed from: h  reason: collision with root package name */
    public int f20789h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f20790i;

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
