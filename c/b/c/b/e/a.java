package c.b.c.b.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.b.c.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f31520a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31520a = new JSONObject();
    }

    public static a c(long j2, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), context, thread, th})) == null) {
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
            }
            a aVar = new a();
            aVar.k("isJava", 1);
            aVar.k(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "java_crash");
            aVar.k("timestamp", Long.valueOf(System.currentTimeMillis()));
            aVar.k("data", l.n.a(th));
            aVar.k("isOOM", Boolean.valueOf(l.n.h(th)));
            aVar.k("crash_time", Long.valueOf(j2));
            aVar.k("process_name", l.b.k(context));
            if (!l.b.i(context)) {
                aVar.k("remote_process", 1);
            }
            l.b.d(context, aVar.j());
            String name = thread == null ? null : thread.getName();
            if (name != null) {
                aVar.k("crash_thread_name", name);
            }
            aVar.k("all_thread_stacks", l.n.d(name));
            return aVar;
        }
        return (a) invokeCommon.objValue;
    }

    public a a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) == null) {
            try {
                this.f31520a.put("miniapp_id", i2);
                this.f31520a.put("miniapp_version", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            try {
                k(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, Long.valueOf(j2));
                k("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j2)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            k("header", bVar.b());
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a e(c.b.c.b.h.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            k("activity_trace", bVar.d());
            k("running_tasks", bVar.i());
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                k("session_id", str);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    jSONArray.put(str);
                }
                k("patch_info", jSONArray);
                return this;
            }
            k("patch_info", jSONArray);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a h(Map<String, Integer> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (map == null) {
                this.f31520a.put("plugin_info", jSONArray);
                return this;
            }
            for (String str : map.keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", str);
                jSONObject.put("version_code", map.get(str));
                jSONArray.put(jSONObject);
            }
            this.f31520a.put("plugin_info", jSONArray);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            k("storage", jSONObject);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public JSONObject j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31520a : (JSONObject) invokeV.objValue;
    }

    public void k(@NonNull String str, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, obj) == null) {
            try {
                this.f31520a.put(str, obj);
            } catch (Exception e2) {
                l.k.c(e2);
            }
        }
    }

    public a l(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            k("logcat", jSONArray);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a m(Map<Integer, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, map)) == null) {
            if (map != null && map.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (Integer num : map.keySet()) {
                    try {
                        jSONObject.put(String.valueOf(num), map.get(num));
                    } catch (JSONException e2) {
                        l.k.c(e2);
                    }
                }
                try {
                    this.f31520a.put("sdk_info", jSONObject);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a n(Map<? extends String, ? extends String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, map)) == null) {
            if (map != null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                k("filters", jSONObject);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31520a = jSONObject;
    }
}
