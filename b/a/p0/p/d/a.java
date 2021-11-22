package b.a.p0.p.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11720a;

    /* renamed from: b  reason: collision with root package name */
    public String f11721b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11722c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f11723d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f11724e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11725f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11726g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11727h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11728i;
    public int j;
    public int k;
    public C0642a l;

    /* renamed from: b.a.p0.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0642a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11729a;

        /* renamed from: b  reason: collision with root package name */
        public int f11730b;

        /* renamed from: c  reason: collision with root package name */
        public int f11731c;
    }

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
        this.f11721b = "GET";
        this.f11725f = false;
        this.f11726g = false;
        this.f11727h = false;
        this.j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f11723d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C0642a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C0642a) invokeV.objValue;
    }

    public a(String str, ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, responseCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11721b = "GET";
        this.f11725f = false;
        this.f11726g = false;
        this.f11727h = false;
        this.j = 6;
        this.k = 0;
        this.f11720a = str;
        this.f11724e = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, requestBody, responseCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f11721b = "GET";
        this.f11725f = false;
        this.f11726g = false;
        this.f11727h = false;
        this.j = 6;
        this.k = 0;
        this.f11720a = str;
        this.f11723d = requestBody;
        this.f11724e = responseCallback;
    }
}
