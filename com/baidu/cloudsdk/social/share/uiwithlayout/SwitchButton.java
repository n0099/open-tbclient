package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.az;
import com.baidu.location.LocationClientOption;
import com.i;
/* loaded from: classes.dex */
public class SwitchButton extends CheckBox {
    private boolean A;
    private b B;
    private CompoundButton.OnCheckedChangeListener C;
    private CompoundButton.OnCheckedChangeListener D;
    private boolean E;
    private final float F;
    private float G;
    private float H;
    private float I;
    private Paint a;
    private ViewParent b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private RectF i;
    private PorterDuffXfermode j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private int u;
    private int v;
    private final int w;
    private int x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        private static final Handler a = new HandlerC0000a(null);

        /* renamed from: com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class HandlerC0000a extends Handler {
            private HandlerC0000a() {
            }

            /* synthetic */ HandlerC0000a(az azVar) {
                this();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                        if (message.obj != null) {
                            ((Runnable) message.obj).run();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public static void a(Runnable runnable) {
            Message message = new Message();
            message.what = LocationClientOption.MIN_SCAN_SPAN;
            message.obj = runnable;
            a.sendMessageDelayed(message, 16L);
        }
    }

    /* loaded from: classes.dex */
    final class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(SwitchButton switchButton, az azVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            SwitchButton.this.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(SwitchButton switchButton, az azVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwitchButton.this.E) {
                SwitchButton.this.c();
                a.a(this);
            }
        }
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842860);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 255;
        this.x = 255;
        this.y = false;
        this.F = 350.0f;
        a(context);
    }

    private float a(float f) {
        return f - (this.s / 2.0f);
    }

    private void a() {
        this.b = getParent();
        if (this.b != null) {
            this.b.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void a(Context context) {
        this.a = new Paint();
        this.a.setColor(-1);
        Resources resources = context.getApplicationContext().getResources();
        this.u = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.v = ViewConfiguration.get(context).getScaledTouchSlop();
        this.c = BitmapFactory.decodeResource(resources, i.b(context, "bdsocialshare_switch_background"));
        this.e = BitmapFactory.decodeResource(resources, i.c(context, "bdsocialshare_switch_round"));
        this.f = this.e;
        this.g = BitmapFactory.decodeResource(resources, i.b(context, "bdsocialshare_switch_frame"));
        this.h = BitmapFactory.decodeResource(resources, i.c(context, "bdsocialshare_switch_mask"));
        this.d = this.f;
        this.s = this.e.getWidth();
        this.q = this.h.getWidth();
        this.r = this.h.getHeight();
        this.p = this.q - (this.s / 2.0f);
        this.o = this.s / 2.0f;
        this.n = this.y ? this.o : this.p;
        this.m = a(this.n);
        this.G = (int) ((getResources().getDisplayMetrics().density * 350.0f) + 0.5f);
        this.i = new RectF(0.0f, 0.0f, this.h.getWidth(), this.h.getHeight());
        this.j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    private void a(boolean z) {
        postDelayed(new az(this, z), 10L);
    }

    private void b() {
        this.E = false;
    }

    private void b(float f) {
        this.n = f;
        this.m = a(this.n);
        invalidate();
    }

    private void b(boolean z) {
        this.E = true;
        this.I = z ? this.G : -this.G;
        this.H = this.n;
        new c(this, null).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.H += (this.I * 16.0f) / 1000.0f;
        if (this.H <= this.p) {
            b();
            this.H = this.p;
            a(false);
        } else if (this.H >= this.o) {
            b();
            this.H = this.o;
            a(true);
        }
        b(this.H);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.y;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(this.i, this.x, 31);
        canvas.drawBitmap(this.h, 0.0f, 0.0f, this.a);
        this.a.setXfermode(this.j);
        canvas.drawBitmap(this.c, this.m, 0.0f, this.a);
        this.a.setXfermode(null);
        canvas.drawBitmap(this.g, 0.0f, 0.0f, this.a);
        canvas.drawBitmap(this.d, this.m, 0.0f, this.a);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.q, (int) this.r);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float abs = Math.abs(x - this.l);
        float abs2 = Math.abs(y - this.k);
        switch (action) {
            case 0:
                a();
                this.l = x;
                this.k = y;
                this.d = this.e;
                this.t = this.y ? this.o : this.p;
                break;
            case 1:
                this.d = this.f;
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (abs2 < this.v && abs < this.v && eventTime < this.u) {
                    if (this.B == null) {
                        this.B = new b(this, null);
                    }
                    if (!post(this.B)) {
                        performClick();
                        break;
                    }
                } else {
                    b(this.A);
                    break;
                }
                break;
            case 2:
                float eventTime2 = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                this.n = (this.t + motionEvent.getX()) - this.l;
                if (this.n <= this.p) {
                    this.n = this.p;
                }
                if (this.n >= this.o) {
                    this.n = this.o;
                }
                this.A = this.n > ((this.o - this.p) / 2.0f) + this.p;
                this.m = a(this.n);
                break;
        }
        invalidate();
        return isEnabled();
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        b(!this.y);
        return true;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.y != z) {
            this.y = z;
            this.n = z ? this.o : this.p;
            this.m = a(this.n);
            invalidate();
            if (this.z) {
                return;
            }
            this.z = true;
            if (this.C != null) {
                this.C.onCheckedChanged(this, this.y);
            }
            if (this.D != null) {
                this.D.onCheckedChanged(this, this.y);
            }
            this.z = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        this.x = z ? 255 : 127;
        super.setEnabled(z);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.C = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!this.y);
    }
}
