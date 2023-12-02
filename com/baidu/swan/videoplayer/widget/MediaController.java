package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.tieba.jn4;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class MediaController extends RelativeLayout {
    public boolean A;
    public LinearLayout B;
    public LinearLayout C;
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public SeekBar e;
    public TextView f;
    public View g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public long n;
    public Timer o;
    public Handler p;
    public Timer q;
    public SwanVideoView r;
    public boolean s;
    public boolean t;
    public jn4 u;
    public boolean v;
    public boolean w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    public void s(boolean z) {
    }

    /* loaded from: classes4.dex */
    public class a extends TimerTask {

        /* renamed from: com.baidu.swan.videoplayer.widget.MediaController$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0210a implements Runnable {
            public RunnableC0210a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaController.this.k();
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MediaController.this.getMainThreadHandler().post(new RunnableC0210a());
        }
    }

    /* loaded from: classes4.dex */
    public class j extends TimerTask {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.this.r != null && MediaController.this.r.getVideoPlayerCallback() != null) {
                    MediaController.this.r.getVideoPlayerCallback().c(MediaController.this.r);
                }
                MediaController.this.n();
            }
        }

        public j() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MediaController.this.getMainThreadHandler().post(new a());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (MediaController.this.r != null) {
                if (MediaController.this.r.z()) {
                    if (MediaController.this.a.getVisibility() == 0) {
                        MediaController.this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                    }
                    if (MediaController.this.i.getVisibility() == 0) {
                        MediaController.this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                    }
                    MediaController.this.r.C();
                    return;
                }
                Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                if (MediaController.this.a.getVisibility() == 0) {
                    MediaController.this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fd);
                }
                if (MediaController.this.i.getVisibility() == 0) {
                    MediaController.this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fd);
                }
                MediaController.this.r.X();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements SeekBar.OnSeekBarChangeListener {
        public c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MediaController.this.s = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (MediaController.this.r.getDuration() > 0) {
                MediaController.this.n = seekBar.getProgress();
                if (MediaController.this.r != null) {
                    MediaController.this.r.H(seekBar.getProgress());
                }
            }
            MediaController.this.s = false;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            MediaController.this.D(i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z = !MediaController.this.r.y();
            if (MediaController.this.r != null) {
                MediaController.this.r.setMuted(z);
            }
            if (MediaController.this.u != null) {
                MediaController.this.u.b(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (MediaController.this.u != null) {
                MediaController.this.u.d(!MediaController.this.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (MediaController.this.v && MediaController.this.u != null) {
                MediaController.this.u.d(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MediaController.this.B();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MediaController.this.r.R();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MediaController.this.r.U();
        }
    }

    public MediaController(Context context) {
        super(context);
        this.t = false;
        this.v = false;
        this.w = false;
        m();
    }

    private void setMax(int i2) {
        if (this.t) {
            return;
        }
        SeekBar seekBar = this.e;
        if (seekBar != null) {
            seekBar.setMax(i2);
        }
        C(i2);
        if (i2 > 0) {
            this.t = true;
        }
    }

    public final void C(int i2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(j(i2));
        }
    }

    public final void D(int i2) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(j(i2));
        }
    }

    public void i(SwanVideoView swanVideoView) {
        this.r = swanVideoView;
    }

    public void o(int i2) {
        SeekBar seekBar = this.e;
        if (seekBar != null && i2 != seekBar.getSecondaryProgress()) {
            this.e.setSecondaryProgress(i2);
        }
    }

    public void r(boolean z) {
        int i2;
        this.A = z;
        ImageView imageView = this.a;
        if (imageView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void setMute(boolean z) {
        int i2;
        ImageView imageView = this.c;
        if (imageView != null) {
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f08150a;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f081509;
            }
            imageView.setImageResource(i2);
        }
    }

    public void setProgress(int i2) {
        SeekBar seekBar = this.e;
        if (seekBar != null) {
            seekBar.setProgress(i2);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setToggleScreenListener(jn4 jn4Var) {
        this.u = jn4Var;
    }

    public void t(boolean z) {
        int i2;
        ImageView imageView = this.c;
        if (imageView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void u(boolean z) {
        int i2;
        ImageView imageView = this.i;
        if (imageView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void v(boolean z) {
        int i2;
        this.z = z;
        TextView textView = this.l;
        if (textView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }

    public void w(boolean z) {
        int i2;
        int i3;
        SeekBar seekBar = this.e;
        int i4 = 0;
        if (seekBar != null) {
            if (z) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            seekBar.setVisibility(i3);
        }
        TextView textView = this.f;
        if (textView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            textView.setVisibility(i2);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            if (!z) {
                i4 = 4;
            }
            textView2.setVisibility(i4);
        }
    }

    public void x(boolean z) {
        this.w = z;
    }

    public void y(boolean z) {
        int i2;
        ImageView imageView = this.b;
        if (imageView != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = false;
        this.v = false;
        this.w = false;
        m();
    }

    public static String j(int i2) {
        if (i2 < 0) {
            return "";
        }
        int i3 = i2 / 1000;
        int i4 = i3 / 3600;
        int i5 = (i3 % 3600) / 60;
        int i6 = i3 % 60;
        if (i4 != 0) {
            return String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        }
        return String.format(Locale.US, "%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public final void A() {
        Timer timer = this.o;
        if (timer != null) {
            timer.cancel();
            this.o = null;
        }
    }

    public Handler getMainThreadHandler() {
        if (this.p == null) {
            this.p = new Handler(Looper.getMainLooper());
        }
        return this.p;
    }

    public void k() {
        setVisibility(8);
    }

    public void l() {
        q();
        Timer timer = this.q;
        if (timer != null) {
            timer.cancel();
            this.q = null;
        }
        Timer timer2 = new Timer();
        this.q = timer2;
        timer2.schedule(new a(), 3000L);
    }

    public void n() {
        int duration;
        SwanVideoView swanVideoView = this.r;
        if (swanVideoView != null && !this.s) {
            long currentPosition = swanVideoView.getCurrentPosition();
            if (currentPosition >= 0) {
                this.n = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.r.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }

    public final void q() {
        if (this.r == null) {
            return;
        }
        setProgress((int) this.n);
        setVisibility(0);
    }

    public final void z() {
        Timer timer = this.o;
        if (timer != null) {
            timer.cancel();
            this.o = null;
        }
        Timer timer2 = new Timer();
        this.o = timer2;
        timer2.schedule(new j(), 0L, 1000L);
    }

    public final void B() {
        int i2;
        boolean z = !this.y;
        this.y = z;
        int i3 = 8;
        if (z) {
            this.k.setImageResource(R.drawable.obfuscated_res_0x7f0814fc);
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.l.setVisibility(8);
            this.a.setVisibility(8);
        } else {
            this.k.setImageResource(R.drawable.obfuscated_res_0x7f081500);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            TextView textView = this.l;
            if (this.z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            ImageView imageView = this.a;
            if (this.A) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
        }
        SwanVideoView swanVideoView = this.r;
        if (swanVideoView != null) {
            swanVideoView.b0(this.y);
        }
    }

    public void E() {
        int currentPosition;
        int duration;
        int currentPlayerState = this.r.getCurrentPlayerState();
        int i2 = 0;
        this.t = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                A();
                this.a.setEnabled(true);
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                this.i.setEnabled(true);
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                this.e.setEnabled(false);
                SwanVideoView swanVideoView = this.r;
                if (swanVideoView == null) {
                    currentPosition = 0;
                } else {
                    currentPosition = swanVideoView.getCurrentPosition();
                }
                D(currentPosition);
                SwanVideoView swanVideoView2 = this.r;
                if (swanVideoView2 != null) {
                    i2 = swanVideoView2.getDuration();
                }
                C(i2);
                return;
            case 1:
                this.a.setEnabled(false);
                this.i.setEnabled(false);
                this.e.setEnabled(false);
                return;
            case 2:
                this.a.setEnabled(true);
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                this.i.setEnabled(true);
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                this.e.setEnabled(true);
                SwanVideoView swanVideoView3 = this.r;
                if (swanVideoView3 == null) {
                    duration = 0;
                } else {
                    duration = swanVideoView3.getDuration();
                }
                C(duration);
                SeekBar seekBar = this.e;
                SwanVideoView swanVideoView4 = this.r;
                if (swanVideoView4 != null) {
                    i2 = swanVideoView4.getDuration();
                }
                seekBar.setMax(i2);
                return;
            case 3:
                z();
                this.e.setEnabled(true);
                this.a.setEnabled(true);
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fd);
                this.i.setEnabled(true);
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fd);
                return;
            case 4:
                this.a.setEnabled(true);
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                this.i.setEnabled(true);
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                return;
            case 5:
                A();
                SeekBar seekBar2 = this.e;
                seekBar2.setProgress(seekBar2.getMax());
                this.e.setEnabled(false);
                this.a.setEnabled(true);
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                this.i.setEnabled(true);
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0814fe);
                return;
            default:
                return;
        }
    }

    public final void m() {
        boolean z;
        int i2;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0968, this);
        this.B = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09242d);
        this.C = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092423);
        this.x = new b();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092428);
        this.a = imageView;
        imageView.setOnClickListener(this.x);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092429);
        this.i = imageView2;
        imageView2.setOnClickListener(this.x);
        this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09242f);
        this.e = (SeekBar) inflate.findViewById(R.id.obfuscated_res_0x7f09242c);
        this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09242e);
        this.e.setOnSeekBarChangeListener(new c());
        this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092427);
        SwanVideoView swanVideoView = this.r;
        if (swanVideoView != null && swanVideoView.y()) {
            z = true;
        } else {
            z = false;
        }
        ImageView imageView3 = this.c;
        if (z) {
            i2 = R.drawable.obfuscated_res_0x7f08150a;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f081509;
        }
        imageView3.setImageResource(i2);
        this.c.setOnClickListener(new d());
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09242b);
        this.b = imageView4;
        imageView4.setOnClickListener(new e());
        this.e.setEnabled(false);
        this.a.setEnabled(false);
        this.i.setEnabled(false);
        View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092424);
        this.g = findViewById;
        findViewById.setOnClickListener(new f());
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092431);
        this.h = textView;
        textView.setVisibility(4);
        this.g.setVisibility(8);
        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092425);
        this.j = imageView5;
        imageView5.setVisibility(8);
        ImageView imageView6 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092426);
        this.k = imageView6;
        imageView6.setVisibility(8);
        this.k.setOnClickListener(new g());
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092430);
        this.l = textView2;
        textView2.setOnClickListener(new h());
        View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f09242a);
        this.m = findViewById2;
        findViewById2.setVisibility(8);
        this.m.setOnClickListener(new i());
    }

    public void p(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        this.v = z;
        ImageView imageView = this.b;
        if (z) {
            i2 = R.drawable.obfuscated_res_0x7f0814fb;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f0814fa;
        }
        imageView.setImageResource(i2);
        int i7 = 8;
        int i8 = 0;
        if (this.v) {
            this.h.setVisibility(0);
            this.g.setVisibility(0);
            this.k.setVisibility(0);
            View view2 = this.m;
            if (this.w) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
            LinearLayout linearLayout = this.B;
            if (this.y) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            linearLayout.setVisibility(i4);
            LinearLayout linearLayout2 = this.C;
            if (this.y) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            linearLayout2.setVisibility(i5);
            ImageView imageView2 = this.a;
            if (!this.y && this.A) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            imageView2.setVisibility(i6);
            TextView textView = this.l;
            if (!this.y && this.z) {
                i7 = 0;
            }
            textView.setVisibility(i7);
            return;
        }
        this.h.setVisibility(4);
        this.g.setVisibility(8);
        this.k.setVisibility(8);
        this.C.setVisibility(0);
        TextView textView2 = this.l;
        if (!this.z) {
            i8 = 8;
        }
        textView2.setVisibility(i8);
        this.m.setVisibility(8);
    }
}
