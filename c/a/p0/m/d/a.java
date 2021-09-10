package c.a.p0.m.d;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11840a;

    /* renamed from: b  reason: collision with root package name */
    public String f11841b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11842c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f11843d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f11844e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11845f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11846g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11847h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11848i;

    /* renamed from: j  reason: collision with root package name */
    public int f11849j;
    public int k;
    public C0618a l;

    /* renamed from: c.a.p0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11850a;

        /* renamed from: b  reason: collision with root package name */
        public int f11851b;

        /* renamed from: c  reason: collision with root package name */
        public int f11852c;
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
        this.f11841b = "GET";
        this.f11845f = false;
        this.f11846g = false;
        this.f11847h = false;
        this.f11849j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f11843d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C0618a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C0618a) invokeV.objValue;
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
        this.f11841b = "GET";
        this.f11845f = false;
        this.f11846g = false;
        this.f11847h = false;
        this.f11849j = 6;
        this.k = 0;
        this.f11840a = str;
        this.f11844e = responseCallback;
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
        this.f11841b = "GET";
        this.f11845f = false;
        this.f11846g = false;
        this.f11847h = false;
        this.f11849j = 6;
        this.k = 0;
        this.f11840a = str;
        this.f11843d = requestBody;
        this.f11844e = responseCallback;
    }
}
