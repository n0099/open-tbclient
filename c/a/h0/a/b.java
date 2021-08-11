package c.a.h0.a;

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
    public JSONObject f3246a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.h0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0067b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f3247a;

        public C0067b(String str, String str2) {
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
            this.f3247a = new JSONObject();
            F("material_type", str);
            F("material_url", str2);
        }

        public C0067b A(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                try {
                    this.f3247a.put("skip_btn_width", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                try {
                    this.f3247a.put("skipTime", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b C(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                try {
                    this.f3247a.put("small_logo_height", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b D(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                try {
                    this.f3247a.put("small_logo_width", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b E(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
                try {
                    this.f3247a.put("style", jSONObject);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public final void F(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
                try {
                    this.f3247a.put(str, str2);
                } catch (Throwable th) {
                    c.a.h0.a.k.b.i().g(th);
                }
            }
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new b(this.f3247a, null) : (b) invokeV.objValue;
        }

        public C0067b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                try {
                    this.f3247a.put("ad_click_opt", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                try {
                    this.f3247a.put("ad_label", str);
                    if (TextUtils.isEmpty(str)) {
                        this.f3247a.put("hide_ad_logo", false);
                    }
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                try {
                    this.f3247a.put("ad_label_height", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                try {
                    this.f3247a.put("ad_label_width", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                try {
                    this.f3247a.put("publisher", str);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                try {
                    this.f3247a.put("app_version", str);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                try {
                    this.f3247a.put("bottom_logo_height", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                try {
                    this.f3247a.put("close_type", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                try {
                    this.f3247a.put("displayMantle", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                try {
                    this.f3247a.put("bitmapDisplayMode", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                try {
                    this.f3247a.put("full_screen", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
                try {
                    this.f3247a.put("host_big_logo_res_id", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                try {
                    this.f3247a.put("host_small_logo_res_id", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                try {
                    this.f3247a.put("show_host_small_logo", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b p(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, jSONObject)) == null) {
                try {
                    this.f3247a.put("inner_style", jSONObject);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                F("lottie_url", str);
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                try {
                    this.f3247a.put("mantleActionText", str);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                try {
                    this.f3247a.put("mantleBottomMargin", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                F("prod", str);
                return this;
            }
            return (C0067b) invokeL.objValue;
        }

        public C0067b u(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
                try {
                    this.f3247a.put("hide_bd_logo", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b v(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
                try {
                    this.f3247a.put("Display_Down_Info", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b w(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
                try {
                    this.f3247a.put("lottie_show", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b x(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
                try {
                    this.f3247a.put("show_wifi_view", z);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeZ.objValue;
        }

        public C0067b y(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                try {
                    this.f3247a.put("skip_btn_height", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }

        public C0067b z(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
                try {
                    this.f3247a.put("skip_btn_type", i2);
                } catch (JSONException e2) {
                    c.a.h0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0067b) invokeI.objValue;
        }
    }

    public /* synthetic */ b(JSONObject jSONObject, a aVar) {
        this(jSONObject);
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3246a : (JSONObject) invokeV.objValue;
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
        this.f3246a = jSONObject;
    }
}
