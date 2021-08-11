package c.b.c.b.n;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.c.b.l;
import c.b.c.b.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f31398b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Context f31399a;

    public a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31399a = context;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31398b == null) {
                f31398b = new a(m.e());
            }
            return f31398b;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public String b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.length() > 0) {
                try {
                    return l.e.b(l.i.a(this.f31399a), l.i.b(), com.bytedance.tea.crash.upload.b.f(m.a().a()), jSONObject, com.bytedance.tea.crash.upload.b.g());
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && jSONObject != null && jSONObject.length() > 0) {
            try {
                String f2 = com.bytedance.tea.crash.upload.b.f(m.a().a());
                String b2 = l.e.b(l.i.a(this.f31399a), l.i.d(), f2, jSONObject, com.bytedance.tea.crash.upload.b.k());
                jSONObject.put("upload_scene", "direct");
                if (!com.bytedance.tea.crash.upload.b.j(f2, jSONObject.toString()).a()) {
                    return;
                }
                l.e.h(b2);
            } catch (Throwable unused) {
            }
        }
    }
}
