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
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class z extends c.b.b.b implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public final float[] D;
    public final float[] E;
    public boolean F;
    public c.b.b.g G;
    public final c.b.b.l.a.b H;
    public final Input.Orientation I;
    public SensorEventListener J;
    public SensorEventListener K;
    public SensorEventListener L;
    public SensorEventListener M;
    public final ArrayList<View.OnGenericMotionListener> N;
    public final o O;
    public boolean P;

    /* renamed from: f  reason: collision with root package name */
    public c.b.b.q.z<d> f22454f;

    /* renamed from: g  reason: collision with root package name */
    public c.b.b.q.z<f> f22455g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<View.OnKeyListener> f22456h;
    public ArrayList<d> i;
    public ArrayList<f> j;
    public int[] k;
    public int[] l;
    public int[] m;
    public int[] n;
    public boolean[] o;
    public int[] p;
    public int[] q;
    public float[] r;
    public boolean[] s;
    public SensorManager t;
    public boolean u;
    public final float[] v;
    public final float[] w;
    public final Application x;
    public final Context y;
    public final t z;

    /* loaded from: classes3.dex */
    public class a extends c.b.b.q.z<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z zVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes3.dex */
    public class b extends c.b.b.q.z<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(z zVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f22457b;

        /* renamed from: c  reason: collision with root package name */
        public int f22458c;

        /* renamed from: d  reason: collision with root package name */
        public char f22459d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z a;

        public e(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent.sensor.getType() == 1) {
                    z zVar = this.a;
                    if (zVar.I == Input.Orientation.Portrait) {
                        float[] fArr = sensorEvent.values;
                        float[] fArr2 = zVar.v;
                        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                    } else {
                        float[] fArr3 = zVar.v;
                        float[] fArr4 = sensorEvent.values;
                        fArr3[0] = fArr4[1];
                        fArr3[1] = -fArr4[0];
                        fArr3[2] = fArr4[2];
                    }
                }
                if (sensorEvent.sensor.getType() == 2) {
                    float[] fArr5 = sensorEvent.values;
                    float[] fArr6 = this.a.D;
                    System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
                }
                if (sensorEvent.sensor.getType() == 4) {
                    z zVar2 = this.a;
                    if (zVar2.I == Input.Orientation.Portrait) {
                        float[] fArr7 = sensorEvent.values;
                        float[] fArr8 = zVar2.w;
                        System.arraycopy(fArr7, 0, fArr8, 0, fArr8.length);
                    } else {
                        float[] fArr9 = zVar2.w;
                        float[] fArr10 = sensorEvent.values;
                        fArr9[0] = fArr10[1];
                        fArr9[1] = -fArr10[0];
                        fArr9[2] = fArr10[2];
                    }
                }
                if (sensorEvent.sensor.getType() == 11) {
                    z zVar3 = this.a;
                    if (zVar3.I == Input.Orientation.Portrait) {
                        float[] fArr11 = sensorEvent.values;
                        float[] fArr12 = zVar3.E;
                        System.arraycopy(fArr11, 0, fArr12, 0, fArr12.length);
                        return;
                    }
                    float[] fArr13 = zVar3.E;
                    float[] fArr14 = sensorEvent.values;
                    fArr13[0] = fArr14[1];
                    fArr13[1] = -fArr14[0];
                    fArr13[2] = fArr14[2];
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f22460b;

        /* renamed from: c  reason: collision with root package name */
        public int f22461c;

        /* renamed from: d  reason: collision with root package name */
        public int f22462d;

        /* renamed from: e  reason: collision with root package name */
        public int f22463e;

        /* renamed from: f  reason: collision with root package name */
        public int f22464f;

        /* renamed from: g  reason: collision with root package name */
        public int f22465g;

        /* renamed from: h  reason: collision with root package name */
        public int f22466h;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22454f = new a(this, 16, 1000);
        this.f22455g = new b(this, 16, 1000);
        this.f22456h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = new int[20];
        this.l = new int[20];
        this.m = new int[20];
        this.n = new int[20];
        this.o = new boolean[20];
        this.p = new int[20];
        this.q = new int[20];
        this.r = new float[20];
        this.s = new boolean[20];
        int i3 = 0;
        this.u = false;
        this.v = new float[3];
        this.w = new float[3];
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = new float[3];
        this.E = new float[3];
        this.F = false;
        this.N = new ArrayList<>();
        this.P = true;
        if (obj instanceof View) {
            View view = (View) obj;
            view.setOnKeyListener(this);
            view.setOnTouchListener(this);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnGenericMotionListener(this);
        }
        this.H = bVar;
        this.O = new o();
        while (true) {
            int[] iArr = this.q;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = -1;
            i3++;
        }
        new Handler();
        this.x = application;
        this.y = context;
        this.A = bVar.m;
        t tVar = new t();
        this.z = tVar;
        tVar.c(context);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        int e2 = e();
        Graphics.a f2 = this.x.getGraphics().f();
        if (((e2 != 0 && e2 != 180) || f2.a < f2.f23709b) && ((e2 != 90 && e2 != 270) || f2.a > f2.f23709b)) {
            this.I = Input.Orientation.Portrait;
        } else {
            this.I = Input.Orientation.Landscape;
        }
        b(255, true);
    }

    public static int c(Input.OnscreenKeyboardType onscreenKeyboardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, onscreenKeyboardType)) == null) {
            int i = c.a[onscreenKeyboardType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return Cea708Decoder.COMMAND_SPA;
                            }
                            return 17;
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
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g();
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int length = this.q.length;
            for (int i = 0; i < length; i++) {
                if (this.q[i] == -1) {
                    return i;
                }
            }
            this.r = h(this.r);
            this.q = j(this.q);
            this.k = j(this.k);
            this.l = j(this.l);
            this.m = j(this.m);
            this.n = j(this.n);
            this.o = k(this.o);
            this.p = j(this.p);
            return length;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        int rotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.y;
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

    public int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.q[i2] == i) {
                    return i2;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < length; i3++) {
                sb.append(i3 + ":" + this.q[i3] + " ");
            }
            Application application = c.b.b.f.a;
            application.log("AndroidInput", "Pointer ID lookup failed: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + sb.toString());
            return -1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.H.f22411h) {
                SensorManager sensorManager = (SensorManager) this.y.getSystemService("sensor");
                this.t = sensorManager;
                if (sensorManager.getSensorList(1).isEmpty()) {
                    this.u = false;
                } else {
                    e eVar = new e(this);
                    this.J = eVar;
                    this.u = this.t.registerListener(eVar, this.t.getSensorList(1).get(0), this.H.l);
                }
            } else {
                this.u = false;
            }
            if (this.H.i) {
                SensorManager sensorManager2 = (SensorManager) this.y.getSystemService("sensor");
                this.t = sensorManager2;
                if (!sensorManager2.getSensorList(4).isEmpty()) {
                    e eVar2 = new e(this);
                    this.K = eVar2;
                    this.t.registerListener(eVar2, this.t.getSensorList(4).get(0), this.H.l);
                }
            }
            this.C = false;
            if (this.H.k) {
                if (this.t == null) {
                    this.t = (SensorManager) this.y.getSystemService("sensor");
                }
                List<Sensor> sensorList = this.t.getSensorList(11);
                if (!sensorList.isEmpty()) {
                    this.M = new e(this);
                    Iterator<Sensor> it = sensorList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Sensor next = it.next();
                        if (next.getVendor().equals("Google Inc.") && next.getVersion() == 3) {
                            this.C = this.t.registerListener(this.M, next, this.H.l);
                            break;
                        }
                    }
                    if (!this.C) {
                        this.C = this.t.registerListener(this.M, sensorList.get(0), this.H.l);
                    }
                }
            }
            if (this.H.j && !this.C) {
                if (this.t == null) {
                    this.t = (SensorManager) this.y.getSystemService("sensor");
                }
                Sensor defaultSensor = this.t.getDefaultSensor(2);
                if (defaultSensor != null) {
                    boolean z = this.u;
                    this.B = z;
                    if (z) {
                        e eVar3 = new e(this);
                        this.L = eVar3;
                        this.B = this.t.registerListener(eVar3, defaultSensor, this.H.l);
                    }
                } else {
                    this.B = false;
                }
            } else {
                this.B = false;
            }
            c.b.b.f.a.log("AndroidInput", "sensor listener setup");
        }
    }

    @Override // c.b.b.l.a.m
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.F) {
                    this.F = false;
                    for (int i = 0; i < this.s.length; i++) {
                        this.s[i] = false;
                    }
                }
                if (this.f22330e) {
                    this.f22330e = false;
                    for (int i2 = 0; i2 < this.f22327b.length; i2++) {
                        this.f22327b[i2] = false;
                    }
                }
                if (this.G != null) {
                    c.b.b.g gVar = this.G;
                    int size = this.i.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = this.i.get(i3);
                        long j = dVar.a;
                        int i4 = dVar.f22457b;
                        if (i4 == 0) {
                            gVar.g(dVar.f22458c);
                            this.f22330e = true;
                            this.f22327b[dVar.f22458c] = true;
                        } else if (i4 == 1) {
                            gVar.f(dVar.f22458c);
                        } else if (i4 == 2) {
                            gVar.h(dVar.f22459d);
                        }
                        this.f22454f.c(dVar);
                    }
                    int size2 = this.j.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        f fVar = this.j.get(i5);
                        long j2 = fVar.a;
                        int i6 = fVar.f22460b;
                        if (i6 == 0) {
                            gVar.b(fVar.f22461c, fVar.f22462d, fVar.f22466h, fVar.f22465g);
                            this.F = true;
                            this.s[fVar.f22465g] = true;
                        } else if (i6 == 1) {
                            gVar.a(fVar.f22461c, fVar.f22462d, fVar.f22466h, fVar.f22465g);
                        } else if (i6 == 2) {
                            gVar.d(fVar.f22461c, fVar.f22462d, fVar.f22466h);
                        } else if (i6 == 3) {
                            gVar.c(fVar.f22463e, fVar.f22464f);
                        } else if (i6 == 4) {
                            gVar.e(fVar.f22461c, fVar.f22462d);
                        }
                        this.f22455g.c(fVar);
                    }
                } else {
                    int size3 = this.j.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        f fVar2 = this.j.get(i7);
                        if (fVar2.f22460b == 0) {
                            this.F = true;
                        }
                        this.f22455g.c(fVar2);
                    }
                    int size4 = this.i.size();
                    for (int i8 = 0; i8 < size4; i8++) {
                        this.f22454f.c(this.i.get(i8));
                    }
                }
                if (this.j.isEmpty()) {
                    for (int i9 = 0; i9 < this.m.length; i9++) {
                        this.m[0] = 0;
                        this.n[0] = 0;
                    }
                }
                this.i.clear();
                this.j.clear();
            }
        }
    }

    public final float[] h(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fArr)) == null) {
            float[] fArr2 = new float[fArr.length + 2];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            return fArr2;
        }
        return (float[]) invokeL.objValue;
    }

    @Override // c.b.b.l.a.m
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public final int[] j(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
            int[] iArr2 = new int[iArr.length + 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public final boolean[] k(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, zArr)) == null) {
            boolean[] zArr2 = new boolean[zArr.length + 2];
            System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
            return zArr2;
        }
        return (boolean[]) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SensorManager sensorManager = this.t;
            if (sensorManager != null) {
                SensorEventListener sensorEventListener = this.J;
                if (sensorEventListener != null) {
                    sensorManager.unregisterListener(sensorEventListener);
                    this.J = null;
                }
                SensorEventListener sensorEventListener2 = this.K;
                if (sensorEventListener2 != null) {
                    this.t.unregisterListener(sensorEventListener2);
                    this.K = null;
                }
                SensorEventListener sensorEventListener3 = this.M;
                if (sensorEventListener3 != null) {
                    this.t.unregisterListener(sensorEventListener3);
                    this.M = null;
                }
                SensorEventListener sensorEventListener4 = this.L;
                if (sensorEventListener4 != null) {
                    this.t.unregisterListener(sensorEventListener4);
                    this.L = null;
                }
                this.t = null;
            }
            c.b.b.f.a.log("AndroidInput", "sensor listener tear down");
        }
    }

    @Override // android.view.View.OnGenericMotionListener
    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, motionEvent)) == null) {
            if (this.O.a(motionEvent, this)) {
                return true;
            }
            int size = this.N.size();
            for (int i = 0; i < size; i++) {
                if (this.N.get(i).onGenericMotion(view, motionEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048588, this, view, i, keyEvent)) == null) {
            int size = this.f22456h.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f22456h.get(i2).onKey(view, i, keyEvent)) {
                    return true;
                }
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() > 0) {
                return a(i);
            }
            synchronized (this) {
                if (keyEvent.getKeyCode() == 0 && keyEvent.getAction() == 2) {
                    String characters = keyEvent.getCharacters();
                    for (int i3 = 0; i3 < characters.length(); i3++) {
                        d e2 = this.f22454f.e();
                        e2.a = System.nanoTime();
                        e2.f22458c = 0;
                        e2.f22459d = characters.charAt(i3);
                        e2.f22457b = 2;
                        this.i.add(e2);
                    }
                    return false;
                }
                char unicodeChar = (char) keyEvent.getUnicodeChar();
                if (i == 67) {
                    unicodeChar = '\b';
                }
                if (keyEvent.getKeyCode() >= 0 && keyEvent.getKeyCode() <= 255) {
                    int action = keyEvent.getAction();
                    if (action == 0) {
                        d e3 = this.f22454f.e();
                        e3.a = System.nanoTime();
                        e3.f22459d = (char) 0;
                        e3.f22458c = keyEvent.getKeyCode();
                        e3.f22457b = 0;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            e3.f22458c = 255;
                            i = 255;
                        }
                        this.i.add(e3);
                        if (!this.a[e3.f22458c]) {
                            this.f22329d++;
                            this.a[e3.f22458c] = true;
                        }
                    } else if (action == 1) {
                        long nanoTime = System.nanoTime();
                        d e4 = this.f22454f.e();
                        e4.a = nanoTime;
                        e4.f22459d = (char) 0;
                        e4.f22458c = keyEvent.getKeyCode();
                        e4.f22457b = 1;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            e4.f22458c = 255;
                            i = 255;
                        }
                        this.i.add(e4);
                        d e5 = this.f22454f.e();
                        e5.a = nanoTime;
                        e5.f22459d = unicodeChar;
                        e5.f22458c = 0;
                        e5.f22457b = 2;
                        this.i.add(e5);
                        if (i == 255) {
                            if (this.a[255]) {
                                this.f22329d--;
                                this.a[255] = false;
                            }
                        } else if (this.a[keyEvent.getKeyCode()]) {
                            this.f22329d--;
                            this.a[keyEvent.getKeyCode()] = false;
                        }
                    }
                    this.x.getGraphics().c();
                    return a(i);
                }
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    @Override // c.b.b.l.a.m
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            l();
            Arrays.fill(this.q, -1);
            Arrays.fill(this.o, false);
        }
    }

    @Override // c.b.b.l.a.m
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            g();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, motionEvent)) == null) {
            if (this.P && view != null) {
                view.setFocusableInTouchMode(true);
                view.requestFocus();
                this.P = false;
            }
            this.z.a(motionEvent, this);
            int i = this.A;
            if (i != 0) {
                try {
                    Thread.sleep(i);
                } catch (InterruptedException unused) {
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.b.b.l.a.m
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            l();
            Arrays.fill(this.q, -1);
            Arrays.fill(this.o, false);
        }
    }
}
