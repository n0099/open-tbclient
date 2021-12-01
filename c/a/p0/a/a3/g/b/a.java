package c.a.p0.a.a3.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import c.a.p0.a.k;
import c.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f4308f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f4309b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f4310c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f4311d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f4312e;

    /* renamed from: c.a.p0.a.a3.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0175a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public float f4313b;

        /* renamed from: c  reason: collision with root package name */
        public float f4314c;

        /* renamed from: d  reason: collision with root package name */
        public float f4315d;

        /* renamed from: e  reason: collision with root package name */
        public float f4316e;

        /* renamed from: f  reason: collision with root package name */
        public float f4317f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4318g;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4318g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.Q(this.f4313b));
                    jSONObject.put("y", n0.Q(this.f4314c));
                    jSONObject.put("clientX", n0.Q(this.f4315d - this.f4318g.f4312e[0]));
                    jSONObject.put("clientY", n0.Q(this.f4316e - this.f4318g.f4312e[1]));
                    jSONObject.put("identifier", this.a);
                    jSONObject.put(TTDownloadField.TT_FORCE, this.f4317f);
                } catch (JSONException e2) {
                    if (a.f4308f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0175a c0175a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1504491797, "Lc/a/p0/a/a3/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1504491797, "Lc/a/p0/a/a3/g/b/a;");
                return;
            }
        }
        f4308f = k.a;
    }

    public a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "error";
        this.f4309b = 0L;
        this.f4310c = new ArrayList();
        this.f4311d = new ArrayList();
        this.f4312e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f4310c.isEmpty()) {
                    for (b bVar : this.f4310c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f4311d.isEmpty()) {
                    for (b bVar2 : this.f4311d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f4309b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f4308f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public b d(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, i2)) == null) {
            int pointerId = motionEvent.getPointerId(i2);
            b bVar = new b(this, null);
            bVar.a = pointerId;
            bVar.f4313b = motionEvent.getX(i2);
            bVar.f4314c = motionEvent.getY(i2);
            bVar.f4315d = (motionEvent.getRawX() + bVar.f4313b) - motionEvent.getX();
            bVar.f4316e = (motionEvent.getRawY() + bVar.f4314c) - motionEvent.getY();
            bVar.f4317f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f4311d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f4311d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f4308f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.a, "touchend") || TextUtils.equals(this.a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f4310c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f4308f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.a = "error";
            } else {
                this.a = "touchpointerup";
                f(motionEvent);
            }
            this.f4309b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.a, "touchpointerdown")) {
                this.a = "touchstart";
            }
            if (TextUtils.equals(this.a, "touchpointerup")) {
                this.a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f4312e = iArr;
            if (f4308f) {
                String str = "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0];
            }
        }
    }

    public a(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = "error";
        this.f4309b = 0L;
        this.f4310c = new ArrayList();
        this.f4311d = new ArrayList();
        this.f4312e = new int[2];
        h(motionEvent, str);
    }
}
