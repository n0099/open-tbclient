package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.swan.videoplayer.SwanVideoView;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class MediaController extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f12654e;

    /* renamed from: f  reason: collision with root package name */
    public View f12655f;

    /* renamed from: g  reason: collision with root package name */
    public View f12656g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12657h;

    /* renamed from: i  reason: collision with root package name */
    public SeekBar f12658i;
    public TextView j;
    public long k;
    public Timer l;
    public Handler m;
    public Timer n;
    public SwanVideoView o;
    public boolean p;
    public boolean q;
    public d.a.h0.s.h.a r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MediaController.this.o == null) {
                return;
            }
            if (MediaController.this.o.v()) {
                MediaController.this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_play);
                MediaController.this.o.x();
                return;
            }
            Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
            MediaController.this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_pause);
            MediaController.this.o.C();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            MediaController.this.r(i2);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MediaController.this.p = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (MediaController.this.o.getDuration() > 0) {
                MediaController.this.k = seekBar.getProgress();
                if (MediaController.this.o != null) {
                    MediaController.this.o.B(seekBar.getProgress());
                }
            }
            MediaController.this.p = false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MediaController.this.o != null) {
                MediaController.this.o.setMuted(!MediaController.this.o.u());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f12662e;

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f12662e = !this.f12662e;
            if (MediaController.this.r != null) {
                MediaController.this.r.b(this.f12662e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends TimerTask {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MediaController.this.o != null && MediaController.this.o.getVideoPlayerCallback() != null) {
                    MediaController.this.o.getVideoPlayerCallback().a(MediaController.this.o);
                }
                MediaController.this.k();
            }
        }

        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MediaController.this.getMainThreadHandler().post(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class f extends TimerTask {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaController.this.h();
            }
        }

        public f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MediaController.this.getMainThreadHandler().post(new a());
        }
    }

    public MediaController(Context context) {
        super(context);
        this.q = false;
        j();
    }

    public static String g(int i2) {
        if (i2 < 0) {
            return "";
        }
        int i3 = i2 / 1000;
        int i4 = i3 / 3600;
        int i5 = (i3 % 3600) / 60;
        int i6 = i3 % 60;
        return i4 != 0 ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private void setMax(int i2) {
        if (this.q) {
            return;
        }
        SeekBar seekBar = this.f12658i;
        if (seekBar != null) {
            seekBar.setMax(i2);
        }
        q(i2);
        if (i2 > 0) {
            this.q = true;
        }
    }

    public void f(SwanVideoView swanVideoView) {
        this.o = swanVideoView;
    }

    public Handler getMainThreadHandler() {
        if (this.m == null) {
            this.m = new Handler(Looper.getMainLooper());
        }
        return this.m;
    }

    public void h() {
        setVisibility(8);
    }

    public void i() {
        n();
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n = null;
        }
        Timer timer2 = new Timer();
        this.n = timer2;
        timer2.schedule(new f(), 3000L);
    }

    public final void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.a.h0.s.e.media_controller, this);
        ImageButton imageButton = (ImageButton) inflate.findViewById(d.a.h0.s.d.btn_play);
        this.f12654e = imageButton;
        imageButton.setOnClickListener(new a());
        this.f12657h = (TextView) inflate.findViewById(d.a.h0.s.d.tv_position);
        this.f12658i = (SeekBar) inflate.findViewById(d.a.h0.s.d.seekbar);
        this.j = (TextView) inflate.findViewById(d.a.h0.s.d.tv_duration);
        this.f12658i.setOnSeekBarChangeListener(new b());
        this.f12656g = inflate.findViewById(d.a.h0.s.d.btn_mute);
        SwanVideoView swanVideoView = this.o;
        this.f12656g.setBackgroundResource(swanVideoView != null && swanVideoView.u() ? d.a.h0.s.c.mute_on : d.a.h0.s.c.mute_off);
        this.f12656g.setOnClickListener(new c());
        View findViewById = inflate.findViewById(d.a.h0.s.d.btn_toggle_screen);
        this.f12655f = findViewById;
        findViewById.setOnClickListener(new d());
        this.f12658i.setEnabled(false);
        this.f12654e.setEnabled(false);
    }

    public void k() {
        int duration;
        SwanVideoView swanVideoView = this.o;
        if (swanVideoView == null || this.p) {
            return;
        }
        long currentPosition = swanVideoView.getCurrentPosition();
        if (currentPosition > 0) {
            this.k = currentPosition;
        }
        if (getVisibility() == 0 && (duration = this.o.getDuration()) > 0) {
            setMax(duration);
            setProgress((int) currentPosition);
        }
    }

    public void l(int i2) {
        SeekBar seekBar = this.f12658i;
        if (seekBar == null || i2 == seekBar.getSecondaryProgress()) {
            return;
        }
        this.f12658i.setSecondaryProgress(i2);
    }

    public void m(boolean z) {
        this.f12655f.setBackgroundResource(z ? d.a.h0.s.c.btn_halfscreen : d.a.h0.s.c.btn_fullscreen);
    }

    public final void n() {
        if (this.o == null) {
            return;
        }
        setProgress((int) this.k);
        setVisibility(0);
    }

    public final void o() {
        Timer timer = this.l;
        if (timer != null) {
            timer.cancel();
            this.l = null;
        }
        Timer timer2 = new Timer();
        this.l = timer2;
        timer2.schedule(new e(), 0L, 1000L);
    }

    public final void p() {
        Timer timer = this.l;
        if (timer != null) {
            timer.cancel();
            this.l = null;
        }
    }

    public final void q(int i2) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(g(i2));
        }
    }

    public final void r(int i2) {
        TextView textView = this.f12657h;
        if (textView != null) {
            textView.setText(g(i2));
        }
    }

    public void s() {
        int currentPlayerState = this.o.getCurrentPlayerState();
        this.q = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                p();
                this.f12654e.setEnabled(true);
                this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_play);
                this.f12658i.setEnabled(false);
                SwanVideoView swanVideoView = this.o;
                r(swanVideoView == null ? 0 : swanVideoView.getCurrentPosition());
                SwanVideoView swanVideoView2 = this.o;
                q(swanVideoView2 != null ? swanVideoView2.getDuration() : 0);
                return;
            case 1:
                this.f12654e.setEnabled(false);
                this.f12658i.setEnabled(false);
                return;
            case 2:
                this.f12654e.setEnabled(true);
                this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_play);
                this.f12658i.setEnabled(true);
                SwanVideoView swanVideoView3 = this.o;
                q(swanVideoView3 == null ? 0 : swanVideoView3.getDuration());
                SeekBar seekBar = this.f12658i;
                SwanVideoView swanVideoView4 = this.o;
                seekBar.setMax(swanVideoView4 != null ? swanVideoView4.getDuration() : 0);
                return;
            case 3:
                o();
                this.f12658i.setEnabled(true);
                this.f12654e.setEnabled(true);
                this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_pause);
                return;
            case 4:
                this.f12654e.setEnabled(true);
                this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_play);
                return;
            case 5:
                p();
                SeekBar seekBar2 = this.f12658i;
                seekBar2.setProgress(seekBar2.getMax());
                this.f12658i.setEnabled(false);
                this.f12654e.setEnabled(true);
                this.f12654e.setBackgroundResource(d.a.h0.s.c.btn_play);
                return;
            default:
                return;
        }
    }

    public void setMute(boolean z) {
        View view = this.f12656g;
        if (view != null) {
            view.setBackgroundResource(z ? d.a.h0.s.c.mute_on : d.a.h0.s.c.mute_off);
        }
    }

    public void setProgress(int i2) {
        SeekBar seekBar = this.f12658i;
        if (seekBar != null) {
            seekBar.setProgress(i2);
        }
    }

    public void setToggleScreenListener(d.a.h0.s.h.a aVar) {
        this.r = aVar;
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        j();
    }
}
