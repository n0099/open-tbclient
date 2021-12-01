package c.a.p0.p.d;

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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10670b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f10671c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f10672d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f10673e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10674f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10675g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10676h;

    /* renamed from: i  reason: collision with root package name */
    public Object f10677i;

    /* renamed from: j  reason: collision with root package name */
    public int f10678j;

    /* renamed from: k  reason: collision with root package name */
    public int f10679k;
    public C0698a l;

    /* renamed from: c.a.p0.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0698a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f10680b;

        /* renamed from: c  reason: collision with root package name */
        public int f10681c;
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
        this.f10670b = "GET";
        this.f10674f = false;
        this.f10675g = false;
        this.f10676h = false;
        this.f10678j = 6;
        this.f10679k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f10672d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C0698a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C0698a) invokeV.objValue;
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
        this.f10670b = "GET";
        this.f10674f = false;
        this.f10675g = false;
        this.f10676h = false;
        this.f10678j = 6;
        this.f10679k = 0;
        this.a = str;
        this.f10673e = responseCallback;
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
        this.f10670b = "GET";
        this.f10674f = false;
        this.f10675g = false;
        this.f10676h = false;
        this.f10678j = 6;
        this.f10679k = 0;
        this.a = str;
        this.f10672d = requestBody;
        this.f10673e = responseCallback;
    }
}
