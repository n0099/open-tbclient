package c.a.l0.a;

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
    public JSONObject a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.l0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0166b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;

        public C0166b(String str, String str2) {
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
            this.a = new JSONObject();
            D("material_type", str);
            D("material_url", str2);
        }

        public C0166b A(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                try {
                    this.a.put("small_logo_height", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                try {
                    this.a.put("small_logo_width", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b C(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                try {
                    this.a.put("style", jSONObject);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public final void D(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
                try {
                    this.a.put(str, str2);
                } catch (Throwable th) {
                    c.a.l0.a.l.b.i().g(th);
                }
            }
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this.a, null) : (b) invokeV.objValue;
        }

        public C0166b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                try {
                    this.a.put("ad_click_opt", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                try {
                    this.a.put("ad_label", str);
                    if (TextUtils.isEmpty(str)) {
                        this.a.put("hide_ad_logo", false);
                    }
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public C0166b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                try {
                    this.a.put("ad_label_height", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                try {
                    this.a.put("ad_label_width", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                try {
                    this.a.put("bottom_logo_height", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                try {
                    this.a.put("close_type", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                try {
                    this.a.put("bitmapDisplayMode", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                try {
                    this.a.put("full_screen", z);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeZ.objValue;
        }

        public C0166b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                D("gesture_lottie_url", str);
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public C0166b k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                try {
                    this.a.put("gesture_lottie_sensitivity", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b l(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                try {
                    this.a.put("gesture_lottie_type", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                try {
                    this.a.put("host_big_logo_res_id", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                try {
                    this.a.put("host_small_logo_res_id", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                try {
                    this.a.put("show_host_small_logo", z);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeZ.objValue;
        }

        public C0166b p(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSONObject)) == null) {
                try {
                    this.a.put("inner_style", jSONObject);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public C0166b q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                D("lottie_url", str);
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public C0166b r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                try {
                    this.a.put("mantleActionText", str);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public C0166b s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                try {
                    this.a.put("mantleBottomMargin", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                D("prod", str);
                return this;
            }
            return (C0166b) invokeL.objValue;
        }

        public C0166b u(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
                try {
                    this.a.put("lottie_show", z);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeZ.objValue;
        }

        public C0166b v(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                try {
                    this.a.put("show_wifi_view", z);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeZ.objValue;
        }

        public C0166b w(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
                try {
                    this.a.put("skip_btn_height", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b x(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
                try {
                    this.a.put("skip_btn_type", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b y(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
                try {
                    this.a.put("skip_btn_width", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }

        public C0166b z(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
                try {
                    this.a.put("skipTime", i2);
                } catch (JSONException e2) {
                    c.a.l0.a.l.b.i().g(e2);
                }
                return this;
            }
            return (C0166b) invokeI.objValue;
        }
    }

    public /* synthetic */ b(JSONObject jSONObject, a aVar) {
        this(jSONObject);
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (JSONObject) invokeV.objValue;
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
        this.a = jSONObject;
    }
}
