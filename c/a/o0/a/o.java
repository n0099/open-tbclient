package c.a.o0.a;

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
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9688b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9689c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;

        /* renamed from: b  reason: collision with root package name */
        public String f9690b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f9691c;

        /* renamed from: d  reason: collision with root package name */
        public Long f9692d;

        /* renamed from: e  reason: collision with root package name */
        public Long f9693e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f9694f;

        /* renamed from: g  reason: collision with root package name */
        public String f9695g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final o a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(448599299, "Lc/a/o0/a/o$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(448599299, "Lc/a/o0/a/o$c;");
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
                boolean h2 = c.a.o0.r.j0.b.k().h("pref_key_task_first_open", true);
                int l = c.a.o0.r.j0.b.k().l("pref_key_float_tip_num", 0);
                long m = c.a.o0.r.j0.b.k().m("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (h2) {
                    if (e(bVar)) {
                        this.f9689c = true;
                        c.a.o0.r.j0.b.k().u("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, m / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.f9689c = true;
                            c.a.o0.r.j0.b.k().w("pref_key_float_tip_num", 0);
                        }
                    } else if (l >= bVar.f9694f.intValue() || !e(bVar)) {
                    } else {
                        this.f9689c = true;
                        c.a.o0.r.j0.b.k().w("pref_key_float_tip_num", l + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(c.a.o0.a.c cVar) {
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

    public final boolean d(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar != null && j2 > 0 && !TextUtils.isEmpty(bVar.f9690b) && bVar.f9692d.longValue() < bVar.f9693e.longValue() && j >= bVar.f9692d.longValue() && j <= bVar.f9693e.longValue() && bVar.f9694f.intValue() > 0 && bVar.a.intValue() >= 0 && j > j2) {
                String[] split = bVar.f9690b.split(",");
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
                long j3 = j - j2;
                if (j3 > intValue && j3 < intValue + 86400) {
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
            c.a.o0.r.j0.b.k().y("pref_key_strategy_json", str);
            c.a.o0.r.j0.b.k().w("pref_key_float_tip_num", 0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.o0.r.j0.b.k().x("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void h(c.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && cVar != null && c(cVar)) {
            c.a.o0.r.j0.b.k().x("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(c.a.o0.a.b0.b bVar) {
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
                bVar2.f9690b = next.browsetimepage;
                bVar2.f9691c = next.duration;
                bVar2.f9694f = next.show_num;
                bVar2.f9692d = next.show_time_begin;
                bVar2.f9693e = next.show_time_end;
                bVar2.f9695g = next.toast;
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
            jSONObject.put("browsetimepage", bVar2.f9690b);
            jSONObject.put("duration", bVar2.f9691c.intValue());
            jSONObject.put("show_time_begin", bVar2.f9692d.longValue());
            jSONObject.put("show_time_end", bVar2.f9693e.longValue());
            jSONObject.put("show_num", bVar2.f9694f.intValue());
            jSONObject.put("toast", bVar2.f9695g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(c.a.o0.r.j0.b.k().q("pref_key_strategy_json", null))) {
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
            if (z && this.f9688b) {
                this.f9688b = false;
                if (!this.f9689c && d.y().t()) {
                    String q = c.a.o0.r.j0.b.k().q("pref_key_strategy_json", null);
                    if (TextUtils.isEmpty(q)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(q);
                        b bVar = new b();
                        bVar.a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                        bVar.f9690b = jSONObject.optString("browsetimepage", "");
                        bVar.f9691c = Integer.valueOf(jSONObject.optInt("duration", 0));
                        bVar.f9692d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                        bVar.f9693e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                        bVar.f9694f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                        bVar.f9695g = jSONObject.optString("toast", null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f9688b = true;
        this.f9689c = false;
    }
}
