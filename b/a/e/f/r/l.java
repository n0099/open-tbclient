package b.a.e.f.r;

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

    /* renamed from: a  reason: collision with root package name */
    public String f2155a;

    /* renamed from: b  reason: collision with root package name */
    public String f2156b;

    /* renamed from: c  reason: collision with root package name */
    public String f2157c;

    /* renamed from: d  reason: collision with root package name */
    public String f2158d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f2159e;

    /* renamed from: f  reason: collision with root package name */
    public List<BasicNameValuePair> f2160f;

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
        this.f2155a = str;
        this.f2156b = "/";
        this.f2158d = null;
        this.f2159e = null;
        this.f2160f = null;
    }
}
