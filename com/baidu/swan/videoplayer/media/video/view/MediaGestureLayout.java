package com.baidu.swan.videoplayer.media.video.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.tieba.mt4;
import com.baidu.tieba.nt4;
import com.baidu.tieba.ot4;
/* loaded from: classes4.dex */
public final class MediaGestureLayout extends FrameLayout implements nt4 {
    public mt4 a;
    public b b;
    public MediaVolume c;
    public MediaBrightness d;
    public MediaFastForward e;
    public SwanVideoView f;
    public ot4 g;

    /* loaded from: classes4.dex */
    public interface b {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode);

        void c(int i);

        void onDoubleTap(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public static class c implements b {
        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void a(MotionEvent motionEvent);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void c(int i);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void onDoubleTap(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            return MediaGestureLayout.this.a.a(motionEvent);
        }
    }

    public MediaGestureLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.nt4
    public boolean a(MotionEvent motionEvent) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(motionEvent);
            return true;
        }
        return true;
    }

    public void g(@NonNull ot4 ot4Var) {
        this.g = ot4Var;
    }

    public void h(@NonNull SwanVideoView swanVideoView) {
        this.f = swanVideoView;
    }

    public final void i(Context context) {
        mt4 mt4Var = new mt4(context);
        this.a = mt4Var;
        mt4Var.d(this);
        this.g = new ot4.b().f();
        setOnTouchListener(new a());
    }

    public final void j(Context context) {
        MediaVolume mediaVolume = new MediaVolume(context);
        this.c = mediaVolume;
        mediaVolume.setVisibility(8);
        addView(this.c);
        MediaBrightness mediaBrightness = new MediaBrightness(context);
        this.d = mediaBrightness;
        mediaBrightness.setVisibility(8);
        addView(this.d);
        MediaFastForward mediaFastForward = new MediaFastForward(context);
        this.e = mediaFastForward;
        mediaFastForward.setVisibility(8);
        addView(this.e);
    }

    @Override // com.baidu.tieba.nt4
    public boolean onDoubleTap(MotionEvent motionEvent) {
        b bVar;
        if (this.g.a() && (bVar = this.b) != null) {
            bVar.onDoubleTap(motionEvent);
            return true;
        }
        return true;
    }

    public void setMediaGestureListener(b bVar) {
        this.b = bVar;
    }

    public MediaGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j(context);
        i(context);
    }

    @Override // com.baidu.tieba.nt4
    public boolean b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        this.e.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        if (this.b != null && mediaGestureMode == MediaGestureMode.FAST_FORWARD && this.g.d()) {
            this.b.c(this.e.a());
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(motionEvent, mediaGestureMode);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.nt4
    public boolean c(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if ((this.g.f() && this.g.b()) || (!this.g.f() && this.g.e())) {
            float b2 = this.c.b() + (((motionEvent.getY() - motionEvent2.getY()) * this.c.c()) / (getHeight() * 0.8f));
            this.c.g(R.drawable.obfuscated_res_0x7f081449);
            this.c.h(b2);
            this.c.f();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.nt4
    public boolean d(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        if (this.g.d()) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float c2 = this.e.c() * x;
            this.e.h((int) (this.e.b() + (c2 / (getWidth() * 0.8f))));
            MediaFastForward mediaFastForward = this.e;
            if (x > 0.0f) {
                i = R.drawable.obfuscated_res_0x7f081445;
            } else {
                i = R.drawable.obfuscated_res_0x7f081446;
            }
            mediaFastForward.g(i);
            this.e.f();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.nt4
    public boolean e(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if ((this.g.f() && this.g.b()) || (!this.g.f() && this.g.e())) {
            float a2 = this.d.a() + (((motionEvent.getY() - motionEvent2.getY()) * this.d.b()) / (getHeight() * 0.8f));
            this.d.f(a2);
            this.d.g(R.drawable.obfuscated_res_0x7f081437);
            this.d.h((int) ((a2 / this.d.b()) * 100.0f));
            this.d.e();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.nt4
    public boolean onDown(MotionEvent motionEvent) {
        SwanVideoView swanVideoView = this.f;
        if (swanVideoView == null) {
            return true;
        }
        this.g.i(swanVideoView.w());
        this.g.j(this.f.getTipState());
        if (this.g.c()) {
            this.e.e(this.f.getCurrentPosition(), this.f.getDuration());
            this.c.e();
            this.d.d();
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.c(getWidth());
    }
}
