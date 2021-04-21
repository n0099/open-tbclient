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
import d.b.d0.a.f.d;
import d.b.d0.a.f.e;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class GifAnimView extends View implements d.b.d0.a.f.a {

    /* renamed from: e  reason: collision with root package name */
    public d.b.d0.a.f.b f11195e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f11196f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11197g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11198h;
    public int i;
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

        GifImageType(int i) {
            this.nativeInt = i;
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
        public static final /* synthetic */ int[] f11200a;

        static {
            int[] iArr = new int[GifImageType.values().length];
            f11200a = iArr;
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11200a[GifImageType.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11200a[GifImageType.SYNC_DECODER.ordinal()] = 3;
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
            if (GifAnimView.this.f11195e == null) {
                return;
            }
            while (GifAnimView.this.f11197g) {
                if (!GifAnimView.this.f11198h) {
                    d.b.d0.a.f.c i = GifAnimView.this.f11195e.i();
                    GifAnimView.this.f11196f = i.f43359a;
                    long j = i.f43360b;
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
        this.f11195e = null;
        this.f11196f = null;
        this.f11197g = true;
        this.f11198h = false;
        this.i = -1;
        this.j = null;
        this.k = null;
        this.l = GifImageType.SYNC_DECODER;
        this.m = true;
        this.p = 255;
        this.q = new a();
    }

    private void setGifDecoderImage(byte[] bArr) {
        d.b.d0.a.f.b bVar = this.f11195e;
        if (bVar != null) {
            bVar.c();
            this.f11195e = null;
        }
        d.b.d0.a.f.b bVar2 = new d.b.d0.a.f.b(bArr, this);
        this.f11195e = bVar2;
        bVar2.start();
    }

    @Override // d.b.d0.a.f.a
    public void a(boolean z, int i) {
        if (!z || this.f11195e == null) {
            return;
        }
        int i2 = b.f11200a[this.l.ordinal()];
        if (i2 == 1) {
            if (i == -1) {
                if (this.f11195e.e() > 1) {
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
                this.f11196f = this.f11195e.g();
                h();
            } else if (i == -1) {
                h();
            } else if (this.k == null) {
                c cVar = new c(this, null);
                this.k = cVar;
                cVar.start();
            }
        } else if (i == 1) {
            this.f11196f = this.f11195e.g();
            h();
        } else if (i == -1) {
            if (this.f11195e.e() > 1) {
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
        this.f11198h = false;
    }

    public void j() {
        this.f11198h = true;
        this.f11197g = false;
        d.b.d0.a.f.b bVar = this.f11195e;
        if (bVar != null) {
            bVar.c();
            this.f11195e = null;
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
        d.b.d0.a.f.b bVar = this.f11195e;
        if (bVar == null) {
            return;
        }
        if (this.f11196f == null) {
            this.f11196f = bVar.g();
        }
        if (this.f11196f == null) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        Paint paint = new Paint();
        paint.setAlpha(this.p);
        if (this.i == -1) {
            canvas.drawBitmap(this.f11196f, 0.0f, 0.0f, paint);
        } else {
            canvas.drawBitmap(this.f11196f, (Rect) null, this.j, paint);
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
    public void onMeasure(int i, int i2) {
        int i3;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        d.b.d0.a.f.b bVar = this.f11195e;
        int i4 = 1;
        if (bVar == null) {
            i3 = 1;
        } else {
            i4 = bVar.f43357g;
            i3 = bVar.f43358h;
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i2));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f11198h = i != 0;
    }

    public void setAlpha(int i) {
        this.p = i;
        invalidate();
    }

    public void setGifImage(byte[] bArr) {
        setGifDecoderImage(bArr);
    }

    public void setGifImageType(GifImageType gifImageType) {
        if (this.f11195e == null) {
            this.l = gifImageType;
        }
    }

    public void setShowDimension(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.i = i;
        Rect rect = new Rect();
        this.j = rect;
        rect.left = 0;
        rect.top = 0;
        rect.right = i;
        rect.bottom = i2;
    }

    public void setGifImage(InputStream inputStream) {
        setGifDecoderImage(inputStream);
    }

    public void setGifImage(int i) {
        setGifDecoderImage(getResources().openRawResource(i));
    }

    private void setGifDecoderImage(InputStream inputStream) {
        d.b.d0.a.f.b bVar = this.f11195e;
        if (bVar != null) {
            bVar.c();
            this.f11195e = null;
        }
        d.b.d0.a.f.b bVar2 = new d.b.d0.a.f.b(inputStream, this);
        this.f11195e = bVar2;
        bVar2.start();
    }

    public GifAnimView(Context context, d dVar) {
        this(context);
        this.o = dVar;
    }
}
