package com.baidu.ar.arplay.core.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e eA;
    public Map<Integer, Vector<Float>> eB;
    public boolean eC;
    public e eD;
    public e eE;
    public e eF;
    public e eG;
    public double eH;
    public boolean eI;
    public boolean eJ;
    public d eK;
    public com.baidu.ar.arplay.core.engine.b es;
    public b et;
    public boolean eu;
    public boolean ev;
    public boolean ew;
    public int ex;
    public int ey;
    public c ez;
    public boolean isScreenOrientationLandscape;

    /* renamed from: com.baidu.ar.arplay.core.engine.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] eL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130576860, "Lcom/baidu/ar/arplay/core/engine/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-130576860, "Lcom/baidu/ar/arplay/core/engine/a$1;");
                    return;
                }
            }
            int[] iArr = new int[c.values().length];
            eL = iArr;
            try {
                iArr[c.eY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eL[c.eZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eL[c.fb.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eL[c.fc.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eL[c.fd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eL[c.fh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eL[c.fi.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                eL[c.fa.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                eL[c.fg.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                eL[c.fe.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                eL[c.ff.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                eL[c.fj.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ar.arplay.core.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class EnumC0070a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC0070a eM;
        public static final EnumC0070a eN;
        public static final EnumC0070a eO;
        public static final EnumC0070a eP;
        public static final EnumC0070a eQ;
        public static final EnumC0070a eR;
        public static final EnumC0070a eS;
        public static final EnumC0070a eT;
        public static final EnumC0070a eU;
        public static final EnumC0070a eV;
        public static final /* synthetic */ EnumC0070a[] eW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130575372, "Lcom/baidu/ar/arplay/core/engine/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-130575372, "Lcom/baidu/ar/arplay/core/engine/a$a;");
                    return;
                }
            }
            eM = new EnumC0070a("EGESTURE_CLICK", 0);
            eN = new EnumC0070a("EGESTURE_DOUBLE_CLICK", 1);
            eO = new EnumC0070a("EGESTURE_LONG_PRESS", 2);
            eP = new EnumC0070a("EGESTURE_SWIPE", 3);
            eQ = new EnumC0070a("EGESTURE_SINGLE_FINGER_SCROLL", 4);
            eR = new EnumC0070a("EGESTURE_TWO_FINGER_SCROLL", 5);
            eS = new EnumC0070a("EGESTURE_TWO_FINGER_PINCH", 6);
            eT = new EnumC0070a("EGESTURE_TWO_FINGER_UNPINCH", 7);
            eU = new EnumC0070a("EGESTURE_TWO_FINGER_ROTATE", 8);
            EnumC0070a enumC0070a = new EnumC0070a("EGESTURE_CLEAR", 9);
            eV = enumC0070a;
            eW = new EnumC0070a[]{eM, eN, eO, eP, eQ, eR, eS, eT, eU, enumC0070a};
        }

        public EnumC0070a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EnumC0070a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0070a) Enum.valueOf(EnumC0070a.class, str) : (EnumC0070a) invokeL.objValue;
        }

        public static EnumC0070a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0070a[]) eW.clone() : (EnumC0070a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a eX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.eX = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (this.eX.ew) {
                    return;
                }
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2 && (obj = message.obj) != null) {
                        e eVar = (e) obj;
                        this.eX.a(eVar.time, eVar.id, eVar.x, eVar.y);
                    }
                } else if (this.eX.ez == c.eY && this.eX.eC) {
                    this.eX.ez = c.fa;
                    this.eX.b(System.currentTimeMillis(), this.eX.eD.id, this.eX.eD.x, this.eX.eD.y);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c eY;
        public static final c eZ;
        public static final c fa;
        public static final c fb;
        public static final c fc;
        public static final c fd;
        public static final c fe;
        public static final c ff;
        public static final c fg;
        public static final c fh;
        public static final c fi;
        public static final c fj;
        public static final /* synthetic */ c[] fk;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130575310, "Lcom/baidu/ar/arplay/core/engine/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-130575310, "Lcom/baidu/ar/arplay/core/engine/a$c;");
                    return;
                }
            }
            eY = new c("EStatSingFingerCandidate", 0);
            eZ = new c("EStatTwoFingersCandidate", 1);
            fa = new c("EStatLongPress", 2);
            fb = new c("EStatScroll", 3);
            fc = new c("EStatSwipe", 4);
            fd = new c("EStatTwoFingersScroll", 5);
            fe = new c("EStatPinch", 6);
            ff = new c("EStatUnPinch", 7);
            fg = new c("EScrollAfterLongPress", 8);
            fh = new c("EStatPinchAndUnpinch", 9);
            fi = new c("EStatTwoFingersRotate", 10);
            c cVar = new c("EStatUnknown", 11);
            fj = cVar;
            fk = new c[]{eY, eZ, fa, fb, fc, fd, fe, ff, fg, fh, fi, cVar};
        }

        public c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) fk.clone() : (c[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d fl;
        public static final d fm;
        public static final d fn;
        public static final d fo;
        public static final /* synthetic */ d[] fp;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130575279, "Lcom/baidu/ar/arplay/core/engine/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-130575279, "Lcom/baidu/ar/arplay/core/engine/a$d;");
                    return;
                }
            }
            fl = new d("ESWIPE_RIGHT", 0);
            fm = new d("ESWIPE_LEFT", 1);
            fn = new d("ESWIPE_UP", 2);
            d dVar = new d("ESWIPE_DOWN", 3);
            fo = dVar;
            fp = new d[]{fl, fm, fn, dVar};
        }

        public d(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static d valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (d) Enum.valueOf(d.class, str) : (d) invokeL.objValue;
        }

        public static d[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (d[]) fp.clone() : (d[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a eX;
        public int id;
        public long time;
        public float x;
        public float y;

        public e(a aVar) {
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
            this.eX = aVar;
            this.id = -1;
            this.x = -1.0f;
            this.y = -1.0f;
            this.time = -1L;
        }

        public /* synthetic */ e(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        public void a(MotionEvent motionEvent, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, motionEvent, i2) == null) {
                this.id = motionEvent.getPointerId(i2);
                this.x = motionEvent.getX(i2);
                this.y = motionEvent.getY(i2);
                this.time = motionEvent.getEventTime();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "fingerId: " + this.id + " && x,y: " + this.x + "," + this.y + " && time: " + this.time;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f fq;
        public static final f fr;
        public static final f fs;
        public static final f ft;
        public static final /* synthetic */ f[] fu;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130575217, "Lcom/baidu/ar/arplay/core/engine/a$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-130575217, "Lcom/baidu/ar/arplay/core/engine/a$f;");
                    return;
                }
            }
            fq = new f("ETOUCH_BEGIN", 0);
            fr = new f("ETOUCH_MOVE", 1);
            fs = new f("ETOUCH_END", 2);
            f fVar = new f("ETOUCH_CANCEL", 3);
            ft = fVar;
            fu = new f[]{fq, fr, fs, fVar};
        }

        public f(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static f valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (f) Enum.valueOf(f.class, str) : (f) invokeL.objValue;
        }

        public static f[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (f[]) fu.clone() : (f[]) invokeV.objValue;
        }
    }

    public a(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.eu = true;
        this.ev = false;
        this.ew = false;
        this.isScreenOrientationLandscape = false;
        this.ex = 0;
        this.ey = 0;
        this.ez = c.eY;
        this.eA = null;
        this.eB = new HashMap();
        this.eC = true;
        this.eD = new e(this, null);
        this.eE = new e(this, null);
        this.eF = new e(this, null);
        this.eG = new e(this, null);
        this.eH = -1.0d;
        this.eI = true;
        this.eJ = false;
        this.eK = d.fl;
        this.es = new com.baidu.ar.arplay.core.engine.b();
        this.et = new b(this, looper);
        onResume();
    }

    private double a(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            double atan2 = Math.atan2(d5, d4) - Math.atan2(d3, d2);
            return atan2 > 3.141592653589793d ? atan2 - 6.283185307179586d : atan2 < -3.141592653589793d ? atan2 + 6.283185307179586d : atan2;
        }
        return invokeCommon.doubleValue;
    }

    private double a(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 - f2;
            float f7 = f5 - f3;
            return Math.sqrt((f6 * f6) + (f7 * f7));
        }
        return invokeCommon.doubleValue;
    }

    private double a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)})) == null) {
            float f10 = f4 - f2;
            float f11 = f5 - f3;
            float f12 = f8 - f6;
            float f13 = f9 - f7;
            Log.d("ARPTouchInput", String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13)));
            double sqrt = ((f10 * f12) + (f11 * f13)) / (Math.sqrt((f10 * f10) + (f11 * f11)) * Math.sqrt((f12 * f12) + (f13 * f13)));
            try {
                sqrt = Double.parseDouble(new DecimalFormat("#.00").format(sqrt));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            double acos = Math.acos(sqrt);
            Log.d("ARPTouchInput", String.format("angle is %1.3f", Double.valueOf(Math.toDegrees(acos))));
            return acos;
        }
        return invokeCommon.doubleValue;
    }

    private void a(int i2, float f2, float f3, float f4, float f5, long j, int i3, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Long.valueOf(j), Integer.valueOf(i3), Float.valueOf(f6)}) == null) {
            if (this.isScreenOrientationLandscape) {
                f7 = this.ex - f3;
                f9 = f4;
                f8 = -f5;
                f10 = f2;
            } else {
                f7 = f2;
                f8 = f4;
                f9 = f5;
                f10 = f3;
            }
            float[] windowSize = ARPEngine.getInstance().getWindowSize();
            if (windowSize.length == 2 && windowSize[0] > 0.0f && windowSize[1] > 0.0f && (i4 = this.ex) > 0 && (i5 = this.ey) > 0) {
                float f11 = windowSize[0] / i4;
                float f12 = windowSize[1] / i5;
                f7 *= f11;
                f8 *= f11;
                f10 *= f12;
                f9 *= f12;
            }
            ARPEngine.getInstance().onTouchUpdate(i2, f7, f10, f8, f9, j, i3, f6);
        }
    }

    private void a(int i2, long j, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, int i5, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i4), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Integer.valueOf(i5), Float.valueOf(f10)}) == null) {
            if (this.isScreenOrientationLandscape) {
                int i8 = this.ex;
                f11 = i8 - f3;
                f14 = f6;
                f13 = i8 - f7;
                f12 = f2;
            } else {
                f11 = f2;
                f12 = f3;
                f13 = f6;
                f14 = f7;
            }
            float[] windowSize = ARPEngine.getInstance().getWindowSize();
            if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || (i6 = this.ex) <= 0 || (i7 = this.ey) <= 0) {
                f15 = f4;
                f16 = f5;
                f17 = f8;
                f18 = f9;
                f19 = f12;
                f20 = f11;
                f21 = f13;
                f22 = f14;
            } else {
                float f23 = windowSize[0] / i6;
                float f24 = windowSize[1] / i7;
                f19 = f12 * f24;
                f20 = f11 * f23;
                f21 = f13 * f23;
                f22 = f14 * f24;
                f18 = f24 * f9;
                f17 = f23 * f8;
                f15 = f4 * f23;
                f16 = f5 * f24;
            }
            ARPEngine.getInstance().onGestureUpdate(i2, j, i3, f20, f19, f15, f16, i4, f21, f22, f17, f18, i5, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i2, float f2, float f3) {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) && (bVar = this.es) != null && bVar.aW()) {
            a(EnumC0070a.eM.ordinal(), j, i2, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
            aS();
        }
    }

    private void a(long j, int i2, float f2, float f3, float f4, float f5) {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && (bVar = this.es) != null && bVar.aZ()) {
            a(EnumC0070a.eQ.ordinal(), j, i2, f2, f3, f4, f5, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        }
    }

    private void a(long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9) {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i3), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)}) == null) && (bVar = this.es) != null && bVar.ba()) {
            a(EnumC0070a.eR.ordinal(), j, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, -1, 0.0f);
        }
    }

    private void a(long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i3), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Boolean.valueOf(z)}) == null) {
            com.baidu.ar.arplay.core.engine.b bVar = this.es;
            if (bVar == null || !bVar.bc()) {
                return;
            }
            if (!this.eI) {
                if ((z && !this.eJ) || (!z && this.eJ)) {
                    aS();
                }
                this.eJ = z;
            }
            int ordinal = EnumC0070a.eT.ordinal();
            if (z) {
                ordinal = EnumC0070a.eS.ordinal();
            }
            a(ordinal, j, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, -1, 0.0f);
            if (this.eI) {
                this.eJ = z;
            }
        }
    }

    private void a(long j, int i2, float f2, float f3, int i3, float f4, float f5, float f6) {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) && (bVar = this.es) != null && bVar.bd()) {
            a(EnumC0070a.eU.ordinal(), j, i2, f2, f3, -1.0f, -1.0f, i3, f4, f5, -1.0f, -1.0f, -1, f6);
        }
    }

    private void a(long j, int i2, int i3) {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && (bVar = this.es) != null && bVar.bb()) {
            a(EnumC0070a.eP.ordinal(), j, i2, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, i3, 0.0f);
            clearStatus();
        }
    }

    private void a(MotionEvent motionEvent) {
        f fVar;
        float f2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, motionEvent) == null) || motionEvent.getPointerCount() <= 0) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        long eventTime = motionEvent.getEventTime();
        float pressure = motionEvent.getPressure(actionIndex);
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = motionEvent.getPointerCount();
                    int i4 = 0;
                    while (i4 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i4);
                        float x2 = motionEvent.getX(i4);
                        float y2 = motionEvent.getY(i4);
                        float f5 = 0.0f;
                        if (this.eB.containsKey(Integer.valueOf(pointerId2))) {
                            Vector<Float> vector = this.eB.get(Integer.valueOf(pointerId2));
                            f5 = x2 - vector.firstElement().floatValue();
                            f2 = y2 - vector.lastElement().floatValue();
                            vector.setElementAt(Float.valueOf(x2), 0);
                            vector.setElementAt(Float.valueOf(y2), 1);
                        } else {
                            f2 = 0.0f;
                        }
                        if (Math.abs(f5) > 0.1f || Math.abs(f2) > 0.1f) {
                            i2 = i4;
                            i3 = pointerCount;
                            a(pointerId2, x2, y2, f5, f2, eventTime, f.fr.ordinal(), motionEvent.getPressure(i4));
                        } else {
                            i2 = i4;
                            i3 = pointerCount;
                        }
                        i4 = i2 + 1;
                        pointerCount = i3;
                    }
                    return;
                } else if (actionMasked == 3) {
                    if (this.eB.containsKey(Integer.valueOf(pointerId))) {
                        Vector<Float> vector2 = this.eB.get(Integer.valueOf(pointerId));
                        this.eB.remove(Integer.valueOf(pointerId));
                        f4 = y - vector2.elementAt(1).floatValue();
                        f3 = x - vector2.elementAt(0).floatValue();
                    }
                    fVar = f.ft;
                    a(pointerId, x, y, f3, f4, eventTime, fVar.ordinal(), pressure);
                } else if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return;
                    }
                }
            }
            if (this.eB.containsKey(Integer.valueOf(pointerId))) {
                Vector<Float> vector3 = this.eB.get(Integer.valueOf(pointerId));
                this.eB.remove(Integer.valueOf(pointerId));
                f4 = y - vector3.elementAt(1).floatValue();
                f3 = x - vector3.elementAt(0).floatValue();
            }
            fVar = f.fs;
            a(pointerId, x, y, f3, f4, eventTime, fVar.ordinal(), pressure);
        }
        Vector<Float> vector4 = new Vector<>(2);
        vector4.add(Float.valueOf(x));
        vector4.add(Float.valueOf(y));
        this.eB.put(Integer.valueOf(pointerId), vector4);
        fVar = f.fq;
        a(pointerId, x, y, f3, f4, eventTime, fVar.ordinal(), pressure);
    }

    private void a(e eVar, e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, eVar, eVar2) == null) {
            eVar2.id = eVar.id;
            eVar2.x = eVar.x;
            eVar2.y = eVar.y;
            eVar2.time = eVar.time;
        }
    }

    private void aS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            a(EnumC0070a.eV.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        }
    }

    private void aT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            ARPEngine.getInstance().onGestureUpdateWithScaleFinish(EnumC0070a.eV.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
        }
    }

    private void aU() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.et.hasMessages(2)) {
            this.et.removeMessages(2);
            e eVar = this.eA;
            if (eVar != null) {
                a(eVar.time, eVar.id, eVar.x, eVar.y);
                this.eA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i2, float f2, float f3) {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) && (bVar = this.es) != null && bVar.aY()) {
            a(EnumC0070a.eO.ordinal(), j, i2, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        }
    }

    private void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, motionEvent) == null) {
            switch (AnonymousClass1.eL[this.ez.ordinal()]) {
                case 1:
                    c(motionEvent);
                    return;
                case 2:
                    h(motionEvent);
                    return;
                case 3:
                    i(motionEvent);
                    return;
                case 4:
                    j(motionEvent);
                    return;
                case 5:
                    k(motionEvent);
                    return;
                case 6:
                    l(motionEvent);
                    return;
                case 7:
                    m(motionEvent);
                    return;
                case 8:
                    n(motionEvent);
                    return;
                case 9:
                    o(motionEvent);
                    return;
                case 10:
                case 11:
                case 12:
                    p(motionEvent);
                    return;
                default:
                    return;
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, motionEvent) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                d(motionEvent);
            } else if (actionMasked == 1) {
                f(motionEvent);
            } else if (actionMasked == 2) {
                e(motionEvent);
            } else if (actionMasked != 5) {
            } else {
                g(motionEvent);
            }
        }
    }

    private void clearStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.ez = c.eY;
            this.eC = true;
            this.eH = -1.0d;
            this.et.removeMessages(1);
            if (this.et.hasMessages(2)) {
                return;
            }
            aS();
        }
    }

    private void d(MotionEvent motionEvent) {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, motionEvent) == null) {
            this.eD.a(motionEvent, motionEvent.getActionIndex());
            a(this.eD, this.eE);
            Log.d("ARPTouchInput", "touchDownInSingleFingerCandidate() mFirstFingerTouch = " + this.eD.toString());
            if (this.et.hasMessages(2) && (eVar = this.eA) != null) {
                float f2 = eVar.x;
                float f3 = eVar.y;
                e eVar2 = this.eD;
                if (a(f2, f3, eVar2.x, eVar2.y) > 100.0d) {
                    aU();
                }
            }
            this.et.sendEmptyMessageDelayed(1, 600L);
        }
    }

    private void e(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, motionEvent) == null) {
            e eVar = this.eD;
            double a2 = a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY());
            Log.d("ARPTouchInput", "touchMoveInSingleFingerCandidate() distance = " + a2);
            if (a2 < 20.0d) {
                if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                    this.ez = c.fa;
                    b(motionEvent.getDownTime(), this.eD.id, motionEvent.getX(), motionEvent.getY());
                    this.et.removeMessages(1);
                }
                this.eE.a(motionEvent, 0);
            } else if (a2 < 50.0d) {
                this.eC = false;
                this.eE.a(motionEvent, 0);
            } else {
                aU();
                this.ez = c.fb;
                a(motionEvent.getEventTime(), this.eD.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
                this.et.removeMessages(1);
                this.eE.a(motionEvent, 0);
            }
        }
    }

    private void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, motionEvent) == null) {
            e eVar = this.eD;
            if (a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300) {
                com.baidu.ar.arplay.core.engine.b bVar = this.es;
                if (bVar != null && bVar.aX()) {
                    if (this.et.hasMessages(2)) {
                        this.et.removeMessages(2);
                    } else {
                        Message obtain = Message.obtain();
                        obtain.what = 2;
                        e eVar2 = new e(this, null);
                        eVar2.a(motionEvent, 0);
                        obtain.obj = eVar2;
                        this.eA = eVar2;
                        this.et.sendMessageDelayed(obtain, 400L);
                    }
                }
                a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
            }
            clearStatus();
        }
    }

    private void g(MotionEvent motionEvent) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, motionEvent) == null) {
            Log.d("ARPTouchInput", "touchPointerDownInSingleFingerCandidate() mFirstFingnerInClickArea = " + this.eC);
            if (this.eC) {
                this.eF.a(motionEvent, motionEvent.getActionIndex());
                a(this.eF, this.eG);
                cVar = c.eZ;
            } else {
                cVar = c.fj;
            }
            this.ez = cVar;
            aU();
        }
    }

    private void h(MotionEvent motionEvent) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, motionEvent) == null) {
            if (2 != motionEvent.getActionMasked()) {
                this.ez = c.fj;
                return;
            }
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            e eVar = this.eD;
            double a2 = a(eVar.x, eVar.y, u, v);
            e eVar2 = this.eF;
            double a3 = a(eVar2.x, eVar2.y, w, x);
            if ((a2 > 50.0d || a3 > 50.0d) && a2 > 20.0d && a3 > 20.0d) {
                e eVar3 = this.eD;
                float f4 = eVar3.x;
                float f5 = eVar3.y;
                e eVar4 = this.eF;
                double a4 = a(f4, f5, u, v, eVar4.x, eVar4.y, w, x);
                if (a4 < 0.7853981633974483d) {
                    this.ez = c.fd;
                    a(motionEvent.getDownTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent));
                    Log.d("ARPTouchInput", "EStatTwoFingersScroll");
                    f2 = w;
                    f3 = x;
                } else {
                    if (a4 > 3.141592653589793d || a4 <= 1.5707963267948966d) {
                        f2 = w;
                        f3 = x;
                        this.ez = c.fh;
                    } else {
                        e eVar5 = this.eD;
                        float f6 = eVar5.x;
                        e eVar6 = this.eF;
                        float f7 = (eVar6.x + f6) / 2.0f;
                        float f8 = eVar5.y;
                        float f9 = (eVar6.y + f8) / 2.0f;
                        double a5 = a(f7, f9, f6, f8, f6, f8, u, v);
                        e eVar7 = this.eF;
                        float f10 = eVar7.x;
                        float f11 = eVar7.y;
                        double a6 = a(f7, f9, f10, f11, f10, f11, w, x);
                        if (Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a6 - 1.5707963267948966d) < 0.6283185307179586d) {
                            f2 = w;
                            f3 = x;
                            this.ez = c.fi;
                        } else {
                            this.ez = c.fh;
                            f2 = w;
                            f3 = x;
                        }
                    }
                    this.eH = a(u, v, f2, f3);
                }
            } else {
                f3 = x;
                f2 = w;
            }
            e eVar8 = this.eE;
            eVar8.x = u;
            eVar8.y = v;
            eVar8.time = motionEvent.getEventTime();
            e eVar9 = this.eG;
            eVar9.x = f2;
            eVar9.y = f3;
            eVar9.time = motionEvent.getEventTime();
        }
    }

    private void i(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, motionEvent) == null) {
            try {
                if (5 == motionEvent.getActionMasked()) {
                    this.eD.a(motionEvent, this.eD.id);
                    a(this.eD, this.eE);
                    this.eF.a(motionEvent, motionEvent.getActionIndex());
                    a(this.eF, this.eG);
                    this.ez = c.eZ;
                    if (this.es == null || !this.es.aZ()) {
                        return;
                    }
                    aS();
                    return;
                }
                if (6 != motionEvent.getActionMasked()) {
                    if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        return;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.eE.time >= 1) {
                            float u = u(motionEvent);
                            float v = v(motionEvent);
                            a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent));
                            float f2 = u - this.eE.x;
                            float f3 = v - this.eE.y;
                            float eventTime = f2 / ((float) (motionEvent.getEventTime() - this.eE.time));
                            float eventTime2 = f3 / ((float) (motionEvent.getEventTime() - this.eE.time));
                            if (Math.abs(f2) <= Math.abs(f3) || Math.abs(f2) <= 100.0d || Math.abs(eventTime) <= 20.0d) {
                                if (Math.abs(f3) > Math.abs(f2) && Math.abs(f3) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                                    this.eK = f3 > 0.0f ? d.fo : d.fn;
                                }
                                this.eE.x = u;
                                this.eE.y = v;
                                this.eE.time = motionEvent.getEventTime();
                                return;
                            }
                            this.eK = f2 > 0.0f ? d.fl : d.fm;
                            this.ez = c.fc;
                            this.eE.x = u;
                            this.eE.y = v;
                            this.eE.time = motionEvent.getEventTime();
                            return;
                        }
                        return;
                    }
                }
                this.ez = c.fj;
            } catch (Exception unused) {
                Log.e("ARPTouchInput", "Monkey event.getX Exception");
            }
        }
    }

    private void j(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65570, this, motionEvent) == null) && 1 == motionEvent.getActionMasked()) {
            a(motionEvent.getEventTime(), this.eD.id, this.eK.ordinal());
        }
    }

    private void k(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, motionEvent) == null) {
            if (5 != motionEvent.getActionMasked()) {
                if (6 == motionEvent.getActionMasked()) {
                    this.ez = c.fb;
                    int action = (motionEvent.getAction() & 65280) >>> 8;
                    e eVar = this.eD;
                    if (action == eVar.id) {
                        a(this.eF, eVar);
                        a(this.eG, this.eE);
                    }
                    aS();
                    return;
                } else if (2 == motionEvent.getActionMasked()) {
                    if (motionEvent.getEventTime() - this.eE.time < 1 || motionEvent.getEventTime() - this.eG.time < 1) {
                        return;
                    }
                    float u = u(motionEvent);
                    float v = v(motionEvent);
                    float w = w(motionEvent);
                    float x = x(motionEvent);
                    a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent));
                    e eVar2 = this.eD;
                    eVar2.x = u;
                    eVar2.y = v;
                    this.eE.time = motionEvent.getEventTime();
                    e eVar3 = this.eG;
                    eVar3.x = w;
                    eVar3.y = x;
                    eVar3.time = motionEvent.getEventTime();
                    return;
                }
            }
            this.ez = c.fj;
        }
    }

    private void l(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, motionEvent) == null) {
            if (5 == motionEvent.getActionMasked()) {
                this.ez = c.fj;
                this.eI = true;
            } else if (6 == motionEvent.getActionMasked()) {
                this.ez = c.fb;
                int action = (motionEvent.getAction() & 65280) >>> 8;
                e eVar = this.eD;
                if (action == eVar.id) {
                    eVar.id = this.eF.id;
                }
                this.eI = true;
                aT();
            } else if (2 != motionEvent.getActionMasked()) {
                this.ez = c.fj;
            } else if (motionEvent.getEventTime() - this.eE.time >= 1 && motionEvent.getEventTime() - this.eG.time >= 1) {
                float u = u(motionEvent);
                float v = v(motionEvent);
                float w = w(motionEvent);
                float x = x(motionEvent);
                double a2 = a(u, v, w, x);
                a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent), a2 < this.eH);
                this.eH = a2;
                e eVar2 = this.eD;
                eVar2.x = u;
                eVar2.y = v;
                this.eE.time = motionEvent.getEventTime();
                e eVar3 = this.eG;
                eVar3.x = w;
                eVar3.y = x;
                eVar3.time = motionEvent.getEventTime();
            }
        }
    }

    private void m(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, motionEvent) == null) {
            if (2 != motionEvent.getActionMasked()) {
                if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    return;
                } else {
                    this.ez = c.fj;
                    return;
                }
            }
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            e eVar = this.eG;
            float f2 = eVar.x;
            e eVar2 = this.eD;
            a(motionEvent.getEventTime(), this.eD.id, u, v, this.eF.id, w, x, (float) a(f2 - eVar2.x, eVar.y - eVar2.y, w - u, x - v));
            e eVar3 = this.eD;
            eVar3.x = u;
            eVar3.y = v;
            this.eE.time = motionEvent.getEventTime();
            e eVar4 = this.eG;
            eVar4.x = w;
            eVar4.y = x;
            eVar4.time = motionEvent.getEventTime();
        }
    }

    private void n(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, this, motionEvent) == null) {
            if (2 != motionEvent.getActionMasked()) {
                if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    return;
                } else {
                    this.ez = c.fj;
                    return;
                }
            }
            e eVar = this.eD;
            if (a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
                this.ez = c.fg;
                a(motionEvent.getEventTime(), this.eD.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
                this.eD.x = u(motionEvent);
                this.eD.y = v(motionEvent);
                this.eE.time = motionEvent.getEventTime();
            }
        }
    }

    private void o(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, motionEvent) == null) {
            if (2 != motionEvent.getActionMasked()) {
                if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    return;
                } else {
                    this.ez = c.fj;
                    return;
                }
            }
            a(motionEvent.getEventTime(), this.eD.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.eD.x = u(motionEvent);
            this.eD.y = v(motionEvent);
            this.eE.time = motionEvent.getEventTime();
        }
    }

    private void p(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65576, this, motionEvent) == null) && 1 == motionEvent.getActionMasked()) {
            clearStatus();
        }
    }

    private float q(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, this, motionEvent)) == null) ? (motionEvent.getX(motionEvent.findPointerIndex(this.eD.id)) - this.eD.x) / ((float) (motionEvent.getEventTime() - this.eE.time)) : invokeL.floatValue;
    }

    private float r(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, this, motionEvent)) == null) ? (motionEvent.getY(motionEvent.findPointerIndex(this.eD.id)) - this.eD.y) / ((float) (motionEvent.getEventTime() - this.eE.time)) : invokeL.floatValue;
    }

    private float s(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, this, motionEvent)) == null) ? (motionEvent.getX(motionEvent.findPointerIndex(this.eF.id)) - this.eG.x) / ((float) (motionEvent.getEventTime() - this.eG.time)) : invokeL.floatValue;
    }

    private float t(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, this, motionEvent)) == null) ? (motionEvent.getY(motionEvent.findPointerIndex(this.eF.id)) - this.eG.y) / ((float) (motionEvent.getEventTime() - this.eG.time)) : invokeL.floatValue;
    }

    private float u(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, this, motionEvent)) == null) ? motionEvent.getX(motionEvent.findPointerIndex(this.eD.id)) : invokeL.floatValue;
    }

    private float v(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, this, motionEvent)) == null) ? motionEvent.getY(motionEvent.findPointerIndex(this.eD.id)) : invokeL.floatValue;
    }

    private float w(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65583, this, motionEvent)) == null) ? motionEvent.getX(motionEvent.findPointerIndex(this.eF.id)) : invokeL.floatValue;
    }

    private float x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, this, motionEvent)) == null) ? motionEvent.getY(motionEvent.findPointerIndex(this.eF.id)) : invokeL.floatValue;
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            Log.d("ARPTouchInput", "setScreenWidthHight width * height = " + i2 + " * " + i3);
            if (this.isScreenOrientationLandscape) {
                this.ex = i3;
                this.ey = i2;
                return;
            }
            this.ex = i2;
            this.ey = i3;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.ev = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.eu = z;
        }
    }

    public void onPause() {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.es) == null) {
            return;
        }
        bVar.onPause();
    }

    public final void onResume() {
        com.baidu.ar.arplay.core.engine.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.es) == null) {
            return;
        }
        bVar.onResume();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            if (this.ev && this.eu && !this.ew) {
                a(motionEvent);
                b(motionEvent);
                return;
            }
            Log.e("ARPTouchInput", "onTouchEvent mEnginSoLoaded = " + this.ev + " && mUserTouchEnable = " + this.eu + " && mReleased = " + this.ew);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.ew = true;
            b bVar = this.et;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages(null);
                this.es = null;
            }
            com.baidu.ar.arplay.core.engine.b bVar2 = this.es;
            if (bVar2 != null) {
                bVar2.release();
                this.es = null;
            }
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            Log.d("ARPTouchInput", "setScreenOrientationLandscape landscape = " + z);
            this.isScreenOrientationLandscape = z;
        }
    }
}
