package c.a.n0.m.d;

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
    public String f11566a;

    /* renamed from: b  reason: collision with root package name */
    public String f11567b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11568c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f11569d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f11570e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11571f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11572g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11573h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11574i;

    /* renamed from: j  reason: collision with root package name */
    public int f11575j;
    public int k;
    public C0608a l;

    /* renamed from: c.a.n0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0608a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11576a;

        /* renamed from: b  reason: collision with root package name */
        public int f11577b;

        /* renamed from: c  reason: collision with root package name */
        public int f11578c;
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
        this.f11567b = "GET";
        this.f11571f = false;
        this.f11572g = false;
        this.f11573h = false;
        this.f11575j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f11569d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C0608a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C0608a) invokeV.objValue;
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
        this.f11567b = "GET";
        this.f11571f = false;
        this.f11572g = false;
        this.f11573h = false;
        this.f11575j = 6;
        this.k = 0;
        this.f11566a = str;
        this.f11570e = responseCallback;
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
        this.f11567b = "GET";
        this.f11571f = false;
        this.f11572g = false;
        this.f11573h = false;
        this.f11575j = 6;
        this.k = 0;
        this.f11566a = str;
        this.f11569d = requestBody;
        this.f11570e = responseCallback;
    }
}
