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
import com.baidu.rtc.PeerConnectionClient;
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
    public float A;
    public float B;
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
    public d.a.i0.a.i1.e.d.d R;
    public final Object S;
    public d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.c> T;
    public d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.d> U;
    public PointF V;
    public float W;
    public final float a0;
    public PointF b0;
    public float c0;
    public PointF d0;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f11020e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11021f;
    public c f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11022g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f11023h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public int f11024i;
    public g i0;
    public Map<Integer, List<i>> j;
    public View.OnLongClickListener j0;
    public boolean k;
    public Handler k0;
    public int l;
    public Paint l0;
    public float m;
    public Paint m0;
    public float n;
    public Paint n0;
    public int o;
    public h o0;
    public int p;
    public Matrix p0;
    public int q;
    public RectF q0;
    public int r;
    public float[] r0;
    public int s;
    public float[] s0;
    public boolean t;
    public float t0;
    public boolean u;
    public boolean u0;
    public boolean v;
    public ColorFilter v0;
    public boolean w;
    public int w0;
    public float x;
    public int y;
    public int z;
    public static final boolean x0 = d.a.i0.a.k.f43025a;
    public static final List<Integer> y0 = Arrays.asList(0, 90, 180, 270, -1);
    public static final List<Integer> z0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> A0 = Arrays.asList(2, 1);
    public static final List<Integer> B0 = Arrays.asList(1, 2, 3);
    public static final List<Integer> C0 = Arrays.asList(2, 1, 3);
    public static int D0 = Integer.MAX_VALUE;

    /* loaded from: classes3.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && HugePhotoDraweeView.this.j0 != null) {
                HugePhotoDraweeView.this.P = 0;
                HugePhotoDraweeView hugePhotoDraweeView = HugePhotoDraweeView.this;
                HugePhotoDraweeView.super.setOnLongClickListener(hugePhotoDraweeView.j0);
                HugePhotoDraweeView.this.performLongClick();
                HugePhotoDraweeView.super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f11026e;

        public b(Context context) {
            this.f11026e = context;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (HugePhotoDraweeView.this.v && HugePhotoDraweeView.this.g0 && HugePhotoDraweeView.this.C != null) {
                HugePhotoDraweeView.this.setGestureDetector(this.f11026e);
                if (HugePhotoDraweeView.this.w) {
                    HugePhotoDraweeView.this.V = new PointF(motionEvent.getX(), motionEvent.getY());
                    HugePhotoDraweeView.this.D = new PointF(HugePhotoDraweeView.this.C.x, HugePhotoDraweeView.this.C.y);
                    HugePhotoDraweeView hugePhotoDraweeView = HugePhotoDraweeView.this;
                    hugePhotoDraweeView.B = hugePhotoDraweeView.A;
                    HugePhotoDraweeView.this.O = true;
                    HugePhotoDraweeView.this.M = true;
                    HugePhotoDraweeView hugePhotoDraweeView2 = HugePhotoDraweeView.this;
                    hugePhotoDraweeView2.b0 = hugePhotoDraweeView2.J0(hugePhotoDraweeView2.V);
                    HugePhotoDraweeView.this.c0 = -1.0f;
                    HugePhotoDraweeView.this.d0 = new PointF(HugePhotoDraweeView.this.b0.x, HugePhotoDraweeView.this.b0.y);
                    HugePhotoDraweeView.this.e0 = false;
                    return false;
                }
                HugePhotoDraweeView hugePhotoDraweeView3 = HugePhotoDraweeView.this;
                hugePhotoDraweeView3.T(hugePhotoDraweeView3.J0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (HugePhotoDraweeView.this.u && HugePhotoDraweeView.this.g0 && HugePhotoDraweeView.this.C != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f2) > 500.0f || Math.abs(f3) > 500.0f) && !HugePhotoDraweeView.this.M))) {
                PointF pointF = new PointF(HugePhotoDraweeView.this.C.x + (f2 * 0.25f), HugePhotoDraweeView.this.C.y + (f3 * 0.25f));
                d dVar = new d(HugePhotoDraweeView.this, new PointF(((HugePhotoDraweeView.this.getWidth() / 2) - pointF.x) / HugePhotoDraweeView.this.A, ((HugePhotoDraweeView.this.getHeight() / 2) - pointF.y) / HugePhotoDraweeView.this.A), (a) null);
                dVar.d(1);
                dVar.f(false);
                dVar.b();
                return true;
            }
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HugePhotoDraweeView.this.performClick();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final float f11037a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f11038b;

        /* renamed from: c  reason: collision with root package name */
        public final PointF f11039c;

        /* renamed from: d  reason: collision with root package name */
        public long f11040d;

        /* renamed from: e  reason: collision with root package name */
        public int f11041e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11042f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11043g;

        /* renamed from: h  reason: collision with root package name */
        public f f11044h;

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF, PointF pointF2, a aVar) {
            this(f2, pointF, pointF2);
        }

        public void b() {
            PointF pointF;
            if (HugePhotoDraweeView.this.f0 != null && HugePhotoDraweeView.this.f0.l != null) {
                try {
                    HugePhotoDraweeView.this.f0.l.b();
                } catch (Exception e2) {
                    Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                }
            }
            int paddingLeft = HugePhotoDraweeView.this.getPaddingLeft() + (((HugePhotoDraweeView.this.getWidth() - HugePhotoDraweeView.this.getPaddingRight()) - HugePhotoDraweeView.this.getPaddingLeft()) / 2);
            int paddingTop = HugePhotoDraweeView.this.getPaddingTop() + (((HugePhotoDraweeView.this.getHeight() - HugePhotoDraweeView.this.getPaddingBottom()) - HugePhotoDraweeView.this.getPaddingTop()) / 2);
            float j0 = HugePhotoDraweeView.this.j0(this.f11037a);
            if (this.f11043g) {
                HugePhotoDraweeView hugePhotoDraweeView = HugePhotoDraweeView.this;
                PointF pointF2 = this.f11038b;
                float f2 = pointF2.x;
                float f3 = pointF2.y;
                pointF = new PointF();
                hugePhotoDraweeView.i0(f2, f3, j0, pointF);
            } else {
                pointF = this.f11038b;
            }
            HugePhotoDraweeView.this.f0 = new c(null);
            HugePhotoDraweeView.this.f0.f11028a = HugePhotoDraweeView.this.A;
            HugePhotoDraweeView.this.f0.f11029b = j0;
            HugePhotoDraweeView.this.f0.k = System.currentTimeMillis();
            HugePhotoDraweeView.this.f0.f11032e = pointF;
            HugePhotoDraweeView.this.f0.f11030c = HugePhotoDraweeView.this.getCenter();
            HugePhotoDraweeView.this.f0.f11031d = pointF;
            HugePhotoDraweeView.this.f0.f11033f = HugePhotoDraweeView.this.B0(pointF);
            HugePhotoDraweeView.this.f0.f11034g = new PointF(paddingLeft, paddingTop);
            HugePhotoDraweeView.this.f0.f11035h = this.f11040d;
            HugePhotoDraweeView.this.f0.f11036i = this.f11042f;
            HugePhotoDraweeView.this.f0.j = this.f11041e;
            HugePhotoDraweeView.this.f0.k = System.currentTimeMillis();
            HugePhotoDraweeView.this.f0.l = this.f11044h;
            PointF pointF3 = this.f11039c;
            if (pointF3 != null) {
                float f4 = pointF3.x - (HugePhotoDraweeView.this.f0.f11030c.x * j0);
                float f5 = this.f11039c.y - (HugePhotoDraweeView.this.f0.f11030c.y * j0);
                h hVar = new h(j0, new PointF(f4, f5), null);
                HugePhotoDraweeView.this.b0(true, hVar);
                HugePhotoDraweeView.this.f0.f11034g = new PointF(this.f11039c.x + (hVar.f11054b.x - f4), this.f11039c.y + (hVar.f11054b.y - f5));
            }
            HugePhotoDraweeView.this.invalidate();
        }

        public d c(long j) {
            this.f11040d = j;
            return this;
        }

        public d d(int i2) {
            if (!HugePhotoDraweeView.A0.contains(Integer.valueOf(i2))) {
                String str = "Unknown easing type: " + i2;
                if (!HugePhotoDraweeView.x0) {
                    d.a.i0.a.e0.d.h("HugePhotoDraweeView", str);
                    return this;
                }
                throw new IllegalArgumentException(str);
            }
            this.f11041e = i2;
            return this;
        }

        public d e(boolean z) {
            this.f11042f = z;
            return this;
        }

        public final d f(boolean z) {
            this.f11043g = z;
            return this;
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, float f2, PointF pointF, a aVar) {
            this(f2, pointF);
        }

        public /* synthetic */ d(HugePhotoDraweeView hugePhotoDraweeView, PointF pointF, a aVar) {
            this(pointF);
        }

        public d(PointF pointF) {
            this.f11040d = 500L;
            this.f11041e = 2;
            this.f11042f = true;
            this.f11043g = true;
            this.f11037a = HugePhotoDraweeView.this.A;
            this.f11038b = pointF;
            this.f11039c = null;
        }

        public d(float f2, PointF pointF) {
            this.f11040d = 500L;
            this.f11041e = 2;
            this.f11042f = true;
            this.f11043g = true;
            this.f11037a = f2;
            this.f11038b = pointF;
            this.f11039c = null;
        }

        public d(float f2, PointF pointF, PointF pointF2) {
            this.f11040d = 500L;
            this.f11041e = 2;
            this.f11042f = true;
            this.f11043g = true;
            this.f11037a = f2;
            this.f11038b = pointF;
            this.f11039c = pointF2;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<HugePhotoDraweeView> f11046a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f11047b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.c>> f11048c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri f11049d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11050e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f11051f;

        /* renamed from: g  reason: collision with root package name */
        public Exception f11052g;

        public e(HugePhotoDraweeView hugePhotoDraweeView, Context context, d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.c> bVar, Uri uri, boolean z) {
            this.f11046a = new WeakReference<>(hugePhotoDraweeView);
            this.f11047b = new WeakReference<>(context);
            this.f11048c = new WeakReference<>(bVar);
            this.f11049d = uri;
            this.f11050e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.f11049d.toString();
                Context context = this.f11047b.get();
                d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.c> bVar = this.f11048c.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.f11046a.get();
                if (context == null || bVar == null || hugePhotoDraweeView == null) {
                    return null;
                }
                this.f11051f = bVar.make().decode(context, this.f11049d);
                return Integer.valueOf(hugePhotoDraweeView.c0(uri));
            } catch (Exception e2) {
                Log.e("HugePhotoDraweeView", "Failed to load bitmap", e2);
                this.f11052g = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e("HugePhotoDraweeView", "Failed to load bitmap - OutOfMemoryError", e3);
                this.f11052g = new RuntimeException(e3);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            HugePhotoDraweeView hugePhotoDraweeView = this.f11046a.get();
            if (hugePhotoDraweeView != null) {
                Bitmap bitmap = this.f11051f;
                if (bitmap != null && num != null) {
                    if (this.f11050e) {
                        hugePhotoDraweeView.n0(bitmap);
                    } else {
                        hugePhotoDraweeView.m0(bitmap, num.intValue(), false);
                    }
                } else if (this.f11052g == null || hugePhotoDraweeView.i0 == null) {
                } else {
                    if (this.f11050e) {
                        hugePhotoDraweeView.i0.onPreviewLoadError(this.f11052g);
                    } else {
                        hugePhotoDraweeView.i0.onImageLoadError(this.f11052g);
                    }
                }
            }
        }
    }

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

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public float f11053a;

        /* renamed from: b  reason: collision with root package name */
        public PointF f11054b;

        public /* synthetic */ h(float f2, PointF pointF, a aVar) {
            this(f2, pointF);
        }

        public h(float f2, PointF pointF) {
            this.f11053a = f2;
            this.f11054b = pointF;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public Rect f11055a;

        /* renamed from: b  reason: collision with root package name */
        public int f11056b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f11057c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11058d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11059e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f11060f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f11061g;

        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<HugePhotoDraweeView> f11062a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<d.a.i0.a.i1.e.d.d> f11063b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<i> f11064c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f11065d;

        public j(HugePhotoDraweeView hugePhotoDraweeView, d.a.i0.a.i1.e.d.d dVar, i iVar) {
            this.f11062a = new WeakReference<>(hugePhotoDraweeView);
            this.f11063b = new WeakReference<>(dVar);
            this.f11064c = new WeakReference<>(iVar);
            iVar.f11058d = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeRegion;
            try {
                HugePhotoDraweeView hugePhotoDraweeView = this.f11062a.get();
                d.a.i0.a.i1.e.d.d dVar = this.f11063b.get();
                i iVar = this.f11064c.get();
                if (dVar == null || iVar == null || hugePhotoDraweeView == null || !dVar.isReady() || !iVar.f11059e) {
                    if (iVar != null) {
                        iVar.f11058d = false;
                        return null;
                    }
                    return null;
                }
                synchronized (hugePhotoDraweeView.S) {
                    hugePhotoDraweeView.Z(iVar.f11055a, iVar.f11061g);
                    if (hugePhotoDraweeView.K != null) {
                        iVar.f11061g.offset(hugePhotoDraweeView.K.left, hugePhotoDraweeView.K.top);
                    }
                    decodeRegion = dVar.decodeRegion(iVar.f11061g, iVar.f11056b);
                }
                return decodeRegion;
            } catch (Exception e2) {
                Log.e("HugePhotoDraweeView", "Failed to decode tile", e2);
                this.f11065d = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e("HugePhotoDraweeView", "Failed to decode tile - OutOfMemoryError", e3);
                this.f11065d = new RuntimeException(e3);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            HugePhotoDraweeView hugePhotoDraweeView = this.f11062a.get();
            i iVar = this.f11064c.get();
            if (hugePhotoDraweeView == null || iVar == null) {
                return;
            }
            if (bitmap != null) {
                iVar.f11057c = bitmap;
                iVar.f11058d = false;
                hugePhotoDraweeView.p0();
            } else if (this.f11065d == null || hugePhotoDraweeView.i0 == null) {
            } else {
                hugePhotoDraweeView.i0.onTileLoadError(this.f11065d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends AsyncTask<Void, Void, int[]> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<HugePhotoDraweeView> f11066a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f11067b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.d>> f11068c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.i0.a.i1.e.b f11069d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.i0.a.i1.e.d.d f11070e;

        /* renamed from: f  reason: collision with root package name */
        public Exception f11071f;

        public k(HugePhotoDraweeView hugePhotoDraweeView, Context context, d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.d> bVar, d.a.i0.a.i1.e.b bVar2) {
            this.f11066a = new WeakReference<>(hugePhotoDraweeView);
            this.f11067b = new WeakReference<>(context);
            this.f11068c = new WeakReference<>(bVar);
            this.f11069d = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public int[] doInBackground(Void... voidArr) {
            Point init;
            try {
                if (this.f11069d.i() != null) {
                    this.f11069d.i().toString();
                }
                Context context = this.f11067b.get();
                d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.d> bVar = this.f11068c.get();
                HugePhotoDraweeView hugePhotoDraweeView = this.f11066a.get();
                if (context == null || bVar == null || hugePhotoDraweeView == null) {
                    return null;
                }
                this.f11070e = bVar.make();
                if (this.f11069d.c() != null) {
                    init = this.f11070e.a(context, this.f11069d.c());
                } else {
                    init = this.f11070e.init(context, this.f11069d.i());
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
                Log.e("HugePhotoDraweeView", "Failed to initialise bitmap decoder", e2);
                this.f11071f = e2;
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(int[] iArr) {
            HugePhotoDraweeView hugePhotoDraweeView = this.f11066a.get();
            if (hugePhotoDraweeView != null) {
                d.a.i0.a.i1.e.d.d dVar = this.f11070e;
                if (dVar != null && iArr != null && iArr.length == 3) {
                    hugePhotoDraweeView.q0(dVar, iArr[0], iArr[1], iArr[2]);
                } else if (this.f11071f == null || hugePhotoDraweeView.i0 == null) {
                } else {
                    hugePhotoDraweeView.i0.onImageLoadError(this.f11071f);
                }
            }
        }
    }

    public HugePhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        d.a.i0.a.i1.e.b a2;
        this.l = 0;
        this.m = k0();
        this.n = 5.0f;
        this.o = -1;
        this.p = 1;
        this.q = 1;
        int i2 = D0;
        this.r = i2;
        this.s = i2;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = 5.0f;
        this.y = 1;
        this.z = 500;
        this.S = new Object();
        this.T = new d.a.i0.a.i1.e.d.a(d.a.i0.a.i1.e.d.e.class);
        this.U = new d.a.i0.a.i1.e.d.a(d.a.i0.a.i1.e.d.f.class);
        this.r0 = new float[8];
        this.s0 = new float[8];
        this.u0 = false;
        this.v0 = null;
        this.w0 = 0;
        this.t0 = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMaximumDpi(PeerConnectionClient.HD_VIDEO_HEIGHT);
        setGestureDetector(context);
        this.k0 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.a.i0.a.j.HugePhotoDraweeView);
            if (obtainStyledAttributes.hasValue(d.a.i0.a.j.HugePhotoDraweeView_assetName) && (string = obtainStyledAttributes.getString(d.a.i0.a.j.HugePhotoDraweeView_assetName)) != null && string.length() > 0 && (a2 = d.a.i0.a.i1.e.b.a(string)) != null) {
                a2.n();
                setImage(a2);
            }
            if (obtainStyledAttributes.hasValue(d.a.i0.a.j.HugePhotoDraweeView_src) && (resourceId = obtainStyledAttributes.getResourceId(d.a.i0.a.j.HugePhotoDraweeView_src, 0)) > 0) {
                d.a.i0.a.i1.e.b k2 = d.a.i0.a.i1.e.b.k(resourceId);
                k2.n();
                setImage(k2);
            }
            if (obtainStyledAttributes.hasValue(d.a.i0.a.j.HugePhotoDraweeView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(d.a.i0.a.j.HugePhotoDraweeView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(d.a.i0.a.j.HugePhotoDraweeView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(d.a.i0.a.j.HugePhotoDraweeView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(d.a.i0.a.j.HugePhotoDraweeView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(d.a.i0.a.j.HugePhotoDraweeView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(d.a.i0.a.j.HugePhotoDraweeView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(d.a.i0.a.j.HugePhotoDraweeView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.a0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int getRequiredRotation() {
        int i2 = this.l;
        return i2 == -1 ? this.J : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.Q = new GestureDetector(context, new b(context));
    }

    public final PointF A0(float f2, float f3, PointF pointF) {
        if (this.C == null) {
            return null;
        }
        pointF.set(D0(f2), E0(f3));
        return pointF;
    }

    public final PointF B0(PointF pointF) {
        return A0(pointF.x, pointF.y, new PointF());
    }

    public final Rect C0(Rect rect, Rect rect2) {
        rect2.set((int) D0(rect.left), (int) E0(rect.top), (int) D0(rect.right), (int) E0(rect.bottom));
        return rect2;
    }

    public final float D0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.A) + pointF.x;
    }

    public final float E0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.A) + pointF.y;
    }

    public final boolean F0(i iVar) {
        return K0(0.0f) <= ((float) iVar.f11055a.right) && ((float) iVar.f11055a.left) <= K0((float) getWidth()) && L0(0.0f) <= ((float) iVar.f11055a.bottom) && ((float) iVar.f11055a.top) <= L0((float) getHeight());
    }

    public final PointF G0(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.o0 == null) {
            this.o0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.o0.f11053a = f4;
        this.o0.f11054b.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        b0(true, this.o0);
        return this.o0.f11054b;
    }

    public final PointF H0(float f2, float f3) {
        return I0(f2, f3, new PointF());
    }

    public final PointF I0(float f2, float f3, PointF pointF) {
        if (this.C == null) {
            return null;
        }
        pointF.set(K0(f2), L0(f3));
        return pointF;
    }

    public final PointF J0(PointF pointF) {
        return I0(pointF.x, pointF.y, new PointF());
    }

    public final float K0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.A;
    }

    public final float L0(float f2) {
        PointF pointF = this.C;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.A;
    }

    public final int O(float f2) {
        int round;
        if (this.o > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.o / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int y02 = (int) (y0() * f2);
        int x02 = (int) (x0() * f2);
        if (y02 == 0 || x02 == 0) {
            return 32;
        }
        int i2 = 1;
        if (x0() > x02 || y0() > y02) {
            round = Math.round(x0() / x02);
            int round2 = Math.round(y0() / y02);
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
        boolean g0 = g0();
        if (!this.h0 && g0) {
            r0();
            this.h0 = true;
            l0();
            g gVar = this.i0;
            if (gVar != null) {
                gVar.onImageLoaded();
            }
        }
        return g0;
    }

    public final boolean Q() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.H > 0 && this.I > 0 && (this.f11020e != null || g0());
        if (!this.g0 && z) {
            r0();
            this.g0 = true;
            o0();
            g gVar = this.i0;
            if (gVar != null) {
                gVar.onReady();
            }
        }
        return z;
    }

    public final void R() {
        if (this.l0 == null) {
            Paint paint = new Paint();
            this.l0 = paint;
            paint.setAntiAlias(true);
            this.l0.setFilterBitmap(true);
            this.l0.setDither(true);
        }
        if (this.m0 == null && this.k) {
            Paint paint2 = new Paint();
            this.m0 = paint2;
            paint2.setTextSize(18.0f);
            this.m0.setColor(-65281);
            this.m0.setStyle(Paint.Style.STROKE);
        }
    }

    public final float S(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    public final void T(PointF pointF, PointF pointF2) {
        if (!this.u) {
            PointF pointF3 = this.G;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = y0() / 2;
                pointF.y = x0() / 2;
            }
        }
        float min = Math.min(this.n, this.x);
        boolean z = ((double) this.A) <= ((double) min) * 0.9d;
        if (!z) {
            min = k0();
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

    public final void U() {
        if (this.l0 != null) {
            if (this.w0 != d.a.i0.a.i1.e.c.d(getContext())) {
                this.w0 = d.a.i0.a.i1.e.c.d(getContext());
                this.v0 = new PorterDuffColorFilter(this.w0, PorterDuff.Mode.SRC_ATOP);
            }
            this.l0.setColorFilter(this.v0);
        }
    }

    public final float V(int i2, long j2, float f2, float f3, long j3) {
        if (i2 != 1) {
            if (i2 != 2) {
                String str = "Unexpected easing type: " + i2;
                if (!x0) {
                    d.a.i0.a.e0.d.h("HugePhotoDraweeView", str);
                    return 0.0f;
                }
                throw new IllegalStateException(str);
            }
            return W(j2, f2, f3, j3);
        }
        return X(j2, f2, f3, j3);
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

    public final void Y(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.t && Build.VERSION.SDK_INT >= 11) {
            try {
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null), null);
                return;
            } catch (Exception e2) {
                Log.i("HugePhotoDraweeView", "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e2);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    public final void Z(Rect rect, Rect rect2) {
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

    public final void a0(boolean z) {
        boolean z2;
        if (this.C == null) {
            z2 = true;
            this.C = new PointF(0.0f, 0.0f);
        } else {
            z2 = false;
        }
        if (this.o0 == null) {
            this.o0 = new h(0.0f, new PointF(0.0f, 0.0f), null);
        }
        this.o0.f11053a = this.A;
        this.o0.f11054b.set(this.C);
        b0(z, this.o0);
        this.A = this.o0.f11053a;
        this.C.set(this.o0.f11054b);
        if (z2) {
            this.C.set(G0(y0() / 2, x0() / 2, this.A));
        }
    }

    public final void b0(boolean z, h hVar) {
        float max;
        int max2;
        float max3;
        if (this.p == 2 && h0()) {
            z = false;
        }
        PointF pointF = hVar.f11054b;
        float j0 = j0(hVar.f11053a);
        float y02 = y0() * j0;
        float x02 = x0() * j0;
        if (this.p == 3 && h0()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - y02);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - x02);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - y02);
            pointF.y = Math.max(pointF.y, getHeight() - x02);
        } else {
            pointF.x = Math.max(pointF.x, -y02);
            pointF.y = Math.max(pointF.y, -x02);
        }
        float f2 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
        }
        if (this.p == 3 && h0()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else if (z) {
            max = Math.max(0.0f, (getWidth() - y02) * paddingLeft);
            max3 = Math.max(0.0f, (getHeight() - x02) * f2);
            pointF.x = Math.min(pointF.x, max);
            pointF.y = Math.min(pointF.y, max3);
            hVar.f11053a = j0;
        } else {
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        hVar.f11053a = j0;
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
                            if (!y0.contains(Integer.valueOf(i3)) || i3 == -1) {
                                Log.w("HugePhotoDraweeView", "Unsupported orientation: " + i3);
                            } else {
                                i2 = i3;
                            }
                        }
                        d.a.i0.a.i1.e.a.a(cursor);
                    }
                } finally {
                    d.a.i0.a.i1.e.a.a(cursor);
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

    public final synchronized void e0(Point point) {
        h hVar = new h(0.0f, new PointF(0.0f, 0.0f), null);
        this.o0 = hVar;
        b0(true, hVar);
        int O = O(this.o0.f11053a);
        this.f11024i = O;
        if (O > 1) {
            this.f11024i = O / 2;
        }
        if (this.f11024i == 1 && this.K == null && y0() < point.x && x0() < point.y && this.f11023h != null) {
            this.R.recycle();
            this.R = null;
            Y(new e(this, getContext(), this.T, this.f11023h, false));
        } else {
            f0(point);
            for (i iVar : this.j.get(Integer.valueOf(this.f11024i))) {
                Y(new j(this, this.R, iVar));
            }
            s0(true);
        }
    }

    public final void f0(Point point) {
        this.j = new LinkedHashMap();
        int i2 = this.f11024i;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int y02 = y0() / i4;
            int x02 = x0() / i5;
            int i6 = y02 / i2;
            int i7 = x02 / i2;
            while (true) {
                if (i6 + i4 + i3 > point.x || (i6 > getWidth() * 1.25d && i2 < this.f11024i)) {
                    i4++;
                    y02 = y0() / i4;
                    i6 = y02 / i2;
                }
            }
            while (true) {
                if (i7 + i5 + i3 > point.y || (i7 > getHeight() * 1.25d && i2 < this.f11024i)) {
                    i5++;
                    x02 = x0() / i5;
                    i7 = x02 / i2;
                }
            }
            ArrayList arrayList = new ArrayList(i4 * i5);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    i iVar = new i(null);
                    iVar.f11056b = i2;
                    iVar.f11059e = i2 == this.f11024i;
                    iVar.f11055a = new Rect(i8 * y02, i9 * x02, i8 == i4 + (-1) ? y0() : (i8 + 1) * y02, i9 == i5 + (-1) ? x0() : (i9 + 1) * x02);
                    iVar.f11060f = new Rect(0, 0, 0, 0);
                    iVar.f11061g = new Rect(iVar.f11055a);
                    arrayList.add(iVar);
                    i9++;
                }
                i8++;
            }
            this.j.put(Integer.valueOf(i2), arrayList);
            i3 = 1;
            if (i2 == 1) {
                return;
            }
            i2 /= 2;
        }
    }

    public final boolean g0() {
        boolean z = true;
        if (this.f11020e == null || this.f11021f) {
            Map<Integer, List<i>> map = this.j;
            if (map != null) {
                for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                    if (entry.getKey().intValue() == this.f11024i) {
                        for (i iVar : entry.getValue()) {
                            if (iVar.f11058d || iVar.f11057c == null) {
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

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return H0(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.n;
    }

    public final float getMinScale() {
        return k0();
    }

    public final int getOrientation() {
        return this.l;
    }

    public final int getSHeight() {
        return this.I;
    }

    public final int getSWidth() {
        return this.H;
    }

    public final float getScale() {
        return this.A;
    }

    public final ImageViewState getState() {
        if (this.C == null || this.H <= 0 || this.I <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean h0() {
        return this.g0;
    }

    public final PointF i0(float f2, float f3, float f4, PointF pointF) {
        PointF G0 = G0(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - G0.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - G0.y) / f4);
        return pointF;
    }

    public final float j0(float f2) {
        if (f2 > 0.0f && f2 < k0()) {
            Log.i("HugePhotoDraweeView", "targetScale is " + f2 + "< minScale is " + k0());
        } else {
            f2 = Math.max(k0(), f2);
        }
        return Math.min(this.n, f2);
    }

    public final float k0() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i2 = this.q;
        if (i2 == 2) {
            return Math.max((getWidth() - paddingLeft) / y0(), (getHeight() - paddingBottom) / x0());
        }
        if (i2 == 3) {
            float f2 = this.m;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / y0(), (getHeight() - paddingBottom) / x0());
    }

    public void l0() {
    }

    public final synchronized void m0(Bitmap bitmap, int i2, boolean z) {
        if (this.H > 0 && this.I > 0 && (this.H != bitmap.getWidth() || this.I != bitmap.getHeight())) {
            t0(false);
        }
        if (this.f11020e != null && !this.f11022g) {
            this.f11020e.recycle();
        }
        this.f11021f = false;
        this.f11022g = z;
        this.f11020e = bitmap;
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

    public final synchronized void n0(Bitmap bitmap) {
        if (this.f11020e == null && !this.h0) {
            if (this.L != null) {
                this.f11020e = Bitmap.createBitmap(bitmap, this.L.left, this.L.top, this.L.width(), this.L.height());
            } else {
                this.f11020e = bitmap;
            }
            this.f11021f = true;
            if (Q()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    public void o0() {
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        float f2;
        if (this.u0) {
            if (this.w0 != d.a.i0.a.i1.e.c.d(getContext())) {
                d.a.i0.a.i1.e.c.b(getContext(), getDrawable());
                this.w0 = d.a.i0.a.i1.e.c.d(getContext());
            }
            super.onDraw(canvas);
            return;
        }
        R();
        U();
        if (this.H == 0 || this.I == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.j == null && this.R != null) {
            e0(d0(canvas));
        }
        if (Q()) {
            r0();
            if (this.f0 != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f0.k;
                boolean z = currentTimeMillis > this.f0.f11035h;
                long min = Math.min(currentTimeMillis, this.f0.f11035h);
                this.A = V(this.f0.j, min, this.f0.f11028a, this.f0.f11029b - this.f0.f11028a, this.f0.f11035h);
                float V = V(this.f0.j, min, this.f0.f11033f.x, this.f0.f11034g.x - this.f0.f11033f.x, this.f0.f11035h);
                float V2 = V(this.f0.j, min, this.f0.f11033f.y, this.f0.f11034g.y - this.f0.f11033f.y, this.f0.f11035h);
                this.C.x -= D0(this.f0.f11031d.x) - V;
                this.C.y -= E0(this.f0.f11031d.y) - V2;
                a0(z || this.f0.f11028a == this.f0.f11029b);
                s0(z);
                if (z) {
                    if (this.f0.l != null) {
                        try {
                            this.f0.l.onComplete();
                        } catch (Exception e2) {
                            Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
                        }
                    }
                    this.f0 = null;
                }
                invalidate();
            }
            if (this.j != null && g0()) {
                int min2 = Math.min(this.f11024i, O(this.A));
                boolean z2 = false;
                for (Map.Entry<Integer, List<i>> entry : this.j.entrySet()) {
                    if (entry.getKey().intValue() == min2) {
                        for (i iVar : entry.getValue()) {
                            if (iVar.f11059e && (iVar.f11058d || iVar.f11057c == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<i>> entry2 : this.j.entrySet()) {
                    if (entry2.getKey().intValue() == min2 || z2) {
                        for (i iVar2 : entry2.getValue()) {
                            C0(iVar2.f11055a, iVar2.f11060f);
                            if (iVar2.f11058d || iVar2.f11057c == null) {
                                if (iVar2.f11058d && this.k) {
                                    canvas.drawText("LOADING", iVar2.f11060f.left + 5, iVar2.f11060f.top + 35, this.m0);
                                }
                            } else {
                                if (this.n0 != null) {
                                    canvas.drawRect(iVar2.f11060f, this.n0);
                                }
                                if (this.p0 == null) {
                                    this.p0 = new Matrix();
                                }
                                this.p0.reset();
                                z0(this.r0, 0.0f, 0.0f, iVar2.f11057c.getWidth(), 0.0f, iVar2.f11057c.getWidth(), iVar2.f11057c.getHeight(), 0.0f, iVar2.f11057c.getHeight());
                                if (getRequiredRotation() == 0) {
                                    z0(this.s0, iVar2.f11060f.left, iVar2.f11060f.top, iVar2.f11060f.right, iVar2.f11060f.top, iVar2.f11060f.right, iVar2.f11060f.bottom, iVar2.f11060f.left, iVar2.f11060f.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    z0(this.s0, iVar2.f11060f.right, iVar2.f11060f.top, iVar2.f11060f.right, iVar2.f11060f.bottom, iVar2.f11060f.left, iVar2.f11060f.bottom, iVar2.f11060f.left, iVar2.f11060f.top);
                                } else if (getRequiredRotation() == 180) {
                                    z0(this.s0, iVar2.f11060f.right, iVar2.f11060f.bottom, iVar2.f11060f.left, iVar2.f11060f.bottom, iVar2.f11060f.left, iVar2.f11060f.top, iVar2.f11060f.right, iVar2.f11060f.top);
                                } else if (getRequiredRotation() == 270) {
                                    z0(this.s0, iVar2.f11060f.left, iVar2.f11060f.bottom, iVar2.f11060f.left, iVar2.f11060f.top, iVar2.f11060f.right, iVar2.f11060f.top, iVar2.f11060f.right, iVar2.f11060f.bottom);
                                }
                                this.p0.setPolyToPoly(this.r0, 0, this.s0, 0, 4);
                                canvas.drawBitmap(iVar2.f11057c, this.p0, this.l0);
                                if (this.k) {
                                    canvas.drawRect(iVar2.f11060f, this.m0);
                                }
                            }
                            if (iVar2.f11059e && this.k) {
                                canvas.drawText("ISS " + iVar2.f11056b + " RECT " + iVar2.f11055a.top + "," + iVar2.f11055a.left + "," + iVar2.f11055a.bottom + "," + iVar2.f11055a.right, iVar2.f11060f.left + 5, iVar2.f11060f.top + 15, this.m0);
                            }
                        }
                    }
                }
                if (this.k) {
                    canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.A)), 5.0f, 15.0f, this.m0);
                    canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.C.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.C.y)), 5.0f, 35.0f, this.m0);
                    PointF center = getCenter();
                    canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), 5.0f, 55.0f, this.m0);
                    c cVar = this.f0;
                    if (cVar != null) {
                        PointF B02 = B0(cVar.f11030c);
                        PointF B03 = B0(this.f0.f11032e);
                        PointF B04 = B0(this.f0.f11031d);
                        canvas.drawCircle(B02.x, B02.y, 10.0f, this.m0);
                        canvas.drawCircle(B03.x, B03.y, 20.0f, this.m0);
                        canvas.drawCircle(B04.x, B04.y, 25.0f, this.m0);
                        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30.0f, this.m0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f11020e != null) {
                float f3 = this.A;
                if (this.f11021f) {
                    f3 *= this.H / bitmap.getWidth();
                    f2 = this.A * (this.I / this.f11020e.getHeight());
                } else {
                    f2 = f3;
                }
                if (this.p0 == null) {
                    this.p0 = new Matrix();
                }
                this.p0.reset();
                this.p0.postScale(f3, f2);
                this.p0.postRotate(getRequiredRotation());
                Matrix matrix = this.p0;
                PointF pointF = this.C;
                matrix.postTranslate(pointF.x, pointF.y);
                if (getRequiredRotation() == 180) {
                    Matrix matrix2 = this.p0;
                    float f4 = this.A;
                    matrix2.postTranslate(this.H * f4, f4 * this.I);
                } else if (getRequiredRotation() == 90) {
                    this.p0.postTranslate(this.A * this.I, 0.0f);
                } else if (getRequiredRotation() == 270) {
                    this.p0.postTranslate(0.0f, this.A * this.H);
                }
                if (this.n0 != null) {
                    if (this.q0 == null) {
                        this.q0 = new RectF();
                    }
                    this.q0.set(0.0f, 0.0f, this.H, this.I);
                    this.p0.mapRect(this.q0);
                    canvas.drawRect(this.q0, this.n0);
                }
                Bitmap bitmap2 = this.f11020e;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    canvas.drawBitmap(this.f11020e, this.p0, this.l0);
                } else {
                    Log.i("HugePhotoDraweeView", "onDraw-> Bitmap is NULL or Recycled <--");
                }
            }
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.H > 0 && this.I > 0) {
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

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        PointF center = getCenter();
        if (!this.g0 || center == null) {
            return;
        }
        this.f0 = null;
        this.E = Float.valueOf(this.A);
        this.F = center;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0093, code lost:
        if (r6 != 262) goto L53;
     */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        c cVar = this.f0;
        if (cVar != null && !cVar.f11036i) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        c cVar2 = this.f0;
        if (cVar2 != null && cVar2.l != null) {
            try {
                this.f0.l.a();
            } catch (Exception e2) {
                Log.w("HugePhotoDraweeView", "Error thrown by animation listener", e2);
            }
        }
        this.f0 = null;
        if (this.u0 && this.C == null) {
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
                                    float k0 = k0();
                                    float f2 = this.A;
                                    if (f2 <= k0) {
                                        Log.i("HugePhotoDraweeView", "scale is " + this.A + "<= minScaleValue is " + k0);
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
                                        this.C.x = (getWidth() / 2) - (this.A * (y0() / 2));
                                        this.C.y = (getHeight() / 2) - (this.A * (x0() / 2));
                                    }
                                    a0(true);
                                    s0(false);
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
                                    float max = Math.max(k0(), Math.min(this.n, this.A * (this.c0 > 0.0f ? z2 ? abs2 + 1.0f : 1.0f - abs2 : 1.0f)));
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
                                        this.C.x = (getWidth() / 2) - (this.A * (y0() / 2));
                                        this.C.y = (getHeight() / 2) - (this.A * (x0() / 2));
                                    }
                                }
                                this.c0 = abs;
                                a0(true);
                                s0(false);
                            } else if (!this.M) {
                                float abs3 = Math.abs(motionEvent.getX() - this.V.x);
                                float abs4 = Math.abs(motionEvent.getY() - this.V.y);
                                float f11 = this.t0 * 5.0f;
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
                                        this.k0.removeMessages(1);
                                        getParent().requestDisallowInterceptTouchEvent(false);
                                    }
                                    if (!this.u) {
                                        PointF pointF9 = this.C;
                                        PointF pointF10 = this.D;
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
                        this.k0.removeMessages(1);
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
            this.k0.removeMessages(1);
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
            s0(true);
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
            this.k0.removeMessages(1);
        } else if (!this.O) {
            PointF pointF15 = this.D;
            PointF pointF16 = this.C;
            pointF15.set(pointF16.x, pointF16.y);
            this.V.set(motionEvent.getX(), motionEvent.getY());
            this.k0.sendEmptyMessageDelayed(1, 600L);
        }
        return true;
    }

    public final synchronized void p0() {
        Q();
        P();
        if (g0() && this.f11020e != null) {
            if (!this.f11022g) {
                this.f11020e.recycle();
            }
            this.f11020e = null;
            this.f11021f = false;
            this.f11022g = false;
        }
        invalidate();
    }

    public final synchronized void q0(d.a.i0.a.i1.e.d.d dVar, int i2, int i3, int i4) {
        if (this.H > 0 && this.I > 0 && (this.H != i2 || this.I != i3)) {
            t0(false);
            if (this.f11020e != null) {
                if (!this.f11022g) {
                    this.f11020e.recycle();
                }
                this.f11020e = null;
                this.f11021f = false;
                this.f11022g = false;
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

    public final void r0() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.H <= 0 || this.I <= 0) {
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
            s0(true);
        }
        a0(false);
    }

    public final void s0(boolean z) {
        if (this.R == null || this.j == null) {
            return;
        }
        int min = Math.min(this.f11024i, O(this.A));
        for (Map.Entry<Integer, List<i>> entry : this.j.entrySet()) {
            for (i iVar : entry.getValue()) {
                if (iVar.f11056b < min || (iVar.f11056b > min && iVar.f11056b != this.f11024i)) {
                    iVar.f11059e = false;
                    if (iVar.f11057c != null) {
                        iVar.f11057c.recycle();
                        iVar.f11057c = null;
                    }
                }
                if (iVar.f11056b != min) {
                    if (iVar.f11056b == this.f11024i) {
                        iVar.f11059e = true;
                    }
                } else if (F0(iVar)) {
                    iVar.f11059e = true;
                    if (!iVar.f11058d && iVar.f11057c == null && z) {
                        Y(new j(this, this.R, iVar));
                    }
                } else if (iVar.f11056b != this.f11024i) {
                    iVar.f11059e = false;
                    if (iVar.f11057c != null) {
                        iVar.f11057c.recycle();
                        iVar.f11057c = null;
                    }
                }
            }
        }
    }

    public final void setBitmapDecoderClass(Class<? extends d.a.i0.a.i1.e.d.c> cls) {
        if (cls == null) {
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", "bitmapDecoderClass is null");
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.T = new d.a.i0.a.i1.e.d.a(cls);
    }

    public final void setBitmapDecoderFactory(d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.c> bVar) {
        if (bVar == null) {
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", "bitmapDecoderFactory is null");
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.T = bVar;
    }

    public final void setDebug(boolean z) {
        this.k = z;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.z = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.x = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (!z0.contains(Integer.valueOf(i2))) {
            String str = "Invalid zoom style: " + i2;
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", str);
                return;
            }
            throw new IllegalArgumentException(str);
        }
        this.y = i2;
    }

    public final void setImage(d.a.i0.a.i1.e.b bVar) {
        setImage(bVar, null, null);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        d.a.i0.a.i1.e.c.b(getContext(), drawable);
        super.setImageDrawable(drawable);
    }

    public void setIsDynamicBitmap(boolean z) {
        this.u0 = z;
    }

    public final void setMaxScale(float f2) {
        this.n = f2;
    }

    public void setMaxTileSize(int i2) {
        this.r = i2;
        this.s = i2;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i2);
    }

    public final void setMinScale(float f2) {
        this.m = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale((((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) * 2.0f) / i2);
    }

    public final void setMinimumScaleType(int i2) {
        if (!C0.contains(Integer.valueOf(i2))) {
            String str = "Invalid scale type: " + i2;
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", str);
                return;
            }
            throw new IllegalArgumentException(str);
        }
        this.q = i2;
        if (h0()) {
            a0(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.o = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i2);
        if (h0()) {
            t0(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(g gVar) {
        this.i0 = gVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.j0 = onLongClickListener;
    }

    public final void setOrientation(int i2) {
        if (!y0.contains(Integer.valueOf(i2))) {
            String str = "Invalid orientation: " + i2;
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", str);
                return;
            }
            throw new IllegalArgumentException(str);
        }
        this.l = i2;
        t0(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.u = z;
        if (z || (pointF = this.C) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.A * (y0() / 2));
        this.C.y = (getHeight() / 2) - (this.A * (x0() / 2));
        if (h0()) {
            s0(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i2) {
        if (!B0.contains(Integer.valueOf(i2))) {
            String str = "Invalid pan limit: " + i2;
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", str);
                return;
            }
            throw new IllegalArgumentException(str);
        }
        this.p = i2;
        if (h0()) {
            a0(true);
            invalidate();
        }
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.t = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.w = z;
    }

    public final void setRegionDecoderClass(Class<? extends d.a.i0.a.i1.e.d.d> cls) {
        if (cls == null) {
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", "regionDecoderClass is null");
                return;
            }
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.U = new d.a.i0.a.i1.e.d.a(cls);
    }

    public final void setRegionDecoderFactory(d.a.i0.a.i1.e.d.b<? extends d.a.i0.a.i1.e.d.d> bVar) {
        if (bVar == null) {
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", "setRegionDecoderFactory is null");
                return;
            }
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.U = bVar;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.f0 = null;
        this.E = Float.valueOf(f2);
        this.F = pointF;
        this.G = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.n0 = null;
        } else {
            Paint paint = new Paint();
            this.n0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.n0.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.v = z;
    }

    public final void t0(boolean z) {
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
        this.f11024i = 0;
        this.V = null;
        this.W = 0.0f;
        this.b0 = null;
        this.c0 = 0.0f;
        this.d0 = null;
        this.e0 = false;
        this.f0 = null;
        this.o0 = null;
        this.p0 = null;
        this.q0 = null;
        if (z) {
            this.f11023h = null;
            if (this.R != null) {
                synchronized (this.S) {
                    this.R.recycle();
                    this.R = null;
                }
            }
            Bitmap bitmap = this.f11020e;
            if (bitmap != null && !this.f11022g) {
                bitmap.recycle();
            }
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = null;
            this.L = null;
            this.g0 = false;
            this.h0 = false;
            this.f11020e = null;
            this.f11021f = false;
            this.f11022g = false;
        }
        Map<Integer, List<i>> map = this.j;
        if (map != null) {
            for (Map.Entry<Integer, List<i>> entry : map.entrySet()) {
                for (i iVar : entry.getValue()) {
                    iVar.f11059e = false;
                    if (iVar.f11057c != null) {
                        iVar.f11057c.recycle();
                        iVar.f11057c = null;
                    }
                }
            }
            this.j = null;
        }
        setGestureDetector(getContext());
    }

    public final void u0() {
        if (this.A < k0()) {
            v0();
        }
    }

    public final void v0() {
        this.f0 = null;
        this.E = Float.valueOf(j0(0.0f));
        if (h0()) {
            this.F = new PointF(y0() / 2, x0() / 2);
        } else {
            this.F = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void w0(ImageViewState imageViewState) {
        if (imageViewState == null || imageViewState.getCenter() == null || !y0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.l = imageViewState.getOrientation();
        this.E = Float.valueOf(imageViewState.getScale());
        this.F = imageViewState.getCenter();
        invalidate();
    }

    public final int x0() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.I;
        }
        return this.H;
    }

    public final int y0() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.H;
        }
        return this.I;
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

    public final void setImage(d.a.i0.a.i1.e.b bVar, ImageViewState imageViewState) {
        setImage(bVar, null, imageViewState);
    }

    public final void setImage(d.a.i0.a.i1.e.b bVar, d.a.i0.a.i1.e.b bVar2) {
        setImage(bVar, bVar2, null);
    }

    public void setMaxTileSize(int i2, int i3) {
        this.r = i2;
        this.s = i3;
    }

    public final void setImage(d.a.i0.a.i1.e.b bVar, d.a.i0.a.i1.e.b bVar2, ImageViewState imageViewState) {
        if (bVar == null) {
            if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", "imageSource is null");
                return;
            }
            throw new NullPointerException("imageSource must not be null");
        }
        t0(true);
        if (imageViewState != null) {
            w0(imageViewState);
        }
        if (bVar2 != null) {
            if (bVar.c() != null) {
                if (!x0) {
                    d.a.i0.a.e0.d.h("HugePhotoDraweeView", "imageSource get bitmap is not null");
                    return;
                }
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (bVar.g() > 0 && bVar.e() > 0) {
                this.H = bVar.g();
                this.I = bVar.e();
                this.L = bVar2.f();
                if (bVar2.c() != null) {
                    this.f11022g = bVar2.j();
                    n0(bVar2.c());
                } else {
                    Uri i2 = bVar2.i();
                    if (i2 == null && bVar2.d() != null) {
                        i2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar2.d());
                    }
                    Y(new e(this, getContext(), this.T, i2, true));
                }
            } else if (!x0) {
                d.a.i0.a.e0.d.h("HugePhotoDraweeView", "imageSource width or height invalid");
                return;
            } else {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
        }
        if (bVar.c() != null && bVar.f() != null) {
            m0(Bitmap.createBitmap(bVar.c(), bVar.f().left, bVar.f().top, bVar.f().width(), bVar.f().height()), 0, false);
        } else if (bVar.c() != null && !bVar.h()) {
            m0(bVar.c(), 0, bVar.j());
        } else {
            this.K = bVar.f();
            Uri i3 = bVar.i();
            this.f11023h = i3;
            if (i3 == null && bVar.d() != null) {
                this.f11023h = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + bVar.d());
            }
            if (!bVar.h() && this.K == null) {
                Y(new e(this, getContext(), this.T, this.f11023h, false));
            } else {
                Y(new k(this, getContext(), this.U, bVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public float f11028a;

        /* renamed from: b  reason: collision with root package name */
        public float f11029b;

        /* renamed from: c  reason: collision with root package name */
        public PointF f11030c;

        /* renamed from: d  reason: collision with root package name */
        public PointF f11031d;

        /* renamed from: e  reason: collision with root package name */
        public PointF f11032e;

        /* renamed from: f  reason: collision with root package name */
        public PointF f11033f;

        /* renamed from: g  reason: collision with root package name */
        public PointF f11034g;

        /* renamed from: h  reason: collision with root package name */
        public long f11035h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11036i;
        public int j;
        public long k;
        public f l;

        public c() {
            this.f11035h = 500L;
            this.f11036i = true;
            this.j = 2;
            this.k = System.currentTimeMillis();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public HugePhotoDraweeView(Context context) {
        this(context, null);
    }
}
