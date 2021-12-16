package c.a.r0.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FloatStrategy;
/* loaded from: classes6.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11980b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11981c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;

        /* renamed from: b  reason: collision with root package name */
        public String f11982b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f11983c;

        /* renamed from: d  reason: collision with root package name */
        public Long f11984d;

        /* renamed from: e  reason: collision with root package name */
        public Long f11985e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f11986f;

        /* renamed from: g  reason: collision with root package name */
        public String f11987g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final o a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-678796794, "Lc/a/r0/a/o$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-678796794, "Lc/a/r0/a/o$c;");
                    return;
                }
            }
            a = new o(null);
        }
    }

    public /* synthetic */ o(a aVar) {
        this();
    }

    public static o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (o) invokeV.objValue;
    }

    public final void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bVar, z) == null) || bVar == null) {
            return;
        }
        try {
            if (this.a) {
                boolean g2 = c.a.r0.s.g0.b.j().g("pref_key_task_first_open", true);
                int k2 = c.a.r0.s.g0.b.j().k("pref_key_float_tip_num", 0);
                long l = c.a.r0.s.g0.b.j().l("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (g2) {
                    if (e(bVar)) {
                        this.f11981c = true;
                        c.a.r0.s.g0.b.j().t("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, l / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.f11981c = true;
                            c.a.r0.s.g0.b.j().v("pref_key_float_tip_num", 0);
                        }
                    } else if (k2 >= bVar.f11986f.intValue() || !e(bVar)) {
                    } else {
                        this.f11981c = true;
                        c.a.r0.s.g0.b.j().v("pref_key_float_tip_num", k2 + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(c.a.r0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            int x = cVar.x();
            return x == 5 || x == 6 || x == 7 || x == 8;
        }
        return invokeL.booleanValue;
    }

    public final boolean d(b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (bVar != null && j3 > 0 && !TextUtils.isEmpty(bVar.f11982b) && bVar.f11984d.longValue() < bVar.f11985e.longValue() && j2 >= bVar.f11984d.longValue() && j2 <= bVar.f11985e.longValue() && bVar.f11986f.intValue() > 0 && bVar.a.intValue() >= 0 && j2 > j3) {
                String[] split = bVar.f11982b.split(",");
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        if ("3".equals(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
                long intValue = bVar.a.intValue() * 86400;
                long j4 = j2 - j3;
                if (j4 > intValue && j4 < intValue + 86400) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2921409, bVar), Boolean.class);
            if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Boolean)) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.r0.s.g0.b.j().x("pref_key_strategy_json", str);
            c.a.r0.s.g0.b.j().v("pref_key_float_tip_num", 0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.s.g0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void h(c.a.r0.a.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && cVar != null && c(cVar)) {
            c.a.r0.s.g0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(c.a.r0.a.b0.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.a() == null || bVar.a().size() <= 0) {
            return;
        }
        ArrayList<FloatStrategy> a2 = bVar.a();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<FloatStrategy> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar2 = null;
                break;
            }
            FloatStrategy next = it.next();
            if (currentTimeMillis > next.show_time_begin.longValue() && currentTimeMillis < next.show_time_end.longValue()) {
                bVar2 = new b();
                bVar2.f11982b = next.browsetimepage;
                bVar2.f11983c = next.duration;
                bVar2.f11986f = next.show_num;
                bVar2.f11984d = next.show_time_begin;
                bVar2.f11985e = next.show_time_end;
                bVar2.f11987g = next.toast;
                bVar2.a = next.un_do_mission;
                break;
            }
        }
        if (bVar2 == null) {
            f("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("un_do_mission", bVar2.a.intValue());
            jSONObject.put("browsetimepage", bVar2.f11982b);
            jSONObject.put("duration", bVar2.f11983c.intValue());
            jSONObject.put("show_time_begin", bVar2.f11984d.longValue());
            jSONObject.put("show_time_end", bVar2.f11985e.longValue());
            jSONObject.put("show_num", bVar2.f11986f.intValue());
            jSONObject.put("toast", bVar2.f11987g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(c.a.r0.s.g0.b.j().p("pref_key_strategy_json", null))) {
                f(jSONObject2);
            }
            a(bVar2, true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (z && this.f11980b) {
                this.f11980b = false;
                if (!this.f11981c && d.y().t()) {
                    String p = c.a.r0.s.g0.b.j().p("pref_key_strategy_json", null);
                    if (TextUtils.isEmpty(p)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(p);
                        b bVar = new b();
                        bVar.a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                        bVar.f11982b = jSONObject.optString("browsetimepage", "");
                        bVar.f11983c = Integer.valueOf(jSONObject.optInt("duration", 0));
                        bVar.f11984d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                        bVar.f11985e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                        bVar.f11986f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                        bVar.f11987g = jSONObject.optString("toast", null);
                        a(bVar, false);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public o() {
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
        this.a = false;
        this.f11980b = true;
        this.f11981c = false;
    }
}
