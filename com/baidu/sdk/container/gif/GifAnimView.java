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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.h0.a.f.d;
import d.a.h0.a.f.e;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class GifAnimView extends View implements d.a.h0.a.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.f.b f10123e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f10124f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10125g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10126h;

    /* renamed from: i  reason: collision with root package name */
    public int f10127i;
    public Rect j;
    public c k;
    public GifImageType l;
    public boolean m;
    public e n;
    public d o;
    public int p;
    @SuppressLint({"HandlerLeak"})
    public Handler q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifAnimView f10128a;

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
            this.f10128a = gifAnimView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f10128a.invalidate();
                if (this.f10128a.o != null) {
                    this.f10128a.o.callback();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10129a;
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
            f10129a = iArr;
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10129a[GifImageType.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10129a[GifImageType.SYNC_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GifAnimView f10130e;

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
            this.f10130e = gifAnimView;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10130e.f10123e == null) {
                return;
            }
            while (this.f10130e.f10125g) {
                if (!this.f10130e.f10126h) {
                    d.a.h0.a.f.c i2 = this.f10130e.f10123e.i();
                    this.f10130e.f10124f = i2.f42486a;
                    long j = i2.f42487b;
                    if (this.f10130e.q == null) {
                        return;
                    }
                    this.f10130e.q.sendMessage(this.f10130e.q.obtainMessage());
                    SystemClock.sleep(j);
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
        this.f10123e = null;
        this.f10124f = null;
        this.f10125g = true;
        this.f10126h = false;
        this.f10127i = -1;
        this.j = null;
        this.k = null;
        this.l = GifImageType.SYNC_DECODER;
        this.m = true;
        this.p = 255;
        this.q = new a(this);
    }

    private void setGifDecoderImage(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bArr) == null) {
            d.a.h0.a.f.b bVar = this.f10123e;
            if (bVar != null) {
                bVar.c();
                this.f10123e = null;
            }
            d.a.h0.a.f.b bVar2 = new d.a.h0.a.f.b(bArr, this);
            this.f10123e = bVar2;
            bVar2.start();
        }
    }

    @Override // d.a.h0.a.f.a
    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f10123e != null) {
            int i3 = b.f10129a[this.l.ordinal()];
            if (i3 == 1) {
                if (i2 == -1) {
                    if (this.f10123e.e() > 1) {
                        new c(this, null).start();
                    } else {
                        h();
                    }
                }
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                if (i2 == 1) {
                    this.f10124f = this.f10123e.g();
                    h();
                } else if (i2 == -1) {
                    h();
                } else if (this.k == null) {
                    c cVar = new c(this, null);
                    this.k = cVar;
                    cVar.start();
                }
            } else if (i2 == 1) {
                this.f10124f = this.f10123e.g();
                h();
            } else if (i2 == -1) {
                if (this.f10123e.e() > 1) {
                    if (this.k == null) {
                        c cVar2 = new c(this, null);
                        this.k = cVar2;
                        cVar2.start();
                        return;
                    }
                    return;
                }
                h();
            }
        }
    }

    public final void h() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.q) == null) {
            return;
        }
        this.q.sendMessage(handler.obtainMessage());
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10126h = false;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f10126h = true;
            this.f10125g = false;
            d.a.h0.a.f.b bVar = this.f10123e;
            if (bVar != null) {
                bVar.c();
                this.f10123e = null;
            }
            if (this.n != null) {
                this.n = null;
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            d.a.h0.a.f.b bVar = this.f10123e;
            if (bVar == null) {
                return;
            }
            if (this.f10124f == null) {
                this.f10124f = bVar.g();
            }
            if (this.f10124f == null) {
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            Paint paint = new Paint();
            paint.setAlpha(this.p);
            if (this.f10127i == -1) {
                canvas.drawBitmap(this.f10124f, 0.0f, 0.0f, paint);
            } else {
                canvas.drawBitmap(this.f10124f, (Rect) null, this.j, paint);
            }
            canvas.restoreToCount(saveCount);
            e eVar = this.n;
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
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            d.a.h0.a.f.b bVar = this.f10123e;
            int i5 = 1;
            if (bVar == null) {
                i4 = 1;
            } else {
                i5 = bVar.f42483g;
                i4 = bVar.f42484h;
            }
            setMeasuredDimension(View.resolveSize(Math.max(i5 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(i4 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i3));
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            this.f10126h = i2 != 0;
        }
    }

    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
            invalidate();
        }
    }

    public void setGifImage(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            setGifDecoderImage(bArr);
        }
    }

    public void setGifImageType(GifImageType gifImageType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, gifImageType) == null) && this.f10123e == null) {
            this.l = gifImageType;
        }
    }

    public void setShowDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f10127i = i2;
        Rect rect = new Rect();
        this.j = rect;
        rect.left = 0;
        rect.top = 0;
        rect.right = i2;
        rect.bottom = i3;
    }

    public void setGifImage(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, inputStream) == null) {
            setGifDecoderImage(inputStream);
        }
    }

    public void setGifImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            setGifDecoderImage(getResources().openRawResource(i2));
        }
    }

    private void setGifDecoderImage(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, inputStream) == null) {
            d.a.h0.a.f.b bVar = this.f10123e;
            if (bVar != null) {
                bVar.c();
                this.f10123e = null;
            }
            d.a.h0.a.f.b bVar2 = new d.a.h0.a.f.b(inputStream, this);
            this.f10123e = bVar2;
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
        this.o = dVar;
    }
}
