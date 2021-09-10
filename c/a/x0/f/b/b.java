package c.a.x0.f.b;

import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.c;
import c.a.x0.t.h;
import c.a.x0.t.o;
import c.a.x0.t.u;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.x0.f.b.c.b f30711a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f30712b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f30713c;

    /* renamed from: d  reason: collision with root package name */
    public int f30714d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f30715e;

    /* renamed from: f  reason: collision with root package name */
    public long f30716f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30717g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30718h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.x0.f.b.c.a f30719i;

    /* renamed from: j  reason: collision with root package name */
    public int f30720j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes4.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30721e;

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
            this.f30721e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30721e.f30718h) {
                    this.f30721e.j();
                } else {
                    this.f30721e.q();
                }
                b bVar = this.f30721e;
                bVar.f30718h = bVar.l(bVar.f30720j);
            }
        }
    }

    /* renamed from: c.a.x0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1419b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30722e;

        public RunnableC1419b(b bVar) {
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
            this.f30722e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30722e.f30717g = false;
                if (this.f30722e.f30713c != null) {
                    this.f30722e.f30713c.cancel();
                }
                if (this.f30722e.f30712b != null) {
                    this.f30722e.f30712b.purge();
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
        this.f30714d = 0;
        this.f30715e = new Vector<>();
        this.f30717g = false;
        this.f30718h = false;
        this.f30719i = new c.a.x0.f.b.c.a();
        this.f30720j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f30712b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30714d++;
            this.f30719i.f30723a = k(this.m);
            this.f30719i.f30724b = k(this.f30715e);
            this.f30719i.f30725c = this.m.size() + "";
            this.f30719i.f30728f = Float.toString(o.a());
            this.f30719i.f30726d = this.k;
            c.b("report ar frame data");
            c.a.x0.f.a.a(String.valueOf(this.f30714d), this.f30711a, this.f30719i);
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
            this.f30717g = false;
            Timer timer = this.f30712b;
            if (timer != null) {
                timer.cancel();
                this.f30712b = null;
            }
            TimerTask timerTask = this.f30713c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f30713c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f30718h && this.f30717g) {
            if (this.f30716f <= 0) {
                this.f30716f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f30716f);
            if (i2 < 0) {
                return;
            }
            this.f30715e.add(Integer.valueOf(i2));
            this.f30716f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f30718h && this.f30717g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f30716f = 0L;
            this.l = 0L;
            this.f30715e.clear();
            this.m.clear();
            this.f30719i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f30717g || this.f30712b == null) {
            return;
        }
        c.b("startTimer");
        this.f30717g = true;
        this.f30713c = new a(this);
        this.f30712b.purge();
        this.f30712b.schedule(this.f30713c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1419b(this), 1000L);
        }
    }
}
