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
import com.baidu.tieba.az2;
import com.baidu.tieba.bz2;
import com.baidu.tieba.cz2;
import com.baidu.tieba.dz2;
import com.baidu.tieba.ez2;
import com.baidu.tieba.fz2;
import com.baidu.tieba.gz2;
import com.baidu.tieba.hr1;
import com.baidu.tieba.hz2;
import com.baidu.tieba.ir1;
import com.baidu.tieba.iz2;
import com.baidu.tieba.y72;
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
/* loaded from: classes4.dex */
public class HugePhotoDraweeView extends SimpleDraweeView {
    public static final boolean A0 = ir1.a;
    public static final List<Integer> B0 = Arrays.asList(0, 90, 180, 270, -1);
    public static final List<Integer> C0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> D0 = Arrays.asList(2, 1);
    public static final List<Integer> E0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> F0 = Arrays.asList(2, 1, 3);
    public static int G0 = Integer.MAX_VALUE;
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
    public gz2 N;
    public final Object O;
    public ez2<? extends fz2> P;
    public ez2<? extends gz2> Q;
    public PointF R;
    public float S;

    /* renamed from: T  reason: collision with root package name */
    public final float f1073T;
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

    /* loaded from: classes4.dex */
    public interface f {
        void a();

        void b();

        void onComplete();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public final float W(long j2, float f2, float f3, long j3) {
        float f4;
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

    public final float X(long j2, float f2, float f3, long j3) {
        float f4 = ((float) j2) / ((float) j3);
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    public void l0() {
    }

    public void o0() {
    }

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && HugePhotoDraweeView.this.f0 != null) {
                HugePhotoDraweeView.this.L = 0;
                HugePhotoDraweeView hugePhotoDraweeView = HugePhotoDraweeView.this;
                HugePhotoDraweeView.super.setOnLongClickListener(hugePhotoDraweeView.f0);
                HugePhotoDraweeView.this.performLongClick();
                HugePhotoDraweeView.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!HugePhotoDraweeView.this.r || !HugePhotoDraweeView.this.c0 || HugePhotoDraweeView.this.y == null) {
                return super.onDoubleTapEvent(motionEvent);
            }
            HugePhotoDraweeView.this.setGestureDetector(this.a);
            if (HugePhotoDraweeView.this.s) {
                HugePhotoDraweeView.this.R = new PointF(motionEvent.getX(), motionEvent.getY());
                HugePhotoDraweeView.this.z = new PointF(HugePhotoDraweeView.this.y.x, HugePhotoDraweeView.this.y.y);
                HugePhotoDraweeView hugePhotoDraweeView = HugePhotoDraweeView.this;
                hugePhotoDraweeView.x = hugePhotoDraweeView.w;
                HugePhotoDraweeView.this.K = true;
                HugePhotoDraweeView.this.I = true;
                HugePhotoDraweeView hugePhotoDraweeView2 = HugePhotoDraweeView.this;
                hugePhotoDraweeView2.U = hugePhotoDraweeView2.J0(hugePhotoDraweeView2.R);
                HugePhotoDraweeView.this.V = -1.0f;
                HugePhotoDraweeView.this.W = new PointF(HugePhotoDraweeView.this.U.x, HugePhotoDraweeView.this.U.y);
                HugePhotoDraweeView.this.a0 = false;
                return false;
            }
            HugePhotoDraweeView hugePhotoDraweeView3 = HugePhotoDraweeView.this;
            hugePhotoDraweeView3.T(hugePhotoDraweeView3.J0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
            return true;
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
        public boolean onFling(android.view.MotionEvent r4, android.view.MotionEvent r5, float r6, float r7) {
            /*
                r3 = this;
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                boolean r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.E(r0)
                if (r0 == 0) goto Lb6
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                boolean r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.K(r0)
                if (r0 == 0) goto Lb6
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.L(r0)
                if (r0 == 0) goto Lb6
                if (r4 == 0) goto Lb6
                if (r5 == 0) goto Lb6
                float r0 = r4.getX()
                float r1 = r5.getX()
                float r0 = r0 - r1
                float r0 = java.lang.Math.abs(r0)
                r1 = 1112014848(0x42480000, float:50.0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L40
                float r0 = r4.getY()
                float r2 = r5.getY()
                float r0 = r0 - r2
                float r0 = java.lang.Math.abs(r0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto Lb6
            L40:
                float r0 = java.lang.Math.abs(r6)
                r1 = 1140457472(0x43fa0000, float:500.0)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L52
                float r0 = java.lang.Math.abs(r7)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto Lb6
            L52:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                boolean r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.M(r0)
                if (r0 != 0) goto Lb6
                android.graphics.PointF r4 = new android.graphics.PointF
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r5 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r5 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.L(r5)
                float r5 = r5.x
                r0 = 1048576000(0x3e800000, float:0.25)
                float r6 = r6 * r0
                float r5 = r5 + r6
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.L(r6)
                float r6 = r6.y
                float r7 = r7 * r0
                float r6 = r6 + r7
                r4.<init>(r5, r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r5 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r5 = r5.getWidth()
                int r5 = r5 / 2
                float r5 = (float) r5
                float r6 = r4.x
                float r5 = r5 - r6
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                float r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b(r6)
                float r5 = r5 / r6
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r6 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r6 = r6.getHeight()
                int r6 = r6 / 2
                float r6 = (float) r6
                float r4 = r4.y
                float r6 = r6 - r4
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                float r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b(r4)
                float r6 = r6 / r4
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$d r4 = new com.baidu.swan.apps.media.image.HugePhotoDraweeView$d
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r7 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r0 = new android.graphics.PointF
                r0.<init>(r5, r6)
                r5 = 0
                r4.<init>(r7, r0, r5)
                r5 = 1
                r4.d(r5)
                r6 = 0
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.a(r4, r6)
                r4.b()
                return r5
            Lb6:
                boolean r4 = super.onFling(r4, r5, r6, r7)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.image.HugePhotoDraweeView.b.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HugePhotoDraweeView.this.performClick();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
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

    /* loaded from: classes4.dex */
    public final class d {
        public final float a;
        public final PointF b;
        public final PointF c;
        public long d;
        public int e;
        public boolean f;
        public boolean g;
        public f h;

        public d(float f, PointF pointF) {
            this.d = 500L;
            this.e = 2;
            this.f = true;
            this.g = true;
            this.a = f;
            this.b = pointF;
            this.c = null;
        }

        public d(float f, PointF pointF, PointF pointF2) {
            this.d = 500L;
            this.e = 2;
            this.f = true;
            this.g = true;
            this.a = f;
            this.b = pointF;
            this.c = pointF2;
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, PointF pointF2, a aVar) {
            this(f, pointF, pointF2);
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f, PointF pointF, a aVar) {
            this(f, pointF);
        }

        public d(PointF pointF) {
            this.d = 500L;
            this.e = 2;
            this.f = true;
            this.g = true;
            this.a = HugePhotoDraweeView.this.w;
            this.b = pointF;
            this.c = null;
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

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, PointF pointF, a aVar) {
            this(pointF);
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
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                if (r0 == 0) goto L2a
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$f r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.c(r0)
                if (r0 == 0) goto L2a
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this     // Catch: java.lang.Exception -> L22
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)     // Catch: java.lang.Exception -> L22
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$f r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.c(r0)     // Catch: java.lang.Exception -> L22
                r0.b()     // Catch: java.lang.Exception -> L22
                goto L2a
            L22:
                r0 = move-exception
                java.lang.String r1 = "HugePhotoDraweeView"
                java.lang.String r2 = "Error thrown by animation listener"
                android.util.Log.w(r1, r2, r0)
            L2a:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r0 = r0.getPaddingLeft()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r1 = r1.getWidth()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r2 = r2.getPaddingRight()
                int r1 = r1 - r2
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r2 = r2.getPaddingLeft()
                int r1 = r1 - r2
                int r1 = r1 / 2
                int r0 = r0 + r1
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r1 = r1.getPaddingTop()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r2 = r2.getHeight()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r3 = r3.getPaddingBottom()
                int r2 = r2 - r3
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                int r3 = r3.getPaddingTop()
                int r2 = r2 - r3
                int r2 = r2 / 2
                int r1 = r1 + r2
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                float r3 = r9.a
                float r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.H(r2, r3)
                boolean r3 = r9.g
                if (r3 == 0) goto L81
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r4 = r9.b
                float r5 = r4.x
                float r4 = r4.y
                android.graphics.PointF r6 = new android.graphics.PointF
                r6.<init>()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.I(r3, r5, r4, r2, r6)
                goto L83
            L81:
                android.graphics.PointF r6 = r9.b
            L83:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r4 = new com.baidu.swan.apps.media.image.HugePhotoDraweeView$c
                r5 = 0
                r4.<init>(r5)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.G(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                float r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.b(r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.l(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.n(r3, r2)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                long r7 = java.lang.System.currentTimeMillis()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.f(r3, r7)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.x(r3, r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r4 = r4.getCenter()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.v(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.t(r3, r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r4 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                android.graphics.PointF r4 = r4.B0(r6)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.p(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                android.graphics.PointF r4 = new android.graphics.PointF
                float r0 = (float) r0
                float r1 = (float) r1
                r4.<init>(r0, r1)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.r(r3, r4)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                long r3 = r9.d
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.h(r0, r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                boolean r1 = r9.f
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.b(r0, r1)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                int r1 = r9.e
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.j(r0, r1)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                long r3 = java.lang.System.currentTimeMillis()
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.f(r0, r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r0)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$f r1 = r9.h
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.d(r0, r1)
                android.graphics.PointF r0 = r9.c
                if (r0 == 0) goto L18a
                float r0 = r0.x
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r1)
                android.graphics.PointF r1 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.u(r1)
                float r1 = r1.x
                float r1 = r1 * r2
                float r0 = r0 - r1
                android.graphics.PointF r1 = r9.c
                float r1 = r1.y
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$c r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.F(r3)
                android.graphics.PointF r3 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.c.u(r3)
                float r3 = r3.y
                float r3 = r3 * r2
                float r1 = r1 - r3
                com.baidu.swan.apps.media.image.HugePhotoDraweeView$h r3 = new com.baidu.swan.apps.media.image.HugePhotoDraweeView$h
                android.graphics.PointF r4 = new android.graphics.PointF
                r4.<init>(r0, r1)
                r3.<init>(r2, r4, r5)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                r4 = 1
                com.baidu.swan.apps.media.image.HugePhotoDraweeView.J(r2, r4, r3)
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r2 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
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
            L18a:
                com.baidu.swan.apps.media.image.HugePhotoDraweeView r0 = com.baidu.swan.apps.media.image.HugePhotoDraweeView.this
                r0.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void");
        }

        public d c(long j) {
            this.d = j;
            return this;
        }

        public d e(boolean z) {
            this.f = z;
            return this;
        }

        public final d f(boolean z) {
            this.g = z;
            return this;
        }

        @SuppressLint({"BDThrowableCheck"})
        public d d(int i) {
            if (!HugePhotoDraweeView.D0.contains(Integer.valueOf(i))) {
                String str = "Unknown easing type: " + i;
                if (!HugePhotoDraweeView.A0) {
                    y72.k("HugePhotoDraweeView", str);
                    return this;
                }
                throw new IllegalArgumentException(str);
            }
            this.e = i;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends AsyncTask<Void, Void, Integer> {
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<Context> b;
        public final WeakReference<ez2<? extends fz2>> c;
        public final Uri d;
        public final boolean e;
        public Bitmap f;
        public Exception g;

        public e(HugePhotoDraweeView hugePhotoDraweeView, Context context, ez2<? extends fz2> ez2Var, Uri uri, boolean z) {
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(ez2Var);
            this.d = uri;
            this.e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.d.toString();
                Context context = this.b.get();
                ez2<? extends fz2> ez2Var = this.c.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                if (context != null && ez2Var != null && hugePhotoDraweeView != null) {
                    this.f = ez2Var.make().decode(context, this.d);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
            if (hugePhotoDraweeView != null) {
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

    /* loaded from: classes4.dex */
    public static class h {
        public float a;
        public PointF b;

        public h(float f, PointF pointF) {
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

    /* loaded from: classes4.dex */
    public static class i {
        public Rect a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public Rect f;
        public Rect g;

        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends AsyncTask<Void, Void, Bitmap> {
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<gz2> b;
        public final WeakReference<i> c;
        public Exception d;

        public j(HugePhotoDraweeView hugePhotoDraweeView, gz2 gz2Var, i iVar) {
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.b = new WeakReference<>(gz2Var);
            this.c = new WeakReference<>(iVar);
            iVar.d = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            try {
                HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                gz2 gz2Var = this.b.get();
                i iVar = this.c.get();
                if (gz2Var != null && iVar != null && hugePhotoDraweeView != null && gz2Var.isReady() && iVar.e) {
                    synchronized (hugePhotoDraweeView.O) {
                        hugePhotoDraweeView.Z(iVar.a, iVar.g);
                        if (hugePhotoDraweeView.G != null) {
                            iVar.g.offset(hugePhotoDraweeView.G.left, hugePhotoDraweeView.G.top);
                        }
                        decodeRegion = gz2Var.decodeRegion(iVar.g, iVar.b);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
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

    /* loaded from: classes4.dex */
    public static class k extends AsyncTask<Void, Void, int[]> {
        public final WeakReference<HugePhotoDraweeView> a;
        public final WeakReference<Context> b;
        public final WeakReference<ez2<? extends gz2>> c;
        public bz2 d;
        public gz2 e;
        public Exception f;

        public k(HugePhotoDraweeView hugePhotoDraweeView, Context context, ez2<? extends gz2> ez2Var, bz2 bz2Var) {
            this.a = new WeakReference<>(hugePhotoDraweeView);
            this.b = new WeakReference<>(context);
            this.c = new WeakReference<>(ez2Var);
            this.d = bz2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public int[] doInBackground(Void... voidArr) {
            Point init;
            try {
                if (this.d.i() != null) {
                    this.d.i().toString();
                }
                Context context = this.b.get();
                ez2<? extends gz2> ez2Var = this.c.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
                if (context != null && ez2Var != null && hugePhotoDraweeView != null) {
                    this.e = ez2Var.make();
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(int[] iArr) {
            HugePhotoDraweeView hugePhotoDraweeView = this.a.get();
            if (hugePhotoDraweeView != null) {
                gz2 gz2Var = this.e;
                if (gz2Var == null || iArr == null || iArr.length != 3) {
                    if (this.f != null && hugePhotoDraweeView.e0 != null) {
                        hugePhotoDraweeView.e0.onImageLoadError(this.f);
                        return;
                    }
                    return;
                }
                hugePhotoDraweeView.q0(gz2Var, iArr[0], iArr[1], iArr[2]);
            }
        }
    }

    public final void r0() {
        Float f2;
        if (getWidth() != 0 && getHeight() != 0 && this.D > 0 && this.E > 0) {
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

    public HugePhotoDraweeView(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
    public static /* synthetic */ float b(HugePhotoDraweeView hugePhotoDraweeView) {
        return hugePhotoDraweeView.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.M = new GestureDetector(context, new b(context));
    }

    public final PointF B0(PointF pointF) {
        return A0(pointF.x, pointF.y, new PointF());
    }

    public final float D0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.w) + pointF.x;
    }

    public final float E0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.w) + pointF.y;
    }

    public final PointF J0(PointF pointF) {
        return I0(pointF.x, pointF.y, new PointF());
    }

    public final float K0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.w;
    }

    public final float L0(float f2) {
        PointF pointF = this.y;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.w;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderClass(Class<? extends fz2> cls) {
        if (cls == null) {
            if (!A0) {
                y72.k("HugePhotoDraweeView", "bitmapDecoderClass is null");
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.P = new dz2(cls);
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setBitmapDecoderFactory(ez2<? extends fz2> ez2Var) {
        if (ez2Var == null) {
            if (!A0) {
                y72.k("HugePhotoDraweeView", "bitmapDecoderFactory is null");
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.P = ez2Var;
    }

    public final void setDebug(boolean z) {
        this.g = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.v = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.t = f2;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setDoubleTapZoomStyle(int i2) {
        if (!C0.contains(Integer.valueOf(i2))) {
            String str = "Invalid zoom style: " + i2;
            if (!A0) {
                y72.k("HugePhotoDraweeView", str);
                return;
            }
            throw new IllegalArgumentException(str);
        }
        this.u = i2;
    }

    public final void setImage(bz2 bz2Var) {
        setImage(bz2Var, null, null);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        cz2.b(getContext(), drawable);
        super.setImageDrawable(drawable);
    }

    public void setIsDynamicBitmap(boolean z) {
        this.x0 = z;
    }

    public final void setMaxScale(float f2) {
        this.j = f2;
    }

    public void setMaxTileSize(int i2) {
        this.n = i2;
        this.o = i2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.i = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.k = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (h0()) {
            t0(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(g gVar) {
        this.e0 = gVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f0 = onLongClickListener;
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.p = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.s = z;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderClass(Class<? extends gz2> cls) {
        if (cls == null) {
            if (!A0) {
                y72.k("HugePhotoDraweeView", "regionDecoderClass is null");
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.Q = new dz2(cls);
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setRegionDecoderFactory(ez2<? extends gz2> ez2Var) {
        if (ez2Var == null) {
            if (!A0) {
                y72.k("HugePhotoDraweeView", "setRegionDecoderFactory is null");
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.Q = ez2Var;
    }

    public final void setTileBackgroundColor(int i2) {
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

    public final void setZoomEnabled(boolean z) {
        this.r = z;
    }

    public final void w0(ImageViewState imageViewState) {
        if (imageViewState != null && imageViewState.getCenter() != null && B0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.h = imageViewState.getOrientation();
            this.A = Float.valueOf(imageViewState.getScale());
            this.B = imageViewState.getCenter();
            invalidate();
        }
    }

    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        bz2 a2;
        this.h = 0;
        this.i = k0();
        this.j = 5.0f;
        this.k = -1;
        this.l = 1;
        this.m = 1;
        int i2 = G0;
        this.n = i2;
        this.o = i2;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = 5.0f;
        this.u = 1;
        this.v = 500;
        this.O = new Object();
        this.P = new dz2(hz2.class);
        this.Q = new dz2(iz2.class);
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
        this.g0 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, hr1.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(0) && (string = obtainStyledAttributes.getString(0)) != null && string.length() > 0 && (a2 = bz2.a(string)) != null) {
                a2.n();
                setImage(a2);
            }
            if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                bz2 k2 = bz2.k(resourceId);
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
        this.f1073T = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public final void b0(boolean z, h hVar) {
        float paddingLeft;
        float max;
        int max2;
        float max3;
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

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.apps.media.image.HugePhotoDraweeView.d.b():void] */
    public static /* synthetic */ c G(HugePhotoDraweeView hugePhotoDraweeView, c cVar) {
        hugePhotoDraweeView.b0 = cVar;
        return cVar;
    }

    public final Rect C0(Rect rect, Rect rect2) {
        rect2.set((int) D0(rect.left), (int) E0(rect.top), (int) D0(rect.right), (int) E0(rect.bottom));
        return rect2;
    }

    public final PointF H0(float f2, float f3) {
        return I0(f2, f3, new PointF());
    }

    public final void setImage(bz2 bz2Var, ImageViewState imageViewState) {
        setImage(bz2Var, null, imageViewState);
    }

    public void setMaxTileSize(int i2, int i3) {
        this.n = i2;
        this.o = i3;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.b0 = null;
        this.A = Float.valueOf(f2);
        this.B = pointF;
        this.C = pointF;
        invalidate();
    }

    public final float S(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        PointF center = getCenter();
        if (this.c0 && center != null) {
            this.b0 = null;
            this.A = Float.valueOf(this.w);
            this.B = center;
        }
    }

    private int getRequiredRotation() {
        int i2 = this.h;
        if (i2 == -1) {
            return this.F;
        }
        return i2;
    }

    public final boolean P() {
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

    public final void U() {
        if (this.h0 != null) {
            if (this.z0 != cz2.d(getContext())) {
                this.z0 = cz2.d(getContext());
                this.y0 = new PorterDuffColorFilter(this.z0, PorterDuff.Mode.SRC_ATOP);
            }
            this.h0.setColorFilter(this.y0);
        }
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return H0(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.j;
    }

    public final float getMinScale() {
        return k0();
    }

    public final int getOrientation() {
        return this.h;
    }

    public final int getSHeight() {
        return this.E;
    }

    public final int getSWidth() {
        return this.D;
    }

    public final float getScale() {
        return this.w;
    }

    public final ImageViewState getState() {
        if (this.y != null && this.D > 0 && this.E > 0) {
            return new ImageViewState(getScale(), getCenter(), getOrientation());
        }
        return null;
    }

    public final boolean h0() {
        return this.c0;
    }

    public final synchronized void p0() {
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

    public final void u0() {
        if (this.w < k0()) {
            v0();
        }
    }

    public final int x0() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.E;
        }
        return this.D;
    }

    public final int y0() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.D;
        }
        return this.E;
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
        if (this.y == null) {
            return null;
        }
        pointF.set(D0(f2), E0(f3));
        return pointF;
    }

    public final PointF I0(float f2, float f3, PointF pointF) {
        if (this.y == null) {
            return null;
        }
        pointF.set(K0(f2), L0(f3));
        return pointF;
    }

    public final boolean F0(i iVar) {
        float K0 = K0(0.0f);
        float K02 = K0(getWidth());
        float L0 = L0(0.0f);
        float L02 = L0(getHeight());
        if (K0 <= iVar.a.right && iVar.a.left <= K02 && L0 <= iVar.a.bottom && iVar.a.top <= L02) {
            return true;
        }
        return false;
    }

    public final int O(float f2) {
        int round;
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
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final Point d0(Canvas canvas) {
        int i2;
        int intValue;
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

    public final PointF G0(float f2, float f3, float f4) {
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

    public final synchronized void m0(Bitmap bitmap, int i2, boolean z) {
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

    public final boolean Q() {
        boolean z;
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

    public final void R() {
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

    public final void v0() {
        this.b0 = null;
        this.A = Float.valueOf(j0(0.0f));
        if (h0()) {
            this.B = new PointF(y0() / 2, x0() / 2);
        } else {
            this.B = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void T(PointF pointF, PointF pointF2) {
        boolean z;
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

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        boolean z;
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

    @SuppressLint({"BDThrowableCheck"})
    public final float V(int i2, long j2, float f2, float f3, long j3) {
        if (i2 != 1) {
            if (i2 != 2) {
                String str = "Unexpected easing type: " + i2;
                if (!A0) {
                    y72.k("HugePhotoDraweeView", str);
                    return 0.0f;
                }
                throw new IllegalStateException(str);
            }
            return W(j2, f2, f3, j3);
        }
        return X(j2, f2, f3, j3);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void Y(AsyncTask<Void, Void, ?> asyncTask) {
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

    public final float j0(float f2) {
        if (f2 > 0.0f && f2 < k0()) {
            Log.i("HugePhotoDraweeView", "targetScale is " + f2 + "< minScale is " + k0());
        } else {
            f2 = Math.max(k0(), f2);
        }
        return Math.min(this.j, f2);
    }

    public final synchronized void n0(Bitmap bitmap) {
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setMinimumScaleType(int i2) {
        if (!F0.contains(Integer.valueOf(i2))) {
            String str = "Invalid scale type: " + i2;
            if (!A0) {
                y72.k("HugePhotoDraweeView", str);
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setOrientation(int i2) {
        if (!B0.contains(Integer.valueOf(i2))) {
            String str = "Invalid orientation: " + i2;
            if (!A0) {
                y72.k("HugePhotoDraweeView", str);
                return;
            }
            throw new IllegalArgumentException(str);
        }
        this.h = i2;
        t0(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
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

    @SuppressLint({"BDThrowableCheck"})
    public final void setPanLimit(int i2) {
        if (!E0.contains(Integer.valueOf(i2))) {
            String str = "Invalid pan limit: " + i2;
            if (!A0) {
                y72.k("HugePhotoDraweeView", str);
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

    public final void Z(Rect rect, Rect rect2) {
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

    public final void a0(boolean z) {
        boolean z2;
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

    public final synchronized void e0(Point point) {
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

    public final int c0(String str) {
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
                        az2.a(cursor);
                    }
                } finally {
                    az2.a(cursor);
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

    public final void f0(Point point) {
        boolean z;
        int i2;
        int i3;
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

    public final boolean g0() {
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

    public final float k0() {
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

    public final PointF i0(float f2, float f3, float f4, PointF pointF) {
        PointF G02 = G0(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - G02.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - G02.y) / f4);
        return pointF;
    }

    public final synchronized void q0(gz2 gz2Var, int i2, int i3, int i4) {
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
        this.N = gz2Var;
        this.D = i2;
        this.E = i3;
        this.F = i4;
        Q();
        P();
        invalidate();
        requestLayout();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        boolean z;
        boolean z2;
        if (this.x0) {
            if (this.z0 != cz2.d(getContext())) {
                cz2.b(getContext(), getDrawable());
                this.z0 = cz2.d(getContext());
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

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0093, code lost:
        if (r6 != 262) goto L53;
     */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        GestureDetector gestureDetector;
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
                                float abs = (Math.abs(this.R.y - motionEvent.getY()) * 2.0f) + this.f1073T;
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

    public final void s0(boolean z) {
        if (this.N != null && this.f != null) {
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

    public final void t0(boolean z) {
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

    public final void setImage(bz2 bz2Var, bz2 bz2Var2) {
        setImage(bz2Var, bz2Var2, null);
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void setImage(bz2 bz2Var, bz2 bz2Var2, ImageViewState imageViewState) {
        if (bz2Var == null) {
            if (!A0) {
                y72.k("HugePhotoDraweeView", "imageSource is null");
                return;
            }
            throw new NullPointerException("imageSource must not be null");
        }
        t0(true);
        if (imageViewState != null) {
            w0(imageViewState);
        }
        if (bz2Var2 != null) {
            if (bz2Var.c() != null) {
                if (!A0) {
                    y72.k("HugePhotoDraweeView", "imageSource get bitmap is not null");
                    return;
                }
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (bz2Var.g() > 0 && bz2Var.e() > 0) {
                this.D = bz2Var.g();
                this.E = bz2Var.e();
                this.H = bz2Var2.f();
                if (bz2Var2.c() != null) {
                    this.c = bz2Var2.j();
                    n0(bz2Var2.c());
                } else {
                    Uri i2 = bz2Var2.i();
                    if (i2 == null && bz2Var2.d() != null) {
                        i2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bz2Var2.d());
                    }
                    Y(new e(this, getContext(), this.P, i2, true));
                }
            } else if (!A0) {
                y72.k("HugePhotoDraweeView", "imageSource width or height invalid");
                return;
            } else {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
        }
        if (bz2Var.c() != null && bz2Var.f() != null) {
            m0(Bitmap.createBitmap(bz2Var.c(), bz2Var.f().left, bz2Var.f().top, bz2Var.f().width(), bz2Var.f().height()), 0, false);
        } else if (bz2Var.c() != null && !bz2Var.h()) {
            m0(bz2Var.c(), 0, bz2Var.j());
        } else {
            this.G = bz2Var.f();
            Uri i3 = bz2Var.i();
            this.d = i3;
            if (i3 == null && bz2Var.d() != null) {
                this.d = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bz2Var.d());
            }
            if (!bz2Var.h() && this.G == null) {
                Y(new e(this, getContext(), this.P, this.d, false));
            } else {
                Y(new k(this, getContext(), this.Q, bz2Var));
            }
        }
    }

    public final void z0(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
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
