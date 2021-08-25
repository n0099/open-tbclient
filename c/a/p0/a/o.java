package c.a.p0.a;

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
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12627a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12628b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12629c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Integer f12630a;

        /* renamed from: b  reason: collision with root package name */
        public String f12631b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f12632c;

        /* renamed from: d  reason: collision with root package name */
        public Long f12633d;

        /* renamed from: e  reason: collision with root package name */
        public Long f12634e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f12635f;

        /* renamed from: g  reason: collision with root package name */
        public String f12636g;

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

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final o f12637a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358855164, "Lc/a/p0/a/o$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1358855164, "Lc/a/p0/a/o$c;");
                    return;
                }
            }
            f12637a = new o(null);
        }
    }

    public /* synthetic */ o(a aVar) {
        this();
    }

    public static o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f12637a : (o) invokeV.objValue;
    }

    public final void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bVar, z) == null) || bVar == null) {
            return;
        }
        try {
            if (this.f12627a) {
                boolean g2 = c.a.p0.s.d0.b.j().g("pref_key_task_first_open", true);
                int k = c.a.p0.s.d0.b.j().k("pref_key_float_tip_num", 0);
                long l = c.a.p0.s.d0.b.j().l("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (g2) {
                    if (e(bVar)) {
                        this.f12629c = true;
                        c.a.p0.s.d0.b.j().t("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, l / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.f12629c = true;
                            c.a.p0.s.d0.b.j().v("pref_key_float_tip_num", 0);
                        }
                    } else if (k >= bVar.f12635f.intValue() || !e(bVar)) {
                    } else {
                        this.f12629c = true;
                        c.a.p0.s.d0.b.j().v("pref_key_float_tip_num", k + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(c.a.p0.a.c cVar) {
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
            if (bVar != null && j3 > 0 && !TextUtils.isEmpty(bVar.f12631b) && bVar.f12633d.longValue() < bVar.f12634e.longValue() && j2 >= bVar.f12633d.longValue() && j2 <= bVar.f12634e.longValue() && bVar.f12635f.intValue() > 0 && bVar.f12630a.intValue() >= 0 && j2 > j3) {
                String[] split = bVar.f12631b.split(",");
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
                long intValue = bVar.f12630a.intValue() * 86400;
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
            c.a.p0.s.d0.b.j().x("pref_key_strategy_json", str);
            c.a.p0.s.d0.b.j().v("pref_key_float_tip_num", 0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.s.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void h(c.a.p0.a.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && cVar != null && c(cVar)) {
            c.a.p0.s.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(c.a.p0.a.b0.b bVar) {
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
                bVar2.f12631b = next.browsetimepage;
                bVar2.f12632c = next.duration;
                bVar2.f12635f = next.show_num;
                bVar2.f12633d = next.show_time_begin;
                bVar2.f12634e = next.show_time_end;
                bVar2.f12636g = next.toast;
                bVar2.f12630a = next.un_do_mission;
                break;
            }
        }
        if (bVar2 == null) {
            f("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("un_do_mission", bVar2.f12630a.intValue());
            jSONObject.put("browsetimepage", bVar2.f12631b);
            jSONObject.put("duration", bVar2.f12632c.intValue());
            jSONObject.put("show_time_begin", bVar2.f12633d.longValue());
            jSONObject.put("show_time_end", bVar2.f12634e.longValue());
            jSONObject.put("show_num", bVar2.f12635f.intValue());
            jSONObject.put("toast", bVar2.f12636g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(c.a.p0.s.d0.b.j().p("pref_key_strategy_json", null))) {
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
            this.f12627a = z;
            if (z && this.f12628b) {
                this.f12628b = false;
                if (!this.f12629c && d.y().t()) {
                    String p = c.a.p0.s.d0.b.j().p("pref_key_strategy_json", null);
                    if (TextUtils.isEmpty(p)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(p);
                        b bVar = new b();
                        bVar.f12630a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                        bVar.f12631b = jSONObject.optString("browsetimepage", "");
                        bVar.f12632c = Integer.valueOf(jSONObject.optInt("duration", 0));
                        bVar.f12633d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                        bVar.f12634e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                        bVar.f12635f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                        bVar.f12636g = jSONObject.optString("toast", null);
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
        this.f12627a = false;
        this.f12628b = true;
        this.f12629c = false;
    }
}
