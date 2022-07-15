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
import com.repackage.bd1;
import com.repackage.cd1;
import com.repackage.dd1;
import com.repackage.ed1;
import com.repackage.fd1;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class GifAnimView extends View implements bd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cd1 a;
    public Bitmap b;
    public boolean c;
    public boolean d;
    public int e;
    public Rect f;
    public c g;
    public GifImageType h;
    public boolean i;
    public fd1 j;
    public ed1 k;
    public int l;
    @SuppressLint({"HandlerLeak"})
    public Handler m;

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

        public GifImageType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeInt = i2;
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
        public final /* synthetic */ GifAnimView a;

        public a(GifAnimView gifAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gifAnimView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.a.invalidate();
                if (this.a.k != null) {
                    this.a.k.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GifImageType.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GifImageType.SYNC_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifAnimView a;

        public c(GifAnimView gifAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gifAnimView;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            while (this.a.c) {
                if (!this.a.d) {
                    dd1 i = this.a.a.i();
                    this.a.b = i.a;
                    long j = i.b;
                    if (this.a.m == null) {
                        return;
                    }
                    this.a.m.sendMessage(this.a.m.obtainMessage());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = true;
        this.d = false;
        this.e = -1;
        this.f = null;
        this.g = null;
        this.h = GifImageType.SYNC_DECODER;
        this.i = true;
        this.l = 255;
        this.m = new a(this);
    }

    private void setGifDecoderImage(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bArr) == null) {
            cd1 cd1Var = this.a;
            if (cd1Var != null) {
                cd1Var.c();
                this.a = null;
            }
            cd1 cd1Var2 = new cd1(bArr, this);
            this.a = cd1Var2;
            cd1Var2.start();
        }
    }

    @Override // com.repackage.bd1
    public void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z && this.a != null) {
            int i2 = b.a[this.h.ordinal()];
            if (i2 == 1) {
                if (i == -1) {
                    if (this.a.e() > 1) {
                        new c(this, null).start();
                    } else {
                        h();
                    }
                }
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                if (i == 1) {
                    this.b = this.a.g();
                    h();
                } else if (i == -1) {
                    h();
                } else if (this.g == null) {
                    c cVar = new c(this, null);
                    this.g = cVar;
                    cVar.start();
                }
            } else if (i == 1) {
                this.b = this.a.g();
                h();
            } else if (i == -1) {
                if (this.a.e() > 1) {
                    if (this.g == null) {
                        c cVar2 = new c(this, null);
                        this.g = cVar2;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.m) == null) {
            return;
        }
        this.m.sendMessage(handler.obtainMessage());
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = false;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = true;
            this.c = false;
            cd1 cd1Var = this.a;
            if (cd1Var != null) {
                cd1Var.c();
                this.a = null;
            }
            if (this.j != null) {
                this.j = null;
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
            cd1 cd1Var = this.a;
            if (cd1Var == null) {
                return;
            }
            if (this.b == null) {
                this.b = cd1Var.g();
            }
            if (this.b == null) {
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            Paint paint = new Paint();
            paint.setAlpha(this.l);
            if (this.e == -1) {
                canvas.drawBitmap(this.b, 0.0f, 0.0f, paint);
            } else {
                canvas.drawBitmap(this.b, (Rect) null, this.f, paint);
            }
            canvas.restoreToCount(saveCount);
            fd1 fd1Var = this.j;
            if (fd1Var == null || !this.i) {
                return;
            }
            fd1Var.a();
            this.i = false;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            cd1 cd1Var = this.a;
            int i4 = 1;
            if (cd1Var == null) {
                i3 = 1;
            } else {
                i4 = cd1Var.c;
                i3 = cd1Var.d;
            }
            setMeasuredDimension(View.resolveSize(Math.max(i4 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i2));
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            this.d = i != 0;
        }
    }

    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
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
        if ((interceptable == null || interceptable.invokeL(1048588, this, gifImageType) == null) && this.a == null) {
            this.h = gifImageType;
        }
    }

    public void setShowDimension(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
        this.e = i;
        Rect rect = new Rect();
        this.f = rect;
        rect.left = 0;
        rect.top = 0;
        rect.right = i;
        rect.bottom = i2;
    }

    public void setGifImage(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, inputStream) == null) {
            setGifDecoderImage(inputStream);
        }
    }

    public void setGifImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            setGifDecoderImage(getResources().openRawResource(i));
        }
    }

    private void setGifDecoderImage(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, inputStream) == null) {
            cd1 cd1Var = this.a;
            if (cd1Var != null) {
                cd1Var.c();
                this.a = null;
            }
            cd1 cd1Var2 = new cd1(inputStream, this);
            this.a = cd1Var2;
            cd1Var2.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifAnimView(Context context, ed1 ed1Var) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ed1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = ed1Var;
    }
}
