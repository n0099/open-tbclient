package com.baidu.swan.game.ad.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.py3;
import com.baidu.tieba.qz3;
import com.baidu.tieba.tz3;
/* loaded from: classes4.dex */
public class RewardVideoView extends RelativeLayout {
    public tz3 a;
    public Context b;
    public boolean c;
    public VolumeBroadcastReceiver d;
    public a e;

    /* loaded from: classes4.dex */
    public interface a {
        void onVolumeChanged(int i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* loaded from: classes4.dex */
    public class VolumeBroadcastReceiver extends BroadcastReceiver {
        public VolumeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                RewardVideoView.this.e.onVolumeChanged(((AudioManager) context.getSystemService("audio")).getStreamVolume(3));
            }
        }
    }

    public RewardVideoView(Context context) {
        this(context, null);
    }

    public void e(boolean z) {
        tz3 tz3Var = this.a;
        if (tz3Var != null) {
            this.c = z;
            tz3Var.mute(z);
        }
    }

    public void f(String str) {
        py3 b = b();
        b.p = str;
        this.a.h(b);
        this.a.d(false);
    }

    public void setVolumeChangeListener(a aVar) {
        this.e = aVar;
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        VolumeBroadcastReceiver volumeBroadcastReceiver = new VolumeBroadcastReceiver();
        this.d = volumeBroadcastReceiver;
        this.b.registerReceiver(volumeBroadcastReceiver, intentFilter);
    }

    @NonNull
    public final py3 b() {
        py3 py3Var = new py3();
        py3Var.f = true;
        py3Var.b = this.c;
        py3Var.o = false;
        py3Var.z = false;
        py3Var.v = false;
        return py3Var;
    }

    public boolean d() {
        return this.c;
    }

    public tz3 getPlayer() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Context context;
        super.onDetachedFromWindow();
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.d;
        if (volumeBroadcastReceiver != null && (context = this.b) != null) {
            context.unregisterReceiver(volumeBroadcastReceiver);
        }
    }

    public final void c() {
        int i;
        tz3 c = qz3.c();
        c.e(getContext(), b());
        this.a = c;
        AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            i = audioManager.getStreamMinVolume(3);
        } else {
            i = 0;
        }
        if (streamVolume <= i) {
            z = true;
        }
        this.c = z;
        FrameLayout frameLayout = new FrameLayout(this.b);
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        tz3 tz3Var = this.a;
        if (tz3Var != null) {
            tz3Var.a(frameLayout);
        }
    }
}
