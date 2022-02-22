package c.a.t0.s.m0.b;

import c.a.d.f.q.h;
import c.a.u0.a4.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13678b;

    /* renamed from: c  reason: collision with root package name */
    public int f13679c;

    /* renamed from: d  reason: collision with root package name */
    public String f13680d;

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
        this.a = null;
        this.f13678b = null;
        this.f13679c = 0;
        this.f13680d = null;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return h.a(j.voice_cache_error_internal);
                case 2:
                    return h.a(j.voice_cache_error_no_space);
                case 3:
                    return h.a(j.neterror);
                case 4:
                    return h.a(j.voice_cache_error_no_file);
                case 5:
                    return h.a(j.voice_cache_error_md5);
                case 6:
                    return h.a(j.voice_cache_error_no_input);
                case 7:
                    return h.a(j.voice_cache_error_no_dir);
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
