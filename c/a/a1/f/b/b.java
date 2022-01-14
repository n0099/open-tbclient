package c.a.a1.f.b;

import androidx.core.view.InputDeviceCompat;
import c.a.a1.t.c;
import c.a.a1.t.h;
import c.a.a1.t.o;
import c.a.a1.t.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a1.f.b.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f1107b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f1108c;

    /* renamed from: d  reason: collision with root package name */
    public int f1109d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f1110e;

    /* renamed from: f  reason: collision with root package name */
    public long f1111f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1112g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1113h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.a1.f.b.c.a f1114i;

    /* renamed from: j  reason: collision with root package name */
    public int f1115j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1116e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1116e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1116e.f1113h) {
                    this.f1116e.j();
                } else {
                    this.f1116e.q();
                }
                b bVar = this.f1116e;
                bVar.f1113h = bVar.l(bVar.f1115j);
            }
        }
    }

    /* renamed from: c.a.a1.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0010b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1117e;

        public RunnableC0010b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1117e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1117e.f1112g = false;
                if (this.f1117e.f1108c != null) {
                    this.f1117e.f1108c.cancel();
                }
                if (this.f1117e.f1107b != null) {
                    this.f1117e.f1107b.purge();
                }
            }
        }
    }

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
                return;
            }
        }
        this.f1109d = 0;
        this.f1110e = new Vector<>();
        this.f1112g = false;
        this.f1113h = false;
        this.f1114i = new c.a.a1.f.b.c.a();
        this.f1115j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f1107b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1109d++;
            this.f1114i.a = k(this.m);
            this.f1114i.f1118b = k(this.f1110e);
            this.f1114i.f1119c = this.m.size() + "";
            this.f1114i.f1122f = Float.toString(o.a());
            this.f1114i.f1120d = this.k;
            c.b("report ar frame data");
            c.a.a1.f.a.a(String.valueOf(this.f1109d), this.a, this.f1114i);
            q();
        }
    }

    public final String k(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (h.e(list)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num != null) {
                    f3 += num.intValue();
                    jSONArray.put(num);
                }
            }
            float size = f3 / list.size();
            for (int i3 = 0; i3 < list.size(); i3++) {
                Integer num2 = list.get(i3);
                if (num2 != null) {
                    f2 = (float) (f2 + Math.pow(num2.intValue() - size, 2.0d));
                }
            }
            float size2 = f2 / list.size();
            try {
                jSONObject.put("avg", size);
                jSONObject.put("vari", size2);
                jSONObject.put("val", jSONArray.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return i2 > 0 && i2 <= 100 && new Random().nextInt(100) <= i2;
        }
        return invokeI.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1112g = false;
            Timer timer = this.f1107b;
            if (timer != null) {
                timer.cancel();
                this.f1107b = null;
            }
            TimerTask timerTask = this.f1108c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f1108c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f1113h && this.f1112g) {
            if (this.f1111f <= 0) {
                this.f1111f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f1111f);
            if (i2 < 0) {
                return;
            }
            this.f1110e.add(Integer.valueOf(i2));
            this.f1111f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f1113h && this.f1112g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
            this.m.add(Integer.valueOf(currentTimeMillis));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = System.currentTimeMillis();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f1111f = 0L;
            this.l = 0L;
            this.f1110e.clear();
            this.m.clear();
            this.f1114i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f1112g || this.f1107b == null) {
            return;
        }
        c.b("startTimer");
        this.f1112g = true;
        this.f1108c = new a(this);
        this.f1107b.purge();
        this.f1107b.schedule(this.f1108c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC0010b(this), 1000L);
        }
    }
}
