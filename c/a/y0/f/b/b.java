package c.a.y0.f.b;

import androidx.core.view.InputDeviceCompat;
import c.a.y0.t.c;
import c.a.y0.t.h;
import c.a.y0.t.o;
import c.a.y0.t.u;
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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.y0.f.b.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f27211b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f27212c;

    /* renamed from: d  reason: collision with root package name */
    public int f27213d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f27214e;

    /* renamed from: f  reason: collision with root package name */
    public long f27215f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27216g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27217h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.y0.f.b.c.a f27218i;

    /* renamed from: j  reason: collision with root package name */
    public int f27219j;

    /* renamed from: k  reason: collision with root package name */
    public float f27220k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes9.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27221e;

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
            this.f27221e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f27221e.f27217h) {
                    this.f27221e.j();
                } else {
                    this.f27221e.q();
                }
                b bVar = this.f27221e;
                bVar.f27217h = bVar.l(bVar.f27219j);
            }
        }
    }

    /* renamed from: c.a.y0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1568b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27222e;

        public RunnableC1568b(b bVar) {
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
            this.f27222e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27222e.f27216g = false;
                if (this.f27222e.f27212c != null) {
                    this.f27222e.f27212c.cancel();
                }
                if (this.f27222e.f27211b != null) {
                    this.f27222e.f27211b.purge();
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
        this.f27213d = 0;
        this.f27214e = new Vector<>();
        this.f27216g = false;
        this.f27217h = false;
        this.f27218i = new c.a.y0.f.b.c.a();
        this.f27219j = 0;
        this.f27220k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f27211b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27213d++;
            this.f27218i.a = k(this.m);
            this.f27218i.f27223b = k(this.f27214e);
            this.f27218i.f27224c = this.m.size() + "";
            this.f27218i.f27227f = Float.toString(o.a());
            this.f27218i.f27225d = this.f27220k;
            c.b("report ar frame data");
            c.a.y0.f.a.a(String.valueOf(this.f27213d), this.a, this.f27218i);
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
            this.f27216g = false;
            Timer timer = this.f27211b;
            if (timer != null) {
                timer.cancel();
                this.f27211b = null;
            }
            TimerTask timerTask = this.f27212c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f27212c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f27217h && this.f27216g) {
            if (this.f27215f <= 0) {
                this.f27215f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f27215f);
            if (i2 < 0) {
                return;
            }
            this.f27214e.add(Integer.valueOf(i2));
            this.f27215f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f27217h && this.f27216g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f27215f = 0L;
            this.l = 0L;
            this.f27214e.clear();
            this.m.clear();
            this.f27218i.a();
            this.f27220k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f27216g || this.f27211b == null) {
            return;
        }
        c.b("startTimer");
        this.f27216g = true;
        this.f27212c = new a(this);
        this.f27211b.purge();
        this.f27211b.schedule(this.f27212c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1568b(this), 1000L);
        }
    }
}
