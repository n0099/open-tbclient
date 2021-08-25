package c.a.o0.a.h0.o.h.g;

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
    public CopyOnWriteArrayList<a> f6314a;

    /* renamed from: b  reason: collision with root package name */
    public String f6315b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6316c;

    /* renamed from: d  reason: collision with root package name */
    public int f6317d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6318e;

    /* renamed from: f  reason: collision with root package name */
    public String f6319f;

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
        this.f6314a = copyOnWriteArrayList;
        this.f6315b = str;
        this.f6316c = map;
        this.f6317d = i2;
        this.f6318e = z;
    }

    @Override // c.a.o0.a.h0.o.h.g.g
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f6319f = str;
        }
    }

    @Override // c.a.o0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f6317d >= this.f6314a.size()) {
                return null;
            }
            return this.f6314a.get(this.f6317d).h(new c(this.f6314a, this.f6315b, this.f6316c, this.f6317d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // c.a.o0.a.h0.o.h.g.g
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6318e : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.o.h.g.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6315b : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.o.h.g.g
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f6319f)) {
                this.f6319f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f6315b));
            }
            return this.f6319f;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6316c : (Map) invokeV.objValue;
    }
}
