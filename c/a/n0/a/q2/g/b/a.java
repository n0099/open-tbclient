package c.a.n0.a.q2.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import c.a.n0.a.p2.n0;
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
    public static final boolean f6037f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f6038b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f6039c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f6040d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f6041e;

    /* renamed from: c.a.n0.a.q2.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0430a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public float f6042b;

        /* renamed from: c  reason: collision with root package name */
        public float f6043c;

        /* renamed from: d  reason: collision with root package name */
        public float f6044d;

        /* renamed from: e  reason: collision with root package name */
        public float f6045e;

        /* renamed from: f  reason: collision with root package name */
        public float f6046f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6047g;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6047g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.P(this.f6042b));
                    jSONObject.put("y", n0.P(this.f6043c));
                    jSONObject.put("clientX", n0.P(this.f6044d - this.f6047g.f6041e[0]));
                    jSONObject.put("clientY", n0.P(this.f6045e - this.f6047g.f6041e[1]));
                    jSONObject.put("identifier", this.a);
                    jSONObject.put(TTDownloadField.TT_FORCE, this.f6046f);
                } catch (JSONException e2) {
                    if (a.f6037f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0430a c0430a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1918298376, "Lc/a/n0/a/q2/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1918298376, "Lc/a/n0/a/q2/g/b/a;");
                return;
            }
        }
        f6037f = c.a.n0.a.a.a;
    }

    public a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "error";
        this.f6038b = 0L;
        this.f6039c = new ArrayList();
        this.f6040d = new ArrayList();
        this.f6041e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f6039c.isEmpty()) {
                    for (b bVar : this.f6039c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f6040d.isEmpty()) {
                    for (b bVar2 : this.f6040d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f6038b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f6037f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public b d(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, i)) == null) {
            int pointerId = motionEvent.getPointerId(i);
            b bVar = new b(this, null);
            bVar.a = pointerId;
            bVar.f6042b = motionEvent.getX(i);
            bVar.f6043c = motionEvent.getY(i);
            bVar.f6044d = (motionEvent.getRawX() + bVar.f6042b) - motionEvent.getX();
            bVar.f6045e = (motionEvent.getRawY() + bVar.f6043c) - motionEvent.getY();
            bVar.f6046f = motionEvent.getPressure(i);
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
                    this.f6040d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    this.f6040d.add(d(motionEvent, i));
                }
            } catch (Exception e2) {
                if (f6037f) {
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
            for (int i = 0; i < pointerCount; i++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                    this.f6039c.add(d(motionEvent, i));
                }
            }
        } catch (Exception e2) {
            if (f6037f) {
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
            this.f6038b = motionEvent.getEventTime();
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
            this.f6041e = iArr;
            if (f6037f) {
                Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = "error";
        this.f6038b = 0L;
        this.f6039c = new ArrayList();
        this.f6040d = new ArrayList();
        this.f6041e = new int[2];
        h(motionEvent, str);
    }
}
