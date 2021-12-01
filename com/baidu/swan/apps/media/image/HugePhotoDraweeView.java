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
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes9.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean D0;
    public static final List<Integer> E0;
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    public static final List<Integer> F0;
    public static final List<Integer> G0;
    public static final List<Integer> H0;
    public static final List<Integer> I0;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static int TILE_SIZE_AUTO = 0;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public boolean A0;
    public float B;
    public ColorFilter B0;
    public PointF C;
    public int C0;
    public PointF D;
    public Float E;
    public PointF F;
    public PointF G;
    public int H;
    public int I;
    public int J;
    public Rect K;
    public Rect L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public GestureDetector Q;
    public c.a.p0.a.j1.e.d.d R;
    public final Object S;
    public c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.c> T;
    public c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.d> U;
    public PointF V;
    public float W;
    public final float a0;
    public PointF b0;
    public float c0;
    public PointF d0;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f39598e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39599f;
    public c f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39600g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f39601h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public int f39602i;
    public g i0;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, List<i>> f39603j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f39604k;
    public View.OnLongClickListener k0;
    public int l;
    public float m;
    public float n;
    public int o;
    public int p;
    public int q;
    public Handler q0;
    public int r;
    public Paint r0;
    public int s;
    public Paint s0;
    public boolean t;
    public Paint t0;
    public boolean u;
    public h u0;
    public boolean v;
    public Matrix v0;
    public boolean w;
    public RectF w0;
    public float x;
    public float[] x0;
    public int y;
    public float[] y0;
    public int z;
    public float z0;

    /* loaded from: classes9.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f39605e;

        public a(HugePhotoDraweeView hugePhotoDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39605e = hugePhotoDraweeView;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f39605e.k0 != null) {
                    this.f39605e.P = 0;
                    HugePhotoDraweeView hugePhotoDraweeView = this.f39605e;
                    HugePhotoDraweeView.super.setOnLongClickListener(hugePhotoDraweeView.k0);
                    this.f39605e.performLongClick();
                    HugePhotoDraweeView.super.setOnLongClickListener(null);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f39607f;

        public b(HugePhotoDraweeView hugePhotoDraweeView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39607f = hugePhotoDraweeView;
            this.f39606e = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.f39607f.v && this.f39607f.g0 && this.f39607f.C != null) {
                    this.f39607f.setGestureDetector(this.f39606e);
                    if (this.f39607f.w) {
                        this.f39607f.V = new PointF(motionEvent.getX(), motionEvent.getY());
                        this.f39607f.D = new PointF(this.f39607f.C.x, this.f39607f.C.y);
                        HugePhotoDraweeView hugePhotoDraweeView = this.f39607f;
                        hugePhotoDraweeView.B = hugePhotoDraweeView.A;
                        this.f39607f.O = true;
                        this.f39607f.M = true;
                        HugePhotoDraweeView hugePhotoDraweeView2 = this.f39607f;
                        hugePhotoDraweeView2.b0 = hugePhotoDraweeView2.viewToSourceCoord(hugePhotoDraweeView2.V);
                        this.f39607f.c0 = -1.0f;
                        this.f39607f.d0 = new PointF(this.f39607f.b0.x, this.f39607f.b0.y);
                        this.f39607f.e0 = false;
                        return false;
                    }
                    HugePhotoDraweeView hugePhotoDraweeView3 = this.f39607f;
                    hugePhotoDraweeView3.T(hugePhotoDraweeView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f39607f.u && this.f39607f.g0 && this.f39607f.C != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f2) > 500.0f || Math.abs(f3) > 500.0f) && !this.f39607f.M))) {
                    PointF pointF = new PointF(this.f39607f.C.x + (f2 * 0.25f), this.f39607f.C.y + (f3 * 0.25f));
                    d dVar = new d(this.f39607f, new PointF(((this.f39607f.getWidth() / 2) - pointF.x) / this.f39607f.A, ((this.f39607f.getHeight() / 2) - pointF.y) / this.f39607f.A), (a) null);
                    dVar.d(1);
                    dVar.f(false);
                    dVar.b();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.f39607f.performClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f39618b;

        /* renamed from: c  reason: collision with root package name */
        public final PointF f39619c;

        /* renamed from: d  reason: collision with root package name */
        public long f39620d;

        /* renamed from: e  reason: collision with root package name */
        public int f39621e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f39622f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f39623g;

        /* renamed from: h  reason: collision with root package name */
        public f f39624h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f39625i;

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF, PointF pointF2, a aVar) {
            this(hugePhotoDraweeView, f2, pointF, pointF2);
        }

        public void b() {
            PointF pointF;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f39625i.f0 != null && this.f39625i.f0.l != null) {
                    try {
                        this.f39625i.f0.l.b();
                    } catch (Exception unused) {
                    }
                }
                int paddingLeft = this.f39625i.getPaddingLeft() + (((this.f39625i.getWidth() - this.f39625i.getPaddingRight()) - this.f39625i.getPaddingLeft()) / 2);
                int paddingTop = this.f39625i.getPaddingTop() + (((this.f39625i.getHeight() - this.f39625i.getPaddingBottom()) - this.f39625i.getPaddingTop()) / 2);
                float i0 = this.f39625i.i0(this.a);
                if (this.f39623g) {
                    HugePhotoDraweeView hugePhotoDraweeView = this.f39625i;
                    PointF pointF2 = this.f39618b;
                    float f2 = pointF2.x;
                    float f3 = pointF2.y;
                    pointF = new PointF();
                    hugePhotoDraweeView.h0(f2, f3, i0, pointF);
                } else {
                    pointF = this.f39618b;
                }
                this.f39625i.f0 = new c(null);
                this.f39625i.f0.a = this.f39625i.A;
                this.f39625i.f0.f39608b = i0;
                this.f39625i.f0.f39617k = System.currentTimeMillis();
                this.f39625i.f0.f39611e = pointF;
                this.f39625i.f0.f39609c = this.f39625i.getCenter();
                this.f39625i.f0.f39610d = pointF;
                this.f39625i.f0.f39612f = this.f39625i.sourceToViewCoord(pointF);
                this.f39625i.f0.f39613g = new PointF(paddingLeft, paddingTop);
                this.f39625i.f0.f39614h = this.f39620d;
                this.f39625i.f0.f39615i = this.f39622f;
                this.f39625i.f0.f39616j = this.f39621e;
                this.f39625i.f0.f39617k = System.currentTimeMillis();
                this.f39625i.f0.l = this.f39624h;
                PointF pointF3 = this.f39619c;
                if (pointF3 != null) {
                    float f4 = pointF3.x - (this.f39625i.f0.f39609c.x * i0);
                    float f5 = this.f39619c.y - (this.f39625i.f0.f39609c.y * i0);
                    h hVar = new h(i0, new PointF(f4, f5), null);
                    this.f39625i.b0(true, hVar);
                    this.f39625i.f0.f39613g = new PointF(this.f39619c.x + (hVar.f39632b.x - f4), this.f39619c.y + (hVar.f39632b.y - f5));
                }
                this.f39625i.invalidate();
            }
        }

        public d c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f39620d = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public d d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (!HugePhotoDraweeView.G0.contains(Integer.valueOf(i2))) {
                    String str = "Unknown easing type: " + i2;
                    if (!HugePhotoDraweeView.D0) {
                        c.a.p0.a.e0.d.k("HugePhotoDraweeView", str);
                        return this;
                    }
                    throw new IllegalArgumentException(str);
                }
                this.f39621e = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }

        public d e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f39622f = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public final d f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f39623g = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF, a aVar) {
            this(hugePhotoDraweeView, f2, pointF);
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f2, a aVar) {
            this(hugePhotoDraweeView, f2);
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
                interceptable.invokeUnInit(65542, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65542, newInitContext);
                    return;
                }
            }
            this.f39625i = hugePhotoDraweeView;
            this.f39620d = 500L;
            this.f39621e = 2;
            this.f39622f = true;
            this.f39623g = true;
            this.a = hugePhotoDraweeView.A;
            this.f39618b = pointF;
            this.f39619c = null;
        }

        public d(HugePhotoDraweeView hugePhotoDraweeView, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39625i = hugePhotoDraweeView;
            this.f39620d = 500L;
            this.f39621e = 2;
            this.f39622f = true;
            this.f39623g = true;
            this.a = f2;
            this.f39618b = hugePhotoDraweeView.getCenter();
            this.f39619c = null;
        }

        public d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, Float.valueOf(f2), pointF};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f39625i = hugePhotoDraweeView;
            this.f39620d = 500L;
            this.f39621e = 2;
            this.f39622f = true;
            this.f39623g = true;
            this.a = f2;
            this.f39618b = pointF;
            this.f39619c = null;
        }

        public d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, Float.valueOf(f2), pointF, pointF2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f39625i = hugePhotoDraweeView;
            this.f39620d = 500L;
            this.f39621e = 2;
            this.f39622f = true;
            this.f39623g = true;
            this.a = f2;
            this.f39618b = pointF;
            this.f39619c = pointF2;
        }
    }

    /* loaded from: classes9.dex */
    public static class e extends AsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f39626b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.c>> f39627c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri f39628d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f39629e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f39630f;

        /* renamed from: g  reason: collision with root package name */
        public Exception f39631g;

        public e(HugePhotoDraweeView hugePhotoDraweeView, Context context, c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.c> bVar, Uri uri, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context, bVar, uri, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.f39626b = new WeakReference<>(context);
            this.f39627c = new WeakReference<>(bVar);
            this.f39628d = uri;
            this.f39629e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    String uri = this.f39628d.toString();
                    Context context = this.f39626b.get();
                    c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.c> bVar = this.f39627c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    if (context == null || bVar == null || hugePhotoDraweeView == null) {
                        return null;
                    }
                    this.f39630f = bVar.make().decode(context, this.f39628d);
                    return Integer.valueOf(hugePhotoDraweeView.c0(uri));
                } catch (Exception e2) {
                    this.f39631g = e2;
                    return null;
                } catch (OutOfMemoryError e3) {
                    this.f39631g = new RuntimeException(e3);
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
            Bitmap bitmap = this.f39630f;
            if (bitmap != null && num != null) {
                if (this.f39629e) {
                    hugePhotoDraweeView.l0(bitmap);
                } else {
                    hugePhotoDraweeView.k0(bitmap, num.intValue(), false);
                }
            } else if (this.f39631g == null || hugePhotoDraweeView.i0 == null) {
            } else {
                if (this.f39629e) {
                    hugePhotoDraweeView.i0.onPreviewLoadError(this.f39631g);
                } else {
                    hugePhotoDraweeView.i0.onImageLoadError(this.f39631g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a();

        void b();

        void onComplete();
    }

    /* loaded from: classes9.dex */
    public interface g {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: classes9.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public PointF f39632b;

        public /* synthetic */ h(float f2, PointF pointF, a aVar) {
            this(f2, pointF);
        }

        public h(float f2, PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), pointF};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2;
            this.f39632b = pointF;
        }
    }

    /* loaded from: classes9.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;

        /* renamed from: b  reason: collision with root package name */
        public int f39633b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f39634c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f39635d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39636e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f39637f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f39638g;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static class j extends AsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<c.a.p0.a.j1.e.d.d> f39639b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<i> f39640c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f39641d;

        public j(HugePhotoDraweeView hugePhotoDraweeView, c.a.p0.a.j1.e.d.d dVar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, dVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.f39639b = new WeakReference<>(dVar);
            this.f39640c = new WeakReference<>(iVar);
            iVar.f39635d = true;
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
                    c.a.p0.a.j1.e.d.d dVar = this.f39639b.get();
                    i iVar = this.f39640c.get();
                    if (dVar == null || iVar == null || hugePhotoDraweeView == null || !dVar.isReady() || !iVar.f39636e) {
                        if (iVar != null) {
                            iVar.f39635d = false;
                            return null;
                        }
                        return null;
                    }
                    synchronized (hugePhotoDraweeView.S) {
                        hugePhotoDraweeView.Z(iVar.a, iVar.f39638g);
                        if (hugePhotoDraweeView.K != null) {
                            iVar.f39638g.offset(hugePhotoDraweeView.K.left, hugePhotoDraweeView.K.top);
                        }
                        decodeRegion = dVar.decodeRegion(iVar.f39638g, iVar.f39633b);
                    }
                    return decodeRegion;
                } catch (Exception e2) {
                    this.f39641d = e2;
                    return null;
                } catch (OutOfMemoryError e3) {
                    this.f39641d = new RuntimeException(e3);
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
                i iVar = this.f39640c.get();
                if (hugePhotoDraweeView == null || iVar == null) {
                    return;
                }
                if (bitmap != null) {
                    iVar.f39634c = bitmap;
                    iVar.f39635d = false;
                    hugePhotoDraweeView.m0();
                } else if (this.f39641d == null || hugePhotoDraweeView.i0 == null) {
                } else {
                    hugePhotoDraweeView.i0.onTileLoadError(this.f39641d);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class k extends AsyncTask<Void, Void, int[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f39642b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.d>> f39643c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.a.j1.e.b f39644d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.a.j1.e.d.d f39645e;

        /* renamed from: f  reason: collision with root package name */
        public Exception f39646f;

        public k(HugePhotoDraweeView hugePhotoDraweeView, Context context, c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.d> bVar, c.a.p0.a.j1.e.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.f39642b = new WeakReference<>(context);
            this.f39643c = new WeakReference<>(bVar);
            this.f39644d = bVar2;
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
                    if (this.f39644d.i() != null) {
                        this.f39644d.i().toString();
                    }
                    Context context = this.f39642b.get();
                    c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.d> bVar = this.f39643c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    if (context == null || bVar == null || hugePhotoDraweeView == null) {
                        return null;
                    }
                    this.f39645e = bVar.make();
                    if (this.f39644d.c() != null) {
                        init = this.f39645e.a(context, this.f39644d.c());
                    } else {
                        init = this.f39645e.init(context, this.f39644d.i());
                    }
                    int i2 = init.x;
                    int i3 = init.y;
                    int c0 = hugePhotoDraweeView.c0("");
                    if (hugePhotoDraweeView.K != null) {
                        i2 = hugePhotoDraweeView.K.width();
                        i3 = hugePhotoDraweeView.K.height();
                    }
                    return new int[]{i2, i3, c0};
                } catch (Exception e2) {
                    this.f39646f = e2;
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
            c.a.p0.a.j1.e.d.d dVar = this.f39645e;
            if (dVar != null && iArr != null && iArr.length == 3) {
                hugePhotoDraweeView.n0(dVar, iArr[0], iArr[1], iArr[2]);
            } else if (this.f39646f == null || hugePhotoDraweeView.i0 == null) {
            } else {
                hugePhotoDraweeView.i0.onImageLoadError(this.f39646f);
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
        D0 = c.a.p0.a.k.a;
        E0 = Arrays.asList(0, 90, 180, 270, -1);
        F0 = Arrays.asList(1, 2, 3);
        G0 = Arrays.asList(2, 1);
        H0 = Arrays.asList(1, 2, 3);
        I0 = Arrays.asList(2, 1, 3);
        TILE_SIZE_AUTO = Integer.MAX_VALUE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        c.a.p0.a.j1.e.b a2;
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
        this.l = 0;
        this.m = j0();
        this.n = 5.0f;
        this.o = -1;
        this.p = 1;
        this.q = 1;
        int i4 = TILE_SIZE_AUTO;
        this.r = i4;
        this.s = i4;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = 5.0f;
        this.y = 1;
        this.z = 500;
        this.S = new Object();
        this.T = new c.a.p0.a.j1.e.d.a(c.a.p0.a.j1.e.d.e.class);
        this.U = new c.a.p0.a.j1.e.d.a(c.a.p0.a.j1.e.d.f.class);
        this.x0 = new float[8];
        this.y0 = new float[8];
        this.A0 = false;
        this.B0 = null;
        this.C0 = 0;
        this.z0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(720);
        setGestureDetector(context);
        this.q0 = new Handler(new a(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.p0.a.j.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_assetName) && (string = obtainStyledAttributes.getString(c.a.p0.a.j.HugePhotoDraweeView_assetName)) != null && string.length() > 0 && (a2 = c.a.p0.a.j1.e.b.a(string)) != null) {
                a2.n();
                setImage(a2);
            }
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_src) && (resourceId = obtainStyledAttributes.getResourceId(c.a.p0.a.j.HugePhotoDraweeView_src, 0)) > 0) {
                c.a.p0.a.j1.e.b k2 = c.a.p0.a.j1.e.b.k(resourceId);
                k2.n();
                setImage(k2);
            }
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(c.a.p0.a.j.HugePhotoDraweeView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(c.a.p0.a.j.HugePhotoDraweeView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(c.a.p0.a.j.HugePhotoDraweeView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(c.a.p0.a.j.HugePhotoDraweeView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.a0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int getRequiredRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            int i2 = this.l;
            return i2 == -1 ? this.J : i2;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, context) == null) {
            this.Q = new GestureDetector(context, new b(this, context));
        }
    }

    public final float A0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            PointF pointF = this.C;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 - pointF.x) / this.A;
        }
        return invokeF.floatValue;
    }

    public final float B0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            PointF pointF = this.C;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 - pointF.y) / this.A;
        }
        return invokeF.floatValue;
    }

    public final int O(float f2) {
        InterceptResult invokeF;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) != null) {
            return invokeF.intValue;
        }
        if (this.o > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.o / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int t0 = (int) (t0() * f2);
        int s0 = (int) (s0() * f2);
        if (t0 == 0 || s0 == 0) {
            return 32;
        }
        int i2 = 1;
        if (s0() > s0 || t0() > t0) {
            round = Math.round(s0() / s0);
            int round2 = Math.round(t0() / t0);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean g0 = g0();
            if (!this.h0 && g0) {
                o0();
                this.h0 = true;
                onImageLoaded();
                g gVar = this.i0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean z = getWidth() > 0 && getHeight() > 0 && this.H > 0 && this.I > 0 && (this.f39598e != null || g0());
            if (!this.g0 && z) {
                o0();
                this.g0 = true;
                onReady();
                g gVar = this.i0;
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.r0 == null) {
                Paint paint = new Paint();
                this.r0 = paint;
                paint.setAntiAlias(true);
                this.r0.setFilterBitmap(true);
                this.r0.setDither(true);
            }
            if (this.s0 == null && this.f39604k) {
                Paint paint2 = new Paint();
                this.s0 = paint2;
                paint2.setTextSize(18.0f);
                this.s0.setColor(-65281);
                this.s0.setStyle(Paint.Style.STROKE);
            }
        }
    }

    public final float S(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f2 - f3;
            float f7 = f4 - f5;
            return (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }
        return invokeCommon.floatValue;
    }

    public final void T(PointF pointF, PointF pointF2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pointF, pointF2) == null) {
            if (!this.u) {
                PointF pointF3 = this.G;
                if (pointF3 != null) {
                    pointF.x = pointF3.x;
                    pointF.y = pointF3.y;
                } else {
                    pointF.x = t0() / 2;
                    pointF.y = s0() / 2;
                }
            }
            float min = Math.min(this.n, this.x);
            boolean z = ((double) this.A) <= ((double) min) * 0.9d;
            if (!z) {
                min = j0();
            }
            float f2 = min;
            int i2 = this.y;
            if (i2 == 3) {
                setScaleAndCenter(f2, pointF);
            } else if (i2 == 2 || !z || !this.u) {
                d dVar = new d(this, f2, pointF, (a) null);
                dVar.e(false);
                dVar.c(this.z);
                dVar.b();
            } else if (i2 == 1) {
                d dVar2 = new d(this, f2, pointF, pointF2, null);
                dVar2.e(false);
                dVar2.c(this.z);
                dVar2.b();
            }
            invalidate();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.r0 == null) {
            return;
        }
        if (this.C0 != c.a.p0.a.j1.e.c.d(getContext())) {
            this.C0 = c.a.p0.a.j1.e.c.d(getContext());
            this.B0 = new PorterDuffColorFilter(this.C0, PorterDuff.Mode.SRC_ATOP);
        }
        this.r0.setColorFilter(this.B0);
    }

    @SuppressLint({"BDThrowableCheck"})
    public final float V(int i2, long j2, float f2, float f3, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    String str = "Unexpected easing type: " + i2;
                    if (!D0) {
                        c.a.p0.a.e0.d.k("HugePhotoDraweeView", str);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            float f4 = ((float) j2) / ((float) j3);
            return ((-f3) * f4 * (f4 - 2.0f)) + f2;
        }
        return invokeCommon.floatValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void Y(AsyncTask<Void, Void, ?> asyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, asyncTask) == null) {
            if (this.t && Build.VERSION.SDK_INT >= 11) {
                try {
                    AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                    return;
                } catch (Exception unused) {
                }
            }
            asyncTask.execute(new Void[0]);
        }
    }

    public final void Z(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, rect, rect2) == null) {
            if (getRequiredRotation() == 0) {
                rect2.set(rect);
            } else if (getRequiredRotation() == 90) {
                int i2 = rect.top;
                int i3 = this.I;
                rect2.set(i2, i3 - rect.right, rect.bottom, i3 - rect.left);
            } else if (getRequiredRotation() == 180) {
                int i4 = this.H;
                int i5 = this.I;
                rect2.set(i4 - rect.right, i5 - rect.bottom, i4 - rect.left, i5 - rect.top);
            } else {
                int i6 = this.H;
                rect2.set(i6 - rect.bottom, rect.left, i6 - rect.top, rect.right);
            }
        }
    }

    public final void a0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.C == null) {
                z2 = true;
                this.C = new PointF(0.0f, 0.0f);
            } else {
                z2 = false;
            }
            if (this.u0 == null) {
                this.u0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.u0.a = this.A;
            this.u0.f39632b.set(this.C);
            b0(z, this.u0);
            this.A = this.u0.a;
            this.C.set(this.u0.f39632b);
            if (z2) {
                this.C.set(z0(t0() / 2, s0() / 2, this.A));
            }
        }
    }

    public d animateCenter(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pointF)) == null) {
            if (isReady()) {
                return new d(this, pointF, (a) null);
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public d animateScale(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f2)) == null) {
            if (isReady()) {
                return new d(this, f2, (a) null);
            }
            return null;
        }
        return (d) invokeF.objValue;
    }

    public d animateScaleAndCenter(float f2, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), pointF})) == null) {
            if (isReady()) {
                return new d(this, f2, pointF, (a) null);
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public final void b0(boolean z, h hVar) {
        float max;
        int max2;
        float max3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048594, this, z, hVar) == null) {
            if (this.p == 2 && isReady()) {
                z = false;
            }
            PointF pointF = hVar.f39632b;
            float i0 = i0(hVar.a);
            float t0 = t0() * i0;
            float s0 = s0() * i0;
            if (this.p == 3 && isReady()) {
                pointF.x = Math.max(pointF.x, (getWidth() / 2) - t0);
                pointF.y = Math.max(pointF.y, (getHeight() / 2) - s0);
            } else if (z) {
                pointF.x = Math.max(pointF.x, getWidth() - t0);
                pointF.y = Math.max(pointF.y, getHeight() - s0);
            } else {
                pointF.x = Math.max(pointF.x, -t0);
                pointF.y = Math.max(pointF.y, -s0);
            }
            float f2 = 0.5f;
            float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
            if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
                f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
            }
            if (this.p == 3 && isReady()) {
                max = Math.max(0, getWidth() / 2);
                max2 = Math.max(0, getHeight() / 2);
            } else if (z) {
                max = Math.max(0.0f, (getWidth() - t0) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - s0) * f2);
                pointF.x = Math.min(pointF.x, max);
                pointF.y = Math.min(pointF.y, max3);
                hVar.a = i0;
            } else {
                max = Math.max(0, getWidth());
                max2 = Math.max(0, getHeight());
            }
            max3 = max2;
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            hVar.a = i0;
        }
    }

    public final int c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            int i2 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.startsWith("content")) {
                Cursor cursor = null;
                try {
                    cursor = getContext().getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            int i3 = cursor.getInt(0);
                            if (!E0.contains(Integer.valueOf(i3)) || i3 == -1) {
                                String str2 = "Unsupported orientation: " + i3;
                            } else {
                                i2 = i3;
                            }
                        }
                        c.a.p0.a.j1.e.a.a(cursor);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    c.a.p0.a.j1.e.a.a(cursor);
                    throw th;
                }
                c.a.p0.a.j1.e.a.a(cursor);
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
                        String str3 = "Unsupported EXIF orientation: " + attributeInt;
                        return 0;
                    }
                    return 0;
                } catch (Exception unused2) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, canvas)) == null) {
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
                        return new Point(Math.min(i3, this.r), Math.min(intValue, this.s));
                    }
                } catch (Exception unused2) {
                    i2 = 2048;
                }
                return new Point(Math.min(i3, this.r), Math.min(intValue, this.s));
            }
            intValue = 2048;
            return new Point(Math.min(i3, this.r), Math.min(intValue, this.s));
        }
        return (Point) invokeL.objValue;
    }

    public final synchronized void e0(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, point) == null) {
            synchronized (this) {
                h hVar = new h(0.0f, new PointF(0.0f, 0.0f), null);
                this.u0 = hVar;
                b0(true, hVar);
                int O = O(this.u0.a);
                this.f39602i = O;
                if (O > 1) {
                    this.f39602i = O / 2;
                }
                if (this.f39602i == 1 && this.K == null && t0() < point.x && s0() < point.y && this.f39601h != null) {
                    this.R.recycle();
                    this.R = null;
                    Y(new e(this, getContext(), this.T, this.f39601h, false));
                } else {
                    f0(point);
                    for (i iVar : this.f39603j.get(Integer.valueOf(this.f39602i))) {
                        Y(new j(this, this.R, iVar));
                    }
                    p0(true);
                }
            }
        }
    }

    public final void f0(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048598, this, point) != null) {
            return;
        }
        this.f39603j = new LinkedHashMap();
        int i2 = this.f39602i;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int t0 = t0() / i4;
            int s0 = s0() / i5;
            int i6 = t0 / i2;
            int i7 = s0 / i2;
            while (true) {
                if (i6 + i4 + i3 > point.x || (i6 > getWidth() * 1.25d && i2 < this.f39602i)) {
                    i4++;
                    t0 = t0() / i4;
                    i6 = t0 / i2;
                }
            }
            while (true) {
                if (i7 + i5 + i3 > point.y || (i7 > getHeight() * 1.25d && i2 < this.f39602i)) {
                    i5++;
                    s0 = s0() / i5;
                    i7 = s0 / i2;
                }
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    i iVar = new i(null);
                    iVar.f39633b = i2;
                    iVar.f39636e = i2 == this.f39602i;
                    iVar.a = new Rect(i8 * t0, i9 * s0, i8 == i4 + (-1) ? t0() : (i8 + 1) * t0, i9 == i5 + (-1) ? s0() : (i9 + 1) * s0);
                    iVar.f39637f = new Rect(0, 0, 0, 0);
                    iVar.f39638g = new Rect(iVar.a);
                    arrayList.add(iVar);
                    i9++;
                }
                i8++;
            }
            this.f39603j.put(Integer.valueOf(i2), arrayList);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            boolean z = true;
            if (this.f39598e == null || this.f39599f) {
                Map<Integer, List<i>> map = this.f39603j;
                if (map != null) {
                    for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                        if (entry.getKey().intValue() == this.f39602i) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.f39635d || iVar.f39634c == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getRequiredRotation() : invokeV.intValue;
    }

    public final PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? viewToSourceCoord(getWidth() / 2, getHeight() / 2) : (PointF) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.n : invokeV.floatValue;
    }

    public final float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? j0() : invokeV.floatValue;
    }

    public final int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.l : invokeV.intValue;
    }

    public final int getSHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.I : invokeV.intValue;
    }

    public final int getSWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.H : invokeV.intValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.A : invokeV.floatValue;
    }

    public final ImageViewState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.C == null || this.H <= 0 || this.I <= 0) {
                return null;
            }
            return new ImageViewState(getScale(), getCenter(), getOrientation());
        }
        return (ImageViewState) invokeV.objValue;
    }

    public final PointF h0(float f2, float f3, float f4, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), pointF})) == null) {
            PointF z0 = z0(f2, f3, f4);
            pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - z0.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - z0.y) / f4);
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final float i0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f2)) == null) {
            if (f2 > 0.0f && f2 < j0()) {
                String str = "targetScale is " + f2 + "< minScale is " + j0();
            } else {
                f2 = Math.max(j0(), f2);
            }
            return Math.min(this.n, f2);
        }
        return invokeF.floatValue;
    }

    public final boolean isImageLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.h0 : invokeV.booleanValue;
    }

    public final boolean isPanEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public final boolean isQuickScaleEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public final boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.g0 : invokeV.booleanValue;
    }

    public final boolean isZoomEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final float j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i2 = this.q;
            if (i2 == 2) {
                return Math.max((getWidth() - paddingLeft) / t0(), (getHeight() - paddingBottom) / s0());
            }
            if (i2 == 3) {
                float f2 = this.m;
                if (f2 > 0.0f) {
                    return f2;
                }
            }
            return Math.min((getWidth() - paddingLeft) / t0(), (getHeight() - paddingBottom) / s0());
        }
        return invokeV.floatValue;
    }

    public final synchronized void k0(Bitmap bitmap, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{bitmap, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.H > 0 && this.I > 0 && (this.H != bitmap.getWidth() || this.I != bitmap.getHeight())) {
                    q0(false);
                }
                if (this.f39598e != null && !this.f39600g) {
                    this.f39598e.recycle();
                }
                this.f39599f = false;
                this.f39600g = z;
                this.f39598e = bitmap;
                this.H = bitmap.getWidth();
                this.I = bitmap.getHeight();
                this.J = i2;
                boolean Q = Q();
                boolean P = P();
                if (Q || P) {
                    invalidate();
                    requestLayout();
                }
            }
        }
    }

    public final synchronized void l0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bitmap) == null) {
            synchronized (this) {
                if (this.f39598e == null && !this.h0) {
                    if (this.L != null) {
                        this.f39598e = Bitmap.createBitmap(bitmap, this.L.left, this.L.top, this.L.width(), this.L.height());
                    } else {
                        this.f39598e = bitmap;
                    }
                    this.f39599f = true;
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

    public final synchronized void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            synchronized (this) {
                Q();
                P();
                if (g0() && this.f39598e != null) {
                    if (!this.f39600g) {
                        this.f39598e.recycle();
                    }
                    this.f39598e = null;
                    this.f39599f = false;
                    this.f39600g = false;
                }
                invalidate();
            }
        }
    }

    public final synchronized void n0(c.a.p0.a.j1.e.d.d dVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048620, this, dVar, i2, i3, i4) == null) {
            synchronized (this) {
                if (this.H > 0 && this.I > 0 && (this.H != i2 || this.I != i3)) {
                    q0(false);
                    if (this.f39598e != null) {
                        if (!this.f39600g) {
                            this.f39598e.recycle();
                        }
                        this.f39598e = null;
                        this.f39599f = false;
                        this.f39600g = false;
                    }
                }
                this.R = dVar;
                this.H = i2;
                this.I = i3;
                this.J = i4;
                Q();
                P();
                invalidate();
                requestLayout();
            }
        }
    }

    public final void o0() {
        Float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || getWidth() == 0 || getHeight() == 0 || this.H <= 0 || this.I <= 0) {
            return;
        }
        if (this.F != null && (f2 = this.E) != null) {
            this.A = f2.floatValue();
            if (this.C == null) {
                this.C = new PointF();
            }
            this.C.x = (getWidth() / 2) - (this.A * this.F.x);
            this.C.y = (getHeight() / 2) - (this.A * this.F.y);
            this.F = null;
            this.E = null;
            a0(true);
            p0(true);
        }
        a0(false);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, canvas) == null) {
            if (this.A0) {
                if (this.C0 != c.a.p0.a.j1.e.c.d(getContext())) {
                    c.a.p0.a.j1.e.c.b(getContext(), getDrawable());
                    this.C0 = c.a.p0.a.j1.e.c.d(getContext());
                }
                super.onDraw(canvas);
                return;
            }
            R();
            U();
            if (this.H == 0 || this.I == 0 || getWidth() == 0 || getHeight() == 0) {
                return;
            }
            if (this.f39603j == null && this.R != null) {
                e0(d0(canvas));
            }
            if (Q()) {
                o0();
                if (this.f0 != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f0.f39617k;
                    boolean z = currentTimeMillis > this.f0.f39614h;
                    long min = Math.min(currentTimeMillis, this.f0.f39614h);
                    this.A = V(this.f0.f39616j, min, this.f0.a, this.f0.f39608b - this.f0.a, this.f0.f39614h);
                    float V = V(this.f0.f39616j, min, this.f0.f39612f.x, this.f0.f39613g.x - this.f0.f39612f.x, this.f0.f39614h);
                    float V2 = V(this.f0.f39616j, min, this.f0.f39612f.y, this.f0.f39613g.y - this.f0.f39612f.y, this.f0.f39614h);
                    this.C.x -= w0(this.f0.f39610d.x) - V;
                    this.C.y -= x0(this.f0.f39610d.y) - V2;
                    a0(z || this.f0.a == this.f0.f39608b);
                    p0(z);
                    if (z) {
                        if (this.f0.l != null) {
                            try {
                                this.f0.l.onComplete();
                            } catch (Exception unused) {
                            }
                        }
                        this.f0 = null;
                    }
                    invalidate();
                }
                if (this.f39603j != null && g0()) {
                    int min2 = Math.min(this.f39602i, O(this.A));
                    boolean z2 = false;
                    for (Map.Entry<Integer, List<i>> entry : this.f39603j.entrySet()) {
                        if (entry.getKey().intValue() == min2) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.f39636e && (iVar.f39635d || iVar.f39634c == null)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry<Integer, List<i>> entry2 : this.f39603j.entrySet()) {
                        if (entry2.getKey().intValue() == min2 || z2) {
                            for (i iVar2 : entry2.getValue()) {
                                v0(iVar2.a, iVar2.f39637f);
                                if (iVar2.f39635d || iVar2.f39634c == null) {
                                    i2 = min2;
                                    if (iVar2.f39635d && this.f39604k) {
                                        canvas.drawText("LOADING", iVar2.f39637f.left + 5, iVar2.f39637f.top + 35, this.s0);
                                    }
                                } else {
                                    if (this.t0 != null) {
                                        canvas.drawRect(iVar2.f39637f, this.t0);
                                    }
                                    if (this.v0 == null) {
                                        this.v0 = new Matrix();
                                    }
                                    this.v0.reset();
                                    i2 = min2;
                                    u0(this.x0, 0.0f, 0.0f, iVar2.f39634c.getWidth(), 0.0f, iVar2.f39634c.getWidth(), iVar2.f39634c.getHeight(), 0.0f, iVar2.f39634c.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        u0(this.y0, iVar2.f39637f.left, iVar2.f39637f.top, iVar2.f39637f.right, iVar2.f39637f.top, iVar2.f39637f.right, iVar2.f39637f.bottom, iVar2.f39637f.left, iVar2.f39637f.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        u0(this.y0, iVar2.f39637f.right, iVar2.f39637f.top, iVar2.f39637f.right, iVar2.f39637f.bottom, iVar2.f39637f.left, iVar2.f39637f.bottom, iVar2.f39637f.left, iVar2.f39637f.top);
                                    } else if (getRequiredRotation() == 180) {
                                        u0(this.y0, iVar2.f39637f.right, iVar2.f39637f.bottom, iVar2.f39637f.left, iVar2.f39637f.bottom, iVar2.f39637f.left, iVar2.f39637f.top, iVar2.f39637f.right, iVar2.f39637f.top);
                                    } else if (getRequiredRotation() == 270) {
                                        u0(this.y0, iVar2.f39637f.left, iVar2.f39637f.bottom, iVar2.f39637f.left, iVar2.f39637f.top, iVar2.f39637f.right, iVar2.f39637f.top, iVar2.f39637f.right, iVar2.f39637f.bottom);
                                    }
                                    this.v0.setPolyToPoly(this.x0, 0, this.y0, 0, 4);
                                    canvas.drawBitmap(iVar2.f39634c, this.v0, this.r0);
                                    if (this.f39604k) {
                                        canvas.drawRect(iVar2.f39637f, this.s0);
                                    }
                                }
                                if (iVar2.f39636e && this.f39604k) {
                                    canvas.drawText("ISS " + iVar2.f39633b + " RECT " + iVar2.a.top + "," + iVar2.a.left + "," + iVar2.a.bottom + "," + iVar2.a.right, iVar2.f39637f.left + 5, iVar2.f39637f.top + 15, this.s0);
                                }
                                min2 = i2;
                            }
                        }
                        min2 = min2;
                    }
                    if (this.f39604k) {
                        canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.A)), 5.0f, 15.0f, this.s0);
                        canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.C.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.C.y)), 5.0f, 35.0f, this.s0);
                        PointF center = getCenter();
                        canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.s0);
                        c cVar = this.f0;
                        if (cVar != null) {
                            PointF sourceToViewCoord = sourceToViewCoord(cVar.f39609c);
                            PointF sourceToViewCoord2 = sourceToViewCoord(this.f0.f39611e);
                            PointF sourceToViewCoord3 = sourceToViewCoord(this.f0.f39610d);
                            canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.s0);
                            canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.s0);
                            canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.s0);
                            canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.s0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f39598e != null) {
                    float f3 = this.A;
                    if (this.f39599f) {
                        f3 *= this.H / bitmap.getWidth();
                        f2 = this.A * (this.I / this.f39598e.getHeight());
                    } else {
                        f2 = f3;
                    }
                    if (this.v0 == null) {
                        this.v0 = new Matrix();
                    }
                    this.v0.reset();
                    this.v0.postScale(f3, f2);
                    this.v0.postRotate(getRequiredRotation());
                    Matrix matrix = this.v0;
                    PointF pointF = this.C;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.v0;
                        float f4 = this.A;
                        matrix2.postTranslate(this.H * f4, f4 * this.I);
                    } else if (getRequiredRotation() == 90) {
                        this.v0.postTranslate(this.A * this.I, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.v0.postTranslate(0.0f, this.A * this.H);
                    }
                    if (this.t0 != null) {
                        if (this.w0 == null) {
                            this.w0 = new RectF();
                        }
                        this.w0.set(0.0f, 0.0f, this.H, this.I);
                        this.v0.mapRect(this.w0);
                        canvas.drawRect(this.w0, this.t0);
                    }
                    Bitmap bitmap2 = this.f39598e;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    canvas.drawBitmap(this.f39598e, this.v0, this.r0);
                }
            }
        }
    }

    public void onImageLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048624, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            boolean z = mode != 1073741824;
            boolean z2 = mode2 != 1073741824;
            if (this.H > 0 && this.I > 0) {
                if (z && z2) {
                    size = t0();
                    size2 = s0();
                } else if (z2) {
                    size2 = (int) ((s0() / t0()) * size);
                } else if (z) {
                    size = (int) ((t0() / s0()) * size2);
                }
            }
            setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
        }
    }

    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048626, this, i2, i3, i4, i5) == null) {
            PointF center = getCenter();
            if (!this.g0 || center == null) {
                return;
            }
            this.f0 = null;
            this.E = Float.valueOf(this.A);
            this.F = center;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0090, code lost:
        if (r5 != 262) goto L54;
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
            c cVar = this.f0;
            if (cVar != null && !cVar.f39615i) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            c cVar2 = this.f0;
            if (cVar2 != null && cVar2.l != null) {
                try {
                    this.f0.l.a();
                } catch (Exception unused) {
                }
            }
            this.f0 = null;
            if (this.A0 && this.C == null) {
                this.C = new PointF();
            }
            if (this.C == null) {
                return true;
            }
            boolean z = false;
            if (!this.O && ((gestureDetector = this.Q) == null || gestureDetector.onTouchEvent(motionEvent))) {
                this.M = false;
                this.N = false;
                this.P = 0;
                return true;
            }
            if (this.D == null) {
                this.D = new PointF(0.0f, 0.0f);
            }
            if (this.V == null) {
                this.V = new PointF(0.0f, 0.0f);
            }
            int pointerCount = motionEvent.getPointerCount();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.P > 0) {
                            if (pointerCount >= 2) {
                                float S = S(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                float x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                if (this.v) {
                                    PointF pointF = this.V;
                                    if (S(pointF.x, x, pointF.y, y) > 5.0f || Math.abs(S - this.W) > 5.0f || this.N) {
                                        this.M = true;
                                        this.N = true;
                                        this.A = Math.min(this.n, (S / this.W) * this.B);
                                        float j0 = j0();
                                        float f2 = this.A;
                                        if (f2 <= j0) {
                                            String str = "scale is " + this.A + "<= minScaleValue is " + j0;
                                        } else if (this.u) {
                                            PointF pointF2 = this.V;
                                            float f3 = pointF2.x;
                                            PointF pointF3 = this.D;
                                            float f4 = pointF2.y - pointF3.y;
                                            float f5 = this.B;
                                            float f6 = f4 * (f2 / f5);
                                            PointF pointF4 = this.C;
                                            pointF4.x = x - ((f3 - pointF3.x) * (f2 / f5));
                                            pointF4.y = y - f6;
                                        } else if (this.G != null) {
                                            this.C.x = (getWidth() / 2) - (this.A * this.G.x);
                                            this.C.y = (getHeight() / 2) - (this.A * this.G.y);
                                        } else {
                                            this.C.x = (getWidth() / 2) - (this.A * (t0() / 2));
                                            this.C.y = (getHeight() / 2) - (this.A * (s0() / 2));
                                        }
                                        a0(true);
                                        p0(false);
                                        z = true;
                                    }
                                }
                            } else {
                                if (this.O) {
                                    float abs = (Math.abs(this.V.y - motionEvent.getY()) * 2.0f) + this.a0;
                                    if (this.c0 == -1.0f) {
                                        this.c0 = abs;
                                    }
                                    boolean z2 = motionEvent.getY() > this.d0.y;
                                    this.d0.set(0.0f, motionEvent.getY());
                                    float abs2 = Math.abs(1.0f - (abs / this.c0)) * 0.5f;
                                    if (abs2 > 0.03f || this.e0) {
                                        this.e0 = true;
                                        float max = Math.max(j0(), Math.min(this.n, this.A * (this.c0 > 0.0f ? z2 ? abs2 + 1.0f : 1.0f - abs2 : 1.0f)));
                                        this.A = max;
                                        if (this.u) {
                                            PointF pointF5 = this.V;
                                            float f7 = pointF5.x;
                                            PointF pointF6 = this.D;
                                            float f8 = pointF5.y;
                                            float f9 = this.B;
                                            float f10 = (f8 - pointF6.y) * (max / f9);
                                            PointF pointF7 = this.C;
                                            pointF7.x = f7 - ((f7 - pointF6.x) * (max / f9));
                                            pointF7.y = f8 - f10;
                                        } else if (this.G != null) {
                                            this.C.x = (getWidth() / 2) - (this.A * this.G.x);
                                            this.C.y = (getHeight() / 2) - (this.A * this.G.y);
                                        } else {
                                            this.C.x = (getWidth() / 2) - (this.A * (t0() / 2));
                                            this.C.y = (getHeight() / 2) - (this.A * (s0() / 2));
                                        }
                                    }
                                    this.c0 = abs;
                                    a0(true);
                                    p0(false);
                                } else if (!this.M) {
                                    float abs3 = Math.abs(motionEvent.getX() - this.V.x);
                                    float abs4 = Math.abs(motionEvent.getY() - this.V.y);
                                    float f11 = this.z0 * 5.0f;
                                    int i2 = (abs3 > f11 ? 1 : (abs3 == f11 ? 0 : -1));
                                    if (i2 > 0 || abs4 > f11 || this.N) {
                                        this.C.x = this.D.x + (motionEvent.getX() - this.V.x);
                                        this.C.y = this.D.y + (motionEvent.getY() - this.V.y);
                                        PointF pointF8 = this.C;
                                        float f12 = pointF8.x;
                                        float f13 = pointF8.y;
                                        a0(true);
                                        boolean z3 = f12 != this.C.x;
                                        boolean z4 = z3 && abs3 > abs4 && !this.N;
                                        boolean z5 = f13 == this.C.y && abs4 > f11 * 3.0f;
                                        if (!z4 && (!z3 || z5 || this.N)) {
                                            this.N = true;
                                        } else if (i2 > 0) {
                                            this.P = 0;
                                            this.q0.removeMessages(1);
                                            getParent().requestDisallowInterceptTouchEvent(false);
                                        }
                                        if (!this.u) {
                                            PointF pointF9 = this.C;
                                            PointF pointF10 = this.D;
                                            pointF9.x = pointF10.x;
                                            pointF9.y = pointF10.y;
                                            getParent().requestDisallowInterceptTouchEvent(false);
                                        }
                                        p0(false);
                                    }
                                }
                                z = true;
                            }
                        }
                        if (z) {
                            this.q0.removeMessages(1);
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
                resetMinScaleIfNeeded();
                this.q0.removeMessages(1);
                if (this.O) {
                    this.O = false;
                    if (!this.e0) {
                        T(this.b0, this.V);
                    }
                }
                if (this.P <= 0 || !(this.M || this.N)) {
                    if (pointerCount == 1) {
                        this.M = false;
                        this.N = false;
                        this.P = 0;
                    }
                    return true;
                }
                if (this.M && pointerCount == 2) {
                    this.N = true;
                    PointF pointF11 = this.D;
                    PointF pointF12 = this.C;
                    pointF11.set(pointF12.x, pointF12.y);
                    if (motionEvent.getActionIndex() == 1) {
                        this.V.set(motionEvent.getX(0), motionEvent.getY(0));
                    } else {
                        this.V.set(motionEvent.getX(1), motionEvent.getY(1));
                    }
                }
                if (pointerCount < 3) {
                    this.M = false;
                }
                if (pointerCount < 2) {
                    this.N = false;
                    this.P = 0;
                }
                p0(true);
                return true;
            }
            this.f0 = null;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.P = Math.max(this.P, pointerCount);
            if (pointerCount >= 2) {
                if (this.v) {
                    float S2 = S(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                    this.B = this.A;
                    this.W = S2;
                    PointF pointF13 = this.D;
                    PointF pointF14 = this.C;
                    pointF13.set(pointF14.x, pointF14.y);
                    this.V.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                } else {
                    this.P = 0;
                }
                this.q0.removeMessages(1);
            } else if (!this.O) {
                PointF pointF15 = this.D;
                PointF pointF16 = this.C;
                pointF15.set(pointF16.x, pointF16.y);
                this.V.set(motionEvent.getX(), motionEvent.getY());
                this.q0.sendEmptyMessageDelayed(1, 600L);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || this.R == null || this.f39603j == null) {
            return;
        }
        int min = Math.min(this.f39602i, O(this.A));
        for (Map.Entry<Integer, List<i>> entry : this.f39603j.entrySet()) {
            for (i iVar : entry.getValue()) {
                if (iVar.f39633b < min || (iVar.f39633b > min && iVar.f39633b != this.f39602i)) {
                    iVar.f39636e = false;
                    if (iVar.f39634c != null) {
                        iVar.f39634c.recycle();
                        iVar.f39634c = null;
                    }
                }
                if (iVar.f39633b != min) {
                    if (iVar.f39633b == this.f39602i) {
                        iVar.f39636e = true;
                    }
                } else if (y0(iVar)) {
                    iVar.f39636e = true;
                    if (!iVar.f39635d && iVar.f39634c == null && z) {
                        Y(new j(this, this.R, iVar));
                    }
                } else if (iVar.f39633b != this.f39602i) {
                    iVar.f39636e = false;
                    if (iVar.f39634c != null) {
                        iVar.f39634c.recycle();
                        iVar.f39634c = null;
                    }
                }
            }
        }
    }

    public final void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.A = 0.0f;
            this.B = 0.0f;
            this.C = null;
            this.D = null;
            this.E = Float.valueOf(0.0f);
            this.F = null;
            this.G = null;
            this.M = false;
            this.N = false;
            this.O = false;
            this.P = 0;
            this.f39602i = 0;
            this.V = null;
            this.W = 0.0f;
            this.b0 = null;
            this.c0 = 0.0f;
            this.d0 = null;
            this.e0 = false;
            this.f0 = null;
            this.u0 = null;
            this.v0 = null;
            this.w0 = null;
            if (z) {
                this.f39601h = null;
                if (this.R != null) {
                    synchronized (this.S) {
                        this.R.recycle();
                        this.R = null;
                    }
                }
                Bitmap bitmap = this.f39598e;
                if (bitmap != null && !this.f39600g) {
                    bitmap.recycle();
                }
                this.H = 0;
                this.I = 0;
                this.J = 0;
                this.K = null;
                this.L = null;
                this.g0 = false;
                this.h0 = false;
                this.f39598e = null;
                this.f39599f = false;
                this.f39600g = false;
            }
            Map<Integer, List<i>> map = this.f39603j;
            if (map != null) {
                for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                    for (i iVar : entry.getValue()) {
                        iVar.f39636e = false;
                        if (iVar.f39634c != null) {
                            iVar.f39634c.recycle();
                            iVar.f39634c = null;
                        }
                    }
                }
                this.f39603j = null;
            }
            setGestureDetector(getContext());
        }
    }

    public final void r0(ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, imageViewState) == null) || imageViewState == null || imageViewState.getCenter() == null || !E0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.l = imageViewState.getOrientation();
        this.E = Float.valueOf(imageViewState.getScale());
        this.F = imageViewState.getCenter();
        invalidate();
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            q0(true);
            this.r0 = null;
            this.s0 = null;
            this.t0 = null;
        }
    }

    public final void resetMinScaleIfNeeded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.A >= j0()) {
            return;
        }
        resetScaleAndCenter();
    }

    public final void resetScaleAndCenter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.f0 = null;
            this.E = Float.valueOf(i0(0.0f));
            if (isReady()) {
                this.F = new PointF(t0() / 2, s0() / 2);
            } else {
                this.F = new PointF(0.0f, 0.0f);
            }
            invalidate();
        }
    }

    public final int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            int requiredRotation = getRequiredRotation();
            if (requiredRotation != 90 && requiredRotation != 270) {
                return this.I;
            }
            return this.H;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderClass(Class<? extends c.a.p0.a.j1.e.d.c> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, cls) == null) {
            if (cls == null) {
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", "bitmapDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.T = new c.a.p0.a.j1.e.d.a(cls);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderFactory(c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.c> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bVar) == null) {
            if (bVar == null) {
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", "bitmapDecoderFactory is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder factory cannot be set to null");
            }
            this.T = bVar;
        }
    }

    public final void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.f39604k = z;
        }
    }

    public final void setDoubleTapZoomDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setDoubleTapZoomScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
        }
    }

    public final void setDoubleTapZoomDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.z = Math.max(0, i2);
        }
    }

    public final void setDoubleTapZoomScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048640, this, f2) == null) {
            this.x = f2;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setDoubleTapZoomStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!F0.contains(Integer.valueOf(i2))) {
                String str = "Invalid zoom style: " + i2;
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.y = i2;
        }
    }

    public final void setImage(c.a.p0.a.j1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, bVar) == null) {
            setImage(bVar, null, null);
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, drawable) == null) {
            c.a.p0.a.j1.e.c.b(getContext(), drawable);
            super.setImageDrawable(drawable);
        }
    }

    public void setIsDynamicBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.A0 = z;
        }
    }

    public final void setMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048648, this, f2) == null) {
            this.n = f2;
        }
    }

    public void setMaxTileSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            this.r = i2;
            this.s = i2;
        }
    }

    public final void setMaximumDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
        }
    }

    public final void setMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048652, this, f2) == null) {
            this.m = f2;
        }
    }

    public final void setMinimumDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            setMaxScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setMinimumScaleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            if (!I0.contains(Integer.valueOf(i2))) {
                String str = "Invalid scale type: " + i2;
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.q = i2;
            if (isReady()) {
                a0(true);
                invalidate();
            }
        }
    }

    public void setMinimumTileDpi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.o = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
            if (isReady()) {
                q0(false);
                invalidate();
            }
        }
    }

    public void setOnImageEventListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, gVar) == null) {
            this.i0 = gVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, onLongClickListener) == null) {
            this.k0 = onLongClickListener;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            if (!E0.contains(Integer.valueOf(i2))) {
                String str = "Invalid orientation: " + i2;
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.l = i2;
            q0(false);
            invalidate();
            requestLayout();
        }
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.u = z;
            if (z || (pointF = this.C) == null) {
                return;
            }
            pointF.x = (getWidth() / 2) - (this.A * (t0() / 2));
            this.C.y = (getHeight() / 2) - (this.A * (s0() / 2));
            if (isReady()) {
                p0(true);
                invalidate();
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setPanLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            if (!H0.contains(Integer.valueOf(i2))) {
                String str = "Invalid pan limit: " + i2;
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.p = i2;
            if (isReady()) {
                a0(true);
                invalidate();
            }
        }
    }

    public void setParallelLoadingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
            this.t = z;
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.w = z;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderClass(Class<? extends c.a.p0.a.j1.e.d.d> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, cls) == null) {
            if (cls == null) {
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", "regionDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.U = new c.a.p0.a.j1.e.d.a(cls);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderFactory(c.a.p0.a.j1.e.d.b<? extends c.a.p0.a.j1.e.d.d> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, bVar) == null) {
            if (bVar == null) {
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", "setRegionDecoderFactory is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder factory cannot be set to null");
            }
            this.U = bVar;
        }
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Float.valueOf(f2), pointF}) == null) {
            this.f0 = null;
            this.E = Float.valueOf(f2);
            this.F = pointF;
            this.G = pointF;
            invalidate();
        }
    }

    public final void setTileBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i2) == null) {
            if (Color.alpha(i2) == 0) {
                this.t0 = null;
            } else {
                Paint paint = new Paint();
                this.t0 = paint;
                paint.setStyle(Paint.Style.FILL);
                this.t0.setColor(i2);
            }
            invalidate();
        }
    }

    public final void setZoomEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.v = z;
        }
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, pointF)) == null) ? sourceToViewCoord(pointF.x, pointF.y, new PointF()) : (PointF) invokeL.objValue;
    }

    public final int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            int requiredRotation = getRequiredRotation();
            if (requiredRotation != 90 && requiredRotation != 270) {
                return this.H;
            }
            return this.I;
        }
        return invokeV.intValue;
    }

    public final void u0(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{fArr, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)}) == null) {
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

    public final Rect v0(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048674, this, rect, rect2)) == null) {
            rect2.set((int) w0(rect.left), (int) x0(rect.top), (int) w0(rect.right), (int) x0(rect.bottom));
            return rect2;
        }
        return (Rect) invokeLL.objValue;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, pointF)) == null) ? viewToSourceCoord(pointF.x, pointF.y, new PointF()) : (PointF) invokeL.objValue;
    }

    public final float w0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048679, this, f2)) == null) {
            PointF pointF = this.C;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 * this.A) + pointF.x;
        }
        return invokeF.floatValue;
    }

    public final float x0(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048680, this, f2)) == null) {
            PointF pointF = this.C;
            if (pointF == null) {
                return Float.NaN;
            }
            return (f2 * this.A) + pointF.y;
        }
        return invokeF.floatValue;
    }

    public final boolean y0(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, iVar)) == null) {
            return A0(0.0f) <= ((float) iVar.a.right) && ((float) iVar.a.left) <= A0((float) getWidth()) && B0(0.0f) <= ((float) iVar.a.bottom) && ((float) iVar.a.top) <= B0((float) getHeight());
        }
        return invokeL.booleanValue;
    }

    public final PointF z0(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048682, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
            int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            if (this.u0 == null) {
                this.u0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.u0.a = f4;
            this.u0.f39632b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
            b0(true, this.u0);
            return this.u0.f39632b;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final void setImage(c.a.p0.a.j1.e.b bVar, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, bVar, imageViewState) == null) {
            setImage(bVar, null, imageViewState);
        }
    }

    public final PointF sourceToViewCoord(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048668, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? sourceToViewCoord(f2, f3, new PointF()) : (PointF) invokeCommon.objValue;
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? viewToSourceCoord(f2, f3, new PointF()) : (PointF) invokeCommon.objValue;
    }

    public final void setImage(c.a.p0.a.j1.e.b bVar, c.a.p0.a.j1.e.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, bVar, bVar2) == null) {
            setImage(bVar, bVar2, null);
        }
    }

    public void setMaxTileSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048650, this, i2, i3) == null) {
            this.r = i2;
            this.s = i3;
        }
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048671, this, pointF, pointF2)) == null) ? sourceToViewCoord(pointF.x, pointF.y, pointF2) : (PointF) invokeLL.objValue;
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048678, this, pointF, pointF2)) == null) ? viewToSourceCoord(pointF.x, pointF.y, pointF2) : (PointF) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setImage(c.a.p0.a.j1.e.b bVar, c.a.p0.a.j1.e.b bVar2, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048644, this, bVar, bVar2, imageViewState) == null) {
            if (bVar == null) {
                if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", "imageSource is null");
                    return;
                }
                throw new NullPointerException("imageSource must not be null");
            }
            q0(true);
            if (imageViewState != null) {
                r0(imageViewState);
            }
            if (bVar2 != null) {
                if (bVar.c() != null) {
                    if (!D0) {
                        c.a.p0.a.e0.d.k("HugePhotoDraweeView", "imageSource get bitmap is not null");
                        return;
                    }
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (bVar.g() > 0 && bVar.e() > 0) {
                    this.H = bVar.g();
                    this.I = bVar.e();
                    this.L = bVar2.f();
                    if (bVar2.c() != null) {
                        this.f39600g = bVar2.j();
                        l0(bVar2.c());
                    } else {
                        Uri i2 = bVar2.i();
                        if (i2 == null && bVar2.d() != null) {
                            i2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar2.d());
                        }
                        Y(new e(this, getContext(), this.T, i2, true));
                    }
                } else if (!D0) {
                    c.a.p0.a.e0.d.k("HugePhotoDraweeView", "imageSource width or height invalid");
                    return;
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                }
            }
            if (bVar.c() != null && bVar.f() != null) {
                k0(Bitmap.createBitmap(bVar.c(), bVar.f().left, bVar.f().top, bVar.f().width(), bVar.f().height()), 0, false);
            } else if (bVar.c() != null && !bVar.h()) {
                k0(bVar.c(), 0, bVar.j());
            } else {
                this.K = bVar.f();
                Uri i3 = bVar.i();
                this.f39601h = i3;
                if (i3 == null && bVar.d() != null) {
                    this.f39601h = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar.d());
                }
                if (!bVar.h() && this.K == null) {
                    Y(new e(this, getContext(), this.T, this.f39601h, false));
                } else {
                    Y(new k(this, getContext(), this.U, bVar));
                }
            }
        }
    }

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048669, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            if (this.C == null) {
                return null;
            }
            pointF.set(w0(f2), x0(f3));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048676, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), pointF})) == null) {
            if (this.C == null) {
                return null;
            }
            pointF.set(A0(f2), B0(f3));
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f39608b;

        /* renamed from: c  reason: collision with root package name */
        public PointF f39609c;

        /* renamed from: d  reason: collision with root package name */
        public PointF f39610d;

        /* renamed from: e  reason: collision with root package name */
        public PointF f39611e;

        /* renamed from: f  reason: collision with root package name */
        public PointF f39612f;

        /* renamed from: g  reason: collision with root package name */
        public PointF f39613g;

        /* renamed from: h  reason: collision with root package name */
        public long f39614h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f39615i;

        /* renamed from: j  reason: collision with root package name */
        public int f39616j;

        /* renamed from: k  reason: collision with root package name */
        public long f39617k;
        public f l;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39614h = 500L;
            this.f39615i = true;
            this.f39616j = 2;
            this.f39617k = System.currentTimeMillis();
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
