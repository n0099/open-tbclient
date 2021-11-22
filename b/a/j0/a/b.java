package b.a.j0.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f3095a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.j0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0073b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f3096a;

        public C0073b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3096a = new JSONObject();
            I("material_type", str);
            I("material_url", str2);
        }

        public C0073b A(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.f3096a.put("show_wifi_view", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }

        public C0073b B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                try {
                    this.f3096a.put("skip_btn_height", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b C(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                try {
                    this.f3096a.put("skip_btn_type", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b D(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                try {
                    this.f3096a.put("skip_btn_width", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b E(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                try {
                    this.f3096a.put("skipTime", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b F(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                try {
                    this.f3096a.put("small_logo_height", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b G(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                try {
                    this.f3096a.put("small_logo_width", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b H(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
                try {
                    this.f3096a.put("style", jSONObject);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public final void I(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
                try {
                    this.f3096a.put(str, str2);
                } catch (Throwable th) {
                    b.a.j0.a.k.b.i().g(th);
                }
            }
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new b(this.f3096a, null) : (b) invokeV.objValue;
        }

        public C0073b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                try {
                    this.f3096a.put("ad_click_opt", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                try {
                    this.f3096a.put("ad_label", str);
                    if (TextUtils.isEmpty(str)) {
                        this.f3096a.put("hide_ad_logo", false);
                    }
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                try {
                    this.f3096a.put("ad_label_height", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                try {
                    this.f3096a.put("ad_label_width", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                try {
                    this.f3096a.put("publisher", str);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                try {
                    this.f3096a.put("app_version", str);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                try {
                    this.f3096a.put("bottom_logo_height", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                try {
                    this.f3096a.put("close_type", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                try {
                    this.f3096a.put("displayMantle", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }

        public C0073b k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                try {
                    this.f3096a.put("bitmapDisplayMode", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                try {
                    this.f3096a.put("full_screen", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }

        public C0073b m(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                I("gesture_lottie_url", str);
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                try {
                    this.f3096a.put("gesture_lottie_sensitivity", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
                try {
                    this.f3096a.put("gesture_lottie_type", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b p(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                try {
                    this.f3096a.put("host_big_logo_res_id", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b q(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
                try {
                    this.f3096a.put("host_small_logo_res_id", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b r(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
                try {
                    this.f3096a.put("show_host_small_logo", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }

        public C0073b s(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, jSONObject)) == null) {
                try {
                    this.f3096a.put("inner_style", jSONObject);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                I("lottie_url", str);
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b u(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                try {
                    this.f3096a.put("mantleActionText", str);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b v(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                try {
                    this.f3096a.put("mantleBottomMargin", i2);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeI.objValue;
        }

        public C0073b w(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                I("prod", str);
                return this;
            }
            return (C0073b) invokeL.objValue;
        }

        public C0073b x(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
                try {
                    this.f3096a.put("hide_bd_logo", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }

        public C0073b y(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
                try {
                    this.f3096a.put("Display_Down_Info", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }

        public C0073b z(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                try {
                    this.f3096a.put("lottie_show", z);
                } catch (JSONException e2) {
                    b.a.j0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0073b) invokeZ.objValue;
        }
    }

    public /* synthetic */ b(JSONObject jSONObject, a aVar) {
        this(jSONObject);
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3095a : (JSONObject) invokeV.objValue;
    }

    public b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3095a = jSONObject;
    }
}
