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
import com.baidu.tieba.ax2;
import com.baidu.tieba.bx2;
import com.baidu.tieba.cx2;
import com.baidu.tieba.dx2;
import com.baidu.tieba.ex2;
import com.baidu.tieba.fp1;
import com.baidu.tieba.fx2;
import com.baidu.tieba.gp1;
import com.baidu.tieba.gx2;
import com.baidu.tieba.w52;
import com.baidu.tieba.yw2;
import com.baidu.tieba.zw2;
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
/* loaded from: classes3.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A0;
    public static final List<Integer> B0;
    public static final List<Integer> C0;
    public static final List<Integer> D0;
    public static final List<Integer> E0;
    public static final List<Integer> F0;
    public static int G0;
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
    public ex2 N;
    public final Object O;
    public cx2<? extends dx2> P;
    public cx2<? extends ex2> Q;
    public PointF R;
    public float S;
    public final float T;
    public PointF U;
    public float V;
    public PointF W;
    public Bitmap a;
    public boolean a0;
    public boolean b;
    public c b0;
    public boolean c;
    public boolean c0;
    public Uri d;
    public boolean d0;
    public int e;
    public g e0;
    public Map<Integer, List<i>> f;
    public View.OnLongClickListener f0;
    public boolean g;
    public Handler g0;
    public int h;
    public Paint h0;
    public float i;
    public Paint i0;
    public float j;
    public Paint j0;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public h r0;
    public boolean s;
    public Matrix s0;
    public float t;
    public RectF t0;
    public int u;
    public float[] u0;
    public int v;
    public float[] v0;
    public float w;
    public float w0;
    public float x;
    public boolean x0;
    public PointF y;
    public ColorFilter y0;
    public PointF z;
    public int z0;

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b();

        void onComplete();
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
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

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
                if (message.what == 1 && this.a.f0 != null) {
                    this.a.L = 0;
                    HugePhotoDraweeView hugePhotoDraweeView = this.a;
                    HugePhotoDraweeView.super.setOnLongClickListener(hugePhotoDraweeView.f0);
                    this.a.performLongClick();
                    HugePhotoDraweeView.super.setOnLongClickListener(null);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                if (!this.b.r || !this.b.c0 || this.b.y == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                this.b.setGestureDetector(this.a);
                if (!this.b.s) {
                    HugePhotoDraweeView hugePhotoDraweeView = this.b;
                    hugePhotoDraweeView.T(hugePhotoDraweeView.J0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                this.b.R = new PointF(motionEvent.getX(), motionEvent.getY());
                this.b.z = new PointF(this.b.y.x, this.b.y.y);
                HugePhotoDraweeView hugePhotoDraweeView2 = this.b;
                hugePhotoDraweeView2.x = hugePhotoDraweeView2.w;
                this.b.K = true;
                this.b.I = true;
                HugePhotoDraweeView hugePhotoDraweeView3 = this.b;
                hugePhotoDraweeView3.U = hugePhotoDraweeView3.J0(hugePhotoDraweeView3.R);
                this.b.V = -1.0f;
                this.b.W = new PointF(this.b.U.x, this.b.U.y);
                this.b.a0 = false;
                return false;
            }
            return invokeL.booleanValue;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.a(com.baidu.swan.apps.media.image.HugePhotoDraweeView$d, boolean):com.baidu.swan.apps.media.image.HugePhotoDraweeView$d
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent r5, android.view.MotionEvent r6, float r7, float r8) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b.$ic
                if (r0 != 0) goto Lbf
            L4:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r4.b
                boolean r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.E(r0)
                if (r0 == 0) goto Lba
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r4.b
                boolean r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.K(r0)
                if (r0 == 0) goto Lba
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r4.b
                android.graphics.PointF r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.L(r0)
                if (r0 == 0) goto Lba
                if (r5 == 0) goto Lba
                if (r6 == 0) goto Lba
                float r0 = r5.getX()
                float r1 = r6.getX()
                float r0 = r0 - r1
                float r0 = java.lang.Math.abs(r0)
                r1 = 1112014848(0x42480000, float:50.0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L44
                float r0 = r5.getY()
                float r2 = r6.getY()
                float r0 = r0 - r2
                float r0 = java.lang.Math.abs(r0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto Lba
            L44:
                float r0 = java.lang.Math.abs(r7)
                r1 = 1140457472(0x43fa0000, float:500.0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L56
                float r0 = java.lang.Math.abs(r8)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto Lba
            L56:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r4.b
                boolean r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.M(r0)
                if (r0 != 0) goto Lba
                android.graphics.PointF r5 = new android.graphics.PointF
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r6 = r4.b
                android.graphics.PointF r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.L(r6)
                float r6 = r6.x
                r0 = 1048576000(0x3e800000, float:0.25)
                float r7 = r7 * r0
                float r6 = r6 + r7
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r7 = r4.b
                android.graphics.PointF r7 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.L(r7)
                float r7 = r7.y
                float r8 = r8 * r0
                float r7 = r7 + r8
                r5.<init>(r6, r7)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r6 = r4.b
                int r6 = r6.getWidth()
                int r6 = r6 / 2
                float r6 = (float) r6
                float r7 = r5.x
                float r6 = r6 - r7
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r7 = r4.b
                float r7 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b(r7)
                float r6 = r6 / r7
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r7 = r4.b
                int r7 = r7.getHeight()
                int r7 = r7 / 2
                float r7 = (float) r7
                float r5 = r5.y
                float r7 = r7 - r5
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r5 = r4.b
                float r5 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b(r5)
                float r7 = r7 / r5
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$d r5 = new com.baidu.swan.apps.media.image.HugePhotoDraweeView$d
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r8 = r4.b
                android.graphics.PointF r0 = new android.graphics.PointF
                r0.<init>(r6, r7)
                r6 = 0
                r5.<init>(r8, r0, r6)
                r6 = 1
                r5.d(r6)
                r7 = 0
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.a(r5, r7)
                r5.b()
                return r6
            Lba:
                boolean r5 = super.onFling(r5, r6, r7, r8)
                return r5
            Lbf:
                r3 = 4
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r1 = 0
                r3[r1] = r5
                r1 = 1
                r3[r1] = r6
                r1 = 2
                java.lang.Float r2 = java.lang.Float.valueOf(r7)
                r3[r1] = r2
                r1 = 3
                java.lang.Float r2 = java.lang.Float.valueOf(r8)
                r3[r1] = r2
                r1 = 1048577(0x100001, float:1.46937E-39)
                r2 = r4
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r0.invokeCommon(r1, r2, r3)
                if (r0 == 0) goto L4
                boolean r1 = r0.booleanValue
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.image.HugePhotoDraweeView.b.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
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

    /* loaded from: classes3.dex */
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

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF u(c cVar) {
            return cVar.c;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ boolean b(c cVar, boolean z) {
            cVar.i = z;
            return z;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ f d(c cVar, f fVar) {
            cVar.l = fVar;
            return fVar;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ long f(c cVar, long j) {
            cVar.k = j;
            return j;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ long h(c cVar, long j) {
            cVar.h = j;
            return j;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ int j(c cVar, int i) {
            cVar.j = i;
            return i;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ float l(c cVar, float f) {
            cVar.a = f;
            return f;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ float n(c cVar, float f) {
            cVar.b = f;
            return f;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF p(c cVar, PointF pointF) {
            cVar.f = pointF;
            return pointF;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF r(c cVar, PointF pointF) {
            cVar.g = pointF;
            return pointF;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF t(c cVar, PointF pointF) {
            cVar.d = pointF;
            return pointF;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF v(c cVar, PointF pointF) {
            cVar.c = pointF;
            return pointF;
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF x(c cVar, PointF pointF) {
            cVar.e = pointF;
            return pointF;
        }
    }

    /* loaded from: classes3.dex */
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

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, PointF pointF2, a aVar) {
            this(hugePhotoDraweeView, f, pointF, pointF2);
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, a aVar) {
            this(hugePhotoDraweeView, f, pointF);
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

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, PointF pointF, a aVar) {
            this(hugePhotoDraweeView, pointF);
        }

        /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
            */
        public static /* synthetic */ com.baidu.swan.apps.media.image.HugePhotoDraweeView.d a(com.baidu.swan.apps.media.image.HugePhotoDraweeView.d r0, boolean r1) {
            /*
                r0.f(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.a(com.baidu.swan.apps.media.image.HugePhotoDraweeView$d, boolean):com.baidu.swan.apps.media.image.HugePhotoDraweeView$d");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.swan.apps.media.image.HugePhotoDraweeView.I(com.baidu.swan.apps.media.image.HugePhotoDraweeView, float, float, float, android.graphics.PointF):android.graphics.PointF
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        public void b() {
            /*
                r9 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.$ic
                if (r0 != 0) goto L194
            L4:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                if (r0 == 0) goto L2e
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$f r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.c(r0)
                if (r0 == 0) goto L2e
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i     // Catch: java.lang.Exception -> L26
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)     // Catch: java.lang.Exception -> L26
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$f r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.c(r0)     // Catch: java.lang.Exception -> L26
                r0.b()     // Catch: java.lang.Exception -> L26
                goto L2e
            L26:
                r0 = move-exception
                java.lang.String r1 = "HugePhotoDraweeView"
                java.lang.String r2 = "Error thrown by animation listener"
                android.util.Log.w(r1, r2, r0)
            L2e:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                int r0 = r0.getPaddingLeft()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r1 = r9.i
                int r1 = r1.getWidth()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = r9.i
                int r2 = r2.getPaddingRight()
                int r1 = r1 - r2
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = r9.i
                int r2 = r2.getPaddingLeft()
                int r1 = r1 - r2
                int r1 = r1 / 2
                int r0 = r0 + r1
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r1 = r9.i
                int r1 = r1.getPaddingTop()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = r9.i
                int r2 = r2.getHeight()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                int r3 = r3.getPaddingBottom()
                int r2 = r2 - r3
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                int r3 = r3.getPaddingTop()
                int r2 = r2 - r3
                int r2 = r2 / 2
                int r1 = r1 + r2
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = r9.i
                float r3 = r9.a
                float r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.H(r2, r3)
                boolean r3 = r9.g
                if (r3 == 0) goto L85
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                android.graphics.PointF r4 = r9.b
                float r5 = r4.x
                float r4 = r4.y
                android.graphics.PointF r6 = new android.graphics.PointF
                r6.<init>()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.I(r3, r5, r4, r2, r6)
                goto L87
            L85:
                android.graphics.PointF r6 = r9.b
            L87:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r4 = new com.baidu.swan.apps.media.image.HugePhotoDraweeView$c
                r5 = 0
                r4.<init>(r5)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.G(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = r9.i
                float r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b(r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.l(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.n(r3, r2)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                long r7 = java.lang.System.currentTimeMillis()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.f(r3, r7)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.x(r3, r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = r9.i
                android.graphics.PointF r4 = r4.getCenter()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.v(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.t(r3, r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = r9.i
                android.graphics.PointF r4 = r4.B0(r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.p(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                android.graphics.PointF r4 = new android.graphics.PointF
                float r0 = (float) r0
                float r1 = (float) r1
                r4.<init>(r0, r1)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.r(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                long r3 = r9.d
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.h(r0, r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                boolean r1 = r9.f
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.b(r0, r1)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                int r1 = r9.e
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.j(r0, r1)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                long r3 = java.lang.System.currentTimeMillis()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.f(r0, r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$f r1 = r9.h
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.d(r0, r1)
                android.graphics.PointF r0 = r9.c
                if (r0 == 0) goto L18e
                float r0 = r0.x
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r1 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r1)
                android.graphics.PointF r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.u(r1)
                float r1 = r1.x
                float r1 = r1 * r2
                float r0 = r0 - r1
                android.graphics.PointF r1 = r9.c
                float r1 = r1.y
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                android.graphics.PointF r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.u(r3)
                float r3 = r3.y
                float r3 = r3 * r2
                float r1 = r1 - r3
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$h r3 = new com.baidu.swan.apps.media.image.HugePhotoDraweeView$h
                android.graphics.PointF r4 = new android.graphics.PointF
                r4.<init>(r0, r1)
                r3.<init>(r2, r4, r5)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = r9.i
                r4 = 1
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.J(r2, r4, r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = r9.i
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r2)
                android.graphics.PointF r4 = new android.graphics.PointF
                android.graphics.PointF r5 = r9.c
                float r5 = r5.x
                android.graphics.PointF r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.h.c(r3)
                float r6 = r6.x
                float r6 = r6 - r0
                float r5 = r5 + r6
                android.graphics.PointF r0 = r9.c
                float r0 = r0.y
                android.graphics.PointF r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.h.c(r3)
                float r3 = r3.y
                float r3 = r3 - r1
                float r0 = r0 + r3
                r4.<init>(r5, r0)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.r(r2, r4)
            L18e:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = r9.i
                r0.invalidate()
                return
            L194:
                r7 = r0
                r8 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r7.invokeV(r8, r9)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void");
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

        @SuppressLint({"BDThrowableCheck"})
        public d d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (!HugePhotoDraweeView.D0.contains(Integer.valueOf(i))) {
                    String str = "Unknown easing type: " + i;
                    if (!HugePhotoDraweeView.A0) {
                        w52.k("HugePhotoDraweeView", str);
                        return this;
                    }
                    throw new IllegalArgumentException(str);
                }
                this.e = i;
                return this;
            }
            return (d) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends AsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<Context> b;
        public final WeakReference<cx2<? extends dx2>> c;
        public final Uri d;
        public final boolean e;
        public Bitmap f;
        public Exception g;

        public e(HugePhotoDraweeView hugePhotoDraweeView, Context context, cx2<? extends dx2> cx2Var, Uri uri, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context, cx2Var, uri, Boolean.valueOf(z)};
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
            this.c = new WeakReference<>(cx2Var);
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
                    cx2<? extends dx2> cx2Var = this.c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    if (context != null && cx2Var != null && hugePhotoDraweeView != null) {
                        this.f = cx2Var.make().decode(context, this.d);
                        return Integer.valueOf(hugePhotoDraweeView.c0(uri));
                    }
                    return null;
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) && (hugePhotoDraweeView = this.a.get()) != null) {
                Bitmap bitmap = this.f;
                if (bitmap != null && num != null) {
                    if (this.e) {
                        hugePhotoDraweeView.n0(bitmap);
                    } else {
                        hugePhotoDraweeView.m0(bitmap, num.intValue(), false);
                    }
                } else if (this.g != null && hugePhotoDraweeView.e0 != null) {
                    if (this.e) {
                        hugePhotoDraweeView.e0.onPreviewLoadError(this.g);
                    } else {
                        hugePhotoDraweeView.e0.onImageLoadError(this.g);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public PointF b;

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

        public /* synthetic */ h(float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        /* JADX DEBUG: Marked for inline */
        /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
        public static /* synthetic */ PointF c(h hVar) {
            return hVar.b;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class j extends AsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<ex2> b;
        public final WeakReference<i> c;
        public Exception d;

        public j(HugePhotoDraweeView hugePhotoDraweeView, ex2 ex2Var, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, ex2Var, iVar};
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
            this.b = new WeakReference<>(ex2Var);
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
                    ex2 ex2Var = this.b.get();
                    i iVar = this.c.get();
                    if (ex2Var != null && iVar != null && hugePhotoDraweeView != null && ex2Var.isReady() && iVar.e) {
                        synchronized (hugePhotoDraweeView.O) {
                            hugePhotoDraweeView.Z(iVar.a, iVar.g);
                            if (hugePhotoDraweeView.G != null) {
                                iVar.g.offset(hugePhotoDraweeView.G.left, hugePhotoDraweeView.G.top);
                            }
                            decodeRegion = ex2Var.decodeRegion(iVar.g, iVar.b);
                        }
                        return decodeRegion;
                    } else if (iVar == null) {
                        return null;
                    } else {
                        iVar.d = false;
                        return null;
                    }
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
                if (hugePhotoDraweeView != null && iVar != null) {
                    if (bitmap != null) {
                        iVar.c = bitmap;
                        iVar.d = false;
                        hugePhotoDraweeView.p0();
                    } else if (this.d != null && hugePhotoDraweeView.e0 != null) {
                        hugePhotoDraweeView.e0.onTileLoadError(this.d);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends AsyncTask<Void, Void, int[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<Context> b;
        public final WeakReference<cx2<? extends ex2>> c;
        public zw2 d;
        public ex2 e;
        public Exception f;

        public k(HugePhotoDraweeView hugePhotoDraweeView, Context context, cx2<? extends ex2> cx2Var, zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hugePhotoDraweeView, context, cx2Var, zw2Var};
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
            this.c = new WeakReference<>(cx2Var);
            this.d = zw2Var;
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
                    cx2<? extends ex2> cx2Var = this.c.get();
                    HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                    if (context != null && cx2Var != null && hugePhotoDraweeView != null) {
                        this.e = cx2Var.make();
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
                    }
                    return null;
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) && (hugePhotoDraweeView = this.a.get()) != null) {
                ex2 ex2Var = this.e;
                if (ex2Var == null || iArr == null || iArr.length != 3) {
                    if (this.f != null && hugePhotoDraweeView.e0 != null) {
                        hugePhotoDraweeView.e0.onImageLoadError(this.f);
                        return;
                    }
                    return;
                }
                hugePhotoDraweeView.q0(ex2Var, iArr[0], iArr[1], iArr[2]);
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
        A0 = gp1.a;
        B0 = Arrays.asList(0, 90, 180, 270, -1);
        C0 = Arrays.asList(1, 2, 3);
        D0 = Arrays.asList(2, 1);
        E0 = Arrays.asList(1, 2, 3);
        F0 = Arrays.asList(2, 1, 3);
        G0 = Integer.MAX_VALUE;
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setDoubleTapZoomStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            if (!C0.contains(Integer.valueOf(i2))) {
                String str = "Invalid zoom style: " + i2;
                if (!A0) {
                    w52.k("HugePhotoDraweeView", str);
                    return;
                }
                throw new IllegalArgumentException(str);
            }
            this.u = i2;
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

    public final void w0(ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048668, this, imageViewState) == null) && imageViewState != null && imageViewState.getCenter() != null && B0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.h = imageViewState.getOrientation();
            this.A = Float.valueOf(imageViewState.getScale());
            this.B = imageViewState.getCenter();
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        zw2 a2;
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
        int i4 = G0;
        this.n = i4;
        this.o = i4;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = 5.0f;
        this.u = 1;
        this.v = 500;
        this.O = new Object();
        this.P = new bx2(fx2.class);
        this.Q = new bx2(gx2.class);
        this.u0 = new float[8];
        this.v0 = new float[8];
        this.x0 = false;
        this.y0 = null;
        this.z0 = 0;
        this.w0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(720);
        setGestureDetector(context);
        this.g0 = new Handler(new a(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, fp1.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(0) && (string = obtainStyledAttributes.getString(0)) != null && string.length() > 0 && (a2 = zw2.a(string)) != null) {
                a2.n();
                setImage(a2);
            }
            if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                zw2 k2 = zw2.k(resourceId);
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

    public final void b0(boolean z, h hVar) {
        float paddingLeft;
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
            if (getPaddingLeft() <= 0 && getPaddingRight() <= 0) {
                paddingLeft = 0.5f;
            } else {
                paddingLeft = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
            }
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

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
    public static /* synthetic */ c G(HugePhotoDraweeView hugePhotoDraweeView, c cVar) {
        hugePhotoDraweeView.b0 = cVar;
        return cVar;
    }

    public final PointF H0(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return I0(f2, f3, new PointF());
        }
        return (PointF) invokeCommon.objValue;
    }

    public final void setImage(zw2 zw2Var, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, zw2Var, imageViewState) == null) {
            setImage(zw2Var, null, imageViewState);
        }
    }

    public void setMaxTileSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048647, this, i2, i3) == null) {
            this.n = i2;
            this.o = i3;
        }
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Float.valueOf(f2), pointF}) == null) {
            this.b0 = null;
            this.A = Float.valueOf(f2);
            this.B = pointF;
            this.C = pointF;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048626, this, i2, i3, i4, i5) == null) {
            PointF center = getCenter();
            if (this.c0 && center != null) {
                this.b0 = null;
                this.A = Float.valueOf(this.w);
                this.B = center;
            }
        }
    }

    private int getRequiredRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            int i2 = this.h;
            if (i2 == -1) {
                return this.F;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            boolean g0 = g0();
            if (!this.d0 && g0) {
                r0();
                this.d0 = true;
                l0();
                g gVar = this.e0;
                if (gVar != null) {
                    gVar.onImageLoaded();
                }
            }
            return g0;
        }
        return invokeV.booleanValue;
    }

    public final int getAppliedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return getRequiredRotation();
        }
        return invokeV.intValue;
    }

    public final PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return H0(getWidth() / 2, getHeight() / 2);
        }
        return (PointF) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    public final float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return k0();
        }
        return invokeV.floatValue;
    }

    public final int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final int getSHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.E;
        }
        return invokeV.intValue;
    }

    public final int getSWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.w;
        }
        return invokeV.floatValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.c0;
        }
        return invokeV.booleanValue;
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && this.w < k0()) {
            v0();
        }
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

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
    public static /* synthetic */ float b(HugePhotoDraweeView hugePhotoDraweeView) {
        return hugePhotoDraweeView.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, context) == null) {
            this.M = new GestureDetector(context, new b(this, context));
        }
    }

    public final PointF B0(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pointF)) == null) {
            return A0(pointF.x, pointF.y, new PointF());
        }
        return (PointF) invokeL.objValue;
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

    public final PointF J0(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, pointF)) == null) {
            return I0(pointF.x, pointF.y, new PointF());
        }
        return (PointF) invokeL.objValue;
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderClass(Class<? extends dx2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, cls) == null) {
            if (cls == null) {
                if (!A0) {
                    w52.k("HugePhotoDraweeView", "bitmapDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.P = new bx2(cls);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderFactory(cx2<? extends dx2> cx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, cx2Var) == null) {
            if (cx2Var == null) {
                if (!A0) {
                    w52.k("HugePhotoDraweeView", "bitmapDecoderFactory is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder factory cannot be set to null");
            }
            this.P = cx2Var;
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

    public final void setImage(zw2 zw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, zw2Var) == null) {
            setImage(zw2Var, null, null);
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, drawable) == null) {
            ax2.b(getContext(), drawable);
            super.setImageDrawable(drawable);
        }
    }

    public void setIsDynamicBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.x0 = z;
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

    public void setOnImageEventListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, gVar) == null) {
            this.e0 = gVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onLongClickListener) == null) {
            this.f0 = onLongClickListener;
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
    public final void setRegionDecoderClass(Class<? extends ex2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, cls) == null) {
            if (cls == null) {
                if (!A0) {
                    w52.k("HugePhotoDraweeView", "regionDecoderClass is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder class cannot be set to null");
            }
            this.Q = new bx2(cls);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderFactory(cx2<? extends ex2> cx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, cx2Var) == null) {
            if (cx2Var == null) {
                if (!A0) {
                    w52.k("HugePhotoDraweeView", "setRegionDecoderFactory is null");
                    return;
                }
                throw new IllegalArgumentException("Decoder factory cannot be set to null");
            }
            this.Q = cx2Var;
        }
    }

    public final void setTileBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i2) == null) {
            if (Color.alpha(i2) == 0) {
                this.j0 = null;
            } else {
                Paint paint = new Paint();
                this.j0 = paint;
                paint.setStyle(Paint.Style.FILL);
                this.j0.setColor(i2);
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

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ android.graphics.PointF I(com.baidu.swan.apps.media.image.HugePhotoDraweeView r0, float r1, float r2, float r3, android.graphics.PointF r4) {
        /*
            r0.i0(r1, r2, r3, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.image.HugePhotoDraweeView.I(com.baidu.swan.apps.media.image.HugePhotoDraweeView, float, float, float, android.graphics.PointF):android.graphics.PointF");
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
    public static /* synthetic */ void J(HugePhotoDraweeView hugePhotoDraweeView, boolean z, h hVar) {
        hugePhotoDraweeView.b0(z, hVar);
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

    public final Rect C0(Rect rect, Rect rect2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rect, rect2)) == null) {
            rect2.set((int) D0(rect.left), (int) E0(rect.top), (int) D0(rect.right), (int) E0(rect.bottom));
            return rect2;
        }
        return (Rect) invokeLL.objValue;
    }

    public final boolean F0(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iVar)) == null) {
            float K0 = K0(0.0f);
            float K02 = K0(getWidth());
            float L0 = L0(0.0f);
            float L02 = L0(getHeight());
            if (K0 <= iVar.a.right && iVar.a.left <= K02 && L0 <= iVar.a.bottom && iVar.a.top <= L02) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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

    public final synchronized void n0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bitmap) == null) {
            synchronized (this) {
                if (this.a == null && !this.d0) {
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setMinimumScaleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            if (!F0.contains(Integer.valueOf(i2))) {
                String str = "Invalid scale type: " + i2;
                if (!A0) {
                    w52.k("HugePhotoDraweeView", str);
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            if (!B0.contains(Integer.valueOf(i2))) {
                String str = "Invalid orientation: " + i2;
                if (!A0) {
                    w52.k("HugePhotoDraweeView", str);
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
            if (!z && (pointF = this.y) != null) {
                pointF.x = (getWidth() / 2) - (this.w * (y0() / 2));
                this.y.y = (getHeight() / 2) - (this.w * (x0() / 2));
                if (h0()) {
                    s0(true);
                    invalidate();
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setPanLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            if (!E0.contains(Integer.valueOf(i2))) {
                String str = "Invalid pan limit: " + i2;
                if (!A0) {
                    w52.k("HugePhotoDraweeView", str);
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

    public final PointF G0(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
            int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            if (this.r0 == null) {
                this.r0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.r0.a = f4;
            this.r0.b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
            b0(true, this.r0);
            return this.r0.b;
        }
        return (PointF) invokeCommon.objValue;
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

    public final int O(float f2) {
        InterceptResult invokeF;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            if (this.k > 0) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                f2 *= this.k / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
            }
            int y0 = (int) (y0() * f2);
            int x0 = (int) (x0() * f2);
            if (y0 != 0 && x0 != 0) {
                int i2 = 1;
                if (x0() <= x0 && y0() <= y0) {
                    round = 1;
                } else {
                    round = Math.round(x0() / x0);
                    int round2 = Math.round(y0() / y0);
                    if (round >= round2) {
                        round = round2;
                    }
                }
                while (true) {
                    int i3 = i2 * 2;
                    if (i3 < round) {
                        i2 = i3;
                    } else {
                        return i2;
                    }
                }
            } else {
                return 32;
            }
        } else {
            return invokeF.intValue;
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
            if (this.r0 == null) {
                this.r0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
            }
            this.r0.a = this.w;
            this.r0.b.set(this.y);
            b0(z, this.r0);
            this.w = this.r0.a;
            this.y.set(this.r0.b);
            if (z2) {
                this.y.set(G0(y0() / 2, x0() / 2, this.w));
            }
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (getWidth() > 0 && getHeight() > 0 && this.D > 0 && this.E > 0 && (this.a != null || g0())) {
                z = true;
            } else {
                z = false;
            }
            if (!this.c0 && z) {
                r0();
                this.c0 = true;
                o0();
                g gVar = this.e0;
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
            if (this.h0 == null) {
                Paint paint = new Paint();
                this.h0 = paint;
                paint.setAntiAlias(true);
                this.h0.setFilterBitmap(true);
                this.h0.setDither(true);
            }
            if (this.i0 == null && this.g) {
                Paint paint2 = new Paint();
                this.i0 = paint2;
                paint2.setTextSize(18.0f);
                this.i0.setColor(-65281);
                this.i0.setStyle(Paint.Style.STROKE);
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
        boolean z;
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
            if (this.w <= min * 0.9d) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                min = k0();
            }
            float f2 = min;
            int i2 = this.u;
            if (i2 == 3) {
                setScaleAndCenter(f2, pointF);
            } else if (i2 != 2 && z && this.q) {
                if (i2 == 1) {
                    d dVar = new d(this, f2, pointF, pointF2, null);
                    dVar.e(false);
                    dVar.c(this.v);
                    dVar.b();
                }
            } else {
                d dVar2 = new d(this, f2, pointF, (a) null);
                dVar2.e(false);
                dVar2.c(this.v);
                dVar2.b();
            }
            invalidate();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.h0 != null) {
            if (this.z0 != ax2.d(getContext())) {
                this.z0 = ax2.d(getContext());
                this.y0 = new PorterDuffColorFilter(this.z0, PorterDuff.Mode.SRC_ATOP);
            }
            this.h0.setColorFilter(this.y0);
        }
    }

    public final ImageViewState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.y != null && this.D > 0 && this.E > 0) {
                return new ImageViewState(getScale(), getCenter(), getOrientation());
            }
            return null;
        }
        return (ImageViewState) invokeV.objValue;
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

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.b0 = null;
            this.A = Float.valueOf(j0(0.0f));
            if (h0()) {
                this.B = new PointF(y0() / 2, x0() / 2);
            } else {
                this.B = new PointF(0.0f, 0.0f);
            }
            invalidate();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final float V(int i2, long j2, float f2, float f3, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j3)})) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    String str = "Unexpected easing type: " + i2;
                    if (!A0) {
                        w52.k("HugePhotoDraweeView", str);
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
                                if (B0.contains(Integer.valueOf(i3)) && i3 != -1) {
                                    i2 = i3;
                                } else {
                                    Log.w("HugePhotoDraweeView", "Unsupported orientation: " + i3);
                                }
                            }
                            yw2.a(cursor);
                        }
                    } finally {
                        yw2.a(cursor);
                    }
                } catch (Exception unused) {
                    Log.w("HugePhotoDraweeView", "Could not get orientation of image from media store");
                }
                return i2;
            } else if (!str.startsWith(ImageSource.FILE_SCHEME) || str.startsWith("file:///android_asset/")) {
                return 0;
            } else {
                try {
                    int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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

    public final void f0(Point point) {
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, point) == null) {
            this.f = new LinkedHashMap();
            int i4 = this.e;
            int i5 = 1;
            int i6 = 1;
            int i7 = 1;
            while (true) {
                int y0 = y0() / i6;
                int x0 = x0() / i7;
                int i8 = y0 / i4;
                int i9 = x0 / i4;
                while (true) {
                    if (i8 + i6 + i5 > point.x || (i8 > getWidth() * 1.25d && i4 < this.e)) {
                        i6++;
                        y0 = y0() / i6;
                        i8 = y0 / i4;
                    }
                }
                while (true) {
                    if (i9 + i7 + i5 > point.y || (i9 > getHeight() * 1.25d && i4 < this.e)) {
                        i7++;
                        x0 = x0() / i7;
                        i9 = x0 / i4;
                    }
                }
                ArrayList arrayList = new ArrayList(i6 * i7);
                for (int i10 = 0; i10 < i6; i10++) {
                    for (int i11 = 0; i11 < i7; i11++) {
                        i iVar = new i(null);
                        iVar.b = i4;
                        if (i4 == this.e) {
                            z = true;
                        } else {
                            z = false;
                        }
                        iVar.e = z;
                        int i12 = i10 * y0;
                        int i13 = i11 * x0;
                        if (i10 == i6 - 1) {
                            i2 = y0();
                        } else {
                            i2 = (i10 + 1) * y0;
                        }
                        if (i11 == i7 - 1) {
                            i3 = x0();
                        } else {
                            i3 = (i11 + 1) * x0;
                        }
                        iVar.a = new Rect(i12, i13, i2, i3);
                        iVar.f = new Rect(0, 0, 0, 0);
                        iVar.g = new Rect(iVar.a);
                        arrayList.add(iVar);
                    }
                }
                this.f.put(Integer.valueOf(i4), arrayList);
                i5 = 1;
                if (i4 == 1) {
                    return;
                }
                i4 /= 2;
            }
        }
    }

    public final void s0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && this.N != null && this.f != null) {
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
                    if (iVar.b == min) {
                        if (F0(iVar)) {
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
                    } else if (iVar.b == this.e) {
                        iVar.e = true;
                    }
                }
            }
        }
    }

    public final synchronized void e0(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, point) == null) {
            synchronized (this) {
                h hVar = new h(0.0f, new PointF(0.0f, 0.0f), null);
                this.r0 = hVar;
                b0(true, hVar);
                int O = O(this.r0.a);
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
            this.a0 = false;
            this.b0 = null;
            this.r0 = null;
            this.s0 = null;
            this.t0 = null;
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
                this.c0 = false;
                this.d0 = false;
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

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            boolean z = true;
            if (this.a != null && !this.b) {
                return true;
            }
            Map<Integer, List<i>> map = this.f;
            if (map == null) {
                return false;
            }
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
        return invokeV.booleanValue;
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

    public final void r0() {
        Float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && getWidth() != 0 && getHeight() != 0 && this.D > 0 && this.E > 0) {
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
    }

    public final PointF i0(float f2, float f3, float f4, PointF pointF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), pointF})) == null) {
            PointF G02 = G0(f2, f3, f4);
            pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - G02.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - G02.y) / f4);
            return pointF;
        }
        return (PointF) invokeCommon.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, canvas) == null) {
            if (this.x0) {
                if (this.z0 != ax2.d(getContext())) {
                    ax2.b(getContext(), getDrawable());
                    this.z0 = ax2.d(getContext());
                }
                super.onDraw(canvas);
                return;
            }
            R();
            U();
            if (this.D != 0 && this.E != 0 && getWidth() != 0 && getHeight() != 0) {
                if (this.f == null && this.N != null) {
                    e0(d0(canvas));
                }
                if (!Q()) {
                    return;
                }
                r0();
                if (this.b0 != null) {
                    long currentTimeMillis = System.currentTimeMillis() - this.b0.k;
                    if (currentTimeMillis > this.b0.h) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long min = Math.min(currentTimeMillis, this.b0.h);
                    this.w = V(this.b0.j, min, this.b0.a, this.b0.b - this.b0.a, this.b0.h);
                    float V = V(this.b0.j, min, this.b0.f.x, this.b0.g.x - this.b0.f.x, this.b0.h);
                    float V2 = V(this.b0.j, min, this.b0.f.y, this.b0.g.y - this.b0.f.y, this.b0.h);
                    this.y.x -= D0(this.b0.d.x) - V;
                    this.y.y -= E0(this.b0.d.y) - V2;
                    if (!z && this.b0.a != this.b0.b) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    a0(z2);
                    s0(z);
                    if (z) {
                        if (this.b0.l != null) {
                            try {
                                this.b0.l.onComplete();
                            } catch (Exception e2) {
                                Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                            }
                        }
                        this.b0 = null;
                    }
                    invalidate();
                }
                if (this.f != null && g0()) {
                    int min2 = Math.min(this.e, O(this.w));
                    boolean z3 = false;
                    for (Map.Entry<Integer, List<i>> entry : this.f.entrySet()) {
                        if (entry.getKey().intValue() == min2) {
                            for (i iVar : entry.getValue()) {
                                if (iVar.e && (iVar.d || iVar.c == null)) {
                                    z3 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry<Integer, List<i>> entry2 : this.f.entrySet()) {
                        if (entry2.getKey().intValue() == min2 || z3) {
                            for (i iVar2 : entry2.getValue()) {
                                C0(iVar2.a, iVar2.f);
                                if (!iVar2.d && iVar2.c != null) {
                                    if (this.j0 != null) {
                                        canvas.drawRect(iVar2.f, this.j0);
                                    }
                                    if (this.s0 == null) {
                                        this.s0 = new Matrix();
                                    }
                                    this.s0.reset();
                                    z0(this.u0, 0.0f, 0.0f, iVar2.c.getWidth(), 0.0f, iVar2.c.getWidth(), iVar2.c.getHeight(), 0.0f, iVar2.c.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        z0(this.v0, iVar2.f.left, iVar2.f.top, iVar2.f.right, iVar2.f.top, iVar2.f.right, iVar2.f.bottom, iVar2.f.left, iVar2.f.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        z0(this.v0, iVar2.f.right, iVar2.f.top, iVar2.f.right, iVar2.f.bottom, iVar2.f.left, iVar2.f.bottom, iVar2.f.left, iVar2.f.top);
                                    } else if (getRequiredRotation() == 180) {
                                        z0(this.v0, iVar2.f.right, iVar2.f.bottom, iVar2.f.left, iVar2.f.bottom, iVar2.f.left, iVar2.f.top, iVar2.f.right, iVar2.f.top);
                                    } else if (getRequiredRotation() == 270) {
                                        z0(this.v0, iVar2.f.left, iVar2.f.bottom, iVar2.f.left, iVar2.f.top, iVar2.f.right, iVar2.f.top, iVar2.f.right, iVar2.f.bottom);
                                    }
                                    this.s0.setPolyToPoly(this.u0, 0, this.v0, 0, 4);
                                    canvas.drawBitmap(iVar2.c, this.s0, this.h0);
                                    if (this.g) {
                                        canvas.drawRect(iVar2.f, this.i0);
                                    }
                                } else if (iVar2.d && this.g) {
                                    canvas.drawText("LOADING", iVar2.f.left + 5, iVar2.f.top + 35, this.i0);
                                }
                                if (iVar2.e && this.g) {
                                    canvas.drawText("ISS " + iVar2.b + " RECT " + iVar2.a.top + "," + iVar2.a.left + "," + iVar2.a.bottom + "," + iVar2.a.right, iVar2.f.left + 5, iVar2.f.top + 15, this.i0);
                                }
                            }
                        }
                    }
                    if (this.g) {
                        canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.w)), 5.0f, 15.0f, this.i0);
                        canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.y.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.y.y)), 5.0f, 35.0f, this.i0);
                        PointF center = getCenter();
                        canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.i0);
                        c cVar = this.b0;
                        if (cVar != null) {
                            PointF B02 = B0(cVar.c);
                            PointF B03 = B0(this.b0.e);
                            PointF B04 = B0(this.b0.d);
                            canvas.drawCircle(B02.x, B02.y, 10.0f, this.i0);
                            canvas.drawCircle(B03.x, B03.y, 20.0f, this.i0);
                            canvas.drawCircle(B04.x, B04.y, 25.0f, this.i0);
                            canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.i0);
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
                    if (this.s0 == null) {
                        this.s0 = new Matrix();
                    }
                    this.s0.reset();
                    this.s0.postScale(f3, f2);
                    this.s0.postRotate(getRequiredRotation());
                    Matrix matrix = this.s0;
                    PointF pointF = this.y;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.s0;
                        float f4 = this.w;
                        matrix2.postTranslate(this.D * f4, f4 * this.E);
                    } else if (getRequiredRotation() == 90) {
                        this.s0.postTranslate(this.w * this.E, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.s0.postTranslate(0.0f, this.w * this.D);
                    }
                    if (this.j0 != null) {
                        if (this.t0 == null) {
                            this.t0 = new RectF();
                        }
                        this.t0.set(0.0f, 0.0f, this.D, this.E);
                        this.s0.mapRect(this.t0);
                        canvas.drawRect(this.t0, this.j0);
                    }
                    Bitmap bitmap2 = this.a;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        canvas.drawBitmap(this.a, this.s0, this.h0);
                    } else {
                        Log.i("HugePhotoDraweeView", "onDraw-> Bitmap is NULL or Recycled <--");
                    }
                }
            }
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048625, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            boolean z2 = true;
            if (mode != 1073741824) {
                z = true;
            } else {
                z = false;
            }
            if (mode2 == 1073741824) {
                z2 = false;
            }
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

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
        if (r6 != 262) goto L55;
     */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        GestureDetector gestureDetector;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            c cVar = this.b0;
            if (cVar != null && !cVar.i) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            c cVar2 = this.b0;
            if (cVar2 != null && cVar2.l != null) {
                try {
                    this.b0.l.a();
                } catch (Exception e2) {
                    Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                }
            }
            this.b0 = null;
            if (this.x0 && this.y == null) {
                this.y = new PointF();
            }
            if (this.y == null) {
                return true;
            }
            boolean z5 = false;
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
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action != 6) {
                                    if (action != 261) {
                                    }
                                }
                            }
                        }
                    } else {
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
                                        z5 = true;
                                    }
                                }
                            } else {
                                if (this.K) {
                                    float abs = (Math.abs(this.R.y - motionEvent.getY()) * 2.0f) + this.T;
                                    if (this.V == -1.0f) {
                                        this.V = abs;
                                    }
                                    if (motionEvent.getY() > this.W.y) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    this.W.set(0.0f, motionEvent.getY());
                                    float f7 = 1.0f;
                                    float abs2 = Math.abs(1.0f - (abs / this.V)) * 0.5f;
                                    if (abs2 > 0.03f || this.a0) {
                                        this.a0 = true;
                                        if (this.V > 0.0f) {
                                            if (z4) {
                                                f7 = abs2 + 1.0f;
                                            } else {
                                                f7 = 1.0f - abs2;
                                            }
                                        }
                                        float max = Math.max(k0(), Math.min(this.j, this.w * f7));
                                        this.w = max;
                                        if (this.q) {
                                            PointF pointF5 = this.R;
                                            float f8 = pointF5.x;
                                            PointF pointF6 = this.z;
                                            float f9 = pointF5.y;
                                            float f10 = this.x;
                                            float f11 = (f9 - pointF6.y) * (max / f10);
                                            PointF pointF7 = this.y;
                                            pointF7.x = f8 - ((f8 - pointF6.x) * (max / f10));
                                            pointF7.y = f9 - f11;
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
                                    float f12 = this.w0 * 5.0f;
                                    int i2 = (abs3 > f12 ? 1 : (abs3 == f12 ? 0 : -1));
                                    if (i2 > 0 || abs4 > f12 || this.J) {
                                        this.y.x = this.z.x + (motionEvent.getX() - this.R.x);
                                        this.y.y = this.z.y + (motionEvent.getY() - this.R.y);
                                        PointF pointF8 = this.y;
                                        float f13 = pointF8.x;
                                        float f14 = pointF8.y;
                                        a0(true);
                                        if (f13 != this.y.x) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z && abs3 > abs4 && !this.J) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (f14 == this.y.y && abs4 > f12 * 3.0f) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (!z2 && (!z || z3 || this.J)) {
                                            this.J = true;
                                        } else if (i2 > 0) {
                                            this.L = 0;
                                            this.g0.removeMessages(1);
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
                                z5 = true;
                            }
                        }
                        if (z5) {
                            this.g0.removeMessages(1);
                            invalidate();
                            return true;
                        }
                    }
                    return super.onTouchEvent(motionEvent);
                }
                u0();
                this.g0.removeMessages(1);
                if (this.K) {
                    this.K = false;
                    if (!this.a0) {
                        T(this.U, this.R);
                    }
                }
                if (this.L > 0 && (this.I || this.J)) {
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
                if (pointerCount == 1) {
                    this.I = false;
                    this.J = false;
                    this.L = 0;
                }
                return true;
            }
            this.b0 = null;
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
                this.g0.removeMessages(1);
            } else if (!this.K) {
                PointF pointF15 = this.z;
                PointF pointF16 = this.y;
                pointF15.set(pointF16.x, pointF16.y);
                this.R.set(motionEvent.getX(), motionEvent.getY());
                this.g0.sendEmptyMessageDelayed(1, 600L);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void q0(ex2 ex2Var, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048629, this, ex2Var, i2, i3, i4) == null) {
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
                this.N = ex2Var;
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

    public final void setImage(zw2 zw2Var, zw2 zw2Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, zw2Var, zw2Var2) == null) {
            setImage(zw2Var, zw2Var2, null);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setImage(zw2 zw2Var, zw2 zw2Var2, ImageViewState imageViewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048642, this, zw2Var, zw2Var2, imageViewState) == null) {
            if (zw2Var == null) {
                if (!A0) {
                    w52.k("HugePhotoDraweeView", "imageSource is null");
                    return;
                }
                throw new NullPointerException("imageSource must not be null");
            }
            t0(true);
            if (imageViewState != null) {
                w0(imageViewState);
            }
            if (zw2Var2 != null) {
                if (zw2Var.c() != null) {
                    if (!A0) {
                        w52.k("HugePhotoDraweeView", "imageSource get bitmap is not null");
                        return;
                    }
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (zw2Var.g() > 0 && zw2Var.e() > 0) {
                    this.D = zw2Var.g();
                    this.E = zw2Var.e();
                    this.H = zw2Var2.f();
                    if (zw2Var2.c() != null) {
                        this.c = zw2Var2.j();
                        n0(zw2Var2.c());
                    } else {
                        Uri i2 = zw2Var2.i();
                        if (i2 == null && zw2Var2.d() != null) {
                            i2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + zw2Var2.d());
                        }
                        Y(new e(this, getContext(), this.P, i2, true));
                    }
                } else if (!A0) {
                    w52.k("HugePhotoDraweeView", "imageSource width or height invalid");
                    return;
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                }
            }
            if (zw2Var.c() != null && zw2Var.f() != null) {
                m0(Bitmap.createBitmap(zw2Var.c(), zw2Var.f().left, zw2Var.f().top, zw2Var.f().width(), zw2Var.f().height()), 0, false);
            } else if (zw2Var.c() != null && !zw2Var.h()) {
                m0(zw2Var.c(), 0, zw2Var.j());
            } else {
                this.G = zw2Var.f();
                Uri i3 = zw2Var.i();
                this.d = i3;
                if (i3 == null && zw2Var.d() != null) {
                    this.d = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + zw2Var.d());
                }
                if (!zw2Var.h() && this.G == null) {
                    Y(new e(this, getContext(), this.P, this.d, false));
                } else {
                    Y(new k(this, getContext(), this.Q, zw2Var));
                }
            }
        }
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
}
