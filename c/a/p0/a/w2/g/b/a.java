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
    public static final boolean f9641f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9642a;

    /* renamed from: b  reason: collision with root package name */
    public long f9643b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f9644c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f9645d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f9646e;

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
        public int f9647a;

        /* renamed from: b  reason: collision with root package name */
        public float f9648b;

        /* renamed from: c  reason: collision with root package name */
        public float f9649c;

        /* renamed from: d  reason: collision with root package name */
        public float f9650d;

        /* renamed from: e  reason: collision with root package name */
        public float f9651e;

        /* renamed from: f  reason: collision with root package name */
        public float f9652f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9653g;

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
            this.f9653g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.M(this.f9648b));
                    jSONObject.put("y", n0.M(this.f9649c));
                    jSONObject.put("clientX", n0.M(this.f9650d - this.f9653g.f9646e[0]));
                    jSONObject.put("clientY", n0.M(this.f9651e - this.f9653g.f9646e[1]));
                    jSONObject.put("identifier", this.f9647a);
                    jSONObject.put("force", this.f9652f);
                } catch (JSONException e2) {
                    if (a.f9641f) {
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
        f9641f = k.f7077a;
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
        this.f9642a = "error";
        this.f9643b = 0L;
        this.f9644c = new ArrayList();
        this.f9645d = new ArrayList();
        this.f9646e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f9644c.isEmpty()) {
                    for (b bVar : this.f9644c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f9645d.isEmpty()) {
                    for (b bVar2 : this.f9645d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f9643b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f9641f) {
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
            bVar.f9647a = pointerId;
            bVar.f9648b = motionEvent.getX(i2);
            bVar.f9649c = motionEvent.getY(i2);
            bVar.f9650d = (motionEvent.getRawX() + bVar.f9648b) - motionEvent.getX();
            bVar.f9651e = (motionEvent.getRawY() + bVar.f9649c) - motionEvent.getY();
            bVar.f9652f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9642a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f9645d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f9645d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f9641f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.f9642a, "touchend") || TextUtils.equals(this.f9642a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f9644c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f9641f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f9642a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.f9642a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.f9642a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.f9642a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.f9642a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.f9642a = "error";
            } else {
                this.f9642a = "touchpointerup";
                f(motionEvent);
            }
            this.f9643b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.f9642a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.f9642a, "touchpointerdown")) {
                this.f9642a = "touchstart";
            }
            if (TextUtils.equals(this.f9642a, "touchpointerup")) {
                this.f9642a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f9646e = iArr;
            if (f9641f) {
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
        this.f9642a = "error";
        this.f9643b = 0L;
        this.f9644c = new ArrayList();
        this.f9645d = new ArrayList();
        this.f9646e = new int[2];
        h(motionEvent, str);
    }
}
