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
import d.a.l0.f.i.j.b;
import d.a.l0.f.i.m.b.c;
/* loaded from: classes3.dex */
public class RewardVideoView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f11619e;

    /* renamed from: f  reason: collision with root package name */
    public Context f11620f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11621g;

    /* renamed from: h  reason: collision with root package name */
    public VolumeBroadcastReceiver f11622h;

    /* renamed from: i  reason: collision with root package name */
    public a f11623i;

    /* loaded from: classes3.dex */
    public class VolumeBroadcastReceiver extends BroadcastReceiver {
        public VolumeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                RewardVideoView.this.f11623i.onVolumeChanged(((AudioManager) context.getSystemService("audio")).getStreamVolume(3));
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
        bVar.f50376f = true;
        bVar.f50372b = this.f11621g;
        bVar.o = false;
        bVar.z = false;
        bVar.v = false;
        return bVar;
    }

    public final void c() {
        c c2 = d.a.l0.f.i.m.a.c();
        c2.e(getContext(), b());
        this.f11619e = c2;
        AudioManager audioManager = (AudioManager) this.f11620f.getSystemService("audio");
        this.f11621g = audioManager.getStreamVolume(3) <= (Build.VERSION.SDK_INT >= 28 ? audioManager.getStreamMinVolume(3) : 0);
        FrameLayout frameLayout = new FrameLayout(this.f11620f);
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        c cVar = this.f11619e;
        if (cVar != null) {
            cVar.a(frameLayout);
        }
    }

    public boolean d() {
        return this.f11621g;
    }

    public void e(boolean z) {
        c cVar = this.f11619e;
        if (cVar != null) {
            this.f11621g = z;
            cVar.mute(z);
        }
    }

    public void f(String str) {
        b b2 = b();
        b2.p = str;
        this.f11619e.h(b2);
        this.f11619e.d(false);
    }

    public c getPlayer() {
        return this.f11619e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Context context;
        super.onDetachedFromWindow();
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.f11622h;
        if (volumeBroadcastReceiver == null || (context = this.f11620f) == null) {
            return;
        }
        context.unregisterReceiver(volumeBroadcastReceiver);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setVolumeChangeListener(a aVar) {
        this.f11623i = aVar;
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11620f = context;
        c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        VolumeBroadcastReceiver volumeBroadcastReceiver = new VolumeBroadcastReceiver();
        this.f11622h = volumeBroadcastReceiver;
        this.f11620f.registerReceiver(volumeBroadcastReceiver, intentFilter);
    }
}
