package c.a.p0.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f8173a;

    /* renamed from: b  reason: collision with root package name */
    public String f8174b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f8175c;

    /* renamed from: d  reason: collision with root package name */
    public j f8176d;

    /* renamed from: e  reason: collision with root package name */
    public long f8177e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f8178f;

    /* renamed from: g  reason: collision with root package name */
    public String f8179g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f8180h;

    public c() {
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
