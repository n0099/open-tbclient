package com.baidu.nadcore.player.helper;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import c.a.d0.h.a;
import c.a.d0.h0.o;
import c.a.d0.i0.a.d.b;
import c.a.d0.v.d;
import c.a.d0.v.f0.f;
import c.a.d0.v.v0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BdVideoGesture {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f37281b;

    /* renamed from: c  reason: collision with root package name */
    public int f37282c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37283d;

    /* renamed from: e  reason: collision with root package name */
    public VideoPluginGesture f37284e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37285f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37286g;

    /* renamed from: h  reason: collision with root package name */
    public int f37287h;

    /* renamed from: i  reason: collision with root package name */
    public int f37288i;

    /* renamed from: j  reason: collision with root package name */
    public int f37289j;
    public int k;
    public f l;
    public int m;
    public int n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class VideoPluginGesture {
        public static final /* synthetic */ VideoPluginGesture[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VideoPluginGesture BrightChange;
        public static final VideoPluginGesture InitChange;
        public static final VideoPluginGesture PlayTimeChange;
        public static final VideoPluginGesture VirtualKeyBoard;
        public static final VideoPluginGesture VolumeChange;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1076733484, "Lcom/baidu/nadcore/player/helper/BdVideoGesture$VideoPluginGesture;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1076733484, "Lcom/baidu/nadcore/player/helper/BdVideoGesture$VideoPluginGesture;");
                    return;
                }
            }
            InitChange = new VideoPluginGesture("InitChange", 0);
            VolumeChange = new VideoPluginGesture("VolumeChange", 1);
            PlayTimeChange = new VideoPluginGesture("PlayTimeChange", 2);
            BrightChange = new VideoPluginGesture("BrightChange", 3);
            VideoPluginGesture videoPluginGesture = new VideoPluginGesture("VirtualKeyBoard", 4);
            VirtualKeyBoard = videoPluginGesture;
            $VALUES = new VideoPluginGesture[]{InitChange, VolumeChange, PlayTimeChange, BrightChange, videoPluginGesture};
        }

        public VideoPluginGesture(String str, int i2) {
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

        public static VideoPluginGesture valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VideoPluginGesture) Enum.valueOf(VideoPluginGesture.class, str) : (VideoPluginGesture) invokeL.objValue;
        }

        public static VideoPluginGesture[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VideoPluginGesture[]) $VALUES.clone() : (VideoPluginGesture[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-165159157, "Lcom/baidu/nadcore/player/helper/BdVideoGesture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-165159157, "Lcom/baidu/nadcore/player/helper/BdVideoGesture;");
                return;
            }
        }
        o = k.b(a.b()) / 10;
    }

    public BdVideoGesture(Context context, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37283d = true;
        this.f37284e = VideoPluginGesture.InitChange;
        this.f37285f = false;
        this.f37286g = false;
        this.f37287h = 0;
        this.f37288i = 0;
        this.f37289j = 0;
        this.m = d.a;
        this.n = d.f3258b;
        f(context);
        this.l = fVar;
    }

    public void a(float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
        }
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            f fVar = this.l;
            if (fVar == null) {
                return false;
            }
            if (fVar.p()) {
                this.l.m(this.f37284e);
                return false;
            } else if (motionEvent.getAction() == 0) {
                this.f37285f = false;
                this.f37286g = false;
                this.f37284e = VideoPluginGesture.InitChange;
                this.a = motionEvent.getX();
                this.f37281b = motionEvent.getY();
                this.f37282c = motionEvent.getPointerId(0);
                this.f37288i = k.c(a.b());
                this.f37289j = this.l.getCurrentPosition();
                this.k = o.a(this.l.o());
                this.l.m(this.f37284e);
                return false;
            } else if (motionEvent.getAction() == 2) {
                if (c(motionEvent)) {
                    this.f37284e = VideoPluginGesture.InitChange;
                    return false;
                } else if (motionEvent.getPointerId(0) == this.f37282c) {
                    d(this.a - motionEvent.getX(), this.f37281b - motionEvent.getY(), this.a, this.f37281b, this.m, this.n);
                    return false;
                } else {
                    return false;
                }
            } else {
                boolean z = true;
                if (motionEvent.getAction() == 1) {
                    this.l.m(this.f37284e);
                    z = (this.f37285f && this.f37286g) ? false : false;
                    VideoPluginGesture videoPluginGesture = this.f37284e;
                    if (videoPluginGesture == VideoPluginGesture.PlayTimeChange) {
                        this.l.l(this.f37289j, this.f37287h);
                    } else if (videoPluginGesture == VideoPluginGesture.VolumeChange) {
                        this.l.b();
                    }
                    this.f37285f = false;
                    this.f37286g = false;
                    this.f37284e = VideoPluginGesture.InitChange;
                    return z;
                } else if (motionEvent.getAction() == 3) {
                    this.l.m(this.f37284e);
                    this.f37285f = false;
                    this.f37286g = false;
                    this.f37284e = VideoPluginGesture.InitChange;
                    return false;
                } else {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public abstract boolean c(MotionEvent motionEvent);

    public void d(float f2, float f3, float f4, float f5, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || this.l == null) {
            return;
        }
        float abs = Math.abs(f3);
        float abs2 = Math.abs(f2);
        this.f37286g = true;
        if (!this.f37285f) {
            if (e(f4, i2)) {
                this.f37284e = VideoPluginGesture.VirtualKeyBoard;
                this.f37285f = true;
                return;
            }
            double d2 = abs;
            double d3 = abs2;
            if (d2 > d3 * 1.0d && abs > b.a(30.0f) && this.f37283d) {
                this.f37285f = true;
                if (f4 <= i2 / 2) {
                    this.f37284e = VideoPluginGesture.BrightChange;
                    return;
                } else {
                    this.f37284e = VideoPluginGesture.VolumeChange;
                    return;
                }
            } else if (d2 * 1.0d >= d3 || abs2 <= b.a(30.0f)) {
                return;
            } else {
                this.f37284e = VideoPluginGesture.PlayTimeChange;
                this.f37285f = true;
                return;
            }
        }
        VideoPluginGesture videoPluginGesture = this.f37284e;
        if (videoPluginGesture == VideoPluginGesture.PlayTimeChange) {
            this.f37287h = (int) (((-f2) / 100.0f) * 15.0f);
            a(f2, i2);
            this.l.c(this.f37289j, this.f37287h);
            return;
        }
        if (videoPluginGesture == VideoPluginGesture.VolumeChange) {
            float f6 = this.f37288i + ((f3 / 100.0f) * o);
            if (f6 > 0.0f) {
                r13 = f6 > ((float) k.b(a.b())) ? k.b(a.b()) : f6;
            }
            this.l.f(r13);
        } else if (videoPluginGesture == VideoPluginGesture.BrightChange) {
            float f7 = this.k + ((f3 / 100.0f) * 25.0f);
            this.l.i(f7 > 0.0f ? f7 > 255.0f ? 255.0f : f7 : 0.0f);
        }
    }

    public final boolean e(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f2 >= f3 : invokeCommon.booleanValue;
    }

    public abstract void f(Context context);

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f37284e = VideoPluginGesture.InitChange;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.l = null;
        }
    }
}
