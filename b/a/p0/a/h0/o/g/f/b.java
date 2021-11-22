package b.a.p0.a.h0.o.g.f;

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
    public int f5958a;

    /* renamed from: b  reason: collision with root package name */
    public String f5959b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f5960c;

    /* renamed from: d  reason: collision with root package name */
    public String f5961d;

    /* renamed from: e  reason: collision with root package name */
    public String f5962e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f5963f;

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
        this.f5958a = i2;
        this.f5959b = str;
        this.f5963f = inputStream;
        this.f5960c = map;
        this.f5961d = str2;
        this.f5962e = str3;
    }
}
