package com.baidu.sdk.container.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.a.f.d;
import c.a.h0.a.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class GifAnimView extends View implements c.a.h0.a.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.h0.a.f.b f44818e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f44819f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44820g;
    public e gifViewListener;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44821h;

    /* renamed from: i  reason: collision with root package name */
    public int f44822i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f44823j;
    public c k;
    public GifImageType l;
    public boolean m;
    public d n;
    public int o;
    @SuppressLint({"HandlerLeak"})
    public Handler p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class GifImageType {
        public static final /* synthetic */ GifImageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GifImageType COVER;
        public static final GifImageType SYNC_DECODER;
        public static final GifImageType WAIT_FINISH;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeInt;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-615644380, "Lcom/baidu/sdk/container/gif/GifAnimView$GifImageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-615644380, "Lcom/baidu/sdk/container/gif/GifAnimView$GifImageType;");
                    return;
                }
            }
            WAIT_FINISH = new GifImageType("WAIT_FINISH", 0, 0);
            SYNC_DECODER = new GifImageType("SYNC_DECODER", 1, 1);
            GifImageType gifImageType = new GifImageType("COVER", 2, 2);
            COVER = gifImageType;
            $VALUES = new GifImageType[]{WAIT_FINISH, SYNC_DECODER, gifImageType};
        }

        public GifImageType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeInt = i3;
        }

        public static GifImageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GifImageType) Enum.valueOf(GifImageType.class, str) : (GifImageType) invokeL.objValue;
        }

        public static GifImageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GifImageType[]) $VALUES.clone() : (GifImageType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifAnimView f44824a;

        public a(GifAnimView gifAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44824a = gifAnimView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f44824a.invalidate();
                if (this.f44824a.n != null) {
                    this.f44824a.n.callback();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44825a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1548996511, "Lcom/baidu/sdk/container/gif/GifAnimView$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1548996511, "Lcom/baidu/sdk/container/gif/GifAnimView$b;");
                    return;
                }
            }
            int[] iArr = new int[GifImageType.values().length];
            f44825a = iArr;
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44825a[GifImageType.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44825a[GifImageType.SYNC_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GifAnimView f44826e;

        public c(GifAnimView gifAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44826e = gifAnimView;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44826e.f44818e == null) {
                return;
            }
            while (this.f44826e.f44820g) {
                if (!this.f44826e.f44821h) {
                    c.a.h0.a.f.c i2 = this.f44826e.f44818e.i();
                    this.f44826e.f44819f = i2.f3321a;
                    long j2 = i2.f3322b;
                    if (this.f44826e.p == null) {
                        return;
                    }
                    this.f44826e.p.sendMessage(this.f44826e.p.obtainMessage());
                    SystemClock.sleep(j2);
                } else {
                    SystemClock.sleep(500L);
                }
            }
        }

        public /* synthetic */ c(GifAnimView gifAnimView, a aVar) {
            this(gifAnimView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifAnimView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44818e = null;
        this.f44819f = null;
        this.f44820g = true;
        this.f44821h = false;
        this.f44822i = -1;
        this.f44823j = null;
        this.k = null;
        this.l = GifImageType.SYNC_DECODER;
        this.m = true;
        this.o = 255;
        this.p = new a(this);
    }

    private void setGifDecoderImage(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bArr) == null) {
            c.a.h0.a.f.b bVar = this.f44818e;
            if (bVar != null) {
                bVar.c();
                this.f44818e = null;
            }
            c.a.h0.a.f.b bVar2 = new c.a.h0.a.f.b(bArr, this);
            this.f44818e = bVar2;
            bVar2.start();
        }
    }

    public final void g() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.p) == null) {
            return;
        }
        this.p.sendMessage(handler.obtainMessage());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            stopAnimation();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            c.a.h0.a.f.b bVar = this.f44818e;
            if (bVar == null) {
                return;
            }
            if (this.f44819f == null) {
                this.f44819f = bVar.g();
            }
            if (this.f44819f == null) {
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            Paint paint = new Paint();
            paint.setAlpha(this.o);
            if (this.f44822i == -1) {
                canvas.drawBitmap(this.f44819f, 0.0f, 0.0f, paint);
            } else {
                canvas.drawBitmap(this.f44819f, (Rect) null, this.f44823j, paint);
            }
            canvas.restoreToCount(saveCount);
            e eVar = this.gifViewListener;
            if (eVar == null || !this.m) {
                return;
            }
            eVar.onAdPresent();
            this.m = false;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            c.a.h0.a.f.b bVar = this.f44818e;
            int i5 = 1;
            if (bVar == null) {
                i4 = 1;
            } else {
                i5 = bVar.f3317g;
                i4 = bVar.f3318h;
            }
            setMeasuredDimension(View.resolveSize(Math.max(i5 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(i4 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i3));
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            this.f44821h = i2 != 0;
        }
    }

    @Override // c.a.h0.a.f.a
    public void parseOk(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f44818e != null) {
            int i3 = b.f44825a[this.l.ordinal()];
            if (i3 == 1) {
                if (i2 == -1) {
                    if (this.f44818e.e() > 1) {
                        new c(this, null).start();
                    } else {
                        g();
                    }
                }
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                if (i2 == 1) {
                    this.f44819f = this.f44818e.g();
                    g();
                } else if (i2 == -1) {
                    g();
                } else if (this.k == null) {
                    c cVar = new c(this, null);
                    this.k = cVar;
                    cVar.start();
                }
            } else if (i2 == 1) {
                this.f44819f = this.f44818e.g();
                g();
            } else if (i2 == -1) {
                if (this.f44818e.e() > 1) {
                    if (this.k == null) {
                        c cVar2 = new c(this, null);
                        this.k = cVar2;
                        cVar2.start();
                        return;
                    }
                    return;
                }
                g();
            }
        }
    }

    public void pauseAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f44821h = true;
        }
    }

    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.o = i2;
            invalidate();
        }
    }

    public void setGifImage(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bArr) == null) {
            setGifDecoderImage(bArr);
        }
    }

    public void setGifImageType(GifImageType gifImageType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, gifImageType) == null) && this.f44818e == null) {
            this.l = gifImageType;
        }
    }

    public void setShowDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f44822i = i2;
        Rect rect = new Rect();
        this.f44823j = rect;
        rect.left = 0;
        rect.top = 0;
        rect.right = i2;
        rect.bottom = i3;
    }

    public void showAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f44821h) {
            this.f44821h = false;
        }
    }

    public void showCover() {
        c.a.h0.a.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.f44818e) == null) {
            return;
        }
        this.f44821h = true;
        this.f44819f = bVar.g();
        invalidate();
    }

    public void startAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f44821h = false;
        }
    }

    public void stopAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f44821h = true;
            this.f44820g = false;
            c.a.h0.a.f.b bVar = this.f44818e;
            if (bVar != null) {
                bVar.c();
                this.f44818e = null;
            }
            if (this.gifViewListener != null) {
                this.gifViewListener = null;
            }
        }
    }

    public void setGifImage(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, inputStream) == null) {
            setGifDecoderImage(inputStream);
        }
    }

    public void setGifImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            setGifDecoderImage(getResources().openRawResource(i2));
        }
    }

    private void setGifDecoderImage(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, inputStream) == null) {
            c.a.h0.a.f.b bVar = this.f44818e;
            if (bVar != null) {
                bVar.c();
                this.f44818e = null;
            }
            c.a.h0.a.f.b bVar2 = new c.a.h0.a.f.b(inputStream, this);
            this.f44818e = bVar2;
            bVar2.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifAnimView(Context context, d dVar) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = dVar;
    }
}
