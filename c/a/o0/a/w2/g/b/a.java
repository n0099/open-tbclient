package c.a.o0.a.w2.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import c.a.o0.a.k;
import c.a.o0.a.v2.n0;
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
    public static final boolean f9613f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9614a;

    /* renamed from: b  reason: collision with root package name */
    public long f9615b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f9616c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f9617d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f9618e;

    /* renamed from: c.a.o0.a.w2.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0449a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f9619a;

        /* renamed from: b  reason: collision with root package name */
        public float f9620b;

        /* renamed from: c  reason: collision with root package name */
        public float f9621c;

        /* renamed from: d  reason: collision with root package name */
        public float f9622d;

        /* renamed from: e  reason: collision with root package name */
        public float f9623e;

        /* renamed from: f  reason: collision with root package name */
        public float f9624f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9625g;

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
            this.f9625g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.M(this.f9620b));
                    jSONObject.put("y", n0.M(this.f9621c));
                    jSONObject.put("clientX", n0.M(this.f9622d - this.f9625g.f9618e[0]));
                    jSONObject.put("clientY", n0.M(this.f9623e - this.f9625g.f9618e[1]));
                    jSONObject.put("identifier", this.f9619a);
                    jSONObject.put("force", this.f9624f);
                } catch (JSONException e2) {
                    if (a.f9613f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0449a c0449a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-842052435, "Lc/a/o0/a/w2/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-842052435, "Lc/a/o0/a/w2/g/b/a;");
                return;
            }
        }
        f9613f = k.f7049a;
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
        this.f9614a = "error";
        this.f9615b = 0L;
        this.f9616c = new ArrayList();
        this.f9617d = new ArrayList();
        this.f9618e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f9616c.isEmpty()) {
                    for (b bVar : this.f9616c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f9617d.isEmpty()) {
                    for (b bVar2 : this.f9617d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f9615b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f9613f) {
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
            bVar.f9619a = pointerId;
            bVar.f9620b = motionEvent.getX(i2);
            bVar.f9621c = motionEvent.getY(i2);
            bVar.f9622d = (motionEvent.getRawX() + bVar.f9620b) - motionEvent.getX();
            bVar.f9623e = (motionEvent.getRawY() + bVar.f9621c) - motionEvent.getY();
            bVar.f9624f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9614a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f9617d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f9617d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f9613f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.f9614a, "touchend") || TextUtils.equals(this.f9614a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f9616c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f9613f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f9614a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.f9614a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.f9614a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.f9614a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.f9614a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.f9614a = "error";
            } else {
                this.f9614a = "touchpointerup";
                f(motionEvent);
            }
            this.f9615b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.f9614a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.f9614a, "touchpointerdown")) {
                this.f9614a = "touchstart";
            }
            if (TextUtils.equals(this.f9614a, "touchpointerup")) {
                this.f9614a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f9618e = iArr;
            if (f9613f) {
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
        this.f9614a = "error";
        this.f9615b = 0L;
        this.f9616c = new ArrayList();
        this.f9617d = new ArrayList();
        this.f9618e = new int[2];
        h(motionEvent, str);
    }
}
