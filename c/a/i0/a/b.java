package c.a.i0.a;

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

    /* renamed from: c.a.i0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0144b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;

        public C0144b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new JSONObject();
            D("material_type", str);
            D("material_url", str2);
        }

        public C0144b A(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                try {
                    this.a.put("small_logo_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b B(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                try {
                    this.a.put("small_logo_width", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b C(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                try {
                    this.a.put("style", jSONObject);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public final void D(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
                try {
                    this.a.put(str, str2);
                } catch (Throwable unused) {
                }
            }
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this.a, null) : (b) invokeV.objValue;
        }

        public C0144b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                try {
                    this.a.put("ad_click_opt", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                try {
                    this.a.put("ad_label", str);
                    if (TextUtils.isEmpty(str)) {
                        this.a.put("hide_ad_logo", false);
                    }
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public C0144b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                try {
                    this.a.put("ad_label_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                try {
                    this.a.put("ad_label_width", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                try {
                    this.a.put("bottom_logo_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                try {
                    this.a.put("close_type", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                try {
                    this.a.put("bitmapDisplayMode", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                try {
                    this.a.put("full_screen", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeZ.objValue;
        }

        public C0144b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                D("gesture_lottie_url", str);
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public C0144b k(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                try {
                    this.a.put("gesture_lottie_sensitivity", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b l(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                try {
                    this.a.put("gesture_lottie_type", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                try {
                    this.a.put("host_big_logo_res_id", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                try {
                    this.a.put("host_small_logo_res_id", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                try {
                    this.a.put("show_host_small_logo", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeZ.objValue;
        }

        public C0144b p(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSONObject)) == null) {
                try {
                    this.a.put("inner_style", jSONObject);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public C0144b q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                D("lottie_url", str);
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public C0144b r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                try {
                    this.a.put("mantleActionText", str);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public C0144b s(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                try {
                    this.a.put("mantleBottomMargin", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                D("prod", str);
                return this;
            }
            return (C0144b) invokeL.objValue;
        }

        public C0144b u(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
                try {
                    this.a.put("lottie_show", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeZ.objValue;
        }

        public C0144b v(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                try {
                    this.a.put("show_wifi_view", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeZ.objValue;
        }

        public C0144b w(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
                try {
                    this.a.put("skip_btn_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b x(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                try {
                    this.a.put("skip_btn_type", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b y(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
                try {
                    this.a.put("skip_btn_width", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
        }

        public C0144b z(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
                try {
                    this.a.put("skipTime", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (C0144b) invokeI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONObject;
    }
}
