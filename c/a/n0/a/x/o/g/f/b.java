package c.a.n0.a.x.o.g.f;

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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f7348b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f7349c;

    /* renamed from: d  reason: collision with root package name */
    public String f7350d;

    /* renamed from: e  reason: collision with root package name */
    public String f7351e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f7352f;

    public b(int i, String str, InputStream inputStream, Map<String, String> map, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, inputStream, map, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.f7348b = str;
        this.f7352f = inputStream;
        this.f7349c = map;
        this.f7350d = str2;
        this.f7351e = str3;
    }
}
