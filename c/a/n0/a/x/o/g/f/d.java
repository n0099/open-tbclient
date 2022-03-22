package c.a.n0.a.x.o.g.f;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import c.a.n0.a.x.o.g.f.h;
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
    public CopyOnWriteArrayList<a> a;

    /* renamed from: b  reason: collision with root package name */
    public String f7361b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f7362c;

    /* renamed from: d  reason: collision with root package name */
    public int f7363d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7364e;

    /* renamed from: f  reason: collision with root package name */
    public String f7365f;

    public d(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {copyOnWriteArrayList, str, map, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = copyOnWriteArrayList;
        this.f7361b = str;
        this.f7362c = map;
        this.f7363d = i;
        this.f7364e = z;
    }

    @Override // c.a.n0.a.x.o.g.f.h.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f7365f = str;
        }
    }

    @Override // c.a.n0.a.x.o.g.f.h.a
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f7363d >= this.a.size()) {
                return null;
            }
            return this.a.get(this.f7363d).a(new d(this.a, this.f7361b, this.f7362c, this.f7363d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // c.a.n0.a.x.o.g.f.h.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7364e : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.o.g.f.h.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7361b : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.o.g.f.h.a
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f7365f)) {
                this.f7365f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f7361b));
            }
            return this.f7365f;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.o.g.f.h.a
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7362c : (Map) invokeV.objValue;
    }
}
