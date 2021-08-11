package c.a.n0.a.h0.o.h.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6062a;

    /* renamed from: b  reason: collision with root package name */
    public String f6063b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6064c;

    /* renamed from: d  reason: collision with root package name */
    public String f6065d;

    /* renamed from: e  reason: collision with root package name */
    public String f6066e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f6067f;

    public b(int i2, String str, InputStream inputStream, Map<String, String> map, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, inputStream, map, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6062a = i2;
        this.f6063b = str;
        this.f6067f = inputStream;
        this.f6064c = map;
        this.f6065d = str2;
        this.f6066e = str3;
    }
}
