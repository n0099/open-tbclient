package c.a.p0.a.v2.b1.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.a1.e;
import c.a.p0.a.k;
import c.a.p0.a.v2.b1.a.b;
import c.a.p0.a.v2.j;
import c.a.p0.n.j.i.m;
import c.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends j.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f9294c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f9295b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1239323755, "Lc/a/p0/a/v2/b1/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1239323755, "Lc/a/p0/a/v2/b1/b/a;");
                return;
            }
        }
        f9294c = k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String str = z ? "swan_js_native_v8_ab.txt" : "swan_js_native_webview_ab.txt";
        this.f9295b = e.g().getPath() + File.separator + "js_native" + File.separator + str;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            String str = e.g().getPath() + File.separator + "js_native" + File.separator;
            if ((i2 & 1) != 0) {
                z = d.L(str + "swan_js_native_v8_ab.txt");
            } else {
                z = true;
            }
            if ((i2 & 2) != 0) {
                return z & d.L(str + "swan_js_native_webview_ab.txt");
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    @Nullable
    public final List<String> b(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str)) == null) {
            List<JSONObject> b2 = c.a.p0.a.v2.b1.a.a.b(z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW, z ? "swan/v8_ab" : "swan/webview_ab");
            if (b2 != null) {
                File file = new File(str);
                ArrayList arrayList = new ArrayList();
                for (JSONObject jSONObject : b2) {
                    if (jSONObject != null) {
                        arrayList.add(jSONObject.toString());
                    }
                }
                if (file.exists()) {
                    d.K(file);
                }
                d.h(file);
                d.O(arrayList, file);
                return arrayList;
            }
            return null;
        }
        return (List) invokeZL.objValue;
    }

    public boolean c(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            if (jSONArray.length() <= 0 || !d.u(this.f9295b)) {
                return false;
            }
            return b.a(jSONArray, new File(this.f9295b), SchemeCollecter.getSchemesDesListSize(this.f9352a ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW));
        }
        return invokeL.booleanValue;
    }

    public List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = f9294c;
            if (!m.b() && !TextUtils.equals(m.a(), "0")) {
                File file = new File(this.f9295b);
                if (file.exists()) {
                    d.K(file);
                }
            }
            if (d.u(this.f9295b)) {
                boolean z2 = f9294c;
                return d.E(new File(this.f9295b));
            }
            return b(this.f9352a, this.f9295b);
        }
        return (List) invokeV.objValue;
    }
}
