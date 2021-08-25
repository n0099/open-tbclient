package c.a.o0.m.d;

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
    public String f11812a;

    /* renamed from: b  reason: collision with root package name */
    public String f11813b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11814c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f11815d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f11816e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11817f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11818g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11819h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11820i;

    /* renamed from: j  reason: collision with root package name */
    public int f11821j;
    public int k;
    public C0616a l;

    /* renamed from: c.a.o0.m.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0616a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f11822a;

        /* renamed from: b  reason: collision with root package name */
        public int f11823b;

        /* renamed from: c  reason: collision with root package name */
        public int f11824c;
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
        this.f11813b = "GET";
        this.f11817f = false;
        this.f11818g = false;
        this.f11819h = false;
        this.f11821j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f11815d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C0616a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C0616a) invokeV.objValue;
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
        this.f11813b = "GET";
        this.f11817f = false;
        this.f11818g = false;
        this.f11819h = false;
        this.f11821j = 6;
        this.k = 0;
        this.f11812a = str;
        this.f11816e = responseCallback;
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
        this.f11813b = "GET";
        this.f11817f = false;
        this.f11818g = false;
        this.f11819h = false;
        this.f11821j = 6;
        this.k = 0;
        this.f11812a = str;
        this.f11815d = requestBody;
        this.f11816e = responseCallback;
    }
}
