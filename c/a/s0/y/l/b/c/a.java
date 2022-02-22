package c.a.s0.y.l.b.c;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f12225j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f12226e;

    /* renamed from: f  reason: collision with root package name */
    public final GestureDetector f12227f;

    /* renamed from: g  reason: collision with root package name */
    public b f12228g;

    /* renamed from: h  reason: collision with root package name */
    public MediaGestureMode f12229h;

    /* renamed from: i  reason: collision with root package name */
    public int f12230i;

    /* renamed from: c.a.s0.y.l.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C0834a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1169977275, "Lc/a/s0/y/l/b/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1169977275, "Lc/a/s0/y/l/b/c/a$a;");
                    return;
                }
            }
            int[] iArr = new int[MediaGestureMode.values().length];
            a = iArr;
            try {
                iArr[MediaGestureMode.VOLUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MediaGestureMode.BRIGHTNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MediaGestureMode.FAST_FORWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1230266392, "Lc/a/s0/y/l/b/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1230266392, "Lc/a/s0/y/l/b/c/a;");
                return;
            }
        }
        f12225j = k.a;
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12229h = MediaGestureMode.INTI;
        this.f12226e = context;
        this.f12227f = new GestureDetector(context, this);
    }

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1 && (bVar = this.f12228g) != null) {
                bVar.onTouchUp(motionEvent, this.f12229h);
            }
            return this.f12227f.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final MediaGestureMode b(MediaGestureMode mediaGestureMode, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaGestureMode, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (mediaGestureMode == MediaGestureMode.INTI) {
                if (Math.abs(f3) - Math.abs(f4) > 3.0f) {
                    MediaGestureMode mediaGestureMode2 = MediaGestureMode.FAST_FORWARD;
                    boolean z = f12225j;
                    return mediaGestureMode2;
                } else if (f2 <= this.f12230i / 2) {
                    MediaGestureMode mediaGestureMode3 = MediaGestureMode.BRIGHTNESS;
                    boolean z2 = f12225j;
                    return mediaGestureMode3;
                } else {
                    MediaGestureMode mediaGestureMode4 = MediaGestureMode.VOLUME;
                    boolean z3 = f12225j;
                    return mediaGestureMode4;
                }
            }
            return mediaGestureMode;
        }
        return (MediaGestureMode) invokeCommon.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f12230i = i2;
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f12228g = bVar;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (f12225j) {
                String str = "onDoubleTap:" + motionEvent;
            }
            b bVar = this.f12228g;
            if (bVar != null) {
                return bVar.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (f12225j) {
                String str = "onDown:" + motionEvent;
            }
            this.f12229h = MediaGestureMode.INTI;
            b bVar = this.f12228g;
            if (bVar != null) {
                return bVar.onDown(motionEvent);
            }
            return super.onDown(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f12225j) {
                String str = "onScroll:" + motionEvent + " e2:" + motionEvent2 + " distanceX:" + f2 + " distanceY:" + f3;
            }
            if (this.f12228g == null) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            MediaGestureMode b2 = b(this.f12229h, motionEvent.getX(), f2, f3);
            this.f12229h = b2;
            int i2 = C0834a.a[b2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return this.f12228g.onFastForward(motionEvent, motionEvent2, f2, f3);
                }
                return this.f12228g.onBrightnessChange(motionEvent, motionEvent2, f2, f3);
            }
            return this.f12228g.onVolumeChange(motionEvent, motionEvent2, f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (f12225j) {
                String str = "onSingleTapUp:" + motionEvent;
            }
            b bVar = this.f12228g;
            if (bVar != null) {
                return bVar.onSingleTap(motionEvent);
            }
            return super.onSingleTapUp(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
