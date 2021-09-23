package c.a.p0.a.w2.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import c.a.p0.a.k;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9649f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9650a;

    /* renamed from: b  reason: collision with root package name */
    public long f9651b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f9652c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f9653d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f9654e;

    /* renamed from: c.a.p0.a.w2.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0451a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f9655a;

        /* renamed from: b  reason: collision with root package name */
        public float f9656b;

        /* renamed from: c  reason: collision with root package name */
        public float f9657c;

        /* renamed from: d  reason: collision with root package name */
        public float f9658d;

        /* renamed from: e  reason: collision with root package name */
        public float f9659e;

        /* renamed from: f  reason: collision with root package name */
        public float f9660f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9661g;

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
            this.f9661g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.M(this.f9656b));
                    jSONObject.put("y", n0.M(this.f9657c));
                    jSONObject.put("clientX", n0.M(this.f9658d - this.f9661g.f9654e[0]));
                    jSONObject.put("clientY", n0.M(this.f9659e - this.f9661g.f9654e[1]));
                    jSONObject.put("identifier", this.f9655a);
                    jSONObject.put("force", this.f9660f);
                } catch (JSONException e2) {
                    if (a.f9649f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0451a c0451a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1347611060, "Lc/a/p0/a/w2/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1347611060, "Lc/a/p0/a/w2/g/b/a;");
                return;
            }
        }
        f9649f = k.f7085a;
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
        this.f9650a = "error";
        this.f9651b = 0L;
        this.f9652c = new ArrayList();
        this.f9653d = new ArrayList();
        this.f9654e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f9652c.isEmpty()) {
                    for (b bVar : this.f9652c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f9653d.isEmpty()) {
                    for (b bVar2 : this.f9653d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f9651b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f9649f) {
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
            bVar.f9655a = pointerId;
            bVar.f9656b = motionEvent.getX(i2);
            bVar.f9657c = motionEvent.getY(i2);
            bVar.f9658d = (motionEvent.getRawX() + bVar.f9656b) - motionEvent.getX();
            bVar.f9659e = (motionEvent.getRawY() + bVar.f9657c) - motionEvent.getY();
            bVar.f9660f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9650a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f9653d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f9653d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f9649f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.f9650a, "touchend") || TextUtils.equals(this.f9650a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f9652c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f9649f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f9650a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.f9650a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.f9650a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.f9650a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.f9650a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.f9650a = "error";
            } else {
                this.f9650a = "touchpointerup";
                f(motionEvent);
            }
            this.f9651b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.f9650a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.f9650a, "touchpointerdown")) {
                this.f9650a = "touchstart";
            }
            if (TextUtils.equals(this.f9650a, "touchpointerup")) {
                this.f9650a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f9654e = iArr;
            if (f9649f) {
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
        this.f9650a = "error";
        this.f9651b = 0L;
        this.f9652c = new ArrayList();
        this.f9653d = new ArrayList();
        this.f9654e = new int[2];
        h(motionEvent, str);
    }
}
