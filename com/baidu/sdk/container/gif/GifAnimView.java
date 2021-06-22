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
import d.a.g0.a.f.d;
import d.a.g0.a.f.e;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class GifAnimView extends View implements d.a.g0.a.f.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.g0.a.f.b f10034e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f10035f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10036g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10037h;

    /* renamed from: i  reason: collision with root package name */
    public int f10038i;
    public Rect j;
    public c k;
    public GifImageType l;
    public boolean m;
    public e n;
    public d o;
    public int p;
    @SuppressLint({"HandlerLeak"})
    public Handler q;

    /* loaded from: classes2.dex */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        public final int nativeInt;

        GifImageType(int i2) {
            this.nativeInt = i2;
        }
    }

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GifAnimView.this.invalidate();
            if (GifAnimView.this.o != null) {
                GifAnimView.this.o.callback();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10040a;

        static {
            int[] iArr = new int[GifImageType.values().length];
            f10040a = iArr;
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10040a[GifImageType.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10040a[GifImageType.SYNC_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Thread {
        public c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (GifAnimView.this.f10034e == null) {
                return;
            }
            while (GifAnimView.this.f10036g) {
                if (!GifAnimView.this.f10037h) {
                    d.a.g0.a.f.c i2 = GifAnimView.this.f10034e.i();
                    GifAnimView.this.f10035f = i2.f43648a;
                    long j = i2.f43649b;
                    if (GifAnimView.this.q == null) {
                        return;
                    }
                    GifAnimView.this.q.sendMessage(GifAnimView.this.q.obtainMessage());
                    SystemClock.sleep(j);
                } else {
                    SystemClock.sleep(500L);
                }
            }
        }

        public /* synthetic */ c(GifAnimView gifAnimView, a aVar) {
            this();
        }
    }

    public GifAnimView(Context context) {
        super(context);
        this.f10034e = null;
        this.f10035f = null;
        this.f10036g = true;
        this.f10037h = false;
        this.f10038i = -1;
        this.j = null;
        this.k = null;
        this.l = GifImageType.SYNC_DECODER;
        this.m = true;
        this.p = 255;
        this.q = new a();
    }

    private void setGifDecoderImage(byte[] bArr) {
        d.a.g0.a.f.b bVar = this.f10034e;
        if (bVar != null) {
            bVar.c();
            this.f10034e = null;
        }
        d.a.g0.a.f.b bVar2 = new d.a.g0.a.f.b(bArr, this);
        this.f10034e = bVar2;
        bVar2.start();
    }

    @Override // d.a.g0.a.f.a
    public void a(boolean z, int i2) {
        if (!z || this.f10034e == null) {
            return;
        }
        int i3 = b.f10040a[this.l.ordinal()];
        if (i3 == 1) {
            if (i2 == -1) {
                if (this.f10034e.e() > 1) {
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
                this.f10035f = this.f10034e.g();
                h();
            } else if (i2 == -1) {
                h();
            } else if (this.k == null) {
                c cVar = new c(this, null);
                this.k = cVar;
                cVar.start();
            }
        } else if (i2 == 1) {
            this.f10035f = this.f10034e.g();
            h();
        } else if (i2 == -1) {
            if (this.f10034e.e() > 1) {
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

    public final void h() {
        Handler handler = this.q;
        if (handler != null) {
            this.q.sendMessage(handler.obtainMessage());
        }
    }

    public void i() {
        this.f10037h = false;
    }

    public void j() {
        this.f10037h = true;
        this.f10036g = false;
        d.a.g0.a.f.b bVar = this.f10034e;
        if (bVar != null) {
            bVar.c();
            this.f10034e = null;
        }
        if (this.n != null) {
            this.n = null;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        j();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d.a.g0.a.f.b bVar = this.f10034e;
        if (bVar == null) {
            return;
        }
        if (this.f10035f == null) {
            this.f10035f = bVar.g();
        }
        if (this.f10035f == null) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        Paint paint = new Paint();
        paint.setAlpha(this.p);
        if (this.f10038i == -1) {
            canvas.drawBitmap(this.f10035f, 0.0f, 0.0f, paint);
        } else {
            canvas.drawBitmap(this.f10035f, (Rect) null, this.j, paint);
        }
        canvas.restoreToCount(saveCount);
        e eVar = this.n;
        if (eVar == null || !this.m) {
            return;
        }
        eVar.onAdPresent();
        this.m = false;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        d.a.g0.a.f.b bVar = this.f10034e;
        int i5 = 1;
        if (bVar == null) {
            i4 = 1;
        } else {
            i5 = bVar.f43645g;
            i4 = bVar.f43646h;
        }
        setMeasuredDimension(View.resolveSize(Math.max(i5 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(i4 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i3));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f10037h = i2 != 0;
    }

    public void setAlpha(int i2) {
        this.p = i2;
        invalidate();
    }

    public void setGifImage(byte[] bArr) {
        setGifDecoderImage(bArr);
    }

    public void setGifImageType(GifImageType gifImageType) {
        if (this.f10034e == null) {
            this.l = gifImageType;
        }
    }

    public void setShowDimension(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f10038i = i2;
        Rect rect = new Rect();
        this.j = rect;
        rect.left = 0;
        rect.top = 0;
        rect.right = i2;
        rect.bottom = i3;
    }

    public void setGifImage(InputStream inputStream) {
        setGifDecoderImage(inputStream);
    }

    public void setGifImage(int i2) {
        setGifDecoderImage(getResources().openRawResource(i2));
    }

    private void setGifDecoderImage(InputStream inputStream) {
        d.a.g0.a.f.b bVar = this.f10034e;
        if (bVar != null) {
            bVar.c();
            this.f10034e = null;
        }
        d.a.g0.a.f.b bVar2 = new d.a.g0.a.f.b(inputStream, this);
        this.f10034e = bVar2;
        bVar2.start();
    }

    public GifAnimView(Context context, d dVar) {
        this(context);
        this.o = dVar;
    }
}
