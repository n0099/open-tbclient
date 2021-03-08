package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.mobads.MobRewardVideoImpl;
/* loaded from: classes4.dex */
public class MobRewardVideoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    MobRewardVideoImpl f2471a = new MobRewardVideoImpl(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2471a.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f2471a.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2471a.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f2471a.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f2471a.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f2471a.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2471a.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2471a.onAttachedToWindow();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2471a.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f2471a.finish();
    }
}
