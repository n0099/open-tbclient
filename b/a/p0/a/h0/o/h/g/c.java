package b.a.p0.a.h0.o.h.g;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class c implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f5684a;

    /* renamed from: b  reason: collision with root package name */
    public String f5685b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f5686c;

    /* renamed from: d  reason: collision with root package name */
    public int f5687d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5688e;

    /* renamed from: f  reason: collision with root package name */
    public String f5689f;

    public c(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {copyOnWriteArrayList, str, map, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5684a = copyOnWriteArrayList;
        this.f5685b = str;
        this.f5686c = map;
        this.f5687d = i2;
        this.f5688e = z;
    }

    @Override // b.a.p0.a.h0.o.h.g.g
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f5689f = str;
        }
    }

    @Override // b.a.p0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f5687d >= this.f5684a.size()) {
                return null;
            }
            return this.f5684a.get(this.f5687d).h(new c(this.f5684a, this.f5685b, this.f5686c, this.f5687d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // b.a.p0.a.h0.o.h.g.g
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5688e : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.o.h.g.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5685b : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.o.h.g.g
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f5689f)) {
                this.f5689f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f5685b));
            }
            return this.f5689f;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5686c : (Map) invokeV.objValue;
    }
}
