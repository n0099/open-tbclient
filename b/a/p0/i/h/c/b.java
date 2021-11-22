package b.a.p0.i.h.c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import b.a.p0.a.d2.e;
import b.a.p0.a.k;
import b.a.p0.a.z2.a0;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends b.a.p0.i.e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10832c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-829979398, "Lb/a/p0/i/h/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-829979398, "Lb/a/p0/i/h/c/b;");
                return;
            }
        }
        f10832c = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("startPermissionsPage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.i.e.a
    public b.a.p0.a.u.h.b a(JSONObject jSONObject, b.a.p0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            e a0 = e.a0();
            if (a0 != null && a0.x() != null) {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                    str = str.toLowerCase(Locale.US);
                }
                if (TextUtils.equals(str, RomUtils.MANUFACTURER_OPPO)) {
                    try {
                        Intent intent = new Intent(a0.x().getPackageName());
                        intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                        a0.x().startActivity(intent);
                    } catch (Exception e2) {
                        if (f10832c) {
                            e2.printStackTrace();
                        }
                        a0.f(a0.x());
                    }
                } else {
                    a0.g(a0.x());
                }
                bVar.a(null);
            } else {
                boolean z = f10832c;
            }
            return null;
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }
}
