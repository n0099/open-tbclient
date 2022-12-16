package com.baidu.nadcore.player.helper;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a41;
import com.baidu.tieba.jv0;
import com.baidu.tieba.rr0;
import com.baidu.tieba.v41;
import com.baidu.tieba.yz0;
import com.baidu.tieba.zi0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdVideoGesture {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public int c;
    public boolean d;
    public VideoPluginGesture e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public jv0 l;
    public int m;
    public int n;

    public void a(float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
        }
    }

    public abstract boolean c(MotionEvent motionEvent);

    public final boolean e(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? f >= f2 : invokeCommon.booleanValue;
    }

    public abstract void f(Context context);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public VideoPluginGesture(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (VideoPluginGesture) Enum.valueOf(VideoPluginGesture.class, str);
            }
            return (VideoPluginGesture) invokeL.objValue;
        }

        public static VideoPluginGesture[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (VideoPluginGesture[]) $VALUES.clone();
            }
            return (VideoPluginGesture[]) invokeV.objValue;
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
        o = yz0.b(zi0.b()) / 10;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = VideoPluginGesture.InitChange;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.l = null;
        }
    }

    public BdVideoGesture(Context context, @NonNull jv0 jv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jv0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = true;
        this.e = VideoPluginGesture.InitChange;
        this.f = false;
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.m = rr0.a;
        this.n = rr0.b;
        f(context);
        this.l = jv0Var;
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            jv0 jv0Var = this.l;
            if (jv0Var == null) {
                return false;
            }
            if (jv0Var.p()) {
                this.l.m(this.e);
                return false;
            } else if (motionEvent.getAction() == 0) {
                this.f = false;
                this.g = false;
                this.e = VideoPluginGesture.InitChange;
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getPointerId(0);
                this.i = yz0.c(zi0.b());
                this.j = this.l.getCurrentPosition();
                this.k = a41.a(this.l.o());
                this.l.m(this.e);
                return false;
            } else if (motionEvent.getAction() == 2) {
                if (c(motionEvent)) {
                    this.e = VideoPluginGesture.InitChange;
                    return false;
                } else if (motionEvent.getPointerId(0) != this.c) {
                    return false;
                } else {
                    d(this.a - motionEvent.getX(), this.b - motionEvent.getY(), this.a, this.b, this.m, this.n);
                    return false;
                }
            } else {
                boolean z = true;
                if (motionEvent.getAction() == 1) {
                    this.l.m(this.e);
                    z = (this.f && this.g) ? false : false;
                    VideoPluginGesture videoPluginGesture = this.e;
                    if (videoPluginGesture == VideoPluginGesture.PlayTimeChange) {
                        this.l.l(this.j, this.h);
                    } else if (videoPluginGesture == VideoPluginGesture.VolumeChange) {
                        this.l.b();
                    }
                    this.f = false;
                    this.g = false;
                    this.e = VideoPluginGesture.InitChange;
                    return z;
                } else if (motionEvent.getAction() != 3) {
                    return false;
                } else {
                    this.l.m(this.e);
                    this.f = false;
                    this.g = false;
                    this.e = VideoPluginGesture.InitChange;
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public void d(float f, float f2, float f3, float f4, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(i2)}) != null) || this.l == null) {
            return;
        }
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f);
        this.g = true;
        if (!this.f) {
            if (e(f3, i)) {
                this.e = VideoPluginGesture.VirtualKeyBoard;
                this.f = true;
                return;
            }
            double d = abs;
            double d2 = abs2;
            if (d > d2 * 1.0d && abs > v41.a(30.0f) && this.d) {
                this.f = true;
                if (f3 <= i / 2) {
                    this.e = VideoPluginGesture.BrightChange;
                    return;
                } else {
                    this.e = VideoPluginGesture.VolumeChange;
                    return;
                }
            } else if (d * 1.0d < d2 && abs2 > v41.a(30.0f)) {
                this.e = VideoPluginGesture.PlayTimeChange;
                this.f = true;
                return;
            } else {
                return;
            }
        }
        VideoPluginGesture videoPluginGesture = this.e;
        if (videoPluginGesture == VideoPluginGesture.PlayTimeChange) {
            this.h = (int) (((-f) / 100.0f) * 15.0f);
            a(f, i);
            this.l.c(this.j, this.h);
            return;
        }
        float f5 = 0.0f;
        if (videoPluginGesture == VideoPluginGesture.VolumeChange) {
            float f6 = this.i + ((f2 / 100.0f) * o);
            if (f6 > 0.0f) {
                if (f6 > yz0.b(zi0.b())) {
                    f5 = yz0.b(zi0.b());
                } else {
                    f5 = f6;
                }
            }
            this.l.f(f5);
        } else if (videoPluginGesture == VideoPluginGesture.BrightChange) {
            float f7 = this.k + ((f2 / 100.0f) * 25.0f);
            if (f7 > 0.0f) {
                if (f7 > 255.0f) {
                    f5 = 255.0f;
                } else {
                    f5 = f7;
                }
            }
            this.l.i(f5);
        }
    }
}
