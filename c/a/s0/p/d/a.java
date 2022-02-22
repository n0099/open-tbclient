package c.a.s0.p.d;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11691b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11692c;

    /* renamed from: d  reason: collision with root package name */
    public RequestBody f11693d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseCallback f11694e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11695f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11696g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11697h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11698i;

    /* renamed from: j  reason: collision with root package name */
    public int f11699j;
    public int k;
    public C0811a l;

    /* renamed from: c.a.s0.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0811a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f11700b;

        /* renamed from: c  reason: collision with root package name */
        public int f11701c;
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
        this.f11691b = "GET";
        this.f11695f = false;
        this.f11696g = false;
        this.f11697h = false;
        this.f11699j = 6;
        this.k = 0;
    }

    public a a(MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaType, str)) == null) {
            if (mediaType != null && str != null) {
                this.f11693d = RequestBody.create(mediaType, str);
            }
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public C0811a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (C0811a) invokeV.objValue;
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
        this.f11691b = "GET";
        this.f11695f = false;
        this.f11696g = false;
        this.f11697h = false;
        this.f11699j = 6;
        this.k = 0;
        this.a = str;
        this.f11694e = responseCallback;
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
        this.f11691b = "GET";
        this.f11695f = false;
        this.f11696g = false;
        this.f11697h = false;
        this.f11699j = 6;
        this.k = 0;
        this.a = str;
        this.f11693d = requestBody;
        this.f11694e = responseCallback;
    }
}
