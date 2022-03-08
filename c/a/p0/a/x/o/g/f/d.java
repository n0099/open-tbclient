package c.a.p0.a.x.o.g.f;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import c.a.p0.a.x.o.g.f.h;
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
    public String f8758b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f8759c;

    /* renamed from: d  reason: collision with root package name */
    public int f8760d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8761e;

    /* renamed from: f  reason: collision with root package name */
    public String f8762f;

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
        this.a = copyOnWriteArrayList;
        this.f8758b = str;
        this.f8759c = map;
        this.f8760d = i2;
        this.f8761e = z;
    }

    @Override // c.a.p0.a.x.o.g.f.h.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f8762f = str;
        }
    }

    @Override // c.a.p0.a.x.o.g.f.h.a
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f8760d >= this.a.size()) {
                return null;
            }
            return this.a.get(this.f8760d).a(new d(this.a, this.f8758b, this.f8759c, this.f8760d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // c.a.p0.a.x.o.g.f.h.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8761e : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.o.g.f.h.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8758b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.x.o.g.f.h.a
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f8762f)) {
                this.f8762f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f8758b));
            }
            return this.f8762f;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.x.o.g.f.h.a
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8759c : (Map) invokeV.objValue;
    }
}
