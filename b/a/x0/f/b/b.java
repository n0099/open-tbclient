package b.a.x0.f.b;

import androidx.core.view.InputDeviceCompat;
import b.a.x0.t.c;
import b.a.x0.t.h;
import b.a.x0.t.o;
import b.a.x0.t.u;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.x0.f.b.c.b f29489a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f29490b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f29491c;

    /* renamed from: d  reason: collision with root package name */
    public int f29492d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f29493e;

    /* renamed from: f  reason: collision with root package name */
    public long f29494f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29495g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29496h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.x0.f.b.c.a f29497i;
    public int j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29498e;

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
            this.f29498e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29498e.f29496h) {
                    this.f29498e.j();
                } else {
                    this.f29498e.q();
                }
                b bVar = this.f29498e;
                bVar.f29496h = bVar.l(bVar.j);
            }
        }
    }

    /* renamed from: b.a.x0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1420b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29499e;

        public RunnableC1420b(b bVar) {
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
            this.f29499e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29499e.f29495g = false;
                if (this.f29499e.f29491c != null) {
                    this.f29499e.f29491c.cancel();
                }
                if (this.f29499e.f29490b != null) {
                    this.f29499e.f29490b.purge();
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
        this.f29492d = 0;
        this.f29493e = new Vector<>();
        this.f29495g = false;
        this.f29496h = false;
        this.f29497i = new b.a.x0.f.b.c.a();
        this.j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f29490b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29492d++;
            this.f29497i.f29500a = k(this.m);
            this.f29497i.f29501b = k(this.f29493e);
            this.f29497i.f29502c = this.m.size() + "";
            this.f29497i.f29505f = Float.toString(o.a());
            this.f29497i.f29503d = this.k;
            c.b("report ar frame data");
            b.a.x0.f.a.a(String.valueOf(this.f29492d), this.f29489a, this.f29497i);
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
            this.f29495g = false;
            Timer timer = this.f29490b;
            if (timer != null) {
                timer.cancel();
                this.f29490b = null;
            }
            TimerTask timerTask = this.f29491c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f29491c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f29496h && this.f29495g) {
            if (this.f29494f <= 0) {
                this.f29494f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f29494f);
            if (i2 < 0) {
                return;
            }
            this.f29493e.add(Integer.valueOf(i2));
            this.f29494f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f29496h && this.f29495g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f29494f = 0L;
            this.l = 0L;
            this.f29493e.clear();
            this.m.clear();
            this.f29497i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f29495g || this.f29490b == null) {
            return;
        }
        c.b("startTimer");
        this.f29495g = true;
        this.f29491c = new a(this);
        this.f29490b.purge();
        this.f29490b.schedule(this.f29491c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1420b(this), 1000L);
        }
    }
}
