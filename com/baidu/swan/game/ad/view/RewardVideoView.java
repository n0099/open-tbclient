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
import com.baidu.searchbox.player.event.VideoReceiver;
import d.a.m0.f.i.j.b;
import d.a.m0.f.i.m.b.c;
/* loaded from: classes3.dex */
public class RewardVideoView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f11701e;

    /* renamed from: f  reason: collision with root package name */
    public Context f11702f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11703g;

    /* renamed from: h  reason: collision with root package name */
    public VolumeBroadcastReceiver f11704h;

    /* renamed from: i  reason: collision with root package name */
    public a f11705i;

    /* loaded from: classes3.dex */
    public class VolumeBroadcastReceiver extends BroadcastReceiver {
        public VolumeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                RewardVideoView.this.f11705i.onVolumeChanged(((AudioManager) context.getSystemService("audio")).getStreamVolume(3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void onVolumeChanged(int i2);
    }

    public RewardVideoView(Context context) {
        this(context, null);
    }

    @NonNull
    public final b b() {
        b bVar = new b();
        bVar.f50484f = true;
        bVar.f50480b = this.f11703g;
        bVar.o = false;
        bVar.z = false;
        bVar.v = false;
        return bVar;
    }

    public final void c() {
        c c2 = d.a.m0.f.i.m.a.c();
        c2.e(getContext(), b());
        this.f11701e = c2;
        AudioManager audioManager = (AudioManager) this.f11702f.getSystemService("audio");
        this.f11703g = audioManager.getStreamVolume(3) <= (Build.VERSION.SDK_INT >= 28 ? audioManager.getStreamMinVolume(3) : 0);
        FrameLayout frameLayout = new FrameLayout(this.f11702f);
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        c cVar = this.f11701e;
        if (cVar != null) {
            cVar.a(frameLayout);
        }
    }

    public boolean d() {
        return this.f11703g;
    }

    public void e(boolean z) {
        c cVar = this.f11701e;
        if (cVar != null) {
            this.f11703g = z;
            cVar.mute(z);
        }
    }

    public void f(String str) {
        b b2 = b();
        b2.p = str;
        this.f11701e.h(b2);
        this.f11701e.d(false);
    }

    public c getPlayer() {
        return this.f11701e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Context context;
        super.onDetachedFromWindow();
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.f11704h;
        if (volumeBroadcastReceiver == null || (context = this.f11702f) == null) {
            return;
        }
        context.unregisterReceiver(volumeBroadcastReceiver);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setVolumeChangeListener(a aVar) {
        this.f11705i = aVar;
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11702f = context;
        c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        VolumeBroadcastReceiver volumeBroadcastReceiver = new VolumeBroadcastReceiver();
        this.f11704h = volumeBroadcastReceiver;
        this.f11702f.registerReceiver(volumeBroadcastReceiver, intentFilter);
    }
}
