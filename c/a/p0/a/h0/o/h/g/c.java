package c.a.p0.a.h0.o.h.g;

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
    public CopyOnWriteArrayList<a> f6342a;

    /* renamed from: b  reason: collision with root package name */
    public String f6343b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f6344c;

    /* renamed from: d  reason: collision with root package name */
    public int f6345d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6346e;

    /* renamed from: f  reason: collision with root package name */
    public String f6347f;

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
        this.f6342a = copyOnWriteArrayList;
        this.f6343b = str;
        this.f6344c = map;
        this.f6345d = i2;
        this.f6346e = z;
    }

    @Override // c.a.p0.a.h0.o.h.g.g
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f6347f = str;
        }
    }

    @Override // c.a.p0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z)) == null) {
            if (this.f6345d >= this.f6342a.size()) {
                return null;
            }
            return this.f6342a.get(this.f6345d).h(new c(this.f6342a, this.f6343b, this.f6344c, this.f6345d + 1, z));
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }

    @Override // c.a.p0.a.h0.o.h.g.g
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6346e : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.o.h.g.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6343b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.o.h.g.g
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f6347f)) {
                this.f6347f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f6343b));
            }
            return this.f6347f;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6344c : (Map) invokeV.objValue;
    }
}
