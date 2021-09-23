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
    public String f11848a;

    /* renamed from: b  reason: collision with root package name */
    public String f11849b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11850c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f11851d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f11852e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11853f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11854g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11855h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11856i;

    /* renamed from: j  reason: collision with root package name */
    public int f11857j;
    public int k;
    public C0618a l;

    /* renamed from: c.a.p0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11858a;

        /* renamed from: b  reason: collision with root package name */
        public int f11859b;

        /* renamed from: c  reason: collision with root package name */
        public int f11860c;
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
        this.f11849b = "GET";
        this.f11853f = false;
        this.f11854g = false;
        this.f11855h = false;
        this.f11857j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f11851d = RequestBody.create(mediaType, str);
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
        this.f11849b = "GET";
        this.f11853f = false;
        this.f11854g = false;
        this.f11855h = false;
        this.f11857j = 6;
        this.k = 0;
        this.f11848a = str;
        this.f11852e = responseCallback;
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
        this.f11849b = "GET";
        this.f11853f = false;
        this.f11854g = false;
        this.f11855h = false;
        this.f11857j = 6;
        this.k = 0;
        this.f11848a = str;
        this.f11851d = requestBody;
        this.f11852e = responseCallback;
    }
}
