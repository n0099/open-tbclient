package c.a.y0.f.b;

import androidx.core.view.InputDeviceCompat;
import c.a.y0.r.c;
import c.a.y0.r.h;
import c.a.y0.r.o;
import c.a.y0.r.u;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.y0.f.b.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f26593b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f26594c;

    /* renamed from: d  reason: collision with root package name */
    public int f26595d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f26596e;

    /* renamed from: f  reason: collision with root package name */
    public long f26597f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26598g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26599h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.y0.f.b.c.a f26600i;

    /* renamed from: j  reason: collision with root package name */
    public int f26601j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26602e;

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
            this.f26602e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26602e.f26599h) {
                    this.f26602e.j();
                } else {
                    this.f26602e.q();
                }
                b bVar = this.f26602e;
                bVar.f26599h = bVar.l(bVar.f26601j);
            }
        }
    }

    /* renamed from: c.a.y0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1609b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26603e;

        public RunnableC1609b(b bVar) {
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
            this.f26603e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26603e.f26598g = false;
                if (this.f26603e.f26594c != null) {
                    this.f26603e.f26594c.cancel();
                }
                if (this.f26603e.f26593b != null) {
                    this.f26603e.f26593b.purge();
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
        this.f26595d = 0;
        this.f26596e = new Vector<>();
        this.f26598g = false;
        this.f26599h = false;
        this.f26600i = new c.a.y0.f.b.c.a();
        this.f26601j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f26593b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26595d++;
            this.f26600i.a = k(this.m);
            this.f26600i.f26604b = k(this.f26596e);
            this.f26600i.f26605c = this.m.size() + "";
            this.f26600i.f26608f = Float.toString(o.a());
            this.f26600i.f26606d = this.k;
            c.b("report ar frame data");
            c.a.y0.f.a.a(String.valueOf(this.f26595d), this.a, this.f26600i);
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
            this.f26598g = false;
            Timer timer = this.f26593b;
            if (timer != null) {
                timer.cancel();
                this.f26593b = null;
            }
            TimerTask timerTask = this.f26594c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f26594c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f26599h && this.f26598g) {
            if (this.f26597f <= 0) {
                this.f26597f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f26597f);
            if (i2 < 0) {
                return;
            }
            this.f26596e.add(Integer.valueOf(i2));
            this.f26597f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f26599h && this.f26598g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f26597f = 0L;
            this.l = 0L;
            this.f26596e.clear();
            this.m.clear();
            this.f26600i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f26598g || this.f26593b == null) {
            return;
        }
        c.b("startTimer");
        this.f26598g = true;
        this.f26594c = new a(this);
        this.f26593b.purge();
        this.f26593b.schedule(this.f26594c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1609b(this), 1000L);
        }
    }
}
