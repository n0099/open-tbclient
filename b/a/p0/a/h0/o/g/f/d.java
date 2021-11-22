package b.a.p0.a.h0.o.g.f;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import b.a.p0.a.h0.o.g.f.h;
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
public final class d implements h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f5975a;

    /* renamed from: b  reason: collision with root package name */
    public String f5976b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f5977c;

    /* renamed from: d  reason: collision with root package name */
    public int f5978d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5979e;

    /* renamed from: f  reason: collision with root package name */
    public String f5980f;

    public d(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
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
        this.f5975a = copyOnWriteArrayList;
        this.f5976b = str;
        this.f5977c = map;
        this.f5978d = i2;
        this.f5979e = z;
    }

    @Override // b.a.p0.a.h0.o.g.f.h.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f5980f = str;
        }
    }

    @Override // b.a.p0.a.h0.o.g.f.h.a
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f5978d >= this.f5975a.size()) {
                return null;
            }
            return this.f5975a.get(this.f5978d).a(new d(this.f5975a, this.f5976b, this.f5977c, this.f5978d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // b.a.p0.a.h0.o.g.f.h.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5979e : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.o.g.f.h.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5976b : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.o.g.f.h.a
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f5980f)) {
                this.f5980f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f5976b));
            }
            return this.f5980f;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.o.g.f.h.a
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5977c : (Map) invokeV.objValue;
    }
}
