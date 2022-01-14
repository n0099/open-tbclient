package c.a.r0.a.h0.o.g.f;

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
    public String f6769b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6770c;

    /* renamed from: d  reason: collision with root package name */
    public String f6771d;

    /* renamed from: e  reason: collision with root package name */
    public String f6772e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f6773f;

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
        this.a = i2;
        this.f6769b = str;
        this.f6773f = inputStream;
        this.f6770c = map;
        this.f6771d = str2;
        this.f6772e = str3;
    }
}
