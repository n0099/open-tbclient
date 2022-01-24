package c.a.d.f.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f3197b;

    /* renamed from: c  reason: collision with root package name */
    public String f3198c;

    /* renamed from: d  reason: collision with root package name */
    public String f3199d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f3200e;

    /* renamed from: f  reason: collision with root package name */
    public List<BasicNameValuePair> f3201f;

    public l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f3197b = "/";
        this.f3199d = null;
        this.f3200e = null;
        this.f3201f = null;
    }
}
