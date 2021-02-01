package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.mobads.MobRewardVideoImpl;
/* loaded from: classes5.dex */
public class MobRewardVideoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    MobRewardVideoImpl f3472a = new MobRewardVideoImpl(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3472a.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f3472a.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f3472a.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f3472a.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f3472a.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f3472a.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3472a.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3472a.onAttachedToWindow();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3472a.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f3472a.finish();
    }
}
