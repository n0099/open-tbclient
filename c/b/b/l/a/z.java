package c.b.b.l.a;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class z extends c.b.b.b implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] A;
    public final Application B;
    public final Context C;
    public final t D;
    public int E;
    public boolean F;
    public boolean G;
    public final float[] H;
    public final float[] I;
    public boolean J;
    public c.b.b.g K;
    public final c.b.b.l.a.b L;
    public final Input.Orientation M;
    public SensorEventListener N;
    public SensorEventListener O;
    public SensorEventListener P;
    public SensorEventListener Q;
    public final ArrayList<View.OnGenericMotionListener> R;
    public final o S;
    public boolean T;

    /* renamed from: j  reason: collision with root package name */
    public c.b.b.q.z<d> f27068j;
    public c.b.b.q.z<f> k;
    public ArrayList<View.OnKeyListener> l;
    public ArrayList<d> m;
    public ArrayList<f> n;
    public int[] o;
    public int[] p;
    public int[] q;
    public int[] r;
    public boolean[] s;
    public int[] t;
    public int[] u;
    public float[] v;
    public boolean[] w;
    public SensorManager x;
    public boolean y;
    public final float[] z;

    /* loaded from: classes9.dex */
    public class a extends c.b.b.q.z<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z zVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.z
        /* renamed from: g */
        public d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new d() : (d) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends c.b.b.q.z<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(z zVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.z
        /* renamed from: g */
        public f d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f() : (f) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(104513765, "Lc/b/b/l/a/z$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(104513765, "Lc/b/b/l/a/z$c;");
                    return;
                }
            }
            int[] iArr = new int[Input.OnscreenKeyboardType.values().length];
            a = iArr;
            try {
                iArr[Input.OnscreenKeyboardType.NumberPad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Input.OnscreenKeyboardType.PhonePad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Input.OnscreenKeyboardType.Email.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Input.OnscreenKeyboardType.Password.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Input.OnscreenKeyboardType.URI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f27069b;

        /* renamed from: c  reason: collision with root package name */
        public int f27070c;

        /* renamed from: d  reason: collision with root package name */
        public char f27071d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f27072e;

        public e(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27072e = zVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent.sensor.getType() == 1) {
                    z zVar = this.f27072e;
                    if (zVar.M == Input.Orientation.Portrait) {
                        float[] fArr = sensorEvent.values;
                        float[] fArr2 = zVar.z;
                        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                    } else {
                        float[] fArr3 = zVar.z;
                        float[] fArr4 = sensorEvent.values;
                        fArr3[0] = fArr4[1];
                        fArr3[1] = -fArr4[0];
                        fArr3[2] = fArr4[2];
                    }
                }
                if (sensorEvent.sensor.getType() == 2) {
                    float[] fArr5 = sensorEvent.values;
                    float[] fArr6 = this.f27072e.H;
                    System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
                }
                if (sensorEvent.sensor.getType() == 4) {
                    z zVar2 = this.f27072e;
                    if (zVar2.M == Input.Orientation.Portrait) {
                        float[] fArr7 = sensorEvent.values;
                        float[] fArr8 = zVar2.A;
                        System.arraycopy(fArr7, 0, fArr8, 0, fArr8.length);
                    } else {
                        float[] fArr9 = zVar2.A;
                        float[] fArr10 = sensorEvent.values;
                        fArr9[0] = fArr10[1];
                        fArr9[1] = -fArr10[0];
                        fArr9[2] = fArr10[2];
                    }
                }
                if (sensorEvent.sensor.getType() == 11) {
                    z zVar3 = this.f27072e;
                    if (zVar3.M == Input.Orientation.Portrait) {
                        float[] fArr11 = sensorEvent.values;
                        float[] fArr12 = zVar3.I;
                        System.arraycopy(fArr11, 0, fArr12, 0, fArr12.length);
                        return;
                    }
                    float[] fArr13 = zVar3.I;
                    float[] fArr14 = sensorEvent.values;
                    fArr13[0] = fArr14[1];
                    fArr13[1] = -fArr14[0];
                    fArr13[2] = fArr14[2];
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f27073b;

        /* renamed from: c  reason: collision with root package name */
        public int f27074c;

        /* renamed from: d  reason: collision with root package name */
        public int f27075d;

        /* renamed from: e  reason: collision with root package name */
        public int f27076e;

        /* renamed from: f  reason: collision with root package name */
        public int f27077f;

        /* renamed from: g  reason: collision with root package name */
        public int f27078g;

        /* renamed from: h  reason: collision with root package name */
        public int f27079h;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public z(Application application, Context context, Object obj, c.b.b.l.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, context, obj, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27068j = new a(this, 16, 1000);
        this.k = new b(this, 16, 1000);
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = new int[20];
        this.p = new int[20];
        this.q = new int[20];
        this.r = new int[20];
        this.s = new boolean[20];
        this.t = new int[20];
        this.u = new int[20];
        this.v = new float[20];
        this.w = new boolean[20];
        int i4 = 0;
        this.y = false;
        this.z = new float[3];
        this.A = new float[3];
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = new float[3];
        this.I = new float[3];
        this.J = false;
        this.R = new ArrayList<>();
        this.T = true;
        if (obj instanceof View) {
            View view = (View) obj;
            view.setOnKeyListener(this);
            view.setOnTouchListener(this);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnGenericMotionListener(this);
        }
        this.L = bVar;
        this.S = new o();
        while (true) {
            int[] iArr = this.u;
            if (i4 >= iArr.length) {
                break;
            }
            iArr[i4] = -1;
            i4++;
        }
        new Handler();
        this.B = application;
        this.C = context;
        this.E = bVar.m;
        t tVar = new t();
        this.D = tVar;
        tVar.c(context);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        int f2 = f();
        Graphics.a f3 = this.B.getGraphics().f();
        if (((f2 != 0 && f2 != 180) || f3.a < f3.f31040b) && ((f2 != 90 && f2 != 270) || f3.a > f3.f31040b)) {
            this.M = Input.Orientation.Portrait;
        } else {
            this.M = Input.Orientation.Landscape;
        }
        b(255, true);
    }

    public static int d(Input.OnscreenKeyboardType onscreenKeyboardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, onscreenKeyboardType)) == null) {
            int i2 = c.a[onscreenKeyboardType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return i2 != 5 ? 144 : 17;
                        }
                        return 129;
                    }
                    return 33;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    @Override // c.b.b.l.a.m
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int length = this.u.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.u[i2] == -1) {
                    return i2;
                }
            }
            this.v = k(this.v);
            this.u = l(this.u);
            this.o = l(this.o);
            this.p = l(this.p);
            this.q = l(this.q);
            this.r = l(this.r);
            this.s = n(this.s);
            this.t = l(this.t);
            return length;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        int rotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.C;
            if (context instanceof Activity) {
                rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
            } else {
                rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            }
            if (rotation != 1) {
                if (rotation != 2) {
                    return rotation != 3 ? 0 : 270;
                }
                return 180;
            }
            return 90;
        }
        return invokeV.intValue;
    }

    @Override // c.b.b.l.a.m
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o();
            Arrays.fill(this.u, -1);
            Arrays.fill(this.s, false);
        }
    }

    @Override // c.b.b.l.a.m
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j();
        }
    }

    public int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int length = this.u.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (this.u[i3] == i2) {
                    return i3;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < length; i4++) {
                sb.append(i4 + ":" + this.u[i4] + " ");
            }
            Application application = c.b.b.f.a;
            application.log("AndroidInput", "Pointer ID lookup failed: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + sb.toString());
            return -1;
        }
        return invokeI.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.L.f27018h) {
                SensorManager sensorManager = (SensorManager) this.C.getSystemService("sensor");
                this.x = sensorManager;
                if (sensorManager.getSensorList(1).isEmpty()) {
                    this.y = false;
                } else {
                    e eVar = new e(this);
                    this.N = eVar;
                    this.y = this.x.registerListener(eVar, this.x.getSensorList(1).get(0), this.L.l);
                }
            } else {
                this.y = false;
            }
            if (this.L.f27019i) {
                SensorManager sensorManager2 = (SensorManager) this.C.getSystemService("sensor");
                this.x = sensorManager2;
                if (!sensorManager2.getSensorList(4).isEmpty()) {
                    e eVar2 = new e(this);
                    this.O = eVar2;
                    this.x.registerListener(eVar2, this.x.getSensorList(4).get(0), this.L.l);
                }
            }
            this.G = false;
            if (this.L.k) {
                if (this.x == null) {
                    this.x = (SensorManager) this.C.getSystemService("sensor");
                }
                List<Sensor> sensorList = this.x.getSensorList(11);
                if (!sensorList.isEmpty()) {
                    this.Q = new e(this);
                    Iterator<Sensor> it = sensorList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Sensor next = it.next();
                        if (next.getVendor().equals("Google Inc.") && next.getVersion() == 3) {
                            this.G = this.x.registerListener(this.Q, next, this.L.l);
                            break;
                        }
                    }
                    if (!this.G) {
                        this.G = this.x.registerListener(this.Q, sensorList.get(0), this.L.l);
                    }
                }
            }
            if (this.L.f27020j && !this.G) {
                if (this.x == null) {
                    this.x = (SensorManager) this.C.getSystemService("sensor");
                }
                Sensor defaultSensor = this.x.getDefaultSensor(2);
                if (defaultSensor != null) {
                    boolean z = this.y;
                    this.F = z;
                    if (z) {
                        e eVar3 = new e(this);
                        this.P = eVar3;
                        this.F = this.x.registerListener(eVar3, defaultSensor, this.L.l);
                    }
                } else {
                    this.F = false;
                }
            } else {
                this.F = false;
            }
            c.b.b.f.a.log("AndroidInput", "sensor listener setup");
        }
    }

    public final float[] k(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fArr)) == null) {
            float[] fArr2 = new float[fArr.length + 2];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            return fArr2;
        }
        return (float[]) invokeL.objValue;
    }

    public final int[] l(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
            int[] iArr2 = new int[iArr.length + 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    @Override // c.b.b.l.a.m
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                if (this.J) {
                    this.J = false;
                    for (int i2 = 0; i2 < this.w.length; i2++) {
                        this.w[i2] = false;
                    }
                }
                if (this.f26935i) {
                    this.f26935i = false;
                    for (int i3 = 0; i3 < this.f26932f.length; i3++) {
                        this.f26932f[i3] = false;
                    }
                }
                if (this.K != null) {
                    c.b.b.g gVar = this.K;
                    int size = this.m.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        d dVar = this.m.get(i4);
                        long j2 = dVar.a;
                        int i5 = dVar.f27069b;
                        if (i5 == 0) {
                            gVar.g(dVar.f27070c);
                            this.f26935i = true;
                            this.f26932f[dVar.f27070c] = true;
                        } else if (i5 == 1) {
                            gVar.f(dVar.f27070c);
                        } else if (i5 == 2) {
                            gVar.h(dVar.f27071d);
                        }
                        this.f27068j.c(dVar);
                    }
                    int size2 = this.n.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        f fVar = this.n.get(i6);
                        long j3 = fVar.a;
                        int i7 = fVar.f27073b;
                        if (i7 == 0) {
                            gVar.b(fVar.f27074c, fVar.f27075d, fVar.f27079h, fVar.f27078g);
                            this.J = true;
                            this.w[fVar.f27078g] = true;
                        } else if (i7 == 1) {
                            gVar.a(fVar.f27074c, fVar.f27075d, fVar.f27079h, fVar.f27078g);
                        } else if (i7 == 2) {
                            gVar.d(fVar.f27074c, fVar.f27075d, fVar.f27079h);
                        } else if (i7 == 3) {
                            gVar.c(fVar.f27076e, fVar.f27077f);
                        } else if (i7 == 4) {
                            gVar.e(fVar.f27074c, fVar.f27075d);
                        }
                        this.k.c(fVar);
                    }
                } else {
                    int size3 = this.n.size();
                    for (int i8 = 0; i8 < size3; i8++) {
                        f fVar2 = this.n.get(i8);
                        if (fVar2.f27073b == 0) {
                            this.J = true;
                        }
                        this.k.c(fVar2);
                    }
                    int size4 = this.m.size();
                    for (int i9 = 0; i9 < size4; i9++) {
                        this.f27068j.c(this.m.get(i9));
                    }
                }
                if (this.n.isEmpty()) {
                    for (int i10 = 0; i10 < this.q.length; i10++) {
                        this.q[0] = 0;
                        this.r[0] = 0;
                    }
                }
                this.m.clear();
                this.n.clear();
            }
        }
    }

    public final boolean[] n(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, zArr)) == null) {
            boolean[] zArr2 = new boolean[zArr.length + 2];
            System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
            return zArr2;
        }
        return (boolean[]) invokeL.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SensorManager sensorManager = this.x;
            if (sensorManager != null) {
                SensorEventListener sensorEventListener = this.N;
                if (sensorEventListener != null) {
                    sensorManager.unregisterListener(sensorEventListener);
                    this.N = null;
                }
                SensorEventListener sensorEventListener2 = this.O;
                if (sensorEventListener2 != null) {
                    this.x.unregisterListener(sensorEventListener2);
                    this.O = null;
                }
                SensorEventListener sensorEventListener3 = this.Q;
                if (sensorEventListener3 != null) {
                    this.x.unregisterListener(sensorEventListener3);
                    this.Q = null;
                }
                SensorEventListener sensorEventListener4 = this.P;
                if (sensorEventListener4 != null) {
                    this.x.unregisterListener(sensorEventListener4);
                    this.P = null;
                }
                this.x = null;
            }
            c.b.b.f.a.log("AndroidInput", "sensor listener tear down");
        }
    }

    @Override // android.view.View.OnGenericMotionListener
    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view, motionEvent)) == null) {
            if (this.S.a(motionEvent, this)) {
                return true;
            }
            int size = this.R.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.R.get(i2).onGenericMotion(view, motionEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048589, this, view, i2, keyEvent)) == null) {
            int size = this.l.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.l.get(i3).onKey(view, i2, keyEvent)) {
                    return true;
                }
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() > 0) {
                return a(i2);
            }
            synchronized (this) {
                if (keyEvent.getKeyCode() == 0 && keyEvent.getAction() == 2) {
                    String characters = keyEvent.getCharacters();
                    for (int i4 = 0; i4 < characters.length(); i4++) {
                        d e2 = this.f27068j.e();
                        e2.a = System.nanoTime();
                        e2.f27070c = 0;
                        e2.f27071d = characters.charAt(i4);
                        e2.f27069b = 2;
                        this.m.add(e2);
                    }
                    return false;
                }
                char unicodeChar = (char) keyEvent.getUnicodeChar();
                if (i2 == 67) {
                    unicodeChar = '\b';
                }
                if (keyEvent.getKeyCode() >= 0 && keyEvent.getKeyCode() <= 255) {
                    int action = keyEvent.getAction();
                    if (action == 0) {
                        d e3 = this.f27068j.e();
                        e3.a = System.nanoTime();
                        e3.f27071d = (char) 0;
                        e3.f27070c = keyEvent.getKeyCode();
                        e3.f27069b = 0;
                        if (i2 == 4 && keyEvent.isAltPressed()) {
                            e3.f27070c = 255;
                            i2 = 255;
                        }
                        this.m.add(e3);
                        if (!this.f26931e[e3.f27070c]) {
                            this.f26934h++;
                            this.f26931e[e3.f27070c] = true;
                        }
                    } else if (action == 1) {
                        long nanoTime = System.nanoTime();
                        d e4 = this.f27068j.e();
                        e4.a = nanoTime;
                        e4.f27071d = (char) 0;
                        e4.f27070c = keyEvent.getKeyCode();
                        e4.f27069b = 1;
                        if (i2 == 4 && keyEvent.isAltPressed()) {
                            e4.f27070c = 255;
                            i2 = 255;
                        }
                        this.m.add(e4);
                        d e5 = this.f27068j.e();
                        e5.a = nanoTime;
                        e5.f27071d = unicodeChar;
                        e5.f27070c = 0;
                        e5.f27069b = 2;
                        this.m.add(e5);
                        if (i2 == 255) {
                            if (this.f26931e[255]) {
                                this.f26934h--;
                                this.f26931e[255] = false;
                            }
                        } else if (this.f26931e[keyEvent.getKeyCode()]) {
                            this.f26934h--;
                            this.f26931e[keyEvent.getKeyCode()] = false;
                        }
                    }
                    this.B.getGraphics().c();
                    return a(i2);
                }
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    @Override // c.b.b.l.a.m
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            o();
            Arrays.fill(this.u, -1);
            Arrays.fill(this.s, false);
        }
    }

    @Override // c.b.b.l.a.m
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            j();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, view, motionEvent)) == null) {
            if (this.T && view != null) {
                view.setFocusableInTouchMode(true);
                view.requestFocus();
                this.T = false;
            }
            this.D.a(motionEvent, this);
            int i2 = this.E;
            if (i2 != 0) {
                try {
                    Thread.sleep(i2);
                } catch (InterruptedException unused) {
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
