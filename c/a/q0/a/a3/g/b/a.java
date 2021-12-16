package c.a.q0.a.a3.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import c.a.q0.a.k;
import c.a.q0.a.z2.n0;
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
    public static final boolean f4617f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f4618b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f4619c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f4620d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f4621e;

    /* renamed from: c.a.q0.a.a3.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0209a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public float f4622b;

        /* renamed from: c  reason: collision with root package name */
        public float f4623c;

        /* renamed from: d  reason: collision with root package name */
        public float f4624d;

        /* renamed from: e  reason: collision with root package name */
        public float f4625e;

        /* renamed from: f  reason: collision with root package name */
        public float f4626f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4627g;

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
            this.f4627g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.Q(this.f4622b));
                    jSONObject.put("y", n0.Q(this.f4623c));
                    jSONObject.put("clientX", n0.Q(this.f4624d - this.f4627g.f4621e[0]));
                    jSONObject.put("clientY", n0.Q(this.f4625e - this.f4627g.f4621e[1]));
                    jSONObject.put("identifier", this.a);
                    jSONObject.put(TTDownloadField.TT_FORCE, this.f4626f);
                } catch (JSONException e2) {
                    if (a.f4617f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0209a c0209a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(998933172, "Lc/a/q0/a/a3/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(998933172, "Lc/a/q0/a/a3/g/b/a;");
                return;
            }
        }
        f4617f = k.a;
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
        this.f4618b = 0L;
        this.f4619c = new ArrayList();
        this.f4620d = new ArrayList();
        this.f4621e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f4619c.isEmpty()) {
                    for (b bVar : this.f4619c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f4620d.isEmpty()) {
                    for (b bVar2 : this.f4620d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f4618b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f4617f) {
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
            bVar.f4622b = motionEvent.getX(i2);
            bVar.f4623c = motionEvent.getY(i2);
            bVar.f4624d = (motionEvent.getRawX() + bVar.f4622b) - motionEvent.getX();
            bVar.f4625e = (motionEvent.getRawY() + bVar.f4623c) - motionEvent.getY();
            bVar.f4626f = motionEvent.getPressure(i2);
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
                    this.f4620d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f4620d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f4617f) {
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
                    this.f4619c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f4617f) {
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
            this.f4618b = motionEvent.getEventTime();
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
            this.f4621e = iArr;
            if (f4617f) {
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
        this.f4618b = 0L;
        this.f4619c = new ArrayList();
        this.f4620d = new ArrayList();
        this.f4621e = new int[2];
        h(motionEvent, str);
    }
}
