package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.mobads.MobRewardVideoImpl;
/* loaded from: classes2.dex */
public class MobRewardVideoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public MobRewardVideoImpl f8505a = new MobRewardVideoImpl(this);

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f8505a.finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8505a.onAttachedToWindow();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f8505a.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8505a.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f8505a.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8505a.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f8505a.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f8505a.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8505a.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f8505a.onWindowFocusChanged(z);
    }
}
