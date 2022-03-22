package c.a.n0.y.f.b.c;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9559f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final GestureDetector f9560b;

    /* renamed from: c  reason: collision with root package name */
    public b f9561c;

    /* renamed from: d  reason: collision with root package name */
    public MediaGestureMode f9562d;

    /* renamed from: e  reason: collision with root package name */
    public int f9563e;

    /* renamed from: c.a.n0.y.f.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0775a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-893733444, "Lc/a/n0/y/f/b/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-893733444, "Lc/a/n0/y/f/b/c/a$a;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830354009, "Lc/a/n0/y/f/b/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(830354009, "Lc/a/n0/y/f/b/c/a;");
                return;
            }
        }
        f9559f = c.a.n0.a.a.a;
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9562d = MediaGestureMode.INTI;
        this.a = context;
        this.f9560b = new GestureDetector(context, this);
    }

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1 && (bVar = this.f9561c) != null) {
                bVar.b(motionEvent, this.f9562d);
            }
            return this.f9560b.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final MediaGestureMode b(MediaGestureMode mediaGestureMode, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaGestureMode, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (mediaGestureMode == MediaGestureMode.INTI) {
                if (Math.abs(f3) - Math.abs(f4) > 3.0f) {
                    mediaGestureMode = MediaGestureMode.FAST_FORWARD;
                    if (f9559f) {
                        Log.d("MediaGestureDetector", "horizontal slide");
                    }
                } else if (f2 <= this.f9563e / 2) {
                    mediaGestureMode = MediaGestureMode.BRIGHTNESS;
                    if (f9559f) {
                        Log.d("MediaGestureDetector", "brightness slide");
                    }
                } else {
                    mediaGestureMode = MediaGestureMode.VOLUME;
                    if (f9559f) {
                        Log.d("MediaGestureDetector", "volume slide");
                    }
                }
            }
            return mediaGestureMode;
        }
        return (MediaGestureMode) invokeCommon.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f9563e = i;
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f9561c = bVar;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (f9559f) {
                Log.d("MediaGestureDetector", "onDoubleTap:" + motionEvent);
            }
            b bVar = this.f9561c;
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
            if (f9559f) {
                Log.d("MediaGestureDetector", "onDown:" + motionEvent);
            }
            this.f9562d = MediaGestureMode.INTI;
            b bVar = this.f9561c;
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
            if (f9559f) {
                Log.d("MediaGestureDetector", "onScroll:" + motionEvent + " e2:" + motionEvent2 + " distanceX:" + f2 + " distanceY:" + f3);
            }
            if (this.f9561c == null) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            MediaGestureMode b2 = b(this.f9562d, motionEvent.getX(), f2, f3);
            this.f9562d = b2;
            int i = C0775a.a[b2.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return this.f9561c.d(motionEvent, motionEvent2, f2, f3);
                }
                return this.f9561c.e(motionEvent, motionEvent2, f2, f3);
            }
            return this.f9561c.c(motionEvent, motionEvent2, f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (f9559f) {
                Log.d("MediaGestureDetector", "onSingleTapUp:" + motionEvent);
            }
            b bVar = this.f9561c;
            if (bVar != null) {
                return bVar.a(motionEvent);
            }
            return super.onSingleTapUp(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
