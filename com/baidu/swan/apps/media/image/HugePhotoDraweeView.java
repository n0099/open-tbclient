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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean C0;
    public static final List<Integer> D0;
    public static final List<Integer> E0;
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    public static final List<Integer> F0;
    public static final List<Integer> G0;
    public static final List<Integer> H0;
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
    public ColorFilter A0;
    public float B;
    public int B0;
    public PointF C;
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
    public c.a.p0.a.i1.e.d.d R;
    public final Object S;
    public c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.c> T;
    public c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.d> U;
    public PointF V;
    public float W;
    public final float a0;
    public PointF b0;
    public float c0;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f46103e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46104f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46105g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f46106h;

    /* renamed from: i  reason: collision with root package name */
    public int f46107i;
    public PointF i0;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, List<i>> f46108j;
    public boolean j0;
    public boolean k;
    public c k0;
    public int l;
    public boolean l0;
    public float m;
    public boolean m0;
    public float n;
    public g n0;
    public int o;
    public View.OnLongClickListener o0;
    public int p;
    public Handler p0;
    public int q;
    public Paint q0;
    public int r;
    public Paint r0;
    public int s;
    public Paint s0;
    public boolean t;
    public h t0;
    public boolean u;
    public Matrix u0;
    public boolean v;
    public RectF v0;
    public boolean w;
    public float[] w0;
    public float x;
    public float[] x0;
    public int y;
    public float y0;
    public int z;
    public boolean z0;

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f46109e;

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
            this.f46109e = hugePhotoDraweeView;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f46109e.o0 != null) {
                    this.f46109e.P = 0;
                    HugePhotoDraweeView hugePhotoDraweeView = this.f46109e;
                    HugePhotoDraweeView.super.setOnLongClickListener(hugePhotoDraweeView.o0);
                    this.f46109e.performLongClick();
                    HugePhotoDraweeView.super.setOnLongClickListener(null);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f46111f;

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
            this.f46111f = hugePhotoDraweeView;
            this.f46110e = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.f46111f.v && this.f46111f.l0 && this.f46111f.C != null) {
                    this.f46111f.setGestureDetector(this.f46110e);
                    if (this.f46111f.w) {
                        this.f46111f.V = new PointF(motionEvent.getX(), motionEvent.getY());
                        this.f46111f.D = new PointF(this.f46111f.C.x, this.f46111f.C.y);
                        HugePhotoDraweeView hugePhotoDraweeView = this.f46111f;
                        hugePhotoDraweeView.B = hugePhotoDraweeView.A;
                        this.f46111f.O = true;
                        this.f46111f.M = true;
                        HugePhotoDraweeView hugePhotoDraweeView2 = this.f46111f;
                        hugePhotoDraweeView2.b0 = hugePhotoDraweeView2.viewToSourceCoord(hugePhotoDraweeView2.V);
                        this.f46111f.c0 = -1.0f;
                        this.f46111f.i0 = new PointF(this.f46111f.b0.x, this.f46111f.b0.y);
                        this.f46111f.j0 = false;
                        return false;
                    }
                    HugePhotoDraweeView hugePhotoDraweeView3 = this.f46111f;
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
                if (this.f46111f.u && this.f46111f.l0 && this.f46111f.C != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f2) > 500.0f || Math.abs(f3) > 500.0f) && !this.f46111f.M))) {
                    PointF pointF = new PointF(this.f46111f.C.x + (f2 * 0.25f), this.f46111f.C.y + (f3 * 0.25f));
                    d dVar = new d(this.f46111f, new PointF(((this.f46111f.getWidth() / 2) - pointF.x) / this.f46111f.A, ((this.f46111f.getHeight() / 2) - pointF.y) / this.f46111f.A), (a) null);
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
                this.f46111f.performClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final float f46122a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f46123b;

        /* renamed from: c  reason: collision with root package name */
        public final PointF f46124c;

        /* renamed from: d  reason: collision with root package name */
        public long f46125d;

        /* renamed from: e  reason: collision with root package name */
        public int f46126e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f46127f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f46128g;

        /* renamed from: h  reason: collision with root package name */
        public f f46129h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HugePhotoDraweeView f46130i;

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF, PointF pointF2, a aVar) {
            this(hugePhotoDraweeView, f2, pointF, pointF2);
        }

        public void b() {
            PointF pointF;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46130i.k0 != null && this.f46130i.k0.l != null) {
                    try {
                        this.f46130i.k0.l.b();
                    } catch (Exception unused) {
                    }
                }
                int paddingLeft = this.f46130i.getPaddingLeft() + (((this.f46130i.getWidth() - this.f46130i.getPaddingRight()) - this.f46130i.getPaddingLeft()) / 2);
                int paddingTop = this.f46130i.getPaddingTop() + (((this.f46130i.getHeight() - this.f46130i.getPaddingBottom()) - this.f46130i.getPaddingTop()) / 2);
                float i0 = this.f46130i.i0(this.f46122a);
                if (this.f46128g) {
                    HugePhotoDraweeView hugePhotoDraweeView = this.f46130i;
                    PointF pointF2 = this.f46123b;
                    float f2 = pointF2.x;
                    float f3 = pointF2.y;
                    pointF = new PointF();
                    hugePhotoDraweeView.h0(f2, f3, i0, pointF);
                } else {
                    pointF = this.f46123b;
                }
                this.f46130i.k0 = new c(null);
                this.f46130i.k0.f46112a = this.f46130i.A;
                this.f46130i.k0.f46113b = i0;
                this.f46130i.k0.k = System.currentTimeMillis();
                this.f46130i.k0.f46116e = pointF;
                this.f46130i.k0.f46114c = this.f46130i.getCenter();
                this.f46130i.k0.f46115d = pointF;
                this.f46130i.k0.f46117f = this.f46130i.sourceToViewCoord(pointF);
                this.f46130i.k0.f46118g = new PointF(paddingLeft, paddingTop);
                this.f46130i.k0.f46119h = this.f46125d;
                this.f46130i.k0.f46120i = this.f46127f;
                this.f46130i.k0.f46121j = this.f46126e;
                this.f46130i.k0.k = System.currentTimeMillis();
                this.f46130i.k0.l = this.f46129h;
                PointF pointF3 = this.f46124c;
                if (pointF3 != null) {
                    float f4 = pointF3.x - (this.f46130i.k0.f46114c.x * i0);
                    float f5 = this.f46124c.y - (this.f46130i.k0.f46114c.y * i0);
                    h hVar = new h(i0, new PointF(f4, f5), null);
                    this.f46130i.b0(true, hVar);
                    this.f46130i.k0.f46118g = new PointF(this.f46124c.x + (hVar.f46139b.x - f4), this.f46124c.y + (hVar.f46139b.y - f5));
                }
                this.f46130i.invalidate();
            }
        }

        public d c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f46125d = j2;
                return this;
            }
            return (d) invokeJ.objValue;
        }

        public d d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (!HugePhotoDraweeView.F0.contains(Integer.valueOf(i2))) {
                    String str = "Unknown easing type: " + i2;
                    if (!HugePhotoDraweeView.C0) {
                        c.a.p0.a.e0.d.h("HugePhotoDraweeView", str);
                        return this;
                    }
                    throw new IllegalArgumentException(str);
                }
                this.f46126e = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }

        public d e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f46127f = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public final d f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f46128g = z;
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
                interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                    return;
                }
            }
            this.f46130i = hugePhotoDraweeView;
            this.f46125d = 500L;
            this.f46126e = 2;
            this.f46127f = true;
            this.f46128g = true;
            this.f46122a = hugePhotoDraweeView.A;
            this.f46123b = pointF;
            this.f46124c = null;
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
            this.f46130i = hugePhotoDraweeView;
            this.f46125d = 500L;
            this.f46126e = 2;
            this.f46127f = true;
            this.f46128g = true;
            this.f46122a = f2;
            this.f46123b = hugePhotoDraweeView.getCenter();
            this.f46124c = null;
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
            this.f46130i = hugePhotoDraweeView;
            this.f46125d = 500L;
            this.f46126e = 2;
            this.f46127f = true;
            this.f46128g = true;
            this.f46122a = f2;
            this.f46123b = pointF;
            this.f46124c = null;
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
            this.f46130i = hugePhotoDraweeView;
            this.f46125d = 500L;
            this.f46126e = 2;
            this.f46127f = true;
            this.f46128g = true;
            this.f46122a = f2;
            this.f46123b = pointF;
            this.f46124c = pointF2;
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends AsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<HugePhotoDraweeView> f46131a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f46132b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.c>> f46133c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri f46134d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f46135e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f46136f;

        /* renamed from: g  reason: collision with root package name */
        public Exception f46137g;

        public e(HugePhotoDraweeView hugePhotoDraweeView, Context context, c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.c> bVar, Uri uri, boolean z) {
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
            this.f46131a = new WeakReference<>(hugePhotoDraweeView);
            this.f46132b = new WeakReference<>(context);
            this.f46133c = new WeakReference<>(bVar);
            this.f46134d = uri;
            this.f46135e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    String uri = this.f46134d.toString();
                    Context context = this.f46132b.get();
                    c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.c> bVar = this.f46133c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.f46131a.get();
                    if (context == null || bVar == null || hugePhotoDraweeView == null) {
                        return null;
                    }
                    this.f46136f = bVar.make().decode(context, this.f46134d);
                    return Integer.valueOf(hugePhotoDraweeView.c0(uri));
                } catch (Exception e2) {
                    this.f46137g = e2;
                    return null;
                } catch (OutOfMemoryError e3) {
                    this.f46137g = new RuntimeException(e3);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) || (hugePhotoDraweeView = this.f46131a.get()) == null) {
                return;
            }
            Bitmap bitmap = this.f46136f;
            if (bitmap != null && num != null) {
                if (this.f46135e) {
                    hugePhotoDraweeView.l0(bitmap);
                } else {
                    hugePhotoDraweeView.k0(bitmap, num.intValue(), false);
                }
            } else if (this.f46137g == null || hugePhotoDraweeView.n0 == null) {
            } else {
                if (this.f46135e) {
                    hugePhotoDraweeView.n0.onPreviewLoadError(this.f46137g);
                } else {
                    hugePhotoDraweeView.n0.onImageLoadError(this.f46137g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();

        void b();

        void onComplete();
    }

    /* loaded from: classes6.dex */
    public interface g {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f46138a;

        /* renamed from: b  reason: collision with root package name */
        public PointF f46139b;

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
            this.f46138a = f2;
            this.f46139b = pointF;
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Rect f46140a;

        /* renamed from: b  reason: collision with root package name */
        public int f46141b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f46142c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46143d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f46144e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f46145f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f46146g;

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

    /* loaded from: classes6.dex */
    public static class j extends AsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<HugePhotoDraweeView> f46147a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<c.a.p0.a.i1.e.d.d> f46148b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<i> f46149c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f46150d;

        public j(HugePhotoDraweeView hugePhotoDraweeView, c.a.p0.a.i1.e.d.d dVar, i iVar) {
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
            this.f46147a = new WeakReference<>(hugePhotoDraweeView);
            this.f46148b = new WeakReference<>(dVar);
            this.f46149c = new WeakReference<>(iVar);
            iVar.f46143d = true;
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
                    HugePhotoDraweeView hugePhotoDraweeView = this.f46147a.get();
                    c.a.p0.a.i1.e.d.d dVar = this.f46148b.get();
                    i iVar = this.f46149c.get();
                    if (dVar == null || iVar == null || hugePhotoDraweeView == null || !dVar.isReady() || !iVar.f46144e) {
                        if (iVar != null) {
                            iVar.f46143d = false;
                            return null;
                        }
                        return null;
                    }
                    synchronized (hugePhotoDraweeView.S) {
                        hugePhotoDraweeView.Z(iVar.f46140a, iVar.f46146g);
                        if (hugePhotoDraweeView.K != null) {
                            iVar.f46146g.offset(hugePhotoDraweeView.K.left, hugePhotoDraweeView.K.top);
                        }
                        decodeRegion = dVar.decodeRegion(iVar.f46146g, iVar.f46141b);
                    }
                    return decodeRegion;
                } catch (Exception e2) {
                    this.f46150d = e2;
                    return null;
                } catch (OutOfMemoryError e3) {
                    this.f46150d = new RuntimeException(e3);
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
                HugePhotoDraweeView hugePhotoDraweeView = this.f46147a.get();
                i iVar = this.f46149c.get();
                if (hugePhotoDraweeView == null || iVar == null) {
                    return;
                }
                if (bitmap != null) {
                    iVar.f46142c = bitmap;
                    iVar.f46143d = false;
                    hugePhotoDraweeView.m0();
                } else if (this.f46150d == null || hugePhotoDraweeView.n0 == null) {
                } else {
                    hugePhotoDraweeView.n0.onTileLoadError(this.f46150d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k extends AsyncTask<Void, Void, int[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<HugePhotoDraweeView> f46151a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f46152b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.d>> f46153c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.a.i1.e.b f46154d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.a.i1.e.d.d f46155e;

        /* renamed from: f  reason: collision with root package name */
        public Exception f46156f;

        public k(HugePhotoDraweeView hugePhotoDraweeView, Context context, c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.d> bVar, c.a.p0.a.i1.e.b bVar2) {
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
            this.f46151a = new WeakReference<>(hugePhotoDraweeView);
            this.f46152b = new WeakReference<>(context);
            this.f46153c = new WeakReference<>(bVar);
            this.f46154d = bVar2;
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
                    if (this.f46154d.i() != null) {
                        this.f46154d.i().toString();
                    }
                    Context context = this.f46152b.get();
                    c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.d> bVar = this.f46153c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.f46151a.get();
                    if (context == null || bVar == null || hugePhotoDraweeView == null) {
                        return null;
                    }
                    this.f46155e = bVar.make();
                    if (this.f46154d.c() != null) {
                        init = this.f46155e.a(context, this.f46154d.c());
                    } else {
                        init = this.f46155e.init(context, this.f46154d.i());
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
                    this.f46156f = e2;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) || (hugePhotoDraweeView = this.f46151a.get()) == null) {
                return;
            }
            c.a.p0.a.i1.e.d.d dVar = this.f46155e;
            if (dVar != null && iArr != null && iArr.length == 3) {
                hugePhotoDraweeView.n0(dVar, iArr[0], iArr[1], iArr[2]);
            } else if (this.f46156f == null || hugePhotoDraweeView.n0 == null) {
            } else {
                hugePhotoDraweeView.n0.onImageLoadError(this.f46156f);
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
        C0 = c.a.p0.a.k.f7077a;
        D0 = Arrays.asList(0, 90, 180, 270, -1);
        E0 = Arrays.asList(1, 2, 3);
        F0 = Arrays.asList(2, 1);
        G0 = Arrays.asList(1, 2, 3);
        H0 = Arrays.asList(2, 1, 3);
        TILE_SIZE_AUTO = Integer.MAX_VALUE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        c.a.p0.a.i1.e.b a2;
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
        this.T = new c.a.p0.a.i1.e.d.a(c.a.p0.a.i1.e.d.e.class);
        this.U = new c.a.p0.a.i1.e.d.a(c.a.p0.a.i1.e.d.f.class);
        this.w0 = new float[8];
        this.x0 = new float[8];
        this.z0 = false;
        this.A0 = null;
        this.B0 = 0;
        this.y0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(720);
        setGestureDetector(context);
        this.p0 = new Handler(new a(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.p0.a.j.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_assetName) && (string = obtainStyledAttributes.getString(c.a.p0.a.j.HugePhotoDraweeView_assetName)) != null && string.length() > 0 && (a2 = c.a.p0.a.i1.e.b.a(string)) != null) {
                a2.n();
                setImage(a2);
            }
            if (obtainStyledAttributes.hasValue(c.a.p0.a.j.HugePhotoDraweeView_src) && (resourceId = obtainStyledAttributes.getResourceId(c.a.p0.a.j.HugePhotoDraweeView_src, 0)) > 0) {
                c.a.p0.a.i1.e.b k2 = c.a.p0.a.i1.e.b.k(resourceId);
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
            if (!this.m0 && g0) {
                o0();
                this.m0 = true;
                onImageLoaded();
                g gVar = this.n0;
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
            boolean z = getWidth() > 0 && getHeight() > 0 && this.H > 0 && this.I > 0 && (this.f46103e != null || g0());
            if (!this.l0 && z) {
                o0();
                this.l0 = true;
                onReady();
                g gVar = this.n0;
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
            if (this.q0 == null) {
                Paint paint = new Paint();
                this.q0 = paint;
                paint.setAntiAlias(true);
                this.q0.setFilterBitmap(true);
                this.q0.setDither(true);
            }
            if (this.r0 == null && this.k) {
                Paint paint2 = new Paint();
                this.r0 = paint2;
                paint2.setTextSize(18.0f);
                this.r0.setColor(-65281);
                this.r0.setStyle(Paint.Style.STROKE);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.q0 == null) {
            return;
        }
        if (this.B0 != c.a.p0.a.i1.e.c.d(getContext())) {
            this.B0 = c.a.p0.a.i1.e.c.d(getContext());
            this.A0 = new PorterDuffColorFilter(this.B0, PorterDuff.Mode.SRC_ATOP);
        }
        this.q0.setColorFilter(this.A0);
    }

    public final float V(int i2, long j2, float f2, float f3, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    String str = "Unexpected easing type: " + i2;
                    if (!C0) {
                        c.a.p0.a.e0.d.h("HugePhotoDraweeView", str);
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
            if (this.t0 == null) {
                this.t0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.t0.f46138a = this.A;
            this.t0.f46139b.set(this.C);
            b0(z, this.t0);
            this.A = this.t0.f46138a;
            this.C.set(this.t0.f46139b);
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
            PointF pointF = hVar.f46139b;
            float i0 = i0(hVar.f46138a);
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
                hVar.f46138a = i0;
            } else {
                max = Math.max(0, getWidth());
                max2 = Math.max(0, getHeight());
            }
            max3 = max2;
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            hVar.f46138a = i0;
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
                            if (!D0.contains(Integer.valueOf(i3)) || i3 == -1) {
                                String str2 = "Unsupported orientation: " + i3;
                            } else {
                                i2 = i3;
                            }
                        }
                        c.a.p0.a.i1.e.a.a(cursor);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    c.a.p0.a.i1.e.a.a(cursor);
                    throw th;
                }
                c.a.p0.a.i1.e.a.a(cursor);
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
                this.t0 = hVar;
                b0(true, hVar);
                int O = O(this.t0.f46138a);
                this.f46107i = O;
                if (O > 1) {
                    this.f46107i = O / 2;
                }
                if (this.f46107i == 1 && this.K == null && t0() < point.x && s0() < point.y && this.f46106h != null) {
                    this.R.recycle();
                    this.R = null;
                    Y(new e(this, getContext(), this.T, this.f46106h, false));
                } else {
                    f0(point);
                    for (i iVar : this.f46108j.get(Integer.valueOf(this.f46107i))) {
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
        this.f46108j = new LinkedHashMap();
        int i2 = this.f46107i;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int t0 = t0() / i4;
            int s0 = s0() / i5;
            int i6 = t0 / i2;
            int i7 = s0 / i2;
            while (true) {
                if (i6 + i4 + i3 > point.x || (i6 > getWidth() * 1.25d && i2 < this.f46107i)) {
                    i4++;
                    t0 = t0() / i4;
                    i6 = t0 / i2;
                }
            }
            while (true) {
                if (i7 + i5 + i3 > point.y || (i7 > getHeight() * 1.25d && i2 < this.f46107i)) {
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
                    iVar.f46141b = i2;
                    iVar.f46144e = i2 == this.f46107i;
                    iVar.f46140a = new Rect(i8 * t0, i9 * s0, i8 == i4 + (-1) ? t0() : (i8 + 1) * t0, i9 == i5 + (-1) ? s0() : (i9 + 1) * s0);
                    iVar.f46145f = new Rect(0, 0, 0, 0);
                    iVar.f46146g = new Rect(iVar.f46140a);
                    arrayList.add(iVar);
                    i9++;
                }
                i8++;
            }
            this.f46108j.put(Integer.valueOf(i2), arrayList);
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
            if (this.f46103e == null || this.f46104f) {
                Map<Integer, List<i>> map = this.f46108j;
                if (map != null) {
                    for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                        if (entry.getKey().intValue() == this.f46107i) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.f46143d || iVar.f46142c == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.m0 : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.l0 : invokeV.booleanValue;
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
                if (this.f46103e != null && !this.f46105g) {
                    this.f46103e.recycle();
                }
                this.f46104f = false;
                this.f46105g = z;
                this.f46103e = bitmap;
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
                if (this.f46103e == null && !this.m0) {
                    if (this.L != null) {
                        this.f46103e = Bitmap.createBitmap(bitmap, this.L.left, this.L.top, this.L.width(), this.L.height());
                    } else {
                        this.f46103e = bitmap;
                    }
                    this.f46104f = true;
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
                if (g0() && this.f46103e != null) {
                    if (!this.f46105g) {
                        this.f46103e.recycle();
                    }
                    this.f46103e = null;
                    this.f46104f = false;
                    this.f46105g = false;
                }
                invalidate();
            }
        }
    }

    public final synchronized void n0(c.a.p0.a.i1.e.d.d dVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048620, this, dVar, i2, i3, i4) == null) {
            synchronized (this) {
                if (this.H > 0 && this.I > 0 && (this.H != i2 || this.I != i3)) {
                    q0(false);
                    if (this.f46103e != null) {
                        if (!this.f46105g) {
                            this.f46103e.recycle();
                        }
                        this.f46103e = null;
                        this.f46104f = false;
                        this.f46105g = false;
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
            if (this.z0) {
                if (this.B0 != c.a.p0.a.i1.e.c.d(getContext())) {
                    c.a.p0.a.i1.e.c.b(getContext(), getDrawable());
                    this.B0 = c.a.p0.a.i1.e.c.d(getContext());
                }
                super.onDraw(canvas);
                return;
            }
            R();
            U();
            if (this.H == 0 || this.I == 0 || getWidth() == 0 || getHeight() == 0) {
                return;
            }
            if (this.f46108j == null && this.R != null) {
                e0(d0(canvas));
            }
            if (Q()) {
                o0();
                if (this.k0 != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.k0.k;
                    boolean z = currentTimeMillis > this.k0.f46119h;
                    long min = Math.min(currentTimeMillis, this.k0.f46119h);
                    this.A = V(this.k0.f46121j, min, this.k0.f46112a, this.k0.f46113b - this.k0.f46112a, this.k0.f46119h);
                    float V = V(this.k0.f46121j, min, this.k0.f46117f.x, this.k0.f46118g.x - this.k0.f46117f.x, this.k0.f46119h);
                    float V2 = V(this.k0.f46121j, min, this.k0.f46117f.y, this.k0.f46118g.y - this.k0.f46117f.y, this.k0.f46119h);
                    this.C.x -= w0(this.k0.f46115d.x) - V;
                    this.C.y -= x0(this.k0.f46115d.y) - V2;
                    a0(z || this.k0.f46112a == this.k0.f46113b);
                    p0(z);
                    if (z) {
                        if (this.k0.l != null) {
                            try {
                                this.k0.l.onComplete();
                            } catch (Exception unused) {
                            }
                        }
                        this.k0 = null;
                    }
                    invalidate();
                }
                if (this.f46108j != null && g0()) {
                    int min2 = Math.min(this.f46107i, O(this.A));
                    boolean z2 = false;
                    for (Map.Entry<Integer, List<i>> entry : this.f46108j.entrySet()) {
                        if (entry.getKey().intValue() == min2) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.f46144e && (iVar.f46143d || iVar.f46142c == null)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry<Integer, List<i>> entry2 : this.f46108j.entrySet()) {
                        if (entry2.getKey().intValue() == min2 || z2) {
                            for (i iVar2 : entry2.getValue()) {
                                v0(iVar2.f46140a, iVar2.f46145f);
                                if (iVar2.f46143d || iVar2.f46142c == null) {
                                    i2 = min2;
                                    if (iVar2.f46143d && this.k) {
                                        canvas.drawText("LOADING", iVar2.f46145f.left + 5, iVar2.f46145f.top + 35, this.r0);
                                    }
                                } else {
                                    if (this.s0 != null) {
                                        canvas.drawRect(iVar2.f46145f, this.s0);
                                    }
                                    if (this.u0 == null) {
                                        this.u0 = new Matrix();
                                    }
                                    this.u0.reset();
                                    i2 = min2;
                                    u0(this.w0, 0.0f, 0.0f, iVar2.f46142c.getWidth(), 0.0f, iVar2.f46142c.getWidth(), iVar2.f46142c.getHeight(), 0.0f, iVar2.f46142c.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        u0(this.x0, iVar2.f46145f.left, iVar2.f46145f.top, iVar2.f46145f.right, iVar2.f46145f.top, iVar2.f46145f.right, iVar2.f46145f.bottom, iVar2.f46145f.left, iVar2.f46145f.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        u0(this.x0, iVar2.f46145f.right, iVar2.f46145f.top, iVar2.f46145f.right, iVar2.f46145f.bottom, iVar2.f46145f.left, iVar2.f46145f.bottom, iVar2.f46145f.left, iVar2.f46145f.top);
                                    } else if (getRequiredRotation() == 180) {
                                        u0(this.x0, iVar2.f46145f.right, iVar2.f46145f.bottom, iVar2.f46145f.left, iVar2.f46145f.bottom, iVar2.f46145f.left, iVar2.f46145f.top, iVar2.f46145f.right, iVar2.f46145f.top);
                                    } else if (getRequiredRotation() == 270) {
                                        u0(this.x0, iVar2.f46145f.left, iVar2.f46145f.bottom, iVar2.f46145f.left, iVar2.f46145f.top, iVar2.f46145f.right, iVar2.f46145f.top, iVar2.f46145f.right, iVar2.f46145f.bottom);
                                    }
                                    this.u0.setPolyToPoly(this.w0, 0, this.x0, 0, 4);
                                    canvas.drawBitmap(iVar2.f46142c, this.u0, this.q0);
                                    if (this.k) {
                                        canvas.drawRect(iVar2.f46145f, this.r0);
                                    }
                                }
                                if (iVar2.f46144e && this.k) {
                                    canvas.drawText("ISS " + iVar2.f46141b + " RECT " + iVar2.f46140a.top + "," + iVar2.f46140a.left + "," + iVar2.f46140a.bottom + "," + iVar2.f46140a.right, iVar2.f46145f.left + 5, iVar2.f46145f.top + 15, this.r0);
                                }
                                min2 = i2;
                            }
                        }
                        min2 = min2;
                    }
                    if (this.k) {
                        canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.A)), 5.0f, 15.0f, this.r0);
                        canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.C.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.C.y)), 5.0f, 35.0f, this.r0);
                        PointF center = getCenter();
                        canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.r0);
                        c cVar = this.k0;
                        if (cVar != null) {
                            PointF sourceToViewCoord = sourceToViewCoord(cVar.f46114c);
                            PointF sourceToViewCoord2 = sourceToViewCoord(this.k0.f46116e);
                            PointF sourceToViewCoord3 = sourceToViewCoord(this.k0.f46115d);
                            canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, 10.0f, this.r0);
                            canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, 20.0f, this.r0);
                            canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, 25.0f, this.r0);
                            canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.r0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f46103e != null) {
                    float f3 = this.A;
                    if (this.f46104f) {
                        f3 *= this.H / bitmap.getWidth();
                        f2 = this.A * (this.I / this.f46103e.getHeight());
                    } else {
                        f2 = f3;
                    }
                    if (this.u0 == null) {
                        this.u0 = new Matrix();
                    }
                    this.u0.reset();
                    this.u0.postScale(f3, f2);
                    this.u0.postRotate(getRequiredRotation());
                    Matrix matrix = this.u0;
                    PointF pointF = this.C;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.u0;
                        float f4 = this.A;
                        matrix2.postTranslate(this.H * f4, f4 * this.I);
                    } else if (getRequiredRotation() == 90) {
                        this.u0.postTranslate(this.A * this.I, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.u0.postTranslate(0.0f, this.A * this.H);
                    }
                    if (this.s0 != null) {
                        if (this.v0 == null) {
                            this.v0 = new RectF();
                        }
                        this.v0.set(0.0f, 0.0f, this.H, this.I);
                        this.u0.mapRect(this.v0);
                        canvas.drawRect(this.v0, this.s0);
                    }
                    Bitmap bitmap2 = this.f46103e;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    canvas.drawBitmap(this.f46103e, this.u0, this.q0);
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
            if (!this.l0 || center == null) {
                return;
            }
            this.k0 = null;
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
            c cVar = this.k0;
            if (cVar != null && !cVar.f46120i) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            c cVar2 = this.k0;
            if (cVar2 != null && cVar2.l != null) {
                try {
                    this.k0.l.a();
                } catch (Exception unused) {
                }
            }
            this.k0 = null;
            if (this.z0 && this.C == null) {
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
                                    boolean z2 = motionEvent.getY() > this.i0.y;
                                    this.i0.set(0.0f, motionEvent.getY());
                                    float abs2 = Math.abs(1.0f - (abs / this.c0)) * 0.5f;
                                    if (abs2 > 0.03f || this.j0) {
                                        this.j0 = true;
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
                                    float f11 = this.y0 * 5.0f;
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
                                            this.p0.removeMessages(1);
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
                            this.p0.removeMessages(1);
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
                this.p0.removeMessages(1);
                if (this.O) {
                    this.O = false;
                    if (!this.j0) {
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
            this.k0 = null;
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
                this.p0.removeMessages(1);
            } else if (!this.O) {
                PointF pointF15 = this.D;
                PointF pointF16 = this.C;
                pointF15.set(pointF16.x, pointF16.y);
                this.V.set(motionEvent.getX(), motionEvent.getY());
                this.p0.sendEmptyMessageDelayed(1, 600L);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || this.R == null || this.f46108j == null) {
            return;
        }
        int min = Math.min(this.f46107i, O(this.A));
        for (Map.Entry<Integer, List<i>> entry : this.f46108j.entrySet()) {
            for (i iVar : entry.getValue()) {
                if (iVar.f46141b < min || (iVar.f46141b > min && iVar.f46141b != this.f46107i)) {
                    iVar.f46144e = false;
                    if (iVar.f46142c != null) {
                        iVar.f46142c.recycle();
                        iVar.f46142c = null;
                    }
                }
                if (iVar.f46141b != min) {
                    if (iVar.f46141b == this.f46107i) {
                        iVar.f46144e = true;
                    }
                } else if (y0(iVar)) {
                    iVar.f46144e = true;
                    if (!iVar.f46143d && iVar.f46142c == null && z) {
                        Y(new j(this, this.R, iVar));
                    }
                } else if (iVar.f46141b != this.f46107i) {
                    iVar.f46144e = false;
                    if (iVar.f46142c != null) {
                        iVar.f46142c.recycle();
                        iVar.f46142c = null;
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
            this.f46107i = 0;
            this.V = null;
            this.W = 0.0f;
            this.b0 = null;
            this.c0 = 0.0f;
            this.i0 = null;
            this.j0 = false;
            this.k0 = null;
            this.t0 = null;
            this.u0 = null;
            this.v0 = null;
            if (z) {
                this.f46106h = null;
                if (this.R != null) {
                    synchronized (this.S) {
                        this.R.recycle();
                        this.R = null;
                    }
                }
                Bitmap bitmap = this.f46103e;
                if (bitmap != null && !this.f46105g) {
                    bitmap.recycle();
                }
                this.H = 0;
                this.I = 0;
                this.J = 0;
                this.K = null;
                this.L = null;
                this.l0 = false;
                this.m0 = false;
                this.f46103e = null;
                this.f46104f = false;
                this.f46105g = false;
            }
            Map<Integer, List<i>> map = this.f46108j;
            if (map != null) {
                for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                    for (i iVar : entry.getValue()) {
                        iVar.f46144e = false;
                        if (iVar.f46142c != null) {
                            iVar.f46142c.recycle();
                            iVar.f46142c = null;
                        }
                    }
                }
                this.f46108j = null;
            }
            setGestureDetector(getContext());
        }
    }

    public final void r0(ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, imageViewState) == null) || imageViewState == null || imageViewState.getCenter() == null || !D0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
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
            this.q0 = null;
            this.r0 = null;
            this.s0 = null;
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
            this.k0 = null;
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

    public final void setBitmapDecoderClass(Class<? extends c.a.p0.a.i1.e.d.c> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, cls) == null) {
            if (cls == null) {
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", "bitmapDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.T = new c.a.p0.a.i1.e.d.a(cls);
        }
    }

    public final void setBitmapDecoderFactory(c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.c> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bVar) == null) {
            if (bVar == null) {
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", "bitmapDecoderFactory is null");
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
            this.k = z;
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

    public final void setDoubleTapZoomStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!E0.contains(Integer.valueOf(i2))) {
                String str = "Invalid zoom style: " + i2;
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.y = i2;
        }
    }

    public final void setImage(c.a.p0.a.i1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, bVar) == null) {
            setImage(bVar, null, null);
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, drawable) == null) {
            c.a.p0.a.i1.e.c.b(getContext(), drawable);
            super.setImageDrawable(drawable);
        }
    }

    public void setIsDynamicBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.z0 = z;
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

    public final void setMinimumScaleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            if (!H0.contains(Integer.valueOf(i2))) {
                String str = "Invalid scale type: " + i2;
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", str);
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
            this.n0 = gVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, onLongClickListener) == null) {
            this.o0 = onLongClickListener;
        }
    }

    public final void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            if (!D0.contains(Integer.valueOf(i2))) {
                String str = "Invalid orientation: " + i2;
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", str);
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

    public final void setPanLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            if (!G0.contains(Integer.valueOf(i2))) {
                String str = "Invalid pan limit: " + i2;
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", str);
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

    public final void setRegionDecoderClass(Class<? extends c.a.p0.a.i1.e.d.d> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, cls) == null) {
            if (cls == null) {
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", "regionDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.U = new c.a.p0.a.i1.e.d.a(cls);
        }
    }

    public final void setRegionDecoderFactory(c.a.p0.a.i1.e.d.b<? extends c.a.p0.a.i1.e.d.d> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, bVar) == null) {
            if (bVar == null) {
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", "setRegionDecoderFactory is null");
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
            this.k0 = null;
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
                this.s0 = null;
            } else {
                Paint paint = new Paint();
                this.s0 = paint;
                paint.setStyle(Paint.Style.FILL);
                this.s0.setColor(i2);
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
            return A0(0.0f) <= ((float) iVar.f46140a.right) && ((float) iVar.f46140a.left) <= A0((float) getWidth()) && B0(0.0f) <= ((float) iVar.f46140a.bottom) && ((float) iVar.f46140a.top) <= B0((float) getHeight());
        }
        return invokeL.booleanValue;
    }

    public final PointF z0(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048682, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
            int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            if (this.t0 == null) {
                this.t0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.t0.f46138a = f4;
            this.t0.f46139b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
            b0(true, this.t0);
            return this.t0.f46139b;
        }
        return (PointF) invokeCommon.objValue;
    }

    public final void setImage(c.a.p0.a.i1.e.b bVar, ImageViewState imageViewState) {
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

    public final void setImage(c.a.p0.a.i1.e.b bVar, c.a.p0.a.i1.e.b bVar2) {
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

    public final void setImage(c.a.p0.a.i1.e.b bVar, c.a.p0.a.i1.e.b bVar2, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048644, this, bVar, bVar2, imageViewState) == null) {
            if (bVar == null) {
                if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", "imageSource is null");
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
                    if (!C0) {
                        c.a.p0.a.e0.d.h("HugePhotoDraweeView", "imageSource get bitmap is not null");
                        return;
                    }
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (bVar.g() > 0 && bVar.e() > 0) {
                    this.H = bVar.g();
                    this.I = bVar.e();
                    this.L = bVar2.f();
                    if (bVar2.c() != null) {
                        this.f46105g = bVar2.j();
                        l0(bVar2.c());
                    } else {
                        Uri i2 = bVar2.i();
                        if (i2 == null && bVar2.d() != null) {
                            i2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar2.d());
                        }
                        Y(new e(this, getContext(), this.T, i2, true));
                    }
                } else if (!C0) {
                    c.a.p0.a.e0.d.h("HugePhotoDraweeView", "imageSource width or height invalid");
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
                this.f46106h = i3;
                if (i3 == null && bVar.d() != null) {
                    this.f46106h = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar.d());
                }
                if (!bVar.h() && this.K == null) {
                    Y(new e(this, getContext(), this.T, this.f46106h, false));
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

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f46112a;

        /* renamed from: b  reason: collision with root package name */
        public float f46113b;

        /* renamed from: c  reason: collision with root package name */
        public PointF f46114c;

        /* renamed from: d  reason: collision with root package name */
        public PointF f46115d;

        /* renamed from: e  reason: collision with root package name */
        public PointF f46116e;

        /* renamed from: f  reason: collision with root package name */
        public PointF f46117f;

        /* renamed from: g  reason: collision with root package name */
        public PointF f46118g;

        /* renamed from: h  reason: collision with root package name */
        public long f46119h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f46120i;

        /* renamed from: j  reason: collision with root package name */
        public int f46121j;
        public long k;
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
            this.f46119h = 500L;
            this.f46120i = true;
            this.f46121j = 2;
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
