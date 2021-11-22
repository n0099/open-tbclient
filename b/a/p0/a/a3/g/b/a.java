package b.a.p0.a.a3.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import b.a.p0.a.k;
import b.a.p0.a.z2.n0;
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
    public static final boolean f4107f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4108a;

    /* renamed from: b  reason: collision with root package name */
    public long f4109b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f4110c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f4111d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f4112e;

    /* renamed from: b.a.p0.a.a3.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0119a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f4113a;

        /* renamed from: b  reason: collision with root package name */
        public float f4114b;

        /* renamed from: c  reason: collision with root package name */
        public float f4115c;

        /* renamed from: d  reason: collision with root package name */
        public float f4116d;

        /* renamed from: e  reason: collision with root package name */
        public float f4117e;

        /* renamed from: f  reason: collision with root package name */
        public float f4118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f4119g;

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
            this.f4119g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.Q(this.f4114b));
                    jSONObject.put("y", n0.Q(this.f4115c));
                    jSONObject.put("clientX", n0.Q(this.f4116d - this.f4119g.f4112e[0]));
                    jSONObject.put("clientY", n0.Q(this.f4117e - this.f4119g.f4112e[1]));
                    jSONObject.put("identifier", this.f4113a);
                    jSONObject.put(TTDownloadField.TT_FORCE, this.f4118f);
                } catch (JSONException e2) {
                    if (a.f4107f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0119a c0119a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1793403146, "Lb/a/p0/a/a3/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1793403146, "Lb/a/p0/a/a3/g/b/a;");
                return;
            }
        }
        f4107f = k.f6863a;
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
        this.f4108a = "error";
        this.f4109b = 0L;
        this.f4110c = new ArrayList();
        this.f4111d = new ArrayList();
        this.f4112e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f4110c.isEmpty()) {
                    for (b bVar : this.f4110c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f4111d.isEmpty()) {
                    for (b bVar2 : this.f4111d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f4109b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f4107f) {
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
            bVar.f4113a = pointerId;
            bVar.f4114b = motionEvent.getX(i2);
            bVar.f4115c = motionEvent.getY(i2);
            bVar.f4116d = (motionEvent.getRawX() + bVar.f4114b) - motionEvent.getX();
            bVar.f4117e = (motionEvent.getRawY() + bVar.f4115c) - motionEvent.getY();
            bVar.f4118f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4108a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f4111d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f4111d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f4107f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.f4108a, "touchend") || TextUtils.equals(this.f4108a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f4110c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f4107f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f4108a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.f4108a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.f4108a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.f4108a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.f4108a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.f4108a = "error";
            } else {
                this.f4108a = "touchpointerup";
                f(motionEvent);
            }
            this.f4109b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.f4108a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.f4108a, "touchpointerdown")) {
                this.f4108a = "touchstart";
            }
            if (TextUtils.equals(this.f4108a, "touchpointerup")) {
                this.f4108a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f4112e = iArr;
            if (f4107f) {
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
        this.f4108a = "error";
        this.f4109b = 0L;
        this.f4110c = new ArrayList();
        this.f4111d = new ArrayList();
        this.f4112e = new int[2];
        h(motionEvent, str);
    }
}
