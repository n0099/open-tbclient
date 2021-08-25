package c.a.w0.f.b;

import androidx.core.view.InputDeviceCompat;
import c.a.w0.t.c;
import c.a.w0.t.h;
import c.a.w0.t.o;
import c.a.w0.t.u;
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
    public c.a.w0.f.b.c.b f30479a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f30480b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f30481c;

    /* renamed from: d  reason: collision with root package name */
    public int f30482d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f30483e;

    /* renamed from: f  reason: collision with root package name */
    public long f30484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30485g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30486h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.w0.f.b.c.a f30487i;

    /* renamed from: j  reason: collision with root package name */
    public int f30488j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes4.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30489e;

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
            this.f30489e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30489e.f30486h) {
                    this.f30489e.j();
                } else {
                    this.f30489e.q();
                }
                b bVar = this.f30489e;
                bVar.f30486h = bVar.l(bVar.f30488j);
            }
        }
    }

    /* renamed from: c.a.w0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1415b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30490e;

        public RunnableC1415b(b bVar) {
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
            this.f30490e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30490e.f30485g = false;
                if (this.f30490e.f30481c != null) {
                    this.f30490e.f30481c.cancel();
                }
                if (this.f30490e.f30480b != null) {
                    this.f30490e.f30480b.purge();
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
        this.f30482d = 0;
        this.f30483e = new Vector<>();
        this.f30485g = false;
        this.f30486h = false;
        this.f30487i = new c.a.w0.f.b.c.a();
        this.f30488j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f30480b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30482d++;
            this.f30487i.f30491a = k(this.m);
            this.f30487i.f30492b = k(this.f30483e);
            this.f30487i.f30493c = this.m.size() + "";
            this.f30487i.f30496f = Float.toString(o.a());
            this.f30487i.f30494d = this.k;
            c.b("report ar frame data");
            c.a.w0.f.a.a(String.valueOf(this.f30482d), this.f30479a, this.f30487i);
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
            this.f30485g = false;
            Timer timer = this.f30480b;
            if (timer != null) {
                timer.cancel();
                this.f30480b = null;
            }
            TimerTask timerTask = this.f30481c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f30481c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f30486h && this.f30485g) {
            if (this.f30484f <= 0) {
                this.f30484f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f30484f);
            if (i2 < 0) {
                return;
            }
            this.f30483e.add(Integer.valueOf(i2));
            this.f30484f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f30486h && this.f30485g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f30484f = 0L;
            this.l = 0L;
            this.f30483e.clear();
            this.m.clear();
            this.f30487i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f30485g || this.f30480b == null) {
            return;
        }
        c.b("startTimer");
        this.f30485g = true;
        this.f30481c = new a(this);
        this.f30480b.purge();
        this.f30480b.schedule(this.f30481c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1415b(this), 1000L);
        }
    }
}
