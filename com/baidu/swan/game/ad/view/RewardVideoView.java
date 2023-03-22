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
import com.baidu.tieba.kv3;
import com.baidu.tieba.lw3;
import com.baidu.tieba.ow3;
/* loaded from: classes3.dex */
public class RewardVideoView extends RelativeLayout {
    public ow3 a;
    public Context b;
    public boolean c;
    public VolumeBroadcastReceiver d;
    public a e;

    /* loaded from: classes3.dex */
    public interface a {
        void onVolumeChanged(int i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* loaded from: classes3.dex */
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
        ow3 ow3Var = this.a;
        if (ow3Var != null) {
            this.c = z;
            ow3Var.mute(z);
        }
    }

    public void f(String str) {
        kv3 b = b();
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
    public final kv3 b() {
        kv3 kv3Var = new kv3();
        kv3Var.f = true;
        kv3Var.b = this.c;
        kv3Var.o = false;
        kv3Var.z = false;
        kv3Var.v = false;
        return kv3Var;
    }

    public boolean d() {
        return this.c;
    }

    public ow3 getPlayer() {
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
        ow3 c = lw3.c();
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
        ow3 ow3Var = this.a;
        if (ow3Var != null) {
            ow3Var.a(frameLayout);
        }
    }
}
