package com.baidu.swan.apps.media.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.ao2;
import com.repackage.bo2;
import com.repackage.cg1;
import com.repackage.co2;
import com.repackage.sw1;
import com.repackage.un2;
import com.repackage.vn2;
import com.repackage.wn2;
import com.repackage.xn2;
import com.repackage.yn2;
import com.repackage.zn2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes2.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Integer> A0;
    public static final List<Integer> B0;
    public static final List<Integer> C0;
    public static final List<Integer> D0;
    public static final List<Integer> E0;
    public static int F0;
    public static final boolean z0;
    public transient /* synthetic */ FieldHolder $fh;
    public Float A;
    public PointF B;
    public PointF C;
    public int D;
    public int E;
    public int F;
    public Rect G;
    public Rect H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public GestureDetector M;
    public ao2 N;
    public final Object O;
    public yn2<? extends zn2> P;
    public yn2<? extends ao2> Q;
    public PointF R;
    public float S;
    public final float T;
    public PointF U;
    public float V;
    public PointF W;
    public Bitmap a;
    public boolean b;
    public boolean c;
    public Uri d;
    public int e;
    public Map<Integer, List<i>> f;
    public boolean g;
    public boolean g0;
    public int h;
    public c h0;
    public float i;
    public boolean i0;
    public float j;
    public boolean j0;
    public int k;
    public g k0;
    public int l;
    public View.OnLongClickListener l0;
    public int m;
    public Handler m0;
    public int n;
    public Paint n0;
    public int o;
    public Paint o0;
    public boolean p;
    public Paint p0;
    public boolean q;
    public h q0;
    public boolean r;
    public Matrix r0;
    public boolean s;
    public RectF s0;
    public float t;
    public float[] t0;
    public int u;
    public float[] u0;
    public int v;
    public float v0;
    public float w;
    public boolean w0;
    public float x;
    public ColorFilter x0;
    public PointF y;
    public int y0;
    public PointF z;

    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HugePhotoDraweeView a;

        public a(HugePhotoDraweeView hugePhotoDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hugePhotoDraweeView;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.a.l0 != null) {
                    this.a.L = 0;
                    HugePhotoDraweeView hugePhotoDraweeView = this.a;
                    HugePhotoDraweeView.super.setOnLongClickListener(hugePhotoDraweeView.l0);
                    this.a.performLongClick();
                    HugePhotoDraweeView.super.setOnLongClickListener(null);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HugePhotoDraweeView b;

        public b(HugePhotoDraweeView hugePhotoDraweeView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hugePhotoDraweeView;
            this.a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.b.r && this.b.i0 && this.b.y != null) {
                    this.b.setGestureDetector(this.a);
                    if (this.b.s) {
                        this.b.R = new PointF(motionEvent.getX(), motionEvent.getY());
                        this.b.z = new PointF(this.b.y.x, this.b.y.y);
                        HugePhotoDraweeView hugePhotoDraweeView = this.b;
                        hugePhotoDraweeView.x = hugePhotoDraweeView.w;
                        this.b.K = true;
                        this.b.I = true;
                        HugePhotoDraweeView hugePhotoDraweeView2 = this.b;
                        hugePhotoDraweeView2.U = hugePhotoDraweeView2.J0(hugePhotoDraweeView2.R);
                        this.b.V = -1.0f;
                        this.b.W = new PointF(this.b.U.x, this.b.U.y);
                        this.b.g0 = false;
                        return false;
                    }
                    HugePhotoDraweeView hugePhotoDraweeView3 = this.b;
                    hugePhotoDraweeView3.T(hugePhotoDraweeView3.J0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.b.q && this.b.i0 && this.b.y != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f) > 500.0f || Math.abs(f2) > 500.0f) && !this.b.I))) {
                    PointF pointF = new PointF(this.b.y.x + (f * 0.25f), this.b.y.y + (f2 * 0.25f));
                    d dVar = new d(this.b, new PointF(((this.b.getWidth() / 2) - pointF.x) / this.b.w, ((this.b.getHeight() / 2) - pointF.y) / this.b.w), (a) null);
                    dVar.d(1);
                    dVar.f(false);
                    dVar.b();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.b.performClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float a;
        public final PointF b;
        public final PointF c;
        public long d;
        public int e;
        public boolean f;
        public boolean g;
        public f h;
        public final /* synthetic */ HugePhotoDraweeView i;

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, PointF pointF2, a aVar) {
            this(hugePhotoDraweeView, f, pointF, pointF2);
        }

        public void b() {
            PointF pointF;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.i.h0 != null && this.i.h0.l != null) {
                    try {
                        this.i.h0.l.b();
                    } catch (Exception e) {
                        Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e);
                    }
                }
                int paddingLeft = this.i.getPaddingLeft() + (((this.i.getWidth() - this.i.getPaddingRight()) - this.i.getPaddingLeft()) / 2);
                int paddingTop = this.i.getPaddingTop() + (((this.i.getHeight() - this.i.getPaddingBottom()) - this.i.getPaddingTop()) / 2);
                float j0 = this.i.j0(this.a);
                if (this.g) {
                    HugePhotoDraweeView hugePhotoDraweeView = this.i;
                    PointF pointF2 = this.b;
                    float f = pointF2.x;
                    float f2 = pointF2.y;
                    pointF = new PointF();
                    hugePhotoDraweeView.i0(f, f2, j0, pointF);
                } else {
                    pointF = this.b;
                }
                this.i.h0 = new c(null);
                this.i.h0.a = this.i.w;
                this.i.h0.b = j0;
                this.i.h0.k = System.currentTimeMillis();
                this.i.h0.e = pointF;
                this.i.h0.c = this.i.getCenter();
                this.i.h0.d = pointF;
                this.i.h0.f = this.i.B0(pointF);
                this.i.h0.g = new PointF(paddingLeft, paddingTop);
                this.i.h0.h = this.d;
                this.i.h0.i = this.f;
                this.i.h0.j = this.e;
                this.i.h0.k = System.currentTimeMillis();
                this.i.h0.l = this.h;
                PointF pointF3 = this.c;
                if (pointF3 != null) {
                    float f3 = pointF3.x - (this.i.h0.c.x * j0);
                    float f4 = this.c.y - (this.i.h0.c.y * j0);
                    h hVar = new h(j0, new PointF(f3, f4), null);
                    this.i.b0(true, hVar);
                    this.i.h0.g = new PointF(this.c.x + (hVar.b.x - f3), this.c.y + (hVar.b.y - f4));
                }
                this.i.invalidate();
            }
        }

        public d c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.d = j;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public d d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (!HugePhotoDraweeView.C0.contains(Integer.valueOf(i))) {
                    String str = "Unknown easing type: " + i;
                    if (!HugePhotoDraweeView.z0) {
                        sw1.k("HugePhotoDraweeView", str);
                        return this;
                    }
                    throw new IllegalArgumentException(str);
                }
                this.e = i;
                return this;
            }
            return (d) invokeI.objValue;
        }

        public d e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public final d f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.g = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, a aVar) {
            this(hugePhotoDraweeView, f, pointF);
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, PointF pointF, a aVar) {
            this(hugePhotoDraweeView, pointF);
        }

        public d(HugePhotoDraweeView hugePhotoDraweeView, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, pointF};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.i = hugePhotoDraweeView;
            this.d = 500L;
            this.e = 2;
            this.f = true;
            this.g = true;
            this.a = hugePhotoDraweeView.w;
            this.b = pointF;
            this.c = null;
        }

        public d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, Float.valueOf(f), pointF};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = hugePhotoDraweeView;
            this.d = 500L;
            this.e = 2;
            this.f = true;
            this.g = true;
            this.a = f;
            this.b = pointF;
            this.c = null;
        }

        public d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, Float.valueOf(f), pointF, pointF2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.i = hugePhotoDraweeView;
            this.d = 500L;
            this.e = 2;
            this.f = true;
            this.g = true;
            this.a = f;
            this.b = pointF;
            this.c = pointF2;
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends AsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<Context> b;
        public final WeakReference<yn2<? extends zn2>> c;
        public final Uri d;
        public final boolean e;
        public Bitmap f;
        public Exception g;

        public e(HugePhotoDraweeView hugePhotoDraweeView, Context context, yn2<? extends zn2> yn2Var, Uri uri, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context, yn2Var, uri, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(yn2Var);
            this.d = uri;
            this.e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    String uri = this.d.toString();
                    Context context = this.b.get();
                    yn2<? extends zn2> yn2Var = this.c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    if (context == null || yn2Var == null || hugePhotoDraweeView == null) {
                        return null;
                    }
                    this.f = yn2Var.make().decode(context, this.d);
                    return Integer.valueOf(hugePhotoDraweeView.c0(uri));
                } catch (Exception e) {
                    Log.e("HugePhotoDraweeView", "Failed to load bitmap", e);
                    this.g = e;
                    return null;
                } catch (OutOfMemoryError e2) {
                    Log.e("HugePhotoDraweeView", "Failed to load bitmap - OutOfMemoryError", e2);
                    this.g = new RuntimeException(e2);
                    return null;
                }
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            HugePhotoDraweeView hugePhotoDraweeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) || (hugePhotoDraweeView = this.a.get()) == null) {
                return;
            }
            Bitmap bitmap = this.f;
            if (bitmap != null && num != null) {
                if (this.e) {
                    hugePhotoDraweeView.n0(bitmap);
                } else {
                    hugePhotoDraweeView.m0(bitmap, num.intValue(), false);
                }
            } else if (this.g == null || hugePhotoDraweeView.k0 == null) {
            } else {
                if (this.e) {
                    hugePhotoDraweeView.k0.onPreviewLoadError(this.g);
                } else {
                    hugePhotoDraweeView.k0.onImageLoadError(this.g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b();

        void onComplete();
    }

    /* loaded from: classes2.dex */
    public interface g {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: classes2.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public PointF b;

        public /* synthetic */ h(float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        public h(float f, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), pointF};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
            this.b = pointF;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public Rect f;
        public Rect g;

        public i() {
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

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class j extends AsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<ao2> b;
        public final WeakReference<i> c;
        public Exception d;

        public j(HugePhotoDraweeView hugePhotoDraweeView, ao2 ao2Var, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, ao2Var, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.b = new WeakReference<>(ao2Var);
            this.c = new WeakReference<>(iVar);
            iVar.d = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    ao2 ao2Var = this.b.get();
                    i iVar = this.c.get();
                    if (ao2Var == null || iVar == null || hugePhotoDraweeView == null || !ao2Var.isReady() || !iVar.e) {
                        if (iVar != null) {
                            iVar.d = false;
                            return null;
                        }
                        return null;
                    }
                    synchronized (hugePhotoDraweeView.O) {
                        hugePhotoDraweeView.Z(iVar.a, iVar.g);
                        if (hugePhotoDraweeView.G != null) {
                            iVar.g.offset(hugePhotoDraweeView.G.left, hugePhotoDraweeView.G.top);
                        }
                        decodeRegion = ao2Var.decodeRegion(iVar.g, iVar.b);
                    }
                    return decodeRegion;
                } catch (Exception e) {
                    Log.e("HugePhotoDraweeView", "Failed to decode tile", e);
                    this.d = e;
                    return null;
                } catch (OutOfMemoryError e2) {
                    Log.e("HugePhotoDraweeView", "Failed to decode tile - OutOfMemoryError", e2);
                    this.d = new RuntimeException(e2);
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                i iVar = this.c.get();
                if (hugePhotoDraweeView == null || iVar == null) {
                    return;
                }
                if (bitmap != null) {
                    iVar.c = bitmap;
                    iVar.d = false;
                    hugePhotoDraweeView.p0();
                } else if (this.d == null || hugePhotoDraweeView.k0 == null) {
                } else {
                    hugePhotoDraweeView.k0.onTileLoadError(this.d);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class k extends AsyncTask<Void, Void, int[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<Context> b;
        public final WeakReference<yn2<? extends ao2>> c;
        public vn2 d;
        public ao2 e;
        public Exception f;

        public k(HugePhotoDraweeView hugePhotoDraweeView, Context context, yn2<? extends ao2> yn2Var, vn2 vn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context, yn2Var, vn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(yn2Var);
            this.d = vn2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public int[] doInBackground(Void... voidArr) {
            Point init;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    if (this.d.i() != null) {
                        this.d.i().toString();
                    }
                    Context context = this.b.get();
                    yn2<? extends ao2> yn2Var = this.c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    if (context == null || yn2Var == null || hugePhotoDraweeView == null) {
                        return null;
                    }
                    this.e = yn2Var.make();
                    if (this.d.c() != null) {
                        init = this.e.a(context, this.d.c());
                    } else {
                        init = this.e.init(context, this.d.i());
                    }
                    int i = init.x;
                    int i2 = init.y;
                    int c0 = hugePhotoDraweeView.c0("");
                    if (hugePhotoDraweeView.G != null) {
                        i = hugePhotoDraweeView.G.width();
                        i2 = hugePhotoDraweeView.G.height();
                    }
                    return new int[]{i, i2, c0};
                } catch (Exception e) {
                    Log.e("HugePhotoDraweeView", "Failed to initialise bitmap decoder", e);
                    this.f = e;
                    return null;
                }
            }
            return (int[]) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(int[] iArr) {
            HugePhotoDraweeView hugePhotoDraweeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) || (hugePhotoDraweeView = this.a.get()) == null) {
                return;
            }
            ao2 ao2Var = this.e;
            if (ao2Var != null && iArr != null && iArr.length == 3) {
                hugePhotoDraweeView.q0(ao2Var, iArr[0], iArr[1], iArr[2]);
            } else if (this.f == null || hugePhotoDraweeView.k0 == null) {
            } else {
                hugePhotoDraweeView.k0.onImageLoadError(this.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1814046761, "Lcom/baidu/swan/apps/media/image/HugePhotoDraweeView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1814046761, "Lcom/baidu/swan/apps/media/image/HugePhotoDraweeView;");
                return;
            }
        }
        z0 = cg1.a;
        A0 = Arrays.asList(0, 90, 180, 270, -1);
        B0 = Arrays.asList(1, 2, 3);
        C0 = Arrays.asList(2, 1);
        D0 = Arrays.asList(1, 2, 3);
        E0 = Arrays.asList(2, 1, 3);
        F0 = Integer.MAX_VALUE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        vn2 a2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = k0();
        this.j = 5.0f;
        this.k = -1;
        this.l = 1;
        this.m = 1;
        int i4 = F0;
        this.n = i4;
        this.o = i4;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = 5.0f;
        this.u = 1;
        this.v = 500;
        this.O = new Object();
        this.P = new xn2(bo2.class);
        this.Q = new xn2(co2.class);
        this.t0 = new float[8];
        this.u0 = new float[8];
        this.w0 = false;
        this.x0 = null;
        this.y0 = 0;
        this.v0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(720);
        setGestureDetector(context);
        this.m0 = new Handler(new a(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040096, R.attr.obfuscated_res_0x7f0404ac, R.attr.obfuscated_res_0x7f04051f, R.attr.obfuscated_res_0x7f0405c1, R.attr.obfuscated_res_0x7f040683, R.attr.obfuscated_res_0x7f040720});
            if (obtainStyledAttributes.hasValue(0) && (string = obtainStyledAttributes.getString(0)) != null && string.length() > 0 && (a2 = vn2.a(string)) != null) {
                a2.n();
                setImage(a2);
            }
            if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                vn2 k2 = vn2.k(resourceId);
                k2.n();
                setImage(k2);
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(1, true));
            }
            if (obtainStyledAttributes.hasValue(5)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(5, true));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(2, true));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(4, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.T = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int getRequiredRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            int i2 = this.h;
            return i2 == -1 ? this.F : i2;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, context) == null) {
            this.M = new GestureDetector(context, new b(this, context));
        }
    }

    public final PointF A0(float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            if (this.y == null) {
                return null;
            }
            pointF.set(D0(f2), E0(f3));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF B0(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pointF)) == null) ? A0(pointF.x, pointF.y, new PointF()) : (PointF) invokeL.objValue;
    }

    public final Rect C0(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rect, rect2)) == null) {
            rect2.set((int) D0(rect.left), (int) E0(rect.top), (int) D0(rect.right), (int) E0(rect.bottom));
            return rect2;
        }
        return (Rect) invokeLL.objValue;
    }

    public final float D0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            PointF pointF = this.y;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 * this.w) + pointF.x;
        }
        return invokeF.floatValue;
    }

    public final float E0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            PointF pointF = this.y;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 * this.w) + pointF.y;
        }
        return invokeF.floatValue;
    }

    public final boolean F0(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iVar)) == null) {
            return K0(0.0f) <= ((float) iVar.a.right) && ((float) iVar.a.left) <= K0((float) getWidth()) && L0(0.0f) <= ((float) iVar.a.bottom) && ((float) iVar.a.top) <= L0((float) getHeight());
        }
        return invokeL.booleanValue;
    }

    public final PointF G0(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
            int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            if (this.q0 == null) {
                this.q0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.q0.a = f4;
            this.q0.b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
            b0(true, this.q0);
            return this.q0.b;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF H0(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? I0(f2, f3, new PointF()) : (PointF) invokeCommon.objValue;
    }

    public final PointF I0(float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            if (this.y == null) {
                return null;
            }
            pointF.set(K0(f2), L0(f3));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF J0(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, pointF)) == null) ? I0(pointF.x, pointF.y, new PointF()) : (PointF) invokeL.objValue;
    }

    public final float K0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f2)) == null) {
            PointF pointF = this.y;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 - pointF.x) / this.w;
        }
        return invokeF.floatValue;
    }

    public final float L0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            PointF pointF = this.y;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 - pointF.y) / this.w;
        }
        return invokeF.floatValue;
    }

    public final int O(float f2) {
        InterceptResult invokeF;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeF = interceptable.invokeF(1048588, this, f2)) != null) {
            return invokeF.intValue;
        }
        if (this.k > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.k / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int y0 = (int) (y0() * f2);
        int x0 = (int) (x0() * f2);
        if (y0 == 0 || x0 == 0) {
            return 32;
        }
        int i2 = 1;
        if (x0() > x0 || y0() > y0) {
            round = Math.round(x0() / x0);
            int round2 = Math.round(y0() / y0);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while (true) {
            int i3 = i2 * 2;
            if (i3 >= round) {
                return i2;
            }
            i2 = i3;
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            boolean g0 = g0();
            if (!this.j0 && g0) {
                r0();
                this.j0 = true;
                l0();
                g gVar = this.k0;
                if (gVar != null) {
                    gVar.onImageLoaded();
                }
            }
            return g0;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            boolean z = getWidth() > 0 && getHeight() > 0 && this.D > 0 && this.E > 0 && (this.a != null || g0());
            if (!this.i0 && z) {
                r0();
                this.i0 = true;
                o0();
                g gVar = this.k0;
                if (gVar != null) {
                    gVar.onReady();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.n0 == null) {
                Paint paint = new Paint();
                this.n0 = paint;
                paint.setAntiAlias(true);
                this.n0.setFilterBitmap(true);
                this.n0.setDither(true);
            }
            if (this.o0 == null && this.g) {
                Paint paint2 = new Paint();
                this.o0 = paint2;
                paint2.setTextSize(18.0f);
                this.o0.setColor(-65281);
                this.o0.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public final float S(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f2 - f3;
            float f7 = f4 - f5;
            return (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }
        return invokeCommon.floatValue;
    }

    public final void T(PointF pointF, PointF pointF2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pointF, pointF2) == null) {
            if (!this.q) {
                PointF pointF3 = this.C;
                if (pointF3 != null) {
                    pointF.x = pointF3.x;
                    pointF.y = pointF3.y;
                } else {
                    pointF.x = y0() / 2;
                    pointF.y = x0() / 2;
                }
            }
            float min = Math.min(this.j, this.t);
            boolean z = ((double) this.w) <= ((double) min) * 0.9d;
            if (!z) {
                min = k0();
            }
            float f2 = min;
            int i2 = this.u;
            if (i2 == 3) {
                setScaleAndCenter(f2, pointF);
            } else if (i2 == 2 || !z || !this.q) {
                d dVar = new d(this, f2, pointF, (a) null);
                dVar.e(false);
                dVar.c(this.v);
                dVar.b();
            } else if (i2 == 1) {
                d dVar2 = new d(this, f2, pointF, pointF2, null);
                dVar2.e(false);
                dVar2.c(this.v);
                dVar2.b();
            }
            invalidate();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.n0 == null) {
            return;
        }
        if (this.y0 != wn2.d(getContext())) {
            this.y0 = wn2.d(getContext());
            this.x0 = new PorterDuffColorFilter(this.y0, PorterDuff.Mode.SRC_ATOP);
        }
        this.n0.setColorFilter(this.x0);
    }

    @SuppressLint({"BDThrowableCheck"})
    public final float V(int i2, long j2, float f2, float f3, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    String str = "Unexpected easing type: " + i2;
                    if (!z0) {
                        sw1.k("HugePhotoDraweeView", str);
                        return 0.0f;
                    }
                    throw new IllegalStateException(str);
                }
                return W(j2, f2, f3, j3);
            }
            return X(j2, f2, f3, j3);
        }
        return invokeCommon.floatValue;
    }

    public final float W(long j2, float f2, float f3, long j3) {
        InterceptResult invokeCommon;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            float f5 = ((float) j2) / (((float) j3) / 2.0f);
            if (f5 < 1.0f) {
                f4 = (f3 / 2.0f) * f5;
            } else {
                float f6 = f5 - 1.0f;
                f4 = (-f3) / 2.0f;
                f5 = (f6 * (f6 - 2.0f)) - 1.0f;
            }
            return (f4 * f5) + f2;
        }
        return invokeCommon.floatValue;
    }

    public final float X(long j2, float f2, float f3, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            float f4 = ((float) j2) / ((float) j3);
            return ((-f3) * f4 * (f4 - 2.0f)) + f2;
        }
        return invokeCommon.floatValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void Y(AsyncTask<Void, Void, ?> asyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, asyncTask) == null) {
            if (this.p && Build.VERSION.SDK_INT >= 11) {
                try {
                    AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                    return;
                } catch (Exception e2) {
                    Log.i("HugePhotoDraweeView", "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e2);
                }
            }
            asyncTask.execute(new Void[0]);
        }
    }

    public final void Z(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, rect, rect2) == null) {
            if (getRequiredRotation() == 0) {
                rect2.set(rect);
            } else if (getRequiredRotation() == 90) {
                int i2 = rect.top;
                int i3 = this.E;
                rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
            } else if (getRequiredRotation() == 180) {
                int i4 = this.D;
                int i5 = this.E;
                rect2.set(i4 - rect.right, i5 - rect.bottom, i4 - rect.left, i5 - rect.top);
            } else {
                int i6 = this.D;
                rect2.set(i6 - rect.bottom, rect.left, i6 - rect.top, rect.right);
            }
        }
    }

    public final void a0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (this.y == null) {
                z2 = true;
                this.y = new PointF(0.0f, 0.0f);
            } else {
                z2 = false;
            }
            if (this.q0 == null) {
                this.q0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.q0.a = this.w;
            this.q0.b.set(this.y);
            b0(z, this.q0);
            this.w = this.q0.a;
            this.y.set(this.q0.b);
            if (z2) {
                this.y.set(G0(y0() / 2, x0() / 2, this.w));
            }
        }
    }

    public final void b0(boolean z, h hVar) {
        float max;
        int max2;
        float max3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048601, this, z, hVar) == null) {
            if (this.l == 2 && h0()) {
                z = false;
            }
            PointF pointF = hVar.b;
            float j0 = j0(hVar.a);
            float y0 = y0() * j0;
            float x0 = x0() * j0;
            if (this.l == 3 && h0()) {
                pointF.x = Math.max(pointF.x, (getWidth() / 2) - y0);
                pointF.y = Math.max(pointF.y, (getHeight() / 2) - x0);
            } else if (z) {
                pointF.x = Math.max(pointF.x, getWidth() - y0);
                pointF.y = Math.max(pointF.y, getHeight() - x0);
            } else {
                pointF.x = Math.max(pointF.x, -y0);
                pointF.y = Math.max(pointF.y, -x0);
            }
            float f2 = 0.5f;
            float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
            if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
                f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
            }
            if (this.l == 3 && h0()) {
                max = Math.max(0, getWidth() / 2);
                max2 = Math.max(0, getHeight() / 2);
            } else if (z) {
                max = Math.max(0.0f, (getWidth() - y0) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - x0) * f2);
                pointF.x = Math.min(pointF.x, max);
                pointF.y = Math.min(pointF.y, max3);
                hVar.a = j0;
            } else {
                max = Math.max(0, getWidth());
                max2 = Math.max(0, getHeight());
            }
            max3 = max2;
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            hVar.a = j0;
        }
    }

    public final int c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            int i2 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.startsWith("content")) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = getContext().getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                        if (cursor != null) {
                            if (cursor.moveToFirst()) {
                                int i3 = cursor.getInt(0);
                                if (!A0.contains(Integer.valueOf(i3)) || i3 == -1) {
                                    Log.w("HugePhotoDraweeView", "Unsupported orientation: " + i3);
                                } else {
                                    i2 = i3;
                                }
                            }
                            un2.a(cursor);
                        }
                    } finally {
                        un2.a(cursor);
                    }
                } catch (Exception unused) {
                    Log.w("HugePhotoDraweeView", "Could not get orientation of image from media store");
                }
                return i2;
            } else if (!str.startsWith(ImageSource.FILE_SCHEME) || str.startsWith("file:///android_asset/")) {
                return 0;
            } else {
                try {
                    int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
                    if (attributeInt != 1 && attributeInt != 0) {
                        if (attributeInt == 6) {
                            return 90;
                        }
                        if (attributeInt == 3) {
                            return 180;
                        }
                        if (attributeInt == 8) {
                            return 270;
                        }
                        Log.w("HugePhotoDraweeView", "Unsupported EXIF orientation: " + attributeInt);
                        return 0;
                    }
                    return 0;
                } catch (Exception unused2) {
                    Log.w("HugePhotoDraweeView", "Could not get EXIF orientation of image");
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final Point d0(Canvas canvas) {
        InterceptResult invokeL;
        int i2;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, canvas)) == null) {
            int i3 = 2048;
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    i2 = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
                    try {
                        intValue = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                        i3 = i2;
                    } catch (Exception unused) {
                        i3 = i2;
                        intValue = 2048;
                        return new Point(Math.min(i3, this.n), Math.min(intValue, this.o));
                    }
                } catch (Exception unused2) {
                    i2 = 2048;
                }
                return new Point(Math.min(i3, this.n), Math.min(intValue, this.o));
            }
            intValue = 2048;
            return new Point(Math.min(i3, this.n), Math.min(intValue, this.o));
        }
        return (Point) invokeL.objValue;
    }

    public final synchronized void e0(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, point) == null) {
            synchronized (this) {
                h hVar = new h(0.0f, new PointF(0.0f, 0.0f), null);
                this.q0 = hVar;
                b0(true, hVar);
                int O = O(this.q0.a);
                this.e = O;
                if (O > 1) {
                    this.e = O / 2;
                }
                if (this.e == 1 && this.G == null && y0() < point.x && x0() < point.y && this.d != null) {
                    this.N.recycle();
                    this.N = null;
                    Y(new e(this, getContext(), this.P, this.d, false));
                } else {
                    f0(point);
                    for (i iVar : this.f.get(Integer.valueOf(this.e))) {
                        Y(new j(this, this.N, iVar));
                    }
                    s0(true);
                }
            }
        }
    }

    public final void f0(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048605, this, point) != null) {
            return;
        }
        this.f = new LinkedHashMap();
        int i2 = this.e;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int y0 = y0() / i4;
            int x0 = x0() / i5;
            int i6 = y0 / i2;
            int i7 = x0 / i2;
            while (true) {
                if (i6 + i4 + i3 > point.x || (i6 > getWidth() * 1.25d && i2 < this.e)) {
                    i4++;
                    y0 = y0() / i4;
                    i6 = y0 / i2;
                }
            }
            while (true) {
                if (i7 + i5 + i3 > point.y || (i7 > getHeight() * 1.25d && i2 < this.e)) {
                    i5++;
                    x0 = x0() / i5;
                    i7 = x0 / i2;
                }
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    i iVar = new i(null);
                    iVar.b = i2;
                    iVar.e = i2 == this.e;
                    iVar.a = new Rect(i8 * y0, i9 * x0, i8 == i4 + (-1) ? y0() : (i8 + 1) * y0, i9 == i5 + (-1) ? x0() : (i9 + 1) * x0);
                    iVar.f = new Rect(0, 0, 0, 0);
                    iVar.g = new Rect(iVar.a);
                    arrayList.add(iVar);
                    i9++;
                }
                i8++;
            }
            this.f.put(Integer.valueOf(i2), arrayList);
            i3 = 1;
            if (i2 == 1) {
                return;
            }
            i2 /= 2;
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            boolean z = true;
            if (this.a == null || this.b) {
                Map<Integer, List<i>> map = this.f;
                if (map != null) {
                    for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                        if (entry.getKey().intValue() == this.e) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.d || iVar.c == null) {
                                    z = false;
                                }
                            }
                        }
                    }
                    return z;
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int getAppliedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? getRequiredRotation() : invokeV.intValue;
    }

    public final PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? H0(getWidth() / 2, getHeight() / 2) : (PointF) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.j : invokeV.floatValue;
    }

    public final float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? k0() : invokeV.floatValue;
    }

    public final int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.h : invokeV.intValue;
    }

    public final int getSHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.E : invokeV.intValue;
    }

    public final int getSWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.D : invokeV.intValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.w : invokeV.floatValue;
    }

    public final ImageViewState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.y == null || this.D <= 0 || this.E <= 0) {
                return null;
            }
            return new ImageViewState(getScale(), getCenter(), getOrientation());
        }
        return (ImageViewState) invokeV.objValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public final PointF i0(float f2, float f3, float f4, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), pointF})) == null) {
            PointF G0 = G0(f2, f3, f4);
            pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - G0.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - G0.y) / f4);
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final float j0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048618, this, f2)) == null) {
            if (f2 > 0.0f && f2 < k0()) {
                Log.i("HugePhotoDraweeView", "targetScale is " + f2 + "< minScale is " + k0());
            } else {
                f2 = Math.max(k0(), f2);
            }
            return Math.min(this.j, f2);
        }
        return invokeF.floatValue;
    }

    public final float k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i2 = this.m;
            if (i2 == 2) {
                return Math.max((getWidth() - paddingLeft) / y0(), (getHeight() - paddingBottom) / x0());
            }
            if (i2 == 3) {
                float f2 = this.i;
                if (f2 > 0.0f) {
                    return f2;
                }
            }
            return Math.min((getWidth() - paddingLeft) / y0(), (getHeight() - paddingBottom) / x0());
        }
        return invokeV.floatValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public final synchronized void m0(Bitmap bitmap, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{bitmap, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.D > 0 && this.E > 0 && (this.D != bitmap.getWidth() || this.E != bitmap.getHeight())) {
                    t0(false);
                }
                if (this.a != null && !this.c) {
                    this.a.recycle();
                }
                this.b = false;
                this.c = z;
                this.a = bitmap;
                this.D = bitmap.getWidth();
                this.E = bitmap.getHeight();
                this.F = i2;
                boolean Q = Q();
                boolean P = P();
                if (Q || P) {
                    invalidate();
                    requestLayout();
                }
            }
        }
    }

    public final synchronized void n0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bitmap) == null) {
            synchronized (this) {
                if (this.a == null && !this.j0) {
                    if (this.H != null) {
                        this.a = Bitmap.createBitmap(bitmap, this.H.left, this.H.top, this.H.width(), this.H.height());
                    } else {
                        this.a = bitmap;
                    }
                    this.b = true;
                    if (Q()) {
                        invalidate();
                        requestLayout();
                    }
                    return;
                }
                bitmap.recycle();
            }
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, canvas) == null) {
            if (this.w0) {
                if (this.y0 != wn2.d(getContext())) {
                    wn2.b(getContext(), getDrawable());
                    this.y0 = wn2.d(getContext());
                }
                super.onDraw(canvas);
                return;
            }
            R();
            U();
            if (this.D == 0 || this.E == 0 || getWidth() == 0 || getHeight() == 0) {
                return;
            }
            if (this.f == null && this.N != null) {
                e0(d0(canvas));
            }
            if (Q()) {
                r0();
                if (this.h0 != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.h0.k;
                    boolean z = currentTimeMillis > this.h0.h;
                    long min = Math.min(currentTimeMillis, this.h0.h);
                    this.w = V(this.h0.j, min, this.h0.a, this.h0.b - this.h0.a, this.h0.h);
                    float V = V(this.h0.j, min, this.h0.f.x, this.h0.g.x - this.h0.f.x, this.h0.h);
                    float V2 = V(this.h0.j, min, this.h0.f.y, this.h0.g.y - this.h0.f.y, this.h0.h);
                    this.y.x -= D0(this.h0.d.x) - V;
                    this.y.y -= E0(this.h0.d.y) - V2;
                    a0(z || this.h0.a == this.h0.b);
                    s0(z);
                    if (z) {
                        if (this.h0.l != null) {
                            try {
                                this.h0.l.onComplete();
                            } catch (Exception e2) {
                                Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                            }
                        }
                        this.h0 = null;
                    }
                    invalidate();
                }
                if (this.f != null && g0()) {
                    int min2 = Math.min(this.e, O(this.w));
                    boolean z2 = false;
                    for (Map.Entry<Integer, List<i>> entry : this.f.entrySet()) {
                        if (entry.getKey().intValue() == min2) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.e && (iVar.d || iVar.c == null)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry<Integer, List<i>> entry2 : this.f.entrySet()) {
                        if (entry2.getKey().intValue() == min2 || z2) {
                            for (i iVar2 : entry2.getValue()) {
                                C0(iVar2.a, iVar2.f);
                                if (iVar2.d || iVar2.c == null) {
                                    if (iVar2.d && this.g) {
                                        canvas.drawText("LOADING", iVar2.f.left + 5, iVar2.f.top + 35, this.o0);
                                    }
                                } else {
                                    if (this.p0 != null) {
                                        canvas.drawRect(iVar2.f, this.p0);
                                    }
                                    if (this.r0 == null) {
                                        this.r0 = new Matrix();
                                    }
                                    this.r0.reset();
                                    z0(this.t0, 0.0f, 0.0f, iVar2.c.getWidth(), 0.0f, iVar2.c.getWidth(), iVar2.c.getHeight(), 0.0f, iVar2.c.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        z0(this.u0, iVar2.f.left, iVar2.f.top, iVar2.f.right, iVar2.f.top, iVar2.f.right, iVar2.f.bottom, iVar2.f.left, iVar2.f.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        z0(this.u0, iVar2.f.right, iVar2.f.top, iVar2.f.right, iVar2.f.bottom, iVar2.f.left, iVar2.f.bottom, iVar2.f.left, iVar2.f.top);
                                    } else if (getRequiredRotation() == 180) {
                                        z0(this.u0, iVar2.f.right, iVar2.f.bottom, iVar2.f.left, iVar2.f.bottom, iVar2.f.left, iVar2.f.top, iVar2.f.right, iVar2.f.top);
                                    } else if (getRequiredRotation() == 270) {
                                        z0(this.u0, iVar2.f.left, iVar2.f.bottom, iVar2.f.left, iVar2.f.top, iVar2.f.right, iVar2.f.top, iVar2.f.right, iVar2.f.bottom);
                                    }
                                    this.r0.setPolyToPoly(this.t0, 0, this.u0, 0, 4);
                                    canvas.drawBitmap(iVar2.c, this.r0, this.n0);
                                    if (this.g) {
                                        canvas.drawRect(iVar2.f, this.o0);
                                    }
                                }
                                if (iVar2.e && this.g) {
                                    canvas.drawText("ISS " + iVar2.b + " RECT " + iVar2.a.top + "," + iVar2.a.left + "," + iVar2.a.bottom + "," + iVar2.a.right, iVar2.f.left + 5, iVar2.f.top + 15, this.o0);
                                }
                            }
                        }
                    }
                    if (this.g) {
                        canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.w)), 5.0f, 15.0f, this.o0);
                        canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.y.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.y.y)), 5.0f, 35.0f, this.o0);
                        PointF center = getCenter();
                        canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.o0);
                        c cVar = this.h0;
                        if (cVar != null) {
                            PointF B02 = B0(cVar.c);
                            PointF B03 = B0(this.h0.e);
                            PointF B04 = B0(this.h0.d);
                            canvas.drawCircle(B02.x, B02.y, 10.0f, this.o0);
                            canvas.drawCircle(B03.x, B03.y, 20.0f, this.o0);
                            canvas.drawCircle(B04.x, B04.y, 25.0f, this.o0);
                            canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.o0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.a != null) {
                    float f3 = this.w;
                    if (this.b) {
                        f3 *= this.D / bitmap.getWidth();
                        f2 = this.w * (this.E / this.a.getHeight());
                    } else {
                        f2 = f3;
                    }
                    if (this.r0 == null) {
                        this.r0 = new Matrix();
                    }
                    this.r0.reset();
                    this.r0.postScale(f3, f2);
                    this.r0.postRotate(getRequiredRotation());
                    Matrix matrix = this.r0;
                    PointF pointF = this.y;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.r0;
                        float f4 = this.w;
                        matrix2.postTranslate(this.D * f4, f4 * this.E);
                    } else if (getRequiredRotation() == 90) {
                        this.r0.postTranslate(this.w * this.E, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.r0.postTranslate(0.0f, this.w * this.D);
                    }
                    if (this.p0 != null) {
                        if (this.s0 == null) {
                            this.s0 = new RectF();
                        }
                        this.s0.set(0.0f, 0.0f, this.D, this.E);
                        this.r0.mapRect(this.s0);
                        canvas.drawRect(this.s0, this.p0);
                    }
                    Bitmap bitmap2 = this.a;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        canvas.drawBitmap(this.a, this.r0, this.n0);
                    } else {
                        Log.i("HugePhotoDraweeView", "onDraw-> Bitmap is NULL or Recycled <--");
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048625, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            boolean z = mode != 1073741824;
            boolean z2 = mode2 != 1073741824;
            if (this.D > 0 && this.E > 0) {
                if (z && z2) {
                    size = y0();
                    size2 = x0();
                } else if (z2) {
                    size2 = (int) ((x0() / y0()) * size);
                } else if (z) {
                    size = (int) ((y0() / x0()) * size2);
                }
            }
            setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048626, this, i2, i3, i4, i5) == null) {
            PointF center = getCenter();
            if (!this.i0 || center == null) {
                return;
            }
            this.h0 = null;
            this.A = Float.valueOf(this.w);
            this.B = center;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
        if (r6 != 262) goto L55;
     */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        GestureDetector gestureDetector;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            c cVar = this.h0;
            if (cVar != null && !cVar.i) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            c cVar2 = this.h0;
            if (cVar2 != null && cVar2.l != null) {
                try {
                    this.h0.l.a();
                } catch (Exception e2) {
                    Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                }
            }
            this.h0 = null;
            if (this.w0 && this.y == null) {
                this.y = new PointF();
            }
            if (this.y == null) {
                return true;
            }
            boolean z = false;
            if (!this.K && ((gestureDetector = this.M) == null || gestureDetector.onTouchEvent(motionEvent))) {
                this.I = false;
                this.J = false;
                this.L = 0;
                return true;
            }
            if (this.z == null) {
                this.z = new PointF(0.0f, 0.0f);
            }
            if (this.R == null) {
                this.R = new PointF(0.0f, 0.0f);
            }
            int pointerCount = motionEvent.getPointerCount();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.L > 0) {
                            if (pointerCount >= 2) {
                                float S = S(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                float x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                if (this.r) {
                                    PointF pointF = this.R;
                                    if (S(pointF.x, x, pointF.y, y) > 5.0f || Math.abs(S - this.S) > 5.0f || this.J) {
                                        this.I = true;
                                        this.J = true;
                                        this.w = Math.min(this.j, (S / this.S) * this.x);
                                        float k0 = k0();
                                        float f2 = this.w;
                                        if (f2 <= k0) {
                                            Log.i("HugePhotoDraweeView", "scale is " + this.w + "<= minScaleValue is " + k0);
                                        } else if (this.q) {
                                            PointF pointF2 = this.R;
                                            float f3 = pointF2.x;
                                            PointF pointF3 = this.z;
                                            float f4 = pointF2.y - pointF3.y;
                                            float f5 = this.x;
                                            float f6 = f4 * (f2 / f5);
                                            PointF pointF4 = this.y;
                                            pointF4.x = x - ((f3 - pointF3.x) * (f2 / f5));
                                            pointF4.y = y - f6;
                                        } else if (this.C != null) {
                                            this.y.x = (getWidth() / 2) - (this.w * this.C.x);
                                            this.y.y = (getHeight() / 2) - (this.w * this.C.y);
                                        } else {
                                            this.y.x = (getWidth() / 2) - (this.w * (y0() / 2));
                                            this.y.y = (getHeight() / 2) - (this.w * (x0() / 2));
                                        }
                                        a0(true);
                                        s0(false);
                                        z = true;
                                    }
                                }
                            } else {
                                if (this.K) {
                                    float abs = (Math.abs(this.R.y - motionEvent.getY()) * 2.0f) + this.T;
                                    if (this.V == -1.0f) {
                                        this.V = abs;
                                    }
                                    boolean z2 = motionEvent.getY() > this.W.y;
                                    this.W.set(0.0f, motionEvent.getY());
                                    float abs2 = Math.abs(1.0f - (abs / this.V)) * 0.5f;
                                    if (abs2 > 0.03f || this.g0) {
                                        this.g0 = true;
                                        float max = Math.max(k0(), Math.min(this.j, this.w * (this.V > 0.0f ? z2 ? abs2 + 1.0f : 1.0f - abs2 : 1.0f)));
                                        this.w = max;
                                        if (this.q) {
                                            PointF pointF5 = this.R;
                                            float f7 = pointF5.x;
                                            PointF pointF6 = this.z;
                                            float f8 = pointF5.y;
                                            float f9 = this.x;
                                            float f10 = (f8 - pointF6.y) * (max / f9);
                                            PointF pointF7 = this.y;
                                            pointF7.x = f7 - ((f7 - pointF6.x) * (max / f9));
                                            pointF7.y = f8 - f10;
                                        } else if (this.C != null) {
                                            this.y.x = (getWidth() / 2) - (this.w * this.C.x);
                                            this.y.y = (getHeight() / 2) - (this.w * this.C.y);
                                        } else {
                                            this.y.x = (getWidth() / 2) - (this.w * (y0() / 2));
                                            this.y.y = (getHeight() / 2) - (this.w * (x0() / 2));
                                        }
                                    }
                                    this.V = abs;
                                    a0(true);
                                    s0(false);
                                } else if (!this.I) {
                                    float abs3 = Math.abs(motionEvent.getX() - this.R.x);
                                    float abs4 = Math.abs(motionEvent.getY() - this.R.y);
                                    float f11 = this.v0 * 5.0f;
                                    int i2 = (abs3 > f11 ? 1 : (abs3 == f11 ? 0 : -1));
                                    if (i2 > 0 || abs4 > f11 || this.J) {
                                        this.y.x = this.z.x + (motionEvent.getX() - this.R.x);
                                        this.y.y = this.z.y + (motionEvent.getY() - this.R.y);
                                        PointF pointF8 = this.y;
                                        float f12 = pointF8.x;
                                        float f13 = pointF8.y;
                                        a0(true);
                                        boolean z3 = f12 != this.y.x;
                                        boolean z4 = z3 && abs3 > abs4 && !this.J;
                                        boolean z5 = f13 == this.y.y && abs4 > f11 * 3.0f;
                                        if (!z4 && (!z3 || z5 || this.J)) {
                                            this.J = true;
                                        } else if (i2 > 0) {
                                            this.L = 0;
                                            this.m0.removeMessages(1);
                                            getParent().requestDisallowInterceptTouchEvent(false);
                                        }
                                        if (!this.q) {
                                            PointF pointF9 = this.y;
                                            PointF pointF10 = this.z;
                                            pointF9.x = pointF10.x;
                                            pointF9.y = pointF10.y;
                                            getParent().requestDisallowInterceptTouchEvent(false);
                                        }
                                        s0(false);
                                    }
                                }
                                z = true;
                            }
                        }
                        if (z) {
                            this.m0.removeMessages(1);
                            invalidate();
                            return true;
                        }
                    } else if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                if (action != 261) {
                                }
                            }
                        }
                    }
                    return super.onTouchEvent(motionEvent);
                }
                u0();
                this.m0.removeMessages(1);
                if (this.K) {
                    this.K = false;
                    if (!this.g0) {
                        T(this.U, this.R);
                    }
                }
                if (this.L <= 0 || !(this.I || this.J)) {
                    if (pointerCount == 1) {
                        this.I = false;
                        this.J = false;
                        this.L = 0;
                    }
                    return true;
                }
                if (this.I && pointerCount == 2) {
                    this.J = true;
                    PointF pointF11 = this.z;
                    PointF pointF12 = this.y;
                    pointF11.set(pointF12.x, pointF12.y);
                    if (motionEvent.getActionIndex() == 1) {
                        this.R.set(motionEvent.getX(0), motionEvent.getY(0));
                    } else {
                        this.R.set(motionEvent.getX(1), motionEvent.getY(1));
                    }
                }
                if (pointerCount < 3) {
                    this.I = false;
                }
                if (pointerCount < 2) {
                    this.J = false;
                    this.L = 0;
                }
                s0(true);
                return true;
            }
            this.h0 = null;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.L = Math.max(this.L, pointerCount);
            if (pointerCount >= 2) {
                if (this.r) {
                    float S2 = S(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                    this.x = this.w;
                    this.S = S2;
                    PointF pointF13 = this.z;
                    PointF pointF14 = this.y;
                    pointF13.set(pointF14.x, pointF14.y);
                    this.R.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                } else {
                    this.L = 0;
                }
                this.m0.removeMessages(1);
            } else if (!this.K) {
                PointF pointF15 = this.z;
                PointF pointF16 = this.y;
                pointF15.set(pointF16.x, pointF16.y);
                this.R.set(motionEvent.getX(), motionEvent.getY());
                this.m0.sendEmptyMessageDelayed(1, 600L);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            synchronized (this) {
                Q();
                P();
                if (g0() && this.a != null) {
                    if (!this.c) {
                        this.a.recycle();
                    }
                    this.a = null;
                    this.b = false;
                    this.c = false;
                }
                invalidate();
            }
        }
    }

    public final synchronized void q0(ao2 ao2Var, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048629, this, ao2Var, i2, i3, i4) == null) {
            synchronized (this) {
                if (this.D > 0 && this.E > 0 && (this.D != i2 || this.E != i3)) {
                    t0(false);
                    if (this.a != null) {
                        if (!this.c) {
                            this.a.recycle();
                        }
                        this.a = null;
                        this.b = false;
                        this.c = false;
                    }
                }
                this.N = ao2Var;
                this.D = i2;
                this.E = i3;
                this.F = i4;
                Q();
                P();
                invalidate();
                requestLayout();
            }
        }
    }

    public final void r0() {
        Float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || getWidth() == 0 || getHeight() == 0 || this.D <= 0 || this.E <= 0) {
            return;
        }
        if (this.B != null && (f2 = this.A) != null) {
            this.w = f2.floatValue();
            if (this.y == null) {
                this.y = new PointF();
            }
            this.y.x = (getWidth() / 2) - (this.w * this.B.x);
            this.y.y = (getHeight() / 2) - (this.w * this.B.y);
            this.B = null;
            this.A = null;
            a0(true);
            s0(true);
        }
        a0(false);
    }

    public final void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z) == null) || this.N == null || this.f == null) {
            return;
        }
        int min = Math.min(this.e, O(this.w));
        for (Map.Entry<Integer, List<i>> entry : this.f.entrySet()) {
            for (i iVar : entry.getValue()) {
                if (iVar.b < min || (iVar.b > min && iVar.b != this.e)) {
                    iVar.e = false;
                    if (iVar.c != null) {
                        iVar.c.recycle();
                        iVar.c = null;
                    }
                }
                if (iVar.b != min) {
                    if (iVar.b == this.e) {
                        iVar.e = true;
                    }
                } else if (F0(iVar)) {
                    iVar.e = true;
                    if (!iVar.d && iVar.c == null && z) {
                        Y(new j(this, this.N, iVar));
                    }
                } else if (iVar.b != this.e) {
                    iVar.e = false;
                    if (iVar.c != null) {
                        iVar.c.recycle();
                        iVar.c = null;
                    }
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderClass(Class<? extends zn2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, cls) == null) {
            if (cls == null) {
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", "bitmapDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.P = new xn2(cls);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderFactory(yn2<? extends zn2> yn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, yn2Var) == null) {
            if (yn2Var == null) {
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", "bitmapDecoderFactory is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder factory cannot be set to null");
            }
            this.P = yn2Var;
        }
    }

    public final void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.g = z;
        }
    }

    public final void setDoubleTapZoomDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setDoubleTapZoomScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
        }
    }

    public final void setDoubleTapZoomDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.v = Math.max(0, i2);
        }
    }

    public final void setDoubleTapZoomScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048637, this, f2) == null) {
            this.t = f2;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setDoubleTapZoomStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            if (!B0.contains(Integer.valueOf(i2))) {
                String str = "Invalid zoom style: " + i2;
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.u = i2;
        }
    }

    public final void setImage(vn2 vn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, vn2Var) == null) {
            setImage(vn2Var, null, null);
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, drawable) == null) {
            wn2.b(getContext(), drawable);
            super.setImageDrawable(drawable);
        }
    }

    public void setIsDynamicBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.w0 = z;
        }
    }

    public final void setMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f2) == null) {
            this.j = f2;
        }
    }

    public void setMaxTileSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            this.n = i2;
            this.o = i2;
        }
    }

    public final void setMaximumDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
        }
    }

    public final void setMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048649, this, f2) == null) {
            this.i = f2;
        }
    }

    public final void setMinimumDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMaxScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setMinimumScaleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            if (!E0.contains(Integer.valueOf(i2))) {
                String str = "Invalid scale type: " + i2;
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.m = i2;
            if (h0()) {
                a0(true);
                invalidate();
            }
        }
    }

    public void setMinimumTileDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.k = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
            if (h0()) {
                t0(false);
                invalidate();
            }
        }
    }

    public void setOnImageEventListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, gVar) == null) {
            this.k0 = gVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onLongClickListener) == null) {
            this.l0 = onLongClickListener;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            if (!A0.contains(Integer.valueOf(i2))) {
                String str = "Invalid orientation: " + i2;
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.h = i2;
            t0(false);
            invalidate();
            requestLayout();
        }
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.q = z;
            if (z || (pointF = this.y) == null) {
                return;
            }
            pointF.x = (getWidth() / 2) - (this.w * (y0() / 2));
            this.y.y = (getHeight() / 2) - (this.w * (x0() / 2));
            if (h0()) {
                s0(true);
                invalidate();
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setPanLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            if (!D0.contains(Integer.valueOf(i2))) {
                String str = "Invalid pan limit: " + i2;
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.l = i2;
            if (h0()) {
                a0(true);
                invalidate();
            }
        }
    }

    public void setParallelLoadingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.p = z;
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.s = z;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderClass(Class<? extends ao2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, cls) == null) {
            if (cls == null) {
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", "regionDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.Q = new xn2(cls);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderFactory(yn2<? extends ao2> yn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, yn2Var) == null) {
            if (yn2Var == null) {
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", "setRegionDecoderFactory is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder factory cannot be set to null");
            }
            this.Q = yn2Var;
        }
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Float.valueOf(f2), pointF}) == null) {
            this.h0 = null;
            this.A = Float.valueOf(f2);
            this.B = pointF;
            this.C = pointF;
            invalidate();
        }
    }

    public final void setTileBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i2) == null) {
            if (Color.alpha(i2) == 0) {
                this.p0 = null;
            } else {
                Paint paint = new Paint();
                this.p0 = paint;
                paint.setStyle(Paint.Style.FILL);
                this.p0.setColor(i2);
            }
            invalidate();
        }
    }

    public final void setZoomEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.r = z;
        }
    }

    public final void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = null;
            this.z = null;
            this.A = Float.valueOf(0.0f);
            this.B = null;
            this.C = null;
            this.I = false;
            this.J = false;
            this.K = false;
            this.L = 0;
            this.e = 0;
            this.R = null;
            this.S = 0.0f;
            this.U = null;
            this.V = 0.0f;
            this.W = null;
            this.g0 = false;
            this.h0 = null;
            this.q0 = null;
            this.r0 = null;
            this.s0 = null;
            if (z) {
                this.d = null;
                if (this.N != null) {
                    synchronized (this.O) {
                        this.N.recycle();
                        this.N = null;
                    }
                }
                Bitmap bitmap = this.a;
                if (bitmap != null && !this.c) {
                    bitmap.recycle();
                }
                this.D = 0;
                this.E = 0;
                this.F = 0;
                this.G = null;
                this.H = null;
                this.i0 = false;
                this.j0 = false;
                this.a = null;
                this.b = false;
                this.c = false;
            }
            Map<Integer, List<i>> map = this.f;
            if (map != null) {
                for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                    for (i iVar : entry.getValue()) {
                        iVar.e = false;
                        if (iVar.c != null) {
                            iVar.c.recycle();
                            iVar.c = null;
                        }
                    }
                }
                this.f = null;
            }
            setGestureDetector(getContext());
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || this.w >= k0()) {
            return;
        }
        v0();
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.h0 = null;
            this.A = Float.valueOf(j0(0.0f));
            if (h0()) {
                this.B = new PointF(y0() / 2, x0() / 2);
            } else {
                this.B = new PointF(0.0f, 0.0f);
            }
            invalidate();
        }
    }

    public final void w0(ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048668, this, imageViewState) == null) || imageViewState == null || imageViewState.getCenter() == null || !A0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.h = imageViewState.getOrientation();
        this.A = Float.valueOf(imageViewState.getScale());
        this.B = imageViewState.getCenter();
        invalidate();
    }

    public final int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            int requiredRotation = getRequiredRotation();
            if (requiredRotation != 90 && requiredRotation != 270) {
                return this.E;
            }
            return this.D;
        }
        return invokeV.intValue;
    }

    public final int y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            int requiredRotation = getRequiredRotation();
            if (requiredRotation != 90 && requiredRotation != 270) {
                return this.D;
            }
            return this.E;
        }
        return invokeV.intValue;
    }

    public final void z0(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{fArr, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)}) == null) {
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
            fArr[4] = f6;
            fArr[5] = f7;
            fArr[6] = f8;
            fArr[7] = f9;
        }
    }

    public final void setImage(vn2 vn2Var, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, vn2Var, imageViewState) == null) {
            setImage(vn2Var, null, imageViewState);
        }
    }

    public final void setImage(vn2 vn2Var, vn2 vn2Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, vn2Var, vn2Var2) == null) {
            setImage(vn2Var, vn2Var2, null);
        }
    }

    public void setMaxTileSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048647, this, i2, i3) == null) {
            this.n = i2;
            this.o = i3;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setImage(vn2 vn2Var, vn2 vn2Var2, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048642, this, vn2Var, vn2Var2, imageViewState) == null) {
            if (vn2Var == null) {
                if (!z0) {
                    sw1.k("HugePhotoDraweeView", "imageSource is null");
                    return;
                }
                throw new NullPointerException("imageSource must not be null");
            }
            t0(true);
            if (imageViewState != null) {
                w0(imageViewState);
            }
            if (vn2Var2 != null) {
                if (vn2Var.c() != null) {
                    if (!z0) {
                        sw1.k("HugePhotoDraweeView", "imageSource get bitmap is not null");
                        return;
                    }
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (vn2Var.g() > 0 && vn2Var.e() > 0) {
                    this.D = vn2Var.g();
                    this.E = vn2Var.e();
                    this.H = vn2Var2.f();
                    if (vn2Var2.c() != null) {
                        this.c = vn2Var2.j();
                        n0(vn2Var2.c());
                    } else {
                        Uri i2 = vn2Var2.i();
                        if (i2 == null && vn2Var2.d() != null) {
                            i2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + vn2Var2.d());
                        }
                        Y(new e(this, getContext(), this.P, i2, true));
                    }
                } else if (!z0) {
                    sw1.k("HugePhotoDraweeView", "imageSource width or height invalid");
                    return;
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                }
            }
            if (vn2Var.c() != null && vn2Var.f() != null) {
                m0(Bitmap.createBitmap(vn2Var.c(), vn2Var.f().left, vn2Var.f().top, vn2Var.f().width(), vn2Var.f().height()), 0, false);
            } else if (vn2Var.c() != null && !vn2Var.h()) {
                m0(vn2Var.c(), 0, vn2Var.j());
            } else {
                this.G = vn2Var.f();
                Uri i3 = vn2Var.i();
                this.d = i3;
                if (i3 == null && vn2Var.d() != null) {
                    this.d = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + vn2Var.d());
                }
                if (!vn2Var.h() && this.G == null) {
                    Y(new e(this, getContext(), this.P, this.d, false));
                } else {
                    Y(new k(this, getContext(), this.Q, vn2Var));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public PointF c;
        public PointF d;
        public PointF e;
        public PointF f;
        public PointF g;
        public long h;
        public boolean i;
        public int j;
        public long k;
        public f l;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = 500L;
            this.i = true;
            this.j = 2;
            this.k = System.currentTimeMillis();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HugePhotoDraweeView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
