package b.a.p0.a.c2.f.i0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b.a.p0.a.e;
import b.a.p0.a.g;
import b.a.p0.a.h;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f4272f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f4273g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f4274a;

    /* renamed from: b  reason: collision with root package name */
    public FloatButton f4275b;

    /* renamed from: c  reason: collision with root package name */
    public String f4276c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f4277d;

    /* renamed from: e  reason: collision with root package name */
    public String f4278e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(772448719, "Lb/a/p0/a/c2/f/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(772448719, "Lb/a/p0/a/c2/f/i0/a;");
                return;
            }
        }
        f4272f = k.f6397a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4278e = "";
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4273g == null) {
                synchronized (a.class) {
                    if (f4273g == null) {
                        f4273g = new a();
                    }
                }
            }
            return f4273g;
        }
        return (a) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f4273g == null) {
            return;
        }
        f4273g = null;
    }

    public final FloatButton a(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, viewGroup)) == null) {
            if (context == null || viewGroup == null) {
                return null;
            }
            FloatButton e2 = e(context);
            viewGroup.addView(e2);
            return e2;
        }
        return (FloatButton) invokeLL.objValue;
    }

    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null || this.f4275b == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        String substring = dataString.substring(8);
        if (TextUtils.isEmpty(substring) || !substring.equals(this.f4278e)) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            this.f4276c = this.f4274a.getResources().getString(h.aiapps_tip_open_app);
        } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
            this.f4276c = this.f4274a.getResources().getString(h.swan_app_hover_button_download);
        }
        this.f4275b.setFloatButtonText(this.f4276c);
    }

    public FloatButton c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4275b : (FloatButton) invokeV.objValue;
    }

    public final FloatButton e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(g.swan_app_float_button, (ViewGroup) null);
        }
        return (FloatButton) invokeL.objValue;
    }

    public FloatButton f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity activity = this.f4274a;
            if (activity instanceof SwanAppActivity) {
                if (this.f4275b == null) {
                    this.f4275b = a(activity, (ViewGroup) activity.findViewById(16908290));
                }
                this.f4275b.setFloatButtonText(this.f4276c);
                this.f4275b.setFloatButtonDrawable(this.f4274a.getResources().getDrawable(e.swan_app_hover_button_shape));
                this.f4275b.setFloatButtonDefaultPosition();
                this.f4275b.setFloatButtonStyle(this.f4277d);
                this.f4275b.setVisibility(0);
                return this.f4275b;
            }
            return null;
        }
        return (FloatButton) invokeV.objValue;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, activity, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (f4272f) {
            jSONObject.toString();
        }
        this.f4274a = activity;
        String optString = jSONObject.optString("name");
        this.f4278e = optString;
        if (q0.F(activity, optString)) {
            string = activity.getString(h.aiapps_tip_open_app);
        } else {
            string = activity.getString(h.swan_app_hover_button_download);
        }
        this.f4276c = string;
        this.f4277d = jSONObject.optJSONObject("style");
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f4278e = str;
        }
    }

    public void j(FloatButton floatButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, floatButton) == null) {
            this.f4275b = floatButton;
        }
    }
}
