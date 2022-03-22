package c.a.v0.f.b;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.r.c;
import c.a.v0.r.h;
import c.a.v0.r.o;
import c.a.v0.r.u;
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
    public c.a.v0.f.b.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f21531b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f21532c;

    /* renamed from: d  reason: collision with root package name */
    public int f21533d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f21534e;

    /* renamed from: f  reason: collision with root package name */
    public long f21535f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21536g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21537h;
    public c.a.v0.f.b.c.a i;
    public int j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f21537h) {
                    this.a.j();
                } else {
                    this.a.q();
                }
                b bVar = this.a;
                bVar.f21537h = bVar.l(bVar.j);
            }
        }
    }

    /* renamed from: c.a.v0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1598b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC1598b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f21536g = false;
                if (this.a.f21532c != null) {
                    this.a.f21532c.cancel();
                }
                if (this.a.f21531b != null) {
                    this.a.f21531b.purge();
                }
            }
        }
    }

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
                return;
            }
        }
        this.f21533d = 0;
        this.f21534e = new Vector<>();
        this.f21536g = false;
        this.f21537h = false;
        this.i = new c.a.v0.f.b.c.a();
        this.j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f21531b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21533d++;
            this.i.a = k(this.m);
            this.i.f21538b = k(this.f21534e);
            this.i.f21539c = this.m.size() + "";
            this.i.f21542f = Float.toString(o.a());
            this.i.f21540d = this.k;
            c.b("report ar frame data");
            c.a.v0.f.a.a(String.valueOf(this.f21533d), this.a, this.i);
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
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num != null) {
                    f3 += num.intValue();
                    jSONArray.put(num);
                }
            }
            float size = f3 / list.size();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num2 = list.get(i2);
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

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return i > 0 && i <= 100 && new Random().nextInt(100) <= i;
        }
        return invokeI.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21536g = false;
            Timer timer = this.f21531b;
            if (timer != null) {
                timer.cancel();
                this.f21531b = null;
            }
            TimerTask timerTask = this.f21532c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f21532c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f21537h && this.f21536g) {
            if (this.f21535f <= 0) {
                this.f21535f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = (int) (currentTimeMillis - this.f21535f);
            if (i < 0) {
                return;
            }
            this.f21534e.add(Integer.valueOf(i));
            this.f21535f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f21537h && this.f21536g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f21535f = 0L;
            this.l = 0L;
            this.f21534e.clear();
            this.m.clear();
            this.i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f21536g || this.f21531b == null) {
            return;
        }
        c.b("startTimer");
        this.f21536g = true;
        this.f21532c = new a(this);
        this.f21531b.purge();
        this.f21531b.schedule(this.f21532c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1598b(this), 1000L);
        }
    }
}
